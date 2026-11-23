package de.evoal.optimisation.api.run;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.literature.LiteratureContributor;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dynamic.ClassMapping;
import de.evoal.languages.model.dynamic.DynamicFactory;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.core.CorePackage;
import de.evoal.models.v202704.optimisation.model.ModelFactory;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.models.v202704.optimisation.model.Problem;
import de.evoal.optimisation.main.constraints.ConstraintCompiler;

public class RunLiteratureTest {
    /**
     * The DL types of the configuration and a declaration, with their literature.
     */
    private static final String DL = """
            module test {
                type Literature {
                    keys : array string;
                }

                @Literature { keys := ["algorithm2000paper"]; }
                type algorithm {}

                @Literature { keys := ["operator2001paper"]; }
                type operator {}

                @Literature { keys := ["base2002paper"]; }
                abstract type writer {}

                type 'my-writer' extends writer {}

                @Literature { keys := ["block2003paper"]; }
                def void 'building-block'(array data features);

                def void constraint(expression comparison, string group);

                @Literature { keys := ["measure2004paper"]; }
                abstract type 'constraint-measure' {}

                type 'exact-measure' extends 'constraint-measure' {}
            }
            """;

    private final ConstraintCompiler compiler = Mockito.mock(ConstraintCompiler.class);

    private DefinitionModule module;

    private final RunLiterature literature = new RunLiterature();

    @TempDir
    private Path outputFolder;

    private static void inject(final Object target, final String name, final Object value) throws Exception {
        final Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    @BeforeEach
    public void setUp() throws Exception {
        final XtextResourceSet resourceSet = new DefinitionLanguageStandaloneSetup()
                .createInjectorAndDoEMFRegistration()
                .getInstance(XtextResourceSet.class);
        final Resource resource = resourceSet.createResource(URI.createURI("test.dl"));
        resource.load(new ByteArrayInputStream(DL.getBytes(StandardCharsets.UTF_8)), Map.of());
        EcoreUtil.resolveAll(resource);
        module = (DefinitionModule) resource.getContents().getFirst();

        // the components read the attributes with their defaults; the test stores them directly
        final AttributeEvaluator evaluator = Mockito.mock(AttributeEvaluator.class);
        Mockito.when(evaluator.readAttribute(Mockito.any(), Mockito.any())).thenCallRealMethod();
        Mockito.when(evaluator.attributeToJava(Mockito.any(), Mockito.anyString(), Mockito.any()))
               .thenAnswer(invocation -> {
                   final EObject configuration = invocation.getArgument(0);
                   final String name = invocation.getArgument(1);
                   return configuration.eGet(configuration.eClass().getEStructuralFeature(name));
               });

        inject(literature, "constraintCompiler", compiler);
        inject(literature, "evaluator", evaluator);
        inject(literature, "contributors", List.of());
    }

    private ClassDefinition type(final String name) {
        return module.getTypes().stream().filter(type -> name.equals(type.getName())).findFirst().orElseThrow();
    }

    /**
     * @return A dynamic class of the DL type, as the dynamic class provider creates it, with
     *   instance attributes ({@code instance} and {@code array instance} in the DL are
     *   attributes of the dynamic class, not references).
     */
    private static EClass dynamicClass(final ClassDefinition definition, final String... instanceAttributes) {
        final EPackage pack = EcoreFactory.eINSTANCE.createEPackage();
        pack.setName("test");
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName(definition.getName());
        eClass.getESuperTypes().add(CorePackage.Literals.CONFIGURATION);
        pack.getEClassifiers().add(eClass);

        for(final String name : instanceAttributes) {
            final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
            attribute.setName(name);
            attribute.setEType(EcorePackage.Literals.EJAVA_OBJECT);
            attribute.setUpperBound(name.endsWith("s") ? -1 : 1);
            eClass.getEStructuralFeatures().add(attribute);
        }

        final EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource(DynamicPackage.eNS_URI);
        final ClassMapping mapping = DynamicFactory.eINSTANCE.createClassMapping();
        mapping.setSource(definition);
        mapping.setTarget(eClass);
        annotation.getContents().add(mapping);
        eClass.getEAnnotations().add(annotation);

        return eClass;
    }

    /**
     * @return A configuration: an algorithm with an operator (single instance attribute) and
     *   writers (array of instances, the second one a duplicate of the first's type).
     */
    @SuppressWarnings("unchecked")
    private OptimisationModule configuration() {
        final EObject operator = EcoreUtil.create(dynamicClass(type("operator")));
        final EClass writerClass = dynamicClass(type("my-writer"));
        final EObject measure = EcoreUtil.create(dynamicClass(type("exact-measure")));
        final EClass algorithmClass = dynamicClass(type("algorithm"), "operator", "writers", "measure");

        final EObject algorithm = EcoreUtil.create(algorithmClass);
        algorithm.eSet(algorithmClass.getEStructuralFeature("operator"), operator);
        algorithm.eSet(algorithmClass.getEStructuralFeature("measure"), measure);
        ((List<Object>) algorithm.eGet(algorithmClass.getEStructuralFeature("writers")))
                .addAll(List.of(EcoreUtil.create(writerClass), EcoreUtil.create(writerClass)));

        final OptimisationModule configuration = ModelFactory.eINSTANCE.createOptimisationModule();
        configuration.setAlgorithm((Configuration) algorithm);

        return configuration;
    }

    @Test
    public void theWalkEntersNestedInstancesAndAddsTheSuperTypesEachKeyOnce() {
        // when
        final List<String> keys = literature.collect(configuration()).keys();

        // then: the EvoAl paper of core.main first, then in the order of the configuration
        Assertions.assertEquals(List.of("berger2024evoal", "algorithm2000paper", "operator2001paper", "base2002paper"),
                                keys);
    }

    @Test
    public void aContributorAddsTheLiteratureOfWhatAConfigurationLoads() throws Exception {
        // given: a contributor that knows the algorithm, e.g. as the user of a model file
        final LiteratureContributor contributor = configuration -> configuration.eClass().getName().equals("algorithm")
                ? List.of(function("building-block"))
                : List.of();
        inject(literature, "contributors", List.of(contributor));

        // when
        final List<String> keys = literature.collect(configuration()).keys();

        // then: right after the algorithm's own literature
        Assertions.assertEquals(List.of("berger2024evoal", "algorithm2000paper", "block2003paper", "operator2001paper", "base2002paper"),
                                keys);
    }

    @Test
    public void theDeclarationsOfTheProblemAddTheirLiterature() {
        // given
        final OptimisationModule configuration = configuration();
        final Problem problem = ModelFactory.eINSTANCE.createProblem();
        configuration.setProblem(problem);

        Mockito.when(compiler.declarations(problem)).thenReturn(List.of(call(function("building-block"))));

        // when
        final List<String> keys = literature.collect(configuration).keys();

        // then
        Assertions.assertEquals("block2003paper", keys.getLast());
    }

    private FunctionDefinition function(final String name) {
        return module.getFunctions().stream().filter(function -> name.equals(function.getName())).findFirst().orElseThrow();
    }

    private static Call call(final FunctionDefinition function) {
        final Call call = ExpressionsFactory.eINSTANCE.createCall();
        call.setFunction(function);
        return call;
    }

    @Test
    public void theConstraintMeasureCountsOnlyForAProblemWithConstraints() {
        // given
        final OptimisationModule unconstrained = configuration();
        final Problem withoutConstraints = ModelFactory.eINSTANCE.createProblem();
        unconstrained.setProblem(withoutConstraints);
        Mockito.when(compiler.declarations(withoutConstraints)).thenReturn(List.of(call(function("building-block"))));

        final OptimisationModule constrained = configuration();
        final Problem withConstraints = ModelFactory.eINSTANCE.createProblem();
        constrained.setProblem(withConstraints);
        Mockito.when(compiler.declarations(withConstraints)).thenReturn(List.of(call(function("constraint"))));

        // when
        final List<String> withoutKeys = literature.collect(unconstrained).keys();
        final List<String> withKeys = literature.collect(constrained).keys();

        // then
        Assertions.assertFalse(withoutKeys.contains("measure2004paper"), withoutKeys.toString());
        Assertions.assertTrue(withKeys.contains("measure2004paper"), withKeys.toString());
    }

    @Test
    public void theFileIsWrittenOncePerConfigurationAndFolder() throws IOException {
        // given
        final OptimisationModule configuration = configuration();
        final Path file = outputFolder.resolve(RunLiterature.FILE_NAME);

        // when
        literature.start(configuration, outputFolder.toFile());
        final String first = Files.readString(file);
        Files.delete(file);
        literature.start(configuration, outputFolder.toFile());

        // then: the first run wrote the EvoAl paper (the test keys have no entries); the
        //   second run of the same configuration did not write the file again
        Assertions.assertTrue(first.startsWith("@inproceedings{berger2024evoal,"), first);
        Assertions.assertFalse(Files.exists(file));
        Assertions.assertEquals(List.of("berger2024evoal", "algorithm2000paper", "operator2001paper", "base2002paper"),
                                literature.keys());
    }

    @Test
    public void withoutAnOutputFolderOnlyTheKeysAreCollected() {
        // when
        literature.start(configuration(), null);

        // then
        Assertions.assertEquals(4, literature.keys().size());
    }
}

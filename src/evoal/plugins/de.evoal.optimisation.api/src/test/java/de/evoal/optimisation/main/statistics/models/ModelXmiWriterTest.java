package de.evoal.optimisation.main.statistics.models;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.models.EcoreModels;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.IndividualRecord;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;

import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.builder.TreeMethod;
import de.evoal.optimisation.api.builder.ValueDrawer;
import de.evoal.optimisation.api.models.EcoreModelTypes;
import de.evoal.optimisation.api.run.CurrentRun;
import de.evoal.optimisation.api.run.RunParameters;

/**
 * 'model-xmi' on the 2048 policy types of the tests as an Ecore metamodel.
 */
public class ModelXmiWriterTest {
    @TempDir
    private Path output;

    private EClass policy;

    private Space searchSpace;

    private EReference feature;

    private ModelBuilder builder;

    private int built;

    private static void inject(final Object target, final String name, final Object value) throws Exception {
        final Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    private static Space spaceWith(final EStructuralFeature... features) {
        final EClass space = EcoreFactory.eINSTANCE.createEClass();
        space.setName("Space");
        space.getEStructuralFeatures().addAll(List.of(features));
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(space);

        return new Space(space);
    }

    private static EReference modelFeature(final String name, final EClass type) {
        final EReference reference = EcoreFactory.eINSTANCE.createEReference();
        reference.setName(name);
        reference.setContainment(true);
        reference.setEType(type);

        return reference;
    }

    @BeforeEach
    public void loadMetamodel() throws Exception {
        final URI base = URI.createURI(getClass().getResource("/de/evoal/optimisation/test/models/ecore/policy.ecore").toURI().toString());
        final EcoreModels models = new EcoreModels(List.of());
        policy = models.classOf(List.of("policy.ecore", "conditions.ecore"), "policy.ecore#//Policy", base, "the test");

        feature = modelFeature("policy", policy);
        searchSpace = spaceWith(feature);

        final FeatureBoundaries boundaries = new FeatureBoundaries();
        final ModelTypes types = new ModelTypes(new EcoreModelTypes(models), new ValueDrawer(boundaries), List.of(policy));
        builder = new ModelBuilder(types, new ValueDrawer(boundaries),
                                   new BuildSettings(new TreeMethod.Grow(6), BuildSettings.NO_SIZE_LIMIT, 0.5),
                                   RandomService.withSeed(5).random("de.evoal.optimisation.test.model-xmi"));
    }

    private ModelXmiWriter writer(final Space space, final EStructuralFeature data, final String candidates) throws Exception {
        final EEnumLiteral literal = EcoreFactory.eINSTANCE.createEEnumLiteral();
        literal.setName(candidates);

        final AttributeHelper attributes = Mockito.mock(AttributeHelper.class);
        Mockito.when(attributes.lookup(Mockito.any(EObject.class), Mockito.eq("feature"))).thenReturn(data);
        Mockito.when(attributes.lookup(Mockito.any(EObject.class), Mockito.eq("candidates"))).thenReturn(literal);

        final ModelXmiWriter writer = new ModelXmiWriter();
        inject(writer, "attributes", attributes);
        inject(writer, "searchSpace", space);
        inject(writer, "currentRun", CurrentRun.of(RunParameters.single(0, output.toFile())));

        return writer;
    }

    private ModelXmiWriter startedWriter(final String candidates) throws Exception {
        final ModelXmiWriter writer = writer(searchSpace, feature, candidates);
        writer.init(EcoreFactory.eINSTANCE.createEObject());
        writer.start();

        return writer;
    }

    private IndividualRecord individual(final int id) {
        final TypedEObject input = searchSpace.newEObject();
        input.eSet(feature, builder.build(policy, built++));

        final IndividualRecord individual = MemoryFactory.eINSTANCE.createIndividualRecord();
        individual.setId(id);
        individual.setInput(input);

        return individual;
    }

    /**
     * @return An iteration with the ranks and the best individual so far.
     */
    private static Iteration iteration(final int number, final IndividualRecord bestSoFar, final List<List<IndividualRecord>> ranks) {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);
        for(int i = 0; i < ranks.size(); i++) {
            final Rank rank = MemoryFactory.eINSTANCE.createRank();
            rank.setNumber(i);
            rank.getMembers().addAll(ranks.get(i));
            iteration.getRanks().add(rank);
        }
        iteration.setBestSoFar(bestSoFar);

        return iteration;
    }

    private List<String> writtenFiles() throws Exception {
        final Path folder = output.resolve("models").resolve("policy");
        try(Stream<Path> files = Files.list(folder)) {
            return files.map(file -> file.getFileName().toString()).sorted().toList();
        }
    }

    private EObject read(final String name) {
        final ResourceSetImpl set = new ResourceSetImpl();
        set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        final EPackage conditions = ((EClass) policy.getEPackage().getEClassifier("Entry")).getEStructuralFeature("condition").getEType().getEPackage();
        set.getPackageRegistry().put(policy.getEPackage().getNsURI(), policy.getEPackage());
        set.getPackageRegistry().put(conditions.getNsURI(), conditions);

        final File file = output.resolve("models").resolve("policy").resolve(name).toFile();
        final Resource resource = set.getResource(URI.createFileURI(file.getAbsolutePath()), true);

        return resource.getContents().getFirst();
    }

    @Test
    public void bestSoFarIsWrittenOnlyWhenItChanges() throws Exception {
        final ModelXmiWriter writer = startedWriter("best-so-far");
        final IndividualRecord first = individual(1);
        final IndividualRecord second = individual(2);

        writer.add(iteration(0, first, List.of(List.of(first))));
        writer.add(iteration(1, first, List.of(List.of(first, second))));
        writer.add(iteration(2, second, List.of(List.of(second))));
        writer.write();

        Assertions.assertEquals(List.of("0-1.xmi", "2-2.xmi"), writtenFiles());
    }

    @Test
    public void allWritesEverySurvivorAndBestPerIterationTheFirstRank() throws Exception {
        final IndividualRecord best = individual(3);
        final IndividualRecord other = individual(4);
        final Iteration iteration = iteration(0, best, List.of(List.of(best), List.of(other)));

        final ModelXmiWriter all = startedWriter("all");
        all.add(iteration);
        Assertions.assertEquals(List.of("0-3.xmi", "0-4.xmi"), writtenFiles());

        final ModelXmiWriter bestPerIteration = startedWriter("best-per-iteration");
        bestPerIteration.add(iteration);
        Assertions.assertEquals(List.of("0-3.xmi"), writtenFiles());
    }

    @Test
    public void aWrittenModelReadsBackAsTheModelOfTheCandidate() throws Exception {
        final ModelXmiWriter writer = startedWriter("all");
        final IndividualRecord individual = individual(7);
        final EObject model = (EObject) individual.getInput().eGet(feature);

        writer.add(iteration(0, individual, List.of(List.of(individual))));

        Assertions.assertTrue(EcoreUtil.equals(model, read("0-7.xmi")));
        Assertions.assertSame(model, individual.getInput().eGet(feature), "the candidate keeps its model");
        Assertions.assertNotNull(model.eContainer(), "the model stays in its candidate");
        Assertions.assertNull(model.eResource(), "the model is not moved into the resource");

        final String text = Files.readString(output.resolve("models/policy/0-7.xmi"));
        Assertions.assertFalse(text.contains("schemaLocation"), text);
        Assertions.assertFalse(text.contains("\r"), "line ends");
        Assertions.assertTrue(text.contains("xmlns:policy=\"http://evoal.de/test/policy\""), text);
    }

    @Test
    public void anotherToolReadsAWrittenModelWithTheMetamodelFilesAlone() throws Exception {
        final ModelXmiWriter writer = startedWriter("all");
        final IndividualRecord individual = individual(8);
        writer.add(iteration(0, individual, List.of(List.of(individual))));

        final ResourceSetImpl set = new ResourceSetImpl();
        set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        for(final String name : List.of("policy.ecore", "conditions.ecore")) {
            final URI uri = URI.createURI(getClass().getResource("/de/evoal/optimisation/test/models/ecore/" + name).toURI().toString());
            final EPackage ePackage = (EPackage) set.getResource(uri, true).getContents().getFirst();
            set.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
        }

        final File file = output.resolve("models/policy/0-8.xmi").toFile();
        final EObject model = set.getResource(URI.createFileURI(file.getAbsolutePath()), true).getContents().getFirst();

        Assertions.assertNotSame(policy, model.eClass());
        Assertions.assertEquals("Policy", model.eClass().getName());
        Assertions.assertEquals(Diagnostic.OK, Diagnostician.INSTANCE.validate(model).getSeverity());
    }

    @Test
    public void theFolderOfAnEarlierRunIsDeleted() throws Exception {
        final Path old = Files.createDirectories(output.resolve("models/policy")).resolve("9-9.xmi");
        Files.writeString(old, "old");

        startedWriter("all");

        Assertions.assertFalse(Files.exists(old));
    }

    @Test
    public void modelsOfDlTypesAreRejected() throws Exception {
        final DefinitionModule module = LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/models/policy.dl");
        final EClass dlPolicy = new DynamicEClassProvider().toEClass(module.getTypes().getFirst());
        final EReference dlFeature = modelFeature("policy", dlPolicy);

        final ModelXmiWriter writer = writer(spaceWith(dlFeature), dlFeature, "all");
        final IllegalArgumentException failure = Assertions.assertThrows(IllegalArgumentException.class,
                                                                         () -> writer.init(EcoreFactory.eINSTANCE.createEObject()));

        Assertions.assertTrue(failure.getMessage().contains("has no metamodel file"), failure.getMessage());
    }

    @Test
    public void tabularDataIsRejected() throws Exception {
        final EAttribute weight = EcoreFactory.eINSTANCE.createEAttribute();
        weight.setName("weight");
        weight.setEType(EcorePackage.eINSTANCE.getEDouble());

        final ModelXmiWriter writer = writer(spaceWith(weight), weight, "all");
        final IllegalArgumentException failure = Assertions.assertThrows(IllegalArgumentException.class,
                                                                         () -> writer.init(EcoreFactory.eINSTANCE.createEObject()));

        Assertions.assertTrue(failure.getMessage().contains("has to be structured search data"), failure.getMessage());
    }
}

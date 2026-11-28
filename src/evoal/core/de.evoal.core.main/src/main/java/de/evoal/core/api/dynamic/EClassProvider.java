package de.evoal.core.api.dynamic;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.apache.commons.math3.util.Pair;

import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.dynamic.DefinitionMapping;
import de.evoal.languages.model.dynamic.DynamicFactory;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.generator.PipelineStep;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.ol.OptimisationGoal;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.models.core.ecore.Space;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.info.BoundaryExtractor;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.info.FeatureScales;
import de.evoal.core.api.ecore.models.EcoreModels;
import de.evoal.core.api.utils.Requirements;

/**
 * Creates the Ecore classes that hold the values of a space at runtime.
 *   A space is a set of data descriptions from the DDL, e.g., the search
 *   space of an optimisation problem or the inputs and outputs of a learning
 *   task. Instances of the created classes (wrapped in {@link Space} and
 *   {@code TypedEObject}) carry the actual values, such as a candidate
 *   solution or a data point.
 * <p>
 * For each space, the provider creates a dynamic package containing a single
 *   class {@code Space}. The class has one optional attribute per data
 *   description:
 * <ul>
 *   <li>The attribute has the name of the data description and an Ecore type
 *     that matches its representation (boolean, integer, real or string).
 *     Structured data ({@code data 'x' of instance T}) becomes a containment
 *     reference to the class of the DL type instead; its value is a model. With an
 *     {@code @EcoreType} annotation, the class comes from an Ecore metamodel instead
 *     (see {@link EcoreModels}).</li>
 *   <li>The attribute is unsettable, so {@code eIsSet} tells whether a value was
 *     set, also for a value equal to the default (0, 0.0, false). An attribute
 *     that no reader set has no value, e.g. a missing value in an ARFF file.</li>
 *   <li>The bounds from the {@code @LowerBoundary}/{@code @UpperBoundary}
 *     constraints of the data description are attached to the attribute
 *     (see {@link FeatureBoundaries}), and its scale (see {@link FeatureScales}).</li>
 *   <li>A {@link DefinitionMapping} links the attribute and the data
 *     description in both directions.</li>
 * </ul>
 * The attributes follow the order in which the data descriptions are
 *   declared or first used. The created classes are cached, so the same
 *   module or problem always gets the same class.
 */
@ApplicationScoped
@Slf4j
public class EClassProvider {
    /**
     * Ecore factory for creating new ecore objects.
     */
    private static final EcoreFactory factory = EcoreFactory.eINSTANCE;

    /**
     * Dynamic factory for creating new dynamic objects.
     */
    private static final DynamicFactory dynFactory = DynamicFactory.eINSTANCE;

    /**
     * Creates the classes of the DL types of structured data; looked up through CDI when it is
     *   needed and was not given.
     */
    @Inject
    private DynamicEClassProvider dynamicClasses;

    /**
     * Loads the classes of structured data with an {@code @EcoreType} annotation; looked up
     *   through CDI when it is needed and was not given.
     */
    @Inject
    private EcoreModels ecoreModels;

    /**
     * Keeping track of already mapped classes.
     */
    private final Map<Object, EClass> eClassCache = new HashMap<>();

    /**
     * Creates a provider that looks up the provider of the DL classes when it needs it.
     */
    public EClassProvider() {
    }

    /**
     * @param dynamicClasses Creates the classes of the DL types of structured data.
     */
    public EClassProvider(final DynamicEClassProvider dynamicClasses) {
        this.dynamicClasses = dynamicClasses;
    }

    /**
     * @param dynamicClasses Creates the classes of the DL types of structured data.
     * @param ecoreModels Loads the classes of structured data with an {@code @EcoreType} annotation.
     */
    public EClassProvider(final DynamicEClassProvider dynamicClasses, final EcoreModels ecoreModels) {
        this.dynamicClasses = dynamicClasses;
        this.ecoreModels = ecoreModels;
    }

    /**
     * Returns the class for all data used by a generator module, i.e., the
     *   data read or written by the steps of all its pipelines, including the
     *   steps of nested pipelines. The attributes follow the order of first use.
     *
     * @param module The generator module.
     * @return The cached or newly created class.
     * @throws IllegalArgumentException if a step type or a data representation
     *   is not supported.
     */
    public EClass eClassFor(final GeneratorModule module) {
        log.info("Creating dynamic eclass for module {}.", module.getName());
        if(eClassCache.containsKey(module)) {
            return eClassCache.get(module);
        }

        // create a set of all used data
        final Set<DataDescription> references =
            module.getPipelines()
                    .stream()
                    .flatMap(p -> p.getSteps().stream())
                    .flatMap(EClassProvider::toUsedDataStream)
                    .map(TypeDefinitionReference::getDefinition)
                    .filter(DataDescription.class::isInstance)
                    .map(DataDescription.class::cast)
                    .collect(Collectors.toCollection(LinkedHashSet::new));

        final EClass result = eClassOf(references);

        eClassCache.put(module, result);

        return result;
    }

    /**
     * Returns the class for all data descriptions declared in a DDL module.
     *   The attributes follow the declaration order.
     *
     * @param module The data description module.
     * @return The cached or newly created class.
     * @throws IllegalArgumentException if a data representation is not supported.
     */
    public EClass eClassFor(final DataDescriptionModule module) {
        log.info("Creating dynamic eclass for module {}.", module.getName());
        if(eClassCache.containsKey(module)) {
            return eClassCache.get(module);
        }

        // create a set of all used data
        final Set<DataDescription> references =
                new LinkedHashSet<>(module.getDescriptions());

        final EClass result = eClassOf(references);

        eClassCache.put(module, result);

        return result;
    }

    /**
     * Returns the classes of the search space and the optimisation space of an
     *   optimisation problem. The search space contains the data of the
     *   problem's {@code search for} list, the optimisation space the data of
     *   its optimisation goals, both in the order of the problem definition.
     *   References that do not point to a data description are ignored.
     *
     * @param problem The optimisation problem.
     * @return The search space class (first) and the optimisation space class
     *   (second), each cached or newly created.
     * @throws IllegalArgumentException if a data representation is not supported.
     */
    public Pair<EClass, EClass> eClassFor(final ProblemInstance problem) {
        log.info("Creating dynamic eclass for problem {}.", problem.getName());
        EClass searchSpace = eClassCache.get(problem.getSearchSpace());
        EClass optimisationSpace = eClassCache.get(problem.getOptimisationSpace());

        if(searchSpace == null) {
            final Set<DataDescription> references =
                    problem.getSearchSpace()
                            .stream()
                            .map(TypeDefinitionReference::getDefinition)
                            .filter(DataDescription.class::isInstance)
                            .map(DataDescription.class::cast)
                            .collect(Collectors.toCollection(LinkedHashSet::new));

            searchSpace = eClassOf(references);
        }

        if(optimisationSpace == null) {
            final Set<DataDescription> references =
                    problem.getOptimisationSpace()
                            .stream()
                            .map(OptimisationGoal::getData)
                            .map(TypeDefinitionReference::getDefinition)
                            .filter(DataDescription.class::isInstance)
                            .map(DataDescription.class::cast)
                            .collect(Collectors.toCollection(LinkedHashSet::new));

            optimisationSpace = eClassOf(references);
        }

        eClassCache.put(problem.getSearchSpace(), searchSpace);
        eClassCache.put(problem.getOptimisationSpace(), optimisationSpace);

        return Pair.create(searchSpace, optimisationSpace);
    }

    /**
     * Returns a class for data that a configuration names but that belongs to no space of the
     *   problem, e.g. the columns of a reference table of a fitness function
     *   ({@code data 'x0'}). Its attributes let the configuration refer to the data and a
     *   reader read it. The class is not cached: the caller passes only data without a
     *   feature, so no data gets two features.
     *
     * @param descriptions The data descriptions, in the order of their first use.
     * @return The newly created class.
     * @throws IllegalArgumentException if a data representation is not supported.
     */
    public EClass eClassForConfigurationData(final Collection<DataDescription> descriptions) {
        log.info("Creating dynamic eclass for the configuration data {}.",
                 descriptions.stream().map(DataDescription::getName).toList());

        return eClassOf(new LinkedHashSet<>(descriptions));
    }

    private static Stream<TypeDefinitionReference> toUsedDataStream(final Step step) {
        if(step instanceof ConcreteStep concrete) {
            return Stream.concat(concrete.getReads().stream(), concrete.getWrites().stream());
        } else if(step instanceof PipelineStep pipeline) {
            return pipeline.getDefinition()
                    .getSteps()
                    .stream()
                    .flatMap(EClassProvider::toUsedDataStream);
        } else {
            throw new IllegalArgumentException("Unsupported step: " + step.eClass().getName());
        }
    }

    /**
     * Returns the class for the data of a machine learning module's task: first
     *   the inputs, then the outputs, each in the order of the task definition,
     *   then the data that its resampling schemes name (e.g. the feature of
     *   {@code 'given-blocks'}), in the order of their occurrence.
     *
     * @param module The machine learning module.
     * @return The cached or newly created class.
     * @throws IllegalArgumentException if a data representation is not supported.
     */
    public EClass eClassFor(final MachineLearningModule module) {
        log.info("Creating dynamic eclass for module {}.", module.getName());
        if(eClassCache.containsKey(module)) {
            return eClassCache.get(module);
        }

        // create a set of all used data
        final Set<DataDescription> references =
                Stream.concat(
                            module.getTask().getInputs().stream(),
                            module.getTask().getOutputs().stream()
                        )
                      .collect(Collectors.toCollection(LinkedHashSet::new));

        EcoreUtil.<Object>getAllContents(module.getTask().getResampling(), true)
                 .forEachRemaining(element -> {
                     if(element instanceof TypeDefinitionReference reference
                             && reference.getDefinition() instanceof DataDescription description) {
                         references.add(description);
                     }
                 });

        final EClass result = eClassOf(references);

        eClassCache.put(module, result);

        return result;
    }

    /**
     * Creates the space class with one attribute per data description. The
     *   attributes follow the iteration order of {@code descriptions}, so callers
     *   pass an ordered collection (declaration order). A stable feature order
     *   keeps runs with the same seed reproducible (#249).
     */
    private EClass eClassOf(final Collection<DataDescription> descriptions) {
        final EPackage pkg = factory.createEPackage();
        pkg.setName("dynamic");
        pkg.setNsPrefix("dyn");
        pkg.setNsURI("http://www.evoal.de/model/dynamic/2024/04");

        final EClass result = factory.createEClass();
        result.setName("Space");

        for(final DataDescription ref : descriptions) {
            log.info("Creating attribute for '{}'.", ref.getName());

            final EStructuralFeature attr = toFeature(ref);
            attr.setName(ref.getName());
            attr.setLowerBound(0);
            attr.setUpperBound(1);
            // a set 0.0 counts as set; only a missing value is unset (#355)
            attr.setUnsettable(true);

            result.getEStructuralFeatures()
                  .add(attr);


            // add mapping to ecore world
            final DefinitionMapping definition = dynFactory.createDefinitionMapping();
            definition.setSource(ref);
            definition.setTarget(attr);

            final EAnnotation annotation = factory.createEAnnotation();
            annotation.setSource(DynamicPackage.eNS_URI);
            annotation.getContents().add(definition);

            attr.getEAnnotations()
                .add(annotation);

            // add mapping to ddl world
            ref.getEAnnotations()
               .add(EcoreUtil.copy(annotation));
        }

        final Diagnostic diagnostics = Diagnostician.INSTANCE.validate(result);
        for(final Diagnostic diag : diagnostics.getChildren()) {
            log.info(severityToString(diag.getSeverity()) + " " + diag.getMessage()            );
        }

        pkg.getEClassifiers().add(result);

        return result;
    }

    private String severityToString(int severity) {
        return switch (severity) {
            case Diagnostic.OK -> "OK  ";
            case Diagnostic.INFO -> "INFO";
            case Diagnostic.WARNING -> "WARN";
            case Diagnostic.ERROR -> "ERR ";
            case Diagnostic.CANCEL -> "CANC";
            default -> "UNKN";
        };
    }

    /**
     * Creates the unnamed feature of a data description: an attribute for base data, with the
     *   boundaries of its {@code @LowerBoundary}/{@code @UpperBoundary} constraints and its scale;
     *   a containment reference to the class of the DL type for structured data
     *   ({@code data 'x' of instance T}), whose value is a model; with an {@code @EcoreType}
     *   annotation, the class is the one it names in an Ecore metamodel.
     */
    private EStructuralFeature toFeature(final DataDescription description) {
        if(description instanceof StructuredDataDescription structured) {
            final EReference reference = factory.createEReference();
            reference.setContainment(true);
            reference.setEType(EcoreModels.hasEcoreType(structured)
                               ? ecoreModels().classOf(structured)
                               : dynamicClasses().toEClass(structured.getType()));

            return reference;
        }

        final EAttribute attribute = factory.createEAttribute();
        attribute.setEType(toEType(description));
        FeatureBoundaries.annotate(attribute, BoundaryExtractor.extract(description));
        final ScaleType scale = ((BaseDataDescription) description).getScale();
        FeatureScales.annotate(attribute, scale == null ? ScaleType.NOMINAL : scale);

        return attribute;
    }

    /**
     * @return The provider of the classes of DL types; looked up if it was not given.
     */
    private DynamicEClassProvider dynamicClasses() {
        if(dynamicClasses == null) {
            dynamicClasses = BeanFactory.create(DynamicEClassProvider.class);
        }

        return dynamicClasses;
    }

    /**
     * @return The loader of the classes of Ecore metamodels; looked up if it was not given.
     */
    private EcoreModels ecoreModels() {
        if(ecoreModels == null) {
            ecoreModels = BeanFactory.create(EcoreModels.class);
        }

        return ecoreModels;
    }

    private EClassifier toEType(final DataDescription descr) {
        if(descr instanceof BaseDataDescription baseDescr) {
            if(RepresentationType.BOOLEAN.equals(baseDescr.getRepresentation())) {
                return EcorePackage.eINSTANCE.getEBoolean();
            } else if(RepresentationType.INTEGER.equals(baseDescr.getRepresentation())) {
                return EcorePackage.eINSTANCE.getEInt();
            } else if(RepresentationType.REAL.equals(baseDescr.getRepresentation())) {
                return EcorePackage.eINSTANCE.getEDouble();
            } else if(RepresentationType.STRING.equals(baseDescr.getRepresentation())) {
                return EcorePackage.eINSTANCE.getEString();
            } else {
                throw new IllegalArgumentException(baseDescr.getRepresentation().getName());
            }
        } else {
            throw new IllegalArgumentException(descr.getClass().getName());
        }
    }

    /**
     * Returns the common class of two spaces.
     *
     * @param source The first space.
     * @param target The second space.
     * @return The class of {@code source}.
     * @throws IllegalArgumentException if the spaces have different classes.
     */
    public EClass eClassFor(final Space source, final Space target) {
        final LinkedHashSet<DataDescription> references = new LinkedHashSet<>();

        Requirements.requireEqual(source.getEClass(), target.getEClass());

        return source.getEClass();
    }
}

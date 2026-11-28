package de.evoal.optimisation.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.models.EcoreModels;
import de.evoal.models.core.ecore.Space;

import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelTypeSource;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.builder.TreeMethod;
import de.evoal.optimisation.api.builder.ValueDrawer;

/**
 * The front-end of the model candidates of the search space: the structured data of the
 *   search space ({@code data 'x' of instance T}, a containment of the space class), the tables
 *   of their classes and the builder settings of a configured {@code 'tree-method'}. A class is
 *   the class of a DL type or, for data with {@code @EcoreType}, a class of an Ecore metamodel
 *   ({@link EcoreModelTypes}); the tables ask the front-end of each class. The
 *   components that create or change models ({@code 'random-population'}, the operators of a
 *   {@code 'model-chromosome'}, {@code 'maximum-size'} and {@code 'maximum-depth'}) share it.
 */
@Dependent
public class ModelCandidates {
    @Inject
    private FeatureBoundaries boundaries;

    @Inject
    private DynamicEClassProvider dynamicClasses;

    @Inject
    private EcoreModels ecoreModels;

    @Inject @Named("search-space")
    private Space searchSpace;

    /**
     * The tables of the models, created when first needed.
     */
    private ModelTypes types;

    /**
     * Creates the bean.
     */
    public ModelCandidates() {
    }

    /**
     * Creates the front-end without CDI, e.g., for tests.
     *
     * @param searchSpace The search space.
     * @param boundaries The boundaries of the attributes.
     * @param dynamicClasses The classes of the DL types.
     */
    public ModelCandidates(final Space searchSpace, final FeatureBoundaries boundaries, final DynamicEClassProvider dynamicClasses) {
        this(searchSpace, boundaries, dynamicClasses, new EcoreModels(List.of()));
    }

    /**
     * Creates the front-end without CDI, e.g., for tests.
     *
     * @param searchSpace The search space.
     * @param boundaries The boundaries of the attributes.
     * @param dynamicClasses The classes of the DL types.
     * @param ecoreModels The classes of the Ecore metamodels.
     */
    public ModelCandidates(final Space searchSpace, final FeatureBoundaries boundaries,
                           final DynamicEClassProvider dynamicClasses, final EcoreModels ecoreModels) {
        this.searchSpace = searchSpace;
        this.boundaries = boundaries;
        this.dynamicClasses = dynamicClasses;
        this.ecoreModels = ecoreModels;
    }

    /**
     * @return The features of the search space that hold models, in the order of the space.
     */
    public List<EReference> modelFeatures() {
        final List<EReference> models = new ArrayList<>();
        for(final EStructuralFeature feature : searchSpace) {
            if(feature instanceof EReference model) {
                models.add(model);
            }
        }

        return models;
    }

    /**
     * @return The search space.
     */
    public Space searchSpace() {
        return searchSpace;
    }

    /**
     * @return The tables of the classes of all models of the search space.
     */
    public ModelTypes types() {
        if(types == null) {
            final List<EClass> roots = modelFeatures().stream()
                                                      .map(EReference::getEReferenceType)
                                                      .toList();
            types = new ModelTypes(new ClassModelTypes(new DlModelTypes(dynamicClasses), new EcoreModelTypes(ecoreModels)), values(), roots);
        }

        return types;
    }

    /**
     * @return Draws the values of the attributes within their boundaries.
     */
    public ValueDrawer values() {
        return new ValueDrawer(boundaries);
    }

    /**
     * @param method The configuration of a {@code 'tree-method'}.
     * @return The settings of the builder: the method, {@code 'maximum-size'} and
     *   {@code 'optional-probability'}.
     */
    public static BuildSettings settingsOf(final EObject method) {
        final Integer maximumSize = (Integer) valueIfSet(method, "maximum-size");
        final Double optionalProbability = (Double) valueIfSet(method, "optional-probability");
        final long sizeLimit = maximumSize == null ? BuildSettings.NO_SIZE_LIMIT : maximumSize;

        return new BuildSettings(treeMethodOf(method), sizeLimit, optionalProbability);
    }

    /**
     * @return The problems of the settings for the models whose roots have the given types: a
     *   missing optional probability, a depth or size limit below what a root needs.
     */
    public static List<String> problemsOfSettings(final BuildSettings settings, final ModelTypes types,
                                                  final List<EClass> roots) {
        final List<String> problems = new ArrayList<>();
        if(settings.optionalProbability() == null && types.hasOptionalFeatures()) {
            problems.add("the models have optional attributes, so the 'method' needs an 'optional-probability'");
        }

        final int smallestDepthLimit = settings.method().smallestDepthLimit();
        for(final EClass root : roots) {
            final int depth = types.minimumDepthOfType(root);
            final long size = types.minimumSizeOfType(root);

            final boolean isTooShallow = depth != ModelTypes.UNBOUNDED && depth > smallestDepthLimit;
            if(isTooShallow) {
                problems.add("a model of " + root.getName() + " needs a depth of at least " + depth
                             + ", but the 'method' allows " + smallestDepthLimit);
            }

            final boolean isTooSmall = depth != ModelTypes.UNBOUNDED && size > settings.maximumSize();
            if(isTooSmall) {
                problems.add("a model of " + root.getName() + " needs at least " + size
                             + " objects, but 'maximum-size' is " + settings.maximumSize());
            }
        }

        return problems;
    }

    /**
     * @return The value of the attribute of the configuration; empty if the attribute is optional
     *   and not set.
     */
    public static Optional<Object> optionalValue(final EObject configuration, final String name) {
        return Optional.ofNullable(valueIfSet(configuration, name));
    }

    private static TreeMethod treeMethodOf(final EObject method) {
        final String type = DynamicEClassProvider.dlTypeOf(method);
        final int maximumDepth = requiredInteger(method, "maximum-depth");

        return switch(type) {
            case "de.evoal.optimisation.core.grow" -> new TreeMethod.Grow(maximumDepth);
            case "de.evoal.optimisation.core.full" -> new TreeMethod.Full(maximumDepth);
            case "de.evoal.optimisation.core.ramped-half-and-half" -> {
                final int minimumDepth = requiredInteger(method, "minimum-depth");
                yield new TreeMethod.RampedHalfAndHalf(minimumDepth, maximumDepth);
            }
            default -> throw new IllegalArgumentException("Unknown tree method '" + type + "'.");
        };
    }

    private static int requiredInteger(final EObject configuration, final String name) {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(name);

        return (Integer) configuration.eGet(feature);
    }

    private static Object valueIfSet(final EObject configuration, final String name) {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(name);
        if(feature == null || !configuration.eIsSet(feature)) {
            return null;
        }

        return configuration.eGet(feature);
    }

    /**
     * Asks the front-end of each class: the DL front-end for a class of a DL type, the Ecore
     *   front-end for every other class.
     *
     * @param dl The front-end of the DL types.
     * @param ecore The front-end of the Ecore metamodels.
     */
    private record ClassModelTypes(ModelTypeSource dl, ModelTypeSource ecore) implements ModelTypeSource {
        @Override
        public List<EClass> concreteSubtypesOf(final EClass type) {
            return sourceOf(type).concreteSubtypesOf(type);
        }

        @Override
        public boolean isOptional(final EStructuralFeature feature) {
            return sourceOf(feature.getEContainingClass()).isOptional(feature);
        }

        private ModelTypeSource sourceOf(final EClass eClass) {
            return DynamicEClassProvider.toClassDefinition(eClass).isPresent() ? dl : ecore;
        }
    }

    /**
     * The DL types answer which subtypes a type has and which attributes are optional.
     *
     * @param provider The provider of the classes of the DL types.
     */
    private record DlModelTypes(DynamicEClassProvider provider) implements ModelTypeSource {
        @Override
        public List<EClass> concreteSubtypesOf(final EClass type) {
            return provider.concreteSubclassesOf(type);
        }

        @Override
        public boolean isOptional(final EStructuralFeature feature) {
            return DynamicEClassProvider.isOptional(feature);
        }
    }
}

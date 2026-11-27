package de.evoal.optimisation.main.initial;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.ModelTypeSource;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.builder.TreeMethod;
import de.evoal.optimisation.api.builder.ValueDrawer;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;

/**
 * The random population ({@code 'random-population'}): every feature of the search space gets a
 *   random value (see {@link ValueDrawer}), structured data a random model of its DL type
 *   (see {@link ModelBuilder}) built with the {@code method}. The models are checked when the
 *   stream of candidates is created; a model that cannot be built is reported with all its
 *   problems.
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.core.random-population")
public class RandomInitialCandidates implements InitialCandidatesProvider {
    /**
     * The name of the random stream of the population.
     */
    private static final String STREAM = "de.evoal.optimisation.core.random-population";

    @Inject
    private FeatureBoundaries boundaries;

    /**
     * Provides the DL types of the models; only used for search spaces with structured data.
     */
    @Inject
    private DynamicEClassProvider dynamicClasses;

    /**
     * The settings of the builder of models; {@code null} if the configuration has no
     *   {@code method}.
     */
    private BuildSettings settings;

    @Inject
    private RandomService randomService;

    @Inject @Named("search-space")
    private Space searchSpace;

    @Override
    public Stream<TypedEObject> create() {
        final AtomicInteger counter = new AtomicInteger();
        final RandomGenerator randomness = randomService.random(STREAM);
        final ValueDrawer values = new ValueDrawer(boundaries);
        final ModelBuilder models = modelBuilder(values, randomness).orElse(null);

        return Stream.generate(() -> {
            final int index = counter.getAndIncrement();
            log.info("Creating random initial candidate #{}.", index);

            final TypedEObject object = searchSpace.newEObject();
            for(final EStructuralFeature feature : searchSpace) {
                final Object value = valueOf(feature, index, values, models, randomness);
                object.eSet(feature, value);
            }

            return object;
        });
    }

    @Override
    public InitialCandidatesProvider init(final EObject configuration) {
        final EObject method = (EObject) valueIfSet(configuration, "method");
        settings = method == null ? null : toSettings(method);

        return this;
    }

    /**
     * @return The value of the required integer attribute of the configuration.
     */
    private static int valueOf(final EObject configuration, final String name) {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(name);

        return (Integer) configuration.eGet(feature);
    }

    /**
     * @return The value of the attribute of the configuration; {@code null} if the attribute
     *   is optional and not set.
     */
    private static Object valueIfSet(final EObject configuration, final String name) {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(name);
        if(feature == null || !configuration.eIsSet(feature)) {
            return null;
        }

        return configuration.eGet(feature);
    }

    /**
     * Checks the search space and, if it contains structured data, creates the builder.
     *
     * @throws IllegalArgumentException with all problems if a feature cannot get random values.
     */
    private Optional<ModelBuilder> modelBuilder(final ValueDrawer values, final RandomGenerator randomness) {
        final List<String> problems = new ArrayList<>();
        final List<EClass> roots = new ArrayList<>();

        for(final EStructuralFeature feature : searchSpace) {
            if(feature instanceof EReference model) {
                roots.add(model.getEReferenceType());
            } else {
                values.problemOf((EAttribute) feature)
                      .ifPresent(problems::add);
            }
        }

        if(roots.isEmpty()) {
            requireNoProblems(problems);

            return Optional.empty();
        }

        if(settings == null) {
            problems.add("the search space contains structured data, so 'random-population' needs a 'method'");
            requireNoProblems(problems);
        }

        final ModelTypes types = new ModelTypes(new DlModelTypes(dynamicClasses), values, roots);
        problems.addAll(types.problems());
        problems.addAll(problemsOfSettings(types, roots));
        requireNoProblems(problems);

        return Optional.of(new ModelBuilder(types, values, settings, randomness));
    }

    /**
     * @return The problems of the settings for the models: a missing optional probability, a
     *   depth or size limit below what the roots need.
     */
    private List<String> problemsOfSettings(final ModelTypes types, final List<EClass> roots) {
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

    private static void requireNoProblems(final List<String> problems) {
        if(problems.isEmpty()) {
            return;
        }

        final String message = "'random-population' cannot create candidates: " + String.join("; ", problems) + ".";
        log.error(message);

        throw new IllegalArgumentException(message);
    }

    /**
     * @return The settings of the builder from the configuration of the method.
     */
    private BuildSettings toSettings(final EObject method) {
        final Integer maximumSize = (Integer) valueIfSet(method, "maximum-size");
        final Double optionalProbability = (Double) valueIfSet(method, "optional-probability");
        final long sizeLimit = maximumSize == null ? BuildSettings.NO_SIZE_LIMIT : maximumSize;
        final TreeMethod treeMethod = toTreeMethod(method);

        return new BuildSettings(treeMethod, sizeLimit, optionalProbability);
    }

    private TreeMethod toTreeMethod(final EObject method) {
        final String type = DynamicEClassProvider.dlTypeOf(method);
        final int maximumDepth = valueOf(method, "maximum-depth");

        return switch(type) {
            case "de.evoal.optimisation.core.grow" -> new TreeMethod.Grow(maximumDepth);
            case "de.evoal.optimisation.core.full" -> new TreeMethod.Full(maximumDepth);
            case "de.evoal.optimisation.core.ramped-half-and-half" -> {
                final int minimumDepth = valueOf(method, "minimum-depth");
                yield new TreeMethod.RampedHalfAndHalf(minimumDepth, maximumDepth);
            }
            default -> throw new IllegalArgumentException("Unknown tree method '" + type + "'.");
        };
    }

    /**
     * @return The random value of the feature: a model for structured data, else a value of the
     *   attribute.
     *
     * @param models The builder of the models; {@code null} if the search space has no
     *   structured data.
     */
    private static Object valueOf(final EStructuralFeature feature,
                                  final int index,
                                  final ValueDrawer values,
                                  final ModelBuilder models,
                                  final RandomGenerator randomness) {
        if(feature instanceof EReference model) {
            final EClass rootType = model.getEReferenceType();

            return models.build(rootType, index);
        }

        return values.draw((EAttribute) feature, randomness);
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

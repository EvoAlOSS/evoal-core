package de.evoal.optimisation.main.fitness;

import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.function.BiConsumer;
import java.util.random.RandomGenerator;

/**
 * Optimisation function that assigns random values within their boundaries to the features
 *   of the optimisation space, e.g., for testing algorithms or as a baseline.
 * <p>
 * The values are drawn from the task stream of the evaluation
 *   ({@link RandomService#taskRandom(String)}), so they depend only on the seed, the run and
 *   the index of the evaluation, not on the evaluations before it or on the thread that
 *   computes it. The function keeps no generator and can be evaluated in parallel.
 */
@Dependent
@Named("de.evoal.optimisation.core.random-fitness")
public class RandomFitness extends OptimisationFunctionImpl {

    @Inject
    private FeatureBoundaries boundaries;

    @Inject
    private RandomService randomService;

    /**
     * The name of the task stream.
     */
    private static final String STREAM = "de.evoal.optimisation.core.random-fitness";

    /**
     * Sets random values for all features of the optimisation space.
     */
    private BiConsumer<TypedEObject, RandomGenerator> randomOptimisationValueProducer;

    @Inject
    @Named("optimisation-space")
    private Space optimisationSpace;

    @Override
    public final TypedEObject evaluate(final TypedEObject candidate) {
        final TypedEObject optimisationValue = optimisationSpace.newEObject();

        randomOptimisationValueProducer.accept(optimisationValue, randomService.taskRandom(STREAM));

        return optimisationValue;
    }

    @Override
    public RandomFitness init(final EObject configuration) {
        checkFeatureTypes();

        randomOptimisationValueProducer = (object, randomness) -> {};

        for(final EStructuralFeature feature : optimisationSpace) {
            randomOptimisationValueProducer = randomOptimisationValueProducer.andThen(producerFor(feature));
        }

        return this;
    }

    /**
     * Creates a producer that sets a random value within the boundaries of the feature.
     */
    private BiConsumer<TypedEObject, RandomGenerator> producerFor(final EStructuralFeature feature) {
        final EClassifier classifier = feature.getEType();

        if(EClassifierHelper.isBoolean(classifier)) {
            return (object, randomness) -> object.eSet(feature, randomness.nextBoolean());
        }

        final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);

        if(EClassifierHelper.isReal(classifier)) {
            final double lower = bounds.lower().doubleValue();
            final double upper = bounds.upper().doubleValue();

            return (object, randomness) -> {
                // interpolation does not overflow, even for the full range of double
                final double ratio = randomness.nextDouble();
                final double value = ratio * upper + (1.0 - ratio) * lower;

                if(EClassifierHelper.isFloat(classifier)) {
                    object.eSet(feature, (float) value);
                } else {
                    object.eSet(feature, value);
                }
            };
        }

        final long lower = bounds.lower().longValue() + (bounds.lowerIncluded() ? 0 : 1);
        final long upper = bounds.upper().longValue() - (bounds.UpperIncluded() ? 0 : 1);
        Requirements.requireTrue(lower <= upper, "Feature '" + feature.getName() + "' has no valid value.");

        return (object, randomness) -> {
            final long value;
            if(upper < Long.MAX_VALUE) {
                value = randomness.nextLong(lower, upper + 1);
            } else if(lower > Long.MIN_VALUE) {
                value = randomness.nextLong(lower - 1, upper) + 1;
            } else {
                value = randomness.nextLong();
            }
            object.eSet(feature, NumericConversions.toType(value, classifier));
        };
    }

    private void checkFeatureTypes() {
        for(final EStructuralFeature feature : optimisationSpace) {
            final EClassifier classifier = feature.getEType();

            Requirements.requireTrue(
                    EClassifierHelper.isNumeric(classifier) ||
                            EClassifierHelper.isBoolean(classifier),
                    "Representation type " + classifier + " not supported");
        }
    }
}

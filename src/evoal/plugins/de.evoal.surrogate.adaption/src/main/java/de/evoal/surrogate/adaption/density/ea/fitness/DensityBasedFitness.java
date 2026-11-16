package de.evoal.surrogate.adaption.density.ea.fitness;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.math.EvoalMath;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.surrogate.adaption.SurrogateLookup;
import de.evoal.surrogate.adaption.density.model.DensityData;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.pson.Parameter;
import jakarta.enterprise.inject.Vetoed;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Adapts the fitness of the decorated (surrogate-based) function by the probability
 *   density of the candidate with respect to the training data of the surrogate. The
 *   density information has to be calculated during training (see the goodness-of-fit
 *   calculators {@code kernel-density-estimation} and {@code gaussian-density-estimation}).
 */
@Slf4j
@Vetoed
public abstract class DensityBasedFitness extends OptimisationFunctionDecorator {
    /**
     * Calculates the probability of a candidate for a single target feature.
     */
    @FunctionalInterface
    private interface ProbabilityCalculator {
        double apply(final TypedEObject candidate, final EStructuralFeature target, final double predicted);
    }

    /**
     * Restores the density data of a feature from the information stored with the model.
     */
    private final Function<Collection<Parameter>, DensityData> modelCreator;

    /**
     * Pre-calculated density data for the surrogate's input features.
     */
    private final Map<EStructuralFeature, DensityData> sourceDensityData = new HashMap<>();

    /**
     * Pre-calculated density data for the surrogate's output features.
     */
    private final Map<EStructuralFeature, DensityData> targetDensityData = new HashMap<>();

    @Inject
    private FeatureBoundaries ranges;

    private double exponent;

    private double rootExponent;

    private ProbabilityCalculator probabilityCalculator;

    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    protected DensityBasedFitness(final Function<Collection<Parameter>, DensityData> modelCreator) {
        this.modelCreator = modelCreator;
    }

    @Override
    public OptimisationFunction init(final EObject config) {
        log.info("Setting up density-based malus calculation.");
        super.init(config);

        final String kind = helper.lookup(config, "kind");
        exponent = helper.lookup(config, "exponent");
        rootExponent = helper.lookup(config, "root-exponent");

        probabilityCalculator = switch(kind) {
            case "both" -> this::bothProbabilityCalculator;
            case "source-based" -> this::sourceBasedProbabilityCalculator;
            case "target-based" -> this::targetBasedProbabilityCalculator;
            default -> throw new IllegalArgumentException("Unknown kind '" + kind + "' of density-based fitness. Use 'both', 'source-based', or 'target-based'.");
        };

        final ModelFunction function = SurrogateLookup.find(decoratedFunction).function();
        final ModelReader reader = SurrogateLookup.findReader(decoratedFunction);

        for(final EStructuralFeature feature : function.getInput()) {
            sourceDensityData.put(feature, modelCreator.apply(requireInformation(reader.getInputFeatureInformation(feature), feature)));
        }

        for(final EStructuralFeature feature : function.getOutput()) {
            targetDensityData.put(feature, modelCreator.apply(requireInformation(reader.getOutputFeatureInformation(feature), feature)));
        }

        return this;
    }

    private static Collection<Parameter> requireInformation(final Collection<Parameter> information, final EStructuralFeature feature) {
        if(information == null || information.isEmpty()) {
            throw new IllegalStateException("The surrogate model contains no density information for '" + feature.getName() + "'. Calculate it during training with a density estimation.");
        }

        return information;
    }

    @Override
    public TypedEObject evaluate(final TypedEObject candidate) {
        final TypedEObject current = decoratedFunction.evaluate(candidate);
        final TypedEObject fitness = optimisationSpace.newEObject();

        for(final EStructuralFeature feature : optimisationSpace) {
            final double predicted = current.eGetAsDouble(feature);

            if(!targetDensityData.containsKey(feature)) {
                // not predicted by the surrogate, so there is nothing to adapt
                fitness.eSet(feature, current.eGet(feature));
                continue;
            }

            final double probability = probabilityCalculator.apply(candidate, feature, predicted);

            fitness.eSet(feature, predicted * EvoalMath.pow(probability, rootExponent) + (1 - probability) / EvoalMath.pow(probability, exponent));
        }

        return fitness;
    }

    /**
     * Combines the source-based and the target-based probability.
     */
    private double bothProbabilityCalculator(final TypedEObject candidate, final EStructuralFeature target, final double predicted) {
        return sourceBasedProbabilityCalculator(candidate, target, predicted) * targetBasedProbabilityCalculator(candidate, target, predicted);
    }

    /**
     * Geometric mean of the (offset) densities of the candidate's input values.
     */
    private double sourceBasedProbabilityCalculator(final TypedEObject candidate, final EStructuralFeature target, final double predicted) {
        double result = 1.0;

        for(final Map.Entry<EStructuralFeature, DensityData> entry : sourceDensityData.entrySet()) {
            final EStructuralFeature feature = entry.getKey();
            final double probability = entry.getValue().probability(candidate.eGetAsDouble(feature));

            result *= EvoalMath.pow(Math.min(1.0, probability + offsetOf(feature)), 1.0 / sourceDensityData.size());
        }

        return result;
    }

    /**
     * The (offset) density of the predicted value.
     */
    private double targetBasedProbabilityCalculator(final TypedEObject candidate, final EStructuralFeature target, final double predicted) {
        final double probability = targetDensityData.get(target).probability(predicted);

        return Math.min(1.0, probability + offsetOf(target));
    }

    /**
     * The offset avoids a probability of zero. It is the inverse of the feature's range,
     *   or zero if the feature has no finite range.
     */
    private double offsetOf(final EStructuralFeature feature) {
        final FeatureBoundaries.Boundaries boundaries = ranges.get(feature);
        if(boundaries == null || boundaries.lower() == null || boundaries.upper() == null) {
            return 0.0;
        }

        final double range = boundaries.upper().doubleValue() - boundaries.lower().doubleValue();

        return Double.isFinite(range) && range > 0.0 ? 1.0 / range : 0.0;
    }
}

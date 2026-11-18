package de.evoal.surrogate.adaption.density.fitness;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.enterprise.inject.Vetoed;
import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.math.EvoalMath;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.adaption.AdaptionStep;
import de.evoal.surrogate.adaption.density.model.DensityData;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.pson.Parameter;

/**
 * Adapts the predicted objectives by the probability density of the candidate with respect
 *   to the training data of the surrogate (DL types {@code 'kernel-density'} and
 *   {@code 'gaussian-density'}): {@code ŷ · p^r + (1 − p) / p^e} with
 *   {@code r = 'root-exponent'} and {@code e = exponent}. The density information has to be
 *   calculated during training (see the goodness-of-fit calculators
 *   {@code kernel-density-estimation} and {@code gaussian-density-estimation}).
 * <p>
 * The probability {@code p} is {@code min(1, density + 1/range)}, computed from the inputs
 *   ({@code source-based}), the prediction ({@code target-based}) or both.
 */
@Vetoed
public abstract class DensityStep extends AdaptionStep {
    /**
     * Calculates the probability of a candidate for a single predicted objective.
     */
    @FunctionalInterface
    private interface ProbabilityCalculator {
        double apply(TypedEObject candidate, String objective, double predicted);
    }

    @Inject
    private AttributeHelper attributes;

    /**
     * Restores the density data of a feature from the information stored with the model.
     */
    private final Function<Collection<Parameter>, DensityData> modelCreator;

    @Inject
    private FeatureBoundaries ranges;

    /**
     * The density data of the surrogate's input features.
     */
    private final Map<EStructuralFeature, DensityData> sourceDensityData = new HashMap<>();

    /**
     * The density data of the surrogate's output features, by the name of the feature.
     */
    private final Map<String, DensityData> targetDensityData = new HashMap<>();

    /**
     * The output features of the surrogate, by name.
     */
    private final Map<String, EStructuralFeature> targetFeatures = new HashMap<>();

    private double exponent;

    private String kind;

    private ProbabilityCalculator probabilityCalculator;

    private double rootExponent;

    /**
     * @param modelCreator Restores the density data of a feature from the information stored
     *   with the model.
     */
    protected DensityStep(final Function<Collection<Parameter>, DensityData> modelCreator) {
        this.modelCreator = modelCreator;
    }

    @Override
    protected double adapt(final TypedEObject candidate, final String objective, final double predicted) {
        final double probability = probabilityCalculator.apply(candidate, objective, predicted);

        return adapt(predicted, probability, rootExponent, exponent);
    }

    /**
     * @param predicted The (possibly already adapted) prediction.
     * @param probability The probability of the candidate.
     * @param rootExponent The exponent of the probability that weights the prediction.
     * @param exponent The exponent of the probability in the penalty term.
     * @return {@code predicted · probability^rootExponent + (1 − probability) / probability^exponent}.
     */
    static double adapt(final double predicted, final double probability, final double rootExponent, final double exponent) {
        final double weightedPrediction = predicted * EvoalMath.pow(probability, rootExponent);
        final double penalty = (1 - probability) / EvoalMath.pow(probability, exponent);

        return weightedPrediction + penalty;
    }

    @Override
    public DensityStep init(final EObject configuration) {
        kind = attributes.lookup(configuration, "kind");
        exponent = attributes.lookup(configuration, "exponent");
        rootExponent = attributes.lookup(configuration, "root-exponent");

        probabilityCalculator = switch(kind) {
            case "both" -> this::bothProbability;
            case "source-based" -> this::sourceBasedProbability;
            case "target-based" -> this::targetBasedProbability;
            default -> throw new IllegalArgumentException("Unknown kind '" + kind + "' of density-based adaption. Use"
                                                          + " 'both', 'source-based', or 'target-based'.");
        };

        return this;
    }

    /**
     * @throws IllegalStateException if the surrogate model contains no density information.
     */
    @Override
    protected Set<String> prepare() {
        final ModelFunctionData surrogate = surrogate();
        final ModelFunction function = surrogate.function();
        final ModelReader reader = surrogate.reader()
                                            .orElseThrow(() -> new IllegalStateException("The surrogate model has no reader for its stored information."));

        for(final EStructuralFeature feature : function.getInput()) {
            final Collection<Parameter> information = requireInformation(reader.getInputFeatureInformation(feature), feature);
            sourceDensityData.put(feature, modelCreator.apply(information));
        }

        for(final EStructuralFeature feature : function.getOutput()) {
            final Collection<Parameter> information = requireInformation(reader.getOutputFeatureInformation(feature), feature);
            targetDensityData.put(feature.getName(), modelCreator.apply(information));
            targetFeatures.put(feature.getName(), feature);
        }

        return function.getOutput()
                       .stream()
                       .map(EStructuralFeature::getName)
                       .collect(Collectors.toSet());
    }

    private static Collection<Parameter> requireInformation(final Collection<Parameter> information, final EStructuralFeature feature) {
        if(information == null || information.isEmpty()) {
            throw new IllegalStateException("The surrogate model contains no density information for '" + feature.getName()
                                            + "'. Calculate it during training with a density estimation.");
        }

        return information;
    }

    /**
     * Combines the source-based and the target-based probability.
     */
    private double bothProbability(final TypedEObject candidate, final String objective, final double predicted) {
        final double sourceBased = sourceBasedProbability(candidate, objective, predicted);
        final double targetBased = targetBasedProbability(candidate, objective, predicted);

        return sourceBased * targetBased;
    }

    /**
     * Geometric mean of the (offset) densities of the candidate's input values.
     */
    private double sourceBasedProbability(final TypedEObject candidate, final String objective, final double predicted) {
        double result = 1.0;

        for(final Map.Entry<EStructuralFeature, DensityData> entry : sourceDensityData.entrySet()) {
            final EStructuralFeature feature = entry.getKey();
            final double inputValue = candidate.eGetAsDouble(feature);
            final double probability = entry.getValue().probability(inputValue);
            final double offsetProbability = Math.min(1.0, probability + offsetOf(feature));

            result *= EvoalMath.pow(offsetProbability, 1.0 / sourceDensityData.size());
        }

        return result;
    }

    /**
     * The (offset) density of the predicted value.
     */
    private double targetBasedProbability(final TypedEObject candidate, final String objective, final double predicted) {
        final double probability = targetDensityData.get(objective).probability(predicted);
        final EStructuralFeature feature = targetFeatures.get(objective);

        return Math.min(1.0, probability + offsetOf(feature));
    }

    /**
     * The offset avoids a probability of zero. It is the inverse of the feature's range, or
     *   zero if the feature has no finite range.
     */
    private double offsetOf(final EStructuralFeature feature) {
        final FeatureBoundaries.Boundaries boundaries = ranges.get(feature);

        if(boundaries == null || boundaries.lower() == null || boundaries.upper() == null) {
            return 0.0;
        }

        final double range = boundaries.upper().doubleValue() - boundaries.lower().doubleValue();
        final boolean hasFiniteRange = Double.isFinite(range) && range > 0.0;

        return hasFiniteRange ? 1.0 / range : 0.0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + kind;
    }
}

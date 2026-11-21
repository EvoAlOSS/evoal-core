package de.evoal.optimisation.main.fitness;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessContext;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.Scalarisation;

/**
 * Reduces the fitness to one component {@code weighted-sum}: the sum of the fitness
 *   components multiplied by their weights (DL type {@code 'weighted-sum'}).
 * <p>
 * Every component has exactly one weight; weights are not negative and at least one is
 *   greater than 0, so the sum keeps the canonical direction. With {@code normalise}, the weights are divided by
 *   their sum (the usual definition of the weighted sum); this only changes the scale of
 *   the fitness, not the order of the candidates.
 */
@Dependent
@Named("de.evoal.optimisation.core.weighted-sum")
public class WeightedSumStep implements Scalarisation {
    /**
     * The name of the component the step returns.
     */
    public static final String COMPONENT_NAME = "weighted-sum";

    /**
     * The layout the step returns.
     */
    private static final FitnessLayout OUTPUT_LAYOUT = new FitnessLayout(List.of(FitnessComponent.named(COMPONENT_NAME)));

    @Inject
    private AttributeHelper attributes;

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * Whether the weights are divided by their sum.
     */
    private boolean normalise;

    /**
     * The layout {@link #resolvedWeights} was resolved for; all candidates of a run share it.
     */
    private FitnessLayout resolvedLayout;

    /**
     * The weight of every component of {@link #resolvedLayout}, normalised if configured.
     */
    private double[] resolvedWeights;

    /**
     * The weight of each component, by the name of the component.
     */
    private Map<String, Double> weights = Map.of();

    /**
     * Creates the step without configuration. CDI uses it before {@link #init(EObject)}.
     */
    public WeightedSumStep() {
    }

    /**
     * @param weights The weight of each component, by the name of the component.
     * @param normalise Whether the weights are divided by their sum.
     * @throws IllegalArgumentException if there are no weights, a weight is negative or no
     *   weight is greater than 0.
     */
    public WeightedSumStep(final Map<String, Double> weights, final boolean normalise) {
        this.weights = requireValid(weights);
        this.normalise = normalise;
    }

    @Override
    public Fitness apply(final FitnessContext context, final Fitness current) {
        final double[] componentWeights = weightsOf(current.layout());
        double sum = 0.0;

        for(int index = 0; index < componentWeights.length; ++index) {
            sum += componentWeights[index] * current.value(index);
        }

        return new Fitness(OUTPUT_LAYOUT, new double[] {sum});
    }

    @Override
    public WeightedSumStep init(final EObject configuration) {
        final Map<String, Double> configuredWeights = ComponentValues.read(attributes, evaluator, configuration, "weights");
        this.weights = requireValid(configuredWeights);
        this.normalise = evaluator.attributeToBoolean(configuration, "normalise");

        return this;
    }

    /**
     * @throws IllegalArgumentException if a component has no weight, or a weight belongs to a
     *   component that is not part of the layout.
     */
    @Override
    public FitnessLayout layout(final FitnessLayout input) {
        weightsOf(input);

        return OUTPUT_LAYOUT;
    }

    private double[] weightsOf(final FitnessLayout layout) {
        if(layout != resolvedLayout) {
            final double[] componentWeights = toComponentWeights(layout);

            resolvedWeights = normalise ? normalised(componentWeights) : componentWeights;
            resolvedLayout = layout;
        }

        return resolvedWeights;
    }

    private double[] toComponentWeights(final FitnessLayout layout) {
        final double[] componentWeights = new double[layout.size()];

        requireWeightForEveryComponent(layout);

        for(final Map.Entry<String, Double> weight : weights.entrySet()) {
            final int index = layout.indexOf(weight.getKey());
            componentWeights[index] = weight.getValue();
        }

        return componentWeights;
    }

    private void requireWeightForEveryComponent(final FitnessLayout layout) {
        final List<String> withoutWeight = layout.components()
                                                 .stream()
                                                 .map(FitnessComponent::name)
                                                 .filter(name -> !weights.containsKey(name))
                                                 .toList();

        if(!withoutWeight.isEmpty()) {
            throw new IllegalArgumentException("'weighted-sum' needs a weight for every component, but has none for "
                                               + withoutWeight + ".");
        }
    }

    private static double[] normalised(final double[] componentWeights) {
        final double total = Arrays.stream(componentWeights).sum();

        return Arrays.stream(componentWeights)
                     .map(weight -> weight / total)
                     .toArray();
    }

    private static Map<String, Double> requireValid(final Map<String, Double> weights) {
        if(weights.isEmpty()) {
            throw new IllegalArgumentException("'weighted-sum' needs a weight for every component, but lists none.");
        }

        for(final Map.Entry<String, Double> weight : weights.entrySet()) {
            final double value = weight.getValue();

            // also rejects NaN
            if(!(value >= 0.0)) {
                throw new IllegalArgumentException("The weight of '" + weight.getKey()
                                                   + "' in 'weighted-sum' must not be negative, but is " + value + ".");
            }
        }

        final boolean hasPositiveWeight = weights.values()
                                                 .stream()
                                                 .anyMatch(value -> value > 0.0);

        if(!hasPositiveWeight) {
            throw new IllegalArgumentException("At least one weight in 'weighted-sum' must be greater than 0.");
        }

        return Map.copyOf(weights);
    }

    @Override
    public String toString() {
        return "weighted-sum " + weights + (normalise ? " (normalised)" : "");
    }
}

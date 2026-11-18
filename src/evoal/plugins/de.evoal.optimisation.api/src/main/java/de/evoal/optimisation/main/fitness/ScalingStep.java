package de.evoal.optimisation.main.fitness;

import java.util.Arrays;
import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.fitness.ChangesUnits;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessContext;
import de.evoal.optimisation.api.fitness.FitnessLayout;

/**
 * Divides fitness components by a reference value: {@code f / r} (DL type
 *   {@code 'scaling'}). Components that are not listed stay unchanged. Since the reference
 *   values are greater than 0, the direction of the fitness is kept.
 */
@Dependent
@Named("de.evoal.optimisation.core.scaling")
public class ScalingStep implements ChangesUnits {
    @Inject
    private AttributeHelper attributes;

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The reference value of each scaled component, by the name of the component.
     */
    private Map<String, Double> references = Map.of();

    /**
     * The divisor of every component of {@link #resolvedLayout}, 1 for unlisted ones.
     */
    private double[] divisors;

    /**
     * The layout {@link #divisors} was resolved for; all candidates of a run share it.
     */
    private FitnessLayout resolvedLayout;

    /**
     * Creates the step without configuration. CDI uses it before {@link #init(EObject)}.
     */
    public ScalingStep() {
    }

    /**
     * @param references The reference value of each scaled component, by the name of the
     *   component.
     * @throws IllegalArgumentException if a reference value is not greater than 0.
     */
    public ScalingStep(final Map<String, Double> references) {
        this.references = requirePositive(references);
    }

    @Override
    public Fitness apply(final FitnessContext context, final Fitness current) {
        final FitnessLayout layout = current.layout();
        final double[] componentDivisors = divisorsOf(layout);
        final double[] values = current.values();

        for(int index = 0; index < values.length; ++index) {
            values[index] = values[index] / componentDivisors[index];
        }

        return new Fitness(layout, values);
    }

    @Override
    public ScalingStep init(final EObject configuration) {
        final Map<String, Double> configuredReferences = ComponentValues.read(attributes, evaluator, configuration, "references");
        this.references = requirePositive(configuredReferences);

        return this;
    }

    /**
     * @throws IllegalArgumentException if a scaled component is not part of the layout.
     */
    @Override
    public FitnessLayout layout(final FitnessLayout input) {
        divisorsOf(input);

        return input;
    }

    private double[] divisorsOf(final FitnessLayout layout) {
        if(layout != resolvedLayout) {
            final double[] resolved = new double[layout.size()];
            Arrays.fill(resolved, 1.0);

            for(final Map.Entry<String, Double> reference : references.entrySet()) {
                final int index = layout.indexOf(reference.getKey());
                resolved[index] = reference.getValue();
            }

            divisors = resolved;
            resolvedLayout = layout;
        }

        return divisors;
    }

    private static Map<String, Double> requirePositive(final Map<String, Double> references) {
        for(final Map.Entry<String, Double> reference : references.entrySet()) {
            final double value = reference.getValue();

            // also rejects NaN
            if(!(value > 0.0)) {
                throw new IllegalArgumentException("The reference value of '" + reference.getKey()
                                                   + "' in 'scaling' must be greater than 0, but is " + value + ".");
            }
        }

        return Map.copyOf(references);
    }

    @Override
    public String toString() {
        return "scaling " + references;
    }
}

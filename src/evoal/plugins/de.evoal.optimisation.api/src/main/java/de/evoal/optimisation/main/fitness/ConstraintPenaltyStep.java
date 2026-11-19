package de.evoal.optimisation.main.fitness;

import java.util.Arrays;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.fitness.ChangesUnits;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessContext;

/**
 * Static penalty (DL type {@code 'constraint-penalty'}): adds {@code weight} times the
 *   violation of a constraint group to every component of the canonical fitness. A feasible
 *   candidate keeps its fitness. The penalty mixes the violation into the fitness, so the
 *   fitness is no longer in the units of the objectives.
 */
@Dependent
@Named("de.evoal.optimisation.core.constraint-penalty")
public class ConstraintPenaltyStep implements ChangesUnits {
    /**
     * The constraint group.
     */
    private String group;

    @Inject
    private AttributeHelper helper;

    /**
     * The factor of the violation.
     */
    private double weight;

    /**
     * Creates the step without configuration. CDI uses it before {@link #init(EObject)}.
     */
    public ConstraintPenaltyStep() {
    }

    /**
     * @param group The constraint group.
     * @param weight The factor of the violation.
     * @throws IllegalArgumentException if the weight is not positive.
     */
    public ConstraintPenaltyStep(final String group, final double weight) {
        this.group = group;
        this.weight = requireWeight(weight);
    }

    /**
     * @throws IllegalArgumentException if the problem has no constraint in the group.
     */
    @Override
    public Fitness apply(final FitnessContext context, final Fitness current) {
        final double violation = context.violations().violation(group);

        if(violation == 0.0) {
            return current;
        }

        final double penalty = weight * violation;
        final double[] penalised = Arrays.stream(current.values())
                                         .map(value -> value + penalty)
                                         .toArray();

        return new Fitness(current.layout(), penalised);
    }

    @Override
    public ConstraintPenaltyStep init(final EObject configuration) throws InitializationException {
        group = helper.lookup(configuration, "group");
        final double configuredWeight = helper.<Number>lookup(configuration, "weight")
                                              .doubleValue();

        try {
            weight = requireWeight(configuredWeight);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage());
        }

        return this;
    }

    private static double requireWeight(final double weight) {
        // also rejects NaN
        if(!(weight > 0.0)) {
            throw new IllegalArgumentException("The 'weight' of 'constraint-penalty' must be greater than 0, but is "
                                               + weight + ".");
        }

        return weight;
    }

    @Override
    public String toString() {
        return "constraint-penalty (group '" + group + "', weight " + weight + ")";
    }
}

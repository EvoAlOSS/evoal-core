package de.evoal.optimisation.main.comparator;

import java.util.List;

import lombok.NonNull;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl;

/**
 * The optimisation value of {@code 'feasibility-comparator'} and {@code 'epsilon-comparator'}:
 *   the fitness value of the candidate and the violation of a constraint group. A candidate
 *   whose violation is at most {@code epsilon} counts as feasible.
 * <ol>
 *   <li>Two feasible candidates are compared by their fitness.</li>
 *   <li>A feasible candidate is better than an infeasible one.</li>
 *   <li>Two infeasible candidates with the same violation are compared by their fitness if
 *     {@code fitnessOnEqualViolation} is set (epsilon-level comparison), otherwise they are
 *     equal (feasibility rules).</li>
 *   <li>Of two other infeasible candidates, the one with the smaller violation is better.</li>
 * </ol>
 */
public final class FeasibilityValue extends OptimisationValueWithDistanceImpl {
    /**
     * The violation up to which a candidate counts as feasible.
     */
    private final double epsilon;

    /**
     * The fitness value of the candidate.
     */
    private final FitnessValue fitness;

    /**
     * Whether two infeasible candidates with the same violation are compared by their fitness.
     */
    private final boolean fitnessOnEqualViolation;

    /**
     * The violation of the constraint group.
     */
    private final double violation;

    /**
     * @param fitness The fitness value of the candidate.
     * @param violation The violation of the constraint group.
     * @param epsilon The violation up to which a candidate counts as feasible.
     * @param fitnessOnEqualViolation Whether two infeasible candidates with the same violation
     *   are compared by their fitness.
     */
    public FeasibilityValue(final @NonNull FitnessValue fitness,
                            final double violation,
                            final double epsilon,
                            final boolean fitnessOnEqualViolation) {
        this.fitness = fitness;
        this.violation = violation;
        this.epsilon = epsilon;
        this.fitnessOnEqualViolation = fitnessOnEqualViolation;
    }

    /**
     * @return A positive number if this value is better, a negative number if it is worse, 0
     *   if both are equal.
     * @throws IllegalArgumentException if the other value is no feasibility value.
     */
    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        final FeasibilityValue otherValue = toFeasibilityValue(other);
        final boolean feasible = isFeasible();
        final boolean otherFeasible = otherValue.isFeasible();

        if(feasible && otherFeasible) {
            return fitness.compareTo(otherValue.fitness);
        }

        if(feasible != otherFeasible) {
            return feasible ? 1 : -1;
        }

        if(violation == otherValue.violation) {
            return fitnessOnEqualViolation ? fitness.compareTo(otherValue.fitness) : 0;
        }

        // the smaller violation is the greater (better) value
        return Double.compare(otherValue.violation, violation);
    }

    /**
     * @return The fitness distance if both values are compared by their fitness, otherwise the
     *   difference of the violations.
     * @throws IllegalArgumentException if the other value is no feasibility value.
     */
    @Override
    public double distanceFrom(final @NonNull OptimisationValue other) {
        final FeasibilityValue otherValue = toFeasibilityValue(other);
        final boolean bothFeasible = isFeasible() && otherValue.isFeasible();
        final boolean equalViolation = fitnessOnEqualViolation && violation == otherValue.violation;

        if(bothFeasible || equalViolation) {
            return fitness.distanceFrom(otherValue.fitness);
        }

        return Math.abs(violation - otherValue.violation);
    }

    /**
     * @return The fitness value of the candidate.
     */
    public FitnessValue getFitnessValue() {
        return fitness;
    }

    /**
     * @return The violation of the constraint group.
     */
    public double getViolation() {
        return violation;
    }

    /**
     * @return Whether the violation is at most epsilon.
     */
    public boolean isFeasible() {
        return violation <= epsilon;
    }

    private static FeasibilityValue toFeasibilityValue(final OptimisationValue other) {
        if(!(other instanceof FeasibilityValue otherValue)) {
            throw new IllegalArgumentException("A feasibility value cannot be compared with " + other + ".");
        }

        return otherValue;
    }

    @Override
    public TypedEObject toOptmisationSpace() {
        return fitness.toOptmisationSpace();
    }

    /**
     * @return The values of the objectives.
     */
    @Override
    public List<Object> toStatistics() {
        return fitness.toStatistics();
    }

    @Override
    public String toString() {
        return "FeasibilityValue [" + fitness + ", violation=" + violation + ", epsilon=" + epsilon + "]";
    }
}

package de.evoal.optimisation.ea.main.comparator;

import java.util.List;

import lombok.NonNull;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.ea.api.selection.ParetoFronts;

/**
 * The optimisation value of {@code 'crowded-comparator'}: the canonical fitness, compared by
 *   Pareto dominance. A value that dominates another is better; two values of which neither
 *   dominates the other compare as equal. The order is therefore only partial: it is used
 *   pairwise (e.g. for the best candidate so far), never for sorting.
 * <p>
 * If {@code 'nsga2-selection'} has a constraint group, the value also holds the violation of
 *   the group and compares by constrained domination ({@link ParetoFronts#constrainedDominates}).
 */
public final class ParetoValue extends OptimisationValueWithDistanceImpl {
    /**
     * The fitness of the candidate.
     */
    private final Fitness fitness;

    /**
     * The objectives of the candidate.
     */
    private final TypedEObject objectives;

    /**
     * The objectives shown in the statistics, in their order.
     */
    private final List<EStructuralFeature> statisticsFeatures;

    /**
     * The violation of the constraint group of the constrained domination; 0 without a group.
     */
    private final double violation;

    ParetoValue(final TypedEObject objectives, final Fitness fitness, final List<EStructuralFeature> statisticsFeatures) {
        this(objectives, fitness, statisticsFeatures, 0.0);
    }

    ParetoValue(final TypedEObject objectives,
                final Fitness fitness,
                final List<EStructuralFeature> statisticsFeatures,
                final double violation) {
        this.objectives = objectives;
        this.fitness = fitness;
        this.statisticsFeatures = statisticsFeatures;
        this.violation = violation;
    }

    /**
     * @return 1 if this value (constrained-)dominates the other, -1 if the other dominates this
     *   value, 0 otherwise.
     * @throws IllegalArgumentException if the other value is no Pareto value.
     */
    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        final ParetoValue otherValue = toParetoValue(other);
        final double[] mine = fitness.values();
        final double[] theirs = otherValue.fitness.values();

        if(ParetoFronts.constrainedDominates(mine, violation, theirs, otherValue.violation)) {
            return 1;
        }
        if(ParetoFronts.constrainedDominates(theirs, otherValue.violation, mine, violation)) {
            return -1;
        }
        return 0;
    }

    /**
     * @return The sum of the absolute differences of the fitness components.
     * @throws IllegalArgumentException if the other value is no Pareto value.
     */
    @Override
    public double distanceFrom(final @NonNull OptimisationValue other) {
        final double[] mine = fitness.values();
        final double[] theirs = toParetoValue(other).fitness.values();

        double distance = 0.0;
        for(int i = 0; i < mine.length; ++i) {
            distance += Math.abs(mine[i] - theirs[i]);
        }
        return distance;
    }

    /**
     * @return The fitness of the candidate.
     */
    public Fitness getFitness() {
        return fitness;
    }

    /**
     * @return The violation of the constraint group; 0 without a group.
     */
    public double getViolation() {
        return violation;
    }

    /**
     * @return The objectives shown in the statistics, in their order.
     */
    List<EStructuralFeature> statisticsFeatures() {
        return statisticsFeatures;
    }

    private static ParetoValue toParetoValue(final OptimisationValue other) {
        if(!(other instanceof ParetoValue otherValue)) {
            throw new IllegalArgumentException("A Pareto value cannot be compared with " + other + ".");
        }

        return otherValue;
    }

    @Override
    public TypedEObject toOptmisationSpace() {
        return objectives;
    }

    /**
     * @return The values of the objectives, not the fitness.
     */
    @Override
    public List<Object> toStatistics() {
        return statisticsFeatures.stream()
                                 .map(objectives::eGet)
                                 .toList();
    }

    @Override
    public String toString() {
        return "ParetoValue [" + fitness + ", violation=" + violation + "]";
    }
}

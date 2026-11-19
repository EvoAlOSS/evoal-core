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

    ParetoValue(final TypedEObject objectives, final Fitness fitness, final List<EStructuralFeature> statisticsFeatures) {
        this.objectives = objectives;
        this.fitness = fitness;
        this.statisticsFeatures = statisticsFeatures;
    }

    /**
     * @return 1 if this value dominates the other, -1 if the other dominates this value, 0
     *   otherwise.
     * @throws IllegalArgumentException if the other value is no Pareto value.
     */
    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        final double[] mine = fitness.values();
        final double[] theirs = toParetoValue(other).fitness.values();

        if(ParetoFronts.dominates(mine, theirs)) {
            return 1;
        }
        if(ParetoFronts.dominates(theirs, mine)) {
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
        return "ParetoValue [" + fitness + "]";
    }
}

package de.evoal.optimisation.main.comparator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NonNull;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl;

import de.evoal.optimisation.api.fitness.Fitness;

/**
 * An optimisation value that compares the canonical fitness: the components in the given
 *   order, lexicographically, where a smaller value is better. The statistics show the
 *   objectives, not the fitness.
 * <p>
 * The contract of {@link OptimisationValue} is that a greater value is better
 *   ({@link #isBetter} means {@code compareTo > 0}). Since the fitness is minimised, the
 *   comparison is reversed.
 */
public final class FitnessValue extends OptimisationValueWithDistanceImpl {
    /**
     * The fitness of the candidate.
     */
    private final Fitness fitness;

    /**
     * The objectives of the candidate.
     */
    private final TypedEObject objectives;

    /**
     * The positions of the compared fitness components, most important first.
     */
    private final int[] order;

    /**
     * The objectives shown in the statistics, in their order.
     */
    private final List<EStructuralFeature> statisticsFeatures;

    private FitnessValue(final TypedEObject objectives,
                         final Fitness fitness,
                         final int[] order,
                         final List<EStructuralFeature> statisticsFeatures) {
        this.objectives = objectives;
        this.fitness = fitness;
        this.order = order;
        this.statisticsFeatures = statisticsFeatures;
    }

    /**
     * @param other Another fitness value.
     * @return A positive number if this value is better (has a smaller fitness at the first
     *   differing component), a negative number if it is worse, and 0 if the compared
     *   components are equal.
     * @throws IllegalArgumentException if the other value is no fitness value.
     */
    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        final FitnessValue otherValue = toFitnessValue(other);

        for(final int index : order) {
            final double thisFitness = fitness.value(index);
            final double otherFitness = otherValue.fitness.value(index);
            // reversed: the smaller fitness is the greater (better) value
            final int comparison = Double.compare(otherFitness, thisFitness);

            if(comparison != 0) {
                return comparison;
            }
        }

        return 0;
    }

    /**
     * @return The sum of the absolute differences of the compared fitness components.
     * @throws IllegalArgumentException if the other value is no fitness value.
     */
    @Override
    public double distanceFrom(final @NonNull OptimisationValue other) {
        final FitnessValue otherValue = toFitnessValue(other);

        return Arrays.stream(order)
                     .mapToDouble(index -> Math.abs(fitness.value(index) - otherValue.fitness.value(index)))
                     .sum();
    }

    /**
     * @return The fitness of the candidate.
     */
    public Fitness getFitness() {
        return fitness;
    }

    /**
     * @param objectives The objectives of the candidate.
     * @param fitness The fitness of the candidate.
     * @param order The positions of the compared fitness components, most important first.
     * @param statisticsFeatures The objectives shown in the statistics, in their order.
     * @return The optimisation value.
     */
    public static FitnessValue of(final @NonNull TypedEObject objectives,
                                  final @NonNull Fitness fitness,
                                  final int @NonNull [] order,
                                  final @NonNull List<EStructuralFeature> statisticsFeatures) {
        return new FitnessValue(objectives, fitness, order, statisticsFeatures);
    }

    private static FitnessValue toFitnessValue(final OptimisationValue other) {
        if(!(other instanceof FitnessValue otherValue)) {
            throw new IllegalArgumentException("A fitness value cannot be compared with " + other + ".");
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
        final String compared = Arrays.stream(order)
                                      .mapToObj(index -> fitness.layout().component(index).name())
                                      .collect(Collectors.joining(", "));

        return "FitnessValue [" + fitness + ", compared=" + compared + "]";
    }
}

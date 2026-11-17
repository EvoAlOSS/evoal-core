package de.evoal.optimisation.api.fitness;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.NonNull;

/**
 * The fitness of a candidate: one {@code double} per component of its {@link FitnessLayout}.
 *   The fitness is canonical, i.e., smaller values are better. It is immutable.
 */
public final class Fitness {
    /**
     * The components of the fitness.
     */
    private final FitnessLayout layout;

    /**
     * The values, in the order of the layout's components.
     */
    private final double[] values;

    /**
     * @param layout The components of the fitness.
     * @param values The values, in the order of the layout's components; the array is copied.
     * @throws IllegalArgumentException if the number of values differs from the number of
     *   components.
     */
    public Fitness(final @NonNull FitnessLayout layout, final double @NonNull [] values) {
        if(layout.size() != values.length) {
            throw new IllegalArgumentException("The fitness has " + values.length + " values for the "
                                               + layout.size() + " components " + layout + ".");
        }

        this.layout = layout;
        this.values = values.clone();
    }

    @Override
    public boolean equals(final Object other) {
        if(this == other) {
            return true;
        }

        if(!(other instanceof Fitness fitness)) {
            return false;
        }

        return layout.equals(fitness.layout) && Arrays.equals(values, fitness.values);
    }

    @Override
    public int hashCode() {
        return 31 * layout.hashCode() + Arrays.hashCode(values);
    }

    /**
     * @return The components of the fitness.
     */
    public FitnessLayout layout() {
        return layout;
    }

    /**
     * @return The number of values.
     */
    public int size() {
        return values.length;
    }

    @Override
    public String toString() {
        final String content = IntStream.range(0, values.length)
                                        .mapToObj(index -> layout.component(index).name() + "=" + values[index])
                                        .collect(Collectors.joining(", "));

        return "Fitness[" + content + "]";
    }

    /**
     * @param index The position of the component.
     * @return The value of the component at the given position.
     */
    public double value(final int index) {
        return values[index];
    }

    /**
     * @return A copy of the values, in the order of the layout's components.
     */
    public double[] values() {
        return values.clone();
    }
}

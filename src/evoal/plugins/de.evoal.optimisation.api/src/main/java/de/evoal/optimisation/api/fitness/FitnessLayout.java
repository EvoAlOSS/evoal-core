package de.evoal.optimisation.api.fitness;

import java.util.List;
import java.util.stream.IntStream;

/**
 * The components of a {@link Fitness}, in the order of its values. A layout is built once
 *   when the {@link FitnessPipeline} is built and is shared by the fitness of all
 *   candidates, so the names are not stored per candidate.
 * <p>
 * Steps and comparators resolve a component by name ({@link #indexOf(String)}) once, when
 *   they are built, and use the index at run time.
 */
public final class FitnessLayout {
    /**
     * A layout without components.
     */
    public static final FitnessLayout EMPTY = new FitnessLayout(List.of());

    /**
     * The components, in the order of the fitness values.
     */
    private final List<FitnessComponent> components;

    /**
     * @param components The components, in the order of the fitness values.
     */
    public FitnessLayout(final List<FitnessComponent> components) {
        this.components = List.copyOf(components);
    }

    /**
     * @param index The position of the component.
     * @return The component at the given position.
     */
    public FitnessComponent component(final int index) {
        return components.get(index);
    }

    /**
     * @return The components, in the order of the fitness values.
     */
    public List<FitnessComponent> components() {
        return components;
    }

    @Override
    public boolean equals(final Object other) {
        if(this == other) {
            return true;
        }

        return other instanceof FitnessLayout layout && components.equals(layout.components);
    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }

    /**
     * @param name The name of a component.
     * @return The position of the component.
     * @throws IllegalArgumentException if the layout has no component with this name.
     */
    public int indexOf(final String name) {
        return IntStream.range(0, components.size())
                        .filter(index -> components.get(index).name().equals(name))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("The fitness has no component '" + name + "'."));
    }

    /**
     * @param goals The goals.
     * @return A layout with one component per goal, in the order of the goals.
     */
    public static FitnessLayout of(final Goals goals) {
        final List<FitnessComponent> components = goals.goals()
                                                       .stream()
                                                       .map(FitnessComponent::of)
                                                       .toList();

        return new FitnessLayout(components);
    }

    /**
     * @return The number of components.
     */
    public int size() {
        return components.size();
    }

    @Override
    public String toString() {
        return components.toString();
    }
}

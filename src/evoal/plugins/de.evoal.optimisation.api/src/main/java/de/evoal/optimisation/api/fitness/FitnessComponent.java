package de.evoal.optimisation.api.fitness;

import java.util.Objects;
import java.util.Optional;

import lombok.NonNull;

/**
 * One component of the fitness: its name and, if it was derived from a goal, the goal.
 *   Components without a goal are added by steps, e.g. a constraint violation.
 */
public final class FitnessComponent {
    /**
     * The goal the component was derived from, {@code null} if it belongs to no goal.
     */
    private final Goal goal;

    /**
     * The name of the component, unique within a {@link FitnessLayout}.
     */
    private final String name;

    private FitnessComponent(final String name, final Goal goal) {
        this.name = name;
        this.goal = goal;
    }

    @Override
    public boolean equals(final Object other) {
        if(this == other) {
            return true;
        }

        if(!(other instanceof FitnessComponent component)) {
            return false;
        }

        return name.equals(component.name) && Objects.equals(goal, component.goal);
    }

    /**
     * @return The goal the component was derived from, if any.
     */
    public Optional<Goal> goal() {
        return Optional.ofNullable(goal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, goal);
    }

    /**
     * @return The name of the component.
     */
    public String name() {
        return name;
    }

    /**
     * @param name The name of the component.
     * @return A component that belongs to no goal.
     */
    public static FitnessComponent named(final @NonNull String name) {
        return new FitnessComponent(name, null);
    }

    /**
     * @param goal The goal.
     * @return A component for the goal, named after its objective.
     */
    public static FitnessComponent of(final @NonNull Goal goal) {
        return new FitnessComponent(goal.name(), goal);
    }

    @Override
    public String toString() {
        return name;
    }
}

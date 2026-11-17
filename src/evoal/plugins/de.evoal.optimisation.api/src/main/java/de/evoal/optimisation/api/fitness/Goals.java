package de.evoal.optimisation.api.fitness;

import java.util.List;

import de.evoal.models.v202704.optimisation.model.Problem;

/**
 * The goals of the problem, in the order in which the problem declares them.
 *
 * @param goals The goals.
 */
public record Goals(List<Goal> goals) {
    /**
     * Copies the list, so the goals cannot change.
     */
    public Goals {
        goals = List.copyOf(goals);
    }

    /**
     * @param index The position of the goal.
     * @return The goal at the given position.
     */
    public Goal get(final int index) {
        return goals.get(index);
    }

    /**
     * @param problem The problem.
     * @return The goals of the problem.
     */
    public static Goals of(final Problem problem) {
        final List<Goal> goals = problem.getGoals()
                                        .stream()
                                        .map(Goal::of)
                                        .toList();

        return new Goals(goals);
    }

    /**
     * @return The number of goals.
     */
    public int size() {
        return goals.size();
    }
}

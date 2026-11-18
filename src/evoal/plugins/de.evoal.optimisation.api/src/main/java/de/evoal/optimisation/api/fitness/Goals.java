package de.evoal.optimisation.api.fitness;

import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.v202704.core.Configuration;
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
     * @param targetPoint The current target point of the evaluation, or {@code null}
     *   outside an evaluation with target points.
     * @param distances Creates the distance of a target goal from its configuration.
     * @return The goals of the problem, with the targets resolved.
     * @see Goal#of(de.evoal.models.v202704.optimisation.model.OptimisationGoal, EObject, Function)
     */
    public static Goals of(final Problem problem,
                           final EObject targetPoint,
                           final Function<Configuration, TargetDistance> distances) {
        final List<Goal> goals = problem.getGoals()
                                        .stream()
                                        .map(goal -> Goal.of(goal, targetPoint, distances))
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

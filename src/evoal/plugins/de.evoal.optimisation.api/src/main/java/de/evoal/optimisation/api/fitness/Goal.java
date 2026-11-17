package de.evoal.optimisation.api.fitness;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.v202704.optimisation.model.MaximiseGoal;
import de.evoal.models.v202704.optimisation.model.MinimiseGoal;
import de.evoal.models.v202704.optimisation.model.OptimisationGoal;
import de.evoal.models.v202704.optimisation.model.TargetGoal;

/**
 * An optimisation goal of the problem: the objective it refers to and what is optimised.
 *   The steps of the {@link FitnessPipeline} work on goals instead of the OL model.
 */
public sealed interface Goal {
    /**
     * @return The name of the objective.
     */
    default String name() {
        return objective().getName();
    }

    /**
     * @return The feature of the objective in the optimisation space.
     */
    EStructuralFeature objective();

    /**
     * Converts a goal of the problem model.
     *
     * @param goal The goal of the problem model.
     * @return The goal.
     * @throws IllegalArgumentException if the kind of goal is not supported.
     */
    static Goal of(final OptimisationGoal goal) {
        return switch(goal) {
            case MaximiseGoal maximise -> new Maximise(maximise.getData());
            case MinimiseGoal minimise -> new Minimise(minimise.getData());
            case TargetGoal target -> toTarget(target);
            default -> throw new IllegalArgumentException("Unsupported goal type: " + goal.getClass().getName());
        };
    }

    private static Target toTarget(final TargetGoal goal) {
        final double target = NumericConversions.toDouble(goal.getValue());

        return new Target(goal.getData(), target);
    }

    /**
     * The objective is maximised.
     *
     * @param objective The feature of the objective in the optimisation space.
     */
    record Maximise(EStructuralFeature objective) implements Goal {
    }

    /**
     * The objective is minimised.
     *
     * @param objective The feature of the objective in the optimisation space.
     */
    record Minimise(EStructuralFeature objective) implements Goal {
    }

    /**
     * The objective should reach a target value.
     *
     * @param objective The feature of the objective in the optimisation space.
     * @param target The target value.
     */
    record Target(EStructuralFeature objective, double target) implements Goal {
    }
}

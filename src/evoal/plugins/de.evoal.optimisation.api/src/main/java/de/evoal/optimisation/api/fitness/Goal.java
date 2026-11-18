package de.evoal.optimisation.api.fitness;

import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.v202704.core.Configuration;
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
     * Converts a goal of the problem model. The target of a target goal is resolved: a
     *   constant target is taken from the goal, a target from the evaluation is taken from
     *   the evaluation's current target point.
     *
     * @param goal The goal of the problem model.
     * @param targetPoint The current target point of the evaluation (a point of the
     *   optimisation space), or {@code null} outside an evaluation with target points.
     * @param distances Creates the distance of a target goal from its configuration.
     * @return The goal.
     * @throws IllegalArgumentException if the kind of goal is not supported.
     * @throws IllegalStateException if the goal takes its target from the evaluation, but
     *   there is no target point.
     */
    static Goal of(final OptimisationGoal goal,
                   final EObject targetPoint,
                   final Function<Configuration, TargetDistance> distances) {
        return switch(goal) {
            case MaximiseGoal maximise -> new Maximise(maximise.getData());
            case MinimiseGoal minimise -> new Minimise(minimise.getData());
            case TargetGoal target -> toTarget(target, targetPoint, distances);
            default -> throw new IllegalArgumentException("Unsupported goal type: " + goal.getClass().getName());
        };
    }

    private static Target toTarget(final TargetGoal goal,
                                   final EObject targetPoint,
                                   final Function<Configuration, TargetDistance> distances) {
        final EStructuralFeature objective = goal.getData();
        final double target = targetOf(goal, targetPoint);
        final Configuration distanceConfiguration = goal.getDistance();
        final TargetDistance distance = distances.apply(distanceConfiguration);

        return new Target(objective, target, distance);
    }

    private static double targetOf(final TargetGoal goal, final EObject targetPoint) {
        if(!goal.isFromEvaluation()) {
            return NumericConversions.toDouble(goal.getValue());
        }

        final String objectiveName = goal.getData().getName();
        if(targetPoint == null) {
            throw new IllegalStateException("The goal for '" + objectiveName + "' optimises towards the target of"
                                            + " the evaluation, but there is no target point. Run it as an evaluation"
                                            + " with a target-points file.");
        }

        // the target point is an object of the optimisation space of the evaluation, so the
        //   objective is looked up by its name
        final EStructuralFeature targetFeature = targetPoint.eClass().getEStructuralFeature(objectiveName);
        if(targetFeature == null) {
            throw new IllegalStateException("The target point has no value for '" + objectiveName + "'.");
        }

        final Object targetValue = targetPoint.eGet(targetFeature);

        return NumericConversions.toDouble(targetValue);
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
     * @param distance Measures how far a value of the objective is from the target.
     */
    record Target(EStructuralFeature objective, double target, TargetDistance distance) implements Goal {
        /**
         * @param value The value of the objective.
         * @return The distance of the value from the target.
         */
        public double distanceOf(final double value) {
            return distance.distance(value, target);
        }
    }
}

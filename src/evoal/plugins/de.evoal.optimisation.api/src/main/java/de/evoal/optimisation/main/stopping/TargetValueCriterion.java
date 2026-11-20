package de.evoal.optimisation.main.stopping;

import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.fitness.DirectionStep;
import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.fitness.Goals;

/**
 * Stops as soon as the best individual so far ({@link Iteration#getBestSoFar()}) reaches a
 *   target value of an objective. The objective value of the individual and the target are
 *   both converted into the canonical direction with the goal of the objective
 *   ({@link DirectionStep#toCanonical}), so the criterion needs no direction logic of its own
 *   and the target stays in the units of the objective, whatever steps the fitness pipeline
 *   has.
 * <p>
 * The target is reached if the canonical value is strictly below the canonical target, as
 *   in the COCO benchmarks, where the runtime ends when the best feasible value "drops below
 *   the target". An infeasible best individual (a degree of violation above 0) does not
 *   reach the target.
 */
@Dependent
@Named("de.evoal.optimisation.core.target-value")
@Slf4j
public class TargetValueCriterion extends TerminationCriterionImpl {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The goals of the current problem, with the current target point of an evaluation.
     */
    @Inject
    private Goals goals;

    @Inject
    private AttributeHelper helper;

    /**
     * The goal of the objective.
     */
    private Goal goal;

    /**
     * The target in the canonical direction.
     */
    private double canonicalTarget;

    /**
     * The target in the units of the objective, for the log.
     */
    private double target;

    /**
     * @throws InitializationException if the problem has no goal for the objective.
     */
    @Override
    public TerminationCriterion init(final EObject configuration) throws InitializationException {
        final EStructuralFeature objective = helper.lookup(configuration, "objective");
        target = evaluator.attributeToDouble(configuration, "target");
        goal = goalOf(objective.getName());
        canonicalTarget = DirectionStep.toCanonical(goal, target);

        return this;
    }

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        final Individual best = iteration.getBestSoFar();
        if(best == null) {
            return false;
        }

        if(!isFeasible(best)) {
            log.info("Check termination: the best individual {} is infeasible.", best.getId());
            return false;
        }

        final double value = best.getOutput().eGetAsDouble(goal.objective());
        final double canonicalValue = DirectionStep.toCanonical(goal, value);
        log.info("Check termination: {} of the best individual {} is {}, target {}.",
                 goal.name(), best.getId(), value, target);

        return canonicalValue < canonicalTarget;
    }

    /**
     * @return The goal of the objective.
     * @throws InitializationException if the problem has no goal for the objective.
     */
    private Goal goalOf(final String objective) throws InitializationException {
        return goals.goals()
                    .stream()
                    .filter(candidate -> candidate.name().equals(objective))
                    .findFirst()
                    .orElseThrow(() -> new InitializationException("The stopping criterion 'target-value' refers to '"
                                                                   + objective + "', but the problem has no goal for it."));
    }

    /**
     * @return Whether no degree of violation of the individual is above 0.
     */
    private static boolean isFeasible(final Individual individual) {
        for(final Map.Entry<String, Object> property : individual.getProperties()) {
            final boolean isViolation = property.getKey().startsWith(ViolationRecord.PROPERTY_PREFIX);
            if(isViolation && ((Number) property.getValue()).doubleValue() > 0.0) {
                return false;
            }
        }

        return true;
    }
}

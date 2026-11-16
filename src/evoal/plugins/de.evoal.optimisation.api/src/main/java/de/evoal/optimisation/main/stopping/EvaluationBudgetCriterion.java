package de.evoal.optimisation.main.stopping;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.ExhaustionPolicy;

/**
 * Stops when the number of evaluations of the real optimisation function
 *   (metric {@code evaluations.real}) reaches the budget. The criterion passes its budget
 *   to the {@link EvaluationService} ({@link EvaluationService#limit}), which records it
 *   as the execution metric {@code evaluations.real.budget} and, with the policy
 *   {@link ExhaustionPolicy#CUT_OFF}, never exceeds it.
 */
@Dependent
@Named("de.evoal.optimisation.core.evaluation-budget")
@Slf4j
public class EvaluationBudgetCriterion extends TerminationCriterionImpl {
    @Inject
    private EvaluationService evaluationService;

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private AttributeHelper helper;

    /**
     * The maximum number of evaluations of the real optimisation function.
     */
    private long maximumEvaluations;

    @Override
    public TerminationCriterion init(final EObject configuration) {
        maximumEvaluations = evaluator.attributeToInteger(configuration, "maximum-evaluations");

        final EEnumLiteral exhaustionLiteral = helper.lookup(configuration, "exhaustion");
        final ExhaustionPolicy policy = toExhaustionPolicy(exhaustionLiteral);

        evaluationService.limit(EvaluationSource.REAL, maximumEvaluations, policy);

        return this;
    }

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        final String metricName = EvaluationSource.REAL.getMetricName();
        final Number numberOfEvaluations = iteration.getMetrics().get(metricName);

        if(numberOfEvaluations == null) {
            throw new IllegalStateException("Iteration " + iteration.getNumber() + " has no value for the metric '"
                                            + metricName + "'.");
        }

        log.info("Check termination {} >= {}.", numberOfEvaluations, maximumEvaluations);

        return numberOfEvaluations.longValue() >= maximumEvaluations;
    }

    /**
     * @param literal A literal of the DL enumeration {@code 'budget-exhaustion'}.
     * @return The corresponding policy.
     */
    private static ExhaustionPolicy toExhaustionPolicy(final EEnumLiteral literal) {
        final String name = literal.getName();

        return switch(name) {
            case "finish-iteration" -> ExhaustionPolicy.FINISH_ITERATION;
            case "cut-off" -> ExhaustionPolicy.CUT_OFF;
            default -> throw new IllegalArgumentException("Unknown budget exhaustion '" + name + "'.");
        };
    }
}

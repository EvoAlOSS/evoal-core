package de.evoal.optimisation.main.evaluation;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.optimisation.api.evaluation.EvaluationStrategy;
import de.evoal.optimisation.api.evaluation.SampleAggregation;

/**
 * Every candidate is evaluated once (DL type {@code 'single-evaluation'}, the default of
 *   every algorithm).
 */
@Dependent
@Named("de.evoal.optimisation.core.single-evaluation")
public class SingleEvaluation implements EvaluationStrategy {
    /**
     * The strategy without configuration, e.g., for evaluators that are created from their
     *   parts.
     */
    public static final EvaluationStrategy INSTANCE = new SingleEvaluation();

    @Override
    public int samplesOfNewCandidates() {
        return 1;
    }

    @Override
    public boolean reEvaluates() {
        return false;
    }

    @Override
    public SampleAggregation aggregation() {
        return null;
    }

    @Override
    public EvaluationStrategy init(final EObject configuration) {
        return this;
    }
}

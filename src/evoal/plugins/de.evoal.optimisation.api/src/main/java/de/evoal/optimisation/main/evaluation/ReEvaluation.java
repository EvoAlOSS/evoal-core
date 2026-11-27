package de.evoal.optimisation.main.evaluation;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.evaluation.EvaluationStrategy;
import de.evoal.optimisation.api.evaluation.SampleAggregation;

/**
 * Every new candidate is evaluated {@code samples} times; every member of the population is
 *   evaluated once more at the start of every iteration, and its objectives are the aggregate
 *   of all its samples (DL type {@code 're-evaluation'}).
 */
@Dependent
@Named("de.evoal.optimisation.core.re-evaluation")
public class ReEvaluation implements EvaluationStrategy {
    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private AttributeHelper helper;

    /**
     * The number of evaluations of a new candidate.
     */
    private int samples;

    /**
     * How the samples are aggregated.
     */
    private SampleAggregation aggregation;

    /**
     * Creates a strategy whose configuration is read in {@link #init(EObject)}.
     */
    public ReEvaluation() {
    }

    /**
     * Creates a configured strategy, e.g., for tests.
     *
     * @param samples The number of evaluations of a new candidate.
     * @param aggregation How the samples are aggregated.
     */
    public ReEvaluation(final int samples, final SampleAggregation aggregation) {
        this.samples = samples;
        this.aggregation = aggregation;
    }

    @Override
    public int samplesOfNewCandidates() {
        return samples;
    }

    @Override
    public boolean reEvaluates() {
        return true;
    }

    @Override
    public SampleAggregation aggregation() {
        return aggregation;
    }

    @Override
    public EvaluationStrategy init(final EObject configuration) {
        samples = evaluator.attributeToInteger(configuration, "samples");
        aggregation = SampleAggregation.of(helper.<EEnumLiteral>lookup(configuration, "aggregation"));

        return this;
    }
}

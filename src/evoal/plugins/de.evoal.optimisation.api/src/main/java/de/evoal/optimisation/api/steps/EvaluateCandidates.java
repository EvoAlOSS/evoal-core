package de.evoal.optimisation.api.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.run.Candidate;

/**
 * Evaluates candidates in one of two modes:
 * <ul>
 *   <li><em>batch</em> ({@link #EvaluateCandidates(EvaluationService, OptimisationValueComparator)}):
 *     the current candidates that are not evaluated yet are passed to the
 *     {@link EvaluationService} as a batch, in their order, and the results come back in
 *     the same order. Evaluated candidates are not evaluated again.</li>
 *   <li><em>until accepted</em> ({@link #untilAccepted}): the offered candidates
 *     ({@link SearchState#getOffered()}) are evaluated one after the other until the first
 *     acceptable one. Every evaluated candidate is tested exactly once, so randomised tests
 *     (e.g. simulated annealing) are not repeated. The evaluated candidates become the
 *     current candidates, the acceptable one the accepted candidate
 *     ({@link SearchState#getAccepted()}). No further candidate is created or evaluated.</li>
 * </ul>
 */
public final class EvaluateCandidates implements FitnessCalculation {
    /**
     * Tests whether an evaluated candidate is acceptable, {@code null} in batch mode.
     */
    private final BiPredicate<SearchState, Candidate> acceptable;

    /**
     * Computes the optimisation values.
     */
    private final OptimisationValueComparator comparator;

    /**
     * Evaluates and counts the candidates.
     */
    private final EvaluationService evaluationService;

    /**
     * Creates an evaluation in batch mode.
     *
     * @param evaluationService Evaluates and counts the candidates.
     * @param comparator Computes the optimisation values.
     */
    public EvaluateCandidates(final EvaluationService evaluationService, final OptimisationValueComparator comparator) {
        this(evaluationService, comparator, null);
    }

    private EvaluateCandidates(final EvaluationService evaluationService,
                               final OptimisationValueComparator comparator,
                               final BiPredicate<SearchState, Candidate> acceptable) {
        this.evaluationService = evaluationService;
        this.comparator = comparator;
        this.acceptable = acceptable;
    }

    /**
     * Creates an evaluation of the offered candidates until one is acceptable.
     *
     * @param evaluationService Evaluates and counts the candidates.
     * @param comparator Computes the optimisation values.
     * @param acceptable Tests whether an evaluated candidate is acceptable; it is called once
     *   per evaluated candidate.
     * @return The evaluation.
     */
    public static EvaluateCandidates untilAccepted(final EvaluationService evaluationService,
                                                   final OptimisationValueComparator comparator,
                                                   final BiPredicate<SearchState, Candidate> acceptable) {
        return new EvaluateCandidates(evaluationService, comparator, acceptable);
    }

    @Override
    public String description() {
        return acceptable == null ? "evaluate the candidates" : "evaluate the offered candidates until one is accepted";
    }

    private void evaluate(final Candidate candidate) {
        final TypedEObject output = evaluationService.evaluate(candidate.input());
        final OptimisationValue value = comparator.apply(output);
        candidate.evaluate(output, value);
    }

    /**
     * @throws de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException if the
     *   budget runs out; the candidates evaluated before keep their evaluation (and are the
     *   current candidates in the mode "until accepted").
     */
    @Override
    public void execute(final SearchState state) {
        if(acceptable == null) {
            evaluateBatch(state);
        } else {
            evaluateUntilAccepted(state);
        }
    }

    private void evaluateBatch(final SearchState state) {
        for(final Candidate candidate : state.getCandidates()) {
            if(!candidate.isEvaluated()) {
                evaluate(candidate);
            }
        }
    }

    /**
     * Consumes the offered stream with {@code findFirst()}, so that every candidate is only
     *   created when the previous one was rejected.
     */
    private void evaluateUntilAccepted(final SearchState state) {
        final List<Candidate> evaluated = new ArrayList<>();

        state.getOffered()
             .filter(candidate -> {
                 evaluate(candidate);

                 evaluated.add(candidate);
                 state.setCandidates(evaluated);

                 return acceptable.test(state, candidate);
             })
             .findFirst()
             .ifPresent(state::setAccepted);
    }
}

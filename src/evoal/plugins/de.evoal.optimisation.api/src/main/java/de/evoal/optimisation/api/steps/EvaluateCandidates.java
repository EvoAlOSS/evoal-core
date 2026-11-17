package de.evoal.optimisation.api.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.run.Candidate;

/**
 * Evaluates candidates in one of two modes:
 * <ul>
 *   <li><em>batch</em> ({@link #EvaluateCandidates(Evaluator)}): the current candidates
 *     that are not evaluated yet are evaluated in their order. Evaluated candidates are not
 *     evaluated again.</li>
 *   <li><em>until accepted</em> ({@link #untilAccepted}): the offered candidates
 *     ({@link SearchState#getOffered()}) are evaluated one after the other until the first
 *     acceptable one. Every evaluated candidate is tested exactly once, so randomised tests
 *     (e.g. simulated annealing) are not repeated. The evaluated candidates become the
 *     current candidates, the acceptable one the accepted candidate
 *     ({@link SearchState#getAccepted()}). No further candidate is created or evaluated.</li>
 * </ul>
 * The {@link Evaluator} computes the objectives, the fitness and the optimisation value of
 *   each candidate.
 */
public final class EvaluateCandidates implements FitnessCalculation {
    /**
     * Tests whether an evaluated candidate is acceptable, {@code null} in batch mode.
     */
    private final BiPredicate<SearchState, Candidate> acceptable;

    /**
     * Evaluates the candidates.
     */
    private final Evaluator evaluator;

    /**
     * Creates an evaluation in batch mode.
     *
     * @param evaluator Evaluates the candidates.
     */
    public EvaluateCandidates(final Evaluator evaluator) {
        this(evaluator, null);
    }

    private EvaluateCandidates(final Evaluator evaluator, final BiPredicate<SearchState, Candidate> acceptable) {
        this.evaluator = evaluator;
        this.acceptable = acceptable;
    }

    /**
     * Creates an evaluation of the offered candidates until one is acceptable.
     *
     * @param evaluator Evaluates the candidates.
     * @param acceptable Tests whether an evaluated candidate is acceptable; it is called once
     *   per evaluated candidate.
     * @return The evaluation.
     */
    public static EvaluateCandidates untilAccepted(final Evaluator evaluator,
                                                   final BiPredicate<SearchState, Candidate> acceptable) {
        return new EvaluateCandidates(evaluator, acceptable);
    }

    @Override
    public String description() {
        return acceptable == null ? "evaluate the candidates" : "evaluate the offered candidates until one is accepted";
    }

    private void evaluate(final Candidate candidate) {
        final Evaluation evaluation = evaluator.evaluate(candidate.input());
        candidate.evaluate(evaluation);
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

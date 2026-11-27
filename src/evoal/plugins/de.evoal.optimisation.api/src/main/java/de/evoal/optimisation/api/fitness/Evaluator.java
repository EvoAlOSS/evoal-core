package de.evoal.optimisation.api.fitness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import de.evoal.core.api.cdi.Component;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.constraints.ConstraintEvaluation;
import de.evoal.optimisation.api.constraints.PartialViolationRecord;
import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.evaluation.ConfiguredEvaluationStrategy;
import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationStrategy;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.main.evaluation.SingleEvaluation;

/**
 * Evaluates a candidate: the {@link EvaluationService} computes the objectives, the
 *   {@link ConstraintEvaluation} the violation record, the {@link FitnessPipeline} the fitness
 *   and the comparator the optimisation value. Every algorithm evaluates its candidates with
 *   an evaluator, so the four always belong together.
 * <p>
 * The {@link EvaluationStrategy} of the run decides how often the optimisation function is
 *   called for a new candidate: with several samples, the objectives of the candidate are
 *   aggregated ({@link ObjectiveSamples}) before the constraints, the pipeline and the
 *   comparator see them. The samples of a candidate are consecutive evaluations, so each has
 *   its own task stream, and every sample counts against the budget.
 * <p>
 * {@link #evaluateAll(List)} computes the objectives of a batch in parallel
 *   ({@link EvaluationService#evaluateAll(List)}); the aggregates, violation records, the
 *   fitness and the optimisation values are computed afterwards on the calling thread, in
 *   input order.
 */
@Dependent
public class Evaluator {
    /**
     * Computes the optimisation value from the objectives and the fitness.
     */
    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    /**
     * Measures the constraints; {@code null} for an evaluator of a problem without
     *   constraints that is created from its parts.
     */
    @Inject
    private ConstraintEvaluation constraintEvaluation;

    /**
     * Evaluates and counts the candidates.
     */
    @Inject
    private EvaluationService evaluationService;

    /**
     * Computes the fitness from the objectives.
     */
    @Inject
    private FitnessPipeline pipeline;

    /**
     * Provides the evaluation strategy of the run; {@code null} for an evaluator that is
     *   created from its parts.
     */
    @Inject
    private ConfiguredEvaluationStrategy configuredStrategy;

    /**
     * The evaluation strategy of an evaluator that is created from its parts.
     */
    private EvaluationStrategy givenStrategy = SingleEvaluation.INSTANCE;

    /**
     * Creates an evaluator whose parts are injected.
     */
    public Evaluator() {
    }

    /**
     * Creates an evaluator from its parts that evaluates every candidate once.
     *
     * @param evaluationService Evaluates and counts the candidates.
     * @param pipeline Computes the fitness from the objectives.
     * @param comparator Computes the optimisation value from the objectives and the fitness.
     */
    public Evaluator(final EvaluationService evaluationService,
                     final FitnessPipeline pipeline,
                     final OptimisationValueComparator comparator) {
        this.evaluationService = evaluationService;
        this.pipeline = pipeline;
        this.comparator = comparator;
    }

    /**
     * Creates an evaluator from its parts that evaluates every candidate once.
     *
     * @param evaluationService Evaluates and counts the candidates.
     * @param constraintEvaluation Measures the constraints.
     * @param pipeline Computes the fitness from the objectives.
     * @param comparator Computes the optimisation value from the objectives and the fitness.
     */
    public Evaluator(final EvaluationService evaluationService,
                     final ConstraintEvaluation constraintEvaluation,
                     final FitnessPipeline pipeline,
                     final OptimisationValueComparator comparator) {
        this(evaluationService, pipeline, comparator);
        this.constraintEvaluation = constraintEvaluation;
    }

    /**
     * Creates an evaluator from its parts with an evaluation strategy, e.g., for tests.
     *
     * @param evaluationService Evaluates and counts the candidates.
     * @param pipeline Computes the fitness from the objectives.
     * @param comparator Computes the optimisation value from the objectives and the fitness.
     * @param strategy How often a candidate is evaluated.
     */
    public Evaluator(final EvaluationService evaluationService,
                     final FitnessPipeline pipeline,
                     final OptimisationValueComparator comparator,
                     final EvaluationStrategy strategy) {
        this(evaluationService, pipeline, comparator);
        this.givenStrategy = strategy;
    }

    /**
     * @return The evaluation strategy: the one of the run, or the given one.
     */
    public EvaluationStrategy strategy() {
        return configuredStrategy == null ? givenStrategy : configuredStrategy.strategy();
    }

    /**
     * Evaluates a candidate.
     *
     * @param input The candidate (a point of the search space).
     * @return The objectives, the violation record, the fitness and the optimisation value.
     * @throws de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException if the
     *   evaluation budget is exhausted.
     */
    public Evaluation evaluate(final TypedEObject input) {
        return evaluate(input, PartialViolationRecord.EMPTY);
    }

    /**
     * Evaluates a candidate whose constraints are partly measured.
     *
     * @param input The candidate (a point of the search space).
     * @param known The degrees of the constraints measured before the evaluation; they are
     *   not measured again.
     * @return The objectives, the violation record, the fitness and the optimisation value.
     * @throws de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException if the
     *   evaluation budget does not cover all samples of the candidate.
     */
    public Evaluation evaluate(final TypedEObject input, final PartialViolationRecord known) {
        final int samples = strategy().samplesOfNewCandidates();
        final List<TypedEObject> outputs = samples == 1
                ? List.of(evaluationService.evaluate(input))
                : evaluationService.evaluateAll(Collections.nCopies(samples, input));

        return toEvaluation(input, samplesOf(outputs), known);
    }

    /**
     * Evaluates a batch of candidates. If a budget with the policy {@code cut-off} does not
     *   cover all candidates, the first candidates whose samples it covers completely are
     *   evaluated and the result contains the exhaustion, so the evaluations equal the ones
     *   of a sequential run.
     *
     * @param inputs The candidates (points of the search space).
     * @return The evaluations of the first candidates and the exhaustion of the budget, if any.
     * @throws RuntimeException the failure of the evaluation with the lowest index, after all
     *   evaluations of the batch have ended.
     */
    public BatchEvaluation evaluateAll(final List<TypedEObject> inputs) {
        return evaluateAll(inputs, Collections.nCopies(inputs.size(), PartialViolationRecord.EMPTY));
    }

    /**
     * Evaluates a batch of candidates whose constraints are partly measured, like
     *   {@link #evaluateAll(List)}.
     *
     * @param inputs The candidates (points of the search space).
     * @param known The degrees of the constraints of every candidate measured before the
     *   evaluation, in the order of the candidates; they are not measured again.
     * @return The evaluations of the first candidates and the exhaustion of the budget, if any.
     * @throws IllegalArgumentException if the lists differ in size.
     * @throws RuntimeException the failure of the evaluation with the lowest index, after all
     *   evaluations of the batch have ended.
     */
    public BatchEvaluation evaluateAll(final List<TypedEObject> inputs, final List<PartialViolationRecord> known) {
        if(inputs.size() != known.size()) {
            throw new IllegalArgumentException("The batch has " + inputs.size() + " candidates, but " + known.size()
                                               + " partial violation records.");
        }

        final int samples = strategy().samplesOfNewCandidates();
        final int covered = coveredCandidates(inputs.size(), samples);

        final List<TypedEObject> evaluated = inputs.subList(0, covered);
        final List<TypedEObject> outputs = evaluationService.evaluateAll(repeated(evaluated, samples));

        final List<Evaluation> evaluations = new ArrayList<>(covered);
        for(int i = 0; i < covered; ++i) {
            final List<TypedEObject> samplesOfCandidate = outputs.subList(i * samples, (i + 1) * samples);
            evaluations.add(toEvaluation(evaluated.get(i), samplesOf(samplesOfCandidate), known.get(i)));
        }

        final List<TypedEObject> beyondBudget = inputs.subList(covered, inputs.size());
        final EvaluationBudgetExhaustedException exhaustion = beyondBudget.isEmpty() ? null : exhaustionFor(repeated(beyondBudget, samples));

        return new BatchEvaluation(evaluations, exhaustion);
    }

    /**
     * Evaluates every candidate once more and aggregates all its samples, e.g., the members
     *   of the population with the strategy {@code 're-evaluation'}. If a budget with the
     *   policy {@code cut-off} does not cover all candidates, the first candidates that it
     *   covers are evaluated and the result contains the exhaustion.
     *
     * @param inputs The candidates (points of the search space).
     * @param previous The evaluations of the candidates so far, in the order of the
     *   candidates; their samples have an aggregation.
     * @return The new evaluations of the first candidates and the exhaustion of the budget,
     *   if any.
     * @throws IllegalArgumentException if the lists differ in size.
     */
    public BatchEvaluation reEvaluateAll(final List<TypedEObject> inputs, final List<Evaluation> previous) {
        if(inputs.size() != previous.size()) {
            throw new IllegalArgumentException("The batch has " + inputs.size() + " candidates, but " + previous.size()
                                               + " previous evaluations.");
        }

        final int covered = coveredCandidates(inputs.size(), 1);

        final List<TypedEObject> evaluated = inputs.subList(0, covered);
        final List<TypedEObject> outputs = evaluationService.evaluateAll(evaluated);

        final List<Evaluation> evaluations = new ArrayList<>(covered);
        for(int i = 0; i < covered; ++i) {
            final ObjectiveSamples samples = previous.get(i).samples().with(List.of(outputs.get(i)));
            evaluations.add(toEvaluation(evaluated.get(i), samples, PartialViolationRecord.EMPTY));
        }

        final List<TypedEObject> beyondBudget = inputs.subList(covered, inputs.size());
        final EvaluationBudgetExhaustedException exhaustion = beyondBudget.isEmpty() ? null : exhaustionFor(beyondBudget);

        return new BatchEvaluation(evaluations, exhaustion);
    }

    /**
     * @return The number of candidates whose samples the remaining budget covers completely.
     */
    private int coveredCandidates(final int numberOfCandidates, final int samples) {
        final OptionalLong remaining = evaluationService.remainingEvaluations();

        return (int) Math.min(numberOfCandidates, remaining.orElse(Long.MAX_VALUE) / samples);
    }

    /**
     * @return Every input {@code samples} times in a row.
     */
    private static List<TypedEObject> repeated(final List<TypedEObject> inputs, final int samples) {
        if(samples == 1) {
            return inputs;
        }

        final List<TypedEObject> repeated = new ArrayList<>(inputs.size() * samples);
        for(final TypedEObject input : inputs) {
            repeated.addAll(Collections.nCopies(samples, input));
        }

        return repeated;
    }

    /**
     * @return The samples of a candidate with the outputs of its evaluations.
     */
    private ObjectiveSamples samplesOf(final List<TypedEObject> outputs) {
        final EvaluationStrategy strategy = strategy();

        return strategy.samples() ? ObjectiveSamples.of(outputs, strategy.aggregation()) : ObjectiveSamples.single(outputs.getFirst());
    }

    /**
     * @return The exhaustion that the service reports for the evaluations beyond the budget.
     *   The service rejects them before making any of them.
     */
    private EvaluationBudgetExhaustedException exhaustionFor(final List<TypedEObject> beyondBudget) {
        try {
            evaluationService.evaluateAll(beyondBudget);
        } catch(final EvaluationBudgetExhaustedException e) {
            return e;
        }

        throw new IllegalStateException("The budget allowed more evaluations than reported.");
    }

    /**
     * @return The evaluation of a candidate whose objectives are computed: the aggregate of
     *   its samples is the output.
     */
    private Evaluation toEvaluation(final TypedEObject input, final ObjectiveSamples samples,
                                    final PartialViolationRecord known) {
        final TypedEObject output = samples.aggregate();
        final ViolationRecord violations = constraintEvaluation == null
                ? ViolationRecord.NONE
                : constraintEvaluation.measure(input, output, known);
        final Fitness fitness = pipeline.apply(input, output, violations);
        final OptimisationValue value = comparator.toValue(output, fitness, violations);

        return new Evaluation(output, fitness, value, violations, samples);
    }
}

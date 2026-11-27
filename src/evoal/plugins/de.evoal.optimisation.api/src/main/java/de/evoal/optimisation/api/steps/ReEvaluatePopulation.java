package de.evoal.optimisation.api.steps;

import java.util.ArrayList;
import java.util.List;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.evaluation.ConfiguredEvaluationStrategy;
import de.evoal.optimisation.api.fitness.BatchEvaluation;
import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.run.Candidate;

/**
 * Evaluates every member of the population once more (strategy {@code 're-evaluation'}): its
 *   objectives become the aggregate of all its samples, and its relationship to its previous
 *   individual gets the property {@value ConfiguredEvaluationStrategy#RE_EVALUATED}. An
 *   algorithm places the step at the start of its iterations
 *   ({@link TemplateAlgorithm#reEvaluation(Evaluator)}), so a member that survived with a
 *   lucky value is judged by more samples in the next selection.
 * <p>
 * If the budget runs out, the first members that it covers are re-evaluated, the others keep
 *   their evaluation, and the exhaustion is passed on.
 */
public final class ReEvaluatePopulation implements FitnessCalculation {
    /**
     * Evaluates the members.
     */
    private final Evaluator evaluator;

    /**
     * The members the last execution re-evaluated.
     */
    private List<Candidate> reEvaluated = List.of();

    /**
     * @param evaluator Evaluates the members.
     */
    public ReEvaluatePopulation(final Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public String description() {
        return "evaluate the members of the population once more";
    }

    @Override
    public void execute(final SearchState state) {
        final List<Candidate> members = state.getPopulation();

        final List<TypedEObject> inputs = members.stream()
                                                 .map(Candidate::input)
                                                 .toList();
        final List<Evaluation> previous = members.stream()
                                                 .map(Candidate::evaluation)
                                                 .toList();

        final BatchEvaluation batch = evaluator.reEvaluateAll(inputs, previous);
        final List<Evaluation> evaluations = batch.evaluations();

        final List<Candidate> population = new ArrayList<>(members.size());
        final List<Candidate> done = new ArrayList<>(evaluations.size());
        for(int i = 0; i < members.size(); ++i) {
            if(i < evaluations.size()) {
                final Candidate member = members.get(i).reEvaluated(evaluations.get(i), ConfiguredEvaluationStrategy.RE_EVALUATED);
                population.add(member);
                done.add(member);
            } else {
                population.add(members.get(i));
            }
        }

        state.setPopulation(population);
        reEvaluated = done;

        batch.rethrowExhaustion();
    }

    /**
     * @return The members this execution re-evaluated, in their order.
     */
    @Override
    public List<Candidate> outputs(final SearchState state) {
        return reEvaluated;
    }
}

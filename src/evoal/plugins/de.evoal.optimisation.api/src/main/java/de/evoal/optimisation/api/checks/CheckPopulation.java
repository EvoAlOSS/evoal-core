package de.evoal.optimisation.api.checks;

import java.util.ArrayList;
import java.util.List;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.fitness.BatchEvaluation;
import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.steps.SearchState;

/**
 * Applies the checks of the check point {@link CheckPoint#POPULATION} to the population.
 *   Algorithms place it as the last step of every iteration, so the replacements are members
 *   of the iteration and recorded in the memory model.
 * <p>
 * A replacement takes the place of the failed member. If the member was carried over from
 *   the previous iteration, the replacement refers to it by a lineage of the kind
 *   {@link Lineage.Kind#REPLACEMENT} with the property {@code reason}. A member that is new
 *   in this iteration is not recorded, so its replacement has no predecessor and gets the
 *   property {@code reason} itself. The replacements are evaluated together, since the
 *   population consists of evaluated candidates. If the evaluation budget does not cover
 *   all of them, the members whose replacements are not evaluated stay in the population.
 */
public final class CheckPopulation extends CheckStep {
    /**
     * Evaluates the replacements.
     */
    private final Evaluator evaluator;

    /**
     * @param checks The population checks, in the configured order.
     * @param evaluator Evaluates the replacements.
     */
    public CheckPopulation(final List<ConfiguredCheck> checks, final Evaluator evaluator) {
        super(checks);
        this.evaluator = evaluator;
    }

    /**
     * @throws de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException if the
     *   budget runs out while the replacements are evaluated.
     */
    @Override
    public void execute(final SearchState state) {
        final List<Candidate> members = state.getPopulation();
        final List<Candidate> checked = apply(state, members, CheckPopulation::replacementOf);

        final List<Candidate> replacements = checked.stream()
                                                    .filter(candidate -> !candidate.isEvaluated())
                                                    .toList();
        final List<TypedEObject> inputs = replacements.stream()
                                                      .map(Candidate::input)
                                                      .toList();

        final BatchEvaluation batch = evaluator.evaluateAll(inputs);
        final List<Evaluation> evaluations = batch.evaluations();
        for(int i = 0; i < evaluations.size(); ++i) {
            replacements.get(i).evaluate(evaluations.get(i));
        }

        // members whose replacement could not be evaluated stay
        final List<Candidate> population = new ArrayList<>(checked.size());
        for(int i = 0; i < checked.size(); ++i) {
            final Candidate candidate = checked.get(i);
            population.add(candidate.isEvaluated() ? candidate : members.get(i));
        }
        state.setPopulation(population);

        batch.rethrowExhaustion();
    }

    /**
     * @return A replacement that refers to the replaced member if the member was carried
     *   over. If the failed candidate is a replacement of this step itself, the new one
     *   replaces the member that one replaced.
     */
    private static Candidate replacementOf(final Candidate failed, final String reason, final ReplacementSource source) {
        final boolean replacedInThisStep = !failed.isEvaluated();
        final Lineage failedLineage = failed.lineage();

        if(replacedInThisStep && failedLineage.kind() == Lineage.Kind.NONE) {
            return unrelated(reason, source);
        }

        final Candidate replaced = replacedInThisStep ? failedLineage.predecessor() : failed;
        if(replaced.lineage().kind() != Lineage.Kind.IDENTITY) {
            return unrelated(reason, source);
        }

        final Lineage lineage = Lineage.replacement(replaced)
                                       .withProperty(REASON, reason);

        return new Candidate(source.next(), lineage);
    }

    /**
     * @return A replacement of a member that is new in this iteration: without predecessor,
     *   with the reason as its own property.
     */
    private static Candidate unrelated(final String reason, final ReplacementSource source) {
        final Candidate replacement = new Candidate(source.next(), Lineage.NONE);
        replacement.setProperty(REASON, reason);

        return replacement;
    }
}

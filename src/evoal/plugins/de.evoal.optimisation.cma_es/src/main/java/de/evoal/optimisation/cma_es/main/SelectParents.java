package de.evoal.optimisation.cma_es.main;

import java.util.Collection;
import java.util.List;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Ranking;
import de.evoal.optimisation.api.steps.SearchState;
import de.evoal.optimisation.api.steps.Selection;

/**
 * Selects the mu best members of the population by their optimisation values, the best
 *   first; members of equal value keep their order.
 */
final class SelectParents implements Selection {
    @Override
    public String description() {
        return "select the mu best candidates";
    }

    @Override
    public void execute(final SearchState state) {
        final CmaEsRun run = SetUpDistribution.runOf(state);
        final int parents = run.distribution().parameters().parentNumber();

        state.setCandidates(best(state.getPopulation(), parents));
    }

    /**
     * @return The given number of best candidates, the best first.
     */
    static List<Candidate> best(final List<Candidate> population, final int count) {
        final List<OptimisationValue> values = population.stream()
                                                         .map(Candidate::value)
                                                         .toList();

        return Ranking.byValue(values)
                      .stream()
                      .flatMap(Collection::stream)
                      .limit(count)
                      .map(population::get)
                      .toList();
    }
}

package de.evoal.optimisation.cma_es.main;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.steps.ParameterAdjustment;
import de.evoal.optimisation.api.steps.SearchState;

/**
 * Updates the distribution from the selected candidates (the mean, the evolution paths, the
 *   covariance matrix and the step size) and records the function values of the population
 *   in the history of the CMA-ES run. The function value of a candidate is the first
 *   component of its fitness (smaller is better).
 */
final class UpdateDistribution implements ParameterAdjustment {
    @Override
    public String description() {
        return "update the mean, the evolution paths, the covariance matrix and the step size";
    }

    @Override
    public void execute(final SearchState state) {
        final CmaEsRun run = SetUpDistribution.runOf(state);
        final List<Candidate> population = state.getPopulation();

        final List<double[]> ranked = state.getCandidates()
                                           .stream()
                                           .map(Candidate::input)
                                           .map(run::genotypeOf)
                                           .toList();
        run.distribution().update(ranked);

        final double[] values = population.stream()
                                          .mapToDouble(candidate -> candidate.fitness().value(0))
                                          .toArray();
        run.history().record(values);
        run.countEvaluations(population.size());
    }
}

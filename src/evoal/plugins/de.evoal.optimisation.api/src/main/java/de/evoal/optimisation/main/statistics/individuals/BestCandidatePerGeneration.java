package de.evoal.optimisation.main.statistics.individuals;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.statistics.writer.AbstractCandidateStatisticsWriter;

/**
 * Writes the best individuals (rank 0) of every iteration to
 *   {@code best-candidate-per-iteration.csv} (DL type {@code best-candidate-per-iteration}).
 *   The columns are described in the DL type.
 */
@Named("de.evoal.optimisation.core.best-candidate-per-iteration")
@Dependent
public class BestCandidatePerGeneration extends AbstractCandidateStatisticsWriter {
    public BestCandidatePerGeneration() {
        super(Iteration::bestIndividuals, "best-candidate-per-iteration");
    }
}

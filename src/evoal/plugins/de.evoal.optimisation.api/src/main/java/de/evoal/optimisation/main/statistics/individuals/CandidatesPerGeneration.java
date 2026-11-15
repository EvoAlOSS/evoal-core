package de.evoal.optimisation.main.statistics.individuals;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.statistics.writer.AbstractCandidateStatisticsWriter;

/**
 * Writes every surviving individual of every iteration to
 *   {@code candidates-per-iteration.csv} (DL type {@code candidates-per-iteration}).
 *   The columns are described in the DL type.
 */
@Named("de.evoal.optimisation.core.candidates-per-iteration")
@Dependent
public class CandidatesPerGeneration extends AbstractCandidateStatisticsWriter {
    public CandidatesPerGeneration() {
        super(Iteration::survivedIndividuals, "candidates-per-iteration");
    }
}

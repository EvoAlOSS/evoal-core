package de.evoal.optimisation.main.statistics.individuals;

import java.util.stream.Stream;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.api.statistics.writer.AbstractCandidateStatisticsWriter;

/**
 * Writes the best individual found up to and including every iteration (the
 *   iteration's {@code bestSoFar}) to {@code best-candidate-so-far.csv} (DL type
 *   {@code best-candidate-so-far}). Iterations without {@code bestSoFar} are left out.
 *   The columns are described in the DL type.
 */
@Named("de.evoal.optimisation.core.best-candidate-so-far")
@Dependent
public class BestCandidateSoFar extends AbstractCandidateStatisticsWriter {
    public BestCandidateSoFar() {
        super(iteration -> Stream.ofNullable(iteration.getBestSoFar()), "best-candidate-so-far");
    }
}

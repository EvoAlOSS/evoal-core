package de.evoal.optimisation.cma_es.main;

import java.util.ArrayList;
import java.util.List;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.checks.Resampler;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.steps.Adaption;
import de.evoal.optimisation.api.steps.SearchState;

/**
 * Samples lambda candidates from the distribution N(m, sigma^2 C) and maps them into the
 *   bounds. The candidates have no predecessors: they come from the distribution, which the
 *   iteration records in its metrics. With a restart strategy, every candidate has the
 *   property {@code restart}; a candidate that the bounds changed has its point of the
 *   distribution as the property {@code genotype}. If the search stopped in this iteration,
 *   nothing is sampled.
 * <p>
 * As {@link Resampler}, the step samples a new candidate from the same distribution.
 */
final class SampleDistribution implements Adaption, Resampler {
    /**
     * The name of the property with the genotype of a candidate that the bounds changed.
     */
    static final String GENOTYPE = "genotype";

    /**
     * The name of the property with the number of the CMA-ES run of a candidate.
     */
    static final String RESTART = "restart";

    /**
     * Whether a candidate that the bounds changed gets the property {@link #GENOTYPE}.
     */
    private final boolean recordsGenotypes;

    /**
     * Whether the candidates get the property {@link #RESTART}.
     */
    private final boolean recordsRestarts;

    SampleDistribution(final boolean recordsRestarts, final boolean recordsGenotypes) {
        this.recordsRestarts = recordsRestarts;
        this.recordsGenotypes = recordsGenotypes;
    }

    @Override
    public String description() {
        return "sample lambda candidates from the distribution";
    }

    @Override
    public void execute(final SearchState state) {
        if(state.isStopped()) {
            state.setCandidates(List.of());

            return;
        }

        final CmaEsRun run = SetUpDistribution.runOf(state);
        run.distribution().covariance().decomposeIfDue();
        run.startSampling();

        final int populationSize = run.distribution().parameters().populationSize();
        final List<Candidate> sampled = new ArrayList<>(populationSize);
        for(int k = 0; k < populationSize; ++k) {
            sampled.add(newCandidate(run));
        }

        state.setCandidates(sampled);
    }

    private Candidate newCandidate(final CmaEsRun run) {
        final TypedEObject input = run.sample();
        final Candidate candidate = new Candidate(input, Lineage.NONE);
        if(recordsRestarts) {
            candidate.setProperty(RESTART, (long) run.restartNumber());
        }
        if(recordsGenotypes) {
            run.transformedGenotypeOf(input)
               .ifPresent(genotype -> candidate.setProperty(GENOTYPE, genotype));
        }

        return candidate;
    }

    @Override
    public Candidate resample(final SearchState state, final int index) {
        return newCandidate(SetUpDistribution.runOf(state));
    }
}

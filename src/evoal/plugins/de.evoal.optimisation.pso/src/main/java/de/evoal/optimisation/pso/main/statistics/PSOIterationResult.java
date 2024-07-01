package de.evoal.optimisation.pso.main.statistics;

import de.evoal.optimisation.api.statistics.Candidate;
import de.evoal.optimisation.api.statistics.IterationResult;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.optimisation.pso.api.swarm.Particle;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class PSOIterationResult implements IterationResult {

    /**
     * Best candidate of iteration.
     */
    private Candidate bestCandidate;

    /**
     * List of all individuals.
     */
    private final List<Candidate> candidates;

    /**
     * Iteration number
     */
    private final int iteration;

    /**
     * If we are maximising.
     */
    private final boolean maximise;

    /**
     * Size of population.
     */
    private final long populationSize;

    public PSOIterationResult(final int iteration, final boolean maximise, final Swarm swarm) {
        log.info("Iteration {} results with {} particles.", iteration, swarm.size());
        this.iteration = iteration;
        this.maximise = maximise;
        this.populationSize = swarm.size();
        this.candidates = Arrays.stream(swarm.getParticles())
                                .map(Particle::toCandidate)
                                .toList();

        this.bestCandidate = this.candidates.get(0);
        for(final Candidate p : this.candidates) {
            if(p.value().isBetter(this.bestCandidate().value(), maximise)) {
                this.bestCandidate = p;
            }
        }
    }

    @Override
    public int iteration() {
        return iteration;
    }

    @Override
    public Stream<Candidate> candidates() {
        return candidates.stream();
    }

    @Override
    public Optional<Integer> candidateCount() {
        return Optional.of((int)populationSize);
    }

    @Override
    public Candidate bestCandidate() {
        return bestCandidate;
    }
}

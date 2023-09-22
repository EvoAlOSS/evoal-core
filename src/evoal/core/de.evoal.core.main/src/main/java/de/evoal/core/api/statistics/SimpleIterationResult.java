package de.evoal.core.api.statistics;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class SimpleIterationResult implements IterationResult {


    private final int iteration;
    private final Collection<Candidate> candidates;
    private final Candidate bestCandidate;

    public SimpleIterationResult(final int iteration, final Collection<Candidate> candidates, final Candidate bestCandidate) {
        this.iteration = iteration;
        this.candidates = candidates;
        this.bestCandidate = bestCandidate;
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
        return Optional.of(candidates.size());
    }

    @Override
    public Candidate bestCandidate() {
        return bestCandidate;
    }
}

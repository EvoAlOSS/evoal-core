package de.evoal.optimisation.api.model.impl;

import de.evoal.optimisation.api.model.Candidate;
import de.evoal.optimisation.api.model.Iteration;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class SimpleIteration implements Iteration {
    private final int iteration;
    private final Collection<Candidate> individuals;
    private final Candidate bestIndividual;

    public SimpleIteration(final int iteration, final Collection<Candidate> individuals, final Candidate bestIndividual) {
        this.iteration = iteration;
        this.individuals = individuals;
        this.bestIndividual = bestIndividual;
    }

    @Override
    public int iteration() {
        return iteration;
    }

    @Override
    public Stream<Candidate> candidates() {
        return individuals.stream();
    }

    @Override
    public Optional<Integer> candidateCount() {
        return Optional.of(individuals.size());
    }

    @Override
    public Candidate bestCandidate() {
        return bestIndividual;
    }
}

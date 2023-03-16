package de.evoal.core.ea.main.statistics;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.statistics.Candidate;
import de.evoal.core.api.statistics.IterationResult;
import io.jenetics.Phenotype;
import io.jenetics.engine.EvolutionResult;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * An adapter, c.f. GOF: adapter pattern, for adapting Jenetic's {@link EvolutionResult} to
 *   EvoAl's {@link IterationResult}.
 */
public class IterationResultAdapter implements IterationResult {

    private final EvolutionResult<?, OptimisationValue> statistics;

    public IterationResultAdapter(final EvolutionResult<?, OptimisationValue> statistics) {
        this.statistics = statistics;
    }

    @Override
    public int iteration() {
        return (int)statistics.generation();
    }

    @Override
    public Stream<Candidate> candidates() {
        return statistics.population()
                .stream()
                .map(p -> BeanFactory.create(CandidateAdapter.class).init(p, (int)statistics.generation()))
                .map(Candidate.class::cast);
    }

    @Override
    public Optional<Integer> candidateCount() {
        return Optional.empty();
    }

    @Override
    public Candidate bestCandidate() {
        return BeanFactory.create(CandidateAdapter.class)
                .init(statistics.bestPhenotype(), (int)statistics.generation());
    }
}

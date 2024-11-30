package de.evoal.optimisation.ea.main.statistics;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.model.Candidate;
import de.evoal.optimisation.api.model.Iteration;
import io.jenetics.engine.EvolutionResult;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * An adapter, c.f. GOF: adapter pattern, for adapting Jenetic's {@link EvolutionResult} to
 *   EvoAl's {@link Iteration}.
 */
public class IterationAdapter implements Iteration {

    private final EvolutionResult<?, OptimisationValue> statistics;

    public IterationAdapter(final EvolutionResult<?, OptimisationValue> statistics) {
        this.statistics = statistics;
    }

    @Override
    public int iteration() {
        return (int)statistics.generation() - 1;
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

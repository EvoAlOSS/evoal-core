package de.evoal.optimisation.api.steps;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;

/**
 * Takes the next candidates from a candidate provider, e.g., random points of the search
 *   space. All executions of the step take their candidates from the same stream of the
 *   provider. The candidates have no predecessors.
 */
public final class SampleCandidates implements Initialization {
    /**
     * The number of candidates per execution.
     */
    private final int count;

    /**
     * Provides the candidates.
     */
    private final InitialCandidatesProvider provider;

    /**
     * The candidates of the provider, created with the first execution.
     */
    private Iterator<TypedEObject> source;

    /**
     * @param provider Provides the candidates.
     * @param count The number of candidates per execution.
     * @throws IllegalArgumentException if the count is not positive.
     */
    public SampleCandidates(final InitialCandidatesProvider provider, final int count) {
        if(count < 1) {
            throw new IllegalArgumentException("At least one candidate has to be sampled, but got " + count + ".");
        }

        this.provider = provider;
        this.count = count;
    }

    @Override
    public String description() {
        return "sample " + count + " candidates";
    }

    /**
     * @throws IllegalStateException if the provider has fewer candidates.
     */
    @Override
    public void execute(final SearchState state) {
        if(source == null) {
            final Stream<TypedEObject> candidates = provider.create();
            source = candidates.iterator();
        }

        final List<Candidate> sampled = Stream.generate(this::next)
                                              .limit(count)
                                              .map(input -> new Candidate(input, Lineage.NONE))
                                              .toList();

        state.setCandidates(sampled);
    }

    private TypedEObject next() {
        if(!source.hasNext()) {
            throw new IllegalStateException("The candidate provider has no further candidates.");
        }

        return source.next();
    }
}

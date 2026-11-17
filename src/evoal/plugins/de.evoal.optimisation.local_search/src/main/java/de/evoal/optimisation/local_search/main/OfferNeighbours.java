package de.evoal.optimisation.local_search.main;

import java.util.stream.Stream;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.steps.Adaption;
import de.evoal.optimisation.api.steps.SearchState;

import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;

/**
 * Offers the neighbours of the current candidate (the only member of the population) as
 *   mutations of it ({@link SearchState#getOffered()}). The neighbours are created only
 *   when they are consumed. Strategies that test a single neighbour (simulated annealing)
 *   get one neighbour chosen at random, all others get all neighbours in the configured
 *   order.
 */
final class OfferNeighbours implements Adaption {
    /**
     * Decides whether a single neighbour is offered.
     */
    private final AcceptingStrategy acceptingStrategy;

    /**
     * Creates the neighbours.
     */
    private final NeighbourChoosingStrategy neighbourStrategy;

    OfferNeighbours(final NeighbourChoosingStrategy neighbourStrategy, final AcceptingStrategy acceptingStrategy) {
        this.neighbourStrategy = neighbourStrategy;
        this.acceptingStrategy = acceptingStrategy;
    }

    @Override
    public String description() {
        return acceptingStrategy.testsSingleNeighbour() ? "offer a random neighbour" : "offer the neighbours";
    }

    @Override
    public void execute(final SearchState state) {
        final Candidate current = state.getPopulation().getFirst();
        final TypedEObject input = current.input();

        final Stream<TypedEObject> neighbours = acceptingStrategy.testsSingleNeighbour()
                ? neighbourStrategy.randomNeighbour(input).stream()
                : neighbourStrategy.neighbours(input);

        state.setOffered(neighbours.map(neighbour -> new Candidate(neighbour, Lineage.mutation(current))));
    }
}

package de.evoal.optimisation.local_search.main;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.steps.Acceptance;
import de.evoal.optimisation.api.steps.SearchState;

import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;

/**
 * Moves to the accepted neighbour: it replaces the current candidate. If no neighbour was
 *   accepted, the search ends when the rejection is final or there were no neighbours;
 *   otherwise, the candidate stays and the next iteration tries again.
 * <p>
 * The test whether a neighbour is acceptable ({@link #isAcceptable}) is used by the fitness
 *   calculation, which evaluates the neighbours until one is acceptable.
 */
@Slf4j
final class AcceptNeighbour implements Acceptance {
    /**
     * Decides about the neighbours.
     */
    private final AcceptingStrategy acceptingStrategy;

    AcceptNeighbour(final AcceptingStrategy acceptingStrategy) {
        this.acceptingStrategy = acceptingStrategy;
    }

    @Override
    public String description() {
        return "move to the accepted neighbour";
    }

    @Override
    public void execute(final SearchState state) {
        final Optional<Candidate> accepted = state.getAccepted();

        if(accepted.isPresent()) {
            final Candidate neighbour = accepted.get();
            log.info("{}: {} -> {}.", state.getIteration(), neighbour.input(), neighbour.value());

            state.setPopulation(List.of(neighbour));
            return;
        }

        final boolean noNeighbours = state.getCandidates().isEmpty();
        if(acceptingStrategy.rejectionIsFinal() || noNeighbours) {
            log.info("No acceptable neighbour in generation {}. Terminating optimisation.", state.getIteration());
            state.stop();
            return;
        }

        log.info("No acceptable neighbour in generation {}. Keeping the candidate.", state.getIteration());
    }

    /**
     * @return Whether the evaluated neighbour is acceptable compared to the current candidate.
     */
    boolean isAcceptable(final SearchState state, final Candidate neighbour) {
        final Candidate current = state.getPopulation().getFirst();

        return acceptingStrategy.acceptCandidate(neighbour.value(), current.value());
    }
}

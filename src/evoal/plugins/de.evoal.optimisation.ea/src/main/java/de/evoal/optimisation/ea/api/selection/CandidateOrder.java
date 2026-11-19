package de.evoal.optimisation.ea.api.selection;

import java.util.ArrayList;
import java.util.List;

import de.evoal.optimisation.api.run.Candidate;

/**
 * The order in which the selections compare candidates. By default, the candidates are
 *   compared by their optimisation values ({@link #BY_VALUE}); with
 *   {@code 'crowded-comparator'}, they are compared by their front and crowding distance
 *   ({@link CrowdedOrder}).
 */
@FunctionalInterface
public interface CandidateOrder {
    /**
     * Compares the candidates by their optimisation values.
     */
    CandidateOrder BY_VALUE = (first, second) -> first.value().compareTo(second.value());

    /**
     * @return A positive number if the first candidate is better, a negative number if it is
     *   worse, and 0 if both are equally good.
     */
    int compare(Candidate first, Candidate second);

    /**
     * @return Whether the first candidate is better than the second.
     */
    default boolean isBetter(final Candidate first, final Candidate second) {
        return compare(first, second) > 0;
    }

    /**
     * @return The candidates from the best to the worst; equally good candidates keep their
     *   order.
     */
    default List<Candidate> bestFirst(final List<Candidate> candidates) {
        final List<Candidate> sorted = new ArrayList<>(candidates);
        sorted.sort((first, second) -> compare(second, first));
        return sorted;
    }
}

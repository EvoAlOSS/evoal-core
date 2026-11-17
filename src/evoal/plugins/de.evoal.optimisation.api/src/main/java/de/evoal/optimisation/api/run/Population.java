package de.evoal.optimisation.api.run;

import java.util.List;

/**
 * The candidates an algorithm holds after an iteration and their ranking.
 * <p>
 * The index of a member identifies it within the iteration: the ranks and the lineage of
 *   the next population refer to the members by their index. The kernel creates the
 *   individuals in the order of the members, so the order determines the individual ids.
 *
 * @param members The members, indexed from 0.
 * @param ranks The indices of the members of every rank, the best rank first.
 */
public record Population(List<Member> members, List<List<Integer>> ranks) {
    /**
     * @throws IllegalArgumentException if a rank refers to an index that is not a member.
     */
    public Population {
        members = List.copyOf(members);
        ranks = ranks.stream()
                     .map(List::copyOf)
                     .toList();

        final int size = members.size();
        final boolean validIndices = ranks.stream()
                                          .flatMap(List::stream)
                                          .allMatch(index -> index >= 0 && index < size);
        if(!validIndices) {
            throw new IllegalArgumentException("The ranks " + ranks + " refer to indices outside the "
                                               + size + " members.");
        }
    }

    /**
     * @param member The only member.
     * @return A population with a single member in rank 0.
     */
    public static Population of(final Member member) {
        return new Population(List.of(member), List.of(List.of(0)));
    }
}

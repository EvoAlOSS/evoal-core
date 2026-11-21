package de.evoal.optimisation.api.run;

import java.util.List;

/**
 * The candidates an algorithm holds after an iteration and their ranking. All members are
 *   evaluated.
 * <p>
 * The ranks refer to the members by their index; the lineage of the members of the next
 *   population refers to the members themselves. The kernel creates the individuals in the
 *   order in which the candidates first occur in the outputs of the steps and then in the
 *   members, so this order determines the individual ids.
 *
 * @param members The evaluated candidates, indexed from 0.
 * @param ranks The indices of the members of every rank, the best rank first.
 * @param steps The steps executed in the iteration, in execution order, with their outputs.
 *   The kernel adds them to the iteration of the memory model.
 */
public record Population(List<Candidate> members, List<List<Integer>> ranks, List<ExecutedStep> steps) {
    /**
     * @throws IllegalArgumentException if a member is not evaluated or a rank refers to an
     *   index that is not a member.
     */
    public Population {
        members = List.copyOf(members);

        members.stream()
               .filter(member -> !member.isEvaluated())
               .findFirst()
               .ifPresent(member -> {
                   throw new IllegalArgumentException("The member " + member.input() + " is not evaluated.");
               });

        steps = List.copyOf(steps);
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
     * A population of an iteration without recorded steps.
     *
     * @param members The evaluated candidates, indexed from 0.
     * @param ranks The indices of the members of every rank, the best rank first.
     */
    public Population(final List<Candidate> members, final List<List<Integer>> ranks) {
        this(members, ranks, List.of());
    }

    /**
     * @param member The only member.
     * @return A population with a single member in rank 0.
     */
    public static Population of(final Candidate member) {
        return new Population(List.of(member), List.of(List.of(0)));
    }
}

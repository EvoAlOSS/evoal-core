package de.evoal.optimisation.api.run;

import java.util.List;

/**
 * How a member of a population came from the members of the previous population. The
 *   predecessors are given by their index in the previous population
 *   ({@link Population#members()}).
 *
 * @param kind The kind of the relationship.
 * @param predecessors The indices of the predecessors in the previous population.
 */
public record Lineage(Kind kind, List<Integer> predecessors) {
    /**
     * A member without predecessors, e.g., an initial candidate.
     */
    public static final Lineage NONE = new Lineage(Kind.NONE, List.of());

    /**
     * @throws IllegalArgumentException if the number of predecessors does not fit the kind.
     */
    public Lineage {
        predecessors = List.copyOf(predecessors);

        final boolean fits = switch(kind) {
            case NONE -> predecessors.isEmpty();
            case IDENTITY, MUTATION -> predecessors.size() == 1;
            case RECOMBINATION -> !predecessors.isEmpty();
        };

        if(!fits) {
            throw new IllegalArgumentException("A lineage of kind " + kind + " cannot have the predecessors "
                                               + predecessors + ".");
        }
    }

    /**
     * @param predecessor The index of the unchanged member in the previous population.
     * @return The lineage of a member that is the same candidate as its predecessor.
     */
    public static Lineage identity(final int predecessor) {
        return new Lineage(Kind.IDENTITY, List.of(predecessor));
    }

    /**
     * @param predecessor The index of the mutated member in the previous population.
     * @return The lineage of a member that is a changed version of its predecessor.
     */
    public static Lineage mutation(final int predecessor) {
        return new Lineage(Kind.MUTATION, List.of(predecessor));
    }

    /**
     * @param predecessors The indices of the parents in the previous population.
     * @return The lineage of a member that combines its predecessors.
     */
    public static Lineage recombination(final List<Integer> predecessors) {
        return new Lineage(Kind.RECOMBINATION, predecessors);
    }

    /**
     * The kinds of relationships, see the relationships of the memory model.
     */
    public enum Kind {
        /**
         * No predecessor.
         */
        NONE,

        /**
         * The same candidate as the predecessor.
         */
        IDENTITY,

        /**
         * A changed version of the predecessor.
         */
        MUTATION,

        /**
         * A combination of the predecessors.
         */
        RECOMBINATION
    }
}

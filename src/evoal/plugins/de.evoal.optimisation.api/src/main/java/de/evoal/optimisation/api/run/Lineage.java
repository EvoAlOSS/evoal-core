package de.evoal.optimisation.api.run;

import java.util.List;
import java.util.Objects;

/**
 * How a candidate came from other candidates, its predecessors.
 *
 * @param kind The kind of the relationship.
 * @param predecessors The predecessors.
 */
public record Lineage(Kind kind, List<Candidate> predecessors) {
    /**
     * A candidate without predecessors, e.g., an initial or sampled candidate.
     */
    public static final Lineage NONE = new Lineage(Kind.NONE, List.of());

    /**
     * @throws IllegalArgumentException if the number of predecessors does not fit the kind.
     */
    public Lineage {
        predecessors.forEach(Objects::requireNonNull);
        predecessors = List.copyOf(predecessors);

        final boolean fits = switch(kind) {
            case NONE -> predecessors.isEmpty();
            case IDENTITY, MUTATION -> predecessors.size() == 1;
            case RECOMBINATION -> !predecessors.isEmpty();
        };

        if(!fits) {
            throw new IllegalArgumentException("A lineage of kind " + kind + " cannot have "
                                               + predecessors.size() + " predecessors.");
        }
    }

    /**
     * @param predecessor The unchanged candidate.
     * @return The lineage of a candidate that is the same as its predecessor.
     */
    public static Lineage identity(final Candidate predecessor) {
        return new Lineage(Kind.IDENTITY, List.of(predecessor));
    }

    /**
     * @param predecessor The mutated candidate.
     * @return The lineage of a candidate that is a changed version of its predecessor.
     */
    public static Lineage mutation(final Candidate predecessor) {
        return new Lineage(Kind.MUTATION, List.of(predecessor));
    }

    /**
     * @param predecessors The parents.
     * @return The lineage of a candidate that combines its predecessors.
     */
    public static Lineage recombination(final List<Candidate> predecessors) {
        return new Lineage(Kind.RECOMBINATION, predecessors);
    }

    /**
     * @return The only predecessor of an identity or mutation.
     * @throws IllegalStateException if the lineage has not exactly one predecessor.
     */
    public Candidate predecessor() {
        if(predecessors.size() != 1) {
            throw new IllegalStateException("A lineage of kind " + kind + " has " + predecessors.size()
                                            + " predecessors.");
        }

        return predecessors.getFirst();
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

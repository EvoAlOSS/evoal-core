package de.evoal.optimisation.api.run;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * How a candidate came from other candidates, its predecessors.
 *
 * @param kind The kind of the relationship.
 * @param predecessors The predecessors.
 * @param properties Further details of the relationship, e.g., the reason of a replacement,
 *   by property name, in insertion order. The kernel records them on the relationship of the memory model; every
 *   name has to be defined with the scope {@code RELATIONSHIP}
 *   ({@link de.evoal.optimisation.api.execution.ExecutionRecorder#defineProperty}).
 */
public record Lineage(Kind kind, List<Candidate> predecessors, Map<String, Object> properties) {
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
        properties = Collections.unmodifiableMap(new LinkedHashMap<>(properties));

        final boolean fits = switch(kind) {
            case NONE -> predecessors.isEmpty();
            case IDENTITY, MUTATION, REPLACEMENT -> predecessors.size() == 1;
            case RECOMBINATION -> !predecessors.isEmpty();
        };

        if(!fits) {
            throw new IllegalArgumentException("A lineage of kind " + kind + " cannot have "
                                               + predecessors.size() + " predecessors.");
        }

        if(kind == Kind.NONE && !properties.isEmpty()) {
            throw new IllegalArgumentException("A lineage without predecessors has no relationship for the properties "
                                               + properties.keySet() + ".");
        }
    }

    /**
     * Creates a lineage without properties.
     *
     * @param kind The kind of the relationship.
     * @param predecessors The predecessors.
     */
    public Lineage(final Kind kind, final List<Candidate> predecessors) {
        this(kind, predecessors, Map.of());
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
     * @param replaced The candidate that failed a check.
     * @return The lineage of a candidate that took the place of the replaced one; it is not
     *   derived from it.
     */
    public static Lineage replacement(final Candidate replaced) {
        return new Lineage(Kind.REPLACEMENT, List.of(replaced));
    }

    /**
     * @param name The name of the property.
     * @param value The value of the property.
     * @return The same lineage with the property set.
     */
    public Lineage withProperty(final String name, final Object value) {
        final Map<String, Object> extended = new LinkedHashMap<>(properties);
        extended.put(name, value);

        return new Lineage(kind, predecessors, extended);
    }

    /**
     * @return The only predecessor of an identity, mutation or replacement.
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
        RECOMBINATION,

        /**
         * A candidate that took the place of its predecessor, e.g., because the predecessor
         *   failed a check.
         */
        REPLACEMENT
    }
}

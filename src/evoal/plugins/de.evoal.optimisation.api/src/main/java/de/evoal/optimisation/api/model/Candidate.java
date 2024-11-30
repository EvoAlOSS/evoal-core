package de.evoal.optimisation.api.model;

import de.evoal.core.api.properties.Properties;

/**
 * A solution candidate for the optimisation problem
 */
public interface Candidate {
    /**
     * Returns the age of the candidate that is always related to an optimisation
     * iteration, c.f., {@link Iteration}. If there is no age in the
     * optimisation algorithm this value defaults to {@code 1}.
     *
     * @return The age of the candidate For iteration-based approaches.
     */
    default int age() {
        return 1;
    }

    /**
     * @return The candidate's search space representation.
     */
    Properties searchSpaceRepresentation();

    /**
     * @return The optimisation value of the candidate.
     */
    OptimisationValue value();
}

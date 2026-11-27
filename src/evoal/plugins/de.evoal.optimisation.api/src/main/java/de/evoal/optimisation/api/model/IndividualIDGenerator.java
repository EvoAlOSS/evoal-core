package de.evoal.optimisation.api.model;

import java.util.concurrent.atomic.AtomicInteger;

import de.evoal.core.api.cdi.RunScoped;

/**
 * Creates the unique identifiers of the individuals in the memory model
 *   ({@link de.evoal.models.v202704.optimisation.memory.Individual#getId()}).
 *   The identifiers form a sequence starting at 0 in every run (every run has its own
 *   generator), so a run gets the same identifiers whether it is executed alone or after other
 *   runs.
 */
@RunScoped
public class IndividualIDGenerator {
    /**
     * The next identifier.
     */
    private final AtomicInteger next = new AtomicInteger();

    /**
     * @return A new unique identifier.
     */
    public int nextId() {
        return next.getAndIncrement();
    }
}

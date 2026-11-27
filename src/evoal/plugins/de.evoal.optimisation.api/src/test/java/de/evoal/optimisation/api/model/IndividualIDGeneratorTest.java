package de.evoal.optimisation.api.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndividualIDGeneratorTest {
    @Test
    public void idsFormASequence() {
        final IndividualIDGenerator generator = new IndividualIDGenerator();

        Assertions.assertEquals(0, generator.nextId());
        Assertions.assertEquals(1, generator.nextId());
        Assertions.assertEquals(2, generator.nextId());
    }

    @Test
    public void aNewGeneratorStartsAtZero() {
        // every run has its own generator
        final IndividualIDGenerator first = new IndividualIDGenerator();
        first.nextId();
        first.nextId();

        final IndividualIDGenerator second = new IndividualIDGenerator();

        Assertions.assertEquals(0, second.nextId());
    }
}

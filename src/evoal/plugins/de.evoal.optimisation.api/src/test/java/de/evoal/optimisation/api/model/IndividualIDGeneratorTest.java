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
    public void everyRunStartsAtZero() {
        final IndividualIDGenerator generator = new IndividualIDGenerator();
        generator.nextId();
        generator.nextId();

        generator.startRun();

        Assertions.assertEquals(0, generator.nextId());
    }
}

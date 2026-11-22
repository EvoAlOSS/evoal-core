package de.evoal.core.api.validation.components;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.validation.model.Validator;

/**
 * Tests the order in which the validators of a {@link ValidationComponent} run.
 */
public class ValidationComponentTest {
    private static Validator withPriority(final int priority) {
        return () -> priority;
    }

    @Test
    public void validatorsWithTheSamePriorityBothRun() {
        // given
        final Validator first = withPriority(200);
        final Validator second = withPriority(200);

        // when
        final List<Validator> ordered = ValidationComponent.order(List.of(first, second));

        // then
        Assertions.assertEquals(List.of(first, second), ordered);
    }

    @Test
    public void validatorsRunByPriorityAndKeepTheirOrderOtherwise() {
        // given: in the order of their class names
        final Validator a = withPriority(300);
        final Validator b = withPriority(100);
        final Validator c = withPriority(200);
        final Validator d = withPriority(100);

        // when
        final List<Validator> ordered = ValidationComponent.order(List.of(a, b, c, d));

        // then
        Assertions.assertEquals(List.of(b, d, c, a), ordered);
    }
}

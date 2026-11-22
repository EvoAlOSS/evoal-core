package de.evoal.core.api.interpreter;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.IntegerLiteral;
import de.evoal.languages.model.execution.CounterRange;
import de.evoal.languages.model.execution.ExecutionFactory;

/**
 * Tests the counter range of loops, {@code [start to end increment by increment]}: start and
 *   end are inclusive, and an increment that never reaches the end is rejected (#332).
 */
public class CounterRangeTest {
    private static IntegerLiteral integer(final int value) {
        final IntegerLiteral literal = ExpressionsFactory.eINSTANCE.createIntegerLiteral();
        literal.setLiteral(value);
        return literal;
    }

    private static CounterRange range(final int start, final int end, final int increment) {
        final CounterRange range = ExecutionFactory.eINSTANCE.createCounterRange();
        range.setStart(integer(start));
        range.setEnd(integer(end));
        range.setIncrement(integer(increment));
        return range;
    }

    @SuppressWarnings("unchecked")
    private static List<Integer> count(final int start, final int end, final int increment) {
        final ProgramExecutionSwitch interpreter = new ProgramExecutionSwitch(new InterpreterState());
        final Stream<Integer> values = (Stream<Integer>) interpreter.doSwitch(range(start, end, increment));

        return values.toList();
    }

    @Test
    public void bothEndsAreIncludedWhenCountingUp() {
        Assertions.assertEquals(List.of(0, 2, 4, 6, 8, 10), count(0, 10, 2));
        Assertions.assertEquals(List.of(0, 3, 6, 9), count(0, 10, 3));
    }

    @Test
    public void bothEndsAreIncludedWhenCountingDown() {
        Assertions.assertEquals(List.of(3, 2, 1, 0), count(3, 0, -1));
        Assertions.assertEquals(List.of(-1, -3, -5), count(-1, -5, -2));
    }

    @Test
    public void anEqualStartAndEndGiveOneValue() {
        Assertions.assertEquals(List.of(3), count(3, 3, 1));
        Assertions.assertEquals(List.of(3), count(3, 3, -1));
    }

    @Test
    public void theLargestIntDoesNotWrapAround() {
        Assertions.assertEquals(List.of(Integer.MAX_VALUE - 1, Integer.MAX_VALUE), count(Integer.MAX_VALUE - 1, Integer.MAX_VALUE, 1));
    }

    @Test
    public void anIncrementOfZeroIsRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> count(0, 10, 0));
        Assertions.assertEquals("The increment of the counter range [0 to 10 increment by 0] must not be 0.", e.getMessage());
    }

    @Test
    public void anIncrementAwayFromTheEndIsRejected() {
        final IllegalArgumentException up = Assertions.assertThrows(IllegalArgumentException.class, () -> count(0, 10, -1));
        Assertions.assertEquals("The counter range [0 to 10 increment by -1] counts up, so its increment must be positive.", up.getMessage());

        final IllegalArgumentException down = Assertions.assertThrows(IllegalArgumentException.class, () -> count(10, 0, 2));
        Assertions.assertEquals("The counter range [10 to 0 increment by 2] counts down, so its increment must be negative.", down.getMessage());
    }
}

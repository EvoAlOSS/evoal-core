package de.evoal.pipeline.api.values;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.interpreter.InterpreterState;

/**
 * The named values of {@link PipelineValues}.
 */
public class PipelineValuesTest {
    @Test
    public void valuesLiveInTheOutermostState() {
        final InterpreterState program = new InterpreterState();
        final InterpreterState loopBody = new InterpreterState(program);

        PipelineValues.of(loopBody).put("a", 1);

        Assertions.assertSame(PipelineValues.of(program), PipelineValues.of(loopBody));
        Assertions.assertEquals(1, PipelineValues.of(program).get("a"));
    }

    @Test
    public void aNameMayBeSetOncePerExecution() {
        final PipelineValues values = PipelineValues.of(new InterpreterState());
        values.beginExecution();
        values.put("a", 1);

        Assertions.assertThrows(IllegalStateException.class, () -> values.put("a", 2));

        values.beginExecution();
        values.put("a", 3);
        Assertions.assertEquals(3, values.get("a"));
    }

    @Test
    public void anUnknownNameIsRejected() {
        final PipelineValues values = PipelineValues.of(new InterpreterState());

        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> values.get("b"));
        Assertions.assertTrue(e.getMessage().contains("'b'"), e.getMessage());
    }
}

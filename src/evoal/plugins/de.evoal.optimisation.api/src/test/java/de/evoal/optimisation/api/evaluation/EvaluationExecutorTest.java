package de.evoal.optimisation.api.evaluation;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;

public class EvaluationExecutorTest {
    private static EvaluationExecutor withConfiguredThreads(final Object configured) throws Exception {
        final Blackboard board = Mockito.mock(Blackboard.class);
        Mockito.when(board.getOrNull(CoreBlackboardEntries.EVALUATION_THREADS)).thenReturn(configured);

        final EvaluationExecutor executor = new EvaluationExecutor();
        final Field boardField = EvaluationExecutor.class.getDeclaredField("board");
        boardField.setAccessible(true);
        boardField.set(executor, board);

        return executor;
    }

    @Test
    public void readsTheNumberOfThreads() throws Exception {
        Assertions.assertEquals(3, withConfiguredThreads("3").threads());
    }

    @Test
    public void usesTheNumberOfProcessorsByDefault() throws Exception {
        Assertions.assertEquals(Runtime.getRuntime().availableProcessors(), withConfiguredThreads(null).threads());
    }

    @Test
    public void rejectsInvalidNumbers() throws Exception {
        Assertions.assertThrows(IllegalArgumentException.class, () -> withConfiguredThreads("0").threads());
        Assertions.assertThrows(IllegalArgumentException.class, () -> withConfiguredThreads("many").threads());
    }

    @Test
    public void runsTasksOnNamedDaemonThreads() throws Exception {
        final EvaluationExecutor executor = EvaluationExecutor.withThreads(2);

        try {
            final Thread thread = executor.submit(Thread::currentThread).get();

            Assertions.assertTrue(thread.getName().startsWith("evoal-evaluation-"));
            Assertions.assertTrue(thread.isDaemon());
        } finally {
            executor.shutdown();
        }
    }
}

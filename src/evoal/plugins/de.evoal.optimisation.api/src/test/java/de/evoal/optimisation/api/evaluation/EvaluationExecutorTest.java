package de.evoal.optimisation.api.evaluation;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.Callable;

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
            final List<Callable<Thread>> tasks = List.of(Thread::currentThread, Thread::currentThread);
            for(final Thread thread : executor.invokeAll(tasks)) {
                Assertions.assertTrue(thread.getName().startsWith("evoal-evaluation-"));
                Assertions.assertTrue(thread.isDaemon());
            }
        } finally {
            executor.shutdown();
        }
    }

    @Test
    public void invokeAllReturnsTheResultsInTheOrderOfTheTasks() {
        final EvaluationExecutor executor = EvaluationExecutor.withThreads(4);

        try {
            final List<Callable<Integer>> tasks = new java.util.ArrayList<>();
            for(int i = 0; i < 50; ++i) {
                final int value = i;
                tasks.add(() -> {
                    Thread.sleep(java.util.concurrent.ThreadLocalRandom.current().nextInt(3));
                    return value;
                });
            }

            Assertions.assertEquals(java.util.stream.IntStream.range(0, 50).boxed().toList(), executor.invokeAll(tasks));
        } finally {
            executor.shutdown();
        }
    }

    @Test
    public void invokeAllThrowsTheFailureWithTheLowestIndexAfterAllTasks() {
        final EvaluationExecutor executor = EvaluationExecutor.withThreads(4);
        final java.util.concurrent.atomic.AtomicInteger finished = new java.util.concurrent.atomic.AtomicInteger();

        try {
            final List<Callable<Integer>> tasks = new java.util.ArrayList<>();
            for(int i = 0; i < 20; ++i) {
                final int value = i;
                tasks.add(() -> {
                    finished.incrementAndGet();
                    if(value == 5 || value == 12) {
                        throw new IllegalArgumentException("task-" + value);
                    }
                    return value;
                });
            }

            final IllegalArgumentException failure = Assertions.assertThrows(IllegalArgumentException.class, () -> executor.invokeAll(tasks));
            Assertions.assertEquals("task-5", failure.getMessage());
            Assertions.assertEquals("task-12", failure.getSuppressed()[0].getMessage());
            Assertions.assertEquals(20, finished.get());
        } finally {
            executor.shutdown();
        }
    }

    @Test
    public void invokeAllRunsOnTheCallingThreadWithOneThread() {
        final EvaluationExecutor executor = EvaluationExecutor.withThreads(1);

        final List<Callable<Thread>> tasks = List.of(Thread::currentThread, Thread::currentThread);
        Assertions.assertEquals(List.of(Thread.currentThread(), Thread.currentThread()), executor.invokeAll(tasks));
        Assertions.assertFalse(executor.hasThreads());
    }
}

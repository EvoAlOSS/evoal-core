package de.evoal.optimisation.api.evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.RunScoped;
import de.evoal.core.api.cdi.ScopeControl;

/**
 * The threads that evaluate the candidates of a run in parallel. The algorithms also use them
 *   for other independent work per candidate, e.g., the moves of the particles of a swarm.
 * <p>
 * The number of threads is read from {@link CoreBlackboardEntries#EVALUATION_THREADS}
 *   ({@code -Bcore:evaluation-threads=...}; the start scripts pass the environment variable
 *   {@code EVOAL_THREADS}). The default is the number of available processors. The results
 *   of a run do not depend on the number of threads.
 * <p>
 * The threads are platform daemon threads named {@code evoal-evaluation-<n>}. They are
 *   created on the first submission and stopped at the end of the run. A task runs in the
 *   scopes of the code that submitted it ({@link ScopeControl#capture()}), so it sees the
 *   run-scoped beans of its run.
 */
@RunScoped
@Slf4j
public class EvaluationExecutor {
    @Inject
    private Blackboard board;

    /**
     * Takes the scopes of the run to the threads, {@code null} for an executor with a fixed
     *   number of threads.
     */
    @Inject
    private ScopeControl scopes;

    /**
     * The number of threads, read on first use.
     */
    private int threads;

    /**
     * The threads, created on the first submission.
     */
    private ExecutorService executor;

    /**
     * Creates an executor whose number of threads is read from the blackboard.
     */
    public EvaluationExecutor() {
    }

    /**
     * Creates an executor with a fixed number of threads, e.g., for testing.
     *
     * @param threads The number of threads.
     * @return The executor.
     */
    public static EvaluationExecutor withThreads(final int threads) {
        final EvaluationExecutor executor = new EvaluationExecutor();
        executor.threads = requireValidThreadCount(threads, Integer.toString(threads));

        return executor;
    }

    /**
     * @return The number of threads (at least 1).
     */
    public int threads() {
        if(threads == 0) {
            threads = readThreadCount();
            log.info("Evaluating with up to {} thread(s).", threads);
        }

        return threads;
    }

    /**
     * Submits a task to the threads, which are created on the first submission.
     *
     * @param task The task.
     * @return The future of the task.
     */
    private <T> Future<T> submit(final Callable<T> task) {
        if(executor == null) {
            executor = Executors.newFixedThreadPool(threads(), new EvaluationThreadFactory());
        }

        return executor.submit(task);
    }

    /**
     * Runs the tasks and waits until all of them have ended. With one thread, the tasks run
     *   one after another on the calling thread, otherwise on the threads of the run, in the
     *   scopes of the calling code.
     *
     * @param tasks The independent tasks.
     * @return The results of the tasks, in the order of the tasks.
     * @throws RuntimeException the failure of the task with the lowest index, after all tasks
     *   have ended. The failures of the other tasks are suppressed exceptions of it. A
     *   checked exception is wrapped in an {@link IllegalStateException}.
     */
    public <T> List<T> invokeAll(final List<? extends Callable<T>> tasks) {
        final List<Result<T>> results = new ArrayList<>(tasks.size());

        if(tasks.size() <= 1 || threads() <= 1) {
            tasks.forEach(task -> results.add(Result.of(task)));
        } else {
            final ScopeControl.Bindings bindings = scopes == null ? null : scopes.capture();
            final List<Future<Result<T>>> futures = new ArrayList<>(tasks.size());
            tasks.forEach(task -> futures.add(submit(() -> bindings == null ? Result.of(task) : bindings.call(() -> Result.of(task)))));
            futures.forEach(future -> results.add(await(future)));
        }

        Throwable failure = null;
        final List<T> values = new ArrayList<>(results.size());
        for(final Result<T> result : results) {
            if(result.failure() == null) {
                values.add(result.value());
            } else if(failure == null) {
                failure = result.failure();
            } else {
                failure.addSuppressed(result.failure());
            }
        }

        if(failure instanceof RuntimeException exception) {
            throw exception;
        }
        if(failure instanceof Error error) {
            throw error;
        }
        if(failure != null) {
            throw new IllegalStateException("A task failed.", failure);
        }

        return values;
    }

    /**
     * Waits for a task. The tasks catch their failures, so the future only fails if the
     *   thread is interrupted.
     */
    private static <T> Result<T> await(final Future<Result<T>> future) {
        try {
            return future.get();
        } catch(final InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for a task.", e);
        } catch(final ExecutionException e) {
            throw new IllegalStateException("A task ended unexpectedly.", e.getCause());
        }
    }

    /**
     * Stops the threads at the end of the run.
     */
    @PreDestroy
    public void shutdown() {
        if(executor != null) {
            executor.shutdownNow();
            executor = null;
        }
    }

    /**
     * @return {@code true} iff threads have been created and not yet stopped.
     */
    boolean hasThreads() {
        return executor != null;
    }

    private int readThreadCount() {
        final Object configured = board.getOrNull(CoreBlackboardEntries.EVALUATION_THREADS);

        if(configured == null || configured.toString().isBlank()) {
            return Runtime.getRuntime().availableProcessors();
        }

        try {
            final int value = configured instanceof Number number ? number.intValue() : Integer.parseInt(configured.toString().trim());
            return requireValidThreadCount(value, configured.toString());
        } catch(final NumberFormatException e) {
            throw new IllegalArgumentException("The value of " + CoreBlackboardEntries.EVALUATION_THREADS + " is not a number: " + configured, e);
        }
    }

    private static int requireValidThreadCount(final int value, final String configured) {
        if(value < 1) {
            throw new IllegalArgumentException("The value of " + CoreBlackboardEntries.EVALUATION_THREADS + " has to be at least 1: " + configured);
        }

        return value;
    }

    /**
     * The result of a task: either its value or its failure.
     */
    private record Result<T>(T value, Throwable failure) {
        static <T> Result<T> of(final Callable<T> task) {
            try {
                return new Result<>(task.call(), null);
            } catch(final Exception | Error e) {
                return new Result<>(null, e);
            }
        }
    }

    /**
     * Creates the named daemon threads.
     */
    private static final class EvaluationThreadFactory implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger();

        @Override
        public Thread newThread(final Runnable runnable) {
            return Thread.ofPlatform()
                         .name("evoal-evaluation-" + counter.getAndIncrement())
                         .daemon(true)
                         .unstarted(runnable);
        }
    }
}

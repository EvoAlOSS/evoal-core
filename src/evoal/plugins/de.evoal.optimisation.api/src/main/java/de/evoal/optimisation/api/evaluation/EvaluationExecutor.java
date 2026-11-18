package de.evoal.optimisation.api.evaluation;

import java.util.concurrent.Callable;
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

/**
 * The threads that evaluate the candidates of a run in parallel.
 * <p>
 * The number of threads is read from {@link CoreBlackboardEntries#EVALUATION_THREADS}
 *   ({@code -Bcore:evaluation-threads=...}; the start scripts pass the environment variable
 *   {@code EVOAL_THREADS}). The default is the number of available processors. The results
 *   of a run do not depend on the number of threads.
 * <p>
 * The threads are platform daemon threads named {@code evoal-evaluation-<n>}. They are
 *   created on the first submission and stopped at the end of the run.
 */
@RunScoped
@Slf4j
public class EvaluationExecutor {
    @Inject
    private Blackboard board;

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
     * Submits a task to the threads.
     *
     * @param task The task.
     * @return The future of the task.
     */
    public <T> Future<T> submit(final Callable<T> task) {
        if(executor == null) {
            executor = Executors.newFixedThreadPool(threads(), new EvaluationThreadFactory());
        }

        return executor.submit(task);
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

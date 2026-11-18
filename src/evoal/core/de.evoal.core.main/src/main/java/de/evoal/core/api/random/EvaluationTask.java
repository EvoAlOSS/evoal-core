package de.evoal.core.api.random;

import java.util.Optional;

/**
 * The evaluation that the current thread computes. The evaluating code binds it around the
 *   call of the optimisation function ({@link #call}); {@link RandomService#taskRandom(String)}
 *   derives its generators from it.
 * <p>
 * The context is a {@link ScopedValue}: it is visible only on the thread that binds it and
 *   only for the duration of the call, so parallel evaluations on different threads have
 *   different contexts.
 *
 * @param run The run of the evaluation ({@link RandomService#getRun()}).
 * @param index The index of the evaluation within the run. The indices are assigned in
 *   submission order on the thread that runs the algorithm, so they do not depend on the
 *   thread that computes the evaluation.
 */
public record EvaluationTask(long run, long index) {
    /**
     * The evaluation of the current thread.
     */
    private static final ScopedValue<EvaluationTask> CURRENT = ScopedValue.newInstance();

    /**
     * Calls the operation with this evaluation as the current one.
     *
     * @param operation The operation, e.g., the call of the optimisation function.
     * @return The result of the operation.
     */
    public <R, X extends Throwable> R call(final ScopedValue.CallableOp<? extends R, X> operation) throws X {
        return ScopedValue.where(CURRENT, this).call(operation);
    }

    /**
     * @return The evaluation of the current thread, or empty outside an evaluation.
     */
    public static Optional<EvaluationTask> current() {
        return CURRENT.isBound() ? Optional.of(CURRENT.get()) : Optional.empty();
    }
}

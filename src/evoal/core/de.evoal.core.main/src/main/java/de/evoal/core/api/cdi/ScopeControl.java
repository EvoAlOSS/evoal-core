package de.evoal.core.api.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;

import de.evoal.core.main.cdi.ScopeExtension;
import de.evoal.core.main.cdi.ScopedValueContext;

/**
 * Opens the {@link EvaluationScoped} and {@link RunScoped} scopes. A scope is open while its
 *   body runs ({@link #inEvaluation}, {@link #inRun}); when the body ends, normally or by an
 *   exception, the beans of the scope are destroyed and their {@code @PreDestroy} methods are
 *   called.
 * <p>
 * The scopes belong to the code of the body, not to a thread. Code that hands work of the
 *   body to other threads takes the open scopes along ({@link #capture()}). Scopes can be
 *   nested, e.g., an inner optimisation in an evaluation of an outer one: the inner scope has
 *   its own beans while its body runs, and the outer beans are visible again afterwards.
 */
@ApplicationScoped
public class ScopeControl {
    @Inject
    private BeanManager beanManager;

    /**
     * Runs the body in a new evaluation.
     *
     * @param body The runs of the evaluation.
     * @throws X the exception of the body.
     */
    public <X extends Throwable> void inEvaluation(final Body<X> body) throws X {
        inScope(extension().getEvaluationContext(), 0, body);
    }

    /**
     * Runs the body in a new run of the current evaluation.
     *
     * @param number The number of the run; it determines the random numbers of the run.
     * @param body The run.
     * @throws IllegalStateException if no evaluation is open.
     * @throws X the exception of the body.
     */
    public <X extends Throwable> void inRun(final long number, final Body<X> body) throws X {
        if(!isEvaluationActive()) {
            throw new IllegalStateException("Run " + number + " has to belong to an evaluation, but no evaluation is open.");
        }

        inScope(extension().getRunContext(), number, body);
    }

    /**
     * @return {@code true} iff an evaluation is open for the current code.
     */
    public boolean isEvaluationActive() {
        return extension().getEvaluationContext().isActive();
    }

    /**
     * @return {@code true} iff a run is open for the current code.
     */
    public boolean isRunActive() {
        return extension().getRunContext().isActive();
    }

    /**
     * @return The number of the current run.
     * @throws IllegalStateException if no run is open.
     */
    public long runNumber() {
        return extension().getRunContext()
                          .current()
                          .orElseThrow(() -> new IllegalStateException("No run is open."))
                          .number();
    }

    /**
     * @return The scopes that are open for the current code, to open them on another thread.
     */
    public Bindings capture() {
        final ScopeExtension extension = extension();

        return new Bindings(extension.getEvaluationContext(),
                            extension.getEvaluationContext().current().orElse(null),
                            extension.getRunContext(),
                            extension.getRunContext().current().orElse(null));
    }

    private static <X extends Throwable> void inScope(final ScopedValueContext context, final long number, final Body<X> body) throws X {
        final ScopedValueContext.Instance instance = context.open(number);

        context.where(null, instance).call(() -> {
            try {
                body.run();
            } finally {
                ScopedValueContext.close(instance);
            }
            return null;
        });
    }

    private ScopeExtension extension() {
        return beanManager.getExtension(ScopeExtension.class);
    }

    /**
     * The body of a scope.
     *
     * @param <X> The exception the body may throw.
     */
    @FunctionalInterface
    public interface Body<X extends Throwable> {
        /**
         * Runs the body.
         *
         * @throws X the exception of the body.
         */
        void run() throws X;
    }

    /**
     * The scopes that were open when they were captured ({@link #capture()}).
     */
    public static final class Bindings {
        private final ScopedValueContext evaluationContext;
        private final ScopedValueContext.Instance evaluation;
        private final ScopedValueContext runContext;
        private final ScopedValueContext.Instance run;

        private Bindings(final ScopedValueContext evaluationContext,
                         final ScopedValueContext.Instance evaluation,
                         final ScopedValueContext runContext,
                         final ScopedValueContext.Instance run) {
            this.evaluationContext = evaluationContext;
            this.evaluation = evaluation;
            this.runContext = runContext;
            this.run = run;
        }

        /**
         * Calls the operation in the captured scopes, e.g., on a thread that evaluates a
         *   candidate of the run. The scopes stay open after the call.
         *
         * @param operation The operation.
         * @return The result of the operation.
         * @throws X the exception of the operation.
         */
        public <R, X extends Throwable> R call(final ScopedValue.CallableOp<? extends R, X> operation) throws X {
            ScopedValue.Carrier carrier = null;
            if(evaluation != null) {
                carrier = evaluationContext.where(carrier, evaluation);
            }
            if(run != null) {
                carrier = runContext.where(carrier, run);
            }

            return carrier == null ? operation.call() : carrier.call(operation);
        }
    }
}

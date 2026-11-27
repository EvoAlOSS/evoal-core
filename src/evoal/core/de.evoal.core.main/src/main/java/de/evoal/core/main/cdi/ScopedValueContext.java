package de.evoal.core.main.cdi;

import java.lang.annotation.Annotation;
import java.util.Optional;

import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.inject.spi.BeanManager;

import org.apache.deltaspike.core.util.context.AbstractContext;
import org.apache.deltaspike.core.util.context.ContextualStorage;

import de.evoal.core.api.cdi.EvaluationScoped;
import de.evoal.core.api.cdi.RunScoped;

/**
 * A CDI context whose beans belong to a scope instance (an evaluation or a run), not to a
 *   thread. The current instance is a {@link ScopedValue}: the code that opens the scope binds
 *   it around its body, and code that hands work to other threads binds the same instance
 *   there ({@link de.evoal.core.api.cdi.ScopeControl#capture()}). So all threads of a run see
 *   the same beans, and a nested scope binds its own instance without affecting the
 *   instances bound on other threads.
 * <p>
 * The subclasses name the scope as a constant ({@link #getScope()}), because the constructor
 *   of {@link AbstractContext} already asks for it.
 */
public abstract class ScopedValueContext extends AbstractContext {
    /**
     * The scope instance bound on the current thread.
     */
    private final ScopedValue<Instance> current = ScopedValue.newInstance();

    private final BeanManager beanManager;

    /**
     * @param beanManager The bean manager of the container.
     */
    protected ScopedValueContext(final BeanManager beanManager) {
        super(beanManager);
        this.beanManager = beanManager;
    }

    /**
     * @return The context of the {@link EvaluationScoped} scope.
     */
    public static ScopedValueContext forEvaluations(final BeanManager beanManager) {
        return new ScopedValueContext(beanManager) {
            @Override
            public Class<? extends Annotation> getScope() {
                return EvaluationScoped.class;
            }
        };
    }

    /**
     * @return The context of the {@link RunScoped} scope.
     */
    public static ScopedValueContext forRuns(final BeanManager beanManager) {
        return new ScopedValueContext(beanManager) {
            @Override
            public Class<? extends Annotation> getScope() {
                return RunScoped.class;
            }
        };
    }

    @Override
    public boolean isActive() {
        return current.isBound();
    }

    @Override
    protected ContextualStorage getContextualStorage(final Contextual<?> contextual, final boolean createIfNotExist) {
        return current.isBound() ? current.get().storage() : null;
    }

    /**
     * @return The scope instance bound on the current thread, empty if the scope is not active.
     */
    public Optional<Instance> current() {
        return current.isBound() ? Optional.of(current.get()) : Optional.empty();
    }

    /**
     * Creates a new scope instance without beans. Its beans can be used by several threads.
     *
     * @param number The number of the instance, e.g., the number of a run.
     * @return The instance.
     */
    public Instance open(final long number) {
        return new Instance(number, new ContextualStorage(beanManager, true, false));
    }

    /**
     * Adds the binding of an instance to a carrier.
     *
     * @param carrier The carrier of other bindings, {@code null} for none.
     * @param instance The instance to bind.
     * @return The carrier with the binding.
     */
    public ScopedValue.Carrier where(final ScopedValue.Carrier carrier, final Instance instance) {
        return carrier == null ? ScopedValue.where(current, instance) : carrier.where(current, instance);
    }

    /**
     * Destroys the beans of an instance and calls their {@code @PreDestroy} methods.
     *
     * @param instance The instance.
     */
    public static void close(final Instance instance) {
        AbstractContext.destroyAllActive(instance.storage());
    }

    /**
     * An instance of the scope: one evaluation or one run.
     *
     * @param number The number of the instance, e.g., the number of a run.
     * @param storage The beans of the instance.
     */
    public record Instance(long number, ContextualStorage storage) {
    }
}

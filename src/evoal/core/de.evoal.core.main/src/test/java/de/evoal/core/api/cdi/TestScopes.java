package de.evoal.core.api.cdi;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Supplier;

import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.BeanManager;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import de.evoal.core.main.cdi.ScopeExtension;
import de.evoal.core.main.cdi.ScopedValueContext;

/**
 * The evaluation and run contexts with a {@link ScopeControl}, without a CDI container
 *   (Weld SE cannot be started in the module-path tests). Beans are mocked
 *   {@link Contextual}s; {@link #get} looks up the instance as the client proxy of a bean
 *   would.
 */
public final class TestScopes {
    private final ScopeExtension extension = new ScopeExtension();

    private final ScopeControl control = new ScopeControl();

    public TestScopes() throws ReflectiveOperationException {
        final BeanManager beanManager = Mockito.mock(BeanManager.class);
        Mockito.when(beanManager.getExtension(ScopeExtension.class)).thenReturn(extension);
        // as Weld, the bean manager rejects a context without a scope
        Mockito.when(beanManager.isPassivatingScope(ArgumentMatchers.isNull()))
               .thenThrow(new NullPointerException("The context has no scope."));

        final Method afterBeanDiscovery = ScopeExtension.class.getDeclaredMethod("afterBeanDiscovery", AfterBeanDiscovery.class, BeanManager.class);
        afterBeanDiscovery.setAccessible(true);
        afterBeanDiscovery.invoke(extension, Mockito.mock(AfterBeanDiscovery.class), beanManager);

        final Field beanManagerField = ScopeControl.class.getDeclaredField("beanManager");
        beanManagerField.setAccessible(true);
        beanManagerField.set(control, beanManager);
    }

    /**
     * @return The control of the scopes.
     */
    public ScopeControl control() {
        return control;
    }

    /**
     * @return The context of the evaluations.
     */
    public ScopedValueContext evaluationContext() {
        return extension.getEvaluationContext();
    }

    /**
     * @return The context of the runs.
     */
    public ScopedValueContext runContext() {
        return extension.getRunContext();
    }

    /**
     * @return The current instance of the bean in the context.
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(final ScopedValueContext context, final Contextual<T> bean) {
        final CreationalContext<T> creationalContext = Mockito.mock(CreationalContext.class);
        return context.get(bean, creationalContext);
    }

    /**
     * @return A bean whose instances are created by the supplier; its destructions can be
     *   verified with Mockito.
     */
    @SuppressWarnings("unchecked")
    public static <T> Contextual<T> bean(final Supplier<T> supplier) {
        final Contextual<T> bean = Mockito.mock(Contextual.class);
        Mockito.when(bean.create(ArgumentMatchers.any())).thenAnswer(invocation -> supplier.get());

        return bean;
    }
}

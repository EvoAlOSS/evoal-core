package de.evoal.core.api.cdi;

import java.lang.reflect.Field;

import jakarta.enterprise.context.ContextNotActiveException;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.spi.AfterBeanDiscovery;
import jakarta.enterprise.inject.spi.BeanManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import de.evoal.core.main.cdi.RunContext;
import de.evoal.core.main.cdi.RunScopeExtension;

public class RunScopeControlTest {
    private final RunScopeControl control = new RunScopeControl();

    private RunContext context;

    @SuppressWarnings("unchecked")
    private final Contextual<Object> bean = Mockito.mock(Contextual.class);

    @SuppressWarnings("unchecked")
    private final CreationalContext<Object> creationalContext = Mockito.mock(CreationalContext.class);

    @BeforeEach
    public void registerContext() throws Exception {
        final BeanManager beanManager = Mockito.mock(BeanManager.class);
        final RunScopeExtension extension = new RunScopeExtension();
        final java.lang.reflect.Method afterBeanDiscovery = RunScopeExtension.class.getDeclaredMethod("afterBeanDiscovery", AfterBeanDiscovery.class, BeanManager.class);
        afterBeanDiscovery.setAccessible(true);
        afterBeanDiscovery.invoke(extension, Mockito.mock(AfterBeanDiscovery.class), beanManager);
        Mockito.when(beanManager.getExtension(RunScopeExtension.class)).thenReturn(extension);

        final Field beanManagerField = RunScopeControl.class.getDeclaredField("beanManager");
        beanManagerField.setAccessible(true);
        beanManagerField.set(control, beanManager);

        context = extension.getRunContext();
        Mockito.when(bean.create(ArgumentMatchers.any())).thenAnswer(invocation -> new Object());
    }

    @AfterEach
    public void stopRun() {
        control.stop();
    }

    @Test
    public void runScopedBeansNeedAnActiveScope() {
        Assertions.assertFalse(control.isActive());
        Assertions.assertThrows(ContextNotActiveException.class, () -> context.get(bean, creationalContext));
    }

    @Test
    public void aRunScopedBeanLivesUntilTheEndOfTheRun() {
        // given
        control.start();
        final Object first = context.get(bean, creationalContext);

        // when
        final Object second = context.get(bean, creationalContext);
        control.stop();

        // then
        Assertions.assertSame(first, second);
        Mockito.verify(bean).destroy(ArgumentMatchers.same(first), ArgumentMatchers.any());
        Assertions.assertFalse(control.isActive());
    }

    @Test
    public void everyRunGetsANewInstance() {
        // given
        control.start();
        final Object first = context.get(bean, creationalContext);
        control.stop();

        // when
        control.start();
        final Object second = context.get(bean, creationalContext);

        // then
        Assertions.assertNotSame(first, second);
    }

    @Test
    public void theScopeIsNotActiveOnOtherThreads() throws Exception {
        // given
        control.start();
        final boolean[] active = { true };

        // when
        final Thread thread = new Thread(() -> active[0] = control.isActive());
        thread.start();
        thread.join();

        // then
        Assertions.assertFalse(active[0]);
    }
}

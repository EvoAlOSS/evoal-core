package de.evoal.core.main.cdi;

import de.evoal.core.api.cdi.RunScoped;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.inject.spi.BeanManager;
import org.apache.deltaspike.core.util.context.AbstractContext;
import org.apache.deltaspike.core.util.context.ContextualStorage;
import java.lang.annotation.Annotation;

public class RunContext extends AbstractContext {

    private final ThreadLocal<ContextualStorage> storageHolder = new ThreadLocal<>();
    private final BeanManager beanManager;

    public RunContext(BeanManager beanManager) {
        super(beanManager);
        this.beanManager = beanManager;
    }

    @Override
    public Class<? extends Annotation> getScope() {
        return RunScoped.class;
    }

    @Override
    public boolean isActive() {
        return storageHolder.get() != null;
    }

    @Override
    protected ContextualStorage getContextualStorage(Contextual<?> contextual, boolean createIfNotExist) {
        return storageHolder.get();
    }

    public void startRun() {
        if (storageHolder.get() != null) {
            throw new IllegalStateException("RunScoped context is already active on this thread");
        }
        storageHolder.set(new ContextualStorage(beanManager, false, false));
    }

    public void stopRun() {
        if (storageHolder.get() != null) {
            destroyAllActive(); // inherited from AbstractContext — calls @PreDestroy/disposers
            storageHolder.remove();
        }
    }
}
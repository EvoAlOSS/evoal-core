package de.evoal.core.api.cdi;

import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.enterprise.inject.spi.Bean;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Deltaspike wrapper for reducing dependencies in extension.
 */
@Slf4j
public final class BeanFactory {
    private BeanFactory() {
    }

    public static <T> T create(final Class<T> type) {
        Requirements.requireNotNull(type);

        log.info("Creating bean of type {}.", type);
        try {
            return BeanProvider.getContextualReference(type);
        } catch(final IllegalStateException | IllegalArgumentException e) {
            log.error("Failed to create contextual reference of type '{}'.", type, e);

            logInstantiationError(type, e);
            throw e;
        }
    }

    private static <T> void logInstantiationError(Class<T> type, RuntimeException e) {
        final Set<Bean<T>> beans = BeanProvider.getBeanDefinitions(type, true, true);

        final String existingBeans = beans.stream().map(Bean::getName).collect(Collectors.joining(", "));
        log.error("  existing beans are: {}", existingBeans);
    }

    /**
     * Returns an instance of the given {@code type} and the given {@code name}.
     * If necessary, the instance is created.
     *
     * @param name Name of the instance.
     * @param type Type of the instance
     * @param <T> The actual type
     * @return A valid instance
     */
    public static <T> T create(final String name, final Class<T> type) {
        Requirements.requireNotNull(name);
        Requirements.requireNotNull(type);

        log.info("Creating bean of type {} with name {}.", type, name);

        try {
            return BeanProvider.getContextualReference(name, false, type);
        } catch(final IllegalStateException | IllegalArgumentException e) {
            log.error("Failed to create contextual reference of type '{}' with name '{}'.", type, name);
            logInstantiationError(type, e);
            throw e;
        }
    }

    public static <T extends EvoalComponent<T>> T createComponent(final Class<T> type, final Instance configuration) {
        Requirements.requireNotNull(type);
        Requirements.requireNotNull(configuration);

        final String name = configuration.getDefinition().getName();

        log.info("Creating bean for instance of type {}.", name);
        try {
            return BeanProvider.getContextualReference(name, false, type)
                               .init(configuration);
        } catch(final IllegalStateException | IllegalArgumentException e) {
            log.error("Failed to create contextual reference of type '{}' with name '{}'.", type, name);
            logInstantiationError(type, e);
            throw e;
        }
    }

    public static void injectFields(final Object instance) {
        BeanProvider.injectFields(instance);
    }
}

package de.evoal.core.api.cdi;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.api.validation.model.Validator;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.util.FQNProvider;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.enterprise.inject.spi.Bean;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Deltaspike wrapper for reducing dependencies in extensions.
 */
@Slf4j
public final class BeanFactory {
    /**
     * For generating fully qualified names.
     */
    private final static FQNProvider fqName = new FQNProvider();

    private BeanFactory() {
    }

    /**
     * Creates bean of the given {@code type}.
     *
     * @param type Class of the bean type.
     * @return A valid bean instance.
     *
     * @param <T> Type literal of the bean.
     */
    public static <T> @NonNull T create(final Class<T> type) {
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

    private static <T> void logInstantiationError(Class<T> type, Exception e) {
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

        log.info("Creating bean of type '{}' with name '{}'.", type, name);

        try {
            return BeanProvider.getContextualReference(name, false, type);
        } catch(final IllegalStateException | IllegalArgumentException e) {
            log.error("Failed to create contextual reference of type '{}' with name '{}'.", type, name);
            logInstantiationError(type, e);
            throw e;
        }
    }

    public static <T extends EvoalComponent<T>> T createComponent(final Class<T> type, final String name, final Instance configuration) {
        Requirements.requireNotNull(configuration);

        try {
            return create(name, type)
                    .init(configuration);
        } catch (final InitializationException e) {
            log.error("Failed to create contextual reference of type '{}' with name '{}'.", type, name);
            logInstantiationError(type, e);

            throw new RuntimeException("Failed to instantiate component due to an error.", e);
        }
    }

    public static <T extends EvoalComponent<T>> T createComponent(final Class<T> type, final String name, final Instance configuration, final Consumer<T> preInit) {
        Requirements.requireNotNull(preInit);

        try {
            final T instance = create(name, type);
            preInit.accept(instance);
            instance.init(configuration);

            return instance;
        } catch (final InitializationException e) {
            log.error("Failed to create contextual reference of type '{}' with name '{}'.", type, name);
            logInstantiationError(type, e);

            throw new RuntimeException("Failed to instantiate component due to an error.", e);
        }
    }

    public static <T extends EvoalComponent<T>> T createComponent(final Class<T> type, final Instance configuration, final String suffix, final Consumer<T> preInit) {
        Requirements.requireNotNull(preInit);
        final String name = fqName.get(configuration) + suffix;

        try {
            final T instance = create(name, type);
            preInit.accept(instance);
            instance.init(configuration);

            return instance;
        } catch (final InitializationException e) {
            log.error("Failed to create contextual reference of type '{}' with name '{}'.", type, name);
            logInstantiationError(type, e);

            throw new RuntimeException("Failed to instantiate component due to an error.", e);
        }
    }

    public static <T extends EvoalComponent<T>> T createComponent(final Class<T> type, final Instance configuration) {
        Requirements.requireNotNull(configuration);

        final String name = fqName.get(configuration);

        return createComponent(type, name, configuration);
    }

    public static <T extends EvoalComponent<T>> T createComponent(final Class<T> type, final Instance configuration, final Consumer<T> preInit) {
        Requirements.requireNotNull(configuration);

        final String name = fqName.get(configuration);

        return createComponent(type, name, configuration, preInit);
    }

    public static <T extends EvoalComponent<T>> T createComponent(final Class<T> type, final Instance configuration, final String nameSuffix) {
        Requirements.requireNotNull(configuration);

        final String name = fqName.get(configuration) + nameSuffix;

        return createComponent(type, name, configuration);
    }

    public static <S extends EvoalComponent<S>, T extends EvoalComponentProvider<S>> S createComponent(final Class<S> type, final Class<T> provider, final Instance configuration) {
        Requirements.requireNotNull(type);
        Requirements.requireNotNull(configuration);

        final String name = fqName.get(configuration);
        Requirements.requireNotNull(name);

        log.info("Creating bean for instance of type {}.", name);
        try {
            log.info("Testing component provider of type {} with name {}.", provider, name);
            return BeanProvider.getContextualReference(name, false, provider)
                    .create(configuration)
                    .init(configuration);
        } catch (final IllegalStateException | IllegalArgumentException | InitializationException e) {
            log.error("Failed to create contextual reference of type '{}' with name '{}'.", provider, name);
            logInstantiationError(provider, e);

            return createComponent(type, configuration);
        }
    }

    public static <T extends EvoalComponent<T>> T createComponentForAttribute(final Class<T> type, final Instance configuration, final String attributeName) {
        final AttributeHelper helper = BeanFactory.create(AttributeHelper.class);
        final Instance child = helper.lookup(configuration, attributeName);

        return createComponent(type, child);
    }

    public static <T> T injectFields(final T instance) {
        return BeanProvider.injectFields(instance);
    }

    public static <T extends Validator> Collection<? extends T> createComponents(final Class<T> clazz) {
        return BeanProvider.getBeanDefinitions(clazz, true, true)
                .stream()
                .peek(b -> log.info("Creating bean for instance of type {}.", b.getName()))
                .map(bean -> BeanProvider.getContextualReference(clazz, bean))
                .collect(Collectors.toUnmodifiableList());
    }
}

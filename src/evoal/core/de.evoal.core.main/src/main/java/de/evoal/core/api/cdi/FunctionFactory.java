package de.evoal.core.api.cdi;

import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.dl.util.FQNProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * Deltaspike wrapper for reducing dependencies in extension.
 */
@Slf4j
public final class FunctionFactory {
    /**
     * For generating fully qualified names.
     */
    private final static FQNProvider fqName = new FQNProvider();

    private FunctionFactory() {
    }

    public static <T extends EvoalBuiltinFunction<T>> T createBuiltinFunction(final Class<T> type, final FunctionDefinition definition) {
        final String name = new FQNProvider().get(definition);

        log.info("Creating EvoAl builtin function {}", name);

        return BeanFactory.create(name, type);
    }
}

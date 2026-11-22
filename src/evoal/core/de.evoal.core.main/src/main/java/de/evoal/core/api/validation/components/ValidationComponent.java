package de.evoal.core.api.validation.components;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.validation.model.Validator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Base class for validation components.
 *
 * @param <T> The validator category
 */
@Slf4j
public abstract class ValidationComponent<T extends Validator> {
    /**
     * The validators in the order in which they run: by priority, validators with the same
     *   priority by the name of their class.
     */
    protected final List<T> validators = new ArrayList<>();

    protected void loadValidators(final @NonNull Class<T> clazz) {
        validators.addAll(order(BeanFactory.createComponents(clazz)));
        log.info("Found {} validators: {}.",
                 validators.size(),
                 validators.stream()
                           .map(v -> nameOf(v) + " (" + v.priority() + ")")
                           .collect(Collectors.joining(", ")));
    }

    /**
     * @return The simple class name of a validator without the suffix of a CDI client proxy,
     *   e.g. {@code AttributeExistsValidator} for
     *   {@code AttributeExistsValidator$Proxy$_$$_WeldClientProxy}.
     */
    private static String nameOf(final Validator validator) {
        final String name = validator.getClass().getSimpleName();
        final int proxy = name.indexOf("$Proxy$");

        return proxy < 0 ? name : name.substring(0, proxy);
    }

    /**
     * Sorts validators by their priority. The sort is stable: validators with the same priority
     *   keep their order, which is the order of their class names (see
     *   {@link BeanFactory#createComponents(Class)}). No validator is dropped.
     *
     * @param validators The validators, ordered by the name of their class.
     * @return The validators in the order in which they run.
     */
    static <T extends Validator> List<T> order(final @NonNull Collection<? extends T> validators) {
        final List<T> ordered = new ArrayList<>(validators);
        ordered.sort(Comparator.comparingInt(Validator::priority));

        return ordered;
    }
}

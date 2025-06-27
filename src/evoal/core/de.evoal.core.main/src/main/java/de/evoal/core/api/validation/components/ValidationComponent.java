package de.evoal.core.api.validation.components;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.validation.model.Validator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Base class for validation components.
 *
 * @param <T> The validator category
 */
@Slf4j
public abstract class ValidationComponent<T extends Validator> {
    protected final SortedSet<T> validators = new TreeSet<>(Comparator.comparingInt(Validator::priority));

    protected void loadValidators(final @NonNull Class<T> clazz) {
        validators.addAll(BeanFactory.createComponents(clazz));
        log.info("Found {} validators.", validators.size());
    }
}

package de.evoal.core.main.ea.gene;

import io.jenetics.Gene;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public abstract class DynamicGene<T> implements Gene<Object, DynamicGene<T>> {

    private T data;

    protected DynamicGene(final T data) {
        this.data =(T) data;
    }

    /**
     * @return
     */
    @Override
    public Object allele() {
        return data;
    }

    /**
     * @param data
     * @return
     */
    @Override
    public DynamicGene<T> newInstance(final Object data) {
        try {
            return this.getClass()
                       .getConstructor(Object.class)
                       .newInstance(data);
        } catch (final Exception e) {
            log.error("Failed to create new instance of gene: {}.", this, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @return
     */
    @Override
    public boolean isValid() {
        return isValidValue(data);
    }

    /**
     * Checks if the given value is a valid one for this gene.
     *
     * @param value The value to check.
     * @return iff the value is valid.
     */
    protected abstract boolean isValidValue(final T value);
}


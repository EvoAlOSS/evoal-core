package de.evoal.core.api.validation.model;

/**
 * Base interface for all validators.
 */
public interface Validator {
    /**
     * @return The validator's priority.
     */
    public int priority();
}

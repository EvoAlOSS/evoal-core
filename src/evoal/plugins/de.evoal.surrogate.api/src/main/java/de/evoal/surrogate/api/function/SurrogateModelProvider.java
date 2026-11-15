package de.evoal.surrogate.api.function;

/**
 * Implemented by optimisation functions that are backed by a trained surrogate model.
 *   Fitness decorators use it for accessing the model and the information that was
 *   stored together with it (e.g., goodness-of-fit data).
 */
public interface SurrogateModelProvider {
    /**
     * @return The loaded surrogate model, including its reader.
     */
    ModelFunctionData getModelFunctionData();
}

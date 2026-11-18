package de.evoal.surrogate.adaption;

import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.SurrogateModelProvider;
import de.evoal.surrogate.api.io.ModelReader;
import lombok.NonNull;

/**
 * Finds the surrogate model behind an optimisation function: the function itself or a
 *   function wrapped by decorators.
 */
public final class SurrogateLookup {
    private SurrogateLookup() {
    }

    /**
     * Follows the decorated functions until a function backed by a surrogate model is found.
     *
     * @param function The (decorated) optimisation function.
     * @return The surrogate model.
     *
     * @throws IllegalStateException if the chain does not contain a surrogate model.
     */
    public static ModelFunctionData find(final @NonNull OptimisationFunction function) {
        OptimisationFunction current = function;

        while(current instanceof OptimisationFunctionDecorator decorator) {
            if(decorator instanceof SurrogateModelProvider provider) {
                return provider.getModelFunctionData();
            }

            current = decorator.getDecoratedFunction();
        }

        if(current instanceof SurrogateModelProvider provider) {
            return provider.getModelFunctionData();
        }

        throw new IllegalStateException("The decorated function has to be a surrogate function, but is '" + current + "'.");
    }

    /**
     * Returns the reader of the surrogate model that is wrapped by the given function.
     *
     * @param function The (decorated) optimisation function.
     * @return The reader of the surrogate model.
     *
     * @throws IllegalStateException if there is no surrogate model or it has no reader.
     */
    public static ModelReader findReader(final @NonNull OptimisationFunction function) {
        return find(function).reader()
                             .orElseThrow(() -> new IllegalStateException("The surrogate model has no reader for its stored information."));
    }
}

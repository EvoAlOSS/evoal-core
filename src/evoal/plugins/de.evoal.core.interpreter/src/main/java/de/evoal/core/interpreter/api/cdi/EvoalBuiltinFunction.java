package de.evoal.core.interpreter.api.cdi;

import de.evoal.core.interpreter.api.InterpreterState;

import java.util.Optional;

/**
 * Base for built-in functions.
 */
public interface EvoalBuiltinFunction<T extends EvoalBuiltinFunction<T>> {
    /**
     * Is executed for calling the builtin function.
     *
     * @param context The execution context.
     * @param arguments The actual arguments.
     * @return The function result. Return Optional.empty() if you do not want to return a value.
     */
    public Optional<Object> call(final InterpreterState context, final Object[] arguments);
}

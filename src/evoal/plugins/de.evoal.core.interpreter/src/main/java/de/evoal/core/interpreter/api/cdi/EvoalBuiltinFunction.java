package de.evoal.core.interpreter.api.cdi;

import de.evoal.core.interpreter.api.InterpreterState;

/**
 * Base for built-in functions.
 */
public interface EvoalBuiltinFunction<T extends EvoalBuiltinFunction<T>> {
    public Object call(final InterpreterState context, final Object[] arguments);
}

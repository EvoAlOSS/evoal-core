package de.evoal.surrogate.main.internal;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The interpreter state. The state binds variables to values.
 */
public class InterpreterState {
    /**
     * Interpreter states can be hierarchical (leads to variable shadowing).
     */
    private final Optional<InterpreterState> parentState;

    /**
     * The actual variable to value binding.
     */
    private final Map<String, Object> bindings = new HashMap<>();

    public InterpreterState() {
        parentState = Optional.empty();
    }

    public InterpreterState(final InterpreterState symbolTable) {
        parentState = Optional.ofNullable(symbolTable);
    }

    /**
     * Binds the variable to the given value.
     */
    public void put(final @NonNull  String variable, final Object value) {
        bindings.put(variable, value);
    }

    /**
     * Returns the value of the variable.
     *
     * @param variable The variable to lookup.
     * @return The value bound or {@code null}.
     */
    public Object get(final String variable) {
        if(bindings.containsKey(variable)) {
            return bindings.get(variable);
        }

        return parentState.map(state -> state.get(variable))
                          .orElse(null);
    }
}

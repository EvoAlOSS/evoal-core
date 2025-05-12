package de.evoal.core.interpreter.api;

import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.languages.model.execution.Variable;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The interpreter state. The state binds variables to values.
 */
@Slf4j
public class InterpreterState {
    /**
     * Interpreter states can be hierarchical (leads to variable shadowing).
     */
    private final Optional<InterpreterState> parentState;

    private Optional<EClass> space = Optional.empty();

    /**
     * The actual variable to value binding.
     */
    private final Map<Variable, Object> bindings = new HashMap<>();

    public InterpreterState() {
        parentState = Optional.empty();
    }

    public InterpreterState(final Map<Variable, Object> other) {
        parentState = Optional.empty();
        bindings.putAll(other);
    }

    public InterpreterState(final InterpreterState other) {
        parentState = Optional.of(other);
    }

    /**
     * Binds the variable to the given value.
     */
    public void put(final @NonNull Variable variable, final Object value) {
        bindings.put(variable, value);
    }

    /**
     * Returns the value of the variable.
     *
     * @param variable The variable to lookup.
     * @return The value bound or {@code null}.
     */
    public Object get(final Variable variable) {
        log.info("Looking up variable with name: {}", variable instanceof NamedVariable ? ((NamedVariable)variable).getName() : "<unnamed>" );
        if(bindings.containsKey(variable)) {
            return bindings.get(variable);
        }

        return parentState.map(state -> state.get(variable))
                .orElse(null);
    }

    /**
     * Returns the value of a named variable.
     *
     * @param name The variable name to lookup.
     * @return The value bound or {@code null}.
     */
    public Object getByName(final String name) {
        final Optional<Object> value =
                bindings.entrySet()
                        .stream()
                        .filter(e -> e.getKey() instanceof NamedVariable)
                        .filter(e -> name.equals(((NamedVariable)e.getKey()).getName()))
                        .map(Map.Entry::getValue)
                        .findFirst();

        // Return found value. Then, ask parent context if one exists or return null otherwise
        return value.orElse(
                parentState.map(state -> state.getByName(name))
                        .orElse(null)
        );
    }

    public void setSpace(final EClass space) {
        this.space = Optional.of(space);
    }

    public EClass getSpace() {
        if(space.isPresent()) {
            return space.get();
        }

        if(parentState.isPresent()) {
            return parentState.get()
                              .getSpace();
        }

        throw new IllegalStateException("Space is not set");
    }
}


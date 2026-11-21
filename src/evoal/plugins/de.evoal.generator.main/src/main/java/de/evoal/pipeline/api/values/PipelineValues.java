package de.evoal.pipeline.api.values;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;

/**
 * The named values that pipeline components publish, e.g., the estimates of
 *   {@code 'correlation-estimation'}, and that later components read, e.g., {@code 'template'}
 *   or {@code 'csv-writer'}. One map per program, bound to the variable
 *   {@value #VARIABLE} of the outermost interpreter state, so values outlive loop bodies and
 *   later statements can read them.
 * <p>
 * Values are plain data: lists, maps (with camelCase keys), strings, numbers and booleans.
 *   A name may be set once per pipeline execution ({@link #beginExecution()}); a later
 *   execution replaces the value.
 */
@Slf4j
public final class PipelineValues {
    /**
     * The name of the variable that holds the values.
     */
    public static final String VARIABLE = "pipeline-values";

    /**
     * The values by their names, in the order they were set first.
     */
    private final Map<String, Object> values = new LinkedHashMap<>();

    /**
     * The names set in the current pipeline execution.
     */
    private final Set<String> setInExecution = new HashSet<>();

    private PipelineValues() {
    }

    /**
     * @param context The state of the interpreter.
     * @return The values of the program, created on first use.
     */
    public static PipelineValues of(final @NonNull InterpreterState context) {
        final InterpreterState root = context.root();
        if(root.getByName(VARIABLE) instanceof PipelineValues existing) {
            return existing;
        }

        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName(VARIABLE);

        final PipelineValues created = new PipelineValues();
        root.put(variable, created);

        return created;
    }

    /**
     * Starts a pipeline execution: every name may be set again once.
     */
    public void beginExecution() {
        setInExecution.clear();
    }

    /**
     * @param name The name of the value.
     * @return The value.
     * @throws IllegalArgumentException if no value has this name.
     */
    public Object get(final @NonNull String name) {
        if(!values.containsKey(name)) {
            throw new IllegalArgumentException("There is no pipeline value '" + name + "'; known values: "
                                               + values.keySet() + ". A component publishes a value with "
                                               + "result := \"" + name + "\";.");
        }

        return values.get(name);
    }

    /**
     * Sets a value. A value of an earlier execution is replaced.
     *
     * @param name The name of the value.
     * @param value The value: plain data.
     * @throws IllegalStateException if the name was already set in this execution.
     */
    public void put(final @NonNull String name, final Object value) {
        if(!setInExecution.add(name)) {
            throw new IllegalStateException("The pipeline value '" + name + "' is set twice in one execution; give "
                                            + "each component its own result name.");
        }
        if(values.containsKey(name)) {
            log.info("Replacing the pipeline value '{}' of an earlier execution.", name);
        }

        values.put(name, value);
    }

    /**
     * @return The values by their names, unmodifiable.
     */
    public Map<String, Object> asMap() {
        return Collections.unmodifiableMap(values);
    }
}

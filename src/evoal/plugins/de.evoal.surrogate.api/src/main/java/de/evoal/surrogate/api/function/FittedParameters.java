package de.evoal.surrogate.api.function;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The parameters that the preparation steps fitted while learning, per step configuration and
 *   parameter name (e.g. {@code minimum} → one value per feature). They live in the outermost
 *   interpreter state, so the executable prediction pipeline that is built after learning
 *   finds them.
 */
public final class FittedParameters {
    /**
     * The name of the variable that holds the parameters in the outermost interpreter state.
     */
    private static final String VARIABLE = "fitted-parameters";

    /**
     * Step configuration → parameter name → value per feature. The configurations are compared
     *   by identity: two steps of the same type with the same settings are different steps.
     */
    private final Map<EObject, Map<String, List<Double>>> parameters = new IdentityHashMap<>();

    /**
     * Returns the parameters of the program that the given state belongs to.
     *
     * @param context The state of the interpreter.
     * @return The parameters, created on first use.
     */
    public static FittedParameters of(final @NonNull InterpreterState context) {
        final InterpreterState root = context.root();
        if(root.getByName(VARIABLE) instanceof FittedParameters existing) {
            return existing;
        }

        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName(VARIABLE);

        final FittedParameters created = new FittedParameters();
        root.put(variable, created);

        return created;
    }

    /**
     * Records the fitted parameters of a step; a second fit of the same step replaces them.
     *
     * @param configuration The configuration of the step.
     * @param fitted Parameter name → value per feature, in the order of the step's features.
     */
    public void record(final @NonNull EObject configuration, final @NonNull Map<String, List<Double>> fitted) {
        parameters.put(configuration, Collections.unmodifiableMap(new LinkedHashMap<>(fitted)));
    }

    /**
     * @param configuration The configuration of a step.
     * @return The parameters that the step fitted, or empty if it did not fit.
     */
    public Optional<Map<String, List<Double>>> of(final @NonNull EObject configuration) {
        return Optional.ofNullable(parameters.get(configuration));
    }
}

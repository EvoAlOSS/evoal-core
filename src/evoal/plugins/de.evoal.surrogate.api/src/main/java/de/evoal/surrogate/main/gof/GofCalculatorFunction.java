package de.evoal.surrogate.main.gof;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.cdi.EvoalBuiltinFunction;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.ModelFunction;
import de.evoal.languages.model.execution.NamedVariable;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.Optional;

/**
 * {@code 'gof-calculator'()}: the conversion of an MLL module replaces every call by a call of
 *   the program function {@code goodness-of-fit}, whose body is {@code specify gof}, so this
 *   builtin itself is never called. The program function is bound in the outermost
 *   interpreter state ({@link #bind}), so that {@code 'resample'} can run it in the state of
 *   a part.
 */
@Slf4j
@ApplicationScoped
@Named("de.evoal.surrogate.pipeline.gof-calculator")
public class GofCalculatorFunction implements EvoalBuiltinFunction {
    /**
     * The name of the variable that holds the program function in the outermost state.
     */
    private static final String VARIABLE = "goodness-of-fit-function";

    @Override
    public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
        throw new IllegalStateException("This function should not be called.");
    }

    /**
     * Binds the program function {@code goodness-of-fit} in the outermost state.
     *
     * @param context The state of the interpreter.
     * @param function The program function whose body is {@code specify gof}.
     */
    public static void bind(final @NonNull InterpreterState context, final @NonNull ModelFunction function) {
        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName(VARIABLE);

        context.root().put(variable, function);
    }

    /**
     * @param context The state of the interpreter.
     * @return The program function {@code goodness-of-fit}, or empty if none is bound.
     */
    public static Optional<ModelFunction> of(final @NonNull InterpreterState context) {
        return context.getByName(VARIABLE) instanceof ModelFunction function ? Optional.of(function) : Optional.empty();
    }
}

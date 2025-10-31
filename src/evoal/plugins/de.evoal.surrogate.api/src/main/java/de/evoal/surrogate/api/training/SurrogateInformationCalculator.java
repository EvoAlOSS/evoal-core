package de.evoal.surrogate.api.training;

import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.core.interpreter.api.cdi.EvoalBuiltinFunction;
import de.evoal.languages.model.mll.TaskDescription;
import de.evoal.surrogate.api.function.ModelFunctionData;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Calculates information on the calculated surrogate, such as cross validation
 *   values, goodness of fit, and so on.
 */
@Slf4j
public abstract class SurrogateInformationCalculator implements EvoalBuiltinFunction {
    protected ModelFunctionData functionData;

    @Inject
    protected TrainingTaskHelper helper;

    protected TaskDescription task;

    @Override
    public final Optional<Object> call(final InterpreterState context, final Object[] arguments) {
        task = (TaskDescription) context.getByName("learning-task");
        functionData = (ModelFunctionData) context.getByName("model-function");

        return calculate(context, arguments);
    }

    public abstract Optional<Object> calculate(final InterpreterState context, final Object[] arguments);
}

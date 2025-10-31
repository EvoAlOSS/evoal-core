package de.evoal.surrogate.main.gof;

import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.core.interpreter.api.cdi.EvoalBuiltinFunction;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Optional;

@Slf4j
@ApplicationScoped
@Named("de.evoal.surrogate.pipeline.gof-calculator")
public class GofCalculatorFunction implements EvoalBuiltinFunction {
    @Override
    public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
        throw new IllegalStateException("This function should not be called.");
    }
}
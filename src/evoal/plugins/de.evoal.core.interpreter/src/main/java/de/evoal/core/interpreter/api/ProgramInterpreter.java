package de.evoal.core.interpreter.api;

import de.evoal.core.api.ecore.Space;
import de.evoal.languages.model.execution.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProgramInterpreter {

    /**
     * The interpreter state
     */
    private InterpreterState state;

    private final java.util.function.Function<InterpreterState, ProgramExecutionSwitch> executionSupplier;

    public ProgramInterpreter() {
        executionSupplier = (state) -> new ProgramExecutionSwitch(state);
    }

    public ProgramInterpreter(java.util.function.Function<InterpreterState, ProgramExecutionSwitch> supplier) {
        executionSupplier = supplier;
    }

    public void execute(final Program program, final Space space) {
        log.info("Executing program '{}'.", program.getMain().getName());
        state = new InterpreterState();
        state.setSpace(space);

        final ProgramExecutionSwitch executionSwitch = executionSupplier.apply(state);

        executionSwitch.doSwitch(program);
    }
    /*
    public void executeAndKeepState(final Program program) {
        log.info("Executing program '{}' and keeping interpreter state.", program.getMain().getName());

        final ProgramExecutionSwitch executionSwitch = executionSupplier.apply(state);
        final Function mainFunction = program.getMain();

        executionSwitch.caseFunction(mainFunction);
    }
    */
}
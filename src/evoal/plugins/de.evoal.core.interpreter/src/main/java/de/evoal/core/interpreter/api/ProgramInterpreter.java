package de.evoal.core.interpreter.api;

import de.evoal.core.interpreter.impl.ProgramExecutionSwitch;
import de.evoal.languages.model.execution.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;

@Slf4j
public class ProgramInterpreter {

    /**
     * The interpreter state
     */
    private InterpreterState state;

    public ProgramInterpreter() {
    }

    public void execute(final Program program, final EClass space) {
        log.info("Executing program '{}'.", program.getMain());
        state = new InterpreterState();
        state.setSpace(space);

        final ProgramExecutionSwitch executionSwitch = new ProgramExecutionSwitch(state);
        final Function mainFunction = program.getMain();

        executionSwitch.doSwitch(mainFunction);
    }

    public void executeAndKeepState(final Program program) {
        log.info("Executing program '{}' and keeping interpreter state.", program.getMain());

        final ProgramExecutionSwitch executionSwitch = new ProgramExecutionSwitch(state);
        final Function mainFunction = program.getMain();

        executionSwitch.caseFunction(mainFunction);
    }
}
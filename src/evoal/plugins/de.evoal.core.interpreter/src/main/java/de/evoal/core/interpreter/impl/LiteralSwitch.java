package de.evoal.core.interpreter.impl;

import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.languages.model.base.expressions.ValueReference;
import de.evoal.languages.model.execution.VariableReference;
import de.evoal.languages.model.interpreter.AbstractExpressionEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

@Slf4j
public class LiteralSwitch extends AbstractExpressionEvaluator {
    private final InterpreterState state;

    public LiteralSwitch(final InterpreterState state) {
        this.state = state;
    }

    @Override
    public Object caseValueReference(final ValueReference reference) {
        log.info("Looking up value reference {}.", reference);
        if(reference instanceof VariableReference varReference) {
            return state.get(varReference.getVariable());
        }

        return super.caseValueReference(reference);
    }

    @Override
    public Object defaultCase(EObject object) {
        log.error("Visitor for {} is not implemented.", object);
        return super.defaultCase(object);
    }
}

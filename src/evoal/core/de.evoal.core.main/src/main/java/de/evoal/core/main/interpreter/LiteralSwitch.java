package de.evoal.core.main.interpreter;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ConstantDefinition;
import de.evoal.languages.model.base.expressions.*;
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
        } else if(reference instanceof ValueDefinitionReference definition) {
            if (definition.getDefinition() instanceof AttributeDefinition attributeDefinition) {
                final Instance instance = (Instance) state.getByName("self");
                final Attribute attribute = instance.findAttribute(attributeDefinition);

                return doSwitch(attribute.getValue());
            }
        }

        return super.caseValueReference(reference);
    }

    @Override
    public Object caseSelfReference(final SelfReference reference) {
        return state.getByName("self");
    }

    @Override
    public Object defaultCase(EObject object) {
        log.error("Visitor for {} is not implemented.", object);
        return super.defaultCase(object);
    }
}

package de.evoal.core.api.languages.base;

import java.util.Map;

import de.evoal.languages.model.interpreter.AbstractExpressionEvaluator;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import lombok.extern.slf4j.Slf4j;

import de.evoal.languages.model.base.*;
import de.evoal.languages.model.ddl.DataDescription;

@Slf4j
public class DynamicSwitch extends AbstractExpressionEvaluator {

    private final Map<DataDescription,Object> symbolTable;

    public DynamicSwitch(final Map<DataDescription,Object> symbolTable) {
        this.symbolTable = symbolTable;
        setConstantEvaluator(new ConstantEvaluator());
    }

    @Override
    public Object caseValueReference(final ValueReference object) {
        Object value = super.caseValueReference(object);

        if(value instanceof DataDescription) {
            value = symbolTable.get(value);
        }

        return value;
    }

    /**
     * Evaluates the given expression {@code exp}, stores the new value under {@code ref} in the symbol table, and
     *   returns the value that was replaced.
     *
     * @param ref The data to store
     * @param exp The expression to evaluate.
     * @return The value stored as {@code ref} before.
     */
    public Object evaluateAndUpdate(final DataDescription ref, final Expression exp) {
        //first do switch then update map
        Object result = this.doSwitch(exp);

        return symbolTable.put(ref, result);
    }
}
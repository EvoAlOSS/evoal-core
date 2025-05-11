package de.evoal.pipeline.impl.internal;

import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.execution.util.ExecutionSwitch;
import de.evoal.languages.model.generator.ApplyStatement;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.Map;

@Slf4j
public class ExecutionDSLConverter extends ExecutionSwitch<Object> {
    private final ExecutionFactory execFactory = ExecutionFactory.eINSTANCE;
    private final GeneratorDSLConverter converter;
    private final Map<Variable, Variable> variables;

    public ExecutionDSLConverter(final GeneratorDSLConverter converter, final Map<Variable, Variable> variables) {
        this.converter = converter;
        this.variables = variables;
    }

    @Override
    public Block caseBlock(final Block block) {
        final Block result = execFactory.createBlock();

        block.getStatements()
                .stream()
                .map(this::doSwitch)
                .map(Statement.class::cast)
                .forEach(result.getStatements()::add);

        return result;
    }

    @Override
    public ForStatement caseForStatement(final ForStatement obj) {
        final ForStatement result = execFactory.createForStatement();
        result.setVar(caseNamedVariable(obj.getVar()));
        result.setBody(caseBlock(obj.getBody()));
        result.setRange((de.evoal.languages.model.execution.Range)doSwitch(obj.getRange()));

        return result;
    }

    @Override
    public NamedVariable caseNamedVariable(final NamedVariable obj) {
        final NamedVariable result = execFactory.createNamedVariable();
        result.setName(obj.getName());

        return result;
    }

    @Override
    public CounterRange caseCounterRange(final CounterRange obj) {
        final CounterRange result = execFactory.createCounterRange();

        result.setStart(EcoreUtil.copy(obj.getStart()));
        result.setEnd(EcoreUtil.copy(obj.getEnd()));

        return result;
    }

    @Override
    public ValueRange caseValueRange(final ValueRange obj) {
        final ValueRange result = execFactory.createValueRange();

        obj.getElements()
                .stream()
                .map(EcoreUtil::copy)
                .forEach(result.getElements()::add);

        return result;
    }

    @Override
    public Object caseStatement(final Statement obj) {
        if(obj instanceof ApplyStatement applyStatement) {
            return converter.caseApplyStatement(applyStatement);
        }

        return super.caseStatement(obj);
    }

    @Override
    public VariableReference caseVariableReference(final VariableReference obj) {
        log.info("Converting variable reference to {}.", obj);

        final VariableReference result = execFactory.createVariableReference();
        final Variable var = variables.get(obj.getVariable());
        result.setVariable(var);

        return result;
    }
}

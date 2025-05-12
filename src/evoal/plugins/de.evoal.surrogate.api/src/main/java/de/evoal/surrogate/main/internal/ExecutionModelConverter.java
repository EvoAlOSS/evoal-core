package de.evoal.surrogate.main.internal;

import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.execution.util.ExecutionSwitch;
import de.evoal.languages.model.mll.PredictStatement;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.Map;

@Slf4j
public class ExecutionModelConverter extends ExecutionSwitch<Object> {
    private final static ExecutionFactory execFactory = ExecutionFactory.eINSTANCE;

    private final MLLModelConverter converter;
    private final EClass space;
    private final Map<Variable, Variable> variables;

    public ExecutionModelConverter(final EClass space, final Map<Variable, Variable> variables, final MLLModelConverter converter) {
        this.space = space;
        this.variables = variables;
        this.converter = converter;
    }

    @Override
    public Block caseBlock(final Block block) {
        final Block result = execFactory.createBlock();

        block.getStatements()
                .stream()
                .map(this::doSwitch)
                .map(Statement.class::cast)
                .forEachOrdered(result.getStatements()::add);

        return result;
    }

    @Override
    public Statement caseStatement(final Statement statement) {
        if(statement instanceof PredictStatement predictStatement) {
            return converter.casePredictStatement(predictStatement);
        }

        return (Statement) super.caseStatement(statement);
    }

    @Override
    public CallBuiltinFunction caseCallBuiltinFunction(final CallBuiltinFunction function) {
        final CallBuiltinFunction result = execFactory.createCallBuiltinFunction();
        result.setDefinition(function.getDefinition());

        function.getParameters()
                .stream()
                .map(EcoreUtil::copy)
                .forEachOrdered(result.getParameters()::add);

        return result;
    }


    @Override
    public Object defaultCase(EObject object) {
        log.error("Not yet supported {}.", object);
        throw new UnsupportedOperationException();
    }

    @Override
    public NamedVariable caseNamedVariable(final NamedVariable variable) {
        final NamedVariable result = execFactory.createNamedVariable();
        result.setName(variable.getName());

        variables.put(variable, result);
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
    public CounterRange caseCounterRange(final CounterRange obj) {
        log.info("Copying counter range.");
        final CounterRange result = execFactory.createCounterRange();

        result.setStart(EcoreUtil.copy(obj.getStart()));
        result.setEnd(EcoreUtil.copy(obj.getEnd()));
        result.setIncrement(EcoreUtil.copy(obj.getIncrement()));

        return result;
    }

    @Override
    public ValueRange caseValueRange(final ValueRange obj) {
        log.info("Copying value range.");
        final ValueRange result = execFactory.createValueRange();

        obj.getElements()
                .stream()
                .map(EcoreUtil::copy)
                .forEach(result.getElements()::add);

        return result;
    }
}

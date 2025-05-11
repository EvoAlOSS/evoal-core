package de.evoal.core.interpreter.impl;

import de.evoal.core.interpreter.api.cdi.EvoalBuiltinFunction;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.core.interpreter.api.cdi.FunctionFactory;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.ConstantValue;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Value;
import de.evoal.languages.model.base.expressions.ValueReference;
import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.execution.util.ExecutionSwitch;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
public class ProgramExecutionSwitch extends ExecutionSwitch<Object> {

    /**
     * The symbol table used
     */
    private InterpreterState symbols;

    public ProgramExecutionSwitch(final InterpreterState pipelineTable) {
        this.symbols = new InterpreterState(pipelineTable);
    }

    @Override
    public Object caseModelFunction(final ModelFunction function) {
        log.info("Executing function {}.", function.getName());

        // preserve local state for returning
        final InterpreterState localState = symbols;

        // create state for callee
        symbols = new InterpreterState(localState);

        // Copy all variables of callee into callee state
        function.getVariables()
                .forEach(this::caseVariable);

        // execute callee
        Object result = caseBlock(function.getBody());

        // restore local context
        symbols = localState;

        return result;
    }

    @Override
    public Object caseBlock(final Block block) {
        // execute every single statement of the block.
        block.getStatements()
             .forEach(this::doSwitch);

        return Optional.empty();
    }

    @Override
    public Object caseVariable(final Variable variable) {
        log.info("Registering variable {} in context.", variable);
        symbols.put(variable, variable);

        return variable;
    }

    @Override
    public Object caseVariableReference(final VariableReference reference) {
        return symbols.get(reference.getVariable());
    }

    @Override
    public Object caseValue(Value object) {
        return super.caseValue(object);
    }

    @Override
    public Object caseExpression(Expression object) {
        return super.caseExpression(object);
    }

    @Override
    public Object caseValueReference(ValueReference object) {
        return super.caseValueReference(object);
    }

    @Override
    public Object caseConstantValue(ConstantValue object) {
        return super.caseConstantValue(object);
    }

    @Override
    public Object defaultCase(final EObject object) {
        log.error("Visitor for {} is not implemented",  object);

        throw new IllegalArgumentException();
    }

    @Override
    public Object caseForStatement(final ForStatement forLoop) {
        final Variable variable = forLoop.getVar();

        final InterpreterState currentSymbols = this.symbols;

        final Stream<?> loopElements = (Stream<?>)doSwitch(forLoop.getRange());
        loopElements.forEach(e -> {
            this.symbols = new InterpreterState(currentSymbols);
            this.symbols.put(variable, e);

            doSwitch(forLoop.getBody());

            this.symbols = currentSymbols;
        });

        return null;
    }

    @Override
    public Object caseCounterRange(final CounterRange range) {
        final int start = (int)new LiteralSwitch(symbols).doSwitch(range.getStart());
        final int end = (int)new LiteralSwitch(symbols).doSwitch(range.getEnd());
        final int increment = (int)new LiteralSwitch(symbols).doSwitch(range.getIncrement());

        final Iterator<Integer> loopCounter = new Iterator<>() {
            int current = start;
            final java.util.function.Function<Integer, Boolean> hasNext = start < end ? a -> a < end : a -> a > end;

            @Override
            public boolean hasNext() {
                return hasNext.apply(current);
            }

            @Override
            public Integer next() {
                int value = current;
                current += increment;

                return value;
            }
        };

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(loopCounter, Spliterator.ORDERED),
                false
        );
    }

    @Override
    public Object caseValueRange(final ValueRange range) {
        final LiteralSwitch helper = new LiteralSwitch(symbols);

        return range.getElements()
                .stream()
                .map(helper::doSwitch);
    }

    @Override
    public Object caseCallBuiltinFunction(final CallBuiltinFunction call) {
        final FunctionDefinition fDefinition = call.getDefinition();
        log.info("Calling built-in function {}.", fDefinition.getName());

        final EvoalBuiltinFunction<?> function = FunctionFactory.createBuiltinFunction(EvoalBuiltinFunction.class, fDefinition);

        final LiteralSwitch helper = new LiteralSwitch(symbols);

        final Object [] parameters =
                call.getParameters()
                    .stream()
                    .map(helper::doSwitch)
                    .toList()
                    .toArray();

        return function.call(symbols, parameters);
    }

    @Override
    public Object caseCallModelFunction(final CallModelFunction function) {
        return caseModelFunction(function.getFunction());
    }
}
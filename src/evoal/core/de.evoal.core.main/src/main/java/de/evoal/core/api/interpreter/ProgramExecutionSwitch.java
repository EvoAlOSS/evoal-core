package de.evoal.core.api.interpreter;

import de.evoal.core.api.utils.EvoAlEvaluationException;
import de.evoal.core.api.cdi.EvoalBuiltinFunction;
import de.evoal.core.api.cdi.FunctionFactory;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ValueReference;
import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.execution.util.ExecutionSwitch;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
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
    protected InterpreterState context;

    public ProgramExecutionSwitch(final InterpreterState context) {
        this.context = new InterpreterState(context);
    }

    protected ProgramExecutionSwitch() {
    }

    @Override
    public Object caseBlock(final Block block) {
        // execute every single statement of the block.
        block.getStatements()
             .forEach(this::doSwitch);

        return Optional.empty();
    }

    @Override
    public Object caseCallBuiltinFunction(final CallBuiltinFunction call) {
        final FunctionDefinition fDefinition = call.getDefinition();
        log.info("Calling built-in function {}.", fDefinition.getName());

        final EvoalBuiltinFunction<?> function = FunctionFactory.createBuiltinFunction(EvoalBuiltinFunction.class, fDefinition);

        final ExpressionInterpreter helper = new ExpressionInterpreter(context);

        final Object [] parameters =
                call.getParameters()
                    .stream()
                    .map(helper::execute)
                    .toList()
                    .toArray();

        try {
            return function.call(context, parameters);
        } catch (final EvoAlEvaluationException e) {
            throw  new RuntimeException("Failed to call builtin function " + fDefinition.getName(), e);
        }
    }

    @Override
    public Object caseCallModelFunction(final CallModelFunction function) {
        return caseModelFunction(function.getFunction());
    }

    @Override
    public Object caseCounterRange(final CounterRange range) {
        final ExpressionInterpreter helper = new ExpressionInterpreter(context);

        // the bounds are expressions; a quotient is a real, so convert instead of casting
        final int start = NumericConversions.toInteger(helper.execute(range.getStart()));
        final int end = NumericConversions.toInteger(helper.execute(range.getEnd()));
        final int increment = NumericConversions.toInteger(helper.execute(range.getIncrement()));

        // start and end are inclusive: [0 to 10 increment by 2] counts 0, 2, ..., 10
        requireIncrementTowardsEnd(start, end, increment);
        // the increment points towards the end (checked above), also if start and end are equal
        final boolean countsUp = increment > 0;
        final Iterator<Integer> loopCounter = new Iterator<>() {
            // long, so that the step after the largest int does not wrap around
            long current = start;

            @Override
            public boolean hasNext() {
                if(countsUp) {
                    return current <= end;
                }

                return current >= end;
            }

            @Override
            public Integer next() {
                final int value = (int) current;
                current += increment;

                return value;
            }
        };

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(loopCounter, Spliterator.ORDERED),
                false
        );
    }

    /**
     * Rejects a counter range that would never reach its end: an increment of 0, or an
     *   increment whose sign points away from the end.
     *
     * @throws IllegalArgumentException if the increment does not lead from start to end.
     */
    private static void requireIncrementTowardsEnd(final int start, final int end, final int increment) {
        final String range = "[" + start + " to " + end + " increment by " + increment + "]";

        if(increment == 0) {
            throw new IllegalArgumentException("The increment of the counter range " + range + " must not be 0.");
        }

        final boolean countsUp = start < end;
        final boolean countsDown = start > end;

        if(countsUp && increment < 0) {
            throw new IllegalArgumentException("The counter range " + range + " counts up, so its increment must be positive.");
        }

        if(countsDown && increment > 0) {
            throw new IllegalArgumentException("The counter range " + range + " counts down, so its increment must be negative.");
        }
    }

    @Override
    public Object caseExpression(Expression object) {
        return super.caseExpression(object);
    }

    @Override
    public Object caseForStatement(final ForStatement forLoop) {
        final Variable variable = forLoop.getVar();

        final InterpreterState currentSymbols = this.context;

        final Stream<?> loopElements = (Stream<?>)doSwitch(forLoop.getRange());
        loopElements.forEach(e -> {
            this.context = new InterpreterState(currentSymbols);
            this.context.put(variable, e);

            doSwitch(forLoop.getBody());

            this.context = currentSymbols;
        });

        return Optional.empty();
    }

    @Override
    public Object caseModelFunction(final ModelFunction function) {
        log.info("Executing function {}.", function.getName());

        // preserve local state for returning
        final InterpreterState localState = context;

        // create state for callee
        context = new InterpreterState(localState);

        // Copy all variables of callee into callee state
        function.getVariables()
                .forEach(this::caseVariable);

        // execute callee
        Object result = caseBlock(function.getBody());

        // restore local context
        context = localState;

        return result;
    }

    @Override
    public Object caseProgram(final Program program) {
        program.getVariables()
               .forEach(this::doSwitch);

        return doSwitch(program.getMain());
    }

    @Override
    public Object caseValueRange(final ValueRange range) {
        final ExpressionInterpreter helper = new ExpressionInterpreter(context);

        return range.getElements()
                .stream()
                .map(helper::execute);
    }

    @Override
    public Object caseValueReference(ValueReference object) {
        return super.caseValueReference(object);
    }

    @Override
    public Object caseVariable(final Variable variable) {
        log.info("Registering variable {} in context.", variable);
        context.put(variable, variable);

        return variable;
    }

    @Override
    public Object caseVariableReference(final VariableReference reference) {
        return context.get(reference.getVariable());
    }

    @Override
    public Object defaultCase(final EObject object) {
        log.error("Visitor for {} is not implemented",  object);

        throw new IllegalArgumentException();
    }
}
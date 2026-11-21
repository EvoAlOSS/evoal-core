package de.evoal.pipeline.impl.internal;

import de.evoal.core.api.languages.base.StringSwitch;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.execution.util.ExecutionSwitch;
import de.evoal.languages.model.generator.ApplyStatement;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.Map;

@Slf4j
public class ExecutionDSLConverter extends ExecutionSwitch<Object> {
    /**
     * The name of the module that declares {@value #EXECUTE}.
     */
    private static final String BASE_MODULE = "de.evoal.pipeline.base";

    /**
     * The name of the built-in function that executes a pipeline.
     */
    private static final String EXECUTE = "execute";

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

    /**
     * Copies a call of a built-in function. The parameter of {@code execute("name")} names a
     *   pipeline of the module; it becomes a reference to the converted pipeline, so an unknown
     *   name is rejected before the program runs.
     *
     * @throws IllegalArgumentException if {@code execute} has no string parameter or names no
     *   pipeline of the module.
     */
    @Override
    public CallBuiltinFunction caseCallBuiltinFunction(final CallBuiltinFunction obj) {
        final CallBuiltinFunction result = execFactory.createCallBuiltinFunction();
        result.setDefinition(obj.getDefinition());

        if(isExecute(obj)) {
            final String name = obj.getParameters().size() == 1
                    ? new StringSwitch().doSwitch(obj.getParameters().getFirst())
                    : null;
            if(name == null) {
                throw new IllegalArgumentException("execute needs the name of one pipeline as a string, e.g. "
                                                   + "execute(\"main\");.");
            }

            result.getParameters().add(converter.referenceToPipeline(name));
        } else {
            obj.getParameters()
               .stream()
               .map(EcoreUtil::copy)
               .forEach(result.getParameters()::add);
        }

        return result;
    }

    /**
     * @return Whether the call is the built-in function {@code execute} of the pipeline module.
     */
    private static boolean isExecute(final CallBuiltinFunction call) {
        final FunctionDefinition definition = call.getDefinition();
        if(definition == null || !EXECUTE.equals(definition.getName())) {
            return false;
        }

        return definition.eContainer() instanceof DefinitionModule module && BASE_MODULE.equals(module.getName());
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
        final Variable var = variables.get(variables.get(obj.getVariable()));
        result.setVariable(var);

        return result;
    }
}

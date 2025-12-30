package de.evoal.pipeline.impl.components.functions;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.utils.EvoAlEvaluationException;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.cdi.EvoalBuiltinFunction;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.languages.model.pipeline.Step;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.pipeline.api.executor.PipelineExecutor;
import de.evoal.pipeline.api.executor.StreamExecutor;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.pipeline.impl.internal.PipelineInstantiator;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.*;

@Slf4j
@ApplicationScoped
@Named("de.evoal.pipeline.base.execute")
public class ExecuteFunction implements EvoalBuiltinFunction {
    /**
     * For generating expressions
     */
    private final static ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;

    @Inject
    private DefinitionModuleLoader loader;

    @Override
    public Optional<Object> call(final InterpreterState context, final Object[] arguments) throws EvoAlEvaluationException {
        log.info("Calling execute function with parameters: {}", Arrays.toString(arguments));
        if(arguments.length == 0) {
            throw new EvoAlEvaluationException("Number of passed parameters is not allowed to be 0.");
        }

        final Space space = context.getSpace();
        final PipelineInstantiator converter = new PipelineInstantiator(space);

        PipelineComposite composite = null;
        if(arguments.length == 1) {
            if(arguments[0] instanceof PipelineDefinition pipe) {
                log.info("Executing pipeline '{}'.", pipe.getName());
                composite = converter.definitionsToComposite(Collections.singletonList(pipe));
            } else if(arguments[0] instanceof List<?> list) {
                final List<Step> steps = ((List<?>)arguments[0])
                        .stream()
                        .map(Step.class::cast)
                        .toList();

                composite = converter.stepsToComposite(steps);
            }
        }

        composite.setContext(context);

        final PipelineExecutor executor = new StreamExecutor();

        executor.setSpace(space);
        executor.execute(composite);

        composite.close();

        return Optional.empty();
    }
}
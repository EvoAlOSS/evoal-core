package de.evoal.pipeline.impl.components.functions;

import de.evoal.models.core.ecore.Space;
import de.evoal.core.api.cdi.EvoalBuiltinFunction;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.models.v202704.pipeline.ConcreteStep;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.pipeline.api.executor.PipelineExecutor;
import de.evoal.pipeline.api.executor.StreamExecutor;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.pipeline.api.values.PipelineValues;
import de.evoal.pipeline.impl.internal.GeneratorDSLConverter;
import de.evoal.pipeline.impl.internal.PipelineInstantiator;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@ApplicationScoped
@Named("de.evoal.pipeline.base.generate")
public class GenerateFunction implements EvoalBuiltinFunction {
    private final Pattern varPattern = Pattern.compile("\\$\\{[^}]*}");

    /**
     * Executes the pipelines. The last pipeline is the writer pipeline that is created during
     *   the transformation (see {@link GeneratorDSLConverter#WRITER_PIPELINE}). Its file name
     *   may contain variables ({@code ${name}}) that are resolved using the interpreter state.
     */
    @Override
    public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
        final String filename = resolveFilename(context, (String) arguments[0]);
        final Integer count = (Integer) arguments[1];
        final List<PipelineDefinition> pipelines  = (List<PipelineDefinition>) arguments[2];

        final Space space = context.getSpace();

        configureWriter(pipelines, filename);
        log.info("Writing {} data points.", count);
        log.info("There are {} pipelines.", pipelines.size());

        final PipelineInstantiator converter = new PipelineInstantiator(space);
        final PipelineComposite pipeline = converter.definitionsToComposite(pipelines);
        pipeline.setContext(context);
        PipelineValues.of(context).beginExecution();

        final PipelineExecutor executor = new StreamExecutor();

        executor.setSpace(space);
        executor.execute(pipeline);

        pipeline.close();

        return Optional.empty();
    }

    /**
     * Sets the resolved file name in the configuration of the writer pipeline.
     */
    private void configureWriter(final List<PipelineDefinition> pipelines, final String filename) {
        final PipelineDefinition writer = pipelines.isEmpty() ? null : pipelines.get(pipelines.size() - 1);
        if(writer == null || !GeneratorDSLConverter.WRITER_PIPELINE.equals(writer.getName())) {
            throw new IllegalStateException("The last pipeline passed to generate has to be the writer pipeline.");
        }

        final EObject configuration = ((ConcreteStep) writer.getSteps().get(0)).getConfiguration();
        configuration.eSet(configuration.eClass().getEStructuralFeature("filename"), filename);

        log.info("Writing results to {}.", filename);
        new File(filename)
                .getAbsoluteFile()
                .getParentFile()
                .mkdirs();
    }

    private String resolveFilename(final InterpreterState context, String filename) {
        final Matcher matcher = varPattern.matcher(filename);

        final Set<String> vars = new HashSet<>();
        while (matcher.find()) {
            vars.add(filename.substring(matcher.start() + 2, matcher.end() - 1));
        }

        for (final String var : vars) {
            final Object value = context.getByName(var);

            if (value == null) {
                log.warn("Unable to replace ${{}}", var);
                continue;
            }

            filename = filename.replace("${" + var + "}", value.toString());
        }

        return filename;
    }
}

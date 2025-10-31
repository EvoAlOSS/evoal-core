package de.evoal.pipeline.impl.components.functions;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.interpreter.api.cdi.EvoalBuiltinFunction;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.pipeline.ConcreteStep;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.languages.model.pipeline.PipelineFactory;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.pipeline.api.executor.PipelineExecutor;
import de.evoal.pipeline.api.executor.StreamExecutor;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.pipeline.impl.internal.PipelineInstantiator;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Slf4j
@ApplicationScoped
@Named("de.evoal.pipeline.base.generate")
public class GenerateFunction implements EvoalBuiltinFunction {
    /**
     * For generating expressions
     */
    private final static ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;

    @Inject
    private DefinitionModuleLoader loader;

    private final Pattern varPattern = Pattern.compile("\\$\\{[^}]*}");

    @Override
    public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
        final String filename = (String) arguments[0];
        final Integer count = (Integer) arguments[1];
        final List<PipelineDefinition> pipelines  = (List<PipelineDefinition>) arguments[2];

        final Space space = context.getSpace();

        final PipelineDefinition writer = generateWriterPipeline(context, filename);
        log.info("Writing {} data points.", count);
        log.info("There are {} pipelines.", pipelines.size());

        pipelines.add(writer);

        final PipelineInstantiator converter = new PipelineInstantiator(space);
        final PipelineComposite pipeline = converter.definitionsToComposite(pipelines);
        final PipelineExecutor executor = new StreamExecutor();
        final Optional<Function<Stream<TypedEObject>, Stream<TypedEObject>>> countLimit = Optional.of(stream -> stream.limit(count));

        executor.setSpace(space);
        executor.execute(pipeline);

        pipeline.close();

        return Optional.empty();
    }

    private PipelineDefinition generateWriterPipeline(final InterpreterState context, String filename) {
        final Matcher matcher = varPattern.matcher(filename);

        final Set<String> vars = new HashSet<>();
        while (matcher.find()) {
            vars.add(filename.substring(matcher.start() + 2, matcher.end() - 1));
        }

        for (final String var : vars) {
            String replacement = null;

            final Object value = context.getByName(var);
            replacement = value.toString();

            if (replacement == null) {
                log.warn("Unable to replace ${{}}", var);
                continue;
            }

            filename = filename.replace("${" + var + "}", replacement);
        }

        log.info("Writing results to {}.", filename);
        new File(filename)
                .getAbsoluteFile()
                .getParentFile()
                .mkdirs();

        log.info("Generating writer");
        final DefinitionModule module = loader.load("classpath:/de/evoal/pipeline/io.dl");
        final ClassDefinition writerDefinition = module.getTypes()
                .stream()
                .filter(t -> "writer".equals(t.getName()))
                .findFirst()
                .get();

        final AttributeDefinition filenameDefinition = writerDefinition.getAttributes()
                .stream()
                .filter(a -> "filename".equals(a.getName()))
                .findFirst()
                .get();

        final StringLiteral filenameLiteral = exprFactory.createStringLiteral();
        filenameLiteral.setLiteral(filename);

        final Attribute filenameAttribute = exprFactory.createAttribute();
        filenameAttribute.setDefinition(filenameDefinition);
        filenameAttribute.setValue(filenameLiteral);

        final Instance writerInstance = exprFactory.createInstance();
        writerInstance.getAttributes().add(filenameAttribute);
        writerInstance.setDefinition(writerDefinition);

        final ConcreteStep writerStep = PipelineFactory.eINSTANCE.createConcreteStep();
        writerStep.getReads()
                  .addAll(context.getSpace());
        writerStep.setInstance(writerInstance);

        final PipelineDefinition definition = PipelineFactory.eINSTANCE.createPipelineDefinition();
        definition.setName("artificial");
        definition.getSteps().add(writerStep);

        return definition;
    }
}
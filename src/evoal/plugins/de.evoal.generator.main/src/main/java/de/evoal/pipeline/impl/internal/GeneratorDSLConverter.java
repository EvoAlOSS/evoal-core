package de.evoal.pipeline.impl.internal;

import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.models.core.ecore.Space;
import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.execution.VariableReference;
import de.evoal.languages.model.generator.*;
import de.evoal.languages.model.generator.util.GeneratorSwitch;
import de.evoal.models.v202704.pipeline.PipelineFactory;
import de.evoal.models.v202704.pipeline.PipelineModule;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GeneratorDSLConverter extends GeneratorSwitch<Object> {
    /* Factories for creating model instances. */
    private final ExecutionFactory execFactory = ExecutionFactory.eINSTANCE;
    private final ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;
    private final PipelineFactory pipeFactory = PipelineFactory.eINSTANCE;

    /**
     * Name of the pipeline that writes the generated data. It is the last pipeline passed
     *   to the {@code generate} function, which sets the (resolved) file name at runtime.
     */
    public static final String WRITER_PIPELINE = "write-to-file";

    private final Map<String, EStructuralFeature> features = new HashMap<>();
    private final Map<Variable, Variable> pipelines = new HashMap<>();

    /**
     * The data space of the generator.
     */
    private final Space space;

    /**
     * Creates the runtime objects for configurations.
     */
    private final ModelTransformer transformer;

    private final ExecutionDSLConverter converter = new ExecutionDSLConverter(this, pipelines);
    private PipelineModule module;

    /**
     * The resource set of the generator module. Additional DL files are loaded into it,
     *   so they share the definitions (e.g., {@code configuration}) with the generator module.
     */
    private ResourceSet resourceSet;

    public GeneratorDSLConverter(final @NonNull Space space, final @NonNull ModelTransformer transformer) {
        this.space = space;
        this.transformer = transformer;
        for(final EStructuralFeature feature : space.getEClass().getEStructuralFeatures()) {
            features.put(feature.getName(), feature);
        }
    }

    public PipelineModule convert(final GeneratorModule module) {
        log.info("Converting 'GeneratorModule {}' into a PipelineModule.", module.getName());
        this.resourceSet = module.eResource().getResourceSet();
        return caseGeneratorModule(module);
    }

    @Override
    public PipelineModule caseGeneratorModule(final GeneratorModule obj) {
        // generate target module
        final PipelineModule module = pipeFactory.createPipelineModule();
        module.setName(obj.getName());
        this.module = module;

        // convert all imports
        obj.getImports()
           .stream()
           .map(this::caseImport)
           .forEachOrdered(module.getImports()::add);

        // create program and main function
        final ModelFunction main = execFactory.createModelFunction();
        main.setName("main");

        final Program program = execFactory.createProgram();
        program.getFunctions().add(main);
        program.setMain(main);
        module.setProgram(program);

        // convert pipeline definitions (otherwise, we cannot convert the statements)
        obj.getPipelines()
                .stream()
                .map(this::casePipelineDefinition)
                .forEachOrdered(main.getVariables()::add);

        // convert body
        main.setBody(converter.caseBlock(obj.getBody()));

        return module;
    }

    public Import caseImport(final Import imp) {
        return EcoreUtil.copy(imp);
    }

    @Override
    public de.evoal.models.v202704.pipeline.PipelineDefinition casePipelineDefinition(final PipelineDefinition obj) {
        log.info("Converting 'PipelineDefinition {}'.", obj.getName());

        final de.evoal.models.v202704.pipeline.PipelineDefinition result = pipeFactory.createPipelineDefinition();;
        result.setName(obj.getName());

        for(final Step step : obj.getSteps()) {
            result.getSteps().add((de.evoal.models.v202704.pipeline.Step) doSwitch(step));
        }

        pipelines.put(obj, result);

        return result;
    }

    @Override
    public de.evoal.models.v202704.pipeline.ConcreteStep caseConcreteStep(final ConcreteStep obj) {
        log.info("  Converting 'ConcreteStep {}'", obj.getInstance().getDefinition().getName());
        final de.evoal.models.v202704.pipeline.ConcreteStep result = pipeFactory.createConcreteStep();

        result.setConfiguration(transformer.createDynamic(obj.getInstance()));

        obj.getReads()
                .stream()
                .map(TypeDefinitionReference::getDefinition)
                .map(Definition::getName)
                .map(features::get)
                .forEach(ef -> result.getReads().add((EAttribute)ef));

        obj.getWrites()
                .stream()
                .map(TypeDefinitionReference::getDefinition)
                .map(Definition::getName)
                .map(features::get)
                .forEach(ef -> result.getWrites().add((EAttribute)ef));

        return result;
    }

    @Override
    public de.evoal.models.v202704.pipeline.PipelineStep casePipelineStep(final PipelineStep obj) {
        log.info("  Converting 'PipelineStep {}'", obj.getDefinition().getName());
        final de.evoal.models.v202704.pipeline.PipelineStep result = pipeFactory.createPipelineStep();

        final de.evoal.models.v202704.pipeline.PipelineDefinition definition =
                (de.evoal.models.v202704.pipeline.PipelineDefinition) pipelines.get(obj.getDefinition());

        result.setDefinition(definition);

        return result;
    }

    @Override
    public Object caseApplyStatement(final ApplyStatement obj) {
        log.info("Converting apply statement.");
        final FunctionDefinition generateFunction = loadDefinitions("base.dl")
                .getFunctions()
                .stream()
                .filter(t ->"generate".equals(t.getName()))
                .findFirst()
                .get();

        final de.evoal.languages.model.execution.CallBuiltinFunction result = execFactory.createCallBuiltinFunction();
        result.setDefinition(generateFunction);

        // the file name may contain ${variables}, it is resolved by the generate function
        final StringLiteral filename = exprFactory.createStringLiteral();
        filename.setLiteral(obj.getFile());

        result.getParameters().add(filename);

        final Literal count = EcoreUtil.copy(obj.getCount());
        result.getParameters().add(count);

        final Array pipelines = exprFactory.createArray();
        pipelines.getValues().add(referenceTo(createPipeline("generate-empty", type("io.dl", "empty"), Map.of())));
        obj.getPipelines()
                .stream()
                .map(VariableReference::getVariable)
                .map(this.pipelines::get)
                .map(this::referenceTo)
                .forEach(pipelines.getValues()::add);

        pipelines.getValues().add(referenceTo(createPipeline("limit-count", type("misc.dl", "limit"), Map.of("count", obj.getCount().getValue()))));

        final de.evoal.models.v202704.pipeline.PipelineDefinition writer = createPipeline(WRITER_PIPELINE, type("io.dl", "writer"), Map.of("filename", obj.getFile()));
        ((de.evoal.models.v202704.pipeline.ConcreteStep) writer.getSteps().get(0)).getReads().addAll(space);
        pipelines.getValues().add(referenceTo(writer));

        result.getParameters().add(pipelines);

        return result;
    }

    /**
     * Creates a pipeline with a single step that is configured by an instance of the given
     *   type and registers it as a variable of the program.
     */
    private de.evoal.models.v202704.pipeline.PipelineDefinition createPipeline(final String name, final ClassDefinition type, final Map<String, ?> values) {
        log.info("Adding pipeline '{}'.", name);

        final de.evoal.models.v202704.pipeline.ConcreteStep step = pipeFactory.createConcreteStep();
        step.setConfiguration(transformer.createDynamic(type, values));

        final de.evoal.models.v202704.pipeline.PipelineDefinition definition = pipeFactory.createPipelineDefinition();
        definition.setName(name);
        definition.getSteps().add(step);

        this.module
            .getProgram()
            .getVariables()
            .add(definition);

        return definition;
    }

    private VariableReference referenceTo(final Variable variable) {
        final VariableReference reference = execFactory.createVariableReference();
        reference.setVariable(variable);
        return reference;
    }

    /**
     * @param name The name of a pipeline of the generator module.
     * @return A reference to the converted pipeline.
     * @throws IllegalArgumentException if the module defines no pipeline of this name.
     */
    VariableReference referenceToPipeline(final String name) {
        return pipelines.entrySet()
                        .stream()
                        .filter(e -> e.getKey() instanceof PipelineDefinition definition && name.equals(definition.getName()))
                        .map(Map.Entry::getValue)
                        .findFirst()
                        .map(this::referenceTo)
                        .orElseThrow(() -> new IllegalArgumentException(
                                "The module defines no pipeline '" + name + "'; its pipelines are "
                                + pipelines.keySet()
                                           .stream()
                                           .filter(PipelineDefinition.class::isInstance)
                                           .map(p -> "'" + ((PipelineDefinition) p).getName() + "'")
                                           .sorted()
                                           .toList()
                                + "."));
    }

    /**
     * Loads a DL file of the pipeline plugin into the resource set of the generator module.
     */
    private DefinitionModule loadDefinitions(final String file) {
        final Resource resource = resourceSet.getResource(URI.createURI("classpath:/de/evoal/pipeline/" + file), true);
        return (DefinitionModule) resource.getContents().get(0);
    }

    private ClassDefinition type(final String file, final String name) {
        return loadDefinitions(file)
                .getTypes()
                .stream()
                .filter(t -> name.equals(t.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Type '" + name + "' not found in " + file + "."));
    }
}

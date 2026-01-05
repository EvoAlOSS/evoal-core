package de.evoal.pipeline.impl.internal;

import de.evoal.core.api.ecore.Space;
import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.execution.VariableReference;
import de.evoal.languages.model.generator.*;
import de.evoal.languages.model.generator.util.GeneratorSwitch;
import de.evoal.languages.model.pipeline.PipelineFactory;
import de.evoal.languages.model.pipeline.PipelineModule;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GeneratorDSLConverter extends GeneratorSwitch<Object> {
    /* Factories for creating model instances. */
    private final ExecutionFactory execFactory = ExecutionFactory.eINSTANCE;
    private final ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;
    private final PipelineFactory pipeFactory = PipelineFactory.eINSTANCE;

    private final Map<String, EStructuralFeature> features = new HashMap<>();
    private final Map<Variable, Variable> pipelines = new HashMap<>();

    private final DefinitionModuleLoader loader;

    private final ExecutionDSLConverter converter = new ExecutionDSLConverter(this, pipelines);
    private PipelineModule module;

    public GeneratorDSLConverter(final DefinitionModuleLoader loader, final @NonNull Space space) {
        this.loader = loader;
        for(final EStructuralFeature feature : space.getEClass().getEStructuralFeatures()) {
            features.put(feature.getName(), feature);
        }
    }

    public PipelineModule convert(final GeneratorModule module) {
        log.info("Converting 'GeneratorModule {}' into a PipelineModule.", module.getName());
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
    public de.evoal.languages.model.pipeline.PipelineDefinition casePipelineDefinition(final PipelineDefinition obj) {
        log.info("Converting 'PipelineDefinition {}'.", obj.getName());

        final de.evoal.languages.model.pipeline.PipelineDefinition result = pipeFactory.createPipelineDefinition();;
        result.setName(obj.getName());

        for(final Step step : obj.getSteps()) {
            result.getSteps().add((de.evoal.languages.model.pipeline.Step) doSwitch(step));
        }

        pipelines.put(obj, result);

        return result;
    }

    @Override
    public de.evoal.languages.model.pipeline.ConcreteStep caseConcreteStep(final ConcreteStep obj) {
        log.info("  Converting 'ConcreteStep {}'", obj.getInstance().getDefinition().getName());
        final de.evoal.languages.model.pipeline.ConcreteStep result = pipeFactory.createConcreteStep();

        result.setInstance(EcoreUtil.copy(obj.getInstance()));

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
    public de.evoal.languages.model.pipeline.PipelineStep casePipelineStep(final PipelineStep obj) {
        log.info("  Converting 'PipelineStep {}'", obj.getDefinition().getName());
        final de.evoal.languages.model.pipeline.PipelineStep result = pipeFactory.createPipelineStep();

        final de.evoal.languages.model.pipeline.PipelineDefinition definition =
                (de.evoal.languages.model.pipeline.PipelineDefinition) pipelines.get(obj.getDefinition());

        result.setDefinition(definition);

        return result;
    }

    @Override
    public Object caseApplyStatement(final ApplyStatement obj) {
        log.info("Converting apply statement.");
        final DefinitionModule module = loader.load(URI.createURI("classpath:/de/evoal/pipeline/base.dl"));
        final FunctionDefinition generateFunction = module.getFunctions()
                .stream()
                .filter(t ->"generate".equals(t.getName()))
                .findFirst()
                .get();

        final de.evoal.languages.model.execution.CallBuiltinFunction result = execFactory.createCallBuiltinFunction();
        result.setDefinition(generateFunction);

        final StringLiteral filename = exprFactory.createStringLiteral();
        filename.setLiteral(obj.getFile());

        result.getParameters().add(filename);

        final Literal count = EcoreUtil.copy(obj.getCount());
        result.getParameters().add(count);

        final Array pipelines = exprFactory.createArray();;
        addGenerator(pipelines);
        obj.getPipelines()
                .stream()
                .map(VariableReference::getVariable)
                .map(this.pipelines::get)
                .map(v -> {
                    VariableReference ref = execFactory.createVariableReference();
                    ref.setVariable(v);
                    return ref;
                })
                .forEach(pipelines.getValues()::add);

        addLimiter(pipelines, obj.getCount());
        result.getParameters().add(pipelines);

        return result;
    }

    private void addLimiter(final Array pipelines, final Literal limit) {
        log.info("Adding empty object generator.");
        final DefinitionModule module = loader.load(URI.createURI("classpath:/de/evoal/pipeline/misc.dl"));
        final ClassDefinition limitFunction = module.getTypes()
                .stream()
                .filter(t ->"limit".equals(t.getName()))
                .findFirst()
                .get();

        final AttributeDefinition countAttribute = limitFunction
                .getAllAttributes()
                .stream()
                .filter(t ->"count".equals(t.getName()))
                .findFirst()
                .get();

        final Attribute attribute = exprFactory.createAttribute();
        attribute.setDefinition(countAttribute);
        attribute.setValue(EcoreUtil.copy(limit));

        final Instance instance = exprFactory.createInstance();
        instance.setDefinition(limitFunction);
        instance.getAttributes().add(attribute);

        final de.evoal.languages.model.pipeline.ConcreteStep step = pipeFactory.createConcreteStep();
        step.setInstance(instance);

        final de.evoal.languages.model.pipeline.PipelineDefinition genDefinition = pipeFactory.createPipelineDefinition();
        genDefinition.setName("limit-count");
        genDefinition.getSteps().add(step);

        this.module
                .getProgram()
                .getVariables()
                .add(genDefinition);

        final VariableReference reference = execFactory.createVariableReference();
        reference.setVariable(genDefinition);

        pipelines.getValues()
                .add(reference);
    }

    private void addGenerator(final Array pipelines) {
        log.info("Adding empty object generator.");
        final DefinitionModule module = loader.load(URI.createURI("classpath:/de/evoal/pipeline/io.dl"));
        final ClassDefinition generateFunction = module.getTypes()
                .stream()
                .filter(t ->"empty".equals(t.getName()))
                .findFirst()
                .get();

        final Instance instance = exprFactory.createInstance();
        instance.setDefinition(generateFunction);

        final de.evoal.languages.model.pipeline.ConcreteStep step = pipeFactory.createConcreteStep();
        step.setInstance(instance);

        final de.evoal.languages.model.pipeline.PipelineDefinition genDefinition = pipeFactory.createPipelineDefinition();
        genDefinition.setName("generate-empty");
        genDefinition.getSteps().add(step);

        this.module
            .getProgram()
            .getVariables()
            .add(genDefinition);

        final VariableReference reference = execFactory.createVariableReference();
        reference.setVariable(genDefinition);

        pipelines.getValues()
                 .add(0, reference);
    }
}

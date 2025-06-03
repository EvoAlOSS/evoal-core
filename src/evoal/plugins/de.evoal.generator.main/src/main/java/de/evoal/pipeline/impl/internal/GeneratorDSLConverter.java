package de.evoal.pipeline.impl.internal;

import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.types.DefinitionReference;
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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GeneratorDSLConverter extends GeneratorSwitch<Object> {
    private final ExecutionFactory execFactory = ExecutionFactory.eINSTANCE;
    private final ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;
    private final PipelineFactory pipeFactory = PipelineFactory.eINSTANCE;

    private final Map<String, EStructuralFeature> features = new HashMap<>();
    private final Map<Variable, Variable> pipelines = new HashMap<>();

    private final DefinitionModuleLoader loader;

    private final ExecutionDSLConverter converter = new ExecutionDSLConverter(this, pipelines);

    public GeneratorDSLConverter(final DefinitionModuleLoader loader, final @NonNull EClass space) {
        this.loader = loader;
        for(final EStructuralFeature feature : space.getEStructuralFeatures()) {
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
            result.getSteps().add(caseStep(step));
        }

        pipelines.put(obj, result);

        return result;
    }

    @Override
    public de.evoal.languages.model.pipeline.Step caseStep(final Step obj) {
        log.info("  Converting 'Step {}'", obj.getInstance().getDefinition().getName());
        final de.evoal.languages.model.pipeline.Step result = pipeFactory.createStep();

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
    public Object caseApplyStatement(final ApplyStatement obj) {
        log.info("Converting apply statement.");
        final DefinitionModule module = loader.load("classpath:/de/evoal/pipeline/base.dl");
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
        for(final VariableReference ref : obj.getPipelines()) {
            pipelines.getValues().add(converter.caseVariableReference(ref));
        }
        result.getParameters().add(pipelines);


        return result;
    }
}

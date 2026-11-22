package de.evoal.surrogate.main.internal;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Stream;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.models.core.ecore.Space;
import de.evoal.languages.model.base.BaseFactory;
import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.execution.*;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.PipelineDefinition;
import de.evoal.languages.model.generator.PipelineStep;
import de.evoal.languages.model.generator.util.GeneratorSwitch;
import de.evoal.languages.model.mll.*;
import de.evoal.models.v202704.pipeline.PipelineFactory;
import de.evoal.models.v202704.pipeline.PipelineModule;
import de.evoal.models.v202704.pipeline.Step;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import jakarta.inject.Inject;


/**
 * Converts a MLL module into the corresponding pipeline module.
 */
@Slf4j
public class MLLModelConverter extends GeneratorSwitch<Object> {
    /* Factories for creating model instances. */
    private final static BaseFactory baseFactory = BaseFactory.eINSTANCE;
    private final static ExecutionFactory execFactory = ExecutionFactory.eINSTANCE;
    private final static PipelineFactory pipeFactory = PipelineFactory.eINSTANCE;

    /**
     * For converting the execution part.
     */
    private final ExecutionModelConverter execConverter;

    /**
     * For converting the expression part.
     */
    private final ExpressionConverter exprConverter;

    /**
     * Helper for mapping between old and new space definitions.
     */
    private final EAnnotationHelper helper;

    /**
     * For loading definition files.
     */
    private final DefinitionModuleLoader loader;

    /**
     * Late resolving of references
     */
    private final List<Runnable> referenceResolution = new LinkedList<>();

    /**
     * The use case attributes to convert, in the order in which they run.
     */
    private final List<EStructuralFeature> useCases;

    /**
     * The variable mapping from the input model to the output model.
     */
    private final Map<Variable, Variable> variableMapping = new HashMap<>();

    /**
     * The space definition of the pipeline.
     */
    private final Space space;

    /**
     * For creating the runtime configurations of the pipeline steps.
     */
    private final ModelTransformer transformer;

    public MLLModelConverter(final DefinitionModuleLoader loader, final EAnnotationHelper helper, final Space space, final List<EStructuralFeature> useCaseAttributes, final ModelTransformer transformer) {
        this.loader = loader;
        this.helper = helper;
        this.space = space;
        this.useCases = useCaseAttributes;
        this.transformer = transformer;
        this.exprConverter = new ExpressionConverter(this);
        this.execConverter = new ExecutionModelConverter(variableMapping, exprConverter);
    }

    /**
     * Converts the configured use cases: each use case that the module contains becomes a
     *   function named after it (e.g. {@code learning}), and the main function calls them in
     *   the configured order.
     *
     * @param inputModule A valid machine-learning module.
     * @return An equivalent pipeline module.
     */
    @SneakyThrows
    public PipelineModule convert(final MachineLearningModule inputModule) {
        log.info("Converting machine-learning module '{}'.", inputModule.getName());
        final PipelineModule outputModule = pipeFactory.createPipelineModule();
        // copy module name
        outputModule.setName(inputModule.getName());
        // copy imports
        inputModule.getImports()
                .stream()
                .map(this::caseImport)
                .forEachOrdered(outputModule.getImports()::add);

        final List<Variable> variables = new ArrayList<>();

        // convert pre-defined pipelines
        Stream.of(
                inputModule.getValidation(),
                inputModule.getPreparation(),
                inputModule.getPredictionUseCase()
               )
              .map(this::casePipelineDefinition)
              .forEach(variables::add);

        // create the final program
        final Program program = execFactory.createProgram();
        outputModule.setProgram(program);

        final TaskDescription descr = inputModule.getTask();
        final TaskDescription copy = EcoreUtil.copy(descr);
        variables.add(copy);

        final Block gofStatements = inputModule.getGof();
        final Block gofBlock = execConverter.caseBlock(gofStatements);
        final ModelFunction gofFunction = createFunction(program, "goodness-of-fit", gofBlock);
        execConverter.setGofFunction(gofFunction);

        // convert the use cases and call them from main
        final Block mainBlock = execFactory.createBlock();
        for(final EStructuralFeature useCase : useCases) {
            final Block useCaseStatements = (Block)inputModule.eGet(useCase);
            if(useCaseStatements == null) {
                continue;
            }

            final String name = useCase.getName().replace("UseCase", "");
            log.info("Converting use case '{}'.", name);
            final ModelFunction useCaseFunction = createFunction(program, name, execConverter.caseBlock(useCaseStatements));

            final CallModelFunction call = execFactory.createCallModelFunction();
            call.setFunction(useCaseFunction);
            mainBlock.getStatements().add(call);
        }

        final ModelFunction mainFunction = createFunction(program,"main", mainBlock);

        // create the program
        program.setMain(mainFunction);
        program.getVariables()
               .addAll(variables);


        // resolve references
        try {
            referenceResolution.forEach(Runnable::run);
        } catch(final Exception e) {
            log.warn("Failed to resolve reference.", e);
        }

        return outputModule;
    }

    private ModelFunction createFunction(final @NonNull Program program,  final @NonNull String name, final Block block) {
        // create the main function that calls the use case
        final ModelFunction function = execFactory.createModelFunction();
        function.setName(name);
        function.setBody(block);

        program.getFunctions()
               .add(function);

        return function;
    }

    private Import caseImport(final Import _import) {
        final Import result = baseFactory.createImport();
        result.setImportedNamespace(_import.getImportedNamespace());
        result.setLanguage(_import.getLanguage());

        return result;
    }

    @Override
    public de.evoal.models.v202704.pipeline.PipelineDefinition casePipelineDefinition(final PipelineDefinition definition) {
        final de.evoal.models.v202704.pipeline.PipelineDefinition result = pipeFactory.createPipelineDefinition();
        result.setName(definition.getName());

        definition.getSteps()
                .stream()
                .map(this::doSwitch)
                .map(Step.class::cast)
                .forEach(result.getSteps()::add);

        // register for later lookup
        variableMapping.put(definition, result);

        return result;
    }

    @Override
    public de.evoal.models.v202704.pipeline.PipelineStep casePipelineStep(final PipelineStep step) {
        log.info("Concerting pipeline step ...");
        final de.evoal.models.v202704.pipeline.PipelineStep result = pipeFactory.createPipelineStep();

        referenceResolution.add(() -> result.setDefinition((de.evoal.models.v202704.pipeline.PipelineDefinition) variableMapping.get(step.getDefinition())));

        return result;
    }

    @Override
    public de.evoal.models.v202704.pipeline.ConcreteStep caseConcreteStep(final ConcreteStep step) {
        log.info("Concerting concrete step '{}' ...", step.getInstance().getDefinition().getName());

        final de.evoal.models.v202704.pipeline.ConcreteStep result = pipeFactory.createConcreteStep();
        result.setConfiguration(transformer.createDynamic(step.getInstance()));

        final Map<DataDescription, EStructuralFeature> featureMap = helper.featuresOf(space.getEClass());

        step.getReads()
                .stream()
                .map(TypeDefinitionReference::getDefinition)
                .map(DataDescription.class::cast)
                .map(featureMap::get)
                .forEach(result.getReads()::add);

        step.getWrites()
                .stream()
                .map(TypeDefinitionReference::getDefinition)
                .map(DataDescription.class::cast)
                .map(featureMap::get)
                .forEach(result.getWrites()::add);

        return result;
    }

    @Override
    public Object defaultCase(EObject object) {
        throw new UnsupportedOperationException("Not supported yet: " + object);
    }
}

package de.evoal.surrogate.main.internal;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.execution.Block;
import de.evoal.languages.model.execution.CallBuiltinFunction;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.PipelineStep;
import de.evoal.languages.model.generator.GeneratorFactory;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Injects the default behaviour into the module. This allows us to encapsulate this
 *   information into a single place.
 */
@Slf4j
public class DefaultBehaviourInjector {
    /**
     * For creating expression elements.
     */
    private final static ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;

    /**
     * The DL module of the {@code 'execute'} function.
     */
    private final static String PIPELINE_BASE = "de.evoal.pipeline.base";

    /**
     * The DL module of the surrogate pipeline components and functions.
     */
    private final static String SURROGATE_PIPELINE = "de.evoal.surrogate.pipeline";

    /**
     * For loading definition modules.
     */
    private final DefinitionModuleLoader loader;

    /**
     * The input space we are working on.
     */
    private final List<DataDescription> inputs;

    /**
     * The output space we are working on.
     */
    private final List<DataDescription> outputs;

    public DefaultBehaviourInjector(final @NonNull DefinitionModuleLoader loader,
                                    final @NonNull List<DataDescription> inputs,
                                    final @NonNull List<DataDescription> outputs) {
        this.loader = loader;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public void inject(final MachineLearningModule module) {
        log.info("Injecting default behaviour into machine learning module {}.", module.getName());

        injectDefaultPipelines(module);
        injectAccessedData(module);
        injectTestingUseCase(module);

        linkLearner(module);
    }

    private void linkLearner(final MachineLearningModule module) {
        final Instance modelConfiguration = module.getModel();

        final TreeIterator<EObject> contents = module.eAllContents();
        while (contents.hasNext()) {
            final EObject element = contents.next();

            if(element instanceof Instance instance) {
                final ClassDefinition classDefinition = instance.getDefinition();
                final DefinitionModule defModule = (DefinitionModule) classDefinition.eContainer();

                if(!"model-learner".equals(classDefinition.getName()) || !"de.evoal.surrogate.pipeline".equals(defModule.getName())) {
                    continue;
                }

                Attribute attribute = instance.findAttribute("model");
                if(attribute == null) {
                    log.info("Copying model definition to model learner.");
                    final AttributeDefinition attrDefinition = classDefinition.findAttribute("model");
                    attribute = exprFactory.createAttribute();
                    attribute.setDefinition(attrDefinition);
                    attribute.setValue(EcoreUtil.copy(modelConfiguration));

                    instance.getAttributes().add(attribute);
                }

                attribute = instance.findAttribute("model-file");
                if(attribute == null) {
                    log.info("Copying model file to model learner.");
                    final StringLiteral literal = exprFactory.createStringLiteral();
                    literal.setLiteral(module.getTask().getModelFile());


                    final AttributeDefinition attrDefinition = classDefinition.findAttribute("model-file");
                    attribute = exprFactory.createAttribute();
                    attribute.setDefinition(attrDefinition);
                    attribute.setValue(literal);

                    instance.getAttributes().add(attribute);
                }

                attribute = instance.findAttribute("input-features");
                if(attribute == null) {
                    log.info("Copying input features to model learner.");
                    final Array array = exprFactory.createArray();

                    module.getTask()
                          .getInputs()
                          .stream()
                            .map(d -> {
                                final TypeDefinitionReference ref = exprFactory.createTypeDefinitionReference();
                                ref.setDefinition(d);
                                return ref;
                            })
                          .forEach(array.getValues()::add);

                    final AttributeDefinition attrDefinition = classDefinition.findAttribute("input-features");
                    attribute = exprFactory.createAttribute();
                    attribute.setDefinition(attrDefinition);
                    attribute.setValue(array);

                    instance.getAttributes()
                            .add(attribute);
                }

                attribute = instance.findAttribute("output-features");
                if(attribute == null) {
                    log.info("Copying output features to model learner.");
                    final Array array = exprFactory.createArray();

                    module.getTask()
                            .getOutputs()
                            .stream()
                            .map(d -> {
                                final TypeDefinitionReference ref = exprFactory.createTypeDefinitionReference();
                                ref.setDefinition(d);
                                return ref;
                            })
                            .forEach(array.getValues()::add);

                    final AttributeDefinition attrDefinition = classDefinition.findAttribute("output-features");
                    attribute = exprFactory.createAttribute();
                    attribute.setDefinition(attrDefinition);
                    attribute.setValue(array);

                    instance.getAttributes()
                            .add(attribute);
                }
            }
        }
    }

    /**
     * Adds the default testing use case if the learning task has test data
     *   ({@code testing with [...]}) and the module does not write out the use case:
     *
     * <pre>
     *   specify testing begin
     *     'execute'([
     *       step { component 'test-data-loader' {} writes [inputs, outputs] },
     *       pipeline 'validation',
     *       step { component 'assessment-data' { 'data-set' := "test"; } reads [inputs, outputs] }
     *     ]);
     *     'gof-calculator'();
     *     'store-model'();
     *   end;
     * </pre>
     */
    private void injectTestingUseCase(final MachineLearningModule module) {
        if(module.getTestingUseCase() != null || module.getTask().getTestingData().isEmpty()) {
            return;
        }

        log.info("Adding the default testing use case for the test data {}.", module.getTask().getTestingData());

        final DefinitionModule pipelineBase = findDefinitionModule(module, PIPELINE_BASE);
        final DefinitionModule surrogatePipeline = findDefinitionModule(module, SURROGATE_PIPELINE);

        final ConcreteStep loaderStep = concreteStep(findType(surrogatePipeline, "test-data-loader"));
        loaderStep.getWrites().addAll(combinedSpaces());

        final PipelineStep validationStep = GeneratorFactory.eINSTANCE.createPipelineStep();
        validationStep.setDefinition(module.getValidation());

        final ConcreteStep assessmentStep = concreteStep(findType(surrogatePipeline, "assessment-data"));
        final StringLiteral dataSet = exprFactory.createStringLiteral();
        dataSet.setLiteral(GoodnessOfFit.TEST);
        final Attribute dataSetAttribute = exprFactory.createAttribute();
        dataSetAttribute.setDefinition(assessmentStep.getInstance().getDefinition().findAttribute("data-set"));
        dataSetAttribute.setValue(dataSet);
        assessmentStep.getInstance().getAttributes().add(dataSetAttribute);
        assessmentStep.getReads().addAll(combinedSpaces());

        final Array steps = exprFactory.createArray();
        steps.getValues().add(loaderStep);
        steps.getValues().add(validationStep);
        steps.getValues().add(assessmentStep);

        final Block testing = ExecutionFactory.eINSTANCE.createBlock();
        testing.getStatements().add(call(findFunction(pipelineBase, "execute"), steps));
        testing.getStatements().add(call(findFunction(surrogatePipeline, "gof-calculator")));
        testing.getStatements().add(call(findFunction(surrogatePipeline, "store-model")));

        module.setTestingUseCase(testing);
    }

    private static ConcreteStep concreteStep(final ClassDefinition type) {
        final Instance instance = exprFactory.createInstance();
        instance.setDefinition(type);

        final ConcreteStep step = GeneratorFactory.eINSTANCE.createConcreteStep();
        step.setInstance(instance);

        return step;
    }

    private static CallBuiltinFunction call(final FunctionDefinition function, final Expression... parameters) {
        final CallBuiltinFunction call = ExecutionFactory.eINSTANCE.createCallBuiltinFunction();
        call.setDefinition(function);
        call.getParameters().addAll(List.of(parameters));

        return call;
    }

    /**
     * Finds a DL module among the modules that the MLL file imports, or loads it from the class
     *   path.
     */
    private DefinitionModule findDefinitionModule(final MachineLearningModule module, final String name) {
        if(module.eResource() != null && module.eResource().getResourceSet() != null) {
            for(final Resource resource : module.eResource().getResourceSet().getResources()) {
                if(!resource.getContents().isEmpty()
                        && resource.getContents().get(0) instanceof DefinitionModule definitions
                        && name.equals(definitions.getName())) {
                    return definitions;
                }
            }
        }

        log.info("Loading DL module '{}' for the default testing use case.", name);
        return loader.load(URI.createURI("classpath:/" + name.replace('.', '/') + ".dl"));
    }

    private static ClassDefinition findType(final DefinitionModule module, final String name) {
        return module.getTypes()
                     .stream()
                     .filter(t -> name.equals(t.getName()))
                     .findFirst()
                     .orElseThrow(() -> new IllegalStateException("DL module '" + module.getName() + "' has no type '" + name + "'."));
    }

    private static FunctionDefinition findFunction(final DefinitionModule module, final String name) {
        return module.getFunctions()
                     .stream()
                     .filter(f -> name.equals(f.getName()))
                     .findFirst()
                     .orElseThrow(() -> new IllegalStateException("DL module '" + module.getName() + "' has no function '" + name + "'."));
    }

    private Collection<? extends TypeDefinitionReference> combinedSpaces() {
        return Stream.concat(inputs.stream(), outputs.stream())
                    .map(is -> {
                        final TypeDefinitionReference ref = exprFactory.createTypeDefinitionReference();
                        ref.setDefinition(is);
                        return ref;
                    })
                    .toList();
    }

    private void injectDefaultPipelines(final MachineLearningModule module) {
        log.info("Injecting default pipelines into machine learning module {}.", module.getName());
    }

    private void injectAccessedData(final MachineLearningModule module) {
        log.info("Injecting accessed data into machine learning module {}.", module.getName());
    }
}

package de.evoal.surrogate.main.internal;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.execution.Block;
import de.evoal.languages.model.execution.CallBuiltinFunction;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.GeneratorFactory;
import de.evoal.languages.model.generator.PipelineDefinition;
import de.evoal.languages.model.generator.PipelineStep;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.mll.TaskDescription;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Derives the use cases of an MLL module and the settings of their standard steps from the
 *   learning task, unless the module states them:
 *
 * <ul>
 *   <li>A use case that the module does not write out gets its default: learning, predicting
 *     and, if the learning task has test data ({@code testing with [...]}), testing.</li>
 *   <li>A standard step of {@value #SURROGATE_PIPELINE} without {@code reads} or {@code writes}
 *     gets the features of the learning task, and its left-out attributes are derived from
 *     the module.</li>
 *   <li>Every feature that a standard step states in {@code reads}, {@code writes} or its
 *     feature attributes must belong to the learning task: a deliberate subset is allowed,
 *     a feature outside the task stops the run.</li>
 * </ul>
 *
 * The effective use cases are logged.
 */
@Slf4j
public class UseCaseDerivation {
    /**
     * For creating expression elements.
     */
    private final static ExpressionsFactory exprFactory = ExpressionsFactory.eINSTANCE;

    /**
     * The DL module of the {@code 'execute'} function.
     */
    private final static String PIPELINE_BASE = "de.evoal.pipeline.base";

    /**
     * The DL module of the standard steps and the surrogate functions.
     */
    private final static String SURROGATE_PIPELINE = "de.evoal.surrogate.pipeline";

    private final static String TRAINING_DATA_LOADER = "training-data-loader";
    private final static String TEST_DATA_LOADER = "test-data-loader";
    private final static String MODEL_LEARNER = "model-learner";
    private final static String MODEL_PREDICTION = "model-prediction";
    private final static String ASSESSMENT_DATA = "assessment-data";

    private final static String INPUT_FEATURES = "input-features";
    private final static String OUTPUT_FEATURES = "output-features";

    /**
     * For loading definition modules that the MLL file does not import.
     */
    private final DefinitionModuleLoader loader;

    public UseCaseDerivation(final @NonNull DefinitionModuleLoader loader) {
        this.loader = loader;
    }

    /**
     * Adds the missing use cases, fills the missing settings of the standard steps, checks
     *   the stated features against the learning task and logs the effective use cases.
     *
     * @param module The module to complete.
     * @throws IllegalStateException if a standard step states a feature outside the learning
     *   task or the testing use case has no test data.
     */
    public void derive(final @NonNull MachineLearningModule module) {
        log.info("Deriving the use cases of machine learning module '{}' from its learning task.", module.getName());

        if(module.getLearningUseCase() == null) {
            module.setLearningUseCase(defaultLearning(module));
        }

        if(module.getPredictionUseCase() == null) {
            module.setPredictionUseCase(defaultPredicting(module));
        }

        if(module.getTestingUseCase() == null && !module.getTask().getTestingData().isEmpty()) {
            module.setTestingUseCase(defaultTesting(module));
        }

        final List<ConcreteStep> steps = standardSteps(module);
        steps.forEach(step -> derive(module, step));

        final List<String> errors = new ArrayList<>();
        steps.forEach(step -> check(module, step, errors));
        if(!errors.isEmpty()) {
            errors.forEach(log::error);
            throw new IllegalStateException(String.join("\n", errors));
        }

        log.info("Effective use cases of machine learning module '{}':\n{}", module.getName(), new UseCasePrinter().print(module));
    }

    /**
     * <pre>
     *   specify learning begin
     *     'execute'([
     *       step { component 'training-data-loader' {} },
     *       pipeline 'validation',
     *       pipeline 'preparation',
     *       step { component 'model-learner' {} }
     *     ]);
     *     'gof-calculator'();
     *     'store-model'();
     *   end;
     * </pre>
     */
    private Block defaultLearning(final MachineLearningModule module) {
        log.info("Adding the default learning use case.");
        final DefinitionModule surrogatePipeline = findDefinitionModule(module, SURROGATE_PIPELINE);

        return useCase(module,
                       concreteStep(findType(surrogatePipeline, TRAINING_DATA_LOADER)),
                       pipelineStep(module.getValidation()),
                       pipelineStep(module.getPreparation()),
                       concreteStep(findType(surrogatePipeline, MODEL_LEARNER)));
    }

    /**
     * <pre>
     *   specify predicting begin
     *     pipeline 'preparation'
     *     step { component 'model-prediction' {} }
     *   end;
     * </pre>
     */
    private PipelineDefinition defaultPredicting(final MachineLearningModule module) {
        log.info("Adding the default predicting use case.");
        final DefinitionModule surrogatePipeline = findDefinitionModule(module, SURROGATE_PIPELINE);

        final PipelineDefinition predicting = GeneratorFactory.eINSTANCE.createPipelineDefinition();
        predicting.setName("predicting");
        predicting.getSteps().add(pipelineStep(module.getPreparation()));
        predicting.getSteps().add(concreteStep(findType(surrogatePipeline, MODEL_PREDICTION)));

        return predicting;
    }

    /**
     * <pre>
     *   specify testing begin
     *     'execute'([
     *       step { component 'test-data-loader' {} },
     *       pipeline 'validation',
     *       step { component 'assessment-data' { 'data-set' := "test"; } }
     *     ]);
     *     'gof-calculator'();
     *     'store-model'();
     *   end;
     * </pre>
     */
    private Block defaultTesting(final MachineLearningModule module) {
        log.info("Adding the default testing use case for the test data {}.", module.getTask().getTestingData());
        final DefinitionModule surrogatePipeline = findDefinitionModule(module, SURROGATE_PIPELINE);

        final ConcreteStep assessmentStep = concreteStep(findType(surrogatePipeline, ASSESSMENT_DATA));
        setAttribute(assessmentStep.getInstance(), "data-set", stringLiteral(GoodnessOfFit.TEST));

        return useCase(module,
                       concreteStep(findType(surrogatePipeline, TEST_DATA_LOADER)),
                       pipelineStep(module.getValidation()),
                       assessmentStep);
    }

    /**
     * Builds {@code 'execute'([steps]); 'gof-calculator'(); 'store-model'();}.
     */
    private Block useCase(final MachineLearningModule module, final ReadExpression... steps) {
        final DefinitionModule pipelineBase = findDefinitionModule(module, PIPELINE_BASE);
        final DefinitionModule surrogatePipeline = findDefinitionModule(module, SURROGATE_PIPELINE);

        final Array array = exprFactory.createArray();
        array.getValues().addAll(List.of(steps));

        final Block block = ExecutionFactory.eINSTANCE.createBlock();
        block.getStatements().add(call(findFunction(pipelineBase, "execute"), array));
        block.getStatements().add(call(findFunction(surrogatePipeline, "gof-calculator")));
        block.getStatements().add(call(findFunction(surrogatePipeline, "store-model")));

        return block;
    }

    /**
     * Fills the missing {@code reads}, {@code writes} and attributes of a standard step.
     */
    private void derive(final MachineLearningModule module, final ConcreteStep step) {
        final TaskDescription task = module.getTask();
        final Instance instance = step.getInstance();

        switch(instance.getDefinition().getName()) {
            case TRAINING_DATA_LOADER -> {
                deriveFeatures(step.getWrites(), task.getInputs(), task.getOutputs());
                deriveAttribute(instance, "training-files", () -> stringArray(task.getLearningData()));
                deriveFeatureAttributes(instance, task);
            }
            case TEST_DATA_LOADER -> {
                deriveFeatures(step.getWrites(), task.getInputs(), task.getOutputs());
                deriveAttribute(instance, "testing-files", () -> stringArray(task.getTestingData()));
                deriveFeatureAttributes(instance, task);
            }
            case MODEL_LEARNER -> {
                deriveFeatures(step.getReads(), task.getInputs(), task.getOutputs());
                deriveAttribute(instance, "model", () -> EcoreUtil.copy(module.getModel()));
                deriveAttribute(instance, "model-file", () -> stringLiteral(task.getModelFile()));
                deriveFeatureAttributes(instance, task);
            }
            case MODEL_PREDICTION -> {
                deriveFeatures(step.getReads(), task.getInputs());
                deriveFeatures(step.getWrites(), task.getOutputs());
            }
            case ASSESSMENT_DATA -> deriveFeatures(step.getReads(), task.getInputs(), task.getOutputs());
            default -> {
            }
        }
    }

    @SafeVarargs
    private static void deriveFeatures(final EList<TypeDefinitionReference> features, final List<DataDescription>... descriptions) {
        if(features.isEmpty()) {
            features.addAll(references(Stream.of(descriptions).flatMap(List::stream).toList()));
        }
    }

    private static void deriveFeatureAttributes(final Instance instance, final TaskDescription task) {
        deriveAttribute(instance, INPUT_FEATURES, () -> dataArray(task.getInputs()));
        deriveAttribute(instance, OUTPUT_FEATURES, () -> dataArray(task.getOutputs()));
    }

    private static void deriveAttribute(final Instance instance, final String name, final Supplier<Expression> value) {
        if(instance.findAttribute(name) == null) {
            setAttribute(instance, name, value.get());
        }
    }

    /**
     * Checks the features that a standard step states against the learning task.
     */
    private static void check(final MachineLearningModule module, final ConcreteStep step, final List<String> errors) {
        final TaskDescription task = module.getTask();
        final List<DataDescription> taskFeatures = Stream.concat(task.getInputs().stream(), task.getOutputs().stream()).toList();
        final String where = "Module '" + module.getName() + "', " + useCaseOf(module, step) + ", step '" + step.getInstance().getDefinition().getName() + "'";

        checkFeatures(step.getReads().stream().map(TypeDefinitionReference::getDefinition).toList(), taskFeatures,
                      where + ": 'reads' contains '%s', which is not an input or output feature of the learning task.", errors);
        checkFeatures(step.getWrites().stream().map(TypeDefinitionReference::getDefinition).toList(), taskFeatures,
                      where + ": 'writes' contains '%s', which is not an input or output feature of the learning task.", errors);
        checkFeatures(featuresOf(step.getInstance(), INPUT_FEATURES), task.getInputs(),
                      where + ": '" + INPUT_FEATURES + "' contains '%s', which is not an input feature of the learning task.", errors);
        checkFeatures(featuresOf(step.getInstance(), OUTPUT_FEATURES), task.getOutputs(),
                      where + ": '" + OUTPUT_FEATURES + "' contains '%s', which is not an output feature of the learning task.", errors);

        if(TEST_DATA_LOADER.equals(step.getInstance().getDefinition().getName())
                && arrayOf(step.getInstance().findAttribute("testing-files")) instanceof Array files
                && files.getValues().isEmpty()) {
            errors.add(where + ": no test data; add 'testing with [\"<file>\"]' to 'specify learning-task' or 'testing-files' to the step.");
        }
    }

    private static void checkFeatures(final List<TypeDefinition> stated, final List<DataDescription> allowed, final String message, final List<String> errors) {
        stated.stream()
              .filter(feature -> !allowed.contains(feature))
              .map(feature -> String.format(message, feature.getName()))
              .forEach(errors::add);
    }

    /**
     * @return The data features of a feature attribute, or an empty list if the step has no
     *   such attribute or its value is not an array of data references.
     */
    private static List<TypeDefinition> featuresOf(final Instance instance, final String name) {
        if(!(arrayOf(instance.findAttribute(name)) instanceof Array array)) {
            return List.of();
        }

        return array.getValues()
                    .stream()
                    .map(ElementSwitch::elementOf)
                    .flatMap(Optional::stream)
                    .filter(TypeDefinitionReference.class::isInstance)
                    .map(TypeDefinitionReference.class::cast)
                    .map(TypeDefinitionReference::getDefinition)
                    .toList();
    }

    /**
     * @return The array that the value of the attribute consists of, or {@code null} if there
     *   is no attribute or its value is not an array.
     */
    private static Array arrayOf(final Attribute attribute) {
        if(attribute == null) {
            return null;
        }

        return ElementSwitch.elementOf(attribute.getValue())
                            .filter(Array.class::isInstance)
                            .map(Array.class::cast)
                            .orElse(null);
    }

    /**
     * @return The name of the use case or pipeline of the module that contains the element,
     *   e.g. "use case 'predicting'".
     */
    private static String useCaseOf(final MachineLearningModule module, final EObject element) {
        EObject current = element;
        while(current.eContainer() != null && current.eContainer() != module) {
            current = current.eContainer();
        }

        if(current == module.getLearningUseCase()) {
            return "use case 'learning'";
        } else if(current == module.getPredictionUseCase()) {
            return "use case 'predicting'";
        } else if(current == module.getTestingUseCase()) {
            return "use case 'testing'";
        } else if(current instanceof PipelineDefinition pipeline) {
            return "pipeline '" + pipeline.getName() + "'";
        }

        return current.eContainingFeature() != null ? "'" + current.eContainingFeature().getName() + "'" : "module";
    }

    /**
     * @return All steps of the module whose type belongs to {@value #SURROGATE_PIPELINE}.
     */
    private static List<ConcreteStep> standardSteps(final MachineLearningModule module) {
        final List<ConcreteStep> steps = new ArrayList<>();
        module.eAllContents().forEachRemaining(element -> {
            if(element instanceof ConcreteStep step
                    && step.getInstance() != null
                    && step.getInstance().getDefinition().eContainer() instanceof DefinitionModule definitions
                    && SURROGATE_PIPELINE.equals(definitions.getName())) {
                steps.add(step);
            }
        });

        return steps;
    }

    private static void setAttribute(final Instance instance, final String name, final Expression value) {
        final Attribute attribute = exprFactory.createAttribute();
        attribute.setDefinition(instance.getDefinition().findAttribute(name));
        attribute.setValue(value);

        instance.getAttributes().add(attribute);
    }

    private static StringLiteral stringLiteral(final String value) {
        final StringLiteral literal = exprFactory.createStringLiteral();
        literal.setLiteral(value);

        return literal;
    }

    private static Array stringArray(final List<String> values) {
        final Array array = exprFactory.createArray();
        values.stream()
              .map(UseCaseDerivation::stringLiteral)
              .forEach(array.getValues()::add);

        return array;
    }

    private static Array dataArray(final List<DataDescription> features) {
        final Array array = exprFactory.createArray();
        array.getValues().addAll(references(features));

        return array;
    }

    private static Collection<TypeDefinitionReference> references(final List<DataDescription> features) {
        return features.stream()
                       .map(feature -> {
                           final TypeDefinitionReference reference = exprFactory.createTypeDefinitionReference();
                           reference.setDefinition(feature);
                           return reference;
                       })
                       .toList();
    }

    private static ConcreteStep concreteStep(final ClassDefinition type) {
        final Instance instance = exprFactory.createInstance();
        instance.setDefinition(type);

        final ConcreteStep step = GeneratorFactory.eINSTANCE.createConcreteStep();
        step.setInstance(instance);

        return step;
    }

    private static PipelineStep pipelineStep(final PipelineDefinition definition) {
        final PipelineStep step = GeneratorFactory.eINSTANCE.createPipelineStep();
        step.setDefinition(definition);

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

        log.info("Loading DL module '{}' for the default use cases.", name);
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
}

package de.evoal.surrogate.main.internal;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
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
 *   <li>A use case that the module does not write out gets its default: learning, predicting,
 *     testing if the learning task has test data ({@code testing with [...]}), and resampling
 *     if it states resampling schemes ({@code assessing with [...]}).</li>
 *   <li>A standard step of {@value #SURROGATE_PIPELINE} without {@code reads} or {@code writes}
 *     gets the features of the learning task, and its left-out attributes are derived from
 *     the module.</li>
 *   <li>Every feature that a standard step states in {@code reads}, {@code writes} or its
 *     feature attributes must belong to the learning task: a deliberate subset is allowed,
 *     a feature outside the task stops the run.</li>
 *   <li>Every resampling scheme is stated at most once, since its name is the name of its data
 *     set, and the feature of {@code 'given-blocks'} is neither an input nor an output
 *     feature.</li>
 *   <li>A learning use case that calls {@code 'gof-calculator'} records the training rows
 *     after {@code validation} with {@code 'assessment-data' { 'data-set' := "training"; }}:
 *     the goodness of fit on the training data and the estimates of the surrogate adaption
 *     use these rows, so they see the rows the model learned from.</li>
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
    private final static String GIVEN_BLOCKS = "given-blocks";
    private final static String GOF_CALCULATOR = "gof-calculator";
    private final static String DATA_SET = "data-set";

    private final static String PREPARATION_STEP = "preparation-step";
    private final static String FEATURES = "features";
    private final static String INVERSE = "inverse";

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
     *   task, the testing use case has no test data, a resampling scheme is wrong, or the
     *   learning use case assesses the training data without recording its rows.
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

        if(module.getResamplingUseCase() == null && !module.getTask().getResampling().isEmpty()) {
            module.setResamplingUseCase(defaultResampling(module));
        }

        final List<ConcreteStep> steps = standardSteps(module);
        steps.forEach(step -> derive(module, step));

        final List<String> errors = new ArrayList<>();
        steps.forEach(step -> check(module, step, errors));
        checkResampling(module, errors);
        checkLearning(module, errors);
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
     *       step { component 'assessment-data' { 'data-set' := "training"; } },
     *       pipeline 'preparation',
     *       step { component 'model-learner' {} }
     *     ]);
     *     'gof-calculator'();
     *     'store-model'();
     *   end;
     * </pre>
     * The training rows are recorded before {@code preparation}: the goodness of fit predicts
     *   through the prediction pipeline, which prepares the rows itself.
     */
    private Block defaultLearning(final MachineLearningModule module) {
        log.info("Adding the default learning use case.");
        final DefinitionModule surrogatePipeline = findDefinitionModule(module, SURROGATE_PIPELINE);

        return useCase(module,
                       concreteStep(findType(surrogatePipeline, TRAINING_DATA_LOADER)),
                       pipelineStep(module.getValidation()),
                       assessmentStep(surrogatePipeline, GoodnessOfFit.TRAINING),
                       pipelineStep(module.getPreparation()),
                       concreteStep(findType(surrogatePipeline, MODEL_LEARNER)));
    }

    /**
     * @return {@code step { component 'assessment-data' { 'data-set' := "<dataSet>"; } }}.
     */
    private static ConcreteStep assessmentStep(final DefinitionModule surrogatePipeline, final String dataSet) {
        final ConcreteStep step = concreteStep(findType(surrogatePipeline, ASSESSMENT_DATA));
        setAttribute(step.getInstance(), DATA_SET, stringLiteral(dataSet));

        return step;
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

        return useCase(module,
                       concreteStep(findType(surrogatePipeline, TEST_DATA_LOADER)),
                       pipelineStep(module.getValidation()),
                       assessmentStep(surrogatePipeline, GoodnessOfFit.TEST));
    }

    /**
     * <pre>
     *   specify resampling begin
     *     'resample'(&lt;scheme&gt;,
     *                [pipeline 'validation', pipeline 'preparation', step { component 'model-learner' {} }],
     *                [pipeline 'validation']);     // per scheme of assessing with [...]
     *     'store-model'();
     *   end;
     * </pre>
     */
    private Block defaultResampling(final MachineLearningModule module) {
        log.info("Adding the default resampling use case for the schemes {}.",
                 module.getTask().getResampling().stream().map(scheme -> scheme.getDefinition().getName()).toList());
        final DefinitionModule surrogatePipeline = findDefinitionModule(module, SURROGATE_PIPELINE);

        final Block block = ExecutionFactory.eINSTANCE.createBlock();
        for(final Instance scheme : module.getTask().getResampling()) {
            final Array learning = exprFactory.createArray();
            learning.getValues().addAll(List.of(pipelineStep(module.getValidation()),
                                                pipelineStep(module.getPreparation()),
                                                concreteStep(findType(surrogatePipeline, MODEL_LEARNER))));

            final Array assessment = exprFactory.createArray();
            assessment.getValues().add(pipelineStep(module.getValidation()));

            block.getStatements().add(call(findFunction(surrogatePipeline, "resample"), EcoreUtil.copy(scheme), learning, assessment));
        }
        block.getStatements().add(call(findFunction(surrogatePipeline, "store-model")));

        return block;
    }

    /**
     * Checks the resampling schemes of the learning task: each scheme at most once, and the
     *   feature of {@code 'given-blocks'} neither an input nor an output feature.
     */
    private static void checkResampling(final MachineLearningModule module, final List<String> errors) {
        final TaskDescription task = module.getTask();
        final String where = "Module '" + module.getName() + "', 'assessing with'";

        final java.util.Set<String> seen = new java.util.HashSet<>();
        for(final Instance scheme : task.getResampling()) {
            final String name = scheme.getDefinition().getName();
            if(!seen.add(name)) {
                errors.add(where + ": '" + name + "' is stated twice; each scheme names its data set and may be stated once.");
            }
        }

        task.getResampling()
            .forEach(scheme -> scheme.eAllContents().forEachRemaining(element -> {
                if(element instanceof Instance blocks && GIVEN_BLOCKS.equals(blocks.getDefinition().getName())) {
                    featuresOf(blocks, "feature").stream()
                                                 .filter(feature -> task.getInputs().contains(feature) || task.getOutputs().contains(feature))
                                                 .forEach(feature -> errors.add(where + ": the feature '" + feature.getName() + "' of '" + GIVEN_BLOCKS
                                                                                + "' is a feature of the learning task; the blocks need a feature of their own."));
                }
            }));
    }

    /**
     * Checks that a learning use case that calls {@value #GOF_CALCULATOR} records the training
     *   rows: a step {@code 'assessment-data' { 'data-set' := "training"; }}, in the use case or
     *   in a pipeline it runs. Without it, the goodness of fit on the training data and the
     *   estimates of the surrogate adaption have no rows.
     */
    private static void checkLearning(final MachineLearningModule module, final List<String> errors) {
        final Block learning = module.getLearningUseCase();
        if(learning == null || !callsGofCalculator(learning) || recordsTrainingRows(learning, new java.util.HashSet<>())) {
            return;
        }

        errors.add("Module '" + module.getName() + "', use case 'learning': '" + GOF_CALCULATOR + "' assesses the training rows, but no step "
                   + "records them; add step { component '" + ASSESSMENT_DATA + "' { '" + DATA_SET + "' := \"" + GoodnessOfFit.TRAINING
                   + "\"; } } after pipeline 'validation'.");
    }

    private static boolean callsGofCalculator(final Block block) {
        final List<EObject> elements = new ArrayList<>();
        block.eAllContents().forEachRemaining(elements::add);

        return elements.stream()
                       .anyMatch(element -> element instanceof CallBuiltinFunction call
                                            && call.getDefinition() != null
                                            && GOF_CALCULATOR.equals(call.getDefinition().getName()));
    }

    /**
     * @return Whether the element or a pipeline it runs contains a step that records the
     *   training rows.
     */
    private static boolean recordsTrainingRows(final EObject element, final java.util.Set<PipelineDefinition> visited) {
        final List<EObject> elements = new ArrayList<>();
        element.eAllContents().forEachRemaining(elements::add);

        for(final EObject current : elements) {
            if(current instanceof ConcreteStep step
                    && step.getInstance() != null
                    && ASSESSMENT_DATA.equals(step.getInstance().getDefinition().getName())
                    && GoodnessOfFit.TRAINING.equals(stringOf(step.getInstance().findAttribute(DATA_SET)))) {
                return true;
            }

            if(current instanceof PipelineStep step
                    && step.getDefinition() != null
                    && visited.add(step.getDefinition())
                    && recordsTrainingRows(step.getDefinition(), visited)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return The value of the attribute if it is a string literal, otherwise {@code null}.
     */
    private static String stringOf(final Attribute attribute) {
        if(attribute == null) {
            return null;
        }

        return ElementSwitch.elementOf(attribute.getValue())
                            .filter(StringLiteral.class::isInstance)
                            .map(literal -> ((StringLiteral) literal).getLiteral())
                            .orElse(null);
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
        block.getStatements().add(call(findFunction(surrogatePipeline, GOF_CALCULATOR)));
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
                if(isPreparationStep(instance.getDefinition())) {
                    // a preparation step reads and writes the features it names (those of the
                    // task; the others are reported by the check)
                    final List<DataDescription> features = featuresOf(instance, FEATURES).stream()
                                                                                         .filter(DataDescription.class::isInstance)
                                                                                         .map(DataDescription.class::cast)
                                                                                         .filter(f -> task.getInputs().contains(f) || task.getOutputs().contains(f))
                                                                                         .toList();
                    deriveFeatures(step.getReads(), features);
                    deriveFeatures(step.getWrites(), features);
                }
            }
        }
    }

    /**
     * @return Whether the type is a preparation step, i.e. extends {@value #PREPARATION_STEP} of
     *   {@value #SURROGATE_PIPELINE}.
     */
    private static boolean isPreparationStep(final ClassDefinition type) {
        for(ClassDefinition current = type; current != null; current = current.getSuperType()) {
            if(PREPARATION_STEP.equals(current.getName())
                    && current.eContainer() instanceof DefinitionModule module
                    && SURROGATE_PIPELINE.equals(module.getName())) {
                return true;
            }
        }

        return false;
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

        if(isPreparationStep(step.getInstance().getDefinition())) {
            checkPreparationStep(step.getInstance(), taskFeatures, where, errors);
        }

        if(TEST_DATA_LOADER.equals(step.getInstance().getDefinition().getName())
                && arrayOf(step.getInstance().findAttribute("testing-files")) instanceof Array files
                && files.getValues().isEmpty()) {
            errors.add(where + ": no test data; add 'testing with [\"<file>\"]' to 'specify learning-task' or 'testing-files' to the step.");
        }
    }

    /**
     * Checks a preparation step: its features belong to the task, its fitted parameters (its
     *   optional attributes) are either all left out or all stated with one value per feature,
     *   and it does not state {@code inverse}, which only the stored prediction pipeline sets.
     */
    private static void checkPreparationStep(final Instance instance, final List<DataDescription> taskFeatures, final String where, final List<String> errors) {
        final List<TypeDefinition> features = featuresOf(instance, FEATURES);
        checkFeatures(features, taskFeatures,
                      where + ": '" + FEATURES + "' contains '%s', which is not an input or output feature of the learning task.", errors);

        if(instance.findAttribute(INVERSE) != null) {
            errors.add(where + ": '" + INVERSE + "' is derived for the stored prediction pipeline and must not be stated.");
        }

        final List<String> stated = new ArrayList<>();
        final List<String> missing = new ArrayList<>();
        for(final AttributeDefinition parameter : instance.getDefinition().getAllAttributes()) {
            if(!parameter.isOptional()) {
                continue;
            }

            final Attribute attribute = instance.findAttribute(parameter.getName());
            if(attribute == null) {
                missing.add(parameter.getName());
                continue;
            }

            stated.add(parameter.getName());
            final Array values = arrayOf(attribute);
            if(values != null && values.getValues().size() != features.size()) {
                errors.add(where + ": '" + parameter.getName() + "' has " + values.getValues().size() + " values but the step has "
                           + features.size() + " features.");
            }
        }

        if(!stated.isEmpty() && !missing.isEmpty()) {
            errors.add(where + ": states " + quoted(stated) + " but not " + quoted(missing) + "; state all fitted parameters or none.");
        }
    }

    private static String quoted(final List<String> names) {
        return names.stream()
                    .map(n -> "'" + n + "'")
                    .collect(java.util.stream.Collectors.joining(", "));
    }

    private static void checkFeatures(final List<TypeDefinition> stated, final List<DataDescription> allowed, final String message, final List<String> errors) {
        stated.stream()
              .filter(feature -> !allowed.contains(feature))
              .map(feature -> String.format(message, feature.getName()))
              .forEach(errors::add);
    }

    /**
     * @return The data features of a feature attribute (an array of data references or a
     *   single one), or an empty list if the instance has no such attribute or its value is no
     *   data reference.
     */
    private static List<TypeDefinition> featuresOf(final Instance instance, final String name) {
        final Attribute attribute = instance.findAttribute(name);
        final List<? extends Expression> values;
        if(arrayOf(attribute) instanceof Array array) {
            values = array.getValues();
        } else if(attribute != null) {
            values = List.of(attribute.getValue());
        } else {
            return List.of();
        }

        return values.stream()
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
        } else if(current == module.getResamplingUseCase()) {
            return "use case 'resampling'";
        } else if(current instanceof PipelineDefinition pipeline) {
            return "pipeline '" + pipeline.getName() + "'";
        }

        return current.eContainingFeature() != null ? "'" + current.eContainingFeature().getName() + "'" : "module";
    }

    /**
     * @return All steps of the module whose type belongs to {@value #SURROGATE_PIPELINE} or is a
     *   preparation step.
     */
    private static List<ConcreteStep> standardSteps(final MachineLearningModule module) {
        final List<ConcreteStep> steps = new ArrayList<>();
        module.eAllContents().forEachRemaining(element -> {
            if(element instanceof ConcreteStep step
                    && step.getInstance() != null
                    && (step.getInstance().getDefinition().eContainer() instanceof DefinitionModule definitions
                        && SURROGATE_PIPELINE.equals(definitions.getName())
                        || isPreparationStep(step.getInstance().getDefinition()))) {
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

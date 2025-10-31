package de.evoal.surrogate.main.internal;

import de.evoal.surrogate.api.function.ModelFunction;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.regex.Pattern;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.core.interpreter.api.ProgramExecutionSwitch;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.surrogate.api.training.TrainingDataManager;


@Dependent
@Slf4j
public class MLLProgramExecutionSwitch extends ProgramExecutionSwitch {
    /**
     * Pattern for finding variable access.
     */
    private final static Pattern varPattern = Pattern.compile("\\$\\{[^}]*}");

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private EAnnotationHelper helper;

    private ModelFunction function;

    @Inject
    private TrainingDataManager manager;


    public MLLProgramExecutionSwitch setState(final InterpreterState context) {
        super.context = context;

        return this;
    }
/*
    @Override
    public Object caseStatement(final Statement statement) {
        if(statement instanceof PredictStatement predictStatement) {
            return casePredictStatement(predictStatement);
        }

        return super.caseStatement(statement);
    }

    public Object casePredictStatement(final PredictStatement predict) {
        final File input = calculateFilename(predict.getTrainingData());
        final File output = calculateFilename(predict.getModelFilename());
        final SurrogateDefinition definition = predict.getSurrogate();

        apply(definition, input, output, predict.getMeasurements().getStatements());

        return Optional.empty();
    }

    private void apply(final SurrogateDefinition definition, final File input, final File output, final List<Statement> statements) {
        log.info("Applying {} to {}.", definition.getName(), input);

        final long startTime = System.currentTimeMillis();

        // create configuration
        final Map<DataDescription, EStructuralFeature> featureMap = helper.featuresOf(context.getSpace());
        this.config = SurrogateConfiguration.from(definition, featureMap, evaluator);

        // collect specifications
        final Space inputSpec = helper.subSpaceOf(context.getSpace(), definition.getInputs());
        final Space outputSpec = helper.subSpaceOf(context.getSpace(), definition.getOutputs());
        final Space trainingSpec = inputSpec.merge(outputSpec);

        manager.setTrainingStream(EObjectPairStreamFactory.createFromList(inputSpec, outputSpec, new FileBasedEObjectStreamSupplier(input, trainingSpec)));

        log.info("Training surrogate function.");
        this.function = new SurrogateFactory(config, manager.getTrainingStream()).create();

        final long endTime = System.currentTimeMillis();
        log.info("Calculation of surrogate took {} ms.", endTime - startTime);

        statements.stream()
                  .filter(CallBuiltinFunction.class::isInstance)
                  .map(CallBuiltinFunction.class::cast)
                  .forEach(this::handleGoodnessOfFitCall);

        saveTrainedSurrogateFunctionFunction(output);
    }

    private File calculateFilename(String filename) {
        final Matcher matcher = varPattern.matcher(filename);

        final Set<String> vars = new HashSet<>();
        while(matcher.find()) {
            vars.add(filename.substring(matcher.start() + 2, matcher.end() - 1));
        }

        for(final String var : vars) {
            String replacement = null;

            Object value = context.getByName(var);
            if(value instanceof Integer) {
                replacement = value.toString();
            } else if(value instanceof String) {
                replacement = (String)value;
            }

            if(replacement == null) {
                log.warn("Unable to replace ${{}}", var);
                continue;
            }

            filename = filename.replace("${" + var + "}", replacement);
        }

        return new File(filename);
    }

    private void handleGoodnessOfFitCall(final CallBuiltinFunction call) {
        final FunctionDefinition function = call.getDefinition();
        log.info("Handling call of {} ...", function.getName());

        log.info("Creating GOF instance.");
        final SurrogateInformationCalculator calculator = createFunction(function);

        log.info("Calculating parameter values.");
        final List<Object> parameters = call.getParameters()
                .stream()
                .map(ConstantSwitch::findConstant)
                .collect(Collectors.toList());

        log.info("Configuring GOF instance.");
        calculator.configure(this.function, config, manager.getTrainingStream());

        log.info("Calling GOF instance.");
        final long startTime = System.currentTimeMillis();
        calculator.call(context, parameters.toArray());
        final long endTime = System.currentTimeMillis();

        log.info("Calculation of {} took {} ms.", function.getName(), (endTime - startTime));
    }

    private void saveTrainedSurrogateFunctionFunction(final File outputFilename) {
        log.info("Storing pre-calculated predictive functions to '{}' ...", outputFilename);
        outputFilename.getAbsoluteFile().getParentFile().mkdirs();
        surrogateWriter.accept(config, outputFilename);
        log.info("Storing file was successful.");
    }

    /**
     * Returns an instance of the given {@code definition}.
     *
     * @param definition Definition of the function
     * @return A valid instance
     * /
    private SurrogateInformationCalculator createFunction(final FunctionDefinition definition) {
        Requirements.requireNotNull(definition);

        final String name = new FQNProvider().get(definition);
        log.info("Creating surrogate function of name {}.", name);

        try {
            return BeanFactory.create(name, SurrogateInformationCalculator.class);
        } catch(final IllegalStateException | IllegalArgumentException e) {
            log.error("Failed to create contextual reference of type '{}' with name '{}'.", definition, name);
            throw e;
        }
    }
    */
}

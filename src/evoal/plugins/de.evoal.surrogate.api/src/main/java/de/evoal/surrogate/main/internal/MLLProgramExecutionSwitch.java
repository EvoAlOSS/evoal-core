package de.evoal.surrogate.main.internal;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.utils.ConstantSwitch;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.core.interpreter.api.ProgramExecutionSwitch;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.dl.util.FQNProvider;
import de.evoal.languages.model.execution.CallBuiltinFunction;
import de.evoal.languages.model.execution.Statement;
import de.evoal.languages.model.mll.PredictStatement;
import de.evoal.languages.model.mll.SurrogateDefinition;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.api.training.TrainingDataManager;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Dependent
@Slf4j
public class MLLProgramExecutionSwitch extends ProgramExecutionSwitch {
    /**
     * Variable pattern
     */
    private final static Pattern varPattern = Pattern.compile("\\$\\{[^}]*}");

    private SurrogateConfiguration config;

    private SurrogateDefinition definition;

    @Inject
    private AttributeEvaluator evaluator;

    private SurrogateFunction function;

    @Inject
    private TrainingDataManager manager;

    @Inject
    @Named("surrogate-writer")
    private BiConsumer<@NonNull SurrogateConfiguration, @NonNull File> surrogateWriter;


    public MLLProgramExecutionSwitch setState(final InterpreterState context) {
        super.context = context;

        return this;
    }

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

        // collect specifications
        final PropertiesSpecification inputSpec = collectSpecification(definition.getInputs());
        final PropertiesSpecification outputSpec = collectSpecification(definition.getOutputs());
        final PropertiesSpecification trainingSpec = PropertiesSpecification.builder()
                .add(inputSpec)
                .add(outputSpec)
                .build();

        manager.setTrainingStream(new FileBasedPropertiesStreamSupplier(input, trainingSpec));

        this.definition = definition;
        this.config = SurrogateConfiguration.from(definition, evaluator);

        log.info("Training surrogate function.");
        this.function = new SurrogateFactory(config, manager.getTrainingStream()).create();

        final long endTime = System.currentTimeMillis();
        log.info("Calculation of surrogate took " + (endTime - startTime) + " ms.");

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

    private PropertiesSpecification collectSpecification(final List<DataDescription> descriptions) {
        return PropertiesSpecification.builder()
                .addDescriptions(descriptions.stream())
                .build();
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
        calculator.configure(this.function, config, parameters, manager.getTrainingStream());

        log.info("Calling GOF instance.");
        final long startTime = System.currentTimeMillis();
        calculator.execute();
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
     */
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
}

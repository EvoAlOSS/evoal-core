package de.evoal.surrogate.main.internal;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.ConstantSwitch;
import de.evoal.languages.model.base.DefinedFunctionName;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Call;
import de.evoal.languages.model.base.StringLiteral;
import de.evoal.languages.model.mll.*;
import de.evoal.languages.model.mll.util.MllSwitch;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.api.training.TrainingDataManager;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Dependent
@Slf4j
public class StatementExecutor extends MllSwitch<Object> {

    @Inject
    private ExpressionEvaluator evaluator;

    private SurrogateConfiguration config;

    private SurrogateDefinition definition;

    private SurrogateFunction function;

    @Setter
    private SymbolTable symbolTable = new SymbolTable(null);

    @Inject
    private TrainingDataManager manager;


    /**
     * Variable pattern
     */
    private final static Pattern varPattern = Pattern.compile("\\$\\{[^}]*}");

    @Inject
    @Named("surrogate-writer")
    private BiConsumer<@NonNull SurrogateConfiguration, @NonNull File> surrogateWriter;

    public void evaluate(final Statement statement) {
        doSwitch(statement);
    }

    @Override
    public Object caseCallStatement(final CallStatement call) {
        log.warn("Have to call stuff: {}", call.getCall().getFunction());

        return null;
    }

    @Override
    public Object caseBlockStatement(final BlockStatement block) {
        block.getStatements()
             .forEach(this::evaluate);

        return null;
    }

    @Override
    public Object casePredictStatement(final PredictStatement predict) {
        final File input = calculateFilename(predict.getTrainingData());
        final File output = calculateFilename(predict.getModelFilename());
        final SurrogateDefinition definition = predict.getSurrogate();

        apply(definition, input, output, predict.getStatements());

        return null;
    }

    private void apply(final SurrogateDefinition definition, final File input, final File output, final List<CallStatement> statements) {
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

        statements.forEach(this::handleGoodnessOfFitCall);

        saveTrainedSurrogateFunctionFunction(output);
    }

    private PropertiesSpecification collectSpecification(final List<DataDescription> descriptions) {
        return PropertiesSpecification.builder()
                .addDescriptions(descriptions.stream())
                .build();
    }

    private void handleGoodnessOfFitCall(final CallStatement statement) {
        final Call call = statement.getCall();
        final DefinedFunctionName function = (DefinedFunctionName)call.getFunction();
        log.info("Handling call of {} ...", function.getDefinition().getName());

        log.info("Creating GOF instance.");
        final SurrogateInformationCalculator calculator = BeanFactory.create(function.getDefinition().getName(), SurrogateInformationCalculator.class);

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

        log.info("Calculation of {} took {} ms.", function.getDefinition().getName(), (endTime - startTime));
    }

    private File calculateFilename(String filename) {
        final Matcher matcher = varPattern.matcher(filename);

        final Set<String> vars = new HashSet<>();
        while(matcher.find()) {
            vars.add(filename.substring(matcher.start() + 2, matcher.end() - 1));
        }

        for(final String var : vars) {
            String replacement = null;

            Object value = symbolTable.get(var);
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

    @Override
    public Object caseForStatement(final ForStatement loop) {
        final Stream<?> elements = (Stream<?>) doSwitch(loop.getRange());

        elements.forEach(element -> {
            final SymbolTable scopedTable = new SymbolTable(symbolTable);
            scopedTable.put(loop.getName(), element);

            final StatementExecutor executor = BeanFactory.create(StatementExecutor.class);
            executor.setSymbolTable(scopedTable);
            loop.getStatements()
                .forEach(executor::evaluate);
        });

        return null;
    }

    @Override
    public Object caseCounterRange(final CounterRange range) {
        final boolean reverse = range.getStart() > range.getEnd();
        final int min = Math.min(range.getStart(), range.getEnd());
        final int max = Math.max(range.getStart(), range.getEnd());
        final int count = max - min;

        Stream<Integer> values = IntStream.rangeClosed(0, count)
                .boxed();

        if(reverse) {
            values = values.map(i -> max - i);
        } else {
            values = values.map(i -> min + i);
        }

        return values;
    }

    @Override
    public Object caseStringLiteralRange(final StringLiteralRange range) {
        return range.getElements()
                    .stream()
                    .map(StringLiteral::getValue);
    }

    private void saveTrainedSurrogateFunctionFunction(final File outputFilename) {
        log.info("Storing pre-calculated predictive functions to '{}' ...", outputFilename);
        outputFilename.getAbsoluteFile().getParentFile().mkdirs();
        surrogateWriter.accept(config, outputFilename);
        log.info("Storing file was successful.");
    }
}

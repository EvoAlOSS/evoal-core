package de.evoal.surrogate.api.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;
import de.evoal.languages.model.mll.SurrogateLayerDefinition;
import de.evoal.surrogate.api.function.FunctionCombiner;
import lombok.Data;
import org.eclipse.emf.common.util.EList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Configuration of a {@link FunctionCombiner}.
 */
@Data
public class FunctionCombinerConfiguration {
    /**
     * List of functions within this mapping.
     */
    private List<PartialFunctionConfiguration> functions = new ArrayList<>();

    /**
     * Configuration of required properties
     */
    private final List<String> inputDimensions = new ArrayList<>();

    @JsonIgnore
    private final List<DataDescription> inputData = new ArrayList<>();

    /**
     * Name of the mapping.
     */
    private String name;

    /**
     * Configuration of generated properties
     */
    private final List<String> outputDimensions = new ArrayList<>();

    @JsonIgnore
    private final List<DataDescription> outputData = new ArrayList<>();

    public void setInputData(final List<DataDescription> data) {
        inputData.clear();
        inputData.addAll(data);

        inputDimensions.clear();
        data.stream()
                .map(DataDescription::getName)
                .forEach(inputDimensions::add);
    }

    public void setOutputData(final List<DataDescription> data) {
        outputData.clear();
        outputData.addAll(data);

        outputDimensions.clear();
        data.stream()
                .map(DataDescription::getName)
                .forEach(outputDimensions::add);
    }

    public static FunctionCombinerConfiguration from(final SurrogateLayerDefinition definition, ExpressionEvaluator evaluator) {
        final FunctionCombinerConfiguration configuration = new FunctionCombinerConfiguration();
        configuration.setName(definition.getName());

        final List<DataDescription> inputs =
                definition.getFunctions()
                          .stream()
                          .map(PartialSurrogateFunctionDefinition::getInputs)
                          .flatMap(EList::stream)
                          .distinct()
                          .collect(Collectors.toList());

        final List<DataDescription> outputs =
                definition.getFunctions()
                        .stream()
                        .map(PartialSurrogateFunctionDefinition::getOutputs)
                        .flatMap(EList::stream)
                        .distinct()
                        .collect(Collectors.toList());

        configuration.setInputData(inputs);
        configuration.setOutputData(outputs);

        definition.getFunctions()
                .stream()
                .map(d -> PartialFunctionConfiguration.from(d, evaluator))
                .forEach(configuration.functions::add);

        return configuration;
    }

    public static FunctionCombinerConfiguration from(final FunctionCombinerConfiguration config) {
        final FunctionCombinerConfiguration configuration = new FunctionCombinerConfiguration();
        configuration.setName(config.getName());

        configuration.setInputData(config.getInputData());
        configuration.setOutputData(config.getOutputData());

        config.getFunctions()
                .stream()
                .map(PartialFunctionConfiguration::from)
                .forEach(configuration.functions::add);

        return configuration;
    }
}


package de.evoal.surrogate.api.configuration;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;
import de.evoal.languages.model.mll.SurrogateLayerDefinition;
import de.evoal.surrogate.api.function.FunctionCombiner;
import lombok.Data;

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

    /**
     * Name of the mapping.
     */
    private String name;

    /**
     * Configuration of generated properties
     */
    private final List<String> outputDimensions = new ArrayList<>();

    public static FunctionCombinerConfiguration from(final SurrogateLayerDefinition definition) {
        final FunctionCombinerConfiguration configuration = new FunctionCombinerConfiguration();
        configuration.setName(definition.getName());

        final List<String> inputs =
                definition.getFunctions()
                          .stream()
                          .map(PartialSurrogateFunctionDefinition::getInputs)
                          .flatMap(l -> l.stream().map(DataDescription::getName))
                          .distinct()
                          .collect(Collectors.toList());

        final List<String> outputs =
                definition.getFunctions()
                        .stream()
                        .map(PartialSurrogateFunctionDefinition::getOutputs)
                        .flatMap(l -> l.stream().map(DataDescription::getName))
                        .distinct()
                        .collect(Collectors.toList());

        configuration.getInputDimensions().addAll(inputs);
        configuration.getOutputDimensions().addAll(outputs);

        definition.getFunctions()
                .stream()
                .map(PartialFunctionConfiguration::from)
                .forEach(configuration.functions::add);

        return configuration;
    }

    public static FunctionCombinerConfiguration from(final FunctionCombinerConfiguration config) {
        final FunctionCombinerConfiguration configuration = new FunctionCombinerConfiguration();
        configuration.setName(config.getName());

        configuration.getInputDimensions()
                     .addAll(config.getInputDimensions());
        configuration.getOutputDimensions()
                     .addAll(config.getOutputDimensions());

        config.getFunctions()
                .stream()
                .map(PartialFunctionConfiguration::from)
                .forEach(configuration.functions::add);

        return configuration;
    }
}


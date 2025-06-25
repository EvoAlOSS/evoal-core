package de.evoal.optimisation.main.fitness;

import de.evoal.core.api.utils.AttributeHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.ArithmeticOperations;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.OptimisationFunction;

@Dependent
@Named("de.evoal.optimisation.core.search-space-distance")
@Slf4j
public class SearchSpaceDistanceFitness implements OptimisationFunction {

    @Inject
    private Blackboard board;

    @Inject
    protected AttributeHelper helper;

    @Inject @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Inject @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpaceSpecification;

    private BiConsumer<Properties, Properties> fitness;

    @Override
    public double[] evaluate(final Properties properties) {
        final Properties result = new Properties(optimisationSpaceSpecification);

        fitness.accept(properties, result);

        return result.getValuesAsDouble();
    }

    private double distance(final Object o, final double v) {
        return Math.abs(((Number)o).doubleValue() - v);
    }

    @Override
    public OptimisationFunction init(final Instance config) {
        final List<Instance> target = helper.lookup(config, "target");
        final Map<PropertySpecification, Number> values = toValueMap(target);

        final List<Instance> mapping = helper.lookup(config, "mapping");
        final Map<PropertySpecification, PropertySpecification> mappings = toMappingMap(mapping);

        Requirements.requireEqual(new HashSet<>(searchSpaceSpecification.getProperties()), values.keySet());
        Requirements.requireEqual(new HashSet<>(searchSpaceSpecification.getProperties()), mappings.keySet());
        Requirements.requireEqual(new HashSet<>(optimisationSpaceSpecification.getProperties()), new HashSet<>(mappings.values()));

        fitness = (input, output) -> {
            for(final Map.Entry<PropertySpecification, PropertySpecification> entry : mappings.entrySet()) {
                final Number targetValue = values.get(entry.getKey());
                final Number actualValue = input.getAsNumber(entry.getKey());

                final Number resultValue = ArithmeticOperations.abs(ArithmeticOperations.minus(targetValue, actualValue));

                output.put(entry.getValue(), resultValue);
            }
        };


        return this;
    }

    private Map<PropertySpecification, Number> toValueMap(final List<Instance> array) {
        return array.stream()
                    .collect(
                        Collectors.toMap(
                            i -> PropertySpecification.of(helper.<DataDescription>lookup(i, "var")),
                            i -> helper.<Number>lookup(i, "val")
                        )
                    );
    }

    private Map<PropertySpecification, PropertySpecification> toMappingMap(final List<Instance> array) {
        return array.stream()
                .collect(
                        Collectors.toMap(
                                i -> PropertySpecification.of(helper.<DataDescription>lookup(i, "input")),
                                i -> PropertySpecification.of(helper.<DataDescription>lookup(i, "output"))
                        )
                );
    }
}

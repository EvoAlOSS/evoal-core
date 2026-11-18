package de.evoal.optimisation.main.statistics.memory;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;

import lombok.NonNull;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.JsonNodeFactory;
import tools.jackson.databind.node.ObjectNode;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.models.core.utils.FQNProvider;

/**
 * Converts a configuration (an instance of a DL type, e.g., a target distance or a fitness
 *   step) into JSON: {@code {"type": <fully qualified DL type>, "attributes": {...}}}. The
 *   attributes are written in the order of the type's attributes, with their default
 *   values applied.
 * <p>
 * Values: numbers (non-finite ones as strings), booleans, strings, enum literals by name,
 *   arrays, nested instances as configurations, data by its name. Other values (e.g.,
 *   functions) are written as their text; writing the whole configuration of a run is
 *   issue #287.
 */
public class ConfigurationJson {
    /**
     * Creates the JSON nodes.
     */
    private static final JsonNodeFactory NODES = JsonNodeFactory.instance;

    /**
     * Reads the value of an attribute of a configuration.
     */
    private final BiFunction<EObject, EStructuralFeature, Object> reader;

    /**
     * @param reader Reads the value of an attribute of a configuration, e.g., with its
     *   default value applied.
     */
    public ConfigurationJson(final @NonNull BiFunction<EObject, EStructuralFeature, Object> reader) {
        this.reader = reader;
    }

    /**
     * @param evaluator Reads the attribute values with their defaults applied.
     * @return A converter that reads the attributes like the components do.
     */
    public static ConfigurationJson of(final @NonNull AttributeEvaluator evaluator) {
        return new ConfigurationJson((configuration, attribute) -> evaluator.attributeToJava(configuration,
                                                                                             attribute.getName(),
                                                                                             attribute.getEType()));
    }

    private ArrayNode toArray(final Collection<?> elements) {
        final ArrayNode array = NODES.arrayNode();
        elements.stream()
                .map(this::toValue)
                .forEach(array::add);

        return array;
    }

    /**
     * @param configuration The configuration.
     * @return The type and the attribute values of the configuration.
     */
    public ObjectNode toConfiguration(final @NonNull EObject configuration) {
        final ObjectNode configurationNode = NODES.objectNode();
        configurationNode.put("type", new FQNProvider().get(configuration));

        final ObjectNode attributes = configurationNode.putObject("attributes");
        configuration.eClass()
                     .getEAllStructuralFeatures()
                     .forEach(attribute -> attributes.set(attribute.getName(),
                                                          toValue(reader.apply(configuration, attribute))));

        return configurationNode;
    }

    private JsonNode toValue(final Object value) {
        return switch(value) {
            case null -> NODES.nullNode();
            case Number number -> MemoryModelJson.toNumber(number);
            case Boolean bool -> NODES.booleanNode(bool);
            case String string -> NODES.stringNode(string);
            case Enumerator literal -> NODES.stringNode(literal.getName());
            case Definition definition -> NODES.stringNode(definition.getName());
            case EStructuralFeature feature -> NODES.stringNode(feature.getName());
            case EObject configuration -> toConfiguration(configuration);
            case Collection<?> collection -> toArray(collection);
            case Object[] array -> toArray(Arrays.asList(array));
            case double[] array -> toArray(Arrays.stream(array).boxed().toList());
            case int[] array -> toArray(Arrays.stream(array).boxed().toList());
            case long[] array -> toArray(Arrays.stream(array).boxed().toList());
            default -> NODES.stringNode(value.toString());
        };
    }
}

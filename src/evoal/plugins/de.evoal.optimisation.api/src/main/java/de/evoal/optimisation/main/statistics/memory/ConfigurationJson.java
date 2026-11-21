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
import de.evoal.core.api.languages.ExpressionText;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.models.core.utils.FQNProvider;

/**
 * Converts a configuration (an instance of a DL type, e.g., an algorithm, a target distance
 *   or a fitness step) into JSON: {@code {"type": <fully qualified DL type>, "attributes":
 *   {...}}}. All attributes of the type are written in their order, with their default
 *   values applied.
 * <p>
 * Values: numbers (non-finite ones as strings), booleans, strings, enum literals by name,
 *   arrays, nested instances as configurations, data by its name, expressions as their
 *   source text, unset optional attributes as {@code null} (arrays as empty arrays). Other
 *   values are written as their {@code toString()}.
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
     * @return A converter that reads the attributes like the components do. An unset optional
     *   attribute is read as {@code null}.
     */
    public static ConfigurationJson of(final @NonNull AttributeEvaluator evaluator) {
        return new ConfigurationJson((configuration, attribute) -> readAttribute(evaluator, configuration, attribute));
    }

    /**
     * @param evaluator Reads the attribute values with their defaults applied.
     * @param configuration A configuration.
     * @param attribute One of its attributes.
     * @return The value of the attribute as the components read it, with its default value
     *   applied; {@code null} for an unset optional attribute.
     */
    public static Object readAttribute(final @NonNull AttributeEvaluator evaluator,
                                       final @NonNull EObject configuration,
                                       final @NonNull EStructuralFeature attribute) {
        if(isUnsetOptional(configuration, attribute)) {
            return null;
        }

        return evaluator.attributeToJava(configuration, attribute.getName(), attribute.getEType());
    }

    /**
     * @return {@code true} if the attribute is single-valued, optional and has no value, as the
     *   components see it ({@code eIsSet}, e.g., {@code 'gene-probability'} of the mutations).
     *   An attribute with a default value literal is never unset; arrays are written as they
     *   are, an unset one as an empty array.
     */
    private static boolean isUnsetOptional(final EObject configuration, final EStructuralFeature attribute) {
        return attribute.getLowerBound() == 0
               && !attribute.isMany()
               && attribute.getDefaultValueLiteral() == null
               && !configuration.eIsSet(attribute);
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
            case Expression expression -> NODES.stringNode(ExpressionText.of(expression));
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

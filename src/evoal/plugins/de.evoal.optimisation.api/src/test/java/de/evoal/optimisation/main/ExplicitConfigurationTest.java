package de.evoal.optimisation.main;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;

/**
 * The core types state every mapping (#311): a required attribute has neither a default nor
 *   is it optional, so a configuration that leaves it out is rejected at start with the name
 *   of the attribute; a default is stated in the DL.
 */
class ExplicitConfigurationTest {
    private static final DefinitionModule MODULE = LanguageHelper.loadFromClasspath("de/evoal/optimisation/core.dl");

    private static ClassDefinition type(final String name) {
        return MODULE.getTypes()
                     .stream()
                     .filter(type -> name.equals(type.getName()))
                     .findFirst()
                     .orElseThrow(() -> new AssertionError("The DL has no type '" + name + "'."));
    }

    private static AttributeDefinition attribute(final String type, final String attribute) {
        final AttributeDefinition definition = type(type).findAttribute(attribute);
        Assertions.assertNotNull(definition, "'" + type + "' has no attribute '" + attribute + "'.");

        return definition;
    }

    private static void required(final String type, final String attribute) {
        final AttributeDefinition definition = attribute(type, attribute);

        Assertions.assertFalse(definition.isOptional(), "'" + attribute + "' of '" + type + "' is optional.");
        Assertions.assertNull(definition.getInitialisation(), "'" + attribute + "' of '" + type + "' has a default.");
    }

    @Test
    void theWeightsOfTheWeightedSumAreRequired() {
        required("weighted-sum", "weights");
    }

    @Test
    void theReplacementSourceIsARandomPopulationByDefault() {
        final AttributeDefinition source = attribute("candidate-check", "replacement-source");

        Assertions.assertFalse(source.isOptional());
        Assertions.assertNotNull(source.getInitialisation(), "'replacement-source' has no default.");

        // the default is an instance at the end of the expression chain of the initialisation
        final Instance instance = Stream.concat(Stream.of(source.getInitialisation()),
                                                StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                                                        source.getInitialisation().eAllContents(), Spliterator.ORDERED), false))
                                        .filter(Instance.class::isInstance)
                                        .map(Instance.class::cast)
                                        .findFirst()
                                        .orElseThrow(() -> new AssertionError("The default of 'replacement-source' is no instance."));
        Assertions.assertEquals("random-population", instance.getDefinition().getName());
    }

    @Test
    void givenCandidatesComeEitherFromTheListOrFromAFile() {
        required("specify-candidates", "candidate-list");
        Assertions.assertNull(type("specify-candidates").findAttribute("candidate-file"));

        required("candidates-from-file", "candidate-file");
        Assertions.assertNull(type("candidates-from-file").findAttribute("candidate-list"));
    }
}

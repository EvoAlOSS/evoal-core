package de.evoal.optimisation.ea.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;

/**
 * The configuration of the evolutionary algorithm states every mapping (#311): the attributes
 *   below have neither a default nor are they optional, so a configuration that leaves one out
 *   is rejected at start with the name of the attribute.
 */
class ExplicitConfigurationTest {
    private static final DefinitionModule MODULE = LanguageHelper.loadFromClasspath("de/evoal/optimisation/ea/optimisation.dl");

    private static ClassDefinition type(final String name) {
        return MODULE.getTypes()
                     .stream()
                     .filter(type -> name.equals(type.getName()))
                     .findFirst()
                     .orElseThrow(() -> new AssertionError("The DL has no type '" + name + "'."));
    }

    private static void required(final String type, final String attribute) {
        final AttributeDefinition definition = type(type).findAttribute(attribute);

        Assertions.assertNotNull(definition, "'" + type + "' has no attribute '" + attribute + "'.");
        Assertions.assertFalse(definition.isOptional(), "'" + attribute + "' of '" + type + "' is optional.");
        Assertions.assertNull(definition.getInitialisation(), "'" + attribute + "' of '" + type + "' has a default.");
    }

    @Test
    void theGenotypeIsRequired() {
        required("evolutionary-algorithm", "genotype");
    }

    @Test
    void theAlgorithmHasNoOperatorsOfItsOwn() {
        Assertions.assertNull(type("evolutionary-algorithm").findAttribute("recombination"));
        Assertions.assertNull(type("evolutionary-algorithm").findAttribute("mutation"));
    }

    @Test
    void everyChromosomeListsItsOperators() {
        required("chromosome", "recombination");
        required("chromosome", "mutation");
    }

    @Test
    void theWeightsOfTheSingleChoiceMutationAreRequired() {
        required("single-choice-mutation", "weights");
    }

    @Test
    void theGeneProbabilityKeepsItsLiteratureDefault() {
        Assertions.assertTrue(type("mutation").findAttribute("gene-probability").isOptional());
    }
}

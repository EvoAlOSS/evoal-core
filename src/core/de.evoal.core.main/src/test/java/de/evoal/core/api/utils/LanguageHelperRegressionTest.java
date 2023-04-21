package de.evoal.core.api.utils;

import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.dl.*;
import de.evoal.languages.model.base.DoubleLiteral;
import de.evoal.languages.model.generator.Configuration;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.base.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class LanguageHelperRegressionTest {
    private void assertAttributeTypeOfA(final AttributeDefinition attribute) {
        Assertions.assertNotNull(attribute);
        Assertions.assertEquals("a", attribute.getName());
        Assertions.assertTrue(attribute.getType() instanceof ArrayType);
        final ArrayType typeA = (ArrayType) attribute.getType();
        Assertions.assertEquals(1, typeA.getElements().size());
        Assertions.assertTrue(typeA.getElements().get(0) instanceof FloatType);
    }

    private void assertAttributeTypeOfC(final AttributeDefinition attribute) {
        Assertions.assertNotNull(attribute);
        Assertions.assertTrue(attribute.getType() instanceof ArrayType);
        final ArrayType typeC = (ArrayType) attribute.getType();
        Assertions.assertEquals(1, typeC.getElements().size());
        Assertions.assertTrue(typeC.getElements().get(0) instanceof ArrayType);
        final ArrayType typetypeC = (ArrayType) typeC.getElements().get(0);
        Assertions.assertEquals(1, typetypeC.getElements().size());
        Assertions.assertTrue(typetypeC.getElements().get(0) instanceof FloatType);
    }

    private void assertAttributeTypeOfM(final AttributeDefinition attribute) {
        Assertions.assertNotNull(attribute);
        Assertions.assertTrue(attribute.getType() instanceof FloatType);
    }

    @Test
    public void testDefinitionLanguageParser() {
        final DefinitionModel model = LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/regressions/generator.dl");

        Assertions.assertNotNull(model);
        Assertions.assertNotNull(model.getTypes());
        Assertions.assertEquals(1, model.getTypes().size());

        final TypeDefinition type = model.getTypes().get(0);
        Assertions.assertEquals("shekel", type.getName());
        Assertions.assertNull(type.getSuperType());
        Assertions.assertEquals(3, type.getAttributes().size());

        final Optional<AttributeDefinition> attributeA = type.getAttributes().stream().map(AttributeDefinition.class::cast).filter(a -> "a".equals(a.getName())).findFirst();
        final Optional<AttributeDefinition> attributeC = type.getAttributes().stream().map(AttributeDefinition.class::cast).filter(a -> "c".equals(a.getName())).findFirst();
        final Optional<AttributeDefinition> attributeM = type.getAttributes().stream().map(AttributeDefinition.class::cast).filter(a -> "m".equals(a.getName())).findFirst();

        assertAttributeTypeOfA(attributeA.get());
        assertAttributeTypeOfC(attributeC.get());
        assertAttributeTypeOfM(attributeM.get());
    }

    @Test
    public void testLoading() {
        final Configuration configuration = LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/regressions/shekel.generator");

        // fetch step configuration for testee
        final Step step = configuration.getPipelines().get(0).getSteps().get(0);

        Assertions.assertNotNull(step);
        Assertions.assertNotNull(step.getInstance());
        Assertions.assertEquals(3, step.getInstance().getAttributes().size());

        final Attribute attributeA = step.getInstance().findAttribute("a");
        final Attribute attributeC = step.getInstance().findAttribute("c");
        final Attribute attributeM = step.getInstance().findAttribute("m");

        assertAttributeTypeOfA(attributeA.getDefinition());
        assertAttributeTypeOfC(attributeC.getDefinition());
        assertAttributeTypeOfM(attributeM.getDefinition());

        {
            Assertions.assertTrue(attributeA.getValue() instanceof Array);
            final Array array = (Array)attributeA.getValue();
            Assertions.assertEquals(10, array.getValues().size());
            Assertions.assertTrue(array.getValues().get(0) instanceof Literal);
            final Literal literal = (Literal) array.getValues().get(0);
            Assertions.assertTrue(literal instanceof DoubleLiteral);
            Assertions.assertEquals(1.0, literal.getValue());
        }

        {
            Assertions.assertTrue(attributeC.getValue() instanceof Array);
            final Array array = (Array)attributeC.getValue();
            Assertions.assertEquals(4, array.getValues().size());
            Assertions.assertTrue(array.getValues().get(0) instanceof Array);
            final Array array2 = (Array) array.getValues().get(0);
            Assertions.assertEquals(10, array2.getValues().size());
        }
    }
}

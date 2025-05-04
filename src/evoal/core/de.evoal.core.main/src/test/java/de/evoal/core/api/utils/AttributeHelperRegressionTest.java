package de.evoal.core.api.utils;

import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.base.types.*;
import de.evoal.languages.model.base.definitions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class AttributeHelperRegressionTest {
    private void assertAttributeTypeOfA(final AttributeDefinition attribute) {
        Assertions.assertNotNull(attribute);
        Assertions.assertEquals("a", attribute.getName());
        Assertions.assertInstanceOf(ArrayType.class, attribute.getType());
        final ArrayType typeA = (ArrayType) attribute.getType();
        Assertions.assertInstanceOf(RealType.class, typeA.getElements());
    }

    private void assertAttributeTypeOfC(final AttributeDefinition attribute) {
        Assertions.assertNotNull(attribute);
        Assertions.assertInstanceOf(ArrayType.class, attribute.getType());
        final ArrayType typeC = (ArrayType) attribute.getType();
        Assertions.assertInstanceOf(ArrayType.class, typeC.getElements());
        final ArrayType typetypeC = (ArrayType) typeC.getElements();
        Assertions.assertInstanceOf(RealType.class, typetypeC.getElements());
    }

    private void assertAttributeTypeOfM(final AttributeDefinition attribute) {
        Assertions.assertNotNull(attribute);
        Assertions.assertInstanceOf(RealType.class, attribute.getType());
    }

    @Test
    public void testDefinitionLanguageParser() {
        final DefinitionModule model = LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/regressions/generator.dl");

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
        final GeneratorModule configuration = LanguageHelper.loadFromClasspath("de/evoal/core/api/utils/regressions/shekel.generator");

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

    }
}

package de.evoal.core.api.literature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.expressions.Instance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Set;

/**
 * The definitions that {@link ConfigurationLiterature} finds in instance literals that are not
 *   converted into configurations, e.g. the arguments of a builtin function (#334).
 */
public class ConfigurationLiteratureTest {
    private static ClassDefinition type(final String name) {
        final ClassDefinition type = DefinitionsFactory.eINSTANCE.createClassDefinition();
        type.setName(name);

        return type;
    }

    private static Instance instance(final ClassDefinition type) {
        final Instance instance = ExpressionsFactory.eINSTANCE.createInstance();
        instance.setDefinition(type);

        return instance;
    }

    @Test
    public void anInstanceLiteralAddsItsTypeAndThoseOfItsAttributeValues() {
        // given: 'block-cross-validation' { blocks := 'k-means-blocks' {}; }
        final ClassDefinition scheme = type("block-cross-validation");
        final ClassDefinition blocks = type("k-means-blocks");

        final Attribute attribute = ExpressionsFactory.eINSTANCE.createAttribute();
        attribute.setValue(instance(blocks));
        final Instance literal = instance(scheme);
        literal.getAttributes().add(attribute);

        final ConfigurationLiterature walker = new ConfigurationLiterature(Mockito.mock(AttributeEvaluator.class),
                                                                           Set.of(ExpressionsPackage.eINSTANCE), t -> false, List.of());

        // when
        final List<?> definitions = walker.definitions(literal);

        // then
        Assertions.assertEquals(List.of(scheme, blocks), definitions);
    }

    @Test
    public void aSkippedTypeIsLeftOutWithItsAttributeValues() {
        // given
        final ClassDefinition scheme = type("block-cross-validation");
        final Attribute attribute = ExpressionsFactory.eINSTANCE.createAttribute();
        attribute.setValue(instance(type("k-means-blocks")));
        final Instance literal = instance(scheme);
        literal.getAttributes().add(attribute);

        final ConfigurationLiterature walker = new ConfigurationLiterature(Mockito.mock(AttributeEvaluator.class),
                                                                           Set.of(ExpressionsPackage.eINSTANCE), scheme::equals, List.of());

        // when
        final List<?> definitions = walker.definitions(literal);

        // then
        Assertions.assertEquals(List.of(), definitions);
    }
}

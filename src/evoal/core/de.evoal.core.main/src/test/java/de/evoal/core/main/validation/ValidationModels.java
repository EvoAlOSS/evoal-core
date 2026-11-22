package de.evoal.core.main.validation;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.ReadExpression;

/**
 * Builds the parts of a parsed model that the validators walk through.
 */
final class ValidationModels {
    private ValidationModels() {
    }

    /**
     * @return A DL type with the given attributes.
     */
    static ClassDefinition type(final String name, final AttributeDefinition... attributes) {
        final ClassDefinition type = DefinitionsFactory.eINSTANCE.createClassDefinition();
        type.setName(name);
        type.getAttributes().addAll(java.util.List.of(attributes));
        return type;
    }

    /**
     * @return A DL attribute without default.
     */
    static AttributeDefinition attribute(final String name) {
        final AttributeDefinition attribute = DefinitionsFactory.eINSTANCE.createAttributeDefinition();
        attribute.setName(name);
        return attribute;
    }

    /**
     * @return An instance of the type, with values for the given attributes.
     */
    static <I extends Instance> I instance(final I instance, final ClassDefinition type, final Attribute... attributes) {
        instance.setDefinition(type);
        instance.getAttributes().addAll(java.util.List.of(attributes));
        return instance;
    }

    static Instance instance(final ClassDefinition type, final Attribute... attributes) {
        return instance(ExpressionsFactory.eINSTANCE.createInstance(), type, attributes);
    }

    /**
     * @return {@code definition := value}.
     */
    static Attribute assignment(final AttributeDefinition definition, final Expression value) {
        final Attribute attribute = ExpressionsFactory.eINSTANCE.createAttribute();
        attribute.setDefinition(definition);
        attribute.setValue(value);
        return attribute;
    }

    static Array array(final ReadExpression... values) {
        final Array array = ExpressionsFactory.eINSTANCE.createArray();
        array.getValues().addAll(java.util.List.of(values));
        return array;
    }
}

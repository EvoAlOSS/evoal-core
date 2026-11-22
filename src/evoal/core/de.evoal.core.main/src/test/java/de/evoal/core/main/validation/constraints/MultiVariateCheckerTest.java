package de.evoal.core.main.validation.constraints;

import static de.evoal.core.main.validation.constraints.Expressions.comparison;
import static de.evoal.core.main.validation.constraints.Expressions.real;
import static de.evoal.core.main.validation.constraints.Expressions.sum;
import static de.evoal.core.main.validation.constraints.Expressions.term;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.expressions.AddOrSubtractOperator;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.AttributeReference;
import de.evoal.languages.model.base.expressions.ComparisonOperator;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;

/**
 * Tests {@code @MultiVariateConstraint { 'expression' := self.'c1' + self.'c2' >= 4.0; }} of
 *   {@code type 'mover' { 'c1' : real := 2.05; 'c2' : real := 2.05; }} on parsed instances.
 */
public class MultiVariateCheckerTest {
    private final ClassDefinition mover = DefinitionsFactory.eINSTANCE.createClassDefinition();

    private final AttributeDefinition c1 = attribute("c1");

    private final AttributeDefinition c2 = attribute("c2");

    private final MultiVariateChecker checker = new MultiVariateChecker(
            comparison(sum(reference(c1), AddOrSubtractOperator.ADD, reference(c2)), ComparisonOperator.GREATER_EQUAL, real(4.0)));

    private AttributeDefinition attribute(final String name) {
        final AttributeDefinition attribute = DefinitionsFactory.eINSTANCE.createAttributeDefinition();
        attribute.setName(name);
        attribute.setInitialisation(term(real(2.05)));
        mover.getAttributes().add(attribute);
        return attribute;
    }

    private static AttributeReference reference(final AttributeDefinition attribute) {
        final ValueDefinitionReference child = ExpressionsFactory.eINSTANCE.createValueDefinitionReference();
        child.setDefinition(attribute);

        final AttributeReference reference = ExpressionsFactory.eINSTANCE.createAttributeReference();
        reference.setSelf(ExpressionsFactory.eINSTANCE.createSelfReference());
        reference.getChain().add(child);
        return reference;
    }

    private Instance instance(final Double c1Value, final Double c2Value) {
        final Instance instance = ExpressionsFactory.eINSTANCE.createInstance();
        instance.setDefinition(mover);
        set(instance, c1, c1Value);
        set(instance, c2, c2Value);
        return instance;
    }

    private static void set(final Instance instance, final AttributeDefinition definition, final Double value) {
        if(value == null) {
            return;
        }

        final Attribute attribute = ExpressionsFactory.eINSTANCE.createAttribute();
        attribute.setDefinition(definition);
        attribute.setValue(term(real(value)));
        instance.getAttributes().add(attribute);
    }

    @Test
    public void satisfiedValuesPass() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, checker.check(instance(2.05, 2.05)));
    }

    @Test
    public void violatingValuesAreReported() {
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, checker.check(instance(1.0, 2.0)));
    }

    @Test
    public void unsetAttributesHaveTheirDefault() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, checker.check(instance(null, null)));
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, checker.check(instance(1.0, null)));
    }

    @Test
    public void anAttributeWithoutValueOrDefaultCannotBeChecked() {
        c2.setInitialisation(null);

        Assertions.assertInstanceOf(ConstraintCheck.NotCheckable.class, checker.check(instance(2.05, null)));
    }

    @Test
    public void onlyInstancesCanBeChecked() {
        final Expression notAnInstance = real(1.0);

        Assertions.assertInstanceOf(ConstraintCheck.NotCheckable.class, checker.check(notAnInstance));
    }
}

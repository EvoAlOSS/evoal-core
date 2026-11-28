package de.evoal.core.api.dynamic;

import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;
import de.evoal.languages.model.base.types.EnumDefinitionReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.expressions.Factor;
import de.evoal.languages.model.base.expressions.IntegerLiteral;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator;
import de.evoal.languages.model.base.expressions.PowerOfExpression;
import de.evoal.languages.model.base.expressions.RealLiteral;
import de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression;

public class ValueConverterTest {
    private static EAttribute attribute(final EClassifier type) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName("value");
        attribute.setEType(type);
        return attribute;
    }

    private static IntegerLiteral integer(final int value) {
        final IntegerLiteral literal = ExpressionsFactory.eINSTANCE.createIntegerLiteral();
        literal.setLiteral(value);
        return literal;
    }

    @Test
    public void integerIsWidenedForRealAttribute() {
        final Object value = new ValueConverter()
                .setTargetType(attribute(EcorePackage.Literals.EDOUBLE))
                .convert(integer(1));

        Assertions.assertEquals(1.0, value);
    }

    @Test
    public void integerWithPrefixIsScaledForRealAttribute() {
        final IntegerLiteral literal = integer(100);
        literal.setFactor(Factor.MICRO);

        final Object value = new ValueConverter()
                .setTargetType(attribute(EcorePackage.Literals.EDOUBLE))
                .convert(literal);

        Assertions.assertEquals(1.0E-4, value);
    }

    @Test
    public void integerWithPrefixThatIsNoWholeNumberIsRejectedForIntegerAttribute() {
        final IntegerLiteral literal = integer(1500);
        literal.setFactor(Factor.MILLI);

        final ValueConverter converter = new ValueConverter().setTargetType(attribute(EcorePackage.Literals.EINT));

        Assertions.assertThrows(IllegalArgumentException.class, () -> converter.convert(literal));
    }

    @Test
    public void integerArrayIsWidenedForRealArray() {
        final Array array = ExpressionsFactory.eINSTANCE.createArray();
        array.getValues().add(integer(1));
        array.getValues().add(integer(2));

        final Object value = new ValueConverter()
                .setTargetType(attribute(EcorePackage.Literals.EDOUBLE))
                .convert(array);

        Assertions.assertEquals(List.of(1.0, 2.0), value);
    }

    @Test
    public void realIsRejectedForIntAttribute() {
        final RealLiteral literal = ExpressionsFactory.eINSTANCE.createRealLiteral();
        literal.setLiteral(1.5);

        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> new ValueConverter()
                .setTargetType(attribute(EcorePackage.Literals.EINT))
                .convert(literal));
        Assertions.assertTrue(e.getMessage().contains("'value'"), e.getMessage());
    }

    @Test
    public void expressionIsKeptUnevaluated() {
        final EReference target = EcoreFactory.eINSTANCE.createEReference();
        target.setName("expression");
        target.setEType(ExpressionsPackage.Literals.EXPRESSION);

        // the expression has to be returned as is (not evaluated to 1) and must stay in the parsed model
        final Array container = ExpressionsFactory.eINSTANCE.createArray();
        final IntegerLiteral expression = integer(1);
        container.getValues().add(expression);

        final Object value = new ValueConverter()
                .setTargetType(target)
                .convert(expression);

        Assertions.assertSame(expression, value);
        Assertions.assertSame(container, expression.eContainer());
    }

    @Test
    public void enumLiteralIsConvertedToEEnumLiteral() {
        final ClassDefinition definition = DynamicEClassProviderTest.createTypeWithEnum();
        final EClass eClass = new DynamicEClassProvider().toEClass(definition);
        final EStructuralFeature feature = eClass.getEStructuralFeature("topology");
        final EEnum eEnum = (EEnum) feature.getEType();

        final EnumDefinitionReference type = (EnumDefinitionReference) ((AttributeDefinition) definition.getAttributes().get(0)).getType();
        final ValueDefinitionReference star = ExpressionsFactory.eINSTANCE.createValueDefinitionReference();
        star.setDefinition(type.getDefinition().getLiterals().get(1));

        final Object value = new ValueConverter()
                .setTargetType(feature)
                .convert(star);

        Assertions.assertSame(eEnum.getEEnumLiteral("star"), value);
    }

    /** Creates a converter whose (normally injected) provider is set. */
    private static ValueConverter converterWith(final DynamicEClassProvider provider) throws ReflectiveOperationException {
        final ValueConverter converter = new ValueConverter();
        final Field field = ValueConverter.class.getDeclaredField("provider");
        field.setAccessible(true);
        field.set(converter, provider);
        return converter;
    }

    private static Instance instanceOf(final ClassDefinition definition) {
        final Instance instance = ExpressionsFactory.eINSTANCE.createInstance();
        instance.setDefinition(definition);
        return instance;
    }

    @Test
    public void defaultsAreAssignedForUnspecifiedAttributes() throws ReflectiveOperationException {
        final ClassDefinition definition = DynamicEClassProviderTest.createTypeWithDefaults();
        final DynamicEClassProvider provider = new DynamicEClassProvider();

        final EObject object = (EObject) converterWith(provider).convert(instanceOf(definition));
        final EClass eClass = object.eClass();

        Assertions.assertEquals(10, object.eGet(eClass.getEStructuralFeature("count")));
        // EMF reports a value equal to the default value literal as not set
        Assertions.assertFalse(object.eIsSet(eClass.getEStructuralFeature("count")));
        Assertions.assertEquals(1.0, object.eGet(eClass.getEAllStructuralFeatures().stream().filter(f -> "rate".equals(f.getName())).findFirst().get()));
        Assertions.assertSame(((EEnum) eClass.getEStructuralFeature("topology").getEType()).getEEnumLiteral("star"),
                              object.eGet(eClass.getEStructuralFeature("topology")));
        Assertions.assertFalse(object.eIsSet(eClass.getEStructuralFeature("name")));
    }

    @Test
    public void specifiedValuesWinOverDefaults() throws ReflectiveOperationException {
        final ClassDefinition definition = DynamicEClassProviderTest.createTypeWithDefaults();
        final AttributeDefinition count = definition.findAttribute("count");

        final Attribute attribute = ExpressionsFactory.eINSTANCE.createAttribute();
        attribute.setDefinition(count);
        attribute.setValue(DynamicEClassProviderTest.integer(3));
        final Instance instance = instanceOf(definition);
        instance.getAttributes().add(attribute);

        final EObject object = (EObject) converterWith(new DynamicEClassProvider()).convert(instance);

        Assertions.assertEquals(3, object.eGet(object.eClass().getEStructuralFeature("count")));
    }

    @Test
    public void integerStaysIntegerForIntAttribute() {
        final Object value = new ValueConverter()
                .setTargetType(attribute(EcorePackage.Literals.EINT))
                .convert(integer(1));

        Assertions.assertEquals(1, value);
    }

    private static PowerOfExpression power(final int value) {
        final UnaryAddOrSubtractExpression unary = ExpressionsFactory.eINSTANCE.createUnaryAddOrSubtractExpression();
        unary.setSubExpression(integer(value));

        final PowerOfExpression power = ExpressionsFactory.eINSTANCE.createPowerOfExpression();
        power.setLeftOperand(unary);
        return power;
    }

    /**
     * @return {@code dividend / divisor}.
     */
    private static MultiplyDivideModuloExpression quotient(final int dividend, final int divisor) {
        final MultiplyDivideModuloExpression quotient = ExpressionsFactory.eINSTANCE.createMultiplyDivideModuloExpression();
        quotient.setLeftOperand(power(dividend));
        quotient.getOperators().add(MultiplyDivideModuloOperator.DIVIDE);
        quotient.getOperands().add(power(divisor));
        return quotient;
    }

    @Test
    public void aQuotientOfIntegersIsARealForARealAttribute() {
        final Object value = new ValueConverter()
                .setTargetType(attribute(EcorePackage.Literals.EDOUBLE))
                .convert(quotient(1, 5));

        Assertions.assertEquals(0.2, value);
    }

    @Test
    public void anIntegralQuotientIsAcceptedForAnIntAttribute() {
        final Object value = new ValueConverter()
                .setTargetType(attribute(EcorePackage.Literals.EINT))
                .convert(quotient(10, 2));

        Assertions.assertEquals(5, value);
    }

    @Test
    public void aFractionalQuotientIsRejectedForAnIntAttribute() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> new ValueConverter()
                .setTargetType(attribute(EcorePackage.Literals.EINT))
                .convert(quotient(7, 2)));
        Assertions.assertTrue(e.getMessage().contains("'value'"), e.getMessage());
    }
}

package de.evoal.core.api.languages.base;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.expressions.AddOrSubtractExpression;
import de.evoal.languages.model.base.expressions.AddOrSubtractOperator;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.IntegerLiteral;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator;
import de.evoal.languages.model.base.expressions.PowerOfExpression;
import de.evoal.languages.model.base.expressions.ReadExpression;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression;

public class DynamicSwitchTest {
    private static final ExpressionsFactory factory = ExpressionsFactory.eINSTANCE;

    private final DataDescription time = data("time");
    private final DataDescription value = data("value");

    private final EAttribute timeFeature = feature("time");
    private final EAttribute valueFeature = feature("value");

    private final Map<DataDescription, EStructuralFeature> features = Map.of(time, timeFeature, value, valueFeature);

    private static DataDescription data(final String name) {
        final DataDescription description = DefinitionsFactory.eINSTANCE.createUntypedBaseDataDescription();
        description.setName(name);
        return description;
    }

    private static EAttribute feature(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        return attribute;
    }

    /** Wraps a primary expression into the operator levels of the expression grammar. */
    private static MultiplyDivideModuloExpression term(final ReadExpression primary) {
        final UnaryAddOrSubtractExpression unary = factory.createUnaryAddOrSubtractExpression();
        unary.setSubExpression(primary);
        final PowerOfExpression power = factory.createPowerOfExpression();
        power.setLeftOperand(unary);
        final MultiplyDivideModuloExpression term = factory.createMultiplyDivideModuloExpression();
        term.setLeftOperand(power);
        return term;
    }

    private static PowerOfExpression power(final ReadExpression primary) {
        return term(primary).getLeftOperand();
    }

    private static TypeDefinitionReference ref(final DataDescription description) {
        final TypeDefinitionReference reference = factory.createTypeDefinitionReference();
        reference.setDefinition(description);
        return reference;
    }

    private static IntegerLiteral integer(final int literal) {
        final IntegerLiteral result = factory.createIntegerLiteral();
        result.setLiteral(literal);
        return result;
    }

    /** {@code data <left> + <right>} */
    private static AddOrSubtractExpression plus(final DataDescription left, final int right) {
        final AddOrSubtractExpression add = factory.createAddOrSubtractExpression();
        add.setLeftOperand(term(ref(left)));
        add.getOperators().add(AddOrSubtractOperator.ADD);
        add.getOperands().add(term(integer(right)));
        return add;
    }

    /** {@code data <left> * <right>} */
    private static AddOrSubtractExpression times(final DataDescription left, final int right) {
        final MultiplyDivideModuloExpression term = term(ref(left));
        term.getOperators().add(MultiplyDivideModuloOperator.MULTIPLY);
        term.getOperands().add(power(integer(right)));
        final AddOrSubtractExpression add = factory.createAddOrSubtractExpression();
        add.setLeftOperand(term);
        return add;
    }

    @Test
    public void dataReferencesAreReadFromTheFeatureSymbolTable() {
        final Map<EStructuralFeature, Object> symbolTable = new HashMap<>();
        symbolTable.put(timeFeature, 1.0);
        symbolTable.put(valueFeature, 1.0);

        final DynamicSwitch timeSwitch = new DynamicSwitch(symbolTable, features);
        final DynamicSwitch valueSwitch = new DynamicSwitch(symbolTable, features);

        // time := time + 1, value := time * 42 (as in the generator-timeseries example)
        Assertions.assertEquals(1.0, timeSwitch.evaluateAndUpdate(timeFeature, plus(time, 1)));
        Assertions.assertEquals(1.0, valueSwitch.evaluateAndUpdate(valueFeature, times(time, 42)));

        Assertions.assertEquals(2.0, symbolTable.get(timeFeature));
        Assertions.assertEquals(84.0, symbolTable.get(valueFeature));
    }

    @Test
    public void unknownDataIsRejected() {
        final DataDescription other = data("other");
        final DynamicSwitch dynamicSwitch = new DynamicSwitch(new HashMap<>(), features);

        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                () -> dynamicSwitch.evaluateAndUpdate(timeFeature, plus(other, 1)));
        Assertions.assertTrue(e.getMessage().contains("'other'"), e.getMessage());
    }
}

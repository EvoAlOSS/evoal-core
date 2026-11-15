package de.evoal.core.api.dynamic;

import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.interpreter.numeric.NumericConversions;

/**
 * Tests {@link NumericConversions} of the interpreter bundle (which has no test setup of its own).
 */
public class NumericConversionsTest {
    @Test
    public void wideningIsAlwaysAllowed() {
        Assertions.assertEquals(1.0, NumericConversions.toDouble(1));
        Assertions.assertEquals(1.0, NumericConversions.toDouble(1L));
        Assertions.assertEquals(1.0f, NumericConversions.toFloat(1));
        Assertions.assertEquals(1L, NumericConversions.toLong(1));
    }

    @Test
    public void losslessNarrowingIsAllowed() {
        Assertions.assertEquals(2, NumericConversions.toInteger(2.0));
        Assertions.assertEquals(2, NumericConversions.toInteger(2L));
        Assertions.assertEquals(-3L, NumericConversions.toLong(-3.0));
    }

    @Test
    public void lossyNarrowingIsRejected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumericConversions.toInteger(1.7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumericConversions.toInteger((long) Integer.MAX_VALUE + 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumericConversions.toInteger(Double.NaN));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumericConversions.toLong(1e19));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumericConversions.toFloat(1e39));
    }

    @Test
    public void nonNumbersAreRejected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumericConversions.toDouble("1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumericConversions.toInteger(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumericConversions.toType("1", EcorePackage.Literals.EDOUBLE));
    }

    @Test
    public void toTypeConvertsToTheTargetClassifier() {
        Assertions.assertEquals(1.0, NumericConversions.toType(1, EcorePackage.Literals.EDOUBLE));
        Assertions.assertEquals(1.0, NumericConversions.toType(1, EcorePackage.Literals.EDOUBLE_OBJECT));
        Assertions.assertEquals(2, NumericConversions.toType(2.0, EcorePackage.Literals.EINT));
        Assertions.assertEquals(2L, NumericConversions.toType(2, EcorePackage.Literals.ELONG));
        Assertions.assertEquals(List.of(1.0, 2.5), NumericConversions.toType(List.of(1, 2.5), EcorePackage.Literals.EDOUBLE));
    }

    @Test
    public void toTypeKeepsNullAndNonNumericTargets() {
        Assertions.assertNull(NumericConversions.toType(null, EcorePackage.Literals.EDOUBLE));
        Assertions.assertEquals(1, NumericConversions.toType(1, EcorePackage.Literals.EJAVA_OBJECT));
        Assertions.assertEquals("x", NumericConversions.toType("x", EcorePackage.Literals.ESTRING));
    }
}

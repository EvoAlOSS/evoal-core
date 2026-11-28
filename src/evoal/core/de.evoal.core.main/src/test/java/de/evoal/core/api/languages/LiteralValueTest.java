package de.evoal.core.api.languages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.Factor;
import de.evoal.languages.model.base.expressions.IntegerLiteral;
import de.evoal.languages.model.base.expressions.RealLiteral;

/**
 * The values of number literals with a metric prefix, e.g. {@code 100µ} (#372).
 */
public class LiteralValueTest {
    private static Number integer(final int value, final Factor factor) {
        final IntegerLiteral literal = ExpressionsFactory.eINSTANCE.createIntegerLiteral();
        literal.setLiteral(value);
        literal.setFactor(factor);
        return literal.getValue();
    }

    private static Number real(final double value, final Factor factor) {
        final RealLiteral literal = ExpressionsFactory.eINSTANCE.createRealLiteral();
        literal.setLiteral(value);
        literal.setFactor(factor);
        return literal.getValue();
    }

    @Test
    public void anIntegerWithoutPrefixStaysAnInteger() {
        Assertions.assertEquals(7, integer(7, Factor.NONE));
    }

    @Test
    public void aWholeScaledValueIsAnInteger() {
        Assertions.assertEquals(5000, integer(5, Factor.KILO));
        Assertions.assertEquals(3, integer(3000, Factor.MILLI));
    }

    @Test
    public void aFractionIsARealNumber() {
        Assertions.assertEquals(1.0E-4, integer(100, Factor.MICRO));
        Assertions.assertEquals(1.5, integer(1500, Factor.MILLI));
    }

    @Test
    public void aValueBeyondTheRangeOfIntIsARealNumber() {
        Assertions.assertEquals(5.0E9, integer(5, Factor.GIGA));
    }

    @Test
    public void aRealIsScaledExactly() {
        Assertions.assertEquals(1.0E-4, real(100.0, Factor.MICRO));
        Assertions.assertEquals(0.1, real(0.1, Factor.NONE));
        Assertions.assertEquals(2500.0, real(2.5, Factor.KILO));
    }
}

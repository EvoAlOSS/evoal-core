package de.evoal.core.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.utils.Requirements;
import lombok.Getter;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NumericOptimisationValueTest {

    @Test
    public void testOf() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue);
        Assertions.assertEquals(42.0, optValue.doubleValue());
    }

    @Test
    public void testCompareToOptimisationValueSameContent() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue1 = NumericOptimisationValue.of(fitness);
        final NumericOptimisationValue optValue2 = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue1);
        Assertions.assertNotNull(optValue2);
        Assertions.assertEquals(0, optValue1.compareTo(optValue2));
        Assertions.assertEquals(0, optValue2.compareTo(optValue1));
    }

    @Test
    public void testCompareToOptimisationValueDifferentContent() {
        double [] fitness1 = {42.0};
        double [] fitness2 = {83.0};

        final NumericOptimisationValue optValue1 = NumericOptimisationValue.of(fitness1);
        final NumericOptimisationValue optValue2 = NumericOptimisationValue.of(fitness2);

        Assertions.assertNotNull(optValue1);
        Assertions.assertNotNull(optValue2);
        Assertions.assertEquals(-1, optValue1.compareTo(optValue2));
        Assertions.assertEquals(1, optValue2.compareTo(optValue1));
    }

    @Test
    public void testCompareToDifferentInstance() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue1 = NumericOptimisationValue.of(fitness);
        final WeightedSumOptimisationValue optValue2 = WeightedSumOptimisationValue.of(fitness, fitness);

        Assertions.assertThrows(IllegalArgumentException.class, () -> optValue1.compareTo(optValue2));
    }

    @Test
    public void testToString() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue);
        Assertions.assertEquals("NumericOptimisationValue [42.0]", optValue.toString());
    }

    @Test
    public void testToStatistics() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue);
        Object [] statistics = optValue.toStatistics();

        Assertions.assertNotNull(statistics);
        Assertions.assertEquals(1, statistics.length);
        Assertions.assertEquals(42.0,statistics[0]);
    }

    @Test
    public void testIntValue() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue);
        int value = optValue.intValue();

        Assertions.assertEquals(42, value);
    }


    @Test
    public void testLongValue() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue);
        long value = optValue.longValue();

        Assertions.assertEquals(42L, value);
    }

    @Test
    public void testFloatValue() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue);
        float value = optValue.floatValue();

        Assertions.assertEquals(42.0f, value);
    }

    @Test
    public void testDoubleValue() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue);
        double value = optValue.doubleValue();

        Assertions.assertEquals(42.0, value);
    }

    @Test
    public void testGetFitnessValue() {
        double [] fitness = {42.0};

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(fitness);

        Assertions.assertNotNull(optValue);
        Number value = optValue.getFitnessValue();

        Assertions.assertEquals(42.0, value);
    }
}

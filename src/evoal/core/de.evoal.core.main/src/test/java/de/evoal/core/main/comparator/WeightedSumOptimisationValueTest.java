package de.evoal.core.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.main.comparator.WeightedSumOptimisationValue;
import lombok.Getter;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WeightedSumOptimisationValueTest  {
    @Test
    public void testGetFitnessValues() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0}, new double [] {42.0});

        Assertions.assertNotNull(testee);
        double [] values = testee.getFitnessValues();

        Assertions.assertNotNull(values);
        Assertions.assertEquals(1, values.length);
        Assertions.assertEquals(42.0, values[0]);
    }

    @Test
    public void testCompareToNull() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});

        Assertions.assertThrows(NullPointerException.class, () -> testee.compareTo(null));
    }

    @Test
    public void testCompareToSelf() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});

        int result = testee.compareTo(testee);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCompareToIdentical() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});
        WeightedSumOptimisationValue other = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});

        int result = testee.compareTo(other);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCompareToLarger() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});
        WeightedSumOptimisationValue other = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 14.0});

        int result = testee.compareTo(other);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testCompareToSmaller() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});
        WeightedSumOptimisationValue other = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {9.0, 12.0});

        int result = testee.compareTo(other);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testCompareToOtherInstance() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});
        NumericOptimisationValue other = NumericOptimisationValue.of(new double [] {9.0});

        Assertions.assertThrows(IllegalArgumentException.class, () -> testee.compareTo(other));
    }

    @Test
    public void testToStringWithOneDimension() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0}, new double [] {42.0});

        Assertions.assertNotNull(testee);
        Assertions.assertEquals("WeightedSum [fit=[42.0], w=[1.0]]", testee.toString());
    }

    @Test
    public void testToStringWithTwoDimensions() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});

        Assertions.assertNotNull(testee);

        Assertions.assertEquals("WeightedSum [fit=[42.0, 12.0], w=[0.4, 0.6]]", testee.toString());
    }

    @Test
    public void testToStatistics() {
        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(new double [] {2.0, 3.0}, new double [] {42.0, 12.0});

        Assertions.assertNotNull(testee);
        Object [] result = testee.toStatistics();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(42.0, result[0]);
        Assertions.assertEquals(12.0, result[1]);
    }
}

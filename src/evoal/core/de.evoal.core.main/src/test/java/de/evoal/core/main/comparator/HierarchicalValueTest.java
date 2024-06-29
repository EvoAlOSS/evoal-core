package de.evoal.core.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class HierarchicalValueTest {

    @Test
    void testOf() {
        int[] orderIndices = {0, 1, 2};
        double[] fitnessValues = {0.5, 0.7, 0.9};

        HierarchicalValue value = HierarchicalValue.of(orderIndices, fitnessValues);

        assertArrayEquals(fitnessValues, value.getFitnessValues(), 0.0001);
    }

    @Test
    void testCompareTo() {
        int[] orderIndices = {0, 1, 2};
        double[] fitnessValues1 = {0.5, 0.7, 0.9};
        double[] fitnessValues2 = {0.6, 0.7, 0.9};

        HierarchicalValue value1 = HierarchicalValue.of(orderIndices, fitnessValues1);
        HierarchicalValue value2 = HierarchicalValue.of(orderIndices, fitnessValues2);

        assertTrue(value1.compareTo(value2) < 0);
        assertTrue(value2.compareTo(value1) > 0);
    }

    @Test
    void testCompareToEqual() {
        int[] orderIndices = {0, 1, 2};
        double[] fitnessValues = {0.5, 0.7, 0.9};

        HierarchicalValue value1 = HierarchicalValue.of(orderIndices, fitnessValues);
        HierarchicalValue value2 = HierarchicalValue.of(orderIndices, fitnessValues);

        assertEquals(0, value1.compareTo(value2));
    }

    @Test
    void testCompareToDifferentOrder() {
        int[] orderIndices1 = {0, 1, 2};
        int[] orderIndices2 = {2, 1, 0};
        double[] fitnessValues1 = {0.5, 0.7, 0.9};
        double[] fitnessValues2 = {0.9, 0.7, 0.5};

        HierarchicalValue value1 = HierarchicalValue.of(orderIndices1, fitnessValues1);
        HierarchicalValue value2 = HierarchicalValue.of(orderIndices2, fitnessValues2);

        assertTrue(value1.compareTo(value2) < 0);
    }

    @Test
    void testToStatistics() {
        int[] orderIndices = {0, 1, 2};
        double[] fitnessValues = {0.5, 0.7, 0.9};

        HierarchicalValue value = HierarchicalValue.of(orderIndices, fitnessValues);

        Object[] statistics = value.toStatistics();

        for(int index = 0; index < statistics.length; index++) {
            assertEquals(fitnessValues[index], statistics[index]);
        }
    }

    @Test
    void testToString() {
        int[] orderIndices = {0, 1, 2};
        double[] fitnessValues = {0.5, 0.7, 0.9};

        HierarchicalValue value = HierarchicalValue.of(orderIndices, fitnessValues);

        String expected = "HierarchicalValue [fit=[0.5, 0.7, 0.9], order=[0, 1, 2]]";
        assertEquals(expected, value.toString());
    }

    @Test
    void testCompareToInvalidType() {
        int[] orderIndices = {0, 1, 2};
        double[] fitnessValues = {0.5, 0.7, 0.9};

        HierarchicalValue value = HierarchicalValue.of(orderIndices, fitnessValues);

        OptimisationValue other = Mockito.mock(OptimisationValue.class);

        assertThrows(IllegalArgumentException.class, () -> value.compareTo(other));
    }
}
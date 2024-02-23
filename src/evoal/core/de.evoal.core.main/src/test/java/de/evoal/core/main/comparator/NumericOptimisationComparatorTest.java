package de.evoal.core.main.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumericOptimisationComparatorTest  {

    @Test
    public void testInitReturnSelf() {
        final NumericOptimisationComparator testee = new NumericOptimisationComparator();

        Assertions.assertNotNull(testee);
        Assertions.assertTrue(() -> testee == testee.init(null), "Init is exepected to return self.");
    }

    @Test
    public void testToValueForSingleValue() {
        final NumericOptimisationComparator testee = new NumericOptimisationComparator();
        double [] fitness = {42.0};


        final NumericOptimisationValue optValue = testee.toValue(fitness);

        Assertions.assertNotNull(optValue);
        Assertions.assertEquals(42.0, optValue.doubleValue());
    }

}

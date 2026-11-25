package de.evoal.surrogate.api.function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.surrogate.api.function.PredictionInterval.Interval;
import de.evoal.surrogate.api.function.Rearrangement.Rearranged;

/**
 * Rearranging the values of quantile models at one point (#349).
 */
public class RearrangementTest {
    @Test
    public void valuesInOrderStayAsTheyAre() {
        Assertions.assertEquals(new Rearranged(2.0, new Interval(1.0, 3.0)), Rearrangement.ofQuantile(2.0, 1.0, 3.0));
        Assertions.assertEquals(new Rearranged(2.0, new Interval(1.0, 3.0)), Rearrangement.ofMean(2.0, 1.0, 3.0));
    }

    @Test
    public void crossingBoundsAreSwapped() {
        Assertions.assertEquals(new Rearranged(2.0, new Interval(1.0, 3.0)), Rearrangement.ofQuantile(2.0, 3.0, 1.0));
        Assertions.assertEquals(new Rearranged(2.0, new Interval(1.0, 3.0)), Rearrangement.ofMean(2.0, 3.0, 1.0));
    }

    @Test
    public void aQuantilePredictionOutsideTheBoundsBecomesABound() {
        // every order of the three values gives the middle one as prediction
        final double[][] orders = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
        for(final double[] values : orders) {
            Assertions.assertEquals(new Rearranged(2.0, new Interval(1.0, 3.0)), Rearrangement.ofQuantile(values[0], values[1], values[2]));
        }
    }

    @Test
    public void aMeanPredictionOutsideTheBoundsStays() {
        Assertions.assertEquals(new Rearranged(5.0, new Interval(1.0, 3.0)), Rearrangement.ofMean(5.0, 3.0, 1.0));
    }

    @Test
    public void theWidthIsTheDistanceOfTheBounds() {
        Assertions.assertEquals(2.5, new Interval(-1.0, 1.5).width());
    }
}

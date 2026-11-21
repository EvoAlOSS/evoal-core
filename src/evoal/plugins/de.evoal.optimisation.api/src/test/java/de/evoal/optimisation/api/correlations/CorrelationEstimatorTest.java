package de.evoal.optimisation.api.correlations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.definitions.ScaleType;

/**
 * The estimates of the {@link CorrelationEstimator}. The reference values of the confidence
 *   intervals were computed independently from the formulas (Python, statistics.NormalDist);
 *   for the Pearson correlation it is the interval of R's cor.test.
 */
public class CorrelationEstimatorTest {
    private static final double[] LINEAR_X = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final double[] LINEAR_Y = {2.1, 3.9, 6.2, 7.8, 9.9, 12.5, 13.1, 16.4, 17.2, 21.0};

    private static final double[] RANK_X = {1, 2, 3, 4, 5, 6, 7, 8};

    private static final double[] RANK_Y = {2, 1, 4, 3, 6, 5, 8, 8};

    @Test
    public void pearsonIsOneForAnIncreasingLinearRelation() {
        Assertions.assertEquals(1.0, CorrelationEstimator.pearson(new double[] {1, 2, 3}, new double[] {2, 4, 6}), 1e-12);
        Assertions.assertEquals(-1.0, CorrelationEstimator.pearson(new double[] {1, 2, 3}, new double[] {3, 2, 1}), 1e-12);
    }

    @Test
    public void pearsonIsUndefinedForAConstantFeatureOrOneValue() {
        Assertions.assertNull(CorrelationEstimator.pearson(new double[] {1, 2, 3}, new double[] {5, 5, 5}));
        Assertions.assertNull(CorrelationEstimator.pearson(new double[] {1}, new double[] {2}));
    }

    @Test
    public void equalValuesGetTheAverageOfTheirRanks() {
        Assertions.assertArrayEquals(new double[] {1.0, 2.5, 2.5, 4.0},
                                     CorrelationEstimator.ranks(new double[] {0.1, 7.0, 7.0, 9.0}));
    }

    @Test
    public void thePearsonIntervalUsesFishersVariance() {
        final CorrelationEstimate estimate = CorrelationEstimator.estimate(CorrelationKind.LINEAR, LINEAR_X, LINEAR_Y, 0.95,
                                                                           RankStandardError.BONETT_WRIGHT);

        Assertions.assertEquals(10, estimate.n());
        Assertions.assertEquals(0.9956358982969217, estimate.coefficient(), 1e-12);
        Assertions.assertEquals(0.9809395711258976, estimate.confidenceLower(), 1e-9);
        Assertions.assertEquals(0.9990064725507297, estimate.confidenceUpper(), 1e-9);
    }

    @Test
    public void theSpearmanIntervalUsesTheChosenVariance() {
        final CorrelationEstimate bonettWright = CorrelationEstimator.estimate(CorrelationKind.RANK, RANK_X, RANK_Y, 0.9,
                                                                               RankStandardError.BONETT_WRIGHT);
        final CorrelationEstimate fieller = CorrelationEstimator.estimate(CorrelationKind.RANK, RANK_X, RANK_Y, 0.9,
                                                                          RankStandardError.FIELLER_HARTLEY_PEARSON);

        Assertions.assertEquals(0.9221722216732094, bonettWright.coefficient(), 1e-12);
        Assertions.assertEquals(0.6201094960730793, bonettWright.confidenceLower(), 1e-9);
        Assertions.assertEquals(0.9861140757363143, bonettWright.confidenceUpper(), 1e-9);
        Assertions.assertEquals(bonettWright.coefficient(), fieller.coefficient());
        Assertions.assertEquals(0.6889786735986791, fieller.confidenceLower(), 1e-9);
        Assertions.assertEquals(0.9823518409874497, fieller.confidenceUpper(), 1e-9);
    }

    @Test
    public void atMostThreePairsHaveNoInterval() {
        final CorrelationEstimate estimate = CorrelationEstimator.estimate(CorrelationKind.LINEAR, new double[] {1, 2, 3},
                                                                           new double[] {1, 3, 2}, 0.95,
                                                                           RankStandardError.BONETT_WRIGHT);

        Assertions.assertEquals(3, estimate.n());
        Assertions.assertNotNull(estimate.coefficient());
        Assertions.assertNull(estimate.confidenceLower());
        Assertions.assertNull(estimate.confidenceUpper());
    }

    @Test
    public void aConstantFeatureHasNoCoefficient() {
        final CorrelationEstimate estimate = CorrelationEstimator.estimate(CorrelationKind.LINEAR, LINEAR_X,
                                                                           new double[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 0.95,
                                                                           RankStandardError.BONETT_WRIGHT);

        Assertions.assertNull(estimate.coefficient());
        Assertions.assertNull(estimate.confidenceLower());
    }

    @Test
    public void aPerfectCorrelationHasAPointInterval() {
        final CorrelationEstimate estimate = CorrelationEstimator.estimate(CorrelationKind.LINEAR, LINEAR_X, LINEAR_X, 0.95,
                                                                           RankStandardError.BONETT_WRIGHT);

        Assertions.assertEquals(1.0, estimate.confidenceLower(), 1e-12);
        Assertions.assertEquals(1.0, estimate.confidenceUpper(), 1e-12);
    }

    @Test
    public void nominalKindsAndInvalidLevelsAreRejected() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> CorrelationEstimator.estimate(CorrelationKind.NOMINAL, LINEAR_X, LINEAR_Y, 0.95,
                                                                    RankStandardError.BONETT_WRIGHT));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> CorrelationEstimator.estimate(CorrelationKind.LINEAR, LINEAR_X, LINEAR_Y, 1.0,
                                                                    RankStandardError.BONETT_WRIGHT));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> CorrelationEstimator.estimate(CorrelationKind.LINEAR, LINEAR_X, RANK_Y, 0.95,
                                                                    RankStandardError.BONETT_WRIGHT));
    }

    @Test
    public void theKindFollowsFromTheScales() {
        Assertions.assertEquals(CorrelationKind.LINEAR, CorrelationKind.of(ScaleType.QUOTIENT, ScaleType.CARDINAL));
        Assertions.assertEquals(CorrelationKind.LINEAR, CorrelationKind.of(ScaleType.UNKNOWN, null));
        Assertions.assertEquals(CorrelationKind.RANK, CorrelationKind.of(ScaleType.ORDINAL, ScaleType.QUOTIENT));
        Assertions.assertEquals(CorrelationKind.NOMINAL, CorrelationKind.of(ScaleType.ORDINAL, ScaleType.NOMINAL));
    }

    @Test
    public void methodsAreFoundByTheirTypeName() {
        Assertions.assertEquals(RankStandardError.BONETT_WRIGHT, RankStandardError.ofTypeName("bonett-wright"));
        Assertions.assertEquals(RankStandardError.FIELLER_HARTLEY_PEARSON,
                                RankStandardError.ofTypeName("fieller-hartley-pearson"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> RankStandardError.ofTypeName("fisher"));
    }
}

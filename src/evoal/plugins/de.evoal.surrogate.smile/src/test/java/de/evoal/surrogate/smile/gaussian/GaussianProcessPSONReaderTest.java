package de.evoal.surrogate.smile.gaussian;

import de.evoal.surrogate.smile.KernelFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import smile.math.kernel.GaussianKernel;
import smile.math.kernel.MercerKernel;
import smile.regression.GaussianProcessRegression;

import java.util.HashMap;
import java.util.Map;

import static de.evoal.surrogate.smile.gaussian.ForresterGaussianProcess.SIGMA;
import static de.evoal.surrogate.smile.gaussian.ForresterGaussianProcess.fit;

/**
 * A Gaussian process predicts the same after storing and restoring its regression.
 */
public class GaussianProcessPSONReaderTest {
    @Nested
    @DisplayName("given a Gaussian process with fitted hyperparameters")
    class FittedHyperparameters {
        private final GaussianProcessRegression<double[]> fitted = fit(100);

        @Test
        public void fittingChangesTheKernel() {
            Assertions.assertNotEquals(SIGMA, fitted.kernel.hyperparameters()[0]);
        }

        @Test
        public void theRestoredRegressionHasTheFittedKernel() {
            // when
            final GaussianProcessRegression<double[]> restored = restore(KernelFactory.toConfiguration(fitted));

            // then
            Assertions.assertArrayEquals(fitted.kernel.hyperparameters(), restored.kernel.hyperparameters());
        }

        @Test
        public void theRestoredRegressionPredictsTheSame() {
            // when
            final GaussianProcessRegression<double[]> restored = restore(KernelFactory.toConfiguration(fitted));

            // then
            assertSamePredictions(fitted, restored);
        }

        @Test
        public void theRestoredRegressionHasTheLogMarginalLikelihood() {
            // when
            final GaussianProcessRegression<double[]> restored = restore(KernelFactory.toConfiguration(fitted));

            // then
            Assertions.assertEquals(fitted.L, restored.L);
        }

        @Test
        public void weightsStoredAsAColumnMatrixAreRead() {
            // given
            final Map<String, Object> configuration = new HashMap<>(KernelFactory.toConfiguration(fitted));
            configuration.put(KernelFactory.GP_WEIGHTS, fitted.w);

            // when
            final GaussianProcessRegression<double[]> restored = restore(configuration);

            // then
            assertSamePredictions(fitted, restored);
        }
    }

    @Nested
    @DisplayName("given a model file without hyperparameters and log marginal likelihood")
    class OlderModelFile {
        private final GaussianProcessRegression<double[]> fitted = fit(0);

        private final Map<String, Object> configuration = new HashMap<>(KernelFactory.toConfiguration(fitted));

        OlderModelFile() {
            configuration.remove(KernelFactory.GP_HYPERPARAMETERS);
            configuration.remove(KernelFactory.GP_LOG_MARGINAL_LIKELIHOOD);
        }

        @Test
        public void theConfiguredKernelIsUsed() {
            // when
            final GaussianProcessRegression<double[]> restored = restore(configuration);

            // then
            Assertions.assertArrayEquals(new double[] {SIGMA}, restored.kernel.hyperparameters());
            assertSamePredictions(fitted, restored);
        }

        @Test
        public void theLogMarginalLikelihoodIsUnknown() {
            Assertions.assertTrue(Double.isNaN(restore(configuration).L));
        }
    }

    private static GaussianProcessRegression<double[]> restore(final Map<String, Object> configuration) {
        final MercerKernel<double[]> configured = new GaussianKernel(SIGMA);
        return GaussianProcessPSONReader.toRegression(configured, configuration);
    }

    /**
     * Compares the predictions and their standard deviations on a grid over [0, 1].
     */
    private static void assertSamePredictions(final GaussianProcessRegression<double[]> expected,
                                              final GaussianProcessRegression<double[]> actual) {
        for(int i = 0; i <= 100; ++i) {
            final double[] x = {i / 100.0};
            final double[] expectedEstimation = new double[2];
            final double[] actualEstimation = new double[2];

            expected.predict(x, expectedEstimation);
            actual.predict(x, actualEstimation);

            Assertions.assertEquals(expectedEstimation[0], actualEstimation[0], 1e-9, "prediction at " + x[0]);
            Assertions.assertEquals(expectedEstimation[1], actualEstimation[1], 1e-9, "standard deviation at " + x[0]);
        }
    }
}

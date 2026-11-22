package de.evoal.surrogate.smile.gaussian;

import smile.math.kernel.GaussianKernel;
import smile.regression.GaussianProcessRegression;

/**
 * The Gaussian process of the example {@code training.gaussianprocess}: the Forrester
 *   function at 0, 0.1, ..., 0.6, 0.9 and 1.0, i.e. with a gap around its global minimum at
 *   0.757, and a Gaussian kernel.
 */
final class ForresterGaussianProcess {
    /**
     * The training points.
     */
    static final double[] TRAINING = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.9, 1.0};

    /**
     * The configured length scale of the Gaussian kernel.
     */
    static final double SIGMA = 0.2;

    /**
     * The configured noise.
     */
    static final double NOISE = 0.01;

    private ForresterGaussianProcess() {
    }

    /**
     * @param iterations The iterations of the fit of the hyperparameters; 0 keeps the
     *   configured kernel and noise.
     * @return The fitted Gaussian process.
     */
    static GaussianProcessRegression<double[]> fit(final int iterations) {
        final double[][] x = new double[TRAINING.length][];
        final double[] y = new double[TRAINING.length];
        for(int i = 0; i < TRAINING.length; ++i) {
            x[i] = new double[] {TRAINING[i]};
            y[i] = forrester(TRAINING[i]);
        }

        final GaussianProcessRegression.Options options = new GaussianProcessRegression.Options(NOISE, true, 1e-5, iterations);
        return GaussianProcessRegression.fit(x, y, new GaussianKernel(SIGMA), options);
    }

    /**
     * @return The Forrester function (Forrester, Sóbester and Keane 2008) at {@code x}.
     */
    static double forrester(final double x) {
        return Math.pow(6 * x - 2, 2) * Math.sin(12 * x - 4);
    }
}

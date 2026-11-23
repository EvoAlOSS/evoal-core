package de.evoal.surrogate.smile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import smile.math.kernel.MaternKernel;
import smile.math.kernel.MercerKernel;

import java.util.HashMap;
import java.util.Map;

/**
 * The kernels that {@link KernelFactory} builds from a kernel configuration: every kernel is
 *   built from a parameter map like the one of its DL type and evaluated on two points against
 *   its formula.
 */
public class KernelFactoryTest {
    private static final double TOLERANCE = 1e-12;

    private static final double[] U = {1.0, 2.0};
    private static final double[] V = {0.5, 0.5};

    /**
     * uᵀv = 0.5 + 1.0
     */
    private static final double DOT = 1.5;

    /**
     * ‖u − v‖² = 0.25 + 2.25
     */
    private static final double SQUARED_DISTANCE = 2.5;

    private static final double DISTANCE = Math.sqrt(SQUARED_DISTANCE);

    @Nested
    @DisplayName("given a 'matérn' kernel configuration")
    class Matern {
        @Test
        public void aMaternKernelWithLengthScaleAndSmoothnessIsBuilt() {
            // when
            final MercerKernel<double[]> kernel = KernelFactory.toKernel(matern(0.3, 2.5));

            // then
            final MaternKernel matern = Assertions.assertInstanceOf(MaternKernel.class, kernel);
            Assertions.assertEquals(0.3, matern.scale());
            Assertions.assertEquals(2.5, matern.smoothness());
        }

        @Test
        public void theKernelFollowsItsFormula() {
            // (1 + √3 d / σ) exp(−√3 d / σ) for ν = 1.5
            final double r = Math.sqrt(3.0) * DISTANCE / 2.0;

            assertValue((1.0 + r) * Math.exp(-r), KernelFactory.toKernel(matern(2.0, 1.5)));
        }

        @Test
        public void anUnsupportedSmoothnessIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> KernelFactory.toKernel(matern(0.3, 1.0)));
        }
    }

    @Nested
    @DisplayName("given a 'pearson' kernel configuration")
    class Pearson {
        @Test
        public void theWidthAndTheTailingFactorAreNotSwapped() {
            // 1 / (1 + 4 ‖u − v‖² (2^(1/ω) − 1) / σ²)^ω with σ = 2 and ω = 0.5
            final double sigma = 2.0;
            final double omega = 0.5;
            final double expected = Math.pow(1.0 + 4.0 * SQUARED_DISTANCE * (Math.pow(2.0, 1.0 / omega) - 1.0) / (sigma * sigma), -omega);

            assertValue(expected, KernelFactory.toKernel(kernel("pearson", "σ", sigma, "ω", omega)));
        }
    }

    @Nested
    @DisplayName("given a 'polynomial' kernel configuration")
    class Polynomial {
        @Test
        public void theKernelIsBuiltWithoutALengthScale() {
            // (γ uᵀv + λ)^d with d = 2, γ = 0.5, λ = 1
            assertValue(Math.pow(0.5 * DOT + 1.0, 2), KernelFactory.toKernel(kernel("polynomial", "degree", 2, "scale", 0.5, "offset", 1.0)));
        }

        @Test
        public void aDegreeBelowOneIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> KernelFactory.toKernel(kernel("polynomial", "degree", 0, "scale", 0.5, "offset", 1.0)));
        }
    }

    @Nested
    @DisplayName("given another kernel configuration")
    class Others {
        @Test
        public void theLinearKernelIsTheDotProduct() {
            assertValue(DOT, KernelFactory.toKernel(kernel("linear")));
        }

        @Test
        public void theGaussianKernelFollowsItsFormula() {
            // exp(−‖u − v‖² / (2σ²))
            assertValue(Math.exp(-SQUARED_DISTANCE / (2.0 * 4.0)), KernelFactory.toKernel(kernel("gaussian", "σ", 2.0)));
        }

        @Test
        public void theLaplacianKernelFollowsItsFormula() {
            // exp(−‖u − v‖ / σ)
            assertValue(Math.exp(-DISTANCE / 2.0), KernelFactory.toKernel(kernel("laplacian", "σ", 2.0)));
        }

        @Test
        public void theThinPlateSplineKernelFollowsItsFormula() {
            // (‖u − v‖ / σ)² log(‖u − v‖ / σ)
            final double r = DISTANCE / 0.5;

            assertValue(r * r * Math.log(r), KernelFactory.toKernel(kernel("thin-plate-spline", "σ", 0.5)));
        }

        @Test
        public void theHyperbolicTangentKernelIsBuiltWithoutALengthScale() {
            // tanh(γ uᵀv + λ)
            assertValue(Math.tanh(0.5 * DOT + 1.0), KernelFactory.toKernel(kernel("hyperbolic-tangent", "scale", 0.5, "offset", 1.0)));
        }

        @Test
        public void theHellingerKernelIsBuiltWithoutParameters() {
            // Σ √(u_i v_i)
            assertValue(Math.sqrt(0.5) + Math.sqrt(1.0), KernelFactory.toKernel(kernel("hellinger")));
        }

        @Test
        public void theSumKernelAddsItsKernels() {
            assertValue(DOT + Math.exp(-SQUARED_DISTANCE / 8.0),
                        KernelFactory.toKernel(kernel("sum", "kernel-1", kernel("linear"), "kernel-2", kernel("gaussian", "σ", 2.0))));
        }

        @Test
        public void theProductKernelMultipliesItsKernels() {
            assertValue(DOT * Math.exp(-SQUARED_DISTANCE / 8.0),
                        KernelFactory.toKernel(kernel("product", "kernel-1", kernel("linear"), "kernel-2", kernel("gaussian", "σ", 2.0))));
        }
    }

    private static void assertValue(final double expected, final MercerKernel<double[]> kernel) {
        Assertions.assertEquals(expected, kernel.k(U, V), TOLERANCE);
    }

    private static Map<String, Object> matern(final double sigma, final double nu) {
        return kernel("matérn", KernelFactory.SIGMA_PARAMETER, sigma, "ν", nu);
    }

    /**
     * @param type The name of the DL kernel type, e.g. {@code gaussian}.
     * @param namesAndValues The parameters, alternating name and value.
     * @return The kernel configuration as {@link KernelFactory#toKernelConfiguration} creates it.
     */
    private static Map<String, Object> kernel(final String type, final Object... namesAndValues) {
        final Map<String, Object> result = new HashMap<>();
        result.put(KernelFactory.TYPE_PARAMETER, "de.evoal.surrogate.smile.ml." + type);

        for(int i = 0; i < namesAndValues.length; i += 2) {
            result.put((String) namesAndValues[i], namesAndValues[i + 1]);
        }

        return result;
    }
}

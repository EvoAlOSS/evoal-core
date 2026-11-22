package de.evoal.surrogate.smile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import smile.math.kernel.MaternKernel;
import smile.math.kernel.MercerKernel;

import java.util.Map;

/**
 * The kernels that {@link KernelFactory} builds from a kernel configuration.
 */
public class KernelFactoryTest {
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
        public void anUnsupportedSmoothnessIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> KernelFactory.toKernel(matern(0.3, 1.0)));
        }
    }

    private static Map<String, Object> matern(final double sigma, final double nu) {
        return Map.of(KernelFactory.TYPE_PARAMETER, "de.evoal.surrogate.smile.ml.matérn",
                      KernelFactory.SIGMA_PARAMETER, sigma,
                      "ν", nu);
    }
}

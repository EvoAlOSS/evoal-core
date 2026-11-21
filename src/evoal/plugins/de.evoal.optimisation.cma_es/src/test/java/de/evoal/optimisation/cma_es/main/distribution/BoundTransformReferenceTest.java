package de.evoal.optimisation.cma_es.main.distribution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Compares {@link BoundTransform} with {@code BoxConstraintsLinQuadTransformation} of pycma
 *   for bounds on both sides, narrow bounds and one-sided bounds. The data comes from
 *   {@code src/test/python/pycma-reference.py}.
 */
public class BoundTransformReferenceTest {
    private static final double TOLERANCE = 1.0e-12;

    @Nested
    @DisplayName("given the transformed values of pycma")
    class PycmaValues {
        private List<String> lines;

        @BeforeEach
        public void readReference() throws IOException {
            try(InputStream stream = BoundTransformReferenceTest.class.getResourceAsStream("pycma-bounds.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
                lines = reader.lines().toList();
            }
        }

        @Test
        public void transformAndInverseAgreeWithPycma() {
            BoundTransform transform = null;
            int compared = 0;

            for(final String line : lines) {
                if(line.startsWith("#")) {
                    continue;
                }

                final String[] parts = line.split(" ");
                final double first = number(parts[1]);
                final double second = number(parts[2]);

                switch(parts[0]) {
                    case "bounds" -> transform = new BoundTransform(new double[] {first}, new double[] {second});
                    case "transform" -> {
                        // when
                        final double actual = transform.transform(new double[] {first})[0];

                        // then
                        Assertions.assertEquals(second, actual, TOLERANCE * Math.max(1.0, Math.abs(second)), line);
                        ++compared;
                    }
                    case "inverse" -> {
                        // when
                        final double actual = transform.inverse(new double[] {first})[0];

                        // then
                        Assertions.assertEquals(second, actual, TOLERANCE * Math.max(1.0, Math.abs(second)), line);
                        ++compared;
                    }
                    default -> Assertions.fail("Unknown line '" + line + "'.");
                }
            }

            Assertions.assertTrue(compared > 400, "only " + compared + " values compared");
        }
    }

    /**
     * @return The number of a value that Python wrote, {@code inf} and {@code -inf} included.
     */
    private static double number(final String text) {
        return switch(text) {
            case "inf" -> Double.POSITIVE_INFINITY;
            case "-inf" -> Double.NEGATIVE_INFINITY;
            default -> Double.parseDouble(text);
        };
    }

    @Nested
    @DisplayName("given the bounds [-5, 5]")
    class BbobBounds {
        private final BoundTransform transform = new BoundTransform(new double[] {-5.0}, new double[] {5.0});

        @Test
        public void pointsInsideTheMarginsAreUnchanged() {
            // when
            final double[] transformed = transform.transform(new double[] {4.74});

            // then
            Assertions.assertEquals(4.74, transformed[0]);
        }

        @Test
        public void pointsOutsideAreMappedIntoTheBounds() {
            // when
            final double[] transformed = transform.transform(new double[] {123.4});

            // then
            Assertions.assertTrue(-5.0 <= transformed[0] && transformed[0] <= 5.0, "got " + transformed[0]);
        }

        @Test
        public void isNotTheIdentity() {
            Assertions.assertFalse(transform.isIdentity());
        }

        @Test
        public void mirroredPointsHaveTheOppositeOrientation() {
            // given: 9.5 is mirrored at 5.25, -11.5 is shifted by one period to 9.5 and mirrored
            final double[] points = {1.0, 9.5, -11.5};

            // when
            final double[] transformed = Arrays.stream(points)
                                               .map(point -> transform.transform(new double[] {point})[0])
                                               .toArray();
            final double[] orientation = Arrays.stream(points)
                                               .map(point -> transform.orientation(new double[] {point})[0])
                                               .toArray();

            // then
            Assertions.assertArrayEquals(new double[] {1.0, 1.0, 1.0}, transformed, TOLERANCE);
            Assertions.assertArrayEquals(new double[] {1.0, -1.0, -1.0}, orientation);
        }

        @Test
        public void orientationMatchesTheDerivative() {
            for(double point = -40.0; point <= 40.0; point += 0.37) {
                // when
                final double sign = transform.orientation(new double[] {point})[0];
                final double left = transform.transform(new double[] {point - 1.0e-7})[0];
                final double right = transform.transform(new double[] {point + 1.0e-7})[0];

                // then: where the derivative is not 0 (the quadratic parts at the ends)
                final double slope = right - left;
                if(Math.abs(slope) > 1.0e-9) {
                    Assertions.assertEquals(Math.signum(slope), sign, "at " + point);
                }
            }
        }
    }

    @Nested
    @DisplayName("given no bounds")
    class NoBounds {
        private final BoundTransform transform = new BoundTransform(new double[] {Double.NEGATIVE_INFINITY},
                                                                    new double[] {Double.POSITIVE_INFINITY});

        @Test
        public void everyPointIsUnchanged() {
            // when
            final double[] transformed = transform.transform(new double[] {-1.0e300});

            // then
            Assertions.assertEquals(-1.0e300, transformed[0]);
            Assertions.assertTrue(transform.isIdentity());
        }
    }
}

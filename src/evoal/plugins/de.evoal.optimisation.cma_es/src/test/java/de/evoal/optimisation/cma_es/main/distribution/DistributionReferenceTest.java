package de.evoal.optimisation.cma_es.main.distribution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Compares the update of {@link Distribution} with pycma, the reference implementation: the
 *   samples pycma drew are fed into the update, and the state after every iteration has to
 *   agree. The data comes from {@code src/test/python/pycma-reference.py}.
 */
public class DistributionReferenceTest {
    /**
     * The largest relative difference of a vector or matrix; the eigendecompositions and the
     *   functions exp and pow differ in the last bits.
     */
    private static final double TOLERANCE = 1.0e-10;

    @Nested
    @DisplayName("given the samples of pycma")
    class PycmaSamples {
        @ParameterizedTest(name = "{0}")
        @MethodSource("de.evoal.optimisation.cma_es.main.distribution.DistributionReferenceTest#cases")
        public void updateAgreesWithPycma(final ReferenceCase reference) {
            // given
            final StrategyParameters parameters = reference.parameters();
            final int dimension = parameters.dimension();
            final CovarianceModel covariance = reference.diagonal() ? CovarianceModel.diagonal(dimension)
                                                                    : new FullCovariance(reference.initialCovariance(), 1);
            final Distribution distribution = new Distribution(parameters, covariance, reference.mean(), reference.sigma());

            for(final ReferenceIteration iteration : reference.iterations()) {
                // when
                covariance.decomposeIfDue();
                distribution.update(iteration.ranked());

                // then
                final String where = reference.name() + ", iteration " + iteration.number();
                assertClose(iteration.mean(), distribution.mean(), "mean in " + where);
                assertClose(new double[] {iteration.sigma()}, new double[] {distribution.stepSize()}, "sigma in " + where);
                assertClose(iteration.stepSizePath(), distribution.stepSizePath(), "p_sigma in " + where);
                assertClose(iteration.rankOnePath(), distribution.rankOnePath(), "p_c in " + where);
                Assertions.assertEquals(iteration.pathUpdate(), distribution.isPathUpdated(), "h_sigma in " + where);
                assertClose(iteration.covariance(), covarianceOf(covariance), "C in " + where);
            }
        }
    }

    private static void assertClose(final double[] expected, final double[] actual, final String message) {
        Assertions.assertEquals(expected.length, actual.length, message);

        double difference = 0.0;
        double size = 0.0;
        for(int i = 0; i < expected.length; ++i) {
            difference += (expected[i] - actual[i]) * (expected[i] - actual[i]);
            size += expected[i] * expected[i];
        }

        final double relative = Math.sqrt(difference) / Math.max(Math.sqrt(size), Double.MIN_NORMAL);
        Assertions.assertTrue(relative <= TOLERANCE, message + ": relative difference " + relative + ", expected "
                                                     + Arrays.toString(expected) + ", got " + Arrays.toString(actual));
    }

    static Stream<ReferenceCase> cases() throws IOException {
        try(InputStream stream = DistributionReferenceTest.class.getResourceAsStream("pycma-updates.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            return parse(reader.lines().toList()).stream();
        }
    }

    /**
     * @return The matrix as one vector, row by row, or the variances of the diagonal model.
     */
    private static double[] covarianceOf(final CovarianceModel covariance) {
        if(covariance instanceof FullCovariance full) {
            return Arrays.stream(full.matrix())
                         .flatMapToDouble(Arrays::stream)
                         .toArray();
        }

        final double[] variances = new double[covariance.dimension()];
        for(int i = 0; i < variances.length; ++i) {
            variances[i] = covariance.variance(i);
        }

        return variances;
    }

    /**
     * @return The numbers of a line after its key.
     */
    private static double[] numbers(final String[] parts) {
        return Arrays.stream(parts, 1, parts.length)
                     .mapToDouble(Double::parseDouble)
                     .toArray();
    }

    private static List<ReferenceCase> parse(final List<String> lines) {
        final List<ReferenceCase> cases = new ArrayList<>();
        ReferenceCase.Builder current = null;
        ReferenceIteration.Builder iteration = null;

        for(final String line : lines) {
            if(line.isBlank() || line.startsWith("#")) {
                continue;
            }

            final String[] parts = line.split(" ");
            final String key = parts[0];

            switch(key) {
                case "case" -> current = new ReferenceCase.Builder(parts[1]);
                case "end" -> {
                    current.add(iteration);
                    cases.add(current.build());
                    iteration = null;
                }
                case "iteration" -> {
                    current.add(iteration);
                    iteration = new ReferenceIteration.Builder(Integer.parseInt(parts[1]));
                }
                default -> {
                    if(iteration == null) {
                        current.set(key, parts);
                    } else {
                        iteration.set(key, numbers(parts));
                    }
                }
            }
        }

        return cases;
    }

    /**
     * A case of the reference data.
     */
    record ReferenceCase(String name, boolean diagonal, StrategyParameters parameters, double[] mean, double sigma,
                         double[][] initialCovariance, List<ReferenceIteration> iterations) {
        @Override
        public String toString() {
            return name;
        }

        private static final class Builder {
            private boolean diagonal;
            private int dimension;
            private final List<double[]> initialRows = new ArrayList<>();
            private final List<ReferenceIteration> iterations = new ArrayList<>();
            private int lambda;
            private double[] mean;
            private double massOfSelection;
            private final String name;
            private double[] rates;
            private double sigma;
            private double[] weights;

            private Builder(final String name) {
                this.name = name;
            }

            private void add(final ReferenceIteration.Builder iteration) {
                if(iteration != null) {
                    iterations.add(iteration.build(diagonal));
                }
            }

            private ReferenceCase build() {
                final StrategyParameters parameters = new StrategyParameters(dimension, lambda, weights, massOfSelection,
                                                                             rates[0], rates[1], rates[2], rates[3],
                                                                             rates[4], rates[5]);

                final double[][] initial = initialRows.toArray(double[][]::new);

                return new ReferenceCase(name, diagonal, parameters, mean, sigma, initial, List.copyOf(iterations));
            }

            private void set(final String key, final String[] parts) {
                switch(key) {
                    case "seed" -> { }
                    case "dimension" -> dimension = Integer.parseInt(parts[1]);
                    case "diagonal" -> diagonal = Boolean.parseBoolean(parts[1]);
                    case "lambda" -> lambda = Integer.parseInt(parts[1]);
                    case "weights" -> weights = numbers(parts);
                    case "mueff" -> massOfSelection = numbers(parts)[0];
                    case "rates" -> rates = numbers(parts);
                    case "mean" -> mean = numbers(parts);
                    case "sigma" -> sigma = numbers(parts)[0];
                    case "C0" -> initialRows.add(numbers(parts));
                    default -> throw new IllegalArgumentException("Unknown key '" + key + "' in the reference data.");
                }
            }
        }
    }

    /**
     * An iteration of a case: the samples sorted by their value and the state after the update.
     */
    record ReferenceIteration(int number, List<double[]> ranked, double[] mean, double sigma, double[] stepSizePath,
                              double[] rankOnePath, boolean pathUpdate, double[] covariance) {
        private static final class Builder {
            private final List<double[]> covarianceRows = new ArrayList<>();
            private double[] mean;
            private final int number;
            private boolean pathUpdate;
            private double[] rankOnePath;
            private final List<double[]> ranked = new ArrayList<>();
            private double sigma;
            private double[] stepSizePath;
            private double[] variances;

            private Builder(final int number) {
                this.number = number;
            }

            private ReferenceIteration build(final boolean diagonal) {
                final double[] covariance = diagonal ? variances
                                                     : covarianceRows.stream()
                                                                     .flatMapToDouble(Arrays::stream)
                                                                     .toArray();

                return new ReferenceIteration(number, List.copyOf(ranked), mean, sigma, stepSizePath, rankOnePath,
                                              pathUpdate, covariance);
            }

            private void set(final String key, final double[] values) {
                switch(key) {
                    case "x" -> ranked.add(values);
                    case "mean" -> mean = values;
                    case "sigma" -> sigma = values[0];
                    case "ps" -> stepSizePath = values;
                    case "pc" -> rankOnePath = values;
                    case "h" -> pathUpdate = values[0] == 1.0;
                    case "C" -> covarianceRows.add(values);
                    case "variances" -> variances = values;
                    default -> throw new IllegalArgumentException("Unknown key '" + key + "' in the reference data.");
                }
            }
        }
    }
}

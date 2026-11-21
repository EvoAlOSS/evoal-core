package de.evoal.optimisation.cma_es.main.distribution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StrategyParametersTest {
    private static final double TOLERANCE = 1.0e-8;

    @Nested
    @DisplayName("given 20 search variables and lambda = 12")
    class TwentyVariables {
        /**
         * The values of the example of {@code cma.options_parameters.CMAParameters} in pycma
         *   4.6.0, whose formulas for these parameters are those of the tutorial.
         */
        private final StrategyParameters parameters = StrategyParameters.defaults(20, 12, 6);

        @Test
        public void weightsAndSelectionMassAreThoseOfTheTutorial() {
            Assertions.assertArrayEquals(new double[] {0.4024029428, 0.2533890840, 0.1662215645, 0.1043752252,
                                                       0.05640347757, 0.01720770576},
                                         parameters.weights(), TOLERANCE);
            Assertions.assertEquals(3.7, parameters.effectiveSelectionMass(), 0.05);
        }

        @Test
        public void learningRatesAreThoseOfTheTutorial() {
            final double massOfSelection = parameters.effectiveSelectionMass();

            Assertions.assertEquals(0.171767, parameters.cC(), 1.0e-6);
            Assertions.assertEquals(0.00437235, parameters.c1(), 1.0e-8);
            Assertions.assertEquals(0.00921656, parameters.cMu(), 1.0e-8);
            Assertions.assertEquals((massOfSelection + 2.0) / (20.0 + massOfSelection + 5.0), parameters.cSigma(), 1.0e-15);
            Assertions.assertEquals(1.0 + parameters.cSigma(), parameters.dSigma(), 1.0e-15);
            Assertions.assertEquals(1.0, parameters.cM());
        }

        @Test
        public void separableParametersScaleTheCovarianceLearningRates() {
            // when
            final StrategyParameters separable = parameters.separable();

            // then
            Assertions.assertEquals(parameters.c1() * 22.0 / 3.0, separable.c1(), 1.0e-15);
            Assertions.assertEquals(parameters.cMu() * 22.0 / 3.0, separable.cMu(), 1.0e-15);
            Assertions.assertEquals(parameters.cC(), separable.cC());
        }
    }

    @Nested
    @DisplayName("given the default population size")
    class DefaultPopulationSize {
        @Test
        public void populationSizeIsFourPlusThreeLogarithmOfN() {
            Assertions.assertEquals(6, StrategyParameters.defaultPopulationSize(2));
            Assertions.assertEquals(10, StrategyParameters.defaultPopulationSize(10));
            Assertions.assertEquals(24, StrategyParameters.defaultPopulationSize(1000));
        }

        @Test
        public void tooManyParentsAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> StrategyParameters.defaults(10, 10, 6));
        }
    }

    @Nested
    @DisplayName("given the expected length of a standard normal vector")
    class ExpectedLength {
        @Test
        public void expectedLengthIsExact() {
            // values of cma.utilities.math.Mh.chiN in pycma 4.6.0
            Assertions.assertEquals(1.595769121605731, Distribution.expectedLength(3), 1.0e-15);
            Assertions.assertEquals(9.97503163955105, Distribution.expectedLength(100), 1.0e-13);
            Assertions.assertEquals(Math.sqrt(Math.PI / 2.0), Distribution.expectedLength(2), 1.0e-15);
        }
    }
}

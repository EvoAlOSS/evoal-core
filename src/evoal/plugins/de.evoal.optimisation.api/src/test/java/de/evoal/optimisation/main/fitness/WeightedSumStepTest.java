package de.evoal.optimisation.main.fitness;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessLayout;

public class WeightedSumStepTest {
    private static final FitnessLayout LAYOUT = new FitnessLayout(List.of(FitnessComponent.named("a"),
                                                                          FitnessComponent.named("b")));

    private static double sumOf(final WeightedSumStep step, final double a, final double b) {
        final Fitness fitness = new Fitness(LAYOUT, new double[] {a, b});

        return step.apply(null, fitness).value(0);
    }

    @Nested
    @DisplayName("given any weighted sum")
    class Layout {
        @Test
        public void theFitnessHasOneComponentWithoutGoal() {
            // given
            final WeightedSumStep step = new WeightedSumStep(Map.of("a", 1.0, "b", 1.0), true);

            // when
            final FitnessLayout layout = step.layout(LAYOUT);

            // then
            Assertions.assertEquals(1, layout.size());
            Assertions.assertEquals(WeightedSumStep.COMPONENT_NAME, layout.component(0).name());
            Assertions.assertTrue(layout.component(0).goal().isEmpty());
        }

        @Test
        public void theResultHasTheDeclaredLayout() {
            // given
            final WeightedSumStep step = new WeightedSumStep(Map.of("a", 1.0, "b", 1.0), true);
            final FitnessLayout declared = step.layout(LAYOUT);
            final Fitness fitness = new Fitness(LAYOUT, new double[] {1.0, 2.0});

            // when
            final Fitness result = step.apply(null, fitness);

            // then
            Assertions.assertEquals(declared, result.layout());
        }
    }

    @Test
    public void weightsAreRequired() {
        // no equal weights for an empty list (#311)
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                                                                   () -> new WeightedSumStep(Map.of(), true));
        Assertions.assertTrue(e.getMessage().contains("needs a weight for every component"), e.getMessage());
    }

    @Nested
    @DisplayName("given the same weight for every component")
    class EqualWeights {
        @Test
        public void theNormalisedSumIsTheMean() {
            final WeightedSumStep step = new WeightedSumStep(Map.of("a", 1.0, "b", 1.0), true);

            Assertions.assertEquals(2.0, sumOf(step, 1.0, 3.0));
        }

        @Test
        public void theSumWithoutNormalisationIsThePlainSum() {
            final WeightedSumStep step = new WeightedSumStep(Map.of("a", 1.0, "b", 1.0), false);

            Assertions.assertEquals(4.0, sumOf(step, 1.0, 3.0));
        }
    }

    @Nested
    @DisplayName("given a weight for every component")
    class GivenWeights {
        private final Map<String, Double> weights = Map.of("a", 3.0, "b", 1.0);

        @Test
        public void normalisedWeightsSumToOne() {
            final WeightedSumStep step = new WeightedSumStep(weights, true);

            Assertions.assertEquals(0.75 * 2.0 + 0.25 * 4.0, sumOf(step, 2.0, 4.0));
        }

        @Test
        public void weightsWithoutNormalisationAreUsedAsGiven() {
            final WeightedSumStep step = new WeightedSumStep(weights, false);

            Assertions.assertEquals(3.0 * 2.0 + 1.0 * 4.0, sumOf(step, 2.0, 4.0));
        }

        @Test
        public void normalisationKeepsTheOrderOfTheCandidates() {
            // given
            final WeightedSumStep normalised = new WeightedSumStep(weights, true);
            final WeightedSumStep plain = new WeightedSumStep(weights, false);

            // when
            final int byNormalised = Double.compare(sumOf(normalised, 1.0, 5.0), sumOf(normalised, 2.0, 1.0));
            final int byPlain = Double.compare(sumOf(plain, 1.0, 5.0), sumOf(plain, 2.0, 1.0));

            // then
            Assertions.assertEquals(byPlain, byNormalised);
        }

        @Test
        public void aWeightOfZeroIgnoresTheComponent() {
            final WeightedSumStep step = new WeightedSumStep(Map.of("a", 0.0, "b", 2.0), false);

            Assertions.assertEquals(8.0, sumOf(step, 100.0, 4.0));
        }
    }

    @Nested
    @DisplayName("given invalid weights")
    class InvalidWeights {
        @Test
        public void weightsForSomeComponentsOnlyAreRejected() {
            final WeightedSumStep step = new WeightedSumStep(Map.of("a", 1.0), true);

            Assertions.assertThrows(IllegalArgumentException.class, () -> step.layout(LAYOUT));
        }

        @Test
        public void aWeightForAnUnknownComponentIsRejected() {
            final WeightedSumStep step = new WeightedSumStep(Map.of("a", 1.0, "b", 1.0, "c", 1.0), true);

            Assertions.assertThrows(IllegalArgumentException.class, () -> step.layout(LAYOUT));
        }

        @Test
        public void aNegativeWeightIsRejected() {
            final Map<String, Double> weights = Map.of("a", 1.0, "b", -1.0);

            Assertions.assertThrows(IllegalArgumentException.class, () -> new WeightedSumStep(weights, true));
        }

        @Test
        public void anUndefinedWeightIsRejected() {
            final Map<String, Double> weights = Map.of("a", 1.0, "b", Double.NaN);

            Assertions.assertThrows(IllegalArgumentException.class, () -> new WeightedSumStep(weights, true));
        }

        @Test
        public void onlyZeroWeightsAreRejected() {
            final Map<String, Double> weights = Map.of("a", 0.0, "b", 0.0);

            Assertions.assertThrows(IllegalArgumentException.class, () -> new WeightedSumStep(weights, false));
        }
    }
}

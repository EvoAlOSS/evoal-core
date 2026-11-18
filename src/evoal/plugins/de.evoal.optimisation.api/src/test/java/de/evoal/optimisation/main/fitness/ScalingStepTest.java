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

public class ScalingStepTest {
    private static final FitnessLayout LAYOUT = new FitnessLayout(List.of(FitnessComponent.named("a"),
                                                                          FitnessComponent.named("b")));

    @Nested
    @DisplayName("given a reference value for one component")
    class OneReference {
        private final ScalingStep step = new ScalingStep(Map.of("a", 4.0));

        @Test
        public void theComponentIsDividedByItsReferenceValue() {
            // given
            final Fitness fitness = new Fitness(LAYOUT, new double[] {2.0, -6.0});

            // when
            final Fitness scaled = step.apply(null, fitness);

            // then
            Assertions.assertArrayEquals(new double[] {0.5, -6.0}, scaled.values());
        }

        @Test
        public void theLayoutIsKept() {
            Assertions.assertSame(LAYOUT, step.layout(LAYOUT));
        }
    }

    @Nested
    @DisplayName("given invalid reference values")
    class InvalidReferences {
        @Test
        public void aReferenceOfZeroIsRejected() {
            final Map<String, Double> references = Map.of("a", 0.0);

            Assertions.assertThrows(IllegalArgumentException.class, () -> new ScalingStep(references));
        }

        @Test
        public void aNegativeReferenceIsRejected() {
            final Map<String, Double> references = Map.of("a", -2.0);

            Assertions.assertThrows(IllegalArgumentException.class, () -> new ScalingStep(references));
        }

        @Test
        public void anUndefinedReferenceIsRejected() {
            final Map<String, Double> references = Map.of("a", Double.NaN);

            Assertions.assertThrows(IllegalArgumentException.class, () -> new ScalingStep(references));
        }

        @Test
        public void aReferenceForAnUnknownComponentIsRejected() {
            final ScalingStep step = new ScalingStep(Map.of("c", 1.0));

            Assertions.assertThrows(IllegalArgumentException.class, () -> step.layout(LAYOUT));
        }
    }
}

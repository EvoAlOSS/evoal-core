package de.evoal.optimisation.main.fitness;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessLayout;

public class ObjectiveSelectionStepTest {
    private static final FitnessComponent A = FitnessComponent.named("a");

    private static final FitnessComponent B = FitnessComponent.named("b");

    private static final FitnessLayout LAYOUT = new FitnessLayout(List.of(A, B));

    @Test
    public void theLayoutHasTheSelectedComponentOnly() {
        // given
        final ObjectiveSelectionStep step = new ObjectiveSelectionStep("b");

        // when
        final FitnessLayout layout = step.layout(LAYOUT);

        // then
        Assertions.assertEquals(List.of(B), layout.components());
    }

    @Test
    public void theFitnessOfTheSelectedComponentIsKept() {
        // given
        final ObjectiveSelectionStep step = new ObjectiveSelectionStep("b");
        final Fitness fitness = new Fitness(LAYOUT, new double[] {1.0, -2.0});

        // when
        final Fitness selected = step.apply(null, fitness);

        // then
        Assertions.assertArrayEquals(new double[] {-2.0}, selected.values());
        Assertions.assertEquals(step.layout(LAYOUT), selected.layout());
    }

    @Test
    public void anUnknownObjectiveIsRejected() {
        final ObjectiveSelectionStep step = new ObjectiveSelectionStep("c");

        Assertions.assertThrows(IllegalArgumentException.class, () -> step.layout(LAYOUT));
    }
}

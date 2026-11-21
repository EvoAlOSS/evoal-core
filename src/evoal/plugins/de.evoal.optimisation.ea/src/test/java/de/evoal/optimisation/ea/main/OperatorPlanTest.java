package de.evoal.optimisation.ea.main;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.operators.BitFlipMutation;
import de.evoal.optimisation.ea.main.operators.SinglePointCrossover;

/**
 * The plan of the operators of the chromosomes.
 */
class OperatorPlanTest {
    @Test
    void aChromosomeWithoutRecombinationsAndMutationsIsReportedAsUnchanged() {
        final OperatorPlan plan = new OperatorPlan(
                List.<OperatorUse<RecombinationOperator>>of(new OperatorUse<>(new SinglePointCrossover(1.0), 0, "test/recombination")),
                List.<OperatorUse<MutationOperator>>of(new OperatorUse<>(new BitFlipMutation(1.0, Double.NaN), 2, "test/mutation")));

        Assertions.assertEquals(List.of(1, 3), plan.unchangedChromosomes(4));
    }

    @Test
    void anOperatorUseNeedsAChromosome() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new OperatorUse<>(new SinglePointCrossover(1.0), -1, "test/recombination"));
    }
}

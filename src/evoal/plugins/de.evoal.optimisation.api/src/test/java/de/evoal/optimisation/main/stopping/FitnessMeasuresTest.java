package de.evoal.optimisation.main.stopping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.v202704.optimisation.memory.IndividualRecord;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;

public class FitnessMeasuresTest {
    private static IndividualRecord individual(final double... fitness) {
        final IndividualRecord individual = MemoryFactory.eINSTANCE.createIndividualRecord();
        for(final double value : fitness) {
            individual.getFitness().add(value);
        }

        return individual;
    }

    private static Rank rank(final IndividualRecord... members) {
        final Rank rank = MemoryFactory.eINSTANCE.createRank();
        for(final IndividualRecord member : members) {
            rank.getMembers().add(member);
        }

        return rank;
    }

    /**
     * @return An iteration with rank 0 (fitness 2 and 3, chosen by the comparator) and rank 1
     *   (fitness 1, e.g. infeasible, and 6).
     */
    private static Iteration iteration() {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.getRanks().add(rank(individual(3.0), individual(2.0)));
        iteration.getRanks().add(rank(individual(1.0), individual(6.0)));

        return iteration;
    }

    @Test
    public void bestFitnessIsTheSmallestFitnessOfRankZero() {
        Assertions.assertEquals(2.0, new BestFitnessMeasure().measure(iteration()));
    }

    @Test
    public void meanFitnessIsTheMeanOfAllMembers() {
        Assertions.assertEquals(3.0, new MeanFitnessMeasure().measure(iteration()));
    }

    @Test
    public void individualsWithoutFitnessAreIgnoredAndNoneGiveNaN() {
        // given
        final Iteration withoutFitness = MemoryFactory.eINSTANCE.createIteration();
        withoutFitness.getRanks().add(rank(individual()));

        final Iteration mixed = MemoryFactory.eINSTANCE.createIteration();
        mixed.getRanks().add(rank(individual(), individual(4.0)));

        // when / then
        Assertions.assertTrue(Double.isNaN(new BestFitnessMeasure().measure(withoutFitness)));
        Assertions.assertTrue(Double.isNaN(new MeanFitnessMeasure().measure(withoutFitness)));
        Assertions.assertTrue(Double.isNaN(new BestFitnessMeasure().measure(MemoryFactory.eINSTANCE.createIteration())));
        Assertions.assertEquals(4.0, new BestFitnessMeasure().measure(mixed));
        Assertions.assertEquals(4.0, new MeanFitnessMeasure().measure(mixed));
    }
}

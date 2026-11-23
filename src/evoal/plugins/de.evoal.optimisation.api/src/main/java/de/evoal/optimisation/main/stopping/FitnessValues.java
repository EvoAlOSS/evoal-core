package de.evoal.optimisation.main.stopping;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import de.evoal.models.v202704.optimisation.memory.Individual;

/**
 * Reads the single fitness component of recorded individuals for the stagnation measures.
 */
final class FitnessValues {
    private FitnessValues() {
    }

    /**
     * @param individuals The individuals.
     * @return The first fitness component of every individual that has a fitness.
     */
    static DoubleStream of(final Stream<? extends Individual> individuals) {
        return individuals.filter(individual -> !individual.getFitness().isEmpty())
                          .mapToDouble(individual -> individual.getFitness().getFirst());
    }
}

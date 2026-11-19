package de.evoal.optimisation.main.statistics.constraints;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;

import de.evoal.optimisation.api.constraints.ConstraintEvaluation;
import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.TestConstraints;

/**
 * The rows of the {@link ConstraintStatistics}.
 */
public class ConstraintStatisticsTest {
    /**
     * Groups in DDL order: "b" (constraints 1, 3), "a" (constraint 2).
     */
    private final Constraints constraints = TestConstraints.constraints("b", "a", "b");

    private static Individual individual(final double first, final double second, final double third) {
        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
        individual.getProperties().put("violation-1", first);
        individual.getProperties().put("violation-2", second);
        individual.getProperties().put("violation-3", third);

        return individual;
    }

    @Test
    public void everyGroupHasTheNumberOfInfeasibleIndividualsAndTheirViolation() {
        // given: two ranks of the population
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(4);

        final Rank first = MemoryFactory.eINSTANCE.createRank();
        first.getMembers().add(individual(0.0, 0.0, 0.0));
        first.getMembers().add(individual(0.5, 0.0, 0.25));
        final Rank second = MemoryFactory.eINSTANCE.createRank();
        second.getMembers().add(individual(0.0, 2.0, 1.0));
        iteration.getRanks().add(first);
        iteration.getRanks().add(second);

        // when
        final Object[] record = new ConstraintStatistics(constraints).toRecord(iteration);

        // then: iteration, then "b" (2 individuals, 0.75 + 1.0), then "a" (1 individual, 2.0)
        Assertions.assertArrayEquals(new Object[] {4, 2L, 1.75, 1L, 2.0}, record);
    }

    @Test
    public void aProblemWithoutConstraintsIsRejected() throws ReflectiveOperationException {
        // given
        final ConstraintStatistics statistics = new ConstraintStatistics();
        final ConstraintEvaluation evaluation = new ConstraintEvaluation();
        evaluation.setUp(Constraints.NONE, null);

        final java.lang.reflect.Field field = ConstraintStatistics.class.getDeclaredField("evaluation");
        field.setAccessible(true);
        field.set(statistics, evaluation);

        // when / then
        Assertions.assertThrows(InitializationException.class, () -> statistics.init(null));
    }
}

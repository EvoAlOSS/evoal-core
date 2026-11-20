package de.evoal.optimisation.main.statistics.correlations;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;

import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.CorrelationRange;

/**
 * The statistics of the {@link CorrelationStatistics}.
 */
public class CorrelationStatisticsTest {
    private final Space space = space();

    private final EStructuralFeature x = space.getEClass().getEStructuralFeature("x");

    private final EStructuralFeature y = space.getEClass().getEStructuralFeature("y");

    private static Space space() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();

        for(final String name : List.of("x", "y")) {
            final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
            feature.setName(name);
            feature.setEType(EcorePackage.Literals.EDOUBLE);
            eClass.getEStructuralFeatures().add(feature);
        }

        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private Iteration iteration(final int number, final double[]... points) {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);

        final Rank rank = MemoryFactory.eINSTANCE.createRank();
        for(final double[] point : points) {
            final TypedEObject input = space.newEObject();
            input.eSet(x, point[0]);
            input.eSet(y, point[1]);

            final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
            individual.setInput(input);
            rank.getMembers().add(individual);
        }
        iteration.getRanks().add(rank);

        return iteration;
    }

    @Test
    public void pearsonIsOneForAnIncreasingLinearRelation() {
        Assertions.assertEquals(1.0, CorrelationStatistics.pearson(new double[] {1, 2, 3}, new double[] {2, 4, 6}), 1e-12);
        Assertions.assertEquals(-1.0, CorrelationStatistics.pearson(new double[] {1, 2, 3}, new double[] {3, 2, 1}), 1e-12);
    }

    @Test
    public void pearsonIsUndefinedForAConstantFeatureOrOneValue() {
        Assertions.assertNull(CorrelationStatistics.pearson(new double[] {1, 2, 3}, new double[] {5, 5, 5}));
        Assertions.assertNull(CorrelationStatistics.pearson(new double[] {1}, new double[] {2}));
    }

    @Test
    public void equalValuesGetTheAverageOfTheirRanks() {
        Assertions.assertArrayEquals(new double[] {1.0, 2.5, 2.5, 4.0},
                                     CorrelationStatistics.ranks(new double[] {0.1, 7.0, 7.0, 9.0}));
    }

    @Test
    public void theRowHasTheEmpiricalCorrelationAndItsDeviationPerCorrelation() {
        // given: y = x^3 is monotone, but not linear
        final Correlation linear = new Correlation(1, x, y, 0.9, null, null, CorrelationKind.LINEAR);
        final Correlation rank = new Correlation(2, x, y, 0.9, null, null, CorrelationKind.RANK);
        final CorrelationStatistics statistics = new CorrelationStatistics(List.of(linear, rank), true, false);

        // when
        final Object[] record = statistics.toRecord(iteration(3, new double[] {1, 1}, new double[] {2, 8},
                                                               new double[] {3, 27}));

        // then
        Assertions.assertEquals(3, record[0]);
        Assertions.assertEquals(3L, record[1]);
        final double pearson = (Double) record[2];
        Assertions.assertTrue(pearson < 1.0 && pearson > 0.9, "Pearson " + pearson);
        Assertions.assertEquals(pearson - 0.9, (Double) record[3], 1e-12);
        Assertions.assertEquals(3L, record[4]);
        Assertions.assertEquals(1.0, (Double) record[5], 1e-12);
        Assertions.assertEquals(0.1, (Double) record[6], 1e-12);
    }

    @Test
    public void aRangedCorrelationOnlyCountsTheMembersInItsRanges() {
        // given
        final Correlation ranged = new Correlation(1, x, y, 1.0, new CorrelationRange(0.0, 2.0),
                                                   new CorrelationRange(0.0, 10.0), CorrelationKind.LINEAR);
        final CorrelationStatistics statistics = new CorrelationStatistics(List.of(ranged), true, false);

        // when
        final Object[] record = statistics.toRecord(iteration(0, new double[] {1, 1}, new double[] {2, 2},
                                                               new double[] {3, 3}, new double[] {1.5, 20}));

        // then: (3, 3) and (1.5, 20) lie outside
        Assertions.assertEquals(2L, record[1]);
        Assertions.assertEquals(1.0, (Double) record[2], 1e-12);
    }

    @Test
    public void theCovarianceDifferenceRefersToTheFirstIteration() {
        // given
        final Correlation linear = new Correlation(1, x, y, 0.5, null, null, CorrelationKind.LINEAR);
        final CorrelationStatistics statistics = new CorrelationStatistics(List.of(linear), false, true);

        // when: covariance 1/3 * 2 = 2/3 first, then 2/3 * 2 = 4/3
        final Object[] first = statistics.toRecord(iteration(0, new double[] {0, 0}, new double[] {1, 1},
                                                              new double[] {2, 2}));
        final Object[] second = statistics.toRecord(iteration(1, new double[] {0, 0}, new double[] {2, 2},
                                                               new double[] {4, 4}));

        // then
        Assertions.assertEquals(2, first.length);
        Assertions.assertEquals(0.0, (Double) first[1], 1e-12);
        Assertions.assertEquals(8.0 / 3.0 - 2.0 / 3.0, (Double) second[1], 1e-12);
    }

    @Test
    public void nominalCorrelationsHaveNoColumns() {
        final Correlation nominal = new Correlation(1, x, y, 0.5, null, null, CorrelationKind.NOMINAL);
        final CorrelationStatistics statistics = new CorrelationStatistics(List.of(nominal), true, true);

        Assertions.assertEquals(1, statistics.toRecord(iteration(0, new double[] {0, 0})).length);
    }
}

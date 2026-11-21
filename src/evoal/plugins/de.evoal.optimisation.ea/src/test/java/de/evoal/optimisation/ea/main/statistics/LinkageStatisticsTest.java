package de.evoal.optimisation.ea.main.statistics;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

import de.evoal.optimisation.api.correlations.BuildingBlock;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.CorrelationRange;
import de.evoal.optimisation.api.correlations.LinkageGroup;
import de.evoal.optimisation.ea.Candidates;

/**
 * The counts of the {@link LinkageStatistics} and the rows of the
 *   {@link LinkageStatisticsWriter}. Features: x, y, z real. Parent A is (0.5, 1, 2), parent B
 *   is (-0.5, 9, 8).
 */
public class LinkageStatisticsTest {
    private final EAttribute x = Candidates.real("x");
    private final EAttribute y = Candidates.real("y");
    private final EAttribute z = Candidates.real("z");
    private final Space space = Candidates.space(x, y, z);

    private final TypedEObject parentA = point(0.5, 1.0, 2.0);
    private final TypedEObject parentB = point(-0.5, 9.0, 8.0);

    private final LinkageStatistics statistics = new LinkageStatistics();

    private Iteration contribute() {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(1);
        statistics.contributeTo(iteration);

        return iteration;
    }

    private static long metric(final Iteration iteration, final String prefix, final String group) {
        return iteration.getMetrics().get(prefix + group).longValue();
    }

    private TypedEObject point(final double xValue, final double yValue, final double zValue) {
        final TypedEObject point = space.newEObject();
        point.eSet(x, xValue);
        point.eSet(y, yValue);
        point.eSet(z, zValue);

        return point;
    }

    private void count(final TypedEObject child) {
        statistics.count(parentA, parentB, child, child);
    }

    @Test
    public void aBuildingBlockIsPreservedIfAllItsFeaturesComeFromOneParent() {
        // given
        statistics.setUp(List.of(new BuildingBlock(1, List.of(x, y))));

        // when: the first child keeps x and y of A, the second mixes them
        count(point(0.5, 1.0, 8.0));
        count(point(0.5, 9.0, 2.0));
        final Iteration iteration = contribute();

        // then
        Assertions.assertEquals(2, metric(iteration, LinkageStatistics.CHILDREN, "building-block-1"));
        Assertions.assertEquals(1, metric(iteration, LinkageStatistics.PRESERVED, "building-block-1"));
        Assertions.assertEquals(1, metric(iteration, LinkageStatistics.PRESERVED_BEFORE, "building-block-1"));
    }

    @Test
    public void aValueBothParentsShareFitsBoth() {
        statistics.setUp(List.of(new BuildingBlock(1, List.of(x, y))));
        final TypedEObject sharedA = point(0.5, 5.0, 2.0);
        final TypedEObject sharedB = point(-0.5, 5.0, 8.0);

        statistics.count(sharedA, sharedB, point(-0.5, 5.0, 2.0), point(-0.5, 5.0, 2.0));

        Assertions.assertEquals(1, metric(contribute(), LinkageStatistics.PRESERVED, "building-block-1"));
    }

    @Test
    public void overlappingBuildingBlocksAreCountedSeparately() {
        statistics.setUp(List.of(new BuildingBlock(1, List.of(x, y)), new BuildingBlock(2, List.of(y, z))));

        // x and y from A, z from B
        count(point(0.5, 1.0, 8.0));
        final Iteration iteration = contribute();

        Assertions.assertEquals(1, metric(iteration, LinkageStatistics.PRESERVED, "building-block-1"));
        Assertions.assertEquals(0, metric(iteration, LinkageStatistics.PRESERVED, "building-block-2"));
    }

    @Test
    public void correlatedPairsAreGroupsOfTwo() {
        statistics.setUp(List.of(new Correlation(1, x, z, 0.5, null, null, CorrelationKind.LINEAR)));

        count(point(0.5, 9.0, 2.0));
        final Iteration iteration = contribute();

        Assertions.assertEquals(1, metric(iteration, LinkageStatistics.CHILDREN, "correlation-1"));
        Assertions.assertEquals(1, metric(iteration, LinkageStatistics.PRESERVED, "correlation-1"));
    }

    @Test
    public void aRangedCorrelationCountsOnlyChildrenOfParentsInItsRanges() {
        // parent B lies outside the range of x
        statistics.setUp(List.of(new Correlation(1, x, y, 0.5, new CorrelationRange(0.0, 1.0), new CorrelationRange(0.0, 10.0),
                                                 CorrelationKind.LINEAR)));

        count(point(0.5, 1.0, 2.0));

        Assertions.assertEquals(0, metric(contribute(), LinkageStatistics.CHILDREN, "correlation-1"));
    }

    @Test
    public void beforeAndAfterTheLinkageStepAreCountedSeparately() {
        statistics.setUp(List.of(new BuildingBlock(1, List.of(x, y))));

        // the crossover disrupted the building block, the linkage step restored it
        statistics.count(parentA, parentB, point(-0.5, 1.0, 2.0), point(-0.5, 9.0, 2.0));
        final Iteration iteration = contribute();

        Assertions.assertEquals(1, metric(iteration, LinkageStatistics.PRESERVED, "building-block-1"));
        Assertions.assertEquals(0, metric(iteration, LinkageStatistics.PRESERVED_BEFORE, "building-block-1"));
    }

    @Test
    public void everyIterationStartsFromZero() {
        statistics.setUp(List.of(new BuildingBlock(1, List.of(x, y))));
        count(point(0.5, 1.0, 2.0));
        contribute();

        Assertions.assertEquals(0, metric(contribute(), LinkageStatistics.CHILDREN, "building-block-1"));
    }

    @Test
    public void aRunWithoutGroupsRecordsNothing() {
        Assertions.assertFalse(statistics.isRecording());
        Assertions.assertTrue(contribute().getMetrics().isEmpty());
    }

    @Test
    public void theWriterAddsTheRatesAndLeavesThemEmptyWithoutChildren() {
        // given
        final List<LinkageGroup> groups = List.of(new BuildingBlock(1, List.of(x, y)), new BuildingBlock(2, List.of(y, z)));
        statistics.setUp(groups);
        statistics.count(parentA, parentB, point(-0.5, 1.0, 2.0), point(-0.5, 9.0, 8.0));
        statistics.count(parentA, parentB, point(0.5, 1.0, 2.0), point(0.5, 1.0, 2.0));
        final Iteration iteration = contribute();
        iteration.getMetrics().removeKey(LinkageStatistics.CHILDREN + "building-block-2");

        // when
        final Object[] record = new LinkageStatisticsWriter(groups).toRecord(iteration);

        // then: block 1 is preserved by both children after, by one before; block 2 has no count
        Assertions.assertEquals(Arrays.asList(1, 2L, 2L, 1.0, 1L, 0.5, null, 2L, null, 2L, null), Arrays.asList(record));
    }
}

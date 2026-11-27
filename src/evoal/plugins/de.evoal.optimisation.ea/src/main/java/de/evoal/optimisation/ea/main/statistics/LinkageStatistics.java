package de.evoal.optimisation.ea.main.statistics;

import java.util.List;

import de.evoal.core.api.cdi.RunScoped;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;

import de.evoal.optimisation.api.correlations.BuildingBlock;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.LinkageGroup;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;
import de.evoal.optimisation.ea.main.correlation.Linkage;

/**
 * Counts how often the recombinations of an iteration preserve the building blocks and the
 *   correlated pairs of the DDL, and records the counts as iteration metrics. The linkage of a
 *   building block is the probability that crossover preserves it (G. R. Harik, D. E.
 *   Goldberg: Learning linkage. Foundations of Genetic Algorithms 4, 1996, pp. 247-262,
 *   section 2); the counts estimate it.
 * <p>
 * Every child that a recombination created is counted for every group that applies to its
 *   parents (a ranged correlation only if both parents lie in its ranges). A group is
 *   preserved in a child if all its features have the values of one parent
 *   ({@link Linkage#isPreserved}). It is checked twice: right before the first linkage step of
 *   the pair ({@code before}, the wrapped crossover alone if a single recombination fired)
 *   and at the end of the recombinations, before the mutation ({@code after}). Without a
 *   linkage step, both are the same.
 * <p>
 * The metrics, per group g ({@code building-block-<n>}, {@code correlation-<n>}):
 *   {@code linkage-children-<g>}, {@code linkage-preserved-<g>} and
 *   {@code linkage-preserved-before-<g>}. The evolutionary algorithm defines them
 *   ({@link #define}) when the DDL declares groups; otherwise the bean records nothing. The
 *   recombinations, including those of resampled children in the candidate checks, run on
 *   the algorithm thread before the evaluation, so today every call comes from that thread;
 *   the methods are synchronised so that the application-scoped bean stays consistent if
 *   recombinations ever run in parallel.
 */
@RunScoped
public class LinkageStatistics implements MetricContributor {
    /**
     * The prefix of the metric with the number of counted children.
     */
    public static final String CHILDREN = "linkage-children-";

    /**
     * The prefix of the metric with the number of children that preserve the group at the end.
     */
    public static final String PRESERVED = "linkage-preserved-";

    /**
     * The prefix of the metric with the number of children that preserve the group before the
     *   first linkage step.
     */
    public static final String PRESERVED_BEFORE = "linkage-preserved-before-";

    /**
     * The counted children per group of the current iteration.
     */
    private long[] children = new long[0];

    /**
     * The groups of the current run, in the order of the DDL; empty if the run records nothing.
     */
    private List<LinkageGroup> groups = List.of();

    /**
     * The children per group of the current iteration that preserve it at the end.
     */
    private long[] preserved = new long[0];

    /**
     * The children per group of the current iteration that preserve it before the first
     *   linkage step.
     */
    private long[] preservedBefore = new long[0];

    /**
     * @param group A building block or a correlation.
     * @return The name of the group in the metrics, e.g. {@code building-block-1}.
     */
    public static String nameOf(final LinkageGroup group) {
        return switch(group) {
            case BuildingBlock block -> "building-block-" + block.number();
            case Correlation correlation -> "correlation-" + correlation.number();
        };
    }

    /**
     * Counts a child of a recombination.
     *
     * @param parentA One parent.
     * @param parentB The other parent.
     * @param before The child before the first linkage step of the pair.
     * @param after The child at the end of the recombinations.
     */
    public synchronized void count(final TypedEObject parentA, final TypedEObject parentB, final TypedEObject before,
                                   final TypedEObject after) {
        for(int i = 0; i < groups.size(); ++i) {
            final LinkageGroup group = groups.get(i);
            if(!Linkage.appliesTo(group, parentA, parentB)) {
                continue;
            }

            ++children[i];
            if(Linkage.isPreserved(group, before, parentA, parentB)) {
                ++preservedBefore[i];
            }
            if(Linkage.isPreserved(group, after, parentA, parentB)) {
                ++preserved[i];
            }
        }
    }

    @Override
    public synchronized void contributeTo(final Iteration iteration) {
        for(int i = 0; i < groups.size(); ++i) {
            final String name = nameOf(groups.get(i));
            iteration.getMetrics().put(CHILDREN + name, children[i]);
            iteration.getMetrics().put(PRESERVED + name, preserved[i]);
            iteration.getMetrics().put(PRESERVED_BEFORE + name, preservedBefore[i]);
        }

        reset();
    }

    /**
     * Defines the metrics of the groups and records them from now on.
     *
     * @param recorder The recorder of the run, in its definition phase.
     * @param linkageGroups The building blocks and correlations of the DDL, in its order.
     */
    public synchronized void define(final ExecutionRecorder recorder, final List<LinkageGroup> linkageGroups) {
        setUp(linkageGroups);

        for(final LinkageGroup group : groups) {
            final String name = nameOf(group);
            recorder.define(metric(CHILDREN + name, "Number of children of recombinations in the iteration that the "
                                                    + group + " applies to."));
            recorder.define(metric(PRESERVED + name, "Number of these children that preserve the " + group
                                                     + " after the recombinations: all its features have the values of "
                                                     + "one parent."));
            recorder.define(metric(PRESERVED_BEFORE + name, "Number of these children that preserve the " + group
                                                            + " before the first linkage step of their pair."));
        }
    }

    /**
     * @return Whether the current run records the statistics.
     */
    public synchronized boolean isRecording() {
        return !groups.isEmpty();
    }

    private static MetricDefinition metric(final String name, final String description) {
        final MetricDefinition metric = MemoryFactory.eINSTANCE.createMetricDefinition();
        metric.setName(name);
        metric.setKind(MetricKind.MEASURE);
        metric.setValueType(MetricValueType.INTEGER);
        metric.setScope(MetricScope.ITERATION);
        metric.setDescription(description);

        return metric;
    }

    /**
     * Counts the given groups without defining metrics, e.g., for tests.
     *
     * @param linkageGroups The building blocks and correlations, in the order of the DDL.
     */
    public synchronized void setUp(final List<LinkageGroup> linkageGroups) {
        groups = List.copyOf(linkageGroups);
        reset();
    }

    private void reset() {
        children = new long[groups.size()];
        preserved = new long[groups.size()];
        preservedBefore = new long[groups.size()];
    }
}

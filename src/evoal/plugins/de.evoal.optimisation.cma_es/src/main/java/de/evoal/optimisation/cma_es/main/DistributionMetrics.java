package de.evoal.optimisation.cma_es.main;

import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.RunScoped;
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

import de.evoal.optimisation.cma_es.main.distribution.BoundTransform;
import de.evoal.optimisation.cma_es.main.distribution.CovarianceModel;
import de.evoal.optimisation.cma_es.main.distribution.Distribution;

/**
 * Records the search distribution of CMA-ES as iteration metrics: the distribution that
 *   sampled the population of the iteration (after the last update if the search ended
 *   without sampling). The metrics:
 * <ul>
 *   <li>{@code sigma}: the step size, {@code axis-ratio}: sqrt of the condition number of C,
 *     {@code population-size}: lambda, {@code restart}: the number of the CMA-ES run,</li>
 *   <li>{@code mean-<feature>}: the mean of every search feature, mapped into the bounds,</li>
 *   <li>for the full model, the correlations rho_ij = C_ij / sqrt(C_ii C_jj), oriented as the
 *     features: the distribution lives in the genotype space, and a coordinate that the
 *     bounds mirror at the mean has the opposite direction, so rho_ij is multiplied by the
 *     signs of the transformation of both coordinates at the mean
 *     ({@link BoundTransform#orientation}). Per
 *     correlation of the DDL {@code learned-correlation-<n>}, per building block of the DDL
 *     the mean |rho| of the pairs within the block ({@code learned-within-building-block-<n>})
 *     and of the pairs of a feature of the block with a feature outside it
 *     ({@code learned-between-building-block-<n>}), and with 'record-all-correlations'
 *     {@code correlation-<f>-<g>} for every pair of search features.</li>
 * </ul>
 * CMA-ES defines the metrics ({@link #define}); otherwise the bean records nothing.
 */
@RunScoped
public class DistributionMetrics implements MetricContributor {
    /**
     * The name of the metric of the axis ratio.
     */
    public static final String AXIS_RATIO = "axis-ratio";

    /**
     * The prefix of the metric of the learned correlation of a declared correlation.
     */
    public static final String LEARNED = "learned-";

    /**
     * The prefix of the metric of the mean |rho| between a building block and the other
     *   features.
     */
    public static final String LEARNED_BETWEEN = "learned-between-";

    /**
     * The prefix of the metric of the mean |rho| within a building block.
     */
    public static final String LEARNED_WITHIN = "learned-within-";

    /**
     * The prefix of the metrics of the mean.
     */
    public static final String MEAN = "mean-";

    /**
     * The prefix of the metrics of the correlations of all pairs.
     */
    public static final String PAIR = "correlation-";

    /**
     * The name of the metric of the population size.
     */
    public static final String POPULATION_SIZE = "population-size";

    /**
     * The name of the metric of the number of the CMA-ES run.
     */
    public static final String RESTART = "restart";

    /**
     * The name of the metric of the step size.
     */
    public static final String SIGMA = "sigma";

    /**
     * Whether the correlations of all pairs are recorded.
     */
    private boolean allPairs;

    /**
     * The bounds of the search features.
     */
    private BoundTransform bounds;

    /**
     * The distribution to record, {@code null} before the first one.
     */
    private Distribution distribution;

    /**
     * The search features, in the order of the distribution.
     */
    private List<EStructuralFeature> features = List.of();

    /**
     * The declared correlations and building blocks whose learned correlations are recorded;
     *   empty for the diagonal model.
     */
    private List<LinkageGroup> groups = List.of();

    /**
     * Whether the current run records metrics.
     */
    private boolean recording;

    /**
     * The number of the CMA-ES run of the distribution.
     */
    private int restart;

    @Override
    public synchronized void contributeTo(final Iteration iteration) {
        if(!recording || distribution == null) {
            return;
        }

        final EMap<String, Number> metrics = iteration.getMetrics();
        final CovarianceModel covariance = distribution.covariance();
        metrics.put(SIGMA, distribution.stepSize());
        metrics.put(AXIS_RATIO, Math.sqrt(covariance.conditionNumber()));
        metrics.put(POPULATION_SIZE, (long) distribution.parameters().populationSize());
        metrics.put(RESTART, (long) restart);

        final double[] genotypeMean = distribution.mean();
        final double[] mean = bounds.transform(genotypeMean);
        final double[] signs = bounds.orientation(genotypeMean);
        for(int i = 0; i < features.size(); ++i) {
            metrics.put(MEAN + features.get(i).getName(), mean[i]);
        }

        for(final LinkageGroup group : groups) {
            switch(group) {
                case Correlation correlation -> metrics.put(LEARNED + nameOf(group), learned(covariance, signs, correlation));
                case BuildingBlock block -> {
                    putIfDefined(metrics, LEARNED_WITHIN + nameOf(group), within(covariance, block));
                    putIfDefined(metrics, LEARNED_BETWEEN + nameOf(group), between(covariance, block));
                }
            }
        }

        if(allPairs) {
            for(int i = 0; i < features.size(); ++i) {
                for(int j = i + 1; j < features.size(); ++j) {
                    metrics.put(pairName(features.get(i), features.get(j)), oriented(covariance, signs, i, j));
                }
            }
        }
    }

    /**
     * @return The mean |rho| of the pairs of a feature of the block with a feature outside
     *   it; NaN if the block contains all features.
     */
    private double between(final CovarianceModel covariance, final BuildingBlock block) {
        final List<Integer> inside = indicesOf(block.features());
        double sum = 0.0;
        int pairs = 0;
        for(final int i : inside) {
            for(int j = 0; j < features.size(); ++j) {
                if(!inside.contains(j)) {
                    sum += Math.abs(covariance.correlation(i, j));
                    ++pairs;
                }
            }
        }

        return pairs == 0 ? Double.NaN : sum / pairs;
    }

    /**
     * Defines the metrics of a CMA-ES run and records them from now on.
     *
     * @param recorder The recorder of the run, in its definition phase.
     * @param searchFeatures The search features, in the order of the distribution.
     * @param linkageGroups The declared correlations and building blocks whose learned
     *   correlations are recorded; empty for the diagonal model.
     * @param recordAllPairs Whether the correlations of all pairs are recorded.
     * @param searchBounds The bounds of the search features.
     */
    public synchronized void define(final ExecutionRecorder recorder, final List<EStructuralFeature> searchFeatures,
                                    final List<LinkageGroup> linkageGroups, final boolean recordAllPairs,
                                    final BoundTransform searchBounds) {
        features = List.copyOf(searchFeatures);
        bounds = searchBounds;
        groups = List.copyOf(linkageGroups);
        allPairs = recordAllPairs;
        distribution = null;
        restart = 0;
        recording = true;

        recorder.define(metric(SIGMA, MetricValueType.REAL, "The step size sigma of the distribution of CMA-ES."));
        recorder.define(metric(AXIS_RATIO, MetricValueType.REAL,
                               "The ratio of the longest to the shortest principal axis of the covariance matrix C."));
        recorder.define(metric(POPULATION_SIZE, MetricValueType.INTEGER, "The population size lambda of CMA-ES."));
        recorder.define(metric(RESTART, MetricValueType.INTEGER,
                               "The number of the CMA-ES run of the distribution, 0 before the first restart."));
        for(final EStructuralFeature feature : features) {
            recorder.define(metric(MEAN + feature.getName(), MetricValueType.REAL,
                                   "The mean of '" + feature.getName() + "' in the distribution of CMA-ES, mapped into "
                                   + "the bounds."));
        }

        for(final LinkageGroup group : groups) {
            switch(group) {
                case Correlation correlation -> recorder.define(metric(LEARNED + nameOf(group), MetricValueType.REAL,
                        "The correlation the covariance matrix of CMA-ES implies for the features of the " + correlation
                        + "."));
                case BuildingBlock block -> {
                    recorder.define(metric(LEARNED_WITHIN + nameOf(group), MetricValueType.REAL,
                            "The mean absolute correlation the covariance matrix of CMA-ES implies for the pairs of "
                            + "features within the " + block + "."));
                    recorder.define(metric(LEARNED_BETWEEN + nameOf(group), MetricValueType.REAL,
                            "The mean absolute correlation the covariance matrix of CMA-ES implies for the pairs of a "
                            + "feature of the " + block + " and a feature outside it."));
                }
            }
        }

        if(allPairs) {
            for(int i = 0; i < features.size(); ++i) {
                for(int j = i + 1; j < features.size(); ++j) {
                    recorder.define(metric(pairName(features.get(i), features.get(j)), MetricValueType.REAL,
                            "The correlation the covariance matrix of CMA-ES implies for '" + features.get(i).getName()
                            + "' and '" + features.get(j).getName() + "'."));
                }
            }
        }
    }

    private List<Integer> indicesOf(final List<EStructuralFeature> groupFeatures) {
        return groupFeatures.stream()
                            .map(features::indexOf)
                            .toList();
    }

    /**
     * @return The correlation C implies for the features of the declared correlation.
     */
    private double learned(final CovarianceModel covariance, final double[] signs, final Correlation correlation) {
        final int first = features.indexOf(correlation.first());
        final int second = features.indexOf(correlation.second());

        return oriented(covariance, signs, first, second);
    }

    private static MetricDefinition metric(final String name, final MetricValueType type, final String description) {
        final MetricDefinition metric = MemoryFactory.eINSTANCE.createMetricDefinition();
        metric.setName(name);
        metric.setKind(MetricKind.MEASURE);
        metric.setValueType(type);
        metric.setScope(MetricScope.ITERATION);
        metric.setDescription(description);

        return metric;
    }

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
     * @return rho_ij in the orientation of the features.
     */
    private static double oriented(final CovarianceModel covariance, final double[] signs, final int i, final int j) {
        return signs[i] * signs[j] * covariance.correlation(i, j);
    }

    private static String pairName(final EStructuralFeature first, final EStructuralFeature second) {
        return PAIR + first.getName() + "-" + second.getName();
    }

    private static void putIfDefined(final EMap<String, Number> metrics, final String name, final double value) {
        if(!Double.isNaN(value)) {
            metrics.put(name, value);
        }
    }

    /**
     * Records the given distribution from now on.
     *
     * @param current The distribution.
     * @param restartNumber The number of its CMA-ES run.
     */
    synchronized void show(final Distribution current, final int restartNumber) {
        distribution = current;
        restart = restartNumber;
    }

    /**
     * @return The mean |rho| of the pairs within the block; NaN for a block of one feature.
     */
    private double within(final CovarianceModel covariance, final BuildingBlock block) {
        final List<Integer> inside = indicesOf(block.features());
        double sum = 0.0;
        int pairs = 0;
        for(int a = 0; a < inside.size(); ++a) {
            for(int b = a + 1; b < inside.size(); ++b) {
                sum += Math.abs(covariance.correlation(inside.get(a), inside.get(b)));
                ++pairs;
            }
        }

        return pairs == 0 ? Double.NaN : sum / pairs;
    }
}

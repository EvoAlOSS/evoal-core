package de.evoal.optimisation.ea.main.statistics;

import de.evoal.core.api.cdi.RunScoped;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;

import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;
import de.evoal.optimisation.ea.api.selection.StochasticRanking;

/**
 * Records the stochastic rankings of an iteration ({@code 'stochastic-ranking-selection'}) as
 *   iteration metrics: {@value #SWEEPS}, the sweeps until the rankings stopped, and the
 *   comparisons of neighbours, at least one of them infeasible, that were decided by the
 *   fitness ({@value #FITNESS_COMPARISONS}) or by the penalty ({@value #PENALTY_COMPARISONS}).
 *   Their ratio shows the balance between objective and penalty that the method controls
 *   (T. P. Runarsson, X. Yao 2000, section II). Several rankings of an iteration, e.g. of the
 *   parent and the survivor selection, are summed.
 * <p>
 * The evolutionary algorithm defines the metrics ({@link #define}) when its configuration
 *   uses the selection; otherwise the bean records nothing.
 */
@RunScoped
public class StochasticRankingStatistics implements MetricContributor {
    /**
     * The metric with the number of sweeps.
     */
    public static final String SWEEPS = "stochastic-ranking-sweeps";

    /**
     * The metric with the number of comparisons decided by the fitness.
     */
    public static final String FITNESS_COMPARISONS = "stochastic-ranking-fitness-comparisons";

    /**
     * The metric with the number of comparisons decided by the penalty.
     */
    public static final String PENALTY_COMPARISONS = "stochastic-ranking-penalty-comparisons";

    private boolean recording;

    private long sweeps;

    private long fitnessComparisons;

    private long penaltyComparisons;

    /**
     * Counts a ranking of the current iteration.
     *
     * @param result The ranking.
     */
    public synchronized void count(final StochasticRanking.Result result) {
        sweeps += result.sweeps();
        fitnessComparisons += result.fitnessComparisons();
        penaltyComparisons += result.penaltyComparisons();
    }

    @Override
    public synchronized void contributeTo(final Iteration iteration) {
        if(recording) {
            iteration.getMetrics().put(SWEEPS, sweeps);
            iteration.getMetrics().put(FITNESS_COMPARISONS, fitnessComparisons);
            iteration.getMetrics().put(PENALTY_COMPARISONS, penaltyComparisons);
        }

        reset();
    }

    /**
     * Defines the metrics and records them from now on.
     *
     * @param recorder The recorder of the run, in its definition phase.
     */
    public synchronized void define(final ExecutionRecorder recorder) {
        recording = true;
        reset();

        recorder.define(metric(SWEEPS, "Number of sweeps of the stochastic rankings in the iteration until they stopped."));
        recorder.define(metric(FITNESS_COMPARISONS, "Number of comparisons of the stochastic rankings in the iteration "
                                                    + "between neighbours, at least one of them infeasible, that the fitness decided."));
        recorder.define(metric(PENALTY_COMPARISONS, "Number of comparisons of the stochastic rankings in the iteration "
                                                    + "between neighbours, at least one of them infeasible, that the penalty decided."));
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

    private void reset() {
        sweeps = 0;
        fitnessComparisons = 0;
        penaltyComparisons = 0;
    }
}

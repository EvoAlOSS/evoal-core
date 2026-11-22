package de.evoal.optimisation.cma_es.main.restart;

import java.util.Optional;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Restarts in two regimes, BIPOP-CMA-ES (DL type {@code 'bipop-restart'}; N. Hansen:
 *   Benchmarking a BI-population CMA-ES on the BBOB-2009 function testbed. GECCO 2009
 *   companion, pp. 2389-2396, doi 10.1145/1570256.1570333). The schedule follows
 *   {@code cma.fmin(..., bipop=True)} of pycma 4.6.0:
 * <ul>
 *   <li>The first run has the population size lambda_default; its evaluations count for the
 *     small regime.</li>
 *   <li>A restart is small while the evaluations of the small regime are fewer than those of
 *     the large regime (at least 1). With u uniformly distributed in [0, 1) and k the number
 *     of runs that were not small restarts, it has the population size
 *     floor(lambda_default * (factor^k)^(u^2)), the step size sigma_0 * 0.01^u (u drawn
 *     anew), and at most ceil(0.5 * (evaluations of the large regime) / lambda)
 *     iterations.</li>
 *   <li>Otherwise the restart is large: lambda_default * factor^k with sigma_0, as IPOP.</li>
 *   <li>The strategy ends when the number of runs that were not small restarts exceeds
 *     'maximum-restarts'.</li>
 * </ul>
 */
@Dependent
@Named("de.evoal.optimisation.cma_es.optimisation.bipop-restart")
public class BipopRestart implements RestartStrategy {
    /**
     * The factor of the population size per large restart.
     */
    private double factor;

    @Inject
    private AttributeHelper helper;

    /**
     * The largest number of large restarts, {@link Integer#MAX_VALUE} for no limit.
     */
    private int maximumRestarts;

    /**
     * Creates a strategy that is configured by {@link #init(EObject)}.
     */
    public BipopRestart() {
    }

    /**
     * Creates a configured strategy, e.g., for tests.
     */
    BipopRestart(final double factor, final int maximumRestarts) {
        this.factor = factor;
        this.maximumRestarts = maximumRestarts;
    }

    @Override
    public RestartStrategy init(final EObject configuration) throws InitializationException {
        factor = helper.<Double>lookup(configuration, "population-factor");
        final EStructuralFeature maximum = configuration.eClass().getEStructuralFeature("maximum-restarts");
        maximumRestarts = maximum != null && configuration.eIsSet(maximum)
                ? helper.<Integer>lookup(configuration, "maximum-restarts")
                : Integer.MAX_VALUE;

        return this;
    }

    @Override
    public boolean restarts() {
        return true;
    }

    @Override
    public RestartSchedule schedule(final int defaultPopulationSize) {
        return new Schedule(defaultPopulationSize);
    }

    /**
     * The BIPOP schedule of one optimisation run.
     */
    private final class Schedule implements RestartSchedule {
        /**
         * The population size of the configuration.
         */
        private final int defaultPopulationSize;

        /**
         * The evaluations of the runs of the large regime.
         */
        private long largeEvaluations;

        /**
         * The regime of the current run.
         */
        private String regime = "small";

        /**
         * The number of runs so far, including the current one.
         */
        private int runs = 1;

        /**
         * The number of small restarts so far (the first run is not one).
         */
        private int smallRestarts;

        /**
         * The evaluations of the runs of the small regime, including the first run.
         */
        private long smallEvaluations;

        private Schedule(final int defaultPopulationSize) {
            this.defaultPopulationSize = defaultPopulationSize;
        }

        @Override
        public RunSetting first() {
            return new RunSetting(defaultPopulationSize, 1.0, Long.MAX_VALUE, "small");
        }

        @Override
        public Optional<RunSetting> next(final long evaluations, final RandomGenerator random) {
            if("small".equals(regime)) {
                smallEvaluations += evaluations;
            } else {
                largeEvaluations += evaluations;
            }

            final int notSmall = runs - smallRestarts;
            if(notSmall > maximumRestarts) {
                return Optional.empty();
            }

            ++runs;
            final boolean small = smallEvaluations < Math.max(1, largeEvaluations);
            if(small) {
                ++smallRestarts;
                regime = "small";

                return Optional.of(smallRun(random));
            }

            regime = "large";
            final double multiplier = EvoalMath.pow(factor, runs - 1 - smallRestarts);
            final int populationSize = (int) (defaultPopulationSize * multiplier);

            return Optional.of(new RunSetting(populationSize, 1.0, Long.MAX_VALUE, regime));
        }

        private RunSetting smallRun(final RandomGenerator random) {
            final double stepSizeExponent = random.nextDouble();
            final double stepSizeFactor = EvoalMath.pow(0.01, stepSizeExponent);

            final double multiplier = EvoalMath.pow(factor, runs - 1 - smallRestarts);
            final double populationExponent = random.nextDouble();
            final double scale = EvoalMath.pow(multiplier, populationExponent * populationExponent);
            final int populationSize = Math.max(2, (int) (defaultPopulationSize * scale));
            // pycma ends the run when the iteration count reaches the (real) limit
            final double limit = 0.5 * largeEvaluations / populationSize;
            final long maximumIterations = Math.max(1L, (long) Math.ceil(limit));

            return new RunSetting(populationSize, stepSizeFactor, maximumIterations, regime);
        }
    }
}

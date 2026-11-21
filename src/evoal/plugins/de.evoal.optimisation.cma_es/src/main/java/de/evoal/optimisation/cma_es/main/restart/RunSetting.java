package de.evoal.optimisation.cma_es.main.restart;

/**
 * The setting of one CMA-ES run of a restart strategy.
 *
 * @param populationSize The population size lambda of the run.
 * @param stepSizeFactor The factor of the initial step size of the configuration.
 * @param maximumIterations The number of iterations after which the run ends at the latest,
 *   {@link Long#MAX_VALUE} for no limit.
 * @param regime The regime of the run, e.g. {@code large} or {@code small} for BIPOP.
 */
public record RunSetting(int populationSize, double stepSizeFactor, long maximumIterations, String regime) {
    /**
     * @param populationSize The population size lambda of the run.
     * @return The setting of a run with the initial step size and no iteration limit.
     */
    public static RunSetting of(final int populationSize) {
        return new RunSetting(populationSize, 1.0, Long.MAX_VALUE, "default");
    }

    /**
     * @param iterations A further limit of the iterations of the run.
     * @return The setting whose iteration limit is the smaller of both limits.
     */
    public RunSetting limitedTo(final long iterations) {
        return new RunSetting(populationSize, stepSizeFactor, Math.min(maximumIterations, iterations), regime);
    }
}

package de.evoal.optimisation.api.evaluation;

import lombok.Getter;

import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

/**
 * The source that produced the value of an evaluation. The {@link EvaluationService}
 *   counts the evaluations of each source in a counter metric of its own.
 */
public enum EvaluationSource {
    /**
     * The real optimisation function, e.g., a benchmark function or a simulation.
     */
    REAL("evaluations.real", "Number of evaluations of the real optimisation function."),

    /**
     * A surrogate model that predicts the values of the real optimisation function.
     */
    SURROGATE("evaluations.surrogate", "Number of predictions of a surrogate model.");

    /**
     * What the counter metric of the source counts.
     */
    @Getter
    private final String description;

    /**
     * The name of the counter metric of the source, e.g., {@code evaluations.real}.
     */
    @Getter
    private final String metricName;

    EvaluationSource(final String metricName, final String description) {
        this.metricName = metricName;
        this.description = description;
    }

    /**
     * @return The name of the metric that holds the budget of the source, e.g.,
     *   {@code evaluations.real.budget}.
     */
    public String getBudgetMetricName() {
        return metricName + ".budget";
    }

    /**
     * @param function An optimisation function.
     * @return The source the function reports ({@link EvaluationSourceProvider}),
     *   {@link #REAL} if it does not report one.
     */
    public static EvaluationSource of(final OptimisationFunction function) {
        if(function instanceof EvaluationSourceProvider provider) {
            return provider.getEvaluationSource();
        }

        return REAL;
    }
}

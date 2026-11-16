package de.evoal.optimisation.api.evaluation;

/**
 * An optimisation function that knows the source of its values. The
 *   {@link EvaluationService} counts the evaluations of a function that does not
 *   implement this interface as {@link EvaluationSource#REAL} evaluations.
 */
public interface EvaluationSourceProvider {
    /**
     * @return The source of the values the function produces.
     */
    EvaluationSource getEvaluationSource();
}

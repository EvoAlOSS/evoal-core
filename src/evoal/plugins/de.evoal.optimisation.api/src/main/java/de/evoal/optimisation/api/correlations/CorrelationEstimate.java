package de.evoal.optimisation.api.correlations;

/**
 * The estimated correlation of two features in a sample.
 *
 * @param kind How the correlation was measured: {@link CorrelationKind#LINEAR} (Pearson) or
 *   {@link CorrelationKind#RANK} (Spearman).
 * @param n The number of value pairs.
 * @param coefficient The correlation coefficient, {@code null} for fewer than two pairs or a
 *   constant feature.
 * @param confidenceLower The lower bound of the confidence interval, {@code null} if there is
 *   no coefficient or at most three pairs.
 * @param confidenceUpper The upper bound of the confidence interval, {@code null} if there is
 *   no coefficient or at most three pairs.
 */
public record CorrelationEstimate(CorrelationKind kind,
                                  int n,
                                  Double coefficient,
                                  Double confidenceLower,
                                  Double confidenceUpper) {
}

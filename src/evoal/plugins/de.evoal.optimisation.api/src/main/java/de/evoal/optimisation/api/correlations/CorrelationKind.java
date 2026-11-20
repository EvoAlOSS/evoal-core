package de.evoal.optimisation.api.correlations;

/**
 * How a {@link Correlation} is measured and transferred, by the scales of measurement of its
 *   two features in the DDL.
 */
public enum CorrelationKind {
    /**
     * Both features are cardinal or quotient (or declare no scale): the Pearson correlation;
     *   a change is transferred as a linear shift.
     */
    LINEAR,

    /**
     * At least one feature is ordinal and none is nominal: the Spearman rank correlation; a
     *   change is transferred as a shift in rank.
     */
    RANK,

    /**
     * At least one feature is nominal: the values have no order, so the coefficient cannot be
     *   measured or transferred; the correlation is skipped.
     */
    NOMINAL
}

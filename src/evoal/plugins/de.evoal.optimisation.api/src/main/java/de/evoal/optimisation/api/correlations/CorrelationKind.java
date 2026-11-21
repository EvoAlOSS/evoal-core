package de.evoal.optimisation.api.correlations;

import de.evoal.languages.model.base.definitions.ScaleType;

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
    NOMINAL;

    /**
     * @param first The scale of the first feature, {@code null} or {@link ScaleType#UNKNOWN}
     *   if it declares none.
     * @param second The scale of the second feature, {@code null} or
     *   {@link ScaleType#UNKNOWN} if it declares none.
     * @return The kind of a correlation of two features with these scales.
     */
    public static CorrelationKind of(final ScaleType first, final ScaleType second) {
        if(first == ScaleType.NOMINAL || second == ScaleType.NOMINAL) {
            return NOMINAL;
        }
        if(first == ScaleType.ORDINAL || second == ScaleType.ORDINAL) {
            return RANK;
        }

        return LINEAR;
    }
}

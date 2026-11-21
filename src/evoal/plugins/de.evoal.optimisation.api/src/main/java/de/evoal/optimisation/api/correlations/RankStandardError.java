package de.evoal.optimisation.api.correlations;

import java.util.Arrays;

/**
 * The variance of Fisher's z-transformation of a Spearman rank correlation, used for its
 *   confidence interval. The Pearson correlation always uses Fisher's variance 1/(n−3).
 */
public enum RankStandardError {
    /**
     * (1 + r²/2)/(n−3), D. G. Bonett, T. A. Wright: Sample size requirements for estimating
     *   Pearson, Kendall and Spearman correlations. Psychometrika 65(1), 2000, pp. 23-28;
     *   more accurate than {@link #FIELLER_HARTLEY_PEARSON} for large coefficients.
     */
    BONETT_WRIGHT("bonett-wright") {
        @Override
        public double variance(final double coefficient, final int n) {
            return (1.0 + coefficient * coefficient / 2.0) / (n - 3);
        }
    },

    /**
     * 1.06/(n−3), E. C. Fieller, H. O. Hartley, E. S. Pearson: Tests for rank correlation
     *   coefficients. I. Biometrika 44(3/4), 1957, pp. 470-481; meant for absolute
     *   coefficients up to 0.8.
     */
    FIELLER_HARTLEY_PEARSON("fieller-hartley-pearson") {
        @Override
        public double variance(final double coefficient, final int n) {
            return 1.06 / (n - 3);
        }
    };

    /**
     * The name of the DL type that selects the method.
     */
    private final String typeName;

    RankStandardError(final String typeName) {
        this.typeName = typeName;
    }

    /**
     * @param typeName The name of a DL type, e.g. {@code bonett-wright}.
     * @return The method of the DL type.
     * @throws IllegalArgumentException if no method has this name.
     */
    public static RankStandardError ofTypeName(final String typeName) {
        return Arrays.stream(values())
                     .filter(method -> method.typeName.equals(typeName))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("'" + typeName + "' is no method for the "
                                                                     + "confidence interval of a rank correlation."));
    }

    /**
     * @return The name of the DL type that selects the method.
     */
    public String typeName() {
        return typeName;
    }

    /**
     * @param coefficient The Spearman rank correlation.
     * @param n The number of value pairs, greater than 3.
     * @return The variance of Fisher's z-transformation of the coefficient.
     */
    public abstract double variance(double coefficient, int n);
}

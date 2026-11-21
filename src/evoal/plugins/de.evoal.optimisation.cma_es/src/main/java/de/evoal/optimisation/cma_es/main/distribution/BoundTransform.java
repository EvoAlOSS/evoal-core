package de.evoal.optimisation.cma_es.main.distribution;

import java.util.Arrays;

/**
 * Maps the unbounded genotype space of the distribution into the bounds of the variables, as
 *   the default boundary handling {@code BoundTransform} of pycma does
 *   ({@code cma.transformations.BoxConstraintsLinQuadTransformation} of pycma 4.6.0 with
 *   the margin {@code max(1, |bound|) / 20}). Per variable with bounds [l, u] and the margins
 *   a_l = min((u - l) / 2, max(1, |l|) / 20), a_u likewise:
 * <ul>
 *   <li>the transformation is the identity in [l + a_l, u - a_u],</li>
 *   <li>quadratic in [l - a_l, l + a_l] and [u - a_u, u + a_u], so its image stays in
 *     [l, u] and it is continuously differentiable,</li>
 *   <li>and periodic with the period 2 (u - l + a_l + a_u) outside: a value is shifted by
 *     whole periods and mirrored at l - a_l or u + a_u first.</li>
 * </ul>
 * An unbounded side has an infinite bound and the margin 1; it is never reached.
 */
public final class BoundTransform {
    /**
     * The lower bounds, -infinity for an unbounded side.
     */
    private final double[] lower;

    /**
     * The margins a_l of the lower bounds.
     */
    private final double[] lowerMargins;

    /**
     * The upper bounds, +infinity for an unbounded side.
     */
    private final double[] upper;

    /**
     * The margins a_u of the upper bounds.
     */
    private final double[] upperMargins;

    /**
     * @param lower The lower bounds, {@link Double#NEGATIVE_INFINITY} for an unbounded side.
     * @param upper The upper bounds, {@link Double#POSITIVE_INFINITY} for an unbounded side.
     * @throws IllegalArgumentException if the lengths differ or a lower bound is not below
     *   its upper bound.
     */
    public BoundTransform(final double[] lower, final double[] upper) {
        if(lower.length != upper.length) {
            throw new IllegalArgumentException("There are " + lower.length + " lower and " + upper.length + " upper bounds.");
        }

        this.lower = lower.clone();
        this.upper = upper.clone();
        this.lowerMargins = new double[lower.length];
        this.upperMargins = new double[lower.length];

        for(int i = 0; i < lower.length; ++i) {
            if(!(lower[i] < upper[i])) {
                throw new IllegalArgumentException("The lower bound " + lower[i] + " of variable " + i
                                                   + " must be below its upper bound " + upper[i] + ".");
            }

            final double halfRange = (upper[i] - lower[i]) / 2.0;
            lowerMargins[i] = Double.isFinite(lower[i]) ? Math.min(halfRange, marginOf(lower[i])) : 1.0;
            upperMargins[i] = Double.isFinite(upper[i]) ? Math.min(halfRange, marginOf(upper[i])) : 1.0;
        }
    }

    /**
     * @param phenotype A point within the bounds.
     * @return The point of the invertible domain [l - a_l, u + a_u] that the transformation
     *   maps to it, as pycma maps its initial point.
     * @throws IllegalArgumentException if a coordinate lies outside its bounds.
     */
    public double[] inverse(final double[] phenotype) {
        final double[] genotype = new double[phenotype.length];
        for(int i = 0; i < phenotype.length; ++i) {
            genotype[i] = inverse(phenotype[i], i);
        }

        return genotype;
    }

    private double inverse(final double value, final int i) {
        final double l = lower[i];
        final double u = upper[i];
        if(value < l || value > u) {
            throw new IllegalArgumentException("The value " + value + " of variable " + i + " lies outside its bounds ["
                                               + l + ", " + u + "].");
        }

        final double marginL = lowerMargins[i];
        final double marginU = upperMargins[i];
        if(value < l + marginL) {
            return l - marginL + 2.0 * Math.sqrt(marginL * (value - l));
        }
        if(value < u - marginU) {
            return value;
        }

        return u + marginU - 2.0 * Math.sqrt(marginU * (u - value));
    }

    /**
     * @return Whether the transformation is the identity for every point, i.e. no variable
     *   has a bound.
     */
    public boolean isIdentity() {
        final boolean noLowerBound = Arrays.stream(lower).allMatch(bound -> bound == Double.NEGATIVE_INFINITY);
        final boolean noUpperBound = Arrays.stream(upper).allMatch(bound -> bound == Double.POSITIVE_INFINITY);

        return noLowerBound && noUpperBound;
    }

    private static double marginOf(final double bound) {
        return Math.max(1.0, Math.abs(bound)) / 20.0;
    }

    /**
     * @param genotype A point of the genotype space.
     * @return Per coordinate the sign of the derivative of the transformation at the point:
     *   -1 if it is mirrored an odd number of times (at l - a_l or u + a_u), otherwise 1. A
     *   correlation of two coordinates of the genotype space has the sign of their product in
     *   the space of the variables.
     */
    public double[] orientation(final double[] genotype) {
        final double[] signs = new double[genotype.length];
        for(int i = 0; i < genotype.length; ++i) {
            signs[i] = orientation(genotype[i], i);
        }

        return signs;
    }

    /**
     * Follows the shift and the mirrors of {@link #transform(double, int)}; the quadratic
     *   parts have a non-negative derivative.
     */
    private double orientation(final double value, final int i) {
        final double l = lower[i];
        final double u = upper[i];
        final double marginL = lowerMargins[i];
        final double marginU = upperMargins[i];
        final double halfRange = (u - l) / 2.0;

        double y = value;
        double sign = 1.0;
        final boolean farBelow = y < l - 2.0 * marginL - halfRange;
        final boolean farAbove = y > u + 2.0 * marginU + halfRange;
        if(farBelow || farAbove) {
            final double period = 2.0 * (u - l + marginL + marginU);
            final double start = l - 2.0 * marginL - halfRange;
            y -= period * Math.floor((y - start) / period);
        }
        if(y > u + marginU) {
            y -= 2.0 * (y - u - marginU);
            sign = -sign;
        }
        if(y < l - marginL) {
            sign = -sign;
        }

        return sign;
    }

    /**
     * @param genotype A point of the genotype space.
     * @return The point within the bounds.
     */
    public double[] transform(final double[] genotype) {
        final double[] phenotype = new double[genotype.length];
        for(int i = 0; i < genotype.length; ++i) {
            phenotype[i] = transform(genotype[i], i);
        }

        return phenotype;
    }

    /**
     * Transforms one coordinate in the order of pycma: shift by whole periods, mirror at the
     *   ends of the invertible domain, then the quadratic parts at the bounds.
     */
    private double transform(final double value, final int i) {
        final double l = lower[i];
        final double u = upper[i];
        final double marginL = lowerMargins[i];
        final double marginU = upperMargins[i];
        final double halfRange = (u - l) / 2.0;

        double y = value;
        final boolean farBelow = y < l - 2.0 * marginL - halfRange;
        final boolean farAbove = y > u + 2.0 * marginU + halfRange;
        if(farBelow || farAbove) {
            final double period = 2.0 * (u - l + marginL + marginU);
            final double start = l - 2.0 * marginL - halfRange;
            y -= period * Math.floor((y - start) / period);
        }
        if(y > u + marginU) {
            y -= 2.0 * (y - u - marginU);
        }
        if(y < l - marginL) {
            y += 2.0 * (l - marginL - y);
        }
        if(y < l + marginL) {
            final double distance = y - (l - marginL);
            y = l + distance * distance / 4.0 / marginL;
        }
        if(y > u - marginU) {
            final double distance = y - (u + marginU);
            y = u - distance * distance / 4.0 / marginU;
        }

        return y;
    }
}

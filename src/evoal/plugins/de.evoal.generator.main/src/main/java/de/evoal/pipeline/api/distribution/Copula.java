package de.evoal.pipeline.api.distribution;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * A copula (DL type {@code copula}): maps a point of the unit cube [0, 1)^k to d dependent
 *   uniform values, one per marginal of a copula distribution.
 */
public interface Copula extends EvoalComponent<Copula> {
    /**
     * Prepares the copula for d marginals. Called once, before the first point.
     *
     * @param dimension The number d of marginals.
     * @throws IllegalArgumentException if the copula's configuration does not fit d marginals.
     */
    void prepare(int dimension);

    /**
     * @return The dimension k of the points the copula needs, known after {@link #prepare(int)}.
     */
    int pointDimension();

    /**
     * Transforms a point.
     *
     * @param point A point of [0, 1)^k.
     * @return d dependent values in [0, 1].
     */
    double [] apply(double [] point);
}

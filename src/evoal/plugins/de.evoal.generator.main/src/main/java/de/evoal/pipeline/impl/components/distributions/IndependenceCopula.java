package de.evoal.pipeline.impl.components.distributions;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.pipeline.api.distribution.Copula;

/**
 * The independence copula (DL type {@code 'independence-copula'}): keeps the point, so the
 *   values are independent (k = d).
 */
@Named(IndependenceCopula.NAME)
@Dependent
public class IndependenceCopula implements Copula {
    /**
     * The CDI name of the copula.
     */
    static final String NAME = "de.evoal.pipeline.distributions.independence-copula";

    /**
     * The number of marginals.
     */
    private int dimension;

    @Override
    public void prepare(final int dimension) {
        this.dimension = dimension;
    }

    @Override
    public int pointDimension() {
        return dimension;
    }

    @Override
    public double [] apply(final double [] point) {
        return point;
    }
}

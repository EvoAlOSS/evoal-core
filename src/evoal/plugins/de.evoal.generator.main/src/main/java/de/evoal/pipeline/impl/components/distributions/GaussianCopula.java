package de.evoal.pipeline.impl.components.distributions;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.Copula;

/**
 * The Gaussian copula (DL type {@code 'gaussian-copula'}) with the correlation matrix R of the
 *   normal scores (k = d): a point u becomes Φ(A·z) with z = Φ⁻¹(u), where A is the symmetric
 *   square root of R (A·Aᵀ = R, computed by {@link CorrelatedGaussianSampler}, which also
 *   accepts a singular R).
 */
@Named(GaussianCopula.NAME)
@Dependent
public class GaussianCopula implements Copula {
    /**
     * The CDI name of the copula.
     */
    static final String NAME = "de.evoal.pipeline.distributions.gaussian-copula";

    /**
     * The largest allowed deviation of a diagonal entry of R from 1.
     */
    private static final double DIAGONAL_TOLERANCE = 1e-12;

    /**
     * The correlation matrix R.
     */
    private double [][] correlation;

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * Correlates the normal scores.
     */
    private CorrelatedGaussianSampler sampler;

    /**
     * Creates a copula that is configured by {@link #init(EObject)}.
     */
    public GaussianCopula() {
    }

    /**
     * Creates a copula with the given correlation matrix, e.g., for tests. It is checked by
     *   {@link #prepare(int)}.
     */
    GaussianCopula(final double @NonNull [][] correlation) {
        this.correlation = correlation;
    }

    @Override
    public GaussianCopula init(final EObject configuration) {
        correlation = evaluator.attributeToDoubleArrayArray(configuration, "correlation");

        return this;
    }

    /**
     * @throws IllegalArgumentException if R is not a d × d correlation matrix: square, with ones
     *   on the diagonal, symmetric and positive semi-definite.
     */
    @Override
    public void prepare(final int dimension) {
        Requirements.requireTrue(correlation.length == dimension,
                "The correlation matrix of the Gaussian copula has " + correlation.length + " rows, but there are "
                + dimension + " marginals.");

        for(int i = 0; i < dimension; ++i) {
            Requirements.requireTrue(correlation[i].length == dimension,
                    "Row " + i + " of the correlation matrix of the Gaussian copula has " + correlation[i].length
                    + " columns, but there are " + dimension + " marginals.");
            Requirements.requireTrue(Math.abs(correlation[i][i] - 1.0) <= DIAGONAL_TOLERANCE,
                    "The diagonal of the correlation matrix of the Gaussian copula has to be 1, but entry " + i
                    + " is " + correlation[i][i] + ".");
        }

        sampler = new CorrelatedGaussianSampler(new double[dimension], correlation, "correlation matrix of the Gaussian copula");
    }

    @Override
    public int pointDimension() {
        return correlation.length;
    }

    @Override
    public double [] apply(final double [] point) {
        final double [] scores = new double[point.length];

        for(int j = 0; j < point.length; ++j) {
            scores[j] = StandardNormal.quantile(point[j]);
        }

        final double [] correlated = sampler.transform(scores);

        for(int j = 0; j < correlated.length; ++j) {
            correlated[j] = StandardNormal.cdf(correlated[j]);
        }

        return correlated;
    }
}

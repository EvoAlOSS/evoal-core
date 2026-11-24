package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.Requirements;

/**
 * Univariate Gaussian mixture: with probability wᵢ, the value comes from N(μᵢ, σᵢ²). The
 *   distribution function is F(x) = Σ wᵢ·Φ((x − μᵢ)/σᵢ).
 * <p>
 * The quantile has no closed form. Brent's method finds it in
 *   [min(μᵢ − 40σᵢ), max(μᵢ + 40σᵢ)], where F is 0 and 1 in double precision. Below the
 *   median, it solves F(x) = p; above, S(x) = 1 − p with the survival function
 *   S(x) = Σ wᵢ·Φ((μᵢ − x)/σᵢ), so small tail probabilities keep their precision.
 */
@Named(GaussianMixtureDistribution.NAME)
@Dependent
public class GaussianMixtureDistribution extends InversionDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.gaussian-mixture-distribution";

    /**
     * How far the sum of the weights may differ from 1.
     */
    static final double SUM_TOLERANCE = 1e-9;

    /**
     * The number of standard deviations beyond which a component has no probability in double
     *   precision.
     */
    private static final double TAIL = 40.0;

    /**
     * The maximum number of evaluations of Brent's method.
     */
    private static final int MAX_EVALUATIONS = 1000;

    /**
     * The lower end of the search interval.
     */
    private double lower;

    /**
     * The means of the components.
     */
    private double [] μ;

    /**
     * The standard deviations of the components.
     */
    private double [] σ;

    /**
     * Finds the quantile; its absolute accuracy is 1e-12 of the largest standard deviation.
     */
    private BrentSolver solver;

    /**
     * The upper end of the search interval.
     */
    private double upper;

    /**
     * The weights of the components, divided by their sum.
     */
    private double [] weights;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public GaussianMixtureDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if the arrays are empty or differ in length, a weight is
     *   negative, the weights do not sum to 1, or a standard deviation is not positive.
     */
    GaussianMixtureDistribution(final double [] weights, final double [] μ, final double [] σ, final RandomGenerator randomness) {
        super(randomness);
        configure(weights, μ, σ);
    }

    @Override
    protected void configure(final EObject configuration) {
        configure(toArray(lookup(configuration, "weights")), toArray(lookup(configuration, "μ")),
                  toArray(lookup(configuration, "σ")));
    }

    private static double [] toArray(final List<Number> values) {
        return values.stream().mapToDouble(Number::doubleValue).toArray();
    }

    private void configure(final double [] weights, final double [] μ, final double [] σ) {
        Requirements.requireTrue(weights.length > 0, "The Gaussian mixture needs at least one component.");
        Requirements.requireTrue(weights.length == μ.length && weights.length == σ.length,
                "The Gaussian mixture has " + weights.length + " weights, " + μ.length + " means and " + σ.length
                + " standard deviations; it needs one of each per component.");
        Requirements.requireTrue(Arrays.stream(weights).allMatch(w -> w >= 0.0),
                "The weights of the Gaussian mixture have to be non-negative, but are " + Arrays.toString(weights) + ".");
        Requirements.requireTrue(Arrays.stream(σ).allMatch(s -> s > 0.0),
                "The standard deviations of the Gaussian mixture have to be positive, but are " + Arrays.toString(σ) + ".");

        final double sum = Arrays.stream(weights).sum();
        Requirements.requireTrue(Math.abs(sum - 1.0) <= SUM_TOLERANCE,
                "The weights of the Gaussian mixture have to sum to 1, but sum to " + sum + ".");

        this.weights = Arrays.stream(weights).map(w -> w / sum).toArray();
        this.μ = μ.clone();
        this.σ = σ.clone();

        lower = Double.POSITIVE_INFINITY;
        upper = Double.NEGATIVE_INFINITY;
        for(int i = 0; i < μ.length; ++i) {
            lower = Math.min(lower, μ[i] - TAIL * σ[i]);
            upper = Math.max(upper, μ[i] + TAIL * σ[i]);
        }

        final double scale = Arrays.stream(σ).max().orElseThrow();
        solver = new BrentSolver(1e-15, 1e-12 * scale, 0.0);
    }

    @Override
    protected String name() {
        return NAME;
    }

    /**
     * @return F(x).
     */
    double cdf(final double x) {
        double result = 0.0;
        for(int i = 0; i < weights.length; ++i) {
            result += weights[i] * StandardNormal.cdf((x - μ[i]) / σ[i]);
        }

        return result;
    }

    /**
     * @return 1 − F(x), computed without the subtraction.
     */
    private double survival(final double x) {
        double result = 0.0;
        for(int i = 0; i < weights.length; ++i) {
            result += weights[i] * StandardNormal.cdf((μ[i] - x) / σ[i]);
        }

        return result;
    }

    @Override
    public double quantile(final double p) {
        if(p <= 0.0) {
            return Double.NEGATIVE_INFINITY;
        }
        if(p >= 1.0) {
            return Double.POSITIVE_INFINITY;
        }

        if(p <= 0.5) {
            return solver.solve(MAX_EVALUATIONS, x -> cdf(x) - p, lower, upper);
        }

        final double q = 1.0 - p;
        return solver.solve(MAX_EVALUATIONS, x -> q - survival(x), lower, upper);
    }
}

package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.math.EvoalMath;

/**
 * Weibull distribution with shape {@code k} and scale {@code λ}:
 *   F(x) = 1 − exp(−(x/λ)^k) for x ≥ 0. The quantile is F⁻¹(p) = λ·(−ln(1 − p))^(1/k).
 */
@Named(WeibullDistribution.NAME)
@Dependent
public class WeibullDistribution extends InversionDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.weibull-distribution";

    /**
     * The shape, positive.
     */
    private double k;

    /**
     * The scale, positive.
     */
    private double λ;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public WeibullDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     */
    WeibullDistribution(final double k, final double λ, final RandomGenerator randomness) {
        super(randomness);
        this.k = k;
        this.λ = λ;
    }

    @Override
    protected void configure(final EObject configuration) {
        k = lookup(configuration, "k");
        λ = lookup(configuration, "λ");
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    public double quantile(final double p) {
        return λ * EvoalMath.pow(-EvoalMath.log1p(-p), 1.0 / k);
    }
}

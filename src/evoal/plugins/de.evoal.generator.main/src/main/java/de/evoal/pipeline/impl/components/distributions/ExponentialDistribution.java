package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.math.EvoalMath;

/**
 * Exponential distribution with rate {@code λ}: F(x) = 1 − exp(−λx) for x ≥ 0, mean 1/λ. The
 *   quantile is F⁻¹(p) = −ln(1 − p)/λ.
 */
@Named(ExponentialDistribution.NAME)
@Dependent
public class ExponentialDistribution extends InversionDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.exponential-distribution";

    /**
     * The rate, positive.
     */
    private double λ;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public ExponentialDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     */
    ExponentialDistribution(final double λ, final RandomGenerator randomness) {
        super(randomness);
        this.λ = λ;
    }

    @Override
    protected void configure(final EObject configuration) {
        λ = lookup(configuration, "λ");
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    public double quantile(final double p) {
        return -EvoalMath.log1p(-p) / λ;
    }
}

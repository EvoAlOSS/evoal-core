package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

/**
 * Triangular distribution with minimum {@code a}, mode {@code c} and maximum {@code b}: the
 *   density rises linearly from a to c and falls linearly from c to b. The quantile is
 *   a + √(p(b − a)(c − a)) for p &lt; (c − a)/(b − a), and b − √((1 − p)(b − a)(b − c))
 *   otherwise.
 */
@Named(TriangularDistribution.NAME)
@Dependent
public class TriangularDistribution extends InversionDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.triangular-distribution";

    /**
     * The minimum.
     */
    private double a;

    /**
     * The maximum.
     */
    private double b;

    /**
     * The mode.
     */
    private double c;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public TriangularDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     */
    TriangularDistribution(final double a, final double c, final double b, final RandomGenerator randomness) {
        super(randomness);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    protected void configure(final EObject configuration) {
        a = lookup(configuration, "a");
        b = lookup(configuration, "b");
        c = lookup(configuration, "c");
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    public double quantile(final double p) {
        final double width = b - a;
        if(p * width < c - a) {
            return a + Math.sqrt(p * width * (c - a));
        }

        return b - Math.sqrt((1.0 - p) * width * (b - c));
    }
}

package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.apache.commons.math3.random.SobolSequenceGenerator;

import de.evoal.pipeline.api.distribution.Randomisation;

/**
 * Sobol' sequence (DL type {@code 'sobol-sequence'}, Sobol' 1967) with the direction numbers of
 *   Joe and Kuo (2008), as shipped with Commons Math ({@link SobolSequenceGenerator}, up to 1000
 *   dimensions). The first point is the origin of the unit cube; it is kept. It supports
 *   {@link NoRandomisation} and {@link RandomShift}.
 */
@Named(SobolSequence.NAME)
@Dependent
public class SobolSequence extends LowDiscrepancySequence {
    /**
     * The CDI name of the sequence.
     */
    static final String NAME = "de.evoal.pipeline.distributions.sobol-sequence";

    /**
     * The largest dimension of the direction numbers of Commons Math.
     */
    static final int MAXIMUM_DIMENSION = 1000;

    /**
     * The generator of the points.
     */
    private SobolSequenceGenerator generator;

    /**
     * Creates a sequence that is configured by {@link #init(org.eclipse.emf.ecore.EObject)}.
     */
    public SobolSequence() {
    }

    /**
     * Creates a configured sequence, e.g., for tests.
     *
     * @throws IllegalArgumentException if the configuration is invalid (see
     *   {@link #configure(double[], double[], Randomisation, RandomGenerator)}).
     */
    SobolSequence(final double [] lower, final double [] upper, final Randomisation randomisation, final RandomGenerator randomness) {
        configure(lower, upper, randomisation, randomness);
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    protected String typeName() {
        return "Sobol' sequence";
    }

    @Override
    protected int maximumDimension() {
        return MAXIMUM_DIMENSION;
    }

    @Override
    protected void start(final int dimension) {
        generator = new SobolSequenceGenerator(dimension);
    }

    @Override
    protected double [] next() {
        return generator.nextVector();
    }

    @Override
    protected boolean supports(final Randomisation randomisation) {
        return randomisation instanceof NoRandomisation || randomisation instanceof RandomShift;
    }
}

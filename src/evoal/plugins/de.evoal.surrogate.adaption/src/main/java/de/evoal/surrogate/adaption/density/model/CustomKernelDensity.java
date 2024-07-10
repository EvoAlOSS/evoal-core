package de.evoal.surrogate.adaption.density.model;

import smile.math.MathEx;
import smile.stat.distribution.GaussianDistribution;

import java.util.Arrays;

public class CustomKernelDensity {
    private static final long serialVersionUID = 2L;

    /**
     * The kernel -- a symmetric but not necessarily positive function that
     * integrates to one. Here we just Gaussian density function.
     */
    private final GaussianDistribution gaussian;

    /**
     * Constructor. The bandwidth of kernel will be estimated by the rule of thumb.
     * @param x the samples to estimate the density function.
     */
    public CustomKernelDensity(final GaussianDistribution distribution) {
        gaussian = distribution;
    }

    public double p(double x) {
        return gaussian.logp(x);
    }
}


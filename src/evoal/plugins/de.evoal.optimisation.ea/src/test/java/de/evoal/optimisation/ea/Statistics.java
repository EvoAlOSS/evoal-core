package de.evoal.optimisation.ea;

import org.junit.jupiter.api.Assertions;

/**
 * The statistical acceptance of the operators and selections: observed frequencies lie within
 *   +-4 standard deviations of the binomial expectation. With p = 0 or p = 1, the frequency
 *   must be exact.
 */
public final class Statistics {
    private Statistics() {
    }

    /**
     * @param observed The observed number of successes.
     * @param trials The number of trials.
     * @param p The probability of a success.
     * @param what What is counted, for the message.
     */
    public static void assertBinomial(final long observed, final long trials, final double p, final String what) {
        final double expected = trials * p;
        final double sigma = Math.sqrt(trials * p * (1.0 - p));

        Assertions.assertTrue(Math.abs(observed - expected) <= 4.0 * sigma,
                              what + ": observed " + observed + " of " + trials + ", expected " + expected + " +- " + 4.0 * sigma);
    }
}

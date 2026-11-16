package de.evoal.core.api.math;

import net.jafama.StrictFastMath;

/**
 * Mathematical functions that give the same result on every platform, so a
 *   run with a given seed produces the same output on every machine.
 *
 * The functions of {@link java.lang.Math} may differ in the last bit between
 *   platforms, which can change a comparison or an acceptance decision of a
 *   search. Therefore, EvoAl calls these functions only through this class (the
 *   build checks this with forbiddenapis, see {@code src/evoal/pom.xml}).
 *
 * The implementations are pure Java, so their results do not depend on the
 *   platform:
 * <ul>
 *   <li>{@link #cos}, {@link #exp}, and {@link #log} use Jafama's
 *     {@link StrictFastMath}, which is two to six times faster than
 *     {@link StrictMath}. The result differs from the exact one by at most
 *     4 ulp ({@code exp}), 1 ulp ({@code log}), or 6e-16 ({@code cos}).</li>
 *   <li>{@link #pow} uses {@link StrictMath}, because the Jafama version is
 *     not exact for integer powers, e.g., it returns 399.9999999999999 for
 *     20².</li>
 * </ul>
 *
 * Squares are cheaper and exact as {@code x * x}.
 */
public final class EvoalMath {
    private EvoalMath() {
    }

    /**
     * @return the cosine of {@code x} (in radians).
     */
    public static double cos(final double x) {
        return StrictFastMath.cos(x);
    }

    /**
     * @return e raised to the power of {@code x}.
     */
    public static double exp(final double x) {
        return StrictFastMath.exp(x);
    }

    /**
     * @return the natural logarithm of {@code x}.
     */
    public static double log(final double x) {
        return StrictFastMath.log(x);
    }

    /**
     * @return {@code base} raised to the power of {@code exponent}.
     */
    @SuppressForbidden
    public static double pow(final double base, final double exponent) {
        return StrictMath.pow(base, exponent);
    }
}

package de.evoal.optimisation.api.correlations;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A correlation between two search features, declared in the DDL by
 *   {@code correlation(data f, data g, rho)} or
 *   {@code 'ranged-correlation'(data f, range(l, u), data g, range(l, u), rho)}. A ranged
 *   correlation applies only while both features lie in their ranges.
 *
 * @param number The position of the correlation in the DDL, from 1.
 * @param first The first feature.
 * @param second The second feature, not the first one.
 * @param coefficient The correlation coefficient rho, in [-1, 1].
 * @param firstRange The range of the first feature, {@code null} if the correlation is not
 *   ranged.
 * @param secondRange The range of the second feature, {@code null} if the correlation is not
 *   ranged.
 * @param kind How the correlation is measured and transferred.
 */
public record Correlation(int number,
                          EStructuralFeature first,
                          EStructuralFeature second,
                          double coefficient,
                          CorrelationRange firstRange,
                          CorrelationRange secondRange,
                          CorrelationKind kind) {
    /**
     * @throws IllegalArgumentException if both features are the same, the coefficient lies
     *   outside [-1, 1], or only one range is given.
     */
    public Correlation {
        Objects.requireNonNull(first, "first");
        Objects.requireNonNull(second, "second");
        Objects.requireNonNull(kind, "kind");

        if(first == second) {
            throw new IllegalArgumentException("The feature '" + first.getName() + "' cannot be correlated with itself.");
        }
        // also rejects NaN
        if(!(-1.0 <= coefficient && coefficient <= 1.0)) {
            throw new IllegalArgumentException("The correlation coefficient of '" + first.getName() + "' and '"
                                               + second.getName() + "' must lie in [-1, 1], but is " + coefficient + ".");
        }
        if((firstRange == null) != (secondRange == null)) {
            throw new IllegalArgumentException("A ranged correlation needs a range for both features.");
        }
    }

    /**
     * @param firstValue A value of the first feature.
     * @param secondValue A value of the second feature.
     * @return Whether the correlation applies to the values: always for a correlation without
     *   ranges, otherwise if both values lie in their ranges.
     */
    public boolean appliesTo(final double firstValue, final double secondValue) {
        return !isRanged() || firstRange.contains(firstValue) && secondRange.contains(secondValue);
    }

    /**
     * @return Whether the correlation applies only in ranges.
     */
    public boolean isRanged() {
        return firstRange != null;
    }

    /**
     * @param feature A feature of the correlation.
     * @return The other feature, empty if the feature does not belong to the correlation.
     */
    public Optional<EStructuralFeature> partnerOf(final EStructuralFeature feature) {
        if(feature == first) {
            return Optional.of(second);
        }
        if(feature == second) {
            return Optional.of(first);
        }

        return Optional.empty();
    }

    /**
     * @param feature A feature of the correlation.
     * @return The range of the feature, {@code null} if the correlation is not ranged.
     */
    public CorrelationRange rangeOf(final EStructuralFeature feature) {
        return feature == first ? firstRange : secondRange;
    }

    @Override
    public String toString() {
        final String ranges = isRanged() ? " in " + firstRange + " x " + secondRange : "";

        return "correlation " + number + " of '" + first.getName() + "' and '" + second.getName() + "' (" + coefficient
               + ranges + ")";
    }
}

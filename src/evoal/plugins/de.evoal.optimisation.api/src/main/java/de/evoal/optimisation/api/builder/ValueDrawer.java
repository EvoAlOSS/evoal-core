package de.evoal.optimisation.api.builder;

import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

import lombok.NonNull;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;

/**
 * Draws a random value for an attribute: a real number uniformly within its boundaries, an
 *   integer uniformly among the integers within its boundaries, a boolean and an enum literal
 *   uniformly. A side without boundary uses the range of the attribute's type. The draws are the
 *   ones the random population made for tabular search spaces before models were supported, so
 *   the same seed gives the same tabular candidates.
 */
public final class ValueDrawer {
    /**
     * The boundaries of the numeric attributes.
     */
    private final FeatureBoundaries boundaries;

    /**
     * @param boundaries The boundaries of the numeric attributes.
     */
    public ValueDrawer(final @NonNull FeatureBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    /**
     * @return Why no value can be drawn for the attribute, or empty if one can: its type is no
     *   boolean, int, real or enum, or an integer attribute has no integer within its boundaries.
     */
    public Optional<String> problemOf(final @NonNull EAttribute attribute) {
        final EClassifier type = attribute.getEType();
        final boolean isDrawable = EClassifierHelper.isBoolean(type)
                                   || EClassifierHelper.isDouble(type)
                                   || EClassifierHelper.isInteger(type)
                                   || type instanceof EEnum;
        if(!isDrawable) {
            return Optional.of("'" + attribute.getName() + "' has the type " + type.getName() + ", for which no random value can be drawn");
        }

        if(type instanceof EEnum eEnum && eEnum.getELiterals().isEmpty()) {
            return Optional.of("'" + attribute.getName() + "' has an enum without literals");
        }

        if(EClassifierHelper.isInteger(type)) {
            final FeatureBoundaries.Boundaries bounds = boundaries.get(attribute);
            final long lower = lowestInteger(bounds);
            final long upper = highestInteger(bounds);
            if(lower > upper) {
                return Optional.of("'" + attribute.getName() + "' has no valid value");
            }
        }

        return Optional.empty();
    }

    /**
     * Draws a value for the attribute. The attribute has to pass {@link #problemOf}.
     *
     * @param attribute The attribute.
     * @param randomness The source of the random numbers.
     * @return The value, of the Java type of the attribute.
     */
    public Object draw(final @NonNull EAttribute attribute, final @NonNull RandomGenerator randomness) {
        final EClassifier type = attribute.getEType();

        if(EClassifierHelper.isBoolean(type)) {
            return randomness.nextBoolean();
        }

        if(type instanceof EEnum eEnum) {
            return drawLiteral(eEnum, randomness);
        }

        final FeatureBoundaries.Boundaries bounds = boundaries.get(attribute);

        if(EClassifierHelper.isDouble(type)) {
            final double lower = bounds.lower().doubleValue();
            final double upper = bounds.upper().doubleValue();

            // interpolation does not overflow, even for the full range of double
            final double ratio = randomness.nextDouble();

            return ratio * upper + (1.0 - ratio) * lower;
        }

        // integer: the bounds are within the int range, so long arithmetic cannot overflow
        final long lower = lowestInteger(bounds);
        final long upper = highestInteger(bounds);

        return (int) randomness.nextLong(lower, upper + 1);
    }

    private static Object drawLiteral(final EEnum eEnum, final RandomGenerator randomness) {
        final List<EEnumLiteral> literals = eEnum.getELiterals();
        final int index = randomness.nextInt(literals.size());

        return literals.get(index).getInstance();
    }

    private static long highestInteger(final FeatureBoundaries.Boundaries bounds) {
        final long upper = bounds.upper().longValue();

        return bounds.UpperIncluded() ? upper : upper - 1;
    }

    private static long lowestInteger(final FeatureBoundaries.Boundaries bounds) {
        final long lower = bounds.lower().longValue();

        return bounds.lowerIncluded() ? lower : lower + 1;
    }
}

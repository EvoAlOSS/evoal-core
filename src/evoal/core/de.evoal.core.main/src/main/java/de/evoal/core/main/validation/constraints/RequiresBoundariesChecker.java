package de.evoal.core.main.validation.constraints;

import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.info.BoundaryExtractor;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Checks {@code @RequiresBoundaries}: every selected data has a lower and/or an upper boundary
 *   ({@code @LowerBoundary}, {@code @UpperBoundary} of the data or of its type, see
 *   {@link BoundaryExtractor}). The range of the representation does not count, except for
 *   boolean data, which is always bounded. Structured data (a model) meets every
 *   requirement: its attributes have their own boundaries, which the components that change
 *   them check.
 */
@Dependent
@Named("de.evoal.core.constraints.RequiresBoundaries")
public class RequiresBoundariesChecker extends FeatureRequirementChecker {
    /**
     * Whether the data needs a lower boundary.
     */
    private boolean lower;

    /**
     * Whether the data needs an upper boundary.
     */
    private boolean upper;

    public RequiresBoundariesChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    RequiresBoundariesChecker(final String features, final boolean lower, final boolean upper) {
        super(features);
        this.lower = lower;
        this.upper = upper;
    }

    private static boolean booleanOf(final EObject config, final String name) {
        final EStructuralFeature feature = config.eClass().getEStructuralFeature(name);

        return feature != null && Boolean.TRUE.equals(config.eGet(feature));
    }

    @Override
    protected void configure(final EObject config) throws InitializationException {
        lower = booleanOf(config, "lower");
        upper = booleanOf(config, "upper");
    }

    /**
     * @return The boundaries, e.g. "a lower and an upper boundary".
     */
    private static String describe(final boolean withLower, final boolean withUpper) {
        if(withLower && withUpper) {
            return "a lower and an upper boundary";
        }

        return withLower ? "a lower boundary" : "an upper boundary";
    }

    /**
     * @return The missing boundaries, e.g. "no upper boundary".
     */
    private static String missing(final boolean missesLower, final boolean missesUpper) {
        if(missesLower && missesUpper) {
            return "neither a lower nor an upper boundary";
        }

        return missesLower ? "no lower boundary" : "no upper boundary";
    }

    @Override
    protected Optional<String> problemOf(final DataDescription data) {
        // a model has no boundaries itself; its attributes have their own, which the components
        // that change them check
        if(data instanceof StructuredDataDescription) {
            return Optional.empty();
        }

        // boolean data has only two values, false and true
        if(data instanceof BaseDataDescription base && base.getRepresentation() == RepresentationType.BOOLEAN) {
            return Optional.empty();
        }

        final BoundaryExtractor.Extracted boundaries;
        try {
            boundaries = BoundaryExtractor.extract(data);
        } catch(final IllegalStateException e) {
            return Optional.of("needs " + describe(lower, upper) + " for its data, but " + e.getMessage());
        }

        final boolean missesLower = lower && boundaries.lower().isEmpty();
        final boolean missesUpper = upper && boundaries.upper().isEmpty();
        if(!missesLower && !missesUpper) {
            return Optional.empty();
        }

        final String required = describe(lower, upper);
        final String missing = missing(missesLower, missesUpper);

        return Optional.of("needs " + required + " for its data, but '" + data.getName() + "' has " + missing);
    }
}

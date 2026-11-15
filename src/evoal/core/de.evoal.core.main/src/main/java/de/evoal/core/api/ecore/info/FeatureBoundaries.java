package de.evoal.core.api.ecore.info;

import java.util.*;

import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

@ApplicationScoped
public class FeatureBoundaries {
    /**
     * Boundaries of a numeric feature.
     *
     * @param lower The lower bound (might be empty)
     * @param upper The upper bound (might be empty)
     */
    public record Boundaries(Number lower, boolean lowerIncluded, Number upper, boolean UpperIncluded) {}

    /**
     * Source of the annotation that stores the boundaries of a feature. Its details are
     *   {@link #LOWER}, {@link #LOWER_INCLUSIVE}, {@link #UPPER}, and {@link #UPPER_INCLUSIVE}.
     *   Only the bounded sides are present. The values are stored as literals of the
     *   feature's type.
     */
    public static final String BOUNDARIES_SOURCE = "https://evoal.de/v202704/models/core/boundaries";

    public static final String LOWER = "lower";
    public static final String LOWER_INCLUSIVE = "lowerInclusive";
    public static final String UPPER = "upper";
    public static final String UPPER_INCLUSIVE = "upperInclusive";

    /**
     * Cache for boundaries.
     */
    private final Map<EStructuralFeature, Boundaries> cache = new HashMap<>();

    public void add(final EStructuralFeature specification, final Boundaries boundaries) {
        cache.put(specification, boundaries);
    }

    public boolean contains(final EStructuralFeature specification) { return cache.containsKey(specification); }

    /**
     * Returns the boundaries of the feature. They are read from the feature's boundary
     *   annotation (see {@link #annotate}). A side without boundary uses the range of the
     *   feature's type.
     */
    public Boundaries get(final EStructuralFeature feature) {
        return cache.computeIfAbsent(feature, FeatureBoundaries::fromAnnotation);
    }

    /**
     * Attaches the extracted boundaries to the feature. The bounds are converted to the type
     *   of the feature without loss (e.g., a bound of 0.5 for an integer feature is rejected).
     *
     * @throws IllegalStateException if the boundaries cannot be represented by the feature's type.
     */
    public static void annotate(final EStructuralFeature feature, final BoundaryExtractor.Extracted boundaries) {
        if(boundaries.isEmpty()) {
            return;
        }

        if(!NumericConversions.isNumeric(feature.getEType())) {
            throw new IllegalStateException("Boundaries are only supported for numeric data, but data '" + feature.getName() + "' is of type " + feature.getEType().getName() + ".");
        }

        final EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource(BOUNDARIES_SOURCE);

        boundaries.lower().ifPresent(b -> {
            annotation.getDetails().put(LOWER, toLiteral(feature, b.value()));
            annotation.getDetails().put(LOWER_INCLUSIVE, Boolean.toString(b.inclusive()));
        });
        boundaries.upper().ifPresent(b -> {
            annotation.getDetails().put(UPPER, toLiteral(feature, b.value()));
            annotation.getDetails().put(UPPER_INCLUSIVE, Boolean.toString(b.inclusive()));
        });

        feature.getEAnnotations().add(annotation);
    }

    private static String toLiteral(final EStructuralFeature feature, final double value) {
        final EDataType type = (EDataType) feature.getEType();
        try {
            return EcoreUtil.convertToString(type, NumericConversions.toType(value, type));
        } catch(final IllegalArgumentException e) {
            throw new IllegalStateException("Invalid boundary for data '" + feature.getName() + "': " + e.getMessage(), e);
        }
    }

    private static Boundaries fromAnnotation(final EStructuralFeature feature) {
        final Boundaries defaults = createBoundaries(feature);
        final EAnnotation annotation = feature.getEAnnotation(BOUNDARIES_SOURCE);
        if(annotation == null) {
            return defaults;
        }

        final EDataType type = (EDataType) feature.getEType();
        final Map<String, String> details = annotation.getDetails().map();

        Number lower = defaults.lower();
        boolean lowerIncluded = defaults.lowerIncluded();
        if(details.containsKey(LOWER)) {
            lower = (Number) EcoreUtil.createFromString(type, details.get(LOWER));
            lowerIncluded = Boolean.parseBoolean(details.get(LOWER_INCLUSIVE));
        }

        Number upper = defaults.upper();
        boolean upperIncluded = defaults.UpperIncluded();
        if(details.containsKey(UPPER)) {
            upper = (Number) EcoreUtil.createFromString(type, details.get(UPPER));
            upperIncluded = Boolean.parseBoolean(details.get(UPPER_INCLUSIVE));
        }

        return new Boundaries(lower, lowerIncluded, upper, upperIncluded);
    }

    private static Boundaries createBoundaries(final EStructuralFeature feature) {
        final EClassifier type = feature.getEType();

        if(EClassifierHelper.isLong(type)) {
            return new Boundaries(Long.MIN_VALUE, true, Long.MAX_VALUE, true);
        } else if(EClassifierHelper.isInteger(type)) {
            return new Boundaries(Integer.MIN_VALUE, true, Integer.MAX_VALUE, true);
        } else if(EClassifierHelper.isShort(type)) {
            return new Boundaries(Short.MIN_VALUE, true, Short.MAX_VALUE, true);
        } else if(EClassifierHelper.isByte(type)) {
            return new Boundaries(Byte.MIN_VALUE, true, Byte.MAX_VALUE, true);
        } else if(EClassifierHelper.isDouble(type)) {
            return new Boundaries(-Double.MAX_VALUE, true, Double.MAX_VALUE, true);
        } else if(EClassifierHelper.isFloat(type)) {
            return new Boundaries(-Float.MAX_VALUE, true, Float.MAX_VALUE, true);
        } else {
            throw new IllegalStateException("Unsupported type " + feature.getEType().getName());
        }
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("FeatureBoundaries [");
        for(final Map.Entry<EStructuralFeature, Boundaries> entry : cache.entrySet()) {
            builder.append(entry.getValue().lower);
            builder.append(" < ");
            builder.append(entry.getKey().getName());
            builder.append(" < ");
            builder.append(entry.getValue().upper);
            builder.append(", ");
        }

        builder.append("]");

        return builder.toString();
    }
}

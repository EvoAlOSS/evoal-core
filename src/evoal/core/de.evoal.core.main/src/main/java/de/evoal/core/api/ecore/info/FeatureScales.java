package de.evoal.core.api.ecore.info;

import lombok.NonNull;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

import de.evoal.languages.model.base.definitions.ScaleType;

/**
 * The scale of measurement of a feature: of the data description for a feature of a space,
 *   of the {@code @Scale} annotation (or the scale of its enum) for an attribute of a DL type.
 *   The scale is stored in an annotation of the feature when the feature is created
 *   ({@link #annotate}). A feature without the annotation is nominal, the weakest scale, as
 *   DDL data without a scale.
 */
public final class FeatureScales {
    /**
     * Detail key of the {@link #SCALE_SOURCE} annotation that contains the literal of the scale.
     */
    public static final String SCALE = "scale";

    /**
     * Source of the annotation that stores the scale of a feature.
     */
    public static final String SCALE_SOURCE = "https://evoal.de/v202704/models/core/scale";

    private FeatureScales() {
    }

    /**
     * Stores the scale in an annotation of the feature. {@link ScaleType#UNKNOWN} is stored as
     *   nominal.
     *
     * @param feature The feature.
     * @param scale The scale of the feature.
     */
    public static void annotate(final @NonNull EStructuralFeature feature, final @NonNull ScaleType scale) {
        final ScaleType known = scale == ScaleType.UNKNOWN ? ScaleType.NOMINAL : scale;

        final EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource(SCALE_SOURCE);
        annotation.getDetails().put(SCALE, known.getLiteral());

        feature.getEAnnotations().add(annotation);
    }

    /**
     * @return The scale of the feature; nominal if the feature has no scale annotation.
     */
    public static ScaleType scaleOf(final @NonNull EStructuralFeature feature) {
        final EAnnotation annotation = feature.getEAnnotation(SCALE_SOURCE);
        if(annotation == null) {
            return ScaleType.NOMINAL;
        }

        final String literal = annotation.getDetails().get(SCALE);
        final ScaleType scale = ScaleType.get(literal);

        return scale == null ? ScaleType.NOMINAL : scale;
    }
}

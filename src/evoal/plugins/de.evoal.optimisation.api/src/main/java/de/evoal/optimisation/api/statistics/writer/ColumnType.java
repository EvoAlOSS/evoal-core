package de.evoal.optimisation.api.statistics.writer;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.misc.EClassifierHelper;

/**
 * Possible column types.
 */
public enum ColumnType {
    Boolean,
    Double,
    Enum,
    Integer,
    String;

    /**
     * @param feature A feature of the search or optimisation space.
     * @return The column type matching the Ecore type of the feature.
     * @throws IllegalArgumentException if the feature has an unsupported type.
     */
    public static ColumnType of(final EStructuralFeature feature) {
        final EClassifier type = feature.getEType();

        if(EClassifierHelper.isReal(type)) {
            return Double;
        } else if(EClassifierHelper.isLongOrShorter(type)) {
            return Integer;
        } else if(EClassifierHelper.isBoolean(type)) {
            return Boolean;
        } else if(EClassifierHelper.isString(type)) {
            return String;
        }

        throw new IllegalArgumentException("Unsupported EStructuralFeature " + feature.getName());
    }
}

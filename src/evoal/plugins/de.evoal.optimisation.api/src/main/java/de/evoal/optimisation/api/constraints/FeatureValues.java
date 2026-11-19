package de.evoal.optimisation.api.constraints;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * The values of the features a {@link Constraint} reads: search features and objectives.
 */
@FunctionalInterface
public interface FeatureValues {
    /**
     * @param feature A search feature or an objective.
     * @return The value of the feature.
     */
    double valueOf(EStructuralFeature feature);
}

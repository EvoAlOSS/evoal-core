package de.evoal.optimisation.api.correlations;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A group of search features that interact, declared in the DDL: a {@link Correlation} of
 *   two features or a {@link BuildingBlock}. A linkage-preserving crossover keeps the
 *   features of a group together.
 */
public sealed interface LinkageGroup permits Correlation, BuildingBlock {
    /**
     * @return The features of the group, in the order of the DDL.
     */
    List<EStructuralFeature> features();
}

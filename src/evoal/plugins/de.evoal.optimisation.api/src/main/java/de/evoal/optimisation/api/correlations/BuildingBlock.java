package de.evoal.optimisation.api.correlations;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A building block, a group of search features that interact, i.e. the problem is not
 *   separable in them; declared in the DDL by {@code 'building-block'([data f, data g, …])}.
 *   The term follows G. R. Harik, D. E. Goldberg: Learning linkage. Foundations of Genetic
 *   Algorithms 4, 1996, pp. 247-262, section 2, where the linkage of a building block is the
 *   probability that crossover preserves it. A building block has no coefficient, and a
 *   feature may belong to several building blocks.
 *
 * @param number The position of the building block among the building blocks of the DDL,
 *   from 1.
 * @param features The features, at least two and none twice, in the order of the DDL.
 */
public record BuildingBlock(int number, List<EStructuralFeature> features) implements LinkageGroup {
    /**
     * @throws IllegalArgumentException if the building block has fewer than two features or
     *   a feature twice.
     */
    public BuildingBlock {
        features = List.copyOf(Objects.requireNonNull(features, "features"));

        if(features.size() < 2) {
            throw new IllegalArgumentException("A building block needs at least two features, but has " + features.size()
                                               + ".");
        }

        final Set<EStructuralFeature> seen = new HashSet<>();
        for(final EStructuralFeature feature : features) {
            if(!seen.add(feature)) {
                throw new IllegalArgumentException("The feature '" + feature.getName() + "' appears twice in the building "
                                                   + "block.");
            }
        }
    }

    @Override
    public String toString() {
        return "building block " + number + " of "
               + features.stream().map(feature -> "'" + feature.getName() + "'").collect(Collectors.joining(", "));
    }
}

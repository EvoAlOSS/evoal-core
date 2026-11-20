package de.evoal.optimisation.ea.api.genotype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

/**
 * The chromosomes of the candidates. Every feature of the search space belongs to exactly one
 *   chromosome.
 */
public final class Genotype {
    /**
     * The chromosomes.
     */
    private final List<Chromosome> chromosomes;

    /**
     * Creates the candidates.
     */
    private final Space searchSpace;

    /**
     * @param chromosomes The chromosomes.
     * @param searchSpace The search space.
     * @throws IllegalArgumentException if a feature of the search space belongs to no or to
     *   several chromosomes, or a chromosome has a feature outside the search space.
     */
    public Genotype(final List<Chromosome> chromosomes, final Space searchSpace) {
        this.chromosomes = List.copyOf(chromosomes);
        this.searchSpace = searchSpace;

        final List<String> mapped = new ArrayList<>();
        for(final Chromosome chromosome : chromosomes) {
            for(final EStructuralFeature feature : chromosome.features()) {
                if(!searchSpace.contains(feature)) {
                    throw new IllegalArgumentException("The feature '" + feature.getName() + "' of " + chromosome
                                                       + " is not a search variable.");
                }
                if(mapped.contains(feature.getName())) {
                    throw new IllegalArgumentException("The feature '" + feature.getName() + "' belongs to more than one chromosome.");
                }
                mapped.add(feature.getName());
            }
        }

        for(final EStructuralFeature feature : searchSpace) {
            if(!mapped.contains(feature.getName())) {
                throw new IllegalArgumentException("The search variable '" + feature.getName() + "' belongs to no chromosome.");
            }
        }
    }

    /**
     * @return The names of the features whose genes differ between the genomes, in the order
     *   of the chromosomes and their features.
     */
    public List<String> changedFeatures(final Genome from, final Genome to) {
        final List<String> changed = new ArrayList<>();

        for(int c = 0; c < chromosomes.size(); ++c) {
            final Chromosome chromosome = chromosomes.get(c);
            final Genes before = from.chromosomes().get(c);
            final Genes after = to.chromosomes().get(c);

            int lastFeature = -1;
            for(int gene = 0; gene < before.size(); ++gene) {
                final int feature = chromosome.featureOfGene(gene);
                if(feature != lastFeature && !before.equalAt(after, gene)) {
                    changed.add(chromosome.features().get(feature).getName());
                    lastFeature = feature;
                }
            }
        }

        return changed;
    }

    /**
     * @return The chromosomes.
     */
    public List<Chromosome> chromosomes() {
        return chromosomes;
    }

    /**
     * @return A new candidate of the search space with the feature values of the genome.
     */
    public TypedEObject decode(final Genome genome) {
        final TypedEObject candidate = searchSpace.newEObject();

        for(int c = 0; c < chromosomes.size(); ++c) {
            chromosomes.get(c).decode(genome.chromosomes().get(c), candidate);
        }

        return candidate;
    }

    /**
     * @return The genome of the candidate.
     */
    public Genome encode(final TypedEObject candidate) {
        return new Genome(chromosomes.stream()
                                     .map(chromosome -> chromosome.encode(candidate))
                                     .toList());
    }

    /**
     * @param feature A search feature.
     * @return The index of the chromosome that holds the feature.
     * @throws IllegalArgumentException if no chromosome holds the feature.
     */
    public int chromosomeOf(final EStructuralFeature feature) {
        for(int c = 0; c < chromosomes.size(); ++c) {
            if(chromosomes.get(c).features().contains(feature)) {
                return c;
            }
        }

        throw new IllegalArgumentException("The feature '" + feature.getName() + "' belongs to no chromosome.");
    }

    /**
     * Writes the values of features into a genome: the chromosomes that hold them are encoded
     *   from the candidate again, and their genes are replaced in place.
     *
     * @param genome The genome; its genes are changed.
     * @param values A candidate with the values of the features.
     * @param features The features whose values changed.
     */
    public void write(final Genome genome, final TypedEObject values, final Collection<EStructuralFeature> features) {
        final Set<Integer> changed = new TreeSet<>();
        features.forEach(feature -> changed.add(chromosomeOf(feature)));

        for(final int c : changed) {
            final Genes genes = genome.chromosomes().get(c);
            final Genes encoded = chromosomes.get(c).encode(values);

            for(int gene = 0; gene < genes.size(); ++gene) {
                if(!genes.equalAt(encoded, gene)) {
                    genes.exchange(encoded, gene);
                }
            }
        }
    }

    /**
     * @return Whether the genomes have the same genes.
     */
    public boolean isUnchanged(final Genome from, final Genome to) {
        for(int c = 0; c < chromosomes.size(); ++c) {
            final Genes before = from.chromosomes().get(c);
            final Genes after = to.chromosomes().get(c);

            for(int gene = 0; gene < before.size(); ++gene) {
                if(!before.equalAt(after, gene)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return chromosomes.toString();
    }
}

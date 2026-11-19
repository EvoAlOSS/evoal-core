package de.evoal.optimisation.ea.api.genotype;

import java.util.List;

/**
 * The genes of a candidate, one {@link Genes} per chromosome of the {@link Genotype}.
 *
 * @param chromosomes The genes per chromosome.
 */
public record Genome(List<Genes> chromosomes) {
    public Genome {
        chromosomes = List.copyOf(chromosomes);
    }

    /**
     * @return A copy with copied genes.
     */
    public Genome copy() {
        return new Genome(chromosomes.stream().map(Genes::copy).toList());
    }
}

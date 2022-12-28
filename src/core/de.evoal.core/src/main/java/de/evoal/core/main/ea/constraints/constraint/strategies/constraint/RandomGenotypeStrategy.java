package de.evoal.core.main.ea.constraints.constraint.strategies.constraint;

import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.Phenotype;

public class RandomGenotypeStrategy<G extends Gene<?, G>, C extends Comparable<? super C>> implements RepairStrategy<G, C> {
    @Override
    public Phenotype apply(final Phenotype<G, C> individual, long generation) {
        final Genotype<G> newInstance = individual.genotype().newInstance();

        return Phenotype.of(newInstance, generation);
    }
}

package de.evoal.core.ea.main.constraints.constraint.strategies.constraint;

import de.evoal.core.ea.api.constraints.strategies.RepairStrategy;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.Gene;
import io.jenetics.Genotype;
import io.jenetics.Phenotype;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("repair-with-random")
public class RandomGenotypeStrategy<G extends Gene<?, G>, C extends Comparable<? super C>> implements RepairStrategy<G, C> {
    @Override
    public Phenotype apply(final Phenotype<G, C> individual, long generation) {
        final Genotype<G> newInstance = individual.genotype().newInstance();

        return Phenotype.of(newInstance, generation);
    }

    @Override
    public RepairStrategy init(Instance configuration) {
        return null;
    }
}

package de.evoal.core.main.search;

import de.evoal.core.api.ea.fitness.type.FitnessType;
import io.jenetics.Gene;
import io.jenetics.Phenotype;
import io.jenetics.engine.Constraint;

import java.util.List;

public class ListConstraint<G extends Gene<?, G>> implements Constraint<G, FitnessType> {
    private final List<Constraint<G, FitnessType>> constraints;

    public ListConstraint(final List<Constraint<G, FitnessType>> constraints) {
        this.constraints = constraints;
    }

    @Override
    public boolean test(final Phenotype<G, FitnessType> individual) {
        return constraints.stream().allMatch(c -> c.test(individual));
    }

    @Override
    public Phenotype<G, FitnessType> repair(Phenotype<G, FitnessType> individual, long generation) {
        Phenotype<G, FitnessType> phenotype = individual;

        for(final Constraint<G, FitnessType> c : constraints) {
            phenotype = c.repair(phenotype, generation);
        }

        return phenotype;
    }
}

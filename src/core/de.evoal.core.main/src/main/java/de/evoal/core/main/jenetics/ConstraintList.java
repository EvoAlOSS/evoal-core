package de.evoal.core.main.jenetics;

import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import io.jenetics.Gene;
import io.jenetics.Phenotype;
import io.jenetics.engine.Constraint;

import java.util.List;

public class ConstraintList<G extends Gene<?, G>> implements Constraint<G, FitnessValue> {
    private final List<Constraint<G, FitnessValue>> constraints;

    public ConstraintList(final List<Constraint<G, FitnessValue>> constraints) {
        this.constraints = constraints;
    }

    @Override
    public boolean test(final Phenotype<G, FitnessValue> individual) {
        return constraints.stream().allMatch(c -> c.test(individual));
    }

    @Override
    public Phenotype<G, FitnessValue> repair(Phenotype<G, FitnessValue> individual, long generation) {
        Phenotype<G, FitnessValue> phenotype = individual;

        for(final Constraint<G, FitnessValue> c : constraints) {
            phenotype = c.repair(phenotype, generation);
        }

        return phenotype;
    }
}

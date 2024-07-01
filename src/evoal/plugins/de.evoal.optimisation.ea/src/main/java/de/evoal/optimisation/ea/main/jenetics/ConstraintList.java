package de.evoal.optimisation.ea.main.jenetics;

import de.evoal.optimisation.api.model.OptimisationValue;
import io.jenetics.Gene;
import io.jenetics.Phenotype;
import io.jenetics.engine.Constraint;

import java.util.List;

public class ConstraintList<G extends Gene<?, G>> implements Constraint<G, OptimisationValue> {
    private final List<Constraint<G, OptimisationValue>> constraints;

    public ConstraintList(final List<Constraint<G, OptimisationValue>> constraints) {
        this.constraints = constraints;
    }

    @Override
    public boolean test(final Phenotype<G, OptimisationValue> individual) {
        return constraints.stream().allMatch(c -> c.test(individual));
    }

    @Override
    public Phenotype<G, OptimisationValue> repair(Phenotype<G, OptimisationValue> individual, long generation) {
        Phenotype<G, OptimisationValue> phenotype = individual;

        for(final Constraint<G, OptimisationValue> c : constraints) {
            phenotype = c.repair(phenotype, generation);
        }

        return phenotype;
    }
}

package de.evoal.core.main.ddl.constraint.strategies.constraint;

import de.evoal.core.main.ddl.constraint.strategies.CalculationStrategy;
import de.evoal.core.api.ea.constraints.strategies.HandlingStrategy;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.properties.Properties;
import io.jenetics.Gene;
import io.jenetics.Phenotype;

public class JeneticsConstraintStrategy<
        G extends Gene<?, G>,
        C extends Comparable<? super C>
        > implements io.jenetics.engine.Constraint<G, C>, HandlingStrategy {

    private final CalculationStrategy calculation;
    private final CustomCodec<G> codec;
    private final RepairStrategy repair;

    public JeneticsConstraintStrategy(final CalculationStrategy calculation, final CustomCodec<G> codec, final RepairStrategy repair) {
        this.calculation = calculation;
        this.codec = codec;
        this.repair = repair;
    }

    @Override
    public boolean test(final Phenotype<G, C> individual) {
        final Properties properties = codec.decode(individual.genotype());

        return calculation.calculate(properties).isSuccessful();
    }

    @Override
    public Phenotype<G, C> repair(final Phenotype<G, C> individual, final long generation) {
        return repair.apply(individual, generation);
    }
}

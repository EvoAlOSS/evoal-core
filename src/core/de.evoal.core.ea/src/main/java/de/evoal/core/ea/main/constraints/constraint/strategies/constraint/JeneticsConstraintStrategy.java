package de.evoal.core.ea.main.constraints.constraint.strategies.constraint;

import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.ea.api.constraints.calculation.CalculationStrategy;
import de.evoal.core.ea.api.constraints.strategies.HandlingStrategy;
import de.evoal.core.ea.api.codec.CustomCodec;
import de.evoal.core.ea.api.constraints.strategies.RepairStrategy;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import io.jenetics.Gene;
import io.jenetics.Phenotype;

public class JeneticsConstraintStrategy<
        G extends Gene<?, G>,
        C extends Comparable<? super C>
        > implements io.jenetics.engine.Constraint<G, C>, HandlingStrategy {

    private final CalculationStrategy calculation;
    private final CustomCodec<G> codec;
    private final OptimisationFunction function;
    private final PropertiesSpecification fitnessSpec;
    private final RepairStrategy repair;

    public JeneticsConstraintStrategy(final CalculationStrategy calculation, final CustomCodec<G> codec, final OptimisationFunction function, final PropertiesSpecification fitnessSpec, final RepairStrategy repair) {
        this.calculation = calculation;
        this.codec = codec;
        this.function = function;
        this.fitnessSpec = fitnessSpec;
        this.repair = repair;
    }

    @Override
    public boolean test(final Phenotype<G, C> individual) {
        final Properties genotype = codec.decode(individual.genotype());
        final double [] calculated = function.evaluate(genotype);
        final Properties fitness = new Properties(fitnessSpec, calculated);

        return calculation.calculate(genotype, fitness).isSuccessful();
    }

    @Override
    public Phenotype<G, C> repair(final Phenotype<G, C> individual, final long generation) {
        return repair.apply(individual, generation);
    }
}

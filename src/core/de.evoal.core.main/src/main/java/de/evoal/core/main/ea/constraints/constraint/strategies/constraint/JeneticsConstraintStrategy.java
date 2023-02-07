package de.evoal.core.main.ea.constraints.constraint.strategies.constraint;

import de.evoal.core.api.ea.constraints.calculation.CalculationStrategy;
import de.evoal.core.api.ea.constraints.strategies.HandlingStrategy;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.constraints.strategies.RepairStrategy;
import de.evoal.core.api.ea.fitness.FitnessFunction;
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
    private final FitnessFunction function;
    private final PropertiesSpecification fitnessSpec;
    private final RepairStrategy repair;

    public JeneticsConstraintStrategy(final CalculationStrategy calculation, final CustomCodec<G> codec, final FitnessFunction function, final PropertiesSpecification fitnessSpec, final RepairStrategy repair) {
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

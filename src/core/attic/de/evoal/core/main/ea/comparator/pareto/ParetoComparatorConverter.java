package de.evoal.core.main.ea.comparator.pareto;

import de.evoal.core.api.ea.fitness.type.FitnessConverter;
import de.evoal.core.api.ea.fitness.type.FitnessType;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

@ApplicationScoped
@Named("pareto")
public class ParetoComparatorConverter implements FitnessConverter {
    @Override
    public FitnessType convert(final double[] fitnessValues) {
        return ParetoComparatorType.of(fitnessValues);
    }
}

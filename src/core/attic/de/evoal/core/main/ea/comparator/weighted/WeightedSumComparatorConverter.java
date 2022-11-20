package de.evoal.core.main.ea.comparator.weighted;

import de.evoal.core.api.ea.fitness.type.FitnessConverter;
import de.evoal.core.api.ea.fitness.type.FitnessType;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named("weighted_sum")
public class WeightedSumComparatorConverter implements FitnessConverter {
    @Inject
    @ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.comparator.weights")
    private double [] weights;

    @Override
    public FitnessType convert(final double[] fitnessValues) {
        return WeightedSumComparatorType.of(weights, fitnessValues);
    }
}

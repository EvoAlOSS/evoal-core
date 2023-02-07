package de.evoal.core.main.ea.comparator;

import de.evoal.core.api.ea.fitness.comparator.FitnessComparator;
import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

@ApplicationScoped
@Named("pareto")
public class ParetoComparator implements FitnessComparator {
    @Override
    public FitnessValue compare(final double[] fitnessValues) {
        return ParetoFitnessValue.of(fitnessValues);
    }

    @Override
    public ParetoComparator init(Instance config) {
        return this;
    }
}

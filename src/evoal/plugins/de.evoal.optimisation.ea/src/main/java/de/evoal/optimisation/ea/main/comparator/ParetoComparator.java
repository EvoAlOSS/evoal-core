package de.evoal.optimisation.ea.main.comparator;

import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Named;

@ApplicationScoped
@Named("de.evoal.optimisation.ea.optimisation.pareto")
public class ParetoComparator implements OptimisationValueComparator {
    @Override
    public OptimisationValue toValue(final double[] optimisationValues) {
        return ParetoOptimisationValue.of(optimisationValues);
    }

    @Override
    public ParetoComparator init(Instance config) {
        return this;
    }
}

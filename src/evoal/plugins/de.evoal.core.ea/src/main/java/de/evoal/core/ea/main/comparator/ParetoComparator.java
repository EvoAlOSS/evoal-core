package de.evoal.core.ea.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

@ApplicationScoped
@Named("de.evoal.core.ea.optimisation.pareto")
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

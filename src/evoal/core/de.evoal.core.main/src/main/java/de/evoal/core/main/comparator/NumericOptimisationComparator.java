package de.evoal.core.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.core.optimisation.numeric-comparator")
public class NumericOptimisationComparator implements OptimisationValueComparator {
    @Override
    public NumericOptimisationValue toValue(final double[] fitnessValues) {
        return NumericOptimisationValue.of(fitnessValues);
    }

    @Override
    public OptimisationValueComparator init(final Instance config) {
        return this;
    }
}

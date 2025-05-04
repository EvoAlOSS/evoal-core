package de.evoal.optimisation.main.comparator;

import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.optimisation.core.numeric-comparator")
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

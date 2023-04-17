package de.evoal.core.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.LiteralValue;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("numeric-comparator")
public class NumericOptimisationComparator implements OptimisationValueComparator {
    @Override
    public OptimisationValue toValue(final double[] fitnessValues) {
        return NumericOptimisationValue.of(fitnessValues);
    }

    @Override
    public OptimisationValueComparator init(final Instance config) {
        return this;
    }
}

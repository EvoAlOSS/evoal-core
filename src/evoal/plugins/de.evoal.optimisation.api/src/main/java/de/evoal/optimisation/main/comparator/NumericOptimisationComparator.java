package de.evoal.optimisation.main.comparator;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.function.Function;

import de.evoal.optimisation.api.model.OptimisationValueComparator;

@Dependent
@Named("de.evoal.optimisation.core.numeric-comparator")
@Slf4j
public class NumericOptimisationComparator implements OptimisationValueComparator {
    @Inject @Named("optimisation-value-conversions")
    private List<Function<Double, Double>> valueConversions;

    @Override
    public NumericOptimisationValue toValue(final double[] fitnessValues) {
        return NumericOptimisationValue.of(valueConversions, fitnessValues);
    }
}

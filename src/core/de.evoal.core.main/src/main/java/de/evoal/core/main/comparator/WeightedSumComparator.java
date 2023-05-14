package de.evoal.core.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.languages.model.base.RealLiteral;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.Literal;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("weighted-sum")
public class WeightedSumComparator implements OptimisationValueComparator {
    private double [] weights;

    @Override
    public OptimisationValue toValue(final double[] fitnessValues) {
        return WeightedSumOptimisationValue.of(weights, fitnessValues);
    }

    @Override
    public OptimisationValueComparator init(final Instance config) {
        final Array weights = (Array) config.findAttribute("weights")
                                            .getValue();

        this.weights = weights.getValues()
                              .stream()
                              .map(Literal.class::cast)
                              .map(RealLiteral.class::cast)
                              .mapToDouble(RealLiteral::getValue)
                              .toArray();

        return this;
    }
}

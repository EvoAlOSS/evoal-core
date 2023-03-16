package de.evoal.core.main.comparator;

import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.LiteralValue;

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
                              .map(LiteralValue.class::cast)
                              .map(LiteralValue::getLiteral)
                              .map(DoubleLiteral.class::cast)
                              .mapToDouble(DoubleLiteral::getValue)
                              .toArray();

        return this;
    }
}

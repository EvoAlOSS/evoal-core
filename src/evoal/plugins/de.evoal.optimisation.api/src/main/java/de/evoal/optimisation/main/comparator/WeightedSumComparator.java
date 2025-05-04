package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("de.evoal.optimisation.core.weighted-sum")
public class WeightedSumComparator implements OptimisationValueComparator {
    private double [] weights;

    @Inject
    private AttributeEvaluator evaluator;

    @Override
    public WeightedSumOptimisationValue toValue(final double[] fitnessValues) {
        return WeightedSumOptimisationValue.of(weights, fitnessValues);
    }

    @Override
    public WeightedSumComparator init(final Instance config) {
        weights = evaluator.attributeToDoubleArray(config, "weights");

        return this;
    }
}

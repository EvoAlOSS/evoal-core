package de.evoal.core.main.comparator;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("de.evoal.core.optimisation.weighted-sum")
public class WeightedSumComparator implements OptimisationValueComparator {
    private double [] weights;

    @Inject
    private ExpressionEvaluator evaluator;

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

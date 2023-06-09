package de.evoal.core.main.comparator;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.languages.model.base.RealLiteral;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.Literal;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("weighted-sum")
public class WeightedSumComparator implements OptimisationValueComparator {
    private double [] weights;

    @Inject
    private ExpressionEvaluator evaluator;

    @Override
    public OptimisationValue toValue(final double[] fitnessValues) {
        return WeightedSumOptimisationValue.of(weights, fitnessValues);
    }

    @Override
    public OptimisationValueComparator init(final Instance config) {
        weights = evaluator.attributeToDoubleArray(config, "weights");

        return this;
    }
}

package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.function.Function;

@Dependent
@Named("de.evoal.optimisation.core.weighted-sum")
public class WeightedSumComparator implements OptimisationValueComparator {
    @Inject @Named("optimisation-value-conversions")
    private List<Function<Double, Double>> valueConversions;

    private double [] weights;

    @Inject
    private AttributeEvaluator evaluator;

    @Override
    public WeightedSumOptimisationValue toValue(final double[] fitnessValues) {
        return WeightedSumOptimisationValue.of(valueConversions, weights, fitnessValues);
    }

    @Override
    public WeightedSumComparator init(final Instance config) {
        weights = evaluator.attributeToDoubleArray(config, "weights");

        return this;
    }
}

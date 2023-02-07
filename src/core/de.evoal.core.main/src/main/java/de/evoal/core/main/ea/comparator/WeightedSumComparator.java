package de.evoal.core.main.ea.comparator;

import de.evoal.core.api.ea.fitness.comparator.FitnessComparator;
import de.evoal.core.api.ea.fitness.comparator.FitnessValue;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.LiteralValue;
import de.evoal.languages.model.instance.Value;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("weighted-sum")
public class WeightedSumComparator implements FitnessComparator {
    private double [] weights;

    @Override
    public FitnessValue compare(final double[] fitnessValues) {
        return WeightedSumFitnessValue.of(weights, fitnessValues);
    }

    @Override
    public FitnessComparator init(final Instance config) {
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

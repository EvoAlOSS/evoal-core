package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.core.api.properties.PropertiesSpecification;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;

@Dependent
@Named("de.evoal.optimisation.core.epsilon-comparator")
public class EpsilonComparator implements OptimisationValueComparator {

    @Inject
    private AttributeEvaluator evaluator;

    private int index;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpec;

    @Inject @Named("optimisation-value-conversions")
    private List<Function<Double, Double>> valueConversions;

    @Override
    public EpsilonOptimisationValue toValue(final double[] fitnessValues) {
        return EpsilonOptimisationValue.of(valueConversions, index, fitnessValues);
    }

    @Override
    public OptimisationValueComparator init(final Instance config) {
        DataDescription goalData = evaluator.attributeToDataDescription(config, "goal-objective");
        this.index = optimisationSpec.indexOf(goalData.getName());
        return this;
    }
}
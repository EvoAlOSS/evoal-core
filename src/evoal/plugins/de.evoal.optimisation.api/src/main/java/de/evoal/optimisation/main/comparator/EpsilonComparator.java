package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.core.api.properties.PropertiesSpecification;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.inject.Inject;

@Dependent
@Named("de.evoal.optimisation.core.epsilon-comparator")
public class EpsilonComparator implements OptimisationValueComparator {

    private int index;

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpec;

    @Override
    public EpsilonOptimisationValue toValue(final double[] fitnessValues) {
        return EpsilonOptimisationValue.of(index, fitnessValues);
    }

    @Override
    public OptimisationValueComparator init(final Instance config) {
        DataDescription goalData = evaluator.attributeToDataDescription(config, "goal-objective");
        this.index = optimisationSpec.indexOf(goalData.getName());
        return this;
    }
}
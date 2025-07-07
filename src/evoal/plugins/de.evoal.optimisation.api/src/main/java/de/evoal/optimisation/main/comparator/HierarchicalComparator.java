package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.definitions.DataDescription;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.function.Function;

@Dependent
@Named("de.evoal.optimisation.core.hierarchical-comparator")
public class HierarchicalComparator implements OptimisationValueComparator {
    @Inject
    private AttributeEvaluator evaluator;

    private int[] orderIndices;

    @Inject @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpecification;

    @Inject @Named("optimisation-value-conversions")
    private List<Function<Double, Double>> valueConversions;

    @Override
    public HierarchicalValue toValue(final double[] fitnessValues) {
        return HierarchicalValue.of(valueConversions, orderIndices, fitnessValues);
    }

    @Override
    public HierarchicalComparator init(final Instance config) {
        final DataDescription[] order = evaluator.attributeToDataDescriptionArray(config, "order");

        orderIndices = new int[order.length];
        for(int i = 0; i < order.length; i++) {
            orderIndices[i] = optimisationSpecification.indexOf(order[i].getName());
        }

        return this;
    }
}

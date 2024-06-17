package de.evoal.core.main.comparator;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataDescription;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("de.evoal.core.optimisation.hierarchical-comparator")
public class HierarchicalComparator implements OptimisationValueComparator {
    private int[] orderIndices;

    @Inject @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpecification;

    @Inject
    private ExpressionEvaluator evaluator;

    @Override
    public HierarchicalValue toValue(final double[] fitnessValues) {
        return HierarchicalValue.of(orderIndices, fitnessValues);
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

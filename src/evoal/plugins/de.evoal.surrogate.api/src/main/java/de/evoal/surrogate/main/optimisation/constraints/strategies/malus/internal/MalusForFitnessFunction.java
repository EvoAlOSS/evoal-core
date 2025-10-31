package de.evoal.surrogate.main.optimisation.constraints.strategies.malus.internal;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.constraints.model.Constraint;
import de.evoal.optimisation.api.constraints.model.ConstraintResult;
import de.evoal.surrogate.api.ea.constraints.strategies.malus.MalusFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;

public class MalusForFitnessFunction implements MalusFunction {

    private final Constraint constraint;
    private final double smoothing;

    public MalusForFitnessFunction(final AttributeHelper helper, final Constraint constraint, final Instance configuration, final int index) {
        this.constraint = constraint;
        smoothing = helper.lookup(configuration, "smoothing");
    }

    @Override
    public double apply(final Properties genoProperties, final Properties fitnessProperties, final double fitnessValue) {
        final ConstraintResult result = constraint.apply(genoProperties, fitnessProperties);

        return fitnessValue - smoothing * Math.abs(result.getComparisonDifference());
    }
}

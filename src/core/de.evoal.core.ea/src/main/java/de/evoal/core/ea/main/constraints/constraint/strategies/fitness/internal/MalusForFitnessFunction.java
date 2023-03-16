package de.evoal.core.ea.main.constraints.constraint.strategies.fitness.internal;

import de.evoal.core.ea.api.constraints.model.Constraint;
import de.evoal.core.ea.api.constraints.model.ConstraintResult;
import de.evoal.core.ea.api.constraints.strategies.fitness.MalusFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.instance.Instance;

public class MalusForFitnessFunction implements MalusFunction {
    private final Constraint constraint;
    private final double smoothing;

    public MalusForFitnessFunction(final Constraint constraint, final Instance configuration, final int index) {
        this.constraint = constraint;
        smoothing = LanguageHelper.lookup(configuration, "smoothing");
    }

    @Override
    public double apply(final Properties genoProperties, final Properties fitnessProperties, final double fitnessValue) {
        final ConstraintResult result = constraint.apply(genoProperties, fitnessProperties);

        return fitnessValue - smoothing * Math.abs(result.getComparisonDifference());
    }
}

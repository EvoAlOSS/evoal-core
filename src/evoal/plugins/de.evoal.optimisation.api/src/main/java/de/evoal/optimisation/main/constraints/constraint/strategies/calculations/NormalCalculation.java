package de.evoal.optimisation.main.constraints.constraint.strategies.calculations;

import de.evoal.optimisation.api.constraints.model.Constraint;
import de.evoal.optimisation.api.constraints.strategies.CalculationResult;
import de.evoal.optimisation.api.constraints.calculation.CalculationStrategy;
import de.evoal.core.api.properties.Properties;
import jakarta.enterprise.context.Dependent;

import de.evoal.languages.model.base.expressions.Instance;
import lombok.NonNull;

import jakarta.inject.Named;

@Dependent
@Named("de.evoal.optimisation.ea.optimisation.normal-calculation")
public class NormalCalculation implements CalculationStrategy {
    private Instance configuration;
    private Constraint constraint;

    @Override
    public @NonNull CalculationResult calculate(final Properties genotype, final Properties fitness) {
        return new CalculationResult(constraint.apply(genotype, fitness));
    }

    @Override
    public void init(final Constraint constraint, final Instance configuration) {
        this.configuration = configuration;
        this.constraint = constraint;
    }
}

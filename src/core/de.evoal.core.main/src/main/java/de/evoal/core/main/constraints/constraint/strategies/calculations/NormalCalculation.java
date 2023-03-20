package de.evoal.core.main.constraints.constraint.strategies.calculations;

import de.evoal.core.api.constraints.model.Constraint;
import de.evoal.core.api.constraints.strategies.CalculationResult;
import de.evoal.core.api.constraints.calculation.CalculationStrategy;
import de.evoal.core.api.properties.Properties;
import javax.enterprise.context.Dependent;

import de.evoal.languages.model.instance.Instance;
import lombok.NonNull;

import javax.inject.Named;

@Dependent
@Named("normal")
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

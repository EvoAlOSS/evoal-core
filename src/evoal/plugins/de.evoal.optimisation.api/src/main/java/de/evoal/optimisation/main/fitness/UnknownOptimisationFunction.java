package de.evoal.optimisation.main.fitness;

import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.core.api.properties.Properties;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("de.evoal.optimisation.core.unknown-function")
public class UnknownOptimisationFunction implements OptimisationFunction {
    @Override
    public double[] evaluate(Properties candidate) {
        throw new RuntimeException("The unknown function is not valid for usage during optimisation, please specify a proper optimisation function.");
    }
}

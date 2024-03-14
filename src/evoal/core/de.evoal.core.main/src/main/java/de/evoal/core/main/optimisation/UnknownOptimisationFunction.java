package de.evoal.core.main.optimisation;

import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.Properties;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.core.optimisation.unknown-function")
public class UnknownOptimisationFunction implements OptimisationFunction {
    @Override
    public double[] evaluate(Properties candidate) {
        throw new RuntimeException("The unknown function is not valid for usage during optimisation, please specify a proper optimisation function.");
    }
}

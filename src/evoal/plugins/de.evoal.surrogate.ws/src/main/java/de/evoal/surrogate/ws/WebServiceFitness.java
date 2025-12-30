package de.evoal.surrogate.ws;

import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

/**
 *
 */
@Dependent
@Named("webservice")
public class WebServiceFitness implements OptimisationFunction {
    @Override
    public double[] evaluate(final Properties properties) {

        return new double[0];
    }

    @Override
    public OptimisationFunction init(final Instance config) {
//        LanguageHelper.lookup();

        return this;
    }
}

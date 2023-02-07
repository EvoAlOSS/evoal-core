package de.evoal.surrogate.ws;

import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 */
@Dependent
@Named("webservice")
public class WebServiceFitness implements FitnessFunction {
    @Override
    public double[] evaluate(final Properties properties) {

        return new double[0];
    }

    @Override
    public FitnessFunction init(final Instance config) {
        LanguageHelper.lookup()

        return this;
    }
}

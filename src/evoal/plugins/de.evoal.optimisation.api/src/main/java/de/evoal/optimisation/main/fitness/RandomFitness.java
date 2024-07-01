package de.evoal.optimisation.main.fitness;

import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

@Dependent
@Named("de.evoal.optimisation.core.random-fitness")
public class RandomFitness implements OptimisationFunction {
    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification specification;

    @Override
    public double[] evaluate(Properties candidate) {
        double [] result =  new double[specification.size()];

        for(int i = 0; i < specification.size(); ++i) {
            result[i] = new Random().nextDouble();
        }

        return result;
    }
}

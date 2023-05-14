package de.evoal.core.main.optimisation;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;


@Dependent
@Named("problem-function")
@Slf4j
public class ProblemOptimisationFunction implements OptimisationFunction {
    @Inject
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.optimisation-function")
    private Instance problemConfiguration;

    /**
     * The actual problem function to use
     */
    private OptimisationFunction delegate;


    @Override
    public double[] evaluate(final Properties candidate) {
        return delegate.evaluate(candidate);
    }

    @Override
    public OptimisationFunction init(final Instance config) {
        final String fitnessName = problemConfiguration.getDefinition().getName();

        log.info("Creating problem function {}.", fitnessName);

        delegate = BeanFactory.create(fitnessName, OptimisationFunction.class)
                              .init(problemConfiguration);

        return this;
    }
}

package de.evoal.optimisation.main.fitness;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Dependent
@Named("de.evoal.optimisation.core.problem-function")
@Slf4j
public class ProblemOptimisationFunction implements OptimisationFunction {
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem")
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
        problemConfiguration = ((ProblemInstance)problemConfiguration).getOptimisationFunction();
        delegate = BeanFactory.createComponent(OptimisationFunction.class, problemConfiguration);

        return this;
    }
}

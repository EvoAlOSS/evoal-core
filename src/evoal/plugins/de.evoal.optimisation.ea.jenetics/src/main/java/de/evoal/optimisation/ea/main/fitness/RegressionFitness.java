package de.evoal.optimisation.ea.main.fitness;

import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.ea.api.fitness.GoodnessOfFitFunction;
import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.regression-fitness")
public class RegressionFitness extends OptimisationFunctionImpl {

    @Inject
    private AttributeHelper helper;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpecification;

    @Inject
    @Named("search-space-specification")
    private PropertiesSpecification searchSpecification;

    private List<GoodnessOfFitFunction> gofFunctions;

    @Override
    public OptimisationFunction init(final Instance configuration) throws InitializationException {
        final List<Instance> calculations = helper.lookup(configuration, "calculations");

        gofFunctions = calculations.stream()
                             .map(i -> BeanFactory.createComponent(GoodnessOfFitFunction.class, i))
                             .collect(Collectors.toList());

        return super.init(configuration);
    }

    @Override
    public double[] evaluate(final Properties candidate) {
        return gofFunctions.stream()
                .mapToDouble(f -> f.apply(candidate))
                .toArray();
    }
}

package de.evoal.optimisation.ea.main.fitness;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.optimisation.ea.api.fitness.GoodnessOfFitFunction;
import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.regression-fitness")
public class RegressionFitness implements OptimisationFunction {

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

        return OptimisationFunction.super.init(configuration);
    }

    @Override
    public double[] evaluate(final Properties candidate) {
        return gofFunctions.stream()
                .mapToDouble(f -> f.apply(candidate))
                .toArray();
    }
}

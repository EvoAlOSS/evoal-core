package de.evoal.core.ea.main.fitness;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.ea.api.fitness.GoodnessOfFitFunction;
import de.evoal.languages.model.base.Instance;
import io.jenetics.prog.ProgramGene;
import io.jenetics.prog.op.Op;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Dependent
@Named("de.evoal.core.ea.genetic-programming.regression-fitness")
public class RegressionFitness implements OptimisationFunction {

    @Inject
    private LanguageHelper helper;

    @Inject
    @Named("optimisation-space-specification")
    private PropertiesSpecification optimisationSpecification;

    @Inject
    @Named("search-space-specification")
    private PropertiesSpecification searchSpecification;

    private List<GoodnessOfFitFunction> gofFunctions;

    @Override
    public OptimisationFunction init(final Instance configuration) throws InitializationException {
        final Object [] calculations = helper.lookup(configuration, "calculations");

        gofFunctions = Arrays.stream(calculations)
                             .map(Instance.class::cast)
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

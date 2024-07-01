package de.evoal.optimisation.ea.main.fitness.gof;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.optimisation.ea.api.fitness.GoodnessOfFitFunction;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataDescription;
import io.jenetics.ext.util.TreeNode;
import io.jenetics.prog.op.Op;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.Arrays;

@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.squared-error")
public class SquaredError implements GoodnessOfFitFunction {
    @Inject
    private LanguageHelper helper;

    private PropertiesSpecification inputSpecification;
    private PropertiesSpecification outputSpecification;

    private PropertiesPairStreamSupplier streamSupplier;

    private DataDescription functionProperty;

    @Override
    public GoodnessOfFitFunction init(Instance configuration) throws InitializationException {

        functionProperty = helper.lookup(configuration, "function");
        Object [] input = helper.lookup(configuration, "input");
        Object [] output = helper.lookup(configuration, "output");
        final String referenceFile = helper.lookup(configuration, "reference");

        inputSpecification = PropertiesSpecification.builder().add(Arrays.stream(input).map(DataDescription.class::cast)).build();
        outputSpecification = PropertiesSpecification.builder().add(Arrays.stream(output).map(DataDescription.class::cast)).build();

        final PropertiesStreamSupplier supplier = new FileBasedPropertiesStreamSupplier(new File(referenceFile),
                            PropertiesSpecification.builder().add(inputSpecification).add(outputSpecification).build());

        streamSupplier = new PropertiesBasedPropertiesPairStreamSupplier(supplier, inputSpecification, outputSpecification);


        return GoodnessOfFitFunction.super.init(configuration);
    }

    @Override
    public Double apply(final Properties properties) {
        TreeNode<Op<Double>> tree = (TreeNode<Op<Double>>)properties.get(new PropertySpecification(functionProperty.getName(), functionProperty));

        return streamSupplier.get()
                      .mapToDouble(p -> {
                          Double [] inp = Arrays.stream(p.getFirst()
                                                         .getValues())
                                                .map(Number.class::cast)
                                                .map(Number::doubleValue)
                                                .toArray(i -> new Double[i]);

                          double target = p.getSecond().getAsDouble(0);

                          return  Math.pow(target - tree.reduce(inp, Op::apply), 2);

                      })
                .sum();
    }
}

package de.evoal.surrogate.smile.knn;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;

import java.util.List;

public class KNNClassifierFunction extends AbstractPartialSurrogateFunction {
    public KNNClassifierFunction(PartialFunctionConfiguration configuration, List<Parameter> functionParameters, PropertiesSpecification input, PropertiesSpecification output) {
        super(configuration, functionParameters, input, output);
    }

    @Override
    public Object[] apply(Properties input) {
        return new Object[0];
    }
}

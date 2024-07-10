package de.evoal.surrogate.smile.knn;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import smile.classification.KNN;

import java.util.List;

public class KNNClassifierFunctionFactory extends AbstractPartialSurrogateFunctionFactory {
    @Override
    protected PartialSurrogateFunction calculateRegression(PartialFunctionConfiguration configuration, List<Parameter> parameters, PropertiesSpecification actualInput, PropertiesSpecification requiredInput, PropertiesSpecification producedOutput, PropertiesPairStreamSupplier provider) {

        return null;
    }

    @Override
    protected PartialSurrogateFunction restoreRegression(PartialFunctionConfiguration configuration, PropertiesSpecification actualInput, PropertiesSpecification requiredInput, PropertiesSpecification producedOutput) {
        return null;
    }
}

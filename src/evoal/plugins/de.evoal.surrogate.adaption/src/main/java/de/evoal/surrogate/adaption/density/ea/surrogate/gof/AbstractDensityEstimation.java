package de.evoal.surrogate.adaption.density.ea.surrogate.gof;

import de.evoal.surrogate.adaption.density.model.DensityData;
import de.evoal.core.api.properties.PropertiesPair;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.SurrogateFunction;

import java.util.List;
import java.util.function.Function;

public abstract class AbstractDensityEstimation implements SurrogateInformationCalculator {
    /**
     * The used smoothing value -> configuration value.
     */
    protected double bandwidth = 1.0;

    protected SurrogateConfiguration configuration;

    /**
     * Used during calculation for storing the properties specification of the handled function.
     */
    protected PropertiesSpecification sourcePropertiesSpec = null;

    /**
     * Used during calculation for storing the properties specification of the handled function.
     */
    protected PropertiesSpecification targetPropertiesSpec = null;

    protected PropertiesStreamSupplier trainingData;

    protected abstract DensityData calculateDensityData(final Function<PropertiesPair, Double> mapper);

    @Override
    public void configure(final SurrogateFunction function, final SurrogateConfiguration config, final List<Object> parameters, final PropertiesStreamSupplier trainingData) {
        Requirements.requireSize(parameters, 1);
        Requirements.requireType(parameters, 0, Double.class);

        bandwidth = (Double)parameters.get(0);
        this.trainingData = trainingData;
        this.configuration = config;
    }

    @Override
    public void execute() {
        for(final PartialFunctionConfiguration fc : configuration.getFunctions()) {
            // create properties specification for the configuration
            sourcePropertiesSpec = fc.getInputData();
            targetPropertiesSpec = fc.getOutputData();

            for(int i = 0; i < sourcePropertiesSpec.size(); ++i) {
                final int index = i;

                final PropertySpecification propertySpecification = sourcePropertiesSpec.getProperties().get(index);
                final Function<PropertiesPair, Double> mapper = pair -> ((Number)pair.getFirst().get(index)).doubleValue();

                calculateDensityData(mapper).attachTo(fc, propertySpecification.name());
            }

            for(int i = 0; i < targetPropertiesSpec.size(); ++i) {
                final int index = i;

                final PropertySpecification propertySpecification = targetPropertiesSpec.getProperties().get(index);
                final Function<PropertiesPair, Double> mapper = pair -> ((Number)pair.getFirst().get(index)).doubleValue();

                calculateDensityData(mapper).attachTo(fc, propertySpecification.name());
            }
        }

        sourcePropertiesSpec = null;
        targetPropertiesSpec = null;
    }
}

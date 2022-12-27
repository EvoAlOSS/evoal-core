package de.evoal.surrogate.simple.identity;

import java.util.Collections;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdentityFunction extends AbstractPartialSurrogateFunction {

	private final int propertyIndex;

	public IdentityFunction(final PartialFunctionConfiguration configuration, final PropertiesSpecification input, final PropertiesSpecification actualInput, final PropertiesSpecification output) {
		super(configuration, Collections.emptyList(), input, output);

		log.info("Using identity mapping from {} to {}.", input, output);

		final PropertySpecification inputProperty = input.getProperties().get(0);
		propertyIndex = actualInput.indexOf(inputProperty);
	}

	public double [] apply(final Properties input) {
		return new double[] {input.getAsDouble(propertyIndex)};
	}
}

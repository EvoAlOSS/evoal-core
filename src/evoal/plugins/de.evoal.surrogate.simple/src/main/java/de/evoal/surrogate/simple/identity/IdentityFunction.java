package de.evoal.surrogate.simple.identity;

import java.util.Collections;
import java.util.function.Function;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.BaseDataDescription;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;
import de.evoal.core.api.utils.ConverterFunctions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdentityFunction extends AbstractPartialSurrogateFunction {
	protected Function<Properties, Object> converter;

	public IdentityFunction(final PartialFunctionConfiguration configuration, final PropertiesSpecification input, final PropertiesSpecification actualInput, final PropertiesSpecification output) {
		super(configuration, Collections.emptyList(), input, output);

		log.info("Using identity mapping from {} to {}.", input, output);

		final PropertySpecification inputProperty = input.getProperties().get(0);
		final int propertyIndex = actualInput.indexOf(inputProperty);

		Requirements.requireInstanceOf(inputProperty.type(), BaseDataDescription.class);
		Requirements.requireInstanceOf(output.getProperties().get(0).type(), BaseDataDescription.class);
		this.converter = ConverterFunctions.convert(((BaseDataDescription)inputProperty.type()).getRepresentation(),
													((BaseDataDescription)output.getProperties().get(0).type()).getRepresentation(),
													propertyIndex);
	}

	public Object [] apply(final Properties input) {
		return new Object[] {converter.apply(input)};
	}
}

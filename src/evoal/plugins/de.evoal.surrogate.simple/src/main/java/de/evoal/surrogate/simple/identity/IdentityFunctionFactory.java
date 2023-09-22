package de.evoal.surrogate.simple.identity;

import java.util.List;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("identity")
public final class IdentityFunctionFactory extends AbstractPartialSurrogateFunctionFactory {
	@Override
	protected PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput, final PropertiesPairStreamSupplier provider) {
		return new IdentityFunction(configuration, requiredInput, actualInput, producedOutput);
	}

	@Override
	protected PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput) {
		return new IdentityFunction(configuration, requiredInput, actualInput, producedOutput);
	}
}

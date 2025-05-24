package de.evoal.surrogate.api.function;

import java.util.List;

import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.Parameter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Base class for regression factories.
 */
@Slf4j
public abstract class AbstractPartialSurrogateFunctionFactory implements PartialSurrogateFunctionFactory {
	protected abstract PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final Space requiredInput, Space producedOutput, final EObjectPairStreamSupplier provider);

	@Override
	public final PartialSurrogateFunction create(final @NonNull PartialFunctionConfiguration configuration, final @NonNull Space requiredInput, final @NonNull Space producedOutput, final EObjectPairStreamSupplier training) {
		if(training == null) {
			return restoreRegression(configuration, requiredInput, producedOutput);
		} else {
			final EObjectPairStreamSupplier provider = EObjectPairStreamFactory.createFromList(requiredInput, producedOutput, training);
			final PartialSurrogateFunction function = calculateRegression(configuration, configuration.getParameters(), requiredInput, producedOutput, provider);
			
			configuration.getState()
					     .addAll(function.getParameters());

			return function;	
		}
	}

	protected abstract PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final Space requiredInput, final Space producedOutput);
}

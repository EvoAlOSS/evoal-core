package de.evoal.surrogate.api.function;

import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;


/**
 * A surrogate function replaces the actual function used in the optimisation
 * if the actual function is too expensive to calculate or even unknown. A
 * surrogate function transforms some input to some output  according to a
 * known oder learned function.
 */
@Data
public final class SurrogateFunction {
	/**
	 * The chain of property mappings.
	 */
	private final List<PartialSurrogateFunction> functions;

	/**
	 * Property specification of the input of the complete surrogate function.
	 */
	private final Space inputSpecification;

	/**
	 * Property specification of the output of the complete surrogate function.
	 */
	private final Space outputSpecification;

	/**
	 * A map storing the indices of all property specifications in the output properties.
	 */
	private final Map<PropertySpecification, Integer> indices = new HashMap<>();

	/**
	 * Creates a new surrogate function for the combined functions.
	 *
	 * @param functions The chain of combined functions.
	 */
	public SurrogateFunction(final @NonNull List<PartialSurrogateFunction> functions) {
		this.functions = functions;
		this.inputSpecification = SurrogateConfiguration.getInputs(functions);
		this.outputSpecification = SurrogateConfiguration.getOutputs(functions);
	}

	public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
		for(final PartialSurrogateFunction entry : functions) {
			entry.apply(input, output);
		}
	}
}

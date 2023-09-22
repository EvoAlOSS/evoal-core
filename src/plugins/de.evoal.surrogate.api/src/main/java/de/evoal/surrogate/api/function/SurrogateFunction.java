package de.evoal.surrogate.api.function;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * A surrogate function replaces the actual function used in the optimisation
 * if the actual function is too expensive to calculate or even unknown. A
 * surrogate function transforms input properties into output properties
 * according to a known oder learned function.
 *
 * A surrogate function may consist of several chained combined functions (c.f.,
 * {@link FunctionCombiner}. The surrogate function then takes the input and
 * calculates an output' using a combined function. The output' is then used
 * as input for the next combined function in the chain. The output of the last
 * combined function is the result of the surrogate function.
 */
@Data
public final class SurrogateFunction implements MappingFunction {
	/**
	 * The chain of property mappings.
	 */
	private final List<FunctionCombiner> mappings;

	/**
	 * Property specification of the input of the complete surrogate function.
	 */
	private final PropertiesSpecification inputSpecification;

	/**
	 * Property specification of the output of the complete surrogate function.
	 */
	private final PropertiesSpecification outputSpecification;

	/**
	 * Creates a new surrogate function for the combined functions.
	 *
	 * @param mappings The chain of combined functions.
	 */
	public SurrogateFunction(final @NonNull List<FunctionCombiner> mappings) {
		this.mappings = mappings;
		this.inputSpecification = mappings.get(0).getInputSpecification();
		this.outputSpecification = mappings.get(mappings.size() - 1).getOutputSpecification();
	}

	@Override
	public Properties apply(final Properties input) {
		Properties current = input;

		for(final MappingFunction function : mappings) {
			current = function.apply(current);
		}

		return current;
	}
}

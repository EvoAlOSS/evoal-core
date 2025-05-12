package de.evoal.surrogate.api.function;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A surrogate function replaces the actual function used in the optimisation
 * if the actual function is too expensive to calculate or even unknown. A
 * surrogate function transforms input properties into output properties
 * according to a known oder learned function.<br/>
 *
 * A surrogate function may consist of several chained combined functions (c.f.,
 * {@link FunctionCombiner}. The surrogate function then takes the input and
 * calculates an output' using a combined function. The output' is then used
 * as input for the next combined function in the chain. The output of the last
 * combined function is the result of the surrogate function.
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
	private final PropertiesSpecification inputSpecification;

	/**
	 * Property specification of the output of the complete surrogate function.
	 */
	private final PropertiesSpecification outputSpecification;

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
		this.inputSpecification = PropertiesSpecification.builder()
														 .add(SurrogateConfiguration.getInputs(functions).stream())
														 .build();
		this.outputSpecification = PropertiesSpecification.builder()
														  .add(SurrogateConfiguration.getOutputs(functions).stream())
													  	  .build();

		for(final PartialSurrogateFunction function : functions) {
			for(final PropertySpecification specification : function.getOutputProperty().getProperties())   {
				indices.put(specification, outputSpecification.indexOf(specification));
			}
		}
	}

	public Properties apply(final Properties input) {
		final Properties output = new Properties(outputSpecification);

		for(final PartialSurrogateFunction entry : functions) {
			final Object [] values = entry.apply(input);

			for(int index = 0; index < values.length; ++index) {
				output.set(indices.get(entry.getOutputProperty().getProperties().get(index)), values[index]);
			}
		}

		return output;
	}
}

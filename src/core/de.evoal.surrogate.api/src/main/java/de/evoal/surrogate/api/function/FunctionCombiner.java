package de.evoal.surrogate.api.function;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class takes several {@link PartialSurrogateFunction} and combines them to a
 * single mapping function. Each partial surrogate function may take a subset of the
 * input properties and generate a subset of the output properties.
 */
public class FunctionCombiner implements MappingFunction {
	/**
	 * Specification of the input vector.
	 */
	private final PropertiesSpecification inputSpecification;

	/**
	 * Specification of the output vector.
	 */
	private final PropertiesSpecification outputSpecification;

	/**
	 * All regression functions for calculating the output.
	 */
	private final List<PartialSurrogateFunction> functions;

	/**
	 * A map storing the indices of all property specifications in the output properties.
	 */
	private final Map<PropertySpecification, Integer> indices = new HashMap<>();

	public FunctionCombiner(final List<PartialSurrogateFunction> functions, final PropertiesSpecification input, final PropertiesSpecification output) {
		this.inputSpecification = input;
		this.outputSpecification = output;

		for(final PartialSurrogateFunction function : functions) {
			for(final PropertySpecification specification : function.getOutputProperty().getProperties())   {
				indices.put(specification, outputSpecification.indexOf(specification));
			}
		}

		this.functions = functions;
	}

	@Override
	public Properties apply(final Properties input) {
		final Properties output = new Properties(outputSpecification);

		for(final PartialSurrogateFunction entry : functions) {
			final double [] values = entry.apply(input);

			for(int index = 0; index < values.length; ++index) {
				output.set(indices.get(entry.getOutputProperty().getProperties().get(index)), values[index]);
			}
		}

		return output;
	}

	@Override
	public PropertiesSpecification getInputSpecification() {
		return inputSpecification;
	}

	/**
	 * This function gives access to
	 */
	public PartialSurrogateFunction[] getFunctions() {
		return functions.toArray(new PartialSurrogateFunction[functions.size()]);
	}

	@Override
	public PropertiesSpecification getOutputSpecification() {
		return outputSpecification;
	}
}

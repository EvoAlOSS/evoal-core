package de.evoal.surrogates.neural;


import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.factory.Nd4j;

public class SimpleNeuralNetwork extends AbstractPartialSurrogateFunction {

	/**
	 * Indices of input data
	 */
	private final int[] indices;

	/**
	 * Actual SVR
	 */
	private final MultiLayerNetwork nn;

	public SimpleNeuralNetwork(final PartialFunctionConfiguration configuration, final MultiLayerNetwork nn, final PropertiesSpecification input, final PropertiesSpecification actualInput, final PropertiesSpecification output) {
		super(configuration, NeuralNetworkHelper.toParameters(nn), input, output);
		
		this.indices = input.getProperties().stream().mapToInt(p -> actualInput.indexOf(p)).toArray();

		this.nn = nn;
	}

	@Override
	public double [] apply(final Properties input) {
		final double [] data = new double[indices.length];

		for(int i = 0; i < data.length; ++i) {
			data[i] = input.get(indices[i]);
		}

		return nn.output(Nd4j.create(new double[][]{data})).toDoubleVector();
	}
}

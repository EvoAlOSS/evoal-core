package de.evoal.surrogates.neural;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import lombok.extern.slf4j.Slf4j;
import org.deeplearning4j.datasets.iterator.DoublesDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.evaluation.classification.Evaluation;
import org.nd4j.evaluation.classification.ROCMultiClass;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.nio.channels.NotYetConnectedException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Dependent
@Named("neural-network")
@Slf4j
public class SimpleNeuralNetworkFactory extends AbstractPartialSurrogateFunctionFactory {
	@Override
	protected PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput, final PropertiesPairStreamSupplier provider) {
		log.info("Calculate neural network from {} to {}.", requiredInput, producedOutput);
		
		final Map<String, Object> params = parameters.stream()
													 .collect(Collectors.toMap(Parameter::getName, Parameter::getValue));

		final MultiLayerNetwork nn = createNeuralNetwork(params);
		final DataSetIterator iterator = new DoublesDataSetIterator(new EvoalDataSetIterator(provider), 5);

		nn.fit(iterator, 1000);


		Evaluation eval = nn.evaluate(iterator);
		System.out.println("acc ->" + eval.accuracy());
		System.out.println(eval.precision());
		System.out.println(eval.recall());

		// ROC for Area Under Curve on multi-class datasets (not binary classes)
		ROCMultiClass [] roc = nn.doEvaluation(iterator, new ROCMultiClass());
		for(int i = 0; i < roc.length; ++i) {
			System.out.println("[i] -> " + roc[i].calculateAverageAUC());
			System.out.println("[i] -> " + roc[i].calculateAverageAUCPR());
		}

		return new SimpleNeuralNetwork(configuration, nn, requiredInput, actualInput, producedOutput);
	}

	private MultiLayerNetwork createNeuralNetwork(final Map<String, Object> parameters) {
		return new NeuralNetworkConfigurator(parameters).create();
	}

	@Override
	protected PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput) {
		throw new NotYetConnectedException();
		/*
		final KernelMachine<double []> regression = KernelHelper.fromParameters(configuration.getParameters(), configuration.getFunctionParameters());

		final double margin = configuration.getParameters()
										   .stream()
										   .filter(p -> "soft-margin".equals(p.getName()))
										   .map(Parameter::getValue)
										   .map(Double.class::cast)
										   .findFirst()
										   .orElse(0.1);

		return new KernelBasedSVRFunction(configuration, regression, requiredInput, actualInput, producedOutput, margin);
		 */
	}
}

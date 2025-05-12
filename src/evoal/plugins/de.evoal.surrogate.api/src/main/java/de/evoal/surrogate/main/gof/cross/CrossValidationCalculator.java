package de.evoal.surrogate.main.gof.cross;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.main.internal.SurrogateFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

/**
 * Calculates cross validation values.
 */
@Dependent
@Named("de.evoal.surrogate.ml.cross-validation")
@Slf4j
public class CrossValidationCalculator implements SurrogateInformationCalculator {

	/**
	 * The surrogate function to use.
	 */
	private SurrogateFunction function;

	/**
	 * The number of groups for the validation.
	 */
	private int k = 1;

	/**
	 * The surrogate configuration for adding the calculated values
	 */
	private SurrogateConfiguration originalConfiguration;

	/**
	 * The training data used
 	 */
	private CrossValidationPropertiesStreamSupplier trainingSupplier;

	@Override
	public void execute() {
 		log.info("calculating of {}-fold cross validation of surrogate function :", k);

		for(int i = 0; i < originalConfiguration.getFunctions().size(); ++i) {
			final SurrogateConfiguration trainingConfiguration = SurrogateConfiguration.from(originalConfiguration);

			final PartialFunctionConfiguration originalMapping = originalConfiguration.getFunctions().get(i);
			final PartialFunctionConfiguration trainingMapping = trainingConfiguration.getFunctions().get(i);

			validateMapping(originalMapping, trainingMapping);
		}
	}

	private void validateMapping(final PartialFunctionConfiguration originalMapping, final PartialFunctionConfiguration trainingMapping) {
		log.info("Calculating cross validation for mapping {}.", originalMapping.getName());
		final int rowLength = originalMapping.getOutputDimensions().size() + 2;

		//final AsciiTable table = new AsciiTable();
		//table.addRule();
		//final Object [] cvLabels = originalMapping.getOutputDimensions().toArray();
		//final Object [] header = new String [rowLength];
		//header[0] = "";
		//header[rowLength - 1] = "Summe";
		//System.arraycopy(cvLabels, 0, header, 1, cvLabels.length);
		//table.addRow(header);
		//table.addRule();

		// detail list for all input target
		double [][] data = new double[rowLength - 1][k];

		final PropertiesSpecification mappingInput = originalMapping.getInputData();
		final PropertiesSpecification mappingOutput = originalMapping.getOutputData();

		final PropertiesSpecification [] fInputs = new PropertiesSpecification [mappingInput.size()];
		final PropertiesSpecification [] fOutputs = new PropertiesSpecification[mappingOutput.size()];

		for(int partition = 1; partition <= k; ++partition) {
			trainingSupplier.setPartition(partition);

			//final Object[] tableData = new Object[rowLength];
			//tableData[0] = "Partition " + partition;

			final PartialFunctionConfiguration fConfig = PartialFunctionConfiguration.from(originalMapping);

			final PropertiesSpecification fInput = fConfig.getInputData();
			final PropertiesSpecification fOutput = fConfig.getOutputData();
			final PartialSurrogateFunction mapping = SurrogateFactory.create(fConfig, fInput, fOutput, trainingSupplier);

			// sum of prediction errors in this partition for each output property
			final double[] correctness = new double[fOutput.size()];
			new PropertiesBasedPropertiesPairStreamSupplier(trainingSupplier.getValidationStream(), fInput, fOutput)
							.get()
							.forEach(pair -> {
								final Properties source = pair.getFirst();
								final Properties predicted = new Properties(fOutput, mapping.apply(source));
								final Properties calculated = pair.getSecond();

								for (int cvi = 0; cvi < calculated.size(); ++cvi) {
									//correctness[cvi] = correctness[cvi] + Math.abs((calculated.get(cvi) - predicted.get(cvi)) / calculated.get(cvi));
									correctness[cvi] = correctness[cvi] + Math.abs(((Number)calculated.get(cvi)).doubleValue() - ((Number)predicted.get(cvi)).doubleValue());
								}
							});

			// relate cumulative errors to partition size (number of test candidates)
			for (int i = 0; i < correctness.length; ++i) {
				correctness[i] = correctness[i] / trainingSupplier.getValidationStream().get().count();
			}

			for (int i = 0; i < correctness.length; ++i) {
				// copy cumulative error to output table
				//tableData[1 + mappingOutput.indexOf(fOutput.getProperties().get(i))] = String.format("%.4f", correctness[i]);
				// copy cumulative error to data table
				data[mappingOutput.indexOf(fOutput.getProperties().get(i))][partition - 1] = correctness[i];
			}

			// calculate sum of errors for partition
			final int pi = partition;
			data[data.length - 1][partition - 1] = Arrays.stream(data).mapToDouble(a -> a[pi - 1]).sum();
			//data[correctness.length][partition] = Arrays.stream(correctness).sum();
			//tableData[data.length] = String.format("%.4f", data[data.length - 1][partition]);

			//table.addRow(tableData);
		}

		//table.addRule();

		// calculate last row
		// Object [] tableData = new Object[rowLength];
		//tableData[0] = "Ø / s";
		for(int i = 0; i < data.length; ++i) {
			double avg = new Mean().evaluate(data[i]);
			double sd = new StandardDeviation().evaluate(data[i]);

			//tableData[i+1] = String.format("%.4f / %.4f", avg, sd);

			if(i != data.length - 1) {
				attach(originalMapping,
				       mappingOutput.getProperties().get(i),
					   new CrossValidationData(k, avg, k, sd));
			}
		}
		//table.addRow(tableData);
		//table.addRule();
		//System.out.println(table.render(140));
	}

	private void attach(final PartialFunctionConfiguration config, final PropertySpecification propertySpecification, final CrossValidationData data) {
		if(config.getOutputDimensions().contains(propertySpecification.name())) {
			data.attachTo(config, propertySpecification.name());
		}
	}

	@Override
	public String toString() {
		return "cross validation";
	}

	@Override
	public void configure(final SurrogateFunction function, final SurrogateConfiguration config, final List<Object> parameters, final PropertiesStreamSupplier trainingData) {
		Requirements.requireSize(parameters, 1);
		Requirements.requireType(parameters, 0, Integer.class);
		Requirements.requireNotNull(function);
		Requirements.requireNotNull(config);

		k = (Integer)parameters.get(0);
		this.function = function;
		this.originalConfiguration = config;
		trainingSupplier = new CrossValidationPropertiesStreamSupplier(trainingData, k);
	}
}

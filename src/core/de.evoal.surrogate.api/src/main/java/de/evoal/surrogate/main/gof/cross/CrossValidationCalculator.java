package de.evoal.surrogate.main.gof.cross;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.FunctionCombinerConfiguration;
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
@Named("cross-validation")
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

		for(int i = 0; i < originalConfiguration.getMappings().size(); ++i) {
			final SurrogateConfiguration trainingConfiguration = SurrogateConfiguration.from(originalConfiguration);

			final FunctionCombinerConfiguration originalMapping = originalConfiguration.getMappings().get(i);
			final FunctionCombinerConfiguration trainingMapping = trainingConfiguration.getMappings().get(i);

			validateMapping(originalMapping, trainingMapping);
		}
	}

	private void validateMapping(final FunctionCombinerConfiguration originalMapping, final FunctionCombinerConfiguration trainingMapping) {
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

		final PropertiesSpecification mappingInput = PropertiesSpecification.builder()
																			.add(originalMapping.getInputDimensions().stream())
																			.build();
		final PropertiesSpecification mappingOutput = PropertiesSpecification.builder()
																			 .add(originalMapping.getOutputDimensions().stream())
																			 .build();

		final PropertiesSpecification [] fInputs = new PropertiesSpecification [originalMapping.getFunctions().size()];
		final PropertiesSpecification [] fOutputs = new PropertiesSpecification[originalMapping.getFunctions().size()];

		for(int partition = 1; partition <= k; ++partition) {
			trainingSupplier.setPartition(partition);

			//final Object[] tableData = new Object[rowLength];
			//tableData[0] = "Partition " + partition;

			for(int func = 0; func < originalMapping.getFunctions().size(); ++func) {
				final PartialFunctionConfiguration fConfig = PartialFunctionConfiguration.from(trainingMapping.getFunctions()
																			.get(func));

				final PropertiesSpecification fInput = PropertiesSpecification.builder()
																			  .add(fConfig.getInputDimensions().stream())
																			  .build();
				final PropertiesSpecification fOutput = PropertiesSpecification.builder()
																			   .add(fConfig.getOutputDimensions().stream())
																			   .build();


				final PartialSurrogateFunction mapping = SurrogateFactory.create(fConfig, fInput, fOutput, trainingSupplier);

				// sum of prediction errors in this partition for each output property
				final double[] correctness = new double[fOutput.size()];
				trainingSupplier.getValidationStream()
								.get()
						  		.forEach(source -> {
									final Properties predicted = new Properties(fOutput, mapping.apply(source));
									final Properties calculated = Properties.create(fOutput, source);

									for (int cvi = 0; cvi < calculated.size(); ++cvi) {
										//correctness[cvi] = correctness[cvi] + Math.abs((calculated.get(cvi) - predicted.get(cvi)) / calculated.get(cvi));
										correctness[cvi] = correctness[cvi] + Math.abs(calculated.get(cvi) - predicted.get(cvi));
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

	private void attach(final FunctionCombinerConfiguration config, final PropertySpecification propertySpecification, final CrossValidationData data) {
		for(final PartialFunctionConfiguration fConfig : config.getFunctions()) {
			if(fConfig.getOutputDimensions().contains(propertySpecification.name())) {
				data.attachTo(fConfig, propertySpecification.name());
				break;
			}
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

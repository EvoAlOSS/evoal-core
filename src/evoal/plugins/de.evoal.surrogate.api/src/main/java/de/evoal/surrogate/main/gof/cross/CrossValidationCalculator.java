package de.evoal.surrogate.main.gof.cross;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.ModelWriter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;

/**
 * Calculates cross validation values.
 */
@Dependent
@Named("de.evoal.surrogate.ml.cross-validation")
@Slf4j
public class CrossValidationCalculator /* extends SurrogateInformationCalculator */{

	/**
	 * The surrogate function to use.
	 */
	private ModelFunction function;

	/**
	 * The number of groups for the validation.
	 */
	private int k = 1;

	/**
	 * For appending the fitness values
	 */
	private ModelWriter writer;

	/**
	 * The training data used
 	 */
	private CrossValidationEObjectStreamSupplier trainingSupplier;
	private EObjectPairStreamSupplier trainingData;

//	@Override
	public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
		/*
		log.warn("Currently, cross validation is not implemented.");
		k = (Integer)arguments[0];
		trainingSupplier = new CrossValidationEObjectStreamSupplier(trainingData, k);

 		log.info("Calculating of {}-fold cross validation of surrogate function :", k);

		for(int i = 0; i < originalConfiguration.getFunctions().size(); ++i) {
			final SurrogateConfiguration trainingConfiguration = SurrogateConfiguration.from(originalConfiguration);

			final SurrogateConfiguration originalMapping = originalConfiguration.getFunctions().get(i);
			final SurrogateConfiguration trainingMapping = trainingConfiguration.getFunctions().get(i);

			validateMapping(originalMapping, trainingMapping);
		}
*/
		return Optional.empty();
	}
/*
	private void validateMapping(final SurrogateConfiguration originalMapping, final SurrogateConfiguration trainingMapping) {
		log.info("Calculating cross validation for mapping {}.", originalMapping.getName());
		final int rowLength = originalMapping.getOutputFeatures().size() + 2;

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

		//final Space mappingInput = originalMapping.getInputData();
		//final Space mappingOutput = originalMapping.getOutputData();
/*
		for(int partition = 1; partition <= k; ++partition) {
			trainingSupplier.setPartition(partition);

			//final Object[] tableData = new Object[rowLength];
			//tableData[0] = "Partition " + partition;

			final SurrogateConfiguration fConfig = SurrogateConfiguration.from(originalMapping);

			final Space fInput = fConfig.getInputData();
			final Space fOutput = fConfig.getOutputData();
			if(true)
				throw new IllegalStateException();
			final PartialSurrogateFunction mapping = null; //SurrogateFactory.create(fConfig, EObjectPairStreamFactory.createFromList(fInput, fOutput, trainingSupplier));

			// sum of prediction errors in this partition for each output property
			final double[] correctness = new double[fOutput.size()];
			EObjectPairStreamFactory.createFromList(fInput, fOutput, trainingSupplier.getValidationStream())
							.get()
							.forEach(pair -> {
								final TypedEObject source = pair.getFirst();
								final TypedEObject calculated = pair.getSecond();

								final TypedEObject predicted = new TypedEObject(fOutput.getEClass());
							 	mapping.apply(source, predicted);

							 	int index = 0;
								for(final EStructuralFeature feature : fOutput) {
									//correctness[cvi] = correctness[cvi] + Math.abs((calculated.get(cvi) - predicted.get(cvi)) / calculated.get(cvi));
									correctness[index] = correctness[index] + Math.abs(calculated.eGetAsDouble(feature) - predicted.eGetAsDouble(feature));
								}
							});

			// relate cumulative errors to partition size (number of test candidates)
			for (int i = 0; i < correctness.length; ++i) {
				correctness[i] = correctness[i] / trainingSupplier.getValidationStream().get().count();
			}

			int index = 0;
			for(final EStructuralFeature feature : fOutput) {
				// copy cumulative error to output table
				//tableData[1 + mappingOutput.indexOf(fOutput.getProperties().get(i))] = String.format("%.4f", correctness[i]);
				// copy cumulative error to data table
				data[index][partition - 1] = correctness[index];
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
/*
			if(i != data.length - 1) {
				attach(originalMapping,
				       mappingOutput.getProperties().get(i),
					   new CrossValidationData(k, avg, k, sd));
			}* /
		}
		*/
		//table.addRow(tableData);
		//table.addRule();
		//System.out.println(table.render(140));
	/*
	}
/*
	private void attach(final EStructuralFeature feature, final Space specification, final CrossValidationData data) {
		if(config.getOutputDimensions().contains(propertySpecification.name())) {
			data.attachTo(config, propertySpecification.name());
		}
	}
*/
	@Override
	public String toString() {
		return "cross validation";
	}
}

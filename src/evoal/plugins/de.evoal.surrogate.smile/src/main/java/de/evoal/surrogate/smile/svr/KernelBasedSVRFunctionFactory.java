package de.evoal.surrogate.smile.svr;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import org.eclipse.emf.ecore.EStructuralFeature;

import smile.base.svm.SVR;
import smile.math.kernel.MercerKernel;
import smile.regression.KernelMachine;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;


@Slf4j
public abstract class KernelBasedSVRFunctionFactory extends AbstractPartialSurrogateFunctionFactory {
	/**
	 * Function to create the SVR kernel.
	 */
	private final Function<Map<String, Object>, MercerKernel<double[]>> toKernel;

	private final String nameOfKernel;

	public KernelBasedSVRFunctionFactory(final Function<Map<String, Object>, MercerKernel<double []>> toKernel, final String nameOfKernel) {
		this.toKernel = toKernel;
		this.nameOfKernel = nameOfKernel;
	}

	@Override
	protected PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final Space input, final Space output, final EObjectPairStreamSupplier provider) {
		log.info("Calculate SVR surrogate from {} to {}.", input, output);

		Requirements.requireSizeGreaterThan(input, 0);
		Requirements.requireSize(output, 1);

		// do sanity checks and log information for the user
		final Function<TypedEObject, double []> sourceConverter = createConverter(input);
		final Function<TypedEObject, double []> targetConverter = createConverter(output);

		final List<double []> sources = new ArrayList<>();
		final List<Double> targets = new ArrayList<>();

		provider.get()
				.forEach(p -> {
					sources.add(sourceConverter.apply(p.getFirst()));
					targets.add(targetConverter.apply(p.getSecond())[0]);
				});

		log.info("Using {} points for regression.", sources.size());

		double [][] sourceArray = sources.toArray(new double [][] {});
		double [] targetArray = targets.stream().mapToDouble(Double.class::cast).toArray();

		double [] sourceMeans = new double [input.size()];
		double [] sourceSD = new double [input.size()];

		double [] targetMean = new double [1];
		double [] targetSD = new double [1];

		for(int featureIndex = 0; featureIndex < input.size(); ++featureIndex) {
			double [] values = new double [sourceArray.length];
			for(int individualIndex = 0; individualIndex < sourceArray.length; ++individualIndex) {
				values[individualIndex] = sourceArray[individualIndex][featureIndex];
			}

			calculateStatisticalInformation(values, featureIndex, sourceMeans, sourceSD);
		}
		calculateStatisticalInformation(targetArray, 0, targetMean, targetSD);


		// start scaling of trainings data
		for(int individualIndex = 0; individualIndex < sourceArray.length; ++individualIndex) {
			for (int propertyIndex = 0; propertyIndex < input.size(); ++propertyIndex) {
				sourceArray[individualIndex][propertyIndex] = (sourceArray[individualIndex][propertyIndex] - sourceMeans[propertyIndex]) / sourceSD[propertyIndex];

			}
			targetArray[individualIndex] = (targetArray[individualIndex] - targetMean[0]) / targetSD[0];
		}


		final Map<String, Object> params = parameters.stream()
													 .collect(Collectors.toMap(Parameter::getName, Parameter::getValue));

		final double epsilon = ((Number)params.get(KernelHelper.EPSILON_PARAMETER)).doubleValue();
		final double margin = ((Number)params.get(KernelHelper.SOFT_MARGIN_PARAMETER)).doubleValue();
		final double tolerance = ((Number)params.get(KernelHelper.TOLERANCE_PARAMETER)).doubleValue();

		final SVR<double []> svr = new SVR<>(toKernel.apply(params), epsilon, margin, tolerance);
		final KernelMachine<double []> regression = svr.fit(sourceArray, targetArray);

		return new KernelBasedSVRFunction(configuration, regression, nameOfKernel, input, output, margin, sourceMeans, sourceSD, targetMean, targetSD);
	}

	private void calculateStatisticalInformation(final double[] values, final int index, final double[] means, final double[] sds) {
		means[index] = new Mean().evaluate(values, 0, values.length);
		sds[index] = new StandardDeviation().evaluate(values);
	}

	/**
	 * Creates a data converter function based on the given properties specification.
	 */
	private Function<TypedEObject, double[]> createConverter(final Space specification) {
		final Function<TypedEObject, Double>[] converters = new Function[specification.size()];

		int index = 0;
		for(final EStructuralFeature feature : specification) {
			converters[index++] = obj -> obj.eGetAsDouble(feature);
		}

		return p -> {
			double [] values = new double [converters.length];
			for(int i = 0; i < values.length; ++i) {
				values[i] = converters[i].apply(p);
			}

			return values;
		};
	}
}

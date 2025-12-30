package de.evoal.surrogate.smile.svr;

import lombok.extern.slf4j.Slf4j;

import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import org.eclipse.emf.ecore.EStructuralFeature;

import smile.base.svm.SVR;
import smile.regression.KernelMachine;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.training.AbstractModelLearner;
import de.evoal.surrogate.api.training.ModelLearner;


@Slf4j
public abstract class AbstractKernelLerner extends AbstractModelLearner {
	/**
	 * The training data to use.
	 */
	private final List<TypedEObject> trainingData = new ArrayList<>();

	@Inject
	private AttributeHelper helper;
	private double epsilon;
    protected double margin;
	private double sigma;
	private double tolerance;
    protected KernelMachine<double[]> regression;
	protected double[] sourceMeans;
    protected double[] sourceSD;
    protected double[] targetMean;
    protected double[] targetSD;
    protected final Map<String, Object> params = new HashMap<>();

	@Override
	public void add(final TypedEObject features) {
		final TypedEObject copy = features.copy();

		trainingData.add(copy);
	}

	@Override
	public ModelLearner init(final Instance configuration) throws InitializationException {
		super.init(configuration);

		epsilon = helper.lookup(configuration, KernelHelper.EPSILON_PARAMETER);
		margin = helper.lookup(configuration, KernelHelper.SOFT_MARGIN_PARAMETER);
		sigma = helper.lookup(configuration, KernelHelper.SIGMA_PARAMETER);
		tolerance = helper.lookup(configuration, KernelHelper.TOLERANCE_PARAMETER);

		return this;
	}

	@Override
	public void learn() {
		log.info("Calculate SVR surrogate from {} to {}.", inputFeatures, outputFeatures);

		Requirements.requireSizeGreaterThan(inputFeatures, 0);
		Requirements.requireSize(outputFeatures, 1);

		// do sanity checks and log information for the user
		final Function<TypedEObject, double []> sourceConverter = createConverter(inputFeatures);
		final Function<TypedEObject, double []> targetConverter = createConverter(outputFeatures);

		final List<double []> sources = new ArrayList<>();
		final List<Double> targets = new ArrayList<>();

		trainingData
				.forEach(p -> {
					sources.add(sourceConverter.apply(p));
					targets.add(targetConverter.apply(p)[0]);
				});

		log.info("Using {} points for regression.", sources.size());

		double [][] sourceArray = sources.toArray(new double [][] {});
		double [] targetArray = targets.stream().mapToDouble(Double.class::cast).toArray();

		sourceMeans = new double [inputFeatures.size()];
		sourceSD = new double [inputFeatures.size()];

		targetMean = new double [1];
		targetSD = new double [1];

		for(int featureIndex = 0; featureIndex < inputFeatures.size(); ++featureIndex) {
			double [] values = new double [sourceArray.length];
			for(int individualIndex = 0; individualIndex < sourceArray.length; ++individualIndex) {
				values[individualIndex] = sourceArray[individualIndex][featureIndex];
			}

			calculateStatisticalInformation(values, featureIndex, sourceMeans, sourceSD);
		}
		calculateStatisticalInformation(targetArray, 0, targetMean, targetSD);


		// start scaling of trainings data
		for(int individualIndex = 0; individualIndex < sourceArray.length; ++individualIndex) {
			for (int propertyIndex = 0; propertyIndex < inputFeatures.size(); ++propertyIndex) {
				sourceArray[individualIndex][propertyIndex] = (sourceArray[individualIndex][propertyIndex] - sourceMeans[propertyIndex]) / sourceSD[propertyIndex];

			}
			targetArray[individualIndex] = (targetArray[individualIndex] - targetMean[0]) / targetSD[0];
		}

		params.put(KernelHelper.EPSILON_PARAMETER, epsilon);
		params.put(KernelHelper.SOFT_MARGIN_PARAMETER, margin);
		params.put(KernelHelper.SIGMA_PARAMETER, sigma);
		params.put(KernelHelper.TOLERANCE_PARAMETER, tolerance);

		final SVR<double []> svr = new SVR<>(KernelHelper.toLinearKernel(params), epsilon, margin, tolerance);
		regression = svr.fit(sourceArray, targetArray);
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
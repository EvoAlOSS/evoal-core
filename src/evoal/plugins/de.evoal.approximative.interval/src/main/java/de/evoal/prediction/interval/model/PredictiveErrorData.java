package de.evoal.prediction.interval.model;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.FunctionCombiner;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.smile.KernelBasedSVRFunction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.distribution.NormalDistribution;

import org.apache.commons.math3.util.Pair;
import smile.math.matrix.Matrix;

public final class PredictiveErrorData {
    private final double [] predictionErrors;
    private final int numberOfPoints;
    private final double[] calculatedValues;
    private Matrix independentSmoothingMatrix;
    private Matrix independentSmoothingVector;
    private double[] delta;
    private double[] sigma;
    private double[][] trainingPoints;
    final NormalDistribution distribution = new NormalDistribution();

    public PredictiveErrorData(final int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
        predictionErrors = new double[numberOfPoints];
        calculatedValues = new double[numberOfPoints];
    }

    public PredictiveErrorData(final PartialFunctionConfiguration configuration) {
        final Map<String, Object> parameterMap = toMap(configuration.getState());

        sigma = (double[]) parameterMap.get("prediction-error-sigma");
        predictionErrors = (double[]) parameterMap.get("prediction-error-epsilon");
        trainingPoints = (double[][]) parameterMap.get("prediction-error-training");
        calculatedValues = (double[]) parameterMap.get("prediction-error-calculated");
        delta = (double[])parameterMap.get("prediction-error-delta");
        independentSmoothingVector = (Matrix)parameterMap.get("prediction-error-isv");
        independentSmoothingMatrix = (Matrix)parameterMap.get("prediction-error-ism");

        numberOfPoints = predictionErrors.length;
    }

    public double [] getPredictionErrors() {
        return predictionErrors;
    }

    public void setPredictionError(final int index, final double predictionError) {
        this.predictionErrors[index] = predictionError;
    }

    public void setCalculatedValue(final int index, final double calculatedValue) {
        this.calculatedValues[index] = calculatedValue;
    }

    public void attachTo(final PartialFunctionConfiguration regression, final String propertyName) {
        attach(regression, propertyName, "prediction-error-sigma", sigma);
        attach(regression, propertyName, "prediction-error-epsilon", predictionErrors);
        attach(regression, propertyName, "prediction-error-training", trainingPoints);
        attach(regression, propertyName, "prediction-error-calculated", calculatedValues);
        attach(regression, propertyName, "prediction-error-delta", delta);
        attach(regression, propertyName, "prediction-error-isv", independentSmoothingVector);
        attach(regression, propertyName, "prediction-error-ism", independentSmoothingMatrix);
    }

    private void attach(final PartialFunctionConfiguration regression, final String propertyName, final String name, final Object value) {
        final Parameter parameter = Parameter.builder()
                                             .name(name)
                                             .value(value)
                                             .build();

        regression.addOutputParameter(propertyName, parameter);
    }

    public void setIndependentSmoothingMatrix(final Matrix matrix) {
        this.independentSmoothingMatrix = matrix;
    }

    public void setIndependentSmoothingVector(final Matrix independentSmoothingVector) {
        this.independentSmoothingVector = independentSmoothingVector;
    }

    public void setDelta(final double[] delta) {
        this.delta = delta;
    }

    public void setSigma(final double[] sigma) {
        this.sigma = sigma;
    }

    public static Map<String, Object> toMap(final List<Parameter> parameters) {
        return parameters.stream().collect(Collectors.toMap(Parameter::getName, Parameter::getValue));
    }

    public Pair<Double, Double> calculateBoundaries(final Properties candidate, final int regressionIndex, final SurrogateFunction function, final double confidence) {
        final Properties predicted = function.apply(candidate);

        Requirements.requireSize(function.getMappings(), 1);
        final FunctionCombiner combiner = function.getMappings().get(0);

        final KernelBasedSVRFunction regression = (KernelBasedSVRFunction) combiner.getFunctions()[regressionIndex];

        // Calculating Ω
        final Matrix omega = new Matrix(1, numberOfPoints);
        IntStream.range(0, trainingPoints.length)
                 .forEach(i -> {
                     double [] v1 = new double[candidate.size()];
                     double [] v2 = new double[candidate.size()];

                     for(int j = 0; j < v1.length; ++j) {
                         v1[j] = candidate.getAsDouble(j);
                         v2[j] = trainingPoints[i][j];
                     }

                     final double kv = regression.getRegression().kernel().k(v1, v2);

                     omega.set(0, i, kv);
                 });

        final Matrix candidateSmoothing = omega.mm(independentSmoothingMatrix)
                                               .add(1.0, independentSmoothingVector);
        

        // calculate bias
        double bias = 0.0;
        for(int i = 0; i < numberOfPoints; ++i) {
            bias += candidateSmoothing.get(0, i) * calculatedValues[i];
        }

        bias -= predicted.getAsDouble(regressionIndex);

        // calculate variance
        double variance = 0.0;
        for(int i = 0; i < sigma.length; ++i) {
        	//variance += candidateSmoothing.get(0, i) * sigma[i];
            variance += candidateSmoothing.get(0, i) * sigma[i] * sigma[i] * candidateSmoothing.get(0, i);
        }

        // calculate standard
        double std = 0.0;
        double stdDelta = 1.0;
        for(int i = 0; i < predictionErrors.length; ++i) {
            std += candidateSmoothing.get(0, i) * Math.pow(predictionErrors[i], 2);
            stdDelta += candidateSmoothing.get(0, i) * delta[i];
        }

        final double adjustedStd = std / stdDelta;
        final double quantile = distribution.inverseCumulativeProbability(confidence);
        final double v = quantile * Math.sqrt(adjustedStd + variance);
        final double lower = predicted.getAsDouble(regressionIndex) - bias - v;
        final double upper = predicted.getAsDouble(regressionIndex) - bias + v;

        return new Pair<>(lower, upper);
    }

    public void setTrainingData(final double[][] trainingPoints) {
        this.trainingPoints = trainingPoints;
    }
}

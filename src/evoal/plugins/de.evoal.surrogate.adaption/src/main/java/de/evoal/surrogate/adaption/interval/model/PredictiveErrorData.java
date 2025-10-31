package de.evoal.surrogate.adaption.interval.model;

import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.ModelWriter;
import de.evoal.surrogate.api.io.pson.Parameter;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.Pair;

import org.eclipse.emf.ecore.EStructuralFeature;

import smile.math.matrix.Matrix;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;

@Slf4j
public final class PredictiveErrorData {
    private final static String NAMESPACE = "de.evoal.surrogate.adaption.interval";
    private final static String SIGMA = NAMESPACE + ".prediction-error-sigma";
    private final static String EPSILON = NAMESPACE + ".prediction-error-epsilon";
    private final static String TRAINING = NAMESPACE + ".prediction-error-training";
    private final static String CALCULATED = NAMESPACE + ".prediction-error-calculated";
    private final static String DELTA = NAMESPACE + ".prediction-error-delta";
    private final static String ISV = NAMESPACE + ".prediction-error-isv";
    private final static String ISM = NAMESPACE + ".prediction-error-ism";

    @Getter
    private final double [] predictionErrors;
    private final int numberOfPoints;
    private final double[] calculatedValues;
    @Setter
    private Matrix independentSmoothingMatrix;
    @Setter
    private Matrix independentSmoothingVector;
    @Setter
    private double[] delta;
    @Setter
    private double[] sigma;
    private double[][] trainingPoints;
    final NormalDistribution distribution = new NormalDistribution();

    public PredictiveErrorData(final int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
        predictionErrors = new double[numberOfPoints];
        calculatedValues = new double[numberOfPoints];
    }

    public PredictiveErrorData(final ModelReader reader) {
       final Map<String, Object> parameterMap = toMap(reader.getOutputFeatureInformation(reader.getOutput().iterator().next()));

        parameterMap.keySet().forEach(s -> log.info(" attached parameter: {}", s));

        sigma = (double[]) parameterMap.get(SIGMA);
        predictionErrors = (double[]) parameterMap.get(EPSILON);
        trainingPoints = (double[][]) parameterMap.get(TRAINING);
        calculatedValues = (double[]) parameterMap.get(CALCULATED);
        delta = (double[])parameterMap.get(DELTA);
        independentSmoothingVector = (Matrix)parameterMap.get(ISV);
        independentSmoothingMatrix = (Matrix)parameterMap.get(ISM);

        numberOfPoints = predictionErrors.length;
    }

    public void setPredictionError(final int index, final double predictionError) {
        this.predictionErrors[index] = predictionError;
    }

    public void setCalculatedValue(final int index, final double calculatedValue) {
        this.calculatedValues[index] = calculatedValue;
    }

    public void attachTo(final ModelWriter writer, final EStructuralFeature feature) {
        attach(writer, feature, SIGMA, sigma);
        attach(writer, feature, EPSILON, predictionErrors);
        attach(writer, feature, TRAINING, trainingPoints);
        attach(writer, feature, CALCULATED, calculatedValues);
        attach(writer, feature, DELTA, delta);
        attach(writer, feature, ISV, independentSmoothingVector);
        attach(writer, feature, ISM, independentSmoothingMatrix);
    }

    private void attach(final ModelWriter writer, final EStructuralFeature feature, final String name, final Object value) {
        final Parameter parameter = Parameter.builder()
                .name(name)
                .value(value)
                .build();

        writer.addOutputFeatureInformation(feature, parameter);
    }

    public static Map<String, Object> toMap(final Collection<Parameter> parameters) {
        return parameters.stream().collect(Collectors.toMap(Parameter::getName, Parameter::getValue));
    }

    public Pair<Double, Double> calculateBoundaries(final Properties candidate, final int regressionIndex, final KernelBasedSVRFunction function, final double confidence, final EAnnotationHelper helper) {
        final Space inputSpace = function.getInput();
        final Space outputSpace = function.getOutput();

        final EStructuralFeature oFeature = new ArrayList<>(outputSpace).get(regressionIndex);

        final TypedEObject input = inputSpace.newEObject();
        final TypedEObject output = outputSpace.newEObject();

        inputSpace.forEach(f -> {
                      final DataDescription dd = helper.dataDescriptionOf(f).get();
                      final Object value = candidate.get(new PropertySpecification(dd.getName(), dd));
                      input.eSet(f, value);
                  });

        function.apply(input, output);

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

                    final double kv = function.getRegression()
                            .kernel()
                            .k(v1, v2);

                    omega.set(0, i, kv);
                });

        final Matrix candidateSmoothing = omega.mm(independentSmoothingMatrix)
                .add(1.0, independentSmoothingVector);


        // calculate bias
        double bias = 0.0;
        for(int i = 0; i < numberOfPoints; ++i) {
            bias += candidateSmoothing.get(0, i) * calculatedValues[i];
        }

        bias -= output.eGetAsDouble(oFeature);

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
        final double lower = output.eGetAsDouble(oFeature) - bias - v;
        final double upper = output.eGetAsDouble(oFeature) - bias + v;

        return new Pair<>(lower, upper);
    }

    public void setTrainingData(final double[][] trainingPoints) {
        this.trainingPoints = trainingPoints;
    }
}

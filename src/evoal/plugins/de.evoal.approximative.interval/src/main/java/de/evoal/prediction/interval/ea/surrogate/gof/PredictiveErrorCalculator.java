package de.evoal.prediction.interval.ea.surrogate.gof;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesPair;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.prediction.interval.model.PredictiveErrorData;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.FunctionCombiner;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.smile.KernelBasedSVRFunction;
import org.apache.commons.math3.util.Pair;
import smile.math.matrix.Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Dependent
@Named("predictive-error-gof")
public class PredictiveErrorCalculator implements SurrogateInformationCalculator {
    /**
     * Points for training.
     */
    private final List<PropertiesPair> training = new ArrayList<>();

    /**
     * Prediction function
     */
    private SurrogateFunction function;

    private PropertiesStreamSupplier trainingStream;

    @Override
    public void configure(final SurrogateFunction function, final SurrogateConfiguration config, final List<Object> parameters, final PropertiesStreamSupplier trainingData) {
        this.function = function;
        this.trainingStream = trainingData;
    }

    @Override
    public void execute() {
        for(final FunctionCombiner combiner : function.getMappings()) {
            for(final PartialSurrogateFunction func : combiner.getFunctions()) {
                if(!(func instanceof KernelBasedSVRFunction)) {
                    continue;
                }

                calculateError((KernelBasedSVRFunction)func);
            }
        }
    }

    private void calculateError(final KernelBasedSVRFunction kernelFunction) {
        initializeTrainingData(kernelFunction.getUsedProperties(), kernelFunction.getOutputProperty());

        final Map<PropertySpecification, PredictiveErrorData> result = new HashMap<>();

        final int numberOfPoints = training.size();

        // initialize result map with empty data
        kernelFunction.getOutputProperty()
                      .getProperties()
                      .forEach(p -> result.put(p, new PredictiveErrorData(numberOfPoints)));

        for(int pointIndex = 0; pointIndex < numberOfPoints; ++pointIndex) {
            final Properties source = training.get(pointIndex).getFirst();
            final Properties predicted = new Properties(kernelFunction.getOutputProperty(), kernelFunction.apply(source));
            final Properties calculated = training.get(pointIndex).getSecond();

            for(int i = 0; i < calculated.size(); ++i) {
                final PredictiveErrorData errorData =  result.get(kernelFunction.getOutputProperty().getProperties().get(i));

                errorData.setPredictionError(pointIndex, calculated.getAsDouble(i) - predicted.getAsDouble(i));
                errorData.setCalculatedValue(pointIndex, calculated.getAsDouble(i));
            }
        }

        final KernelBasedSVRFunction regression = kernelFunction;
        final PropertySpecification targetSpec = kernelFunction.getOutputProperty().getProperties().get(0);
        final PredictiveErrorData errorData = result.get(targetSpec);

        final Matrix kernelTrainingsMatrix = new Matrix(numberOfPoints, numberOfPoints);
        final Matrix kernelTrainingsMatrixNotAdded = new Matrix(numberOfPoints, numberOfPoints);
        IntStream.rangeClosed(0, numberOfPoints - 1)
                 .boxed()
                 .flatMap(x -> IntStream.rangeClosed(0, numberOfPoints - 1).mapToObj(y -> new Pair<>(x, y)))
 //                .parallel()
                 .forEach(p -> {
                     final Integer index1 = p.getFirst();
                     final Integer index2 = p.getSecond();
                     double kernelValue = calculateKernelValue(regression, index1, index2);

                     kernelTrainingsMatrixNotAdded.set(index1, index2, kernelValue);
                     kernelTrainingsMatrix.set(index1, index2, index1.equals(index2) ? kernelValue + 1.0 / regression.getGamma() : kernelValue);
                 });


        final Matrix invertedKernelTrainingsMatrix = kernelTrainingsMatrix.inverse();

        final double sumOfTrainingsMatrix = invertedKernelTrainingsMatrix.sum();
        final Matrix regularisationMatrix = new Matrix(numberOfPoints, numberOfPoints, 1/sumOfTrainingsMatrix);
        final Matrix independentSmoothingMatrix = new Matrix(invertedKernelTrainingsMatrix.toArray());

        final Matrix matrix1 = invertedKernelTrainingsMatrix.mm(regularisationMatrix)
                                                         .mm(invertedKernelTrainingsMatrix);
        independentSmoothingMatrix.sub(1.0, matrix1);

        final Matrix independentSmoothingVector = new Matrix(1, numberOfPoints, 1/sumOfTrainingsMatrix)
                                                            .mm(invertedKernelTrainingsMatrix);

        final Matrix trainingsSmoothingMatrix = new Matrix(kernelTrainingsMatrixNotAdded.mm(independentSmoothingMatrix).toArray());



        trainingsSmoothingMatrix.add(1.0, regularisationMatrix.mm(invertedKernelTrainingsMatrix));

        final Matrix tmp1 = trainingsSmoothingMatrix.transpose()
                                                    .mm(trainingsSmoothingMatrix)
                                                    .sub(1.0, trainingsSmoothingMatrix)
                                                    .sub(1.0, trainingsSmoothingMatrix.transpose());

        final double [] delta = tmp1.diag();

        final double [] sigma = new double[numberOfPoints];

        IntStream.rangeClosed(0, numberOfPoints - 1)
                 .parallel()
                 .forEach(ri -> {
                     final double [] row = new double[numberOfPoints];
                     for(int ci = 0; ci < numberOfPoints; ++ci) {
                         row[ci] = trainingsSmoothingMatrix.get(ri, ci);
                     }

                     final double [] errors = errorData.getPredictionErrors();

                     double denominator = 0.0;
                     for(int l = 0; l < row.length; ++l) {
                         denominator += row[l] * Math.pow(errors[l], 2);
                     }

                     double nominator = 1.0;
                     for(int l = 0; l < row.length; ++l) {
                         nominator += row[l] * delta[l];
                     }

                     sigma[ri] = denominator / nominator;
                 });

        final double [][] trainingPoints = new double[training.size()][];
        for(int ti = 0; ti < trainingPoints.length; ++ti) {
            final PropertiesPair trainingPoint = training.get(ti);
            final Properties value = trainingPoint.getFirst();

            trainingPoints[ti] = value.getValuesAsDouble();
        }


        errorData.setTrainingData(trainingPoints);
        errorData.setSigma(sigma);
        errorData.setDelta(delta);
        errorData.setIndependentSmoothingMatrix(independentSmoothingMatrix);
        errorData.setIndependentSmoothingVector(independentSmoothingVector);

        errorData.attachTo(kernelFunction.getConfiguration(), kernelFunction.getOutputProperty().getProperties().get(0).name());
    }

    private void initializeTrainingData(final PropertiesSpecification input, final PropertiesSpecification output) {
        training.clear();

        new PropertiesBasedPropertiesPairStreamSupplier(trainingStream, input, output)
                .get()
                .forEach(training::add);
    }

    private Double calculateKernelValue(final KernelBasedSVRFunction regression, final Integer index1, final Integer index2) {
        final Properties sp1 = training.get(index1).getFirst();
        final Properties sp2 = training.get(index2).getFirst();

        return regression.getRegression()
                .kernel()
                .k(sp1.getValuesAsDouble(), sp2.getValuesAsDouble());
    }

    public String toString() {
        return "prediction error";
    }
}

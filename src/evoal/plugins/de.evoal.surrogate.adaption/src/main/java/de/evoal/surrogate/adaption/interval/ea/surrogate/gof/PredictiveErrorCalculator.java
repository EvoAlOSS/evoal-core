package de.evoal.surrogate.adaption.interval.ea.surrogate.gof;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.surrogate.adaption.interval.model.PredictiveErrorData;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.tensor.DenseMatrix;
import smile.tensor.ScalarType;

import java.util.*;
import java.util.stream.IntStream;

@Slf4j
@Dependent
@Named("de.evoal.surrogate.adaption.interval.ml.predictive-error")
public class PredictiveErrorCalculator extends SurrogateInformationCalculator {
    /**
     * Points for training.
     */
    private final List<EObjectPair> training = new ArrayList<>();

    private EObjectPairStreamSupplier trainingStream;

    @Override
    public Optional<Object> calculate(final InterpreterState context, final Object[] arguments) {
        trainingStream = helper.loadTrainingDataPaired(context);

        final ModelFunction function = functionData.function();

        if(function instanceof KernelBasedSVRFunction svrFunction) {
            calculateError(svrFunction);
        } else {
            log.warn("Cannot calculate predictive error for non-SVR function");
        }

        return Optional.empty();
    }

    private void calculateError(final KernelBasedSVRFunction kernelFunction) {
        initializeTrainingData(kernelFunction.getInput(), kernelFunction.getOutput());

        final Map<EStructuralFeature, PredictiveErrorData> result = new HashMap<>();

        final int numberOfPoints = training.size();

        // initialize result map with empty data
        kernelFunction.getOutput()
                      .forEach(feature -> result.put(feature, new PredictiveErrorData(numberOfPoints)));

        for(int pointIndex = 0; pointIndex < numberOfPoints; ++pointIndex) {
            final TypedEObject source = training.get(pointIndex).getFirst();
            final TypedEObject calculated = training.get(pointIndex).getSecond();
            final TypedEObject predicted = kernelFunction.getOutput().newEObject();

            kernelFunction.apply(source, predicted);

//            for(int i = 0; i < calculated.size(); ++i) {
            for(final EStructuralFeature feature : kernelFunction.getOutput()) {
                final PredictiveErrorData errorData =  result.get(feature);

                errorData.setPredictionError(pointIndex, calculated.eGetAsDouble(feature) - predicted.eGetAsDouble(feature));
                errorData.setCalculatedValue(pointIndex, calculated.eGetAsDouble(feature));
            }
        }

        final EStructuralFeature targetSpec = kernelFunction.getOutput().getFirst();
        final PredictiveErrorData errorData = result.get(targetSpec);

        final DenseMatrix kernelTrainingsMatrix = DenseMatrix.zeros(ScalarType.Float64, numberOfPoints, numberOfPoints);
        final DenseMatrix kernelTrainingsMatrixNotAdded = DenseMatrix.zeros(ScalarType.Float64, numberOfPoints, numberOfPoints);
        IntStream.rangeClosed(0, numberOfPoints - 1)
                 .boxed()
                 .flatMap(x -> IntStream.rangeClosed(0, numberOfPoints - 1).mapToObj(y -> new Pair<>(x, y)))
 //                .parallel()
                 .forEach(p -> {
                     final Integer index1 = p.getFirst();
                     final Integer index2 = p.getSecond();
                     double kernelValue = calculateKernelValue(kernelFunction, kernelFunction.getInput(), index1, index2);

                     kernelTrainingsMatrixNotAdded.set(index1, index2, kernelValue);
                     kernelTrainingsMatrix.set(index1, index2, index1.equals(index2) ? kernelValue + 1.0 / kernelFunction.getGamma() : kernelValue);
                 });


        final DenseMatrix invertedKernelTrainingsMatrix = kernelTrainingsMatrix.inverse();

        final double sumOfTrainingsMatrix = invertedKernelTrainingsMatrix.colSums().sum();
        final DenseMatrix regularisationMatrix = DenseMatrix.zeros(ScalarType.Float64, numberOfPoints, numberOfPoints);
        regularisationMatrix.fill(1.0 / sumOfTrainingsMatrix);
        final DenseMatrix independentSmoothingMatrix = invertedKernelTrainingsMatrix.copy();

        final DenseMatrix matrix1 = invertedKernelTrainingsMatrix.mm(regularisationMatrix)
                                                         .mm(invertedKernelTrainingsMatrix);
        independentSmoothingMatrix.sub(matrix1);

        DenseMatrix independentSmoothingVector = DenseMatrix.zeros(ScalarType.Float64, 1, numberOfPoints);
        independentSmoothingVector.fill(1.0 / sumOfTrainingsMatrix);
        independentSmoothingVector = independentSmoothingMatrix.mm(invertedKernelTrainingsMatrix);

        final DenseMatrix trainingsSmoothingMatrix = kernelTrainingsMatrixNotAdded.mm(independentSmoothingMatrix).copy();



        trainingsSmoothingMatrix.add(regularisationMatrix.mm(invertedKernelTrainingsMatrix));

        final DenseMatrix tmp1 = trainingsSmoothingMatrix.transpose()
                                                    .mm(trainingsSmoothingMatrix)
                                                    .sub(trainingsSmoothingMatrix)
                                                    .sub(trainingsSmoothingMatrix.transpose());

        final double [] delta = tmp1.diagonal().toArray(new double[0]);

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

        final Space inputSpace = kernelFunction.getInput();

        final double [][] trainingPoints = new double[training.size()][];
        for(int ti = 0; ti < trainingPoints.length; ++ti) {
            final EObjectPair trainingPoint = training.get(ti);
            final TypedEObject value = trainingPoint.getFirst();

            int index = 0;
            trainingPoints[ti] = new double[inputSpace.size()];
            for(final EStructuralFeature feature : inputSpace) {
                trainingPoints[ti][index++] = value.eGetAsDouble(feature);
            }
        }

        errorData.setTrainingData(trainingPoints);
        errorData.setSigma(sigma);
        errorData.setDelta(delta);
        errorData.setIndependentSmoothingMatrix(independentSmoothingMatrix);
        errorData.setIndependentSmoothingVector(independentSmoothingVector);

        errorData.attachTo(functionData.writer().get(), targetSpec);
    }

    private void initializeTrainingData(final Space input, final Space output) {
        training.clear();

        EObjectPairStreamFactory.createFromList(input, output, trainingStream)
                .get()
                .forEach(training::add);
    }

    private Double calculateKernelValue(final KernelBasedSVRFunction regression,
                                        final Space space,
                                        final Integer index1,
                                        final Integer index2) {
        final TypedEObject sp1 = training.get(index1).getFirst();
        final TypedEObject sp2 = training.get(index2).getFirst();

        final double [] data1 = new double[space.size()];
        final double [] data2 = new double[space.size()];

        int i1 = 0;
        for(final EStructuralFeature feature : space) {
            data1[i1++] = sp1.eGetAsDouble(feature);
        }

        int i2 = 0;
        for(final EStructuralFeature feature : space) {
            data2[i2++] = sp2.eGetAsDouble(feature);
        }

        return regression.getRegression()
                .kernel()
                .k(data1, data2);
    }

    public String toString() {
        return "prediction error";
    }
}

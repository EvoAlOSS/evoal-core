package de.evoal.surrogate.smile.boosting;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.surrogate.api.io.onnx.AbstractONNXReader;
import de.evoal.surrogate.api.io.onnx.IntervalONNXFunction;
import de.evoal.surrogate.api.io.onnx.ONNXFunction;
import de.evoal.surrogate.api.io.onnx.ONNXModelStorage;

/**
 * Reads a 'gradient-boosting' model from an ONNX file (see {@link GradientBoostingONNXWriter}):
 *   the function predicts with ONNX Runtime and gives the prediction interval.
 */
@Named("de.evoal.surrogate.smile.ml.gradient-boosting-reader-onnx")
@Dependent
public class GradientBoostingONNXReader extends AbstractONNXReader {
    @Override
    protected ONNXFunction createFunction(final ONNXModelStorage storage) {
        return IntervalONNXFunction.of(storage, getInput(), getOutput());
    }
}

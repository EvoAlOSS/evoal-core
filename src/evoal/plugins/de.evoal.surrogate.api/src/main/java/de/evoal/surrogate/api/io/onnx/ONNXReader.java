package de.evoal.surrogate.api.io.onnx;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

/**
 * Reads a foreign ONNX model, i.e. an ONNX file without EvoAl's model information: no feature
 *   information, no prediction pipeline.
 */
@Named("de.evoal.surrogate.api.ml.general-onnx-reader-onnx")
@Dependent
public class ONNXReader extends AbstractONNXReader {
    @Override
    protected ONNXFunction createFunction(final ONNXModelStorage storage) {
        return new ONNXFunction(getInput(), getOutput(), storage.getSession().orElseThrow());
    }
}

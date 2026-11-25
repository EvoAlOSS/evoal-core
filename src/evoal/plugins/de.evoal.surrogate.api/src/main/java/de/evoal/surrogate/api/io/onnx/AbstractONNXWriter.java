package de.evoal.surrogate.api.io.onnx;

import lombok.NonNull;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.AbstractModelWriter;
import de.evoal.surrogate.api.io.ModelStorage;

/**
 * Base of the writers of ONNX model files. The writer of a model type builds the ONNX graph of
 *   the model ({@link #toConfiguration}); the file stores the model information (the content of
 *   a PSON file without the state) in the metadata of the model.
 * <p>
 * The graph has one input per input feature and one output per output feature, each named after
 *   the feature and holding one value (shape {@code [1]}, {@code [1, 1]}, or dynamic dimensions,
 *   which {@link ONNXFunction} sets to 1). A model that computes on a vector concatenates the
 *   inputs and splits the outputs inside the graph.
 */
public abstract class AbstractONNXWriter extends AbstractModelWriter {
    private ONNXModelStorage storage;

    @Override
    public void store(final ModelFunction function) {
        final OnnxConfiguration onnx = new OnnxConfiguration();
        onnx.setName(function.getModelName());

        toConfiguration(function, onnx);

        storage.store(configurationOf(function), onnx);
    }

    /**
     * Builds the ONNX graph of the model.
     *
     * @param function The trained model.
     * @param configuration The ONNX model to add the graph to.
     */
    protected abstract void toConfiguration(final @NonNull ModelFunction function, final @NonNull OnnxConfiguration configuration);

    @Override
    public void setStorage(final @NonNull ModelStorage storage) {
        this.storage = (ONNXModelStorage) storage;
    }
}

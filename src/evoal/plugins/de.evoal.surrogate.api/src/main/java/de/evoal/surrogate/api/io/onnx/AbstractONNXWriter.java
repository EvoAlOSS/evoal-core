package de.evoal.surrogate.api.io.onnx;

import lombok.NonNull;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.AbstractModelWriter;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;

/**
 * Base of the writers of ONNX model files. The writer of a model type builds the ONNX graph of
 *   the model ({@link #toConfiguration}); the file stores the model information (the content of
 *   a PSON file) in the metadata of the model. The graph is the state of the model; the state of
 *   the model information only holds small values that are not part of the graph
 *   ({@link #toState}).
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

        final SurrogateConfiguration configuration = configurationOf(function);
        toState(function, configuration);

        storage.store(configuration, onnx);
    }

    /**
     * Builds the ONNX graph of the model.
     *
     * @param function The trained model.
     * @param configuration The ONNX model to add the graph to.
     */
    protected abstract void toConfiguration(final @NonNull ModelFunction function, final @NonNull OnnxConfiguration configuration);

    /**
     * Adds small values of the model that are not part of the graph to the state of the model
     *   information, e.g. the coverage of a prediction interval. The reader of the model type
     *   reads them from the state. By default the state stays empty.
     *
     * @param function The trained model.
     * @param configuration The model information.
     */
    protected void toState(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
    }

    @Override
    public void setStorage(final @NonNull ModelStorage storage) {
        this.storage = (ONNXModelStorage) storage;
    }
}

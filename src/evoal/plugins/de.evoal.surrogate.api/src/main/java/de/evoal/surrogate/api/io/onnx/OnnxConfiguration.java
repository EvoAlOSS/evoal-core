package de.evoal.surrogate.api.io.onnx;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import de.evoal.surrogate.protobuf.GraphProto;
import de.evoal.surrogate.protobuf.ModelProto;
import de.evoal.surrogate.protobuf.OperatorSetIdProto;

/**
 * The ONNX model that an {@link AbstractONNXWriter} builds: one graph in one model. The writer
 *   of a model type adds the inputs, outputs, initializers and nodes to the graph, and the
 *   operator sets beyond the default domain (e.g. {@code ai.onnx.ml}) to the model.
 * <p>
 * The model uses IR version {@value #IR_VERSION} and opset {@value #DEFAULT_OPSET} of the default
 *   domain; ONNX Runtime 1.23 supports both.
 */
public class OnnxConfiguration {
    /**
     * The IR version of the model.
     */
    public static final long IR_VERSION = 10;

    /**
     * The opset of the default domain ({@code ai.onnx}).
     */
    public static final long DEFAULT_OPSET = 21;

    /**
     * The model, without the graph until the model is stored.
     */
    @Getter
    private final ModelProto.Builder model = ModelProto.newBuilder();

    /**
     * The graph of the model.
     */
    @Getter
    private final GraphProto.Builder graph = GraphProto.newBuilder();

    OnnxConfiguration() {
        model.setIrVersion(IR_VERSION)
             .addOpsetImport(OperatorSetIdProto.newBuilder()
                                               .setDomain("")
                                               .setVersion(DEFAULT_OPSET));
    }

    /**
     * Names the graph after the model.
     *
     * @param modelName The name of the model.
     */
    public void setName(final String modelName) {
        graph.setName(modelName);
    }

    /**
     * @return The values as floats, for operators whose attributes are float lists.
     */
    public List<Float> doubleArrayToList(final double [] inArray) {
        final List<Float> outList = new ArrayList<>();
        for(final double value : inArray) {
            outList.add((float)value);
        }
        return outList;
    }

    /**
     * @return The values of the rows, one after the other, as floats, for operators whose
     *   attributes are float lists.
     */
    public List<Float> doubleArrayToList(final double [][] inArray) {
        final List<Float> outList = new ArrayList<>();
        for(final double[] subArray : inArray) {
            for(final double value : subArray) {
                outList.add((float)value);
            }
        }
        return outList;
    }
}

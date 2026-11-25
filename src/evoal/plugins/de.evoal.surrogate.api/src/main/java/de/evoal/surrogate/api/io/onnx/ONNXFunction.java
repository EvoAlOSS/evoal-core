package de.evoal.surrogate.api.io.onnx;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ai.onnxruntime.NodeInfo;
import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OnnxValue;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import ai.onnxruntime.TensorInfo;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;

/**
 * A model function that runs an ONNX model. Every input feature is an input tensor of the
 *   model and every output feature an output tensor, each with the name of the feature and a
 *   single value. Dynamic dimensions of an input (e.g. a batch dimension) are set to 1.
 */
@Slf4j
public class ONNXFunction extends ModelFunction {
    /**
     * The session that runs the model.
     */
    private final OrtSession session;

    /**
     * The tensor information of the model's inputs and outputs, by name. They are read once,
     *   because each query asks the native runtime.
     */
    private final Map<String, NodeInfo> inputInfo;
    private final Map<String, NodeInfo> outputInfo;

    /**
     * Creates the function of a foreign ONNX model.
     */
    public ONNXFunction(final Space input, final Space output, final OrtSession session) {
        this("de.evoal.surrogate.api.ml.general-onnx-function", input, output, session);
    }

    /**
     * Creates the function of an ONNX model.
     *
     * @param modelName The name of the model, the DL type of a model that EvoAl trained.
     * @param input The input features.
     * @param output The output features.
     * @param session The session that runs the model.
     */
    @SneakyThrows
    public ONNXFunction(final String modelName, final Space input, final Space output, final OrtSession session) {
        super(modelName, input, output);
        this.session = session;
        this.inputInfo = session.getInputInfo();
        this.outputInfo = session.getOutputInfo();

        log.info("ONNX function with input space {} and output space {}.", input, output);
    }

    @Override
    public void apply(final @NonNull TypedEObject in, final @NonNull TypedEObject out) {
        log.debug("Applying the ONNX model to {}.", in);

        final Map<String, Object> values = run(in, output.stream().map(EStructuralFeature::getName).toList());
        output.forEach(feature -> out.eSet(feature, values.get(feature.getName())));

        log.debug("The ONNX model predicted {}.", out);
    }

    /**
     * Runs the model once.
     *
     * @param in An object with the input features.
     * @param outputs The names of the outputs of the model to read.
     * @return The single value of each output, by name.
     * @throws IllegalStateException if the model has no output of a name.
     */
    protected Map<String, Object> run(final @NonNull TypedEObject in, final @NonNull Collection<String> outputs) {
        final Map<String, OnnxTensor> tensors = new HashMap<>();
        try {
            final OrtEnvironment environment = OrtEnvironment.getEnvironment();
            for(final EStructuralFeature feature : input) {
                tensors.put(feature.getName(), toTensor(environment, in, feature));
            }

            final Map<String, Object> values = new HashMap<>();
            try(final OrtSession.Result results = session.run(tensors)) {
                for(final String name : outputs) {
                    final OnnxValue value = results.get(name)
                                                   .orElseThrow(() -> new IllegalStateException("The ONNX model has no output '" + name + "'."));
                    values.put(name, fromTensor(name, value));
                }
            }

            return values;
        } catch(final OrtException e) {
            throw new RuntimeException(e);
        } finally {
            // the tensors hold native memory
            tensors.values().forEach(OnnxTensor::close);
        }
    }

    /**
     * @return A tensor with the value of the feature, in the type and shape (one value) that
     *   the model expects.
     */
    private OnnxTensor toTensor(final OrtEnvironment environment, final TypedEObject in, final EStructuralFeature feature) throws OrtException {
        final TensorInfo info = (TensorInfo) inputInfo.get(feature.getName()).getInfo();
        final long[] shape = info.getShape().clone();
        for(int i = 0; i < shape.length; ++i) {
            // a dynamic dimension (-1) holds the one value
            if(shape[i] < 0) {
                shape[i] = 1;
            }
        }

        return switch(info.type) {
            case FLOAT -> OnnxTensor.createTensor(environment, FloatBuffer.wrap(new float[] {in.eGetAsFloat(feature)}), shape);
            case DOUBLE -> OnnxTensor.createTensor(environment, DoubleBuffer.wrap(new double[] {in.eGetAsDouble(feature)}), shape);
            case INT32 -> OnnxTensor.createTensor(environment, IntBuffer.wrap(new int[] {in.eGetAsInteger(feature)}), shape);
            case INT64 -> OnnxTensor.createTensor(environment, LongBuffer.wrap(new long[] {in.eGetAsInteger(feature)}), shape);
            default -> throw new IllegalArgumentException("Unsupported input type: " + info.type);
        };
    }

    /**
     * @return The single value of an output tensor of the model, whatever its shape (e.g.
     *   {@code [1]} or {@code [1, 1]}).
     */
    private Object fromTensor(final String name, final OnnxValue value) {
        final TensorInfo info = (TensorInfo) outputInfo.get(name).getInfo();
        final OnnxTensor tensor = (OnnxTensor) value;

        return switch(info.type) {
            case FLOAT -> Double.valueOf(tensor.getFloatBuffer().get(0));
            case DOUBLE -> tensor.getDoubleBuffer().get(0);
            case INT32 -> tensor.getIntBuffer().get(0);
            case INT64 -> tensor.getLongBuffer().get(0);
            default -> throw new IllegalArgumentException("Unsupported output type: " + info.type);
        };
    }

    /**
     * {@inheritDoc}
     * <p>
     * ONNX Runtime allows several threads to run the same session at the same time; every
     *   call has its own tensors.
     */
    @Override
    public boolean isThreadSafe() {
        return true;
    }
}

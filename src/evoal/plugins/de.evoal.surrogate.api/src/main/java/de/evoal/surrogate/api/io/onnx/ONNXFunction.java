package de.evoal.surrogate.api.io.onnx;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
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
 *   single value.
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

    @SneakyThrows
    public ONNXFunction(final Space input, final Space output, final OrtSession session) {
        super("de.evoal.surrogate.api.ml.general-onnx-function", input, output);
        this.session = session;
        this.inputInfo = session.getInputInfo();
        this.outputInfo = session.getOutputInfo();

        log.info("ONNX function with input space {} and output space {}.", input, output);
    }

    @Override
    public void apply(final @NonNull TypedEObject in, final @NonNull TypedEObject out) {
        log.debug("Applying the ONNX model to {}.", in);

        final Map<String, OnnxTensor> tensors = new HashMap<>();
        try {
            final OrtEnvironment environment = OrtEnvironment.getEnvironment();
            for(final EStructuralFeature feature : input) {
                tensors.put(feature.getName(), toTensor(environment, in, feature));
            }

            try(final OrtSession.Result results = session.run(tensors)) {
                for(final EStructuralFeature feature : output) {
                    final OnnxValue value = results.get(feature.getName())
                                                   .orElseThrow(() -> new IllegalStateException("The ONNX model has no output '" + feature.getName() + "'."));
                    out.eSet(feature, fromTensor(feature, value));
                }
            }
        } catch(final OrtException e) {
            throw new RuntimeException(e);
        } finally {
            // the tensors hold native memory
            tensors.values().forEach(OnnxTensor::close);
        }

        log.debug("The ONNX model predicted {}.", out);
    }

    /**
     * @return A tensor with the value of the feature, in the type and shape (one value) that
     *   the model expects.
     */
    private OnnxTensor toTensor(final OrtEnvironment environment, final TypedEObject in, final EStructuralFeature feature) throws OrtException {
        final TensorInfo info = (TensorInfo) inputInfo.get(feature.getName()).getInfo();
        final long[] shape = info.getShape().clone();

        return switch(info.type) {
            case FLOAT -> OnnxTensor.createTensor(environment, FloatBuffer.wrap(new float[] {in.eGetAsFloat(feature)}), shape);
            case DOUBLE -> OnnxTensor.createTensor(environment, DoubleBuffer.wrap(new double[] {in.eGetAsDouble(feature)}), shape);
            case INT32 -> OnnxTensor.createTensor(environment, IntBuffer.wrap(new int[] {in.eGetAsInteger(feature)}), shape);
            case INT64 -> OnnxTensor.createTensor(environment, LongBuffer.wrap(new long[] {in.eGetAsInteger(feature)}), shape);
            default -> throw new IllegalArgumentException("Unsupported input type: " + info.type);
        };
    }

    /**
     * @return The single value of an output tensor of the model.
     */
    private Object fromTensor(final EStructuralFeature feature, final OnnxValue value) throws OrtException {
        final TensorInfo info = (TensorInfo) outputInfo.get(feature.getName()).getInfo();

        return switch(info.type) {
            case FLOAT -> Double.valueOf(((float[]) value.getValue())[0]);
            case DOUBLE -> ((double[]) value.getValue())[0];
            case INT32 -> ((int[]) value.getValue())[0];
            case INT64 -> ((long[]) value.getValue())[0];
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

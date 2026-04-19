package de.evoal.surrogate.api.io.onnx;

import ai.onnxruntime.*;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.ModelStorage;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
//import org.bytedeco.javacpp.indexer.BooleanBufferIndexer;

import java.lang.reflect.Array;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.HashMap;

@Slf4j
public class ONNXFunction extends ModelFunction {


    /**
     * Actual function for prediction.
     */
    private final BiConsumer<TypedEObject, TypedEObject> ModelCall;
    //For now I think I get the proper tensor If not I will need to create it as the create Tensor function
    private OrtSession session;

    private OnnxTensor inputTensor;
    private OnnxTensor outputTensor;


    @SneakyThrows
    public ONNXFunction(Space input, Space output, OrtSession session) {
        super("de.evoal.surrogate.api.ml.general-onnx-function", input, output);
        this.session = session;
        log.info("OnnX Function Constructor: InputSpace: {}, Outputspace:{}", input, output);

        /*final EStructuralFeature iFeature = input.iterator().next();
        final EStructuralFeature oFeature = output.iterator().next();*/


        this.ModelCall = (in, out) -> {
            try {
                Map<String, OnnxTensor> modelInput = new HashMap<String, OnnxTensor>();
                //First get proper Tensors for each input value
                OrtEnvironment env = OrtEnvironment.getEnvironment(); // It is a singleton so it will be the proper one //ToDo: Fix this
                Iterator<EStructuralFeature> iiter=input.iterator();
                while (iiter.hasNext()) {
                    EStructuralFeature iFeature = iiter.next();
                    log.info("Consumer in: {} = {}", iFeature.getName(), in.eGetAsNumber(iFeature)); //I make an assuption here that the data will be a number --> May not always be the case
                    //               get proper type from Node
                    TensorInfo info = (TensorInfo) session.getInputInfo().get(iFeature.getName()).getInfo();
                    long[] shape = info.getShape().clone(); // it is expected for it to be [1]
                    OnnxTensor tensor;
                    switch (info.type) {
                        case FLOAT:
                            float[] floatInput = new float[]{in.eGetAsFloat(iFeature)};
                            tensor = OnnxTensor.createTensor(env, FloatBuffer.wrap(floatInput), shape);
                            break;
                        case DOUBLE:
                            double[] doubleInput = new double[]{in.eGetAsDouble(iFeature)};
                            tensor = OnnxTensor.createTensor(env, DoubleBuffer.wrap(doubleInput), shape);
                            break;
                        case INT32:
                            int[] intInput = new int[]{in.eGetAsInteger(iFeature)};
                            tensor = OnnxTensor.createTensor(env, IntBuffer.wrap(intInput), shape);
                            break;
                        case INT64:
                            long[] longInput = new long[]{in.eGetAsInteger(iFeature)};
                            tensor = OnnxTensor.createTensor(env, LongBuffer.wrap(longInput), shape);
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported input type: " + info.type);
                    }
                    modelInput.put(iFeature.getName(), tensor);
                }

                //now that all inputs have been filled properly we try to run it
                OrtSession.Result results = this.session.run(modelInput);

                log.info("Module Called and the result was:{}", results);
                for (Map.Entry<String, OnnxValue> result : results) {
                    float[] fl = (float[]) result.getValue().getValue();// First Onnx result to onnxvalue to output []float here
                    log.info("Called the module it says {} was {}", result.getKey(), fl[0]);
                }
                //next we will try to fill out properly
                Iterator<EStructuralFeature> oiter=output.iterator();
                while (oiter.hasNext()) {
                    EStructuralFeature oFeature = oiter.next();
                    TensorInfo info = (TensorInfo) session.getOutputInfo().get(oFeature.getName()).getInfo();
                    OnnxValue val=results.get(oFeature.getName()).get(); //I implicitly resolved an Optional here
                    long[] shape = info.getShape().clone();// should always be [1]
                    switch (info.type) {
                        case FLOAT:
                            float[] floatOutput = (float[]) val.getValue(); //Must be of Double?
                            log.info("Setting: {} = {}", oFeature.getName(), floatOutput);
                            out.eSet(oFeature,Double.valueOf(floatOutput[0])); // I feel like we have a problem here --> Or do we just not have EFloat?
                            break;
                        case DOUBLE:
                            double[] doubleOutput2 = (double[]) val.getValue();
                            log.info("Setting: {} = {}", oFeature.getName(), doubleOutput2[0]);
                            out.eSet(oFeature,doubleOutput2[0]);
                            break;
                        case INT32:
                            int[] intOutput = (int[])val.getValue();
                            log.info("Setting: {} = {}", oFeature.getName(), intOutput[0]);
                            out.eSet(oFeature,intOutput[0]);
                            break;
                        case INT64:
                            long[] longOutput =(long[])val.getValue();
                            log.info("Setting: {} = {}", oFeature.getName(), longOutput[0]);
                            out.eSet(oFeature,longOutput[0]);
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported input type: " + info.type);
                    }
//                    Optional<OnnxValue> val...
//                    if(val.isEmpty())
//                    {
//                        log.info("DAFUQ result is empty?");
//                    }
//                    val.ifPresent(v-> {
//                        log.info("Well at least I am not empty :D");
//                        try {
//                            log.info("This is the Optional speaking, my value is: {}",v.getValue());
//                        } catch (OrtException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                    log.info("Setting: {} = {}", oFeature.getName(), results.get(oFeature.getName()));
//                    out.eSet(oFeature, results.get(oFeature.getName()));
                }
            }catch (OrtException e){throw new RuntimeException(e);}


        };
    }
//    private OnnxTensor createTensor(String name, Object userData) throws Exception {
//        OrtEnvironment env= OrtEnvironment.getEnvironment(); // It is a singleton so it will be the proper one //ToDo: Fix this
//        TensorInfo info = (TensorInfo) session.getInputInfo().get(name).getInfo();
//        long[] shape = info.getShape().clone();
//
//        // Replace dynamic dims (-1) with actual user-supplied sizes
//        long totalElements = 1;
//        for (int i = 0; i < shape.length; i++) {
//            if (shape[i] == -1) {
//                // infer dimension from user array length
//                // (flat array expected for simplicity)
//                long inferred = Array.getLength(userData);
//                shape[i] = inferred;
//            }
//            totalElements *= shape[i];
//        }
//
//        // Create tensor based on expected element type
//        return switch (info.type) {
//            case FLOAT -> OnnxTensor.createTensor(env, (FloatBuffer) userData, shape);
//            case DOUBLE -> OnnxTensor.createTensor(env, (DoubleBuffer) userData, shape);
//            case INT32 -> OnnxTensor.createTensor(env, (IntBuffer) userData, shape);
//            case INT64 -> OnnxTensor.createTensor(env, (LongBuffer) userData, shape);
//            /*case BOOL -> OnnxTensor.createTensor(env, (boolean[]) userData, shape);*/
//            default -> throw new IllegalArgumentException("Unsupported input type: " + info.type);
//        };
//    }

    @Override
    public void apply(@NonNull TypedEObject input, @NonNull TypedEObject output) {
        log.info("Applying onnx model from {}.",input);
        ModelCall.accept(input,output);

    }
}

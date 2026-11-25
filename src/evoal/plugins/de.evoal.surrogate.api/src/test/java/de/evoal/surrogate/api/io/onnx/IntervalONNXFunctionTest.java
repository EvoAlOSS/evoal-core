package de.evoal.surrogate.api.io.onnx;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import lombok.NonNull;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.PredictionInterval.Interval;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.main.internal.SurrogateModelTransformer;
import de.evoal.surrogate.protobuf.NodeProto;
import de.evoal.surrogate.protobuf.TensorProto;
import de.evoal.surrogate.protobuf.TensorShapeProto;
import de.evoal.surrogate.protobuf.TypeProto;
import de.evoal.surrogate.protobuf.ValueInfoProto;

/**
 * ONNX models with a prediction interval (#349): a graph with the outputs
 *   {@code y = x + 5}, {@code y.lower = x + 3} and {@code y.upper = x + 1}, whose bounds cross.
 */
public class IntervalONNXFunctionTest {
    private static final EPackage PACKAGE = EcoreFactory.eINSTANCE.createEPackage();
    static {
        PACKAGE.setName("test");
        PACKAGE.setNsURI("http://www.evoal.de/test/interval-onnx");
    }

    @TempDir
    Path folder;

    private EAttribute x;
    private EAttribute y;
    private Space input;
    private Space output;

    private DefinitionModuleLoader loader;
    private SurrogateModelTransformer transformer;

    @BeforeEach
    void setUp() {
        final EClass data = EcoreFactory.eINSTANCE.createEClass();
        data.setName("data" + PACKAGE.getEClassifiers().size());
        PACKAGE.getEClassifiers().add(data);
        x = attribute(data, "x:0");
        y = attribute(data, "y:0");

        final Space space = new Space(data);
        input = space.subSpace(List.of(x));
        output = space.subSpace(List.of(y));

        loader = Mockito.mock(DefinitionModuleLoader.class);
        transformer = Mockito.mock(SurrogateModelTransformer.class);
        Mockito.when(transformer.setSpace(Mockito.any())).thenReturn(transformer);
    }

    private static EAttribute attribute(final EClass type, final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        type.getEStructuralFeatures().add(attribute);

        return attribute;
    }

    /**
     * Writes the three outputs, {@code x + offset} each, and the given state.
     */
    private static final class OffsetWriter extends AbstractONNXWriter {
        private final List<Parameter> state;
        private final boolean bounds;

        private OffsetWriter(final List<Parameter> state, final boolean bounds) {
            this.state = state;
            this.bounds = bounds;
        }

        @Override
        protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull OnnxConfiguration configuration) {
            final String in = function.getInput().iterator().next().getName();
            final String out = function.getOutput().iterator().next().getName();

            configuration.getGraph().addInput(value(in));
            offset(configuration, in, out, 5.0);
            if(bounds) {
                offset(configuration, in, out + IntervalONNXFunction.LOWER, 3.0);
                offset(configuration, in, out + IntervalONNXFunction.UPPER, 1.0);
            }
        }

        private static void offset(final OnnxConfiguration configuration, final String in, final String out, final double offset) {
            configuration.getGraph()
                         .addOutput(value(out))
                         .addInitializer(TensorProto.newBuilder()
                                                    .setName(out + "/offset")
                                                    .setDataType(TensorProto.DataType.DOUBLE.getNumber())
                                                    .addDims(1)
                                                    .addDims(1)
                                                    .addDoubleData(offset))
                         .addNode(NodeProto.newBuilder()
                                           .setOpType("Add")
                                           .addInput(in)
                                           .addInput(out + "/offset")
                                           .addOutput(out));
        }

        @Override
        protected void toState(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
            configuration.getState().addAll(state);
        }
    }

    private static ValueInfoProto value(final String name) {
        final TensorShapeProto.Dimension one = TensorShapeProto.Dimension.newBuilder().setDimValue(1).build();

        return ValueInfoProto.newBuilder()
                             .setName(name)
                             .setType(TypeProto.newBuilder()
                                               .setTensorType(TypeProto.Tensor.newBuilder()
                                                                              .setElemType(TensorProto.DataType.DOUBLE.getNumber())
                                                                              .setShape(TensorShapeProto.newBuilder().addDim(one).addDim(one))))
                             .build();
    }

    private ModelFunction function() {
        return new ModelFunction("de.evoal.test.ml.offsets", input, output) {
            @Override
            public void apply(final @NonNull TypedEObject in, final @NonNull TypedEObject out) {
            }
        };
    }

    /**
     * Stores the model and loads it again.
     */
    private ONNXModelStorage storeAndLoad(final OffsetWriter writer) {
        final File file = folder.resolve("model.onnx").toFile();
        final ONNXModelStorage storage = new ONNXModelStorage(loader, transformer);
        storage.setLocation(file.toURI()).setSpaces(input, output);
        writer.setStorage(storage);
        writer.store(function());

        final ONNXModelStorage loaded = new ONNXModelStorage(loader, transformer);
        loaded.setLocation(file.toURI()).setSpaces(input, output);
        loaded.load();

        return loaded;
    }

    private IntervalONNXFunction load(final String pointPrediction) {
        return IntervalONNXFunction.of(storeAndLoad(new OffsetWriter(List.of(Parameter.from(IntervalONNXFunction.COVERAGE, 0.8),
                                                                              Parameter.from(IntervalONNXFunction.POINT_PREDICTION, pointPrediction)),
                                                                      true)),
                                       input, output);
    }

    private TypedEObject at(final double value) {
        final TypedEObject in = input.newEObject();
        in.eSet(x, value);

        return in;
    }

    private double predict(final IntervalONNXFunction function, final double value) {
        final TypedEObject out = output.newEObject();
        function.apply(at(value), out);

        return out.eGetAsDouble(y);
    }

    @Test
    public void theMedianIsTheMiddleValueAndTheBoundsTheOuterOnes() {
        // given
        final IntervalONNXFunction function = load(IntervalONNXFunction.MEDIAN);

        // then: x + 5, x + 3, x + 1 sorted
        Assertions.assertEquals(5.0, predict(function, 2.0));
        Assertions.assertEquals(new Interval(3.0, 7.0), function.interval(at(2.0), y));
        Assertions.assertEquals(0.8, function.coverage(y));
    }

    @Test
    public void theMeanStaysAndOnlyTheBoundsAreSorted() {
        // given
        final IntervalONNXFunction function = load(IntervalONNXFunction.MEAN);

        // then
        Assertions.assertEquals(7.0, predict(function, 2.0));
        Assertions.assertEquals(new Interval(3.0, 5.0), function.interval(at(2.0), y));
    }

    @Test
    public void aModelFileWithoutCoverageIsRejected() {
        // given
        final ONNXModelStorage storage = storeAndLoad(new OffsetWriter(List.of(Parameter.from(IntervalONNXFunction.POINT_PREDICTION, IntervalONNXFunction.MEAN)), true));

        // when
        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> IntervalONNXFunction.of(storage, input, output));

        // then
        Assertions.assertTrue(e.getMessage().contains("'coverage'"), e.getMessage());
    }

    @Test
    public void aGraphWithoutBoundsIsRejected() {
        // given
        final ONNXModelStorage storage = storeAndLoad(new OffsetWriter(List.of(Parameter.from(IntervalONNXFunction.COVERAGE, 0.8),
                                                                                Parameter.from(IntervalONNXFunction.POINT_PREDICTION, IntervalONNXFunction.MEAN)),
                                                                        false));

        // when
        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> IntervalONNXFunction.of(storage, input, output));

        // then
        Assertions.assertTrue(e.getMessage().contains("[y:0.lower, y:0.upper]"), e.getMessage());
    }
}

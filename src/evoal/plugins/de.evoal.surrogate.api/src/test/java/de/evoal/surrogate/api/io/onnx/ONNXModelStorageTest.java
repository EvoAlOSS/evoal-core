package de.evoal.surrogate.api.io.onnx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.models.v202704.pipeline.PipelineFactory;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.ModelWriter;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import de.evoal.surrogate.api.io.pson.PSONModelStorage;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.api.io.pson.SurrogateConfigurations;
import de.evoal.surrogate.main.internal.SurrogateModelTransformer;
import de.evoal.surrogate.protobuf.ModelProto;
import de.evoal.surrogate.protobuf.NodeProto;
import de.evoal.surrogate.protobuf.TensorProto;
import de.evoal.surrogate.protobuf.TensorShapeProto;
import de.evoal.surrogate.protobuf.TypeProto;
import de.evoal.surrogate.protobuf.ValueInfoProto;

/**
 * ONNX model files with EvoAl's model information (#348): a small model {@code y = x + 1}.
 */
public class ONNXModelStorageTest {
    private static final String MODEL = "de.evoal.test.ml.plus-one";

    private static final EPackage PACKAGE = EcoreFactory.eINSTANCE.createEPackage();
    static {
        PACKAGE.setName("test");
        PACKAGE.setNsURI("http://www.evoal.de/test/onnx-storage");
    }

    @TempDir
    Path folder;

    private EAttribute x;
    private EAttribute y;
    private EAttribute z;
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
        z = attribute(data, "z:0");

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
     * The trained model: only its spaces and name matter, the writer builds the graph.
     */
    private ModelFunction function() {
        return new ModelFunction(MODEL, input, output) {
            @Override
            public void apply(final @NonNull TypedEObject in, final @NonNull TypedEObject out) {
                out.eSet(y, in.eGetAsDouble(x) + 1.0);
            }
        };
    }

    /**
     * The writer of the model: {@code y = x + 1} in double, with a fixed shape.
     */
    private static final class PlusOneWriter extends AbstractONNXWriter {
        @Override
        protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull OnnxConfiguration configuration) {
            final String in = function.getInput().iterator().next().getName();
            final String out = function.getOutput().iterator().next().getName();

            configuration.getGraph()
                         .addInput(value(in, 1))
                         .addOutput(value(out, 1))
                         .addInitializer(TensorProto.newBuilder()
                                                    .setName("one")
                                                    .setDataType(TensorProto.DataType.DOUBLE.getNumber())
                                                    .addDims(1)
                                                    .addDims(1)
                                                    .addDoubleData(1.0))
                         .addNode(NodeProto.newBuilder()
                                           .setOpType("Add")
                                           .addInput(in)
                                           .addInput("one")
                                           .addOutput(out));
        }
    }

    /**
     * @return A double tensor of shape {@code [n, 1]}, with a dynamic first dimension for n < 0.
     */
    private static ValueInfoProto value(final String name, final int n) {
        final TensorShapeProto.Dimension first = n < 0
                                                 ? TensorShapeProto.Dimension.newBuilder().setDimParam("N").build()
                                                 : TensorShapeProto.Dimension.newBuilder().setDimValue(n).build();

        return ValueInfoProto.newBuilder()
                             .setName(name)
                             .setType(TypeProto.newBuilder()
                                               .setTensorType(TypeProto.Tensor.newBuilder()
                                                                              .setElemType(TensorProto.DataType.DOUBLE.getNumber())
                                                                              .setShape(TensorShapeProto.newBuilder()
                                                                                                        .addDim(first)
                                                                                                        .addDim(TensorShapeProto.Dimension.newBuilder().setDimValue(1)))))
                             .build();
    }

    /**
     * Adds the same model information to a writer: goodness of fit, density data, the DL types
     *   and a prediction pipeline.
     */
    private <W extends ModelWriter> W withInformation(final W writer) {
        writer.addOutputFeatureInformation(y, Parameter.from("de.evoal.surrogate.ml.rmse", 0.25));
        writer.addOutputFeatureInformation(y, Parameter.from("de.evoal.surrogate.ml.R²", 0.75));
        writer.addInputFeatureInformation(x, Parameter.from("density", 3.0));
        writer.addTrainingDefinitions(List.of(MODEL, "de.evoal.test.ml.pearson"));

        final PipelineDefinition pipeline = PipelineFactory.eINSTANCE.createPipelineDefinition();
        pipeline.setName("predicting");
        writer.addPredictionPipeline(pipeline);

        return writer;
    }

    private File store() {
        final File file = folder.resolve("model.onnx").toFile();
        final ONNXModelStorage storage = new ONNXModelStorage(loader, transformer);
        storage.setLocation(file.toURI()).setSpaces(input, output);

        final PlusOneWriter writer = withInformation(new PlusOneWriter());
        writer.setStorage(storage);
        writer.store(function());

        return file;
    }

    private ONNXModelStorage load(final File file, final Space outputs) {
        final ONNXModelStorage storage = new ONNXModelStorage(loader, transformer);
        storage.setLocation(file.toURI()).setSpaces(input, outputs);

        return storage;
    }

    private static ModelProto read(final File file) throws IOException {
        try(final InputStream is = new FileInputStream(file)) {
            return ModelProto.parseFrom(is);
        }
    }

    @Test
    public void theModelInformationIsTheContentOfAPsonFile() throws IOException {
        // given: the same model information in a PSON file
        final File pson = folder.resolve("model.pson").toFile();
        final PSONModelStorage psonStorage = new PSONModelStorage();
        psonStorage.setLocation(pson.toURI()).setSpaces(input, output);
        final AbstractPSONWriter psonWriter = withInformation(new AbstractPSONWriter() {
            @Override
            protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
            }
        });
        psonWriter.setStorage(psonStorage);
        psonWriter.store(function());

        // when
        final ModelProto model = read(store());

        // then
        final JsonMapper mapper = JsonMapper.builder().build();
        Assertions.assertEquals(1, model.getMetadataPropsCount());
        Assertions.assertEquals(ONNXModelStorage.CONFIGURATION_KEY, model.getMetadataProps(0).getKey());
        Assertions.assertEquals(mapper.readTree(pson), mapper.readTree(model.getMetadataProps(0).getValue()));
        Assertions.assertEquals("EvoAl", model.getProducerName());
        Assertions.assertEquals(OnnxConfiguration.IR_VERSION, model.getIrVersion());
        Assertions.assertEquals(MODEL, model.getGraph().getName());
    }

    @Test
    public void aStoredModelIsReadWithItsModelInformation() throws IOException {
        // given
        final File file = store();
        final JsonNode stored = JsonMapper.builder().build().readTree(read(file).getMetadataProps(0).getValue());

        // when
        final ONNXModelStorage storage = load(file, output);

        // then: the same name, DL types, features, pipeline and feature information
        Assertions.assertEquals(MODEL, storage.getModelName());
        Assertions.assertTrue(storage.getPredictionPipeline().isPresent());
        Assertions.assertSame(storage.getPipelineSpace(), storage.getPipelineSpace());
        final String reread = SurrogateConfigurations.writer().writeValueAsString(storage.getConfiguration().orElseThrow());
        Assertions.assertEquals(stored, JsonMapper.builder().build().readTree(reread));
    }

    @Test
    public void theReaderGivesTheFeatureInformationAndPredicts() throws IOException {
        // given
        final ONNXModelStorage storage = load(store(), output);
        final AbstractONNXReader reader = new AbstractONNXReader() {
        };
        reader.setStorage(storage);
        reader.setSpace(input, output);

        // when
        final ONNXFunction function = reader.load();
        final TypedEObject in = input.newEObject();
        in.eSet(x, 2.5);
        final TypedEObject out = output.newEObject();
        function.apply(in, out);

        // then
        Assertions.assertEquals(MODEL, function.getModelName());
        Assertions.assertEquals(3.5, out.eGetAsDouble(y));
        Assertions.assertEquals(List.of("de.evoal.surrogate.ml.rmse", "de.evoal.surrogate.ml.R²"),
                                reader.getOutputFeatureInformation(y).stream().map(Parameter::getName).toList());
        Assertions.assertEquals(List.of("density"),
                                reader.getInputFeatureInformation(x).stream().map(Parameter::getName).toList());
    }

    @Test
    public void aFileWithoutModelInformationIsAForeignModel() throws IOException {
        // given: y = x + x, with a dynamic first dimension like models of other tools
        final File file = folder.resolve("foreign.onnx").toFile();
        final OnnxConfiguration onnx = new OnnxConfiguration();
        onnx.getGraph()
            .setName("foreign")
            .addInput(value(x.getName(), -1))
            .addOutput(value(y.getName(), -1))
            .addNode(NodeProto.newBuilder().setOpType("Add").addInput(x.getName()).addInput(x.getName()).addOutput(y.getName()));
        try(final OutputStream os = new FileOutputStream(file)) {
            onnx.getModel().setGraph(onnx.getGraph()).build().writeTo(os);
        }

        // when
        final ONNXModelStorage storage = load(file, output);
        final ONNXReader reader = new ONNXReader();
        reader.setStorage(storage);
        reader.setSpace(input, output);
        final ONNXFunction function = reader.load();
        final TypedEObject in = input.newEObject();
        in.eSet(x, 2.0);
        final TypedEObject out = output.newEObject();
        function.apply(in, out);

        // then
        Assertions.assertEquals(ONNXModelStorage.FOREIGN_MODEL, storage.getModelName());
        Assertions.assertTrue(storage.getPredictionPipeline().isEmpty());
        Assertions.assertTrue(reader.getOutputFeatureInformation(y).isEmpty());
        Assertions.assertEquals(4.0, out.eGetAsDouble(y));
    }

    @Test
    public void aGraphWithoutAnOutputOfAnOutputFeatureIsRejected() throws IOException {
        // given
        final File file = store();
        final Space outputs = input.merge(output).subSpace(List.of(y, z));

        // when
        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> load(file, outputs).load());

        // then
        Assertions.assertTrue(e.getMessage().contains("missing outputs [z:0]"), e.getMessage());
    }

    @Test
    public void aModelFileWithoutPipelineInItsModelInformationIsRejected() throws IOException {
        // given: model information without a prediction pipeline
        final File file = folder.resolve("model.onnx").toFile();
        final ONNXModelStorage storage = new ONNXModelStorage(loader, transformer);
        storage.setLocation(file.toURI()).setSpaces(input, output);
        final PlusOneWriter writer = new PlusOneWriter();
        writer.setStorage(storage);
        writer.store(function());

        // when / then
        Assertions.assertThrows(IllegalStateException.class, () -> load(file, output).getPredictionPipeline());
    }
}

package de.evoal.surrogate.main.literature;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import de.evoal.surrogate.api.io.onnx.ONNXModelStorage;
import de.evoal.surrogate.protobuf.GraphProto;
import de.evoal.surrogate.protobuf.ModelProto;
import de.evoal.surrogate.protobuf.StringStringEntryProto;

public class SurrogateLiteratureTest {
    @Test
    public void theNamesOfAModelFileAreItsTypeItsDefinitionsAndItsPipelineSteps() {
        // given
        final String model = """
                {
                  "inputFeatures": ["x:0"],
                  "name": "de.evoal.surrogate.smile.ml.epsilon-svr",
                  "definitions": ["de.evoal.surrogate.smile.ml.epsilon-svr", "de.evoal.surrogate.smile.ml.pearson"],
                  "predictionPipeline": {
                    "type": "pipeline-definition",
                    "name": "predicting",
                    "steps": [
                      {"type": "pipeline-step", "definition": {"type": "pipeline-definition", "name": "preparation", "steps": []}},
                      {"type": "concrete-step", "reads": ["x:0"], "writes": ["y:0"],
                       "configuration": {"type": "instance", "class-definition": "de.evoal.surrogate.pipeline.model-prediction",
                                         "attributes": []}}
                    ]
                  }
                }
                """;

        // when
        final List<String> names = List.copyOf(SurrogateLiterature.namesIn(JsonMapper.builder().build().readTree(model)));

        // then: each once, in the order of the file
        Assertions.assertEquals(List.of("de.evoal.surrogate.smile.ml.epsilon-svr", "de.evoal.surrogate.smile.ml.pearson",
                                        "de.evoal.surrogate.pipeline.model-prediction"),
                                names);
    }

    @Test
    public void aModelFileWithoutDefinitionsGivesItsTypeAndItsPipelineSteps() {
        // given: written before the definitions were recorded
        final String model = """
                {"name": "de.evoal.surrogate.smile.ml.gaussian-process", "predictionPipeline": null}
                """;

        // when
        final List<String> names = List.copyOf(SurrogateLiterature.namesIn(JsonMapper.builder().build().readTree(model)));

        // then
        Assertions.assertEquals(List.of("de.evoal.surrogate.smile.ml.gaussian-process"), names);
    }

    @Test
    public void anOnnxModelFileGivesTheModelInformationOfItsMetadata(@TempDir final Path folder) throws IOException {
        // given
        final File file = onnx(folder, Optional.of("{\"name\": \"de.evoal.surrogate.smile.ml.gradient-boosting\"}"));

        // when
        final Optional<JsonNode> model = SurrogateLiterature.modelInformation(file);

        // then
        Assertions.assertEquals(List.of("de.evoal.surrogate.smile.ml.gradient-boosting"), List.copyOf(SurrogateLiterature.namesIn(model.orElseThrow())));
    }

    @Test
    public void aForeignOnnxModelHasNoModelInformation(@TempDir final Path folder) throws IOException {
        Assertions.assertTrue(SurrogateLiterature.modelInformation(onnx(folder, Optional.empty())).isEmpty());
    }

    /**
     * @return An ONNX model file with an empty graph, with or without model information.
     */
    private static File onnx(final Path folder, final Optional<String> information) throws IOException {
        final ModelProto.Builder model = ModelProto.newBuilder().setIrVersion(10).setGraph(GraphProto.newBuilder().setName("empty"));
        information.ifPresent(json -> model.addMetadataProps(StringStringEntryProto.newBuilder()
                                                                                  .setKey(ONNXModelStorage.CONFIGURATION_KEY)
                                                                                  .setValue(json)));

        final File file = folder.resolve("model.onnx").toFile();
        try(final OutputStream os = new FileOutputStream(file)) {
            model.build().writeTo(os);
        }

        return file;
    }
}

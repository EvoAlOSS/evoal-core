package de.evoal.surrogate.main.literature;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

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
}

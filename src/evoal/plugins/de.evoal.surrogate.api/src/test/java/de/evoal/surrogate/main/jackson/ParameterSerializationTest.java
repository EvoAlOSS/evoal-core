package de.evoal.surrogate.main.jackson;

import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.ResampledValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

/**
 * The stored form of the goodness-of-fit values of a resampling scheme in a model file.
 */
public class ParameterSerializationTest {
    private static Parameter roundTrip(final Parameter parameter) {
        final SimpleModule module = new SimpleModule();
        module.addSerializer(Parameter.class, new ParameterSerializer());
        module.addDeserializer(Parameter.class, new ParameterDeserializer());
        final JsonMapper mapper = JsonMapper.builder().addModule(module).build();

        return mapper.readValue(mapper.writeValueAsString(parameter), Parameter.class);
    }

    @Test
    public void aSchemeWithOnlyAPooledValueIsReadBack() {
        // given: R² of leave-one-out, undefined on every part (#351)
        final Parameter stored = Parameter.from("de.evoal.surrogate.ml.R²",
                Map.of("leave-one-out-cross-validation", ResampledValues.of(List.of(), OptionalDouble.of(0.93)).asMap()));

        // when
        final Parameter read = roundTrip(stored);

        // then
        final Map<?, ?> scheme = (Map<?, ?>) ((Map<?, ?>) read.getValue()).get("leave-one-out-cross-validation");
        Assertions.assertEquals(0.93, scheme.get("pooled"));
        Assertions.assertArrayEquals(new double[0], (double[]) scheme.get("values"));
        Assertions.assertFalse(scheme.containsKey("mean"));
    }
}

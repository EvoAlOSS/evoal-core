package de.evoal.surrogate.api.function;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The check that a model type can be stored in the format of the model file (#348).
 */
public class ModelFunctionFactoryTest {
    private static final String MODEL = "de.evoal.surrogate.smile.ml.gaussian-process";

    @Test
    public void aFormatOfTheModelTypeIsAccepted() {
        Assertions.assertDoesNotThrow(() -> ModelFunctionFactory.requireFormat(MODEL, "pson", List.of("pson")));
    }

    @Test
    public void anotherFormatIsRejectedWithTheFormatsOfTheModelType() {
        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                () -> ModelFunctionFactory.requireFormat(MODEL, "onnx", List.of("pson")));

        Assertions.assertEquals("The model type 'de.evoal.surrogate.smile.ml.gaussian-process' cannot be stored as '.onnx'; it supports: pson.",
                                e.getMessage());
    }

    @Test
    public void aModelTypeWithoutWriterSupportsNoFormat() {
        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                () -> ModelFunctionFactory.requireFormat(MODEL, "pson", List.of()));

        Assertions.assertTrue(e.getMessage().endsWith("it supports: no format."), e.getMessage());
    }
}

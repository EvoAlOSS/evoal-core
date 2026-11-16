package de.evoal.optimisation.main.statistics.memory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class MemoryModelSchemasTest {
    @TempDir
    private Path folder;

    @Nested
    @DisplayName("given an iteration file that violates the schema")
    class InvalidFile {
        @Test
        public void theViolationsAreReported() throws Exception {
            // given
            final Path file = folder.resolve("iteration-0.json");
            Files.writeString(file, "{\"formatVersion\":\"2027.4.0\",\"number\":-1}");

            // when
            final List<String> violations = MemoryModelSchemas.violationsOf(file);

            // then
            Assertions.assertFalse(violations.isEmpty());
        }
    }

    @Nested
    @DisplayName("given metrics with non-finite values")
    class NonFiniteMetrics {
        @Test
        public void theStringsAreValid() throws Exception {
            // given
            final Path file = folder.resolve("execution-finished.json");
            Files.writeString(file, """
                    {"formatVersion":"2027.4.0","numberOfIterations":1,"best":[0],
                     "metrics":{"a":"NaN","b":"Infinity","c":"-Infinity","d":1.5}}
                    """);

            // when
            final List<String> violations = MemoryModelSchemas.violationsOf(file);

            // then
            Assertions.assertEquals(List.of(), violations);
        }

        @Test
        public void otherStringsAreInvalid() throws Exception {
            // given
            final Path file = folder.resolve("execution-finished.json");
            Files.writeString(file, """
                    {"formatVersion":"2027.4.0","numberOfIterations":1,"best":[0],"metrics":{"a":"many"}}
                    """);

            // when
            final List<String> violations = MemoryModelSchemas.violationsOf(file);

            // then
            Assertions.assertFalse(violations.isEmpty());
        }
    }
}

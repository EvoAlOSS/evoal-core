package de.evoal.pipeline.impl.components.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.pipeline.api.values.PipelineValues;

/**
 * The sinks that write named pipeline values: {@link TemplateSink} and {@link CsvValueWriter}.
 */
public class ValueSinksTest {
    private final InterpreterState context = new InterpreterState();

    @TempDir
    private Path folder;

    private static Map<String, Object> row(final Object... keysAndValues) {
        final Map<String, Object> row = new LinkedHashMap<>();
        for(int i = 0; i < keysAndValues.length; i += 2) {
            row.put((String) keysAndValues[i], keysAndValues[i + 1]);
        }

        return row;
    }

    @BeforeEach
    public void publishValues() {
        final PipelineValues values = PipelineValues.of(context);
        values.beginExecution();
        values.put("correlations", List.of(row("first", "x:0", "second", "x:1", "n", 1000, "coefficient", 0.8031, "lower", null),
                                           row("first", "x:0", "second", "x,2", "n", 12, "coefficient", -1.0E-4, "lower", 0.5)));
    }

    private String read(final File file) throws IOException {
        return Files.readString(file.toPath(), StandardCharsets.UTF_8);
    }

    @Nested
    public class Template {
        private String render(final String text, final List<String> values) throws IOException {
            final File template = folder.resolve("t.ftl").toFile();
            Files.writeString(template.toPath(), text, StandardCharsets.UTF_8);
            final File output = folder.resolve("out/result.ddl").toFile();

            final TemplateSink sink = new TemplateSink(template, output, values);
            sink.setContext(context);
            sink.streamEnded();

            return read(output);
        }

        @Test
        public void theValuesAreRenderedWithLocaleIndependentNumbers() throws IOException {
            final String text = render("<#list correlations as c>${c.first}/${c.second}: ${c.coefficient} (${c.n})\n</#list>",
                                       List.of("correlations"));

            Assertions.assertEquals("x:0/x:1: 0.8031 (1000)\nx:0/x,2: -0.0001 (12)\n", text);
        }

        @Test
        public void aMissingValueIsAnError() {
            Assertions.assertThrows(IllegalStateException.class,
                                    () -> render("<#list correlations as c>${c.lower}\n</#list>", List.of("correlations")));
            Assertions.assertThrows(IllegalArgumentException.class, () -> render("x", List.of("unknown")));
        }

        @Test
        public void templatesCannotCreateJavaObjects() {
            Assertions.assertThrows(IllegalStateException.class,
                                    () -> render("<#assign e = \"freemarker.template.utility.Execute\"?new()>${e(\"id\")}",
                                                 List.of("correlations")));
        }
    }

    @Nested
    public class Csv {
        private File write(final String name) {
            final File output = folder.resolve("out/values.csv").toFile();
            final CsvValueWriter writer = new CsvValueWriter(name, output);
            writer.setContext(context);
            writer.streamEnded();

            return output;
        }

        @Test
        public void everyMapIsARowWithTheKeysAsColumns() throws IOException {
            Assertions.assertEquals("first,second,n,coefficient,lower\n"
                                    + "x:0,x:1,1000,0.8031,\n"
                                    + "x:0,\"x,2\",12,-1.0E-4,0.5\n",
                                    read(write("correlations")));
        }

        @Test
        public void anEmptyListWritesAnEmptyFile() throws IOException {
            PipelineValues.of(context).put("empty", List.of());

            Assertions.assertEquals("", read(write("empty")));
        }

        @Test
        public void rowsWithDifferentKeysOrNestedValuesAreRejected() {
            PipelineValues.of(context).put("different", List.of(row("a", 1), row("b", 2)));
            final List<Map<String, Object>> nested = new ArrayList<>();
            nested.add(new HashMap<>(Map.of("a", List.of(1))));
            PipelineValues.of(context).put("nested", nested);

            Assertions.assertThrows(IllegalStateException.class, () -> write("different"));
            Assertions.assertThrows(IllegalStateException.class, () -> write("nested"));
        }
    }
}

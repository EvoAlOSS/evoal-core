package de.evoal.core.main.provenance;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

import de.evoal.core.api.provenance.RunRecord;
import de.evoal.core.main.credits.InstalledJars.InstalledJar;

public class RunRecordWriterTest {
    @TempDir
    private Path folder;

    private static RunRecord record() {
        return new RunRecord(Clock.fixed(Instant.parse("2026-11-23T10:00:00Z"), ZoneOffset.UTC));
    }

    @Nested
    @DisplayName("given a run record")
    class Record {
        @Test
        public void filesKeepTheirFirstRoleAndOrder() {
            // given
            final RunRecord record = record();

            // when
            record.input(folder.resolve("data.csv"));
            record.output(folder.resolve("model.pson"));
            record.output(folder.resolve("data.csv"));

            // then
            Assertions.assertEquals(List.of(RunRecord.Role.INPUT, RunRecord.Role.OUTPUT), List.copyOf(record.files().values()));
        }

        @Test
        public void onlyFileUrisAreConfigurationFiles() {
            // given
            final RunRecord record = record();

            // when
            record.configuration(URI.createFileURI(folder.resolve("search.ol").toString()));
            record.configuration(URI.createURI("classpath:/de/evoal/core/math.dl"));

            // then
            Assertions.assertEquals(List.of(folder.resolve("search.ol")), record.configurationFiles());
        }

        @Test
        public void withoutFolderNothingIsWritten() {
            // given
            final RunRecord record = record();

            // then
            Assertions.assertEquals(Optional.empty(), record.folder());
            Assertions.assertDoesNotThrow(() -> RunRecordWriter.write(record, "app", List.of(), null));
        }
    }

    @Nested
    @DisplayName("given the files of a run")
    class Files_ {
        @Test
        public void pathsAreRelativeToTheExecutionFolder() {
            Assertions.assertEquals("output/data.csv", RunRecordWriter.relative(folder.resolve("output/data.csv"), folder));
            Assertions.assertEquals("../data.csv", RunRecordWriter.relative(folder.getParent().resolve("data.csv"), folder));
        }

        @Test
        public void existingFilesGetSizeAndHashMissingOnesNull() throws IOException {
            // given
            final Path data = folder.resolve("data.csv");
            Files.writeString(data, "abc", StandardCharsets.UTF_8);
            final Map<Path, RunRecord.Role> files = new LinkedHashMap<>();
            files.put(data, RunRecord.Role.INPUT);
            files.put(folder.resolve("missing.csv"), RunRecord.Role.OUTPUT);

            // when
            final ArrayNode array = RunRecordWriter.files(files, folder);

            // then: SHA-256 of "abc"
            Assertions.assertEquals("data.csv", array.get(0).get("path").asString());
            Assertions.assertEquals("input", array.get(0).get("role").asString());
            Assertions.assertEquals(3, array.get(0).get("size").asLong());
            Assertions.assertEquals("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad",
                                    array.get(0).get("sha256").asString());
            Assertions.assertTrue(array.get(1).get("sha256").isNull());
        }

        @Test
        public void configurationCopiesKeepTheirPathsAndExternalFilesGoToExternal() throws IOException {
            // given
            final Path execution = Files.createDirectories(folder.resolve("execution"));
            final Path inside = Files.createDirectories(execution.resolve("model")).resolve("search.ol");
            final Path outside = folder.resolve("shared.ddl");
            Files.writeString(inside, "ol");
            Files.writeString(outside, "ddl");
            final Path target = folder.resolve("record/configuration");

            // when
            RunRecordWriter.copyConfiguration(List.of(inside, outside), execution, target);

            // then
            Assertions.assertEquals("ol", Files.readString(target.resolve("model/search.ol")));
            Assertions.assertEquals("ddl", Files.readString(target.resolve("external/shared.ddl")));
        }
    }

    @Nested
    @DisplayName("given the environment of a run")
    class Environment {
        @Test
        public void onlyEvoalVariablesWithoutTheInstallationFolderAreRecorded() throws IOException {
            // given
            final Path jar = Files.createDirectories(folder.resolve("modules")).resolve("x-1.0.jar");
            Files.writeString(jar, "jar");
            final Map<String, String> variables = Map.of("EVOAL_SEED", "42", "EVOAL_HOME", "/home/someone/evoal", "USER", "someone");

            // when
            final ObjectNode environment = RunRecordWriter.environment(record(), "heuristic-search", List.of("-Bcore:seed=42"), "42",
                                                                       variables, folder,
                                                                       List.of(new InstalledJar(jar, "x", Optional.of("1.0"))));

            // then
            final JsonNode recorded = environment.get("environment");
            Assertions.assertEquals("42", recorded.get("EVOAL_SEED").asString());
            Assertions.assertFalse(recorded.has("EVOAL_HOME"));
            Assertions.assertFalse(recorded.has("USER"));
            Assertions.assertFalse(environment.toString().contains("someone"));

            final JsonNode module = environment.get("modules").get(0);
            Assertions.assertEquals("modules/x-1.0.jar", module.get("file").asString());
            Assertions.assertEquals("x", module.get("module").asString());
            Assertions.assertEquals(64, module.get("sha256").asString().length());

            Assertions.assertEquals("2026-11-23T10:00:00Z", environment.get("start").asString());
            Assertions.assertEquals("42", environment.get("seed").asString());
        }
    }
}

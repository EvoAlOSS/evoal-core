package de.evoal.optimisation.main.statistics.memory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import com.networknt.schema.Error;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SchemaRegistry;
import com.networknt.schema.SpecificationVersion;

/**
 * Validates memory model files against the JSON schemas in
 *   {@code de/evoal/optimisation/schemas/memory-model}. The schema ids are resolved to the
 *   schemas on the class path.
 */
final class MemoryModelSchemas {
    /**
     * The common prefix of the schema ids.
     */
    private static final String ID_PREFIX = "https://www.evoal.de/schemas/memory-model/2027.4.0/";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final SchemaRegistry REGISTRY = SchemaRegistry.withDefaultDialect(
            SpecificationVersion.DRAFT_2020_12,
            builder -> builder.schemaIdResolvers(resolvers -> resolvers.mapPrefix(
                    ID_PREFIX,
                    "classpath:de/evoal/optimisation/schemas/memory-model/")));

    private MemoryModelSchemas() {
    }

    /**
     * @return The violations of the file against the schema that matches its name; empty if
     *   the file is valid.
     */
    static List<String> violationsOf(final Path file) throws IOException {
        final String content = Files.readString(file);
        final JsonNode document = MAPPER.readTree(content);
        final String fileName = file.getFileName().toString();
        final Schema schema = schemaFor(fileName);

        return schema.validate(document)
                     .stream()
                     .map(Error::toString)
                     .map(violation -> fileName + ": " + violation)
                     .toList();
    }

    /**
     * @return The schema of the file, e.g. {@code iteration.schema.json} for
     *   {@code iteration-3.json}.
     */
    private static Schema schemaFor(final String fileName) {
        final String schemaName = fileName.startsWith("iteration-")
                ? "iteration"
                : fileName.replace(".json", "");
        final SchemaLocation location = SchemaLocation.of(ID_PREFIX + schemaName + ".schema.json");

        return REGISTRY.getSchema(location);
    }
}

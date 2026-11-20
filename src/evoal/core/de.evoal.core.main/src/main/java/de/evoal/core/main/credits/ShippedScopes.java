package de.evoal.core.main.credits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ObjectNode;

/**
 * Marks in a module's CycloneDX SBOM ({@value CreditsFiles#SBOM_FILE}) which libraries the
 *   module ships. The SBOM that the build generates lists the whole dependency graph, but the
 *   release does not contain every library of it: a plugin ships only its direct dependencies,
 *   and core.main leaves out some libraries (e.g. {@code jsr305}). The shipped libraries and the
 *   ones inside a shipped jar ({@link LibraryCredits#contains()}) get the CycloneDX scope
 *   {@value #REQUIRED}, all others {@value #EXCLUDED}. Tools that read the SBOM, e.g. GitLab's
 *   dependency scanning, can so tell what the module really ships, while the dependency graph
 *   stays complete.
 * <p>
 * {@link CreditsCheck} calls it during the build, before the SBOM is packed into the jar. Marking
 *   twice gives the same document.
 */
public final class ShippedScopes {
    /**
     * The CycloneDX scope of a library that the module does not ship.
     */
    public static final String EXCLUDED = "excluded";

    /**
     * Writes the SBOM indented, as the build generates it.
     */
    private static final JsonMapper MAPPER = JsonMapper.builder()
                                                       .enable(SerializationFeature.INDENT_OUTPUT)
                                                       .build();

    /**
     * The CycloneDX scope of a library that the module ships.
     */
    public static final String REQUIRED = "required";

    /**
     * The CycloneDX field of the scope.
     */
    private static final String SCOPE = "scope";

    private ShippedScopes() {
    }

    /**
     * Marks the components of the SBOM.
     *
     * @param json The content of {@value CreditsFiles#SBOM_FILE}.
     * @param shipped The coordinates ({@code groupId:artifactId}) of the shipped libraries,
     *   including the ones inside a shipped jar.
     * @return The SBOM with the scope of every component set; the rest of the document is
     *   unchanged.
     * @throws tools.jackson.core.JacksonException if the content is no JSON.
     */
    public static String mark(final String json, final Set<String> shipped) {
        final JsonNode document = MAPPER.readTree(json);

        for(final JsonNode component : document.path("components")) {
            if(!(component instanceof final ObjectNode node)) {
                continue;
            }

            final String coordinates = node.path("group").asString("") + ":" + node.path("name").asString("");
            final boolean isShipped = shipped.contains(coordinates);
            node.put(SCOPE, isShipped ? REQUIRED : EXCLUDED);
        }

        return MAPPER.writeValueAsString(document) + "\n";
    }

    /**
     * Marks the components of the SBOM file; the file is only written if its content changes.
     *
     * @param sbom The SBOM file.
     * @param shipped The coordinates of the shipped libraries, see {@link #mark(String, Set)}.
     * @throws IOException if the file cannot be read or written.
     */
    public static void mark(final Path sbom, final Set<String> shipped) throws IOException {
        final String json = Files.readString(sbom);
        final String marked = mark(json, shipped);

        if(!marked.equals(json)) {
            Files.writeString(sbom, marked);
        }
    }
}

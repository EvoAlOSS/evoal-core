package de.evoal.core.main.credits;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

public class CreditsCheckTest {
    /**
     * The licences whose texts the check knows in these tests.
     */
    private static final Set<String> KNOWN_LICENSES = Set.of("Apache-2.0", "MIT", "EPL-2.0");

    /**
     * The file name of the module jar.
     */
    private static final String MODULE_JAR = "plugin-1.0.jar";

    /**
     * The SBOM components written by {@link #writeSbom()}.
     */
    private final List<String> components = new ArrayList<>();

    /**
     * The folder with the files of {@link CreditsFiles}.
     */
    private Path creditsFolder;

    /**
     * The folder with the module jar and the jars it ships.
     */
    private Path shippedFolder;

    @TempDir
    private Path temporaryFolder;

    /**
     * Adds a jar to the shipped folder and its component to the SBOM.
     *
     * @param licenses The licence entries of the component as CycloneDX JSON.
     */
    private void addShipped(final String group, final String name, final String licenses) throws IOException {
        final String fileName = name + "-1.0.jar";
        final byte[] content = (group + ":" + name).getBytes(StandardCharsets.UTF_8);
        Files.write(shippedFolder.resolve(fileName), content);

        addToSbom(group, name, licenses, content);
    }

    private void addToSbom(final String group, final String name, final String licenses, final byte[] content) {
        final String hash = sha256Of(content);
        components.add("""
                {
                    "group": "%s",
                    "name": "%s",
                    "version": "1.0",
                    "licenses": [%s],
                    "hashes": [{"alg": "SHA-1", "content": "00"}, {"alg": "SHA-256", "content": "%s"}]
                }""".formatted(group, name, licenses, hash));
    }

    @Test
    public void ambiguousLicenseNeedsAChoice() throws IOException {
        addShipped("org.example", "dual", license("EPL-2.0") + ", " + license("GPL-2.0-with-classpath-exception"));
        writeCredits("""
                {"libraries": [{"library": "org.example:dual", "purpose": "Test."}]}""");

        final List<String> problems = check();

        Assertions.assertEquals(1, problems.size(), problems.toString());
        Assertions.assertTrue(problems.get(0).contains("several licences"), problems.toString());
    }

    private List<String> check() throws IOException {
        writeSbom();

        final CreditsCheck check = new CreditsCheck(creditsFolder, shippedFolder, MODULE_JAR, KNOWN_LICENSES::contains);

        return check.run();
    }

    @Test
    public void choiceOfLicenseIsAccepted() throws IOException {
        addShipped("org.example", "dual", license("EPL-2.0") + ", " + license("GPL-2.0-with-classpath-exception"));
        writeCredits("""
                {"libraries": [{"library": "org.example:dual", "purpose": "Test.", "licenses": ["EPL-2.0"]}]}""");

        Assertions.assertEquals(List.of(), check());
    }

    @Test
    public void completeCreditsHaveNoProblems() throws IOException {
        addShipped("org.example", "library", license("Apache-2.0"));
        addShipped("de.evoal.languages", "language", "");
        addToSbom("org.example", "not-shipped", "", new byte[] {1, 2, 3});
        Files.writeString(shippedFolder.resolve(MODULE_JAR), "the module itself");
        writeCredits("""
                {
                    "libraries": [
                        {
                            "library": "org.example:library",
                            "purpose": "Test.",
                            "citations": ["key"],
                            "bundled": [{"name": "native", "licenses": ["MIT"], "url": "https://example.org"}]
                        }
                    ]
                }""");
        Files.writeString(creditsFolder.resolve(CreditsFiles.CITATIONS_FILE), "@misc{key, title = {Title}}");

        Assertions.assertEquals(List.of(), check());
        Assertions.assertEquals(Map.of("library", ShippedScopes.REQUIRED,
                                       "language", ShippedScopes.REQUIRED,
                                       "not-shipped", ShippedScopes.EXCLUDED),
                                scopes());
    }

    @Test
    public void markingTwiceGivesTheSameSbom() throws IOException {
        addShipped("org.example", "library", license("MIT"));
        addToSbom("org.example", "not-shipped", "", new byte[] {1});
        writeCredits("""
                {"libraries": [{"library": "org.example:library", "purpose": "Test."}]}""");

        Assertions.assertEquals(List.of(), check());
        final String marked = readSbom();

        final CreditsCheck again = new CreditsCheck(creditsFolder, shippedFolder, MODULE_JAR, KNOWN_LICENSES::contains);
        Assertions.assertEquals(List.of(), again.run());
        Assertions.assertEquals(marked, readSbom());
    }

    @Test
    public void containedLibrariesAreChecked() throws IOException {
        addShipped("org.example", "merged", license("EPL-2.0"));
        addShipped("org.example", "separate", license("MIT"));
        addToSbom("org.example", "unlicensed", "", new byte[] {1});
        addToSbom("de.evoal.languages", "language", "", new byte[] {2});
        writeCredits("""
                {
                    "libraries": [
                        {
                            "library": "org.example:merged",
                            "purpose": "Test.",
                            "contains": ["org.example:missing", "org.example:separate", "org.example:unlicensed",
                                         "de.evoal.languages:language", "org.example:missing"]
                        },
                        {"library": "org.example:separate", "purpose": "Test."}
                    ]
                }""");
        final String original = sbomWithComponents();

        final List<String> problems = check();

        Assertions.assertEquals(List.of("The library 'org.example:missing' inside 'org.example:merged' is not part of "
                                        + "the SBOM of the module.",
                                        "The library 'org.example:separate' inside 'org.example:merged' is also "
                                        + "shipped as a jar of its own.",
                                        "The POM of 'org.example:unlicensed' states no licence; a library inside "
                                        + "another one is used under the licence of its POM.",
                                        "The library 'de.evoal.languages:language' inside 'org.example:merged' is "
                                        + "one of EvoAl's own artifacts.",
                                        "The library 'org.example:missing' inside 'org.example:merged' is named twice "
                                        + "in 'contains'."),
                                problems);
        Assertions.assertEquals(original, readSbom(), "An SBOM with problems is not marked.");
    }

    @Test
    public void containedLibraryNeedsNoEntryAndIsMarkedAsShipped() throws IOException {
        addShipped("org.example", "merged", license("EPL-2.0"));
        addToSbom("org.example", "inner", license("EPL-2.0"), new byte[] {1});
        addToSbom("org.example", "not-shipped", "", new byte[] {2});
        writeCredits("""
                {"libraries": [{"library": "org.example:merged", "purpose": "Test.", "contains": ["org.example:inner"]}]}""");

        Assertions.assertEquals(List.of(), check());
        Assertions.assertEquals(Map.of("merged", ShippedScopes.REQUIRED,
                                       "inner", ShippedScopes.REQUIRED,
                                       "not-shipped", ShippedScopes.EXCLUDED),
                                scopes());
    }

    @Test
    public void entryWithoutShippedLibraryIsReported() throws IOException {
        writeCredits("""
                {"libraries": [{"library": "org.example:gone", "purpose": "Test."}]}""");

        final List<String> problems = check();

        Assertions.assertEquals(1, problems.size(), problems.toString());
        Assertions.assertTrue(problems.get(0).contains("names no third-party library"), problems.toString());
    }

    @Test
    public void invalidBibTeXIsReported() throws IOException {
        Files.writeString(creditsFolder.resolve(CreditsFiles.CITATIONS_FILE), "@misc{key, title = {A}");

        final List<String> problems = check();

        Assertions.assertEquals(1, problems.size(), problems.toString());
        Assertions.assertTrue(problems.get(0).startsWith("credits.bib is not valid"), problems.toString());
    }

    @Test
    public void invalidCitationsAreReported() throws IOException {
        addShipped("org.example", "library", license("MIT"));
        writeCredits("""
                {"libraries": [{"library": "org.example:library", "purpose": "Test.", "citations": ["missing"]}]}""");
        Files.writeString(creditsFolder.resolve(CreditsFiles.CITATIONS_FILE), "@misc{unused, year = 2000}");

        final List<String> problems = check();

        Assertions.assertEquals(3, problems.size(), problems.toString());
        Assertions.assertTrue(problems.get(0).contains("'missing'"), problems.toString());
        Assertions.assertTrue(problems.get(1).contains("'unused'"), problems.toString());
        Assertions.assertTrue(problems.get(2).contains("has no title"), problems.toString());
    }

    @Test
    public void jarOutsideOfTheSbomIsReported() throws IOException {
        Files.writeString(shippedFolder.resolve("unknown.jar"), "unknown");

        final List<String> problems = check();

        Assertions.assertEquals(List.of("The shipped jar 'unknown.jar' is not part of the SBOM of the module."),
                                problems);
    }

    /**
     * @return A CycloneDX licence entry with an SPDX id.
     */
    private static String license(final String id) {
        return "{\"license\": {\"id\": \"" + id + "\"}}";
    }

    @Test
    public void licenseWithoutSpdxIdIsReported() throws IOException {
        addShipped("org.example", "library", "{\"license\": {\"name\": \"Public Domain\"}}");
        writeCredits("""
                {"libraries": [{"library": "org.example:library", "purpose": "Test."}]}""");

        final List<String> problems = check();

        Assertions.assertEquals(1, problems.size(), problems.toString());
        Assertions.assertTrue(problems.get(0).contains("without SPDX id [Public Domain]"), problems.toString());
    }

    @Test
    public void licenseWithoutTextIsReported() throws IOException {
        addShipped("org.example", "library", license("BSD-3-Clause"));
        writeCredits("""
                {"libraries": [{"library": "org.example:library", "purpose": "Test."}]}""");

        final List<String> problems = check();

        Assertions.assertEquals(1, problems.size(), problems.toString());
        Assertions.assertTrue(problems.get(0).contains("no text for the licence 'BSD-3-Clause'"), problems.toString());
    }

    @Test
    public void missingSbomIsReported() {
        final CreditsCheck check = new CreditsCheck(creditsFolder, shippedFolder, MODULE_JAR, KNOWN_LICENSES::contains);

        final List<String> problems = check.run();

        Assertions.assertEquals(1, problems.size(), problems.toString());
        Assertions.assertTrue(problems.get(0).contains("is missing"), problems.toString());
    }

    @Test
    public void missingShippedFolderMeansNothingIsShipped() throws IOException {
        addToSbom("org.example", "not-shipped", "", new byte[] {1});
        Files.delete(shippedFolder);

        Assertions.assertEquals(List.of(), check());
        Assertions.assertEquals(Map.of("not-shipped", ShippedScopes.EXCLUDED), scopes());
    }

    @Test
    public void misspeltFieldIsReported() throws IOException {
        writeCredits("""
                {"libraries": [{"library": "org.example:library", "purpose": "Test.", "licence": ["MIT"]}]}""");

        final List<String> problems = check();

        Assertions.assertEquals(1, problems.size(), problems.toString());
        Assertions.assertTrue(problems.get(0).startsWith("credits.json is not valid"), problems.toString());
    }

    @Test
    public void moduleCitationsAreChecked() throws IOException {
        writeCredits("""
                {"citations": ["module", "missing"], "libraries": []}""");
        Files.writeString(creditsFolder.resolve(CreditsFiles.CITATIONS_FILE), "@misc{module, title = {Paper}}");

        final List<String> problems = check();

        Assertions.assertEquals(List.of("The citation 'missing' of the module is missing in credits.bib."), problems);
    }

    @BeforeEach
    public void prepareFolders() throws IOException {
        creditsFolder = Files.createDirectory(temporaryFolder.resolve("credits"));
        shippedFolder = Files.createDirectory(temporaryFolder.resolve("shipped"));
    }

    private String readSbom() throws IOException {
        return Files.readString(creditsFolder.resolve(CreditsFiles.SBOM_FILE));
    }

    /**
     * @return The SBOM that {@link #writeSbom()} writes.
     */
    private String sbomWithComponents() {
        final String list = String.join(",\n", components);

        return "{\"bomFormat\": \"CycloneDX\", \"components\": [" + list + "]}";
    }

    /**
     * @return The scopes of the components of the SBOM file by name.
     */
    private Map<String, String> scopes() throws IOException {
        final JsonNode sbom = JsonMapper.builder()
                                        .build()
                                        .readTree(readSbom());
        final Map<String, String> scopes = new HashMap<>();
        for(final JsonNode component : sbom.path("components")) {
            scopes.put(component.path("name").asString(), component.path("scope").asString());
        }

        return scopes;
    }

    private static String sha256Of(final byte[] content) {
        try {
            final byte[] hash = MessageDigest.getInstance("SHA-256")
                                             .digest(content);

            return HexFormat.of()
                            .formatHex(hash);
        } catch(final NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void shippedLibraryWithoutEntryIsReported() throws IOException {
        addShipped("org.example", "library", license("MIT"));

        final List<String> problems = check();

        Assertions.assertEquals(List.of("The shipped library 'org.example:library' (version 1.0) has no entry in "
                                        + "credits.json."),
                                problems);
    }

    private void writeCredits(final String json) throws IOException {
        Files.writeString(creditsFolder.resolve(CreditsFiles.CREDITS_FILE), json);
    }

    private void writeSbom() throws IOException {
        Files.writeString(creditsFolder.resolve(CreditsFiles.SBOM_FILE), sbomWithComponents());
    }
}

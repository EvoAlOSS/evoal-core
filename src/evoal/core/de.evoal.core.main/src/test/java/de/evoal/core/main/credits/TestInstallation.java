package de.evoal.core.main.credits;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Builds an installation for the tests: folders with library jars and EvoAl module jars whose
 *   SBOM lists the libraries of their folder with the hashes of the jars.
 */
final class TestInstallation {
    /**
     * The SBOM components of the libraries per folder.
     */
    private final Map<String, List<String>> componentsByFolder = new HashMap<>();

    /**
     * All jars of the installation.
     */
    private final List<Path> jars = new ArrayList<>();

    /**
     * The folder of the installation.
     */
    private final Path root;

    TestInstallation(final Path root) {
        this.root = root;
    }

    /**
     * Builds the installation that the tests of the credits share:
     * <ul>
     *   <li>{@code modules}: core.main with a citation of EvoAl, the libraries
     *     {@code shared-lib} (Apache-2.0, with a NOTICE, contains {@code inner-lib} under
     *     BSD-3-Clause, which has no jar of its own) and {@code gpl-lib} (GPL-3.0-only in the
     *     SBOM, GPL-3.0-or-later in the credits), EvoAl's {@code language} and a jar outside of
     *     the SBOM;</li>
     *   <li>{@code plugins/arff}: a plugin with {@code plugin-lib} (dual licence, EPL-2.0
     *     chosen, with a citation and bundled MIT code);</li>
     *   <li>{@code plugins/other}: a plugin that ships {@code shared-lib} as well.</li>
     * </ul>
     */
    static TestInstallation example(final Path root) throws IOException {
        final TestInstallation installation = new TestInstallation(root);

        installation.library("modules", "org.example", "shared-lib", license("Apache-2.0"),
                             Map.of("META-INF/NOTICE.txt", "Shared Lib\nCopyright The Shared Authors"));
        installation.component("modules", "org.example", "inner-lib", license("BSD-3-Clause"));
        installation.library("modules", "org.example", "gpl-lib", license("GPL-3.0-only"), Map.of());
        installation.library("modules", "de.evoal.languages", "language", "", Map.of());
        installation.module("modules", "core.main", """
                {
                    "citations": ["evoal"],
                    "libraries": [
                        {
                            "library": "org.example:shared-lib",
                            "purpose": "Shares things.",
                            "contains": ["org.example:inner-lib"]
                        },
                        {"library": "org.example:gpl-lib", "purpose": "Is free.", "licenses": ["GPL-3.0-or-later"]}
                    ]
                }""", """
                @inproceedings{evoal,
                    author = {Ada Lovelace and Alan Turing},
                    title = {{EvoAl} - Optimisation},
                    booktitle = {Proceedings},
                    pages = {1--9},
                    year = 2024,
                    doi = {10.1/evoal}
                }""");
        installation.writeJar("modules", "stray.jar", Map.of("stray.txt", "not in the SBOM"));

        installation.library("plugins/arff", "org.example", "plugin-lib",
                             license("EPL-2.0") + ", " + license("GPL-2.0-with-classpath-exception"), Map.of());
        installation.module("plugins/arff", "core.arff", """
                {
                    "libraries": [
                        {
                            "library": "org.example:plugin-lib",
                            "purpose": "Reads files.",
                            "licenses": ["EPL-2.0"],
                            "citations": ["paper"],
                            "bundled": [{"name": "native", "licenses": ["MIT"], "url": "https://example.org/native"}]
                        }
                    ]
                }""", """
                @misc{paper, author = {Grace Hopper}, title = {The Library}, howpublished = {Online}, year = 2016}""");

        installation.library("plugins/other", "org.example", "shared-lib", license("Apache-2.0"),
                             Map.of("META-INF/NOTICE.txt", "Shared Lib\nCopyright The Shared Authors"));
        installation.module("plugins/other", "other", """
                {"libraries": [{"library": "org.example:shared-lib", "purpose": "Shares more."}]}""", null);

        return installation;
    }

    /**
     * Adds a component without a jar of its own to the folder's SBOM, e.g. a library inside
     *   another library's jar.
     *
     * @param licenses The licence entries of the component as CycloneDX JSON.
     */
    void component(final String folder, final String group, final String name, final String licenses) {
        final String component = """
                {
                    "group": "%s",
                    "name": "%s",
                    "version": "1.0",
                    "licenses": [%s]
                }""".formatted(group, name, licenses);
        componentsByFolder.computeIfAbsent(folder, ignored -> new ArrayList<>())
                          .add(component);
    }

    /**
     * @return The folder of the installation, e.g. {@code modules} or {@code plugins/arff}.
     */
    Path folder(final String folder) {
        return root.resolve(folder);
    }

    List<Path> jars() {
        return List.copyOf(jars);
    }

    /**
     * Adds a library jar to the folder and its component to the folder's SBOM.
     *
     * @param licenses The licence entries of the component as CycloneDX JSON.
     * @param entries Further files of the jar by name, e.g. {@code META-INF/NOTICE}.
     */
    Path library(final String folder,
                 final String group,
                 final String name,
                 final String licenses,
                 final Map<String, String> entries) throws IOException {
        final Map<String, String> content = new LinkedHashMap<>(entries);
        content.put("library.txt", group + ":" + name);

        final Path jar = writeJar(folder, name + "-1.0.jar", content);
        final String hash = CreditsFiles.hashOf(jar);
        final String component = """
                {
                    "group": "%s",
                    "name": "%s",
                    "version": "1.0",
                    "licenses": [%s],
                    "hashes": [{"alg": "SHA-256", "content": "%s"}],
                    "externalReferences": [{"type": "website", "url": "https://example.org/%s"}]
                }""".formatted(group, name, licenses, hash, name);
        componentsByFolder.computeIfAbsent(folder, ignored -> new ArrayList<>())
                          .add(component);

        return jar;
    }

    /**
     * @return A CycloneDX licence entry with an SPDX id.
     */
    static String license(final String id) {
        return "{\"license\": {\"id\": \"" + id + "\"}}";
    }

    /**
     * Adds an EvoAl module jar to the folder; its SBOM lists the libraries added to the folder
     *   before.
     *
     * @param credits The content of {@value CreditsFiles#CREDITS_FILE}, {@code null} for none.
     * @param citations The content of {@value CreditsFiles#CITATIONS_FILE}, {@code null} for none.
     */
    Path module(final String folder, final String name, final String credits, final String citations)
            throws IOException {
        final List<String> components = componentsByFolder.getOrDefault(folder, List.of());
        final String sbom = """
                {
                    "bomFormat": "CycloneDX",
                    "metadata": {"component": {"group": "de.evoal", "name": "%s", "version": "2.0"}},
                    "components": [%s]
                }""".formatted(name, String.join(",\n", components));

        final Map<String, String> content = new LinkedHashMap<>();
        content.put(CreditsFiles.FOLDER + "/" + CreditsFiles.SBOM_FILE, sbom);
        if(credits != null) {
            content.put(CreditsFiles.FOLDER + "/" + CreditsFiles.CREDITS_FILE, credits);
        }

        if(citations != null) {
            content.put(CreditsFiles.FOLDER + "/" + CreditsFiles.CITATIONS_FILE, citations);
        }

        return writeJar(folder, name + "-2.0.jar", content);
    }

    private Path writeJar(final String folder, final String fileName, final Map<String, String> content)
            throws IOException {
        final Path directory = Files.createDirectories(root.resolve(folder));
        final Path jar = directory.resolve(fileName);

        try(OutputStream file = Files.newOutputStream(jar);
            ZipOutputStream zip = new ZipOutputStream(file)) {
            for(final Map.Entry<String, String> entry : content.entrySet()) {
                zip.putNextEntry(new ZipEntry(entry.getKey()));
                zip.write(entry.getValue().getBytes(StandardCharsets.UTF_8));
                zip.closeEntry();
            }
        }

        jars.add(jar);

        return jar;
    }
}

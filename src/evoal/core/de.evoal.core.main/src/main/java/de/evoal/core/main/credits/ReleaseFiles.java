package de.evoal.core.main.credits;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

/**
 * Writes the licence files of a release from the credits of the installation
 *   ({@code evoal-credits.sh release-files <folder>}, called by {@code ci/create-release.sh}):
 * <ul>
 *   <li>{@value #LICENSES_FOLDER}{@code /<SPDX id>.txt}: the text of every licence of the
 *     release, EvoAl's own (Apache-2.0) included;</li>
 *   <li>{@value #NOTICE_FILE}: EvoAl's notice, a statement if libraries or bundled code under
 *     the GPL are part of the release, the copyright notices of the third-party code inside the
 *     modules' jars ({@link ModuleCredits#bundled()}), and the notice files of the libraries
 *     with the copyright notices of their bundled code;</li>
 *   <li>{@value #SBOM_FILE}: the CycloneDX SBOM of the release, with the licences under which
 *     EvoAl uses the libraries; a library inside another library's jar
 *     ({@link LibraryCredits#contains()}) is a component of its own, after its container.</li>
 * </ul>
 * EvoAl's licence ({@code LICENSE.md}) is copied by the release script.
 */
public final class ReleaseFiles {
    /**
     * EvoAl's own licence.
     */
    public static final String EVOAL_LICENSE = "Apache-2.0";

    /**
     * The prefixes of the licences that make the release as a whole a GPL work.
     */
    private static final List<String> GPL_PREFIXES = List.of("GPL-", "AGPL-");

    /**
     * The folder with the licence texts.
     */
    public static final String LICENSES_FOLDER = "licenses";

    /**
     * Writes the SBOM indented.
     */
    private static final JsonMapper MAPPER = JsonMapper.builder()
                                                       .enable(SerializationFeature.INDENT_OUTPUT)
                                                       .build();

    /**
     * The notice files of a library jar, e.g. {@code META-INF/NOTICE.txt}.
     */
    private static final Pattern NOTICE_ENTRY = Pattern.compile("(META-INF/)?NOTICE(\\.txt|\\.md)?",
                                                                Pattern.CASE_INSENSITIVE);

    /**
     * The notice file.
     */
    public static final String NOTICE_FILE = "NOTICE";

    /**
     * The SBOM of the release.
     */
    public static final String SBOM_FILE = "sbom.json";

    /**
     * The separator between the notices of the libraries.
     */
    private static final String SEPARATOR = "-".repeat(80);

    private ReleaseFiles() {
    }

    /**
     * @return The GPL libraries of the release, e.g. {@code smile-core 5.0.1 (core)}, and the
     *   GPL licences they use.
     */
    private static List<String> gplLibraries(final InstalledCredits credits, final Set<String> gplLicenses) {
        final List<String> libraries = new ArrayList<>();
        for(final InstalledModule module : credits.modules()) {
            for(final BundledCredits bundled : module.bundled()) {
                final List<String> licenses = gplLicensesOf(bundled.licenses().stream());
                if(licenses.isEmpty()) {
                    continue;
                }

                gplLicenses.addAll(licenses);
                libraries.add(bundled.name() + " (" + module.name() + ")");
            }
        }

        for(final InstalledLibrary library : credits.libraries()) {
            final Stream<String> containedLicenses = library.contained()
                                                            .stream()
                                                            .flatMap(contained -> contained.licenseIds().stream());
            final Stream<String> bundledLicenses = library.bundled()
                                                          .stream()
                                                          .flatMap(bundled -> bundled.licenses().stream());
            final Stream<String> allLicenses = Stream.of(library.licenses().stream(), containedLicenses, bundledLicenses)
                                                     .flatMap(Function.identity());
            final List<String> licenses = gplLicensesOf(allLicenses);
            if(licenses.isEmpty()) {
                continue;
            }

            gplLicenses.addAll(licenses);

            final String modules = String.join(", ", library.uses().stream().map(LibraryUse::module).toList());
            libraries.add(library.component().name() + " " + library.component().version() + " (" + modules + ")");
        }

        return libraries;
    }

    /**
     * @return The GPL licences among the licences, without duplicates.
     */
    private static List<String> gplLicensesOf(final Stream<String> licenseIds) {
        return licenseIds.filter(ReleaseFiles::isGpl)
                         .distinct()
                         .toList();
    }

    private static boolean isGpl(final String licenseId) {
        return GPL_PREFIXES.stream()
                           .anyMatch(licenseId::startsWith);
    }

    /**
     * @return Whether the jar entry is a notice file.
     */
    private static boolean isNotice(final String entryName) {
        return NOTICE_ENTRY.matcher(entryName)
                           .matches();
    }

    /**
     * @return The CycloneDX licence entries of the ids: SPDX ids as {@code id}, EvoAl's own
     *   references ({@code LicenseRef-...}) as {@code name}.
     */
    private static ArrayNode licenseEntries(final List<String> licenseIds) {
        final ArrayNode entries = MAPPER.createArrayNode();
        for(final String licenseId : licenseIds) {
            final ObjectNode license = MAPPER.createObjectNode();
            final boolean isReference = licenseId.startsWith("LicenseRef-");
            license.put(isReference ? "name" : "id", licenseId);

            entries.addObject()
                   .set("license", license);
        }

        return entries;
    }

    /**
     * @return The notice files of the jar, in the order of their names.
     */
    private static List<String> noticesOf(final Path jar) throws IOException {
        final List<String> notices = new ArrayList<>();
        try(ZipFile zip = new ZipFile(jar.toFile())) {
            final List<? extends ZipEntry> entries = zip.stream()
                                                        .filter(entry -> isNotice(entry.getName()))
                                                        .sorted(Comparator.comparing(ZipEntry::getName))
                                                        .toList();
            for(final ZipEntry entry : entries) {
                try(InputStream stream = zip.getInputStream(entry)) {
                    final byte[] content = stream.readAllBytes();
                    notices.add(new String(content, StandardCharsets.UTF_8).strip());
                }
            }
        }

        return notices;
    }

    /**
     * @return The ids of all licences of the release, EvoAl's own included, sorted.
     */
    private static Set<String> releaseLicenses(final InstalledCredits credits) {
        final Set<String> licenseIds = new TreeSet<>();
        licenseIds.add(EVOAL_LICENSE);

        for(final InstalledModule module : credits.modules()) {
            module.bundled()
                  .forEach(bundled -> licenseIds.addAll(bundled.licenses()));
        }

        for(final InstalledLibrary library : credits.libraries()) {
            licenseIds.addAll(library.licenses());
            library.bundled()
                   .forEach(bundled -> licenseIds.addAll(bundled.licenses()));
            library.contained()
                   .forEach(contained -> licenseIds.addAll(contained.licenseIds()));
        }

        return licenseIds;
    }

    /**
     * @return The component of the SBOM with the given licences instead of the ones of its POM.
     */
    private static ObjectNode withLicenses(final SbomComponent component, final List<String> licenseIds) {
        final ObjectNode node = ((ObjectNode) component.source()).deepCopy();
        node.set("licenses", licenseEntries(licenseIds));

        return node;
    }

    /**
     * Writes the licence files of the release into the folder.
     *
     * @param credits The credits of the installation.
     * @param folder The folder of the release.
     * @throws IOException if a file cannot be written or a jar cannot be read.
     * @throws IllegalStateException if core.main has no text for a licence (the build check
     *   prevents this).
     */
    public static void write(final InstalledCredits credits, final Path folder) throws IOException {
        writeLicenses(credits, folder);
        writeNotice(credits, folder);
        writeSbom(credits, folder);
    }

    private static void writeLicenses(final InstalledCredits credits, final Path folder) throws IOException {
        final Path licensesFolder = folder.resolve(LICENSES_FOLDER);
        Files.createDirectories(licensesFolder);

        for(final String licenseId : releaseLicenses(credits)) {
            final Optional<String> text = CreditsFiles.readLicenseText(licenseId);
            if(text.isEmpty()) {
                throw new IllegalStateException("core.main has no text for the licence '" + licenseId + "'.");
            }

            Files.writeString(licensesFolder.resolve(licenseId + ".txt"), text.get());
        }
    }

    private static void writeNotice(final InstalledCredits credits, final Path folder) throws IOException {
        final List<String> lines = new ArrayList<>();
        lines.add("EvoAl");
        lines.add("https://gitlab.informatik.uni-bremen.de/evoal/source/evoal-core");
        lines.add("");
        lines.add("EvoAl's own code is licensed under the Apache License 2.0 (LICENSE.md). The release contains");
        lines.add("third-party libraries under their own licences: their texts are in " + LICENSES_FOLDER
                  + "/, " + SBOM_FILE + " describes");
        lines.add("the libraries, and 'bin/evoal-credits.sh' lists them with what EvoAl uses them for.");

        final Set<String> gplLicenses = new TreeSet<>();
        final List<String> gplLibraries = gplLibraries(credits, gplLicenses);
        if(!gplLibraries.isEmpty()) {
            final String licenses = String.join(", ", gplLicenses);

            lines.add("");
            lines.add("The release contains libraries licensed under the GNU General Public License ("
                      + licenses + "):");
            gplLibraries.forEach(library -> lines.add("  - " + library));
            lines.add("The release as a whole is therefore distributed under the terms of the GNU General Public");
            lines.add("License (" + licenses + "). EvoAl's own code remains available under the Apache License 2.0.");
        }

        for(final InstalledModule module : credits.modules()) {
            for(final BundledCredits bundled : module.bundled()) {
                lines.add("");
                lines.add(SEPARATOR);
                lines.add(bundled.name() + ", part of " + module.name());
                lines.add(SEPARATOR);
                lines.addAll(noticeOf(bundled));
            }
        }

        for(final InstalledLibrary library : credits.libraries()) {
            final List<String> notices = new ArrayList<>(noticesOf(library.jar()));
            for(final BundledCredits bundled : library.bundled()) {
                if(bundled.copyright() != null) {
                    notices.add(bundled.name() + ":\n" + String.join("\n", noticeOf(bundled)));
                }
            }

            if(notices.isEmpty()) {
                continue;
            }

            final SbomComponent component = library.component();
            lines.add("");
            lines.add(SEPARATOR);
            lines.add(component.name() + " " + component.version() + " (" + library.coordinates() + ")");
            lines.add(SEPARATOR);
            lines.addAll(notices);
        }

        Files.write(folder.resolve(NOTICE_FILE), lines, StandardCharsets.UTF_8);
    }

    /**
     * @return The notice of bundled code: its copyright notice, its project link and the files
     *   of its licence texts in the release.
     */
    private static List<String> noticeOf(final BundledCredits bundled) {
        final List<String> lines = new ArrayList<>();
        if(bundled.copyright() != null) {
            lines.add(bundled.copyright().strip());
        }

        if(bundled.url() != null) {
            lines.add(bundled.url());
        }

        final List<String> texts = bundled.licenses()
                                          .stream()
                                          .map(licenseId -> LICENSES_FOLDER + "/" + licenseId + ".txt")
                                          .toList();
        lines.add("Licensed under " + String.join(", ", bundled.licenses()) + " (" + String.join(", ", texts) + ").");

        return lines;
    }

    private static void writeSbom(final InstalledCredits credits, final Path folder) throws IOException {
        final InstalledModule core = credits.modules()
                                            .stream()
                                            .filter(module -> module.name().equals(CreditsCollector.CORE_MODULE))
                                            .findFirst()
                                            .orElseThrow(() -> new IllegalStateException("The installation has no "
                                                                                         + "core.main."));

        final ObjectNode release = MAPPER.createObjectNode();
        release.put("type", "application");
        release.put("name", "EvoAl");
        release.put("version", core.component().version());
        release.set("licenses", licenseEntries(List.of(EVOAL_LICENSE)));

        final ObjectNode sbom = MAPPER.createObjectNode();
        sbom.put("bomFormat", "CycloneDX");
        sbom.put("specVersion", "1.6");
        sbom.put("version", 1);
        sbom.putObject("metadata")
            .set("component", release);

        final ArrayNode components = sbom.putArray("components");
        for(final InstalledModule module : credits.modules()) {
            components.add(withLicenses(module.component(), List.of(EVOAL_LICENSE)));
        }

        for(final SbomComponent component : credits.evoalComponents()) {
            components.add(withLicenses(component, List.of(EVOAL_LICENSE)));
        }

        for(final InstalledLibrary library : credits.libraries()) {
            components.add(withLicenses(library.component(), library.licenses()));

            for(final SbomComponent contained : library.contained()) {
                components.add(withLicenses(contained, contained.licenseIds()));
            }
        }

        final String json = MAPPER.writeValueAsString(sbom) + "\n";
        Files.writeString(folder.resolve(SBOM_FILE), json);
    }
}

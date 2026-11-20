package de.evoal.core.main.credits;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tools.jackson.core.JacksonException;

/**
 * Checks the credits of a module during the build: every shipped third-party library has an
 *   entry in {@value CreditsFiles#CREDITS_FILE} with a purpose and a licence whose text
 *   core.main holds, every entry names a shipped library, and the citations exist in
 *   {@value CreditsFiles#CITATIONS_FILE}.
 * <p>
 * A library counts as shipped if a jar with the SHA-256 hash of its SBOM component lies in the
 *   folder that the build fills for the release ({@code target/<artifactId>}). Libraries of
 *   the SBOM that the module does not ship, e.g. transitive dependencies of a plugin, are
 *   ignored. EvoAl's own artifacts need no entry.
 * <p>
 * The build calls {@link #main(String...)} in the {@code package} phase.
 */
public final class CreditsCheck {
    /**
     * The folder with the files of {@link CreditsFiles} ({@code target/classes/META-INF/evoal}).
     */
    private final Path creditsFolder;

    /**
     * Tells whether core.main holds the text of a licence (SPDX id).
     */
    private final Predicate<String> hasLicenseText;

    /**
     * The file name of the module's own jar in {@link #shippedFolder}.
     */
    private final String moduleJar;

    /**
     * The problems found so far.
     */
    private final List<String> problems = new ArrayList<>();

    /**
     * The folder with the module jar and the jars it ships.
     */
    private final Path shippedFolder;

    /**
     * @param creditsFolder The folder with the files of {@link CreditsFiles}.
     * @param shippedFolder The folder with the module jar and the jars it ships.
     * @param moduleJar The file name of the module's own jar.
     * @param hasLicenseText Tells whether core.main holds the text of a licence.
     */
    public CreditsCheck(final Path creditsFolder,
                        final Path shippedFolder,
                        final String moduleJar,
                        final Predicate<String> hasLicenseText) {
        this.creditsFolder = creditsFolder;
        this.shippedFolder = shippedFolder;
        this.moduleJar = moduleJar;
        this.hasLicenseText = hasLicenseText;
    }

    /**
     * @return A collector into a map by the key; the first component wins if two have the same
     *   key (the SBOM lists a library once).
     */
    private static Collector<SbomComponent, ?, Map<String, SbomComponent>> byKey(
            final Function<SbomComponent, String> key) {
        return Collectors.toMap(key, Function.identity(), (first, second) -> first);
    }

    /**
     * Checks that the cited keys exist and records them as cited.
     *
     * @param citer The module or library that cites, for the message.
     */
    private void checkCitationKeys(final List<String> citations,
                                   final String citer,
                                   final Set<String> keys,
                                   final Set<String> citedKeys) {
        for(final String key : citations) {
            citedKeys.add(key);

            if(!keys.contains(key)) {
                problems.add("The citation '" + key + "' of " + citer + " is missing in "
                             + CreditsFiles.CITATIONS_FILE + ".");
            }
        }
    }

    /**
     * Checks the citations: every key exists, every entry is cited and has a title.
     */
    private void checkCitations(final ModuleCredits credits, final List<BibTeXEntry> entries) {
        final Set<String> keys = entries.stream()
                                        .map(BibTeXEntry::key)
                                        .collect(Collectors.toSet());
        final Set<String> citedKeys = new HashSet<>();

        checkCitationKeys(credits.citations(), "the module", keys, citedKeys);
        for(final LibraryCredits library : credits.libraries()) {
            checkCitationKeys(library.citations(), "'" + library.library() + "'", keys, citedKeys);
        }

        for(final BibTeXEntry entry : entries) {
            if(!citedKeys.contains(entry.key())) {
                problems.add("The entry '" + entry.key() + "' in " + CreditsFiles.CITATIONS_FILE
                             + " is not cited by the module or a library.");
            }

            if(!entry.fields().containsKey("title")) {
                problems.add("The entry '" + entry.key() + "' in " + CreditsFiles.CITATIONS_FILE + " has no title.");
            }
        }
    }

    /**
     * Checks the entries against the shipped libraries.
     */
    private void checkEntries(final ModuleCredits credits, final List<SbomComponent> shipped) {
        final Map<String, SbomComponent> shippedByCoordinates = shipped.stream()
                                                                      .filter(component -> !component.isEvoal())
                                                                      .collect(byKey(SbomComponent::coordinates));
        final Set<String> coordinatesWithEntry = new HashSet<>();

        for(final LibraryCredits library : credits.libraries()) {
            final boolean isNewEntry = coordinatesWithEntry.add(library.library());
            if(!isNewEntry) {
                problems.add("The library '" + library.library() + "' has two entries in "
                             + CreditsFiles.CREDITS_FILE + ".");
                continue;
            }

            final SbomComponent component = shippedByCoordinates.get(library.library());
            if(component == null) {
                problems.add("The entry '" + library.library() + "' in " + CreditsFiles.CREDITS_FILE
                             + " names no third-party library that the module ships.");
                continue;
            }

            checkLibrary(library, component);
        }

        for(final SbomComponent component : shippedByCoordinates.values()) {
            if(!coordinatesWithEntry.contains(component.coordinates())) {
                problems.add("The shipped library '" + component.coordinates() + "' (version " + component.version()
                             + ") has no entry in " + CreditsFiles.CREDITS_FILE + ".");
            }
        }
    }

    /**
     * Checks the purpose, the licences and the bundled code of a shipped library.
     */
    private void checkLibrary(final LibraryCredits library, final SbomComponent component) {
        final boolean hasPurpose = library.purpose() != null && !library.purpose().isBlank();
        if(!hasPurpose) {
            problems.add("The entry '" + library.library() + "' has no purpose.");
        }

        final List<String> licenseIds = licensesOf(library, component);
        checkLicenseTexts(licenseIds, library.library());

        for(final BundledCredits bundled : library.bundled()) {
            final String user = library.library() + "/" + bundled.name();
            final boolean hasName = bundled.name() != null && !bundled.name().isBlank();
            if(!hasName) {
                problems.add("Bundled code of '" + library.library() + "' has no name.");
            }

            if(bundled.licenses().isEmpty()) {
                problems.add("The bundled code '" + user + "' has no licence.");
            }

            checkLicenseTexts(bundled.licenses(), user);
        }
    }

    /**
     * Checks that the licences have texts in core.main.
     */
    private void checkLicenseTexts(final List<String> licenseIds, final String user) {
        for(final String licenseId : licenseIds) {
            if(!hasLicenseText.test(licenseId)) {
                problems.add("core.main has no text for the licence '" + licenseId + "' of '" + user + "' ("
                             + CreditsFiles.LICENSES_FOLDER + "/" + licenseId + ".txt).");
            }
        }
    }

    /**
     * Matches the jars of {@link #shippedFolder} with the SBOM.
     *
     * @return The shipped components.
     */
    private List<SbomComponent> findShipped(final List<SbomComponent> components) throws IOException {
        final Map<String, SbomComponent> componentsByHash = components.stream()
                                                                      .filter(component -> component.sha256() != null)
                                                                      .collect(byKey(SbomComponent::sha256));
        final List<SbomComponent> shipped = new ArrayList<>();

        for(final Path jar : shippedJars()) {
            final String hash = CreditsFiles.hashOf(jar);
            final SbomComponent component = componentsByHash.get(hash);
            if(component == null) {
                problems.add("The shipped jar '" + jar.getFileName() + "' is not part of the SBOM of the module.");
                continue;
            }

            shipped.add(component);
        }

        return shipped;
    }

    /**
     * @return Whether core.main holds the text of the licence.
     */
    private static boolean isLicenseKnown(final String licenseId) {
        try {
            return CreditsFiles.readLicenseText(licenseId)
                               .isPresent();
        } catch(final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * @return The licences under which EvoAl uses the library: the ones of the entry, or else
     *   the single SPDX id of the SBOM. Reports a missing or ambiguous licence.
     */
    private List<String> licensesOf(final LibraryCredits library, final SbomComponent component) {
        if(!library.licenses().isEmpty()) {
            return library.licenses();
        }

        final String hint = "; state the licence under which EvoAl uses it in 'licenses'.";
        if(!component.licenseNames().isEmpty()) {
            problems.add("The POM of '" + library.library() + "' states a licence without SPDX id "
                         + component.licenseNames() + hint);
            return List.of();
        }

        if(component.licenseIds().isEmpty()) {
            problems.add("The POM of '" + library.library() + "' states no licence" + hint);
            return List.of();
        }

        if(component.licenseIds().size() > 1) {
            problems.add("The POM of '" + library.library() + "' states several licences "
                         + component.licenseIds() + hint);
            return List.of();
        }

        return component.licenseIds();
    }

    /**
     * Runs the check of one module and fails the build if it finds a problem.
     *
     * @param arguments The Maven packaging of the module, the folder with the files of
     *   {@link CreditsFiles}, the folder with the module jar and the jars it ships, and the file
     *   name of the module jar. A module with packaging {@code pom} ships nothing and is not
     *   checked; such a module is e.g. the parent of the plugins, which passes the check on.
     * @throws IllegalArgumentException if the number of arguments is wrong.
     * @throws IllegalStateException with the list of problems.
     */
    public static void main(final String... arguments) {
        if(arguments.length != 4) {
            throw new IllegalArgumentException("Expected the packaging, the credits folder, the shipped folder and the "
                                               + "module jar, but got " + arguments.length + " arguments.");
        }

        final String packaging = arguments[0];
        if(packaging.equals("pom")) {
            return;
        }

        final Path creditsFolder = Path.of(arguments[1]);
        final Path shippedFolder = Path.of(arguments[2]);
        final String moduleJar = arguments[3];
        final CreditsCheck check = new CreditsCheck(creditsFolder,
                                                    shippedFolder,
                                                    moduleJar,
                                                    CreditsCheck::isLicenseKnown);
        final List<String> problems = check.run();

        if(!problems.isEmpty()) {
            final String list = String.join("\n  - ", problems);
            throw new IllegalStateException("The credits of '" + moduleJar + "' have " + problems.size()
                                            + " problem(s):\n  - " + list);
        }
    }

    /**
     * @return The content of the file in {@link #creditsFolder}, empty if it does not exist.
     */
    private Optional<String> readOptional(final String fileName) throws IOException {
        final Path file = creditsFolder.resolve(fileName);
        if(!Files.exists(file)) {
            return Optional.empty();
        }

        return Optional.of(Files.readString(file));
    }

    /**
     * Checks the module.
     *
     * @return The problems, empty if the credits are complete.
     */
    public List<String> run() {
        try {
            runChecks();
        } catch(final IOException e) {
            problems.add("Cannot read the credits: " + e.getMessage());
        }

        return List.copyOf(problems);
    }

    private void runChecks() throws IOException {
        final Optional<String> sbom = readOptional(CreditsFiles.SBOM_FILE);
        if(sbom.isEmpty()) {
            problems.add("The SBOM " + creditsFolder.resolve(CreditsFiles.SBOM_FILE) + " is missing.");
            return;
        }

        final List<SbomComponent> components = CreditsFiles.readSbom(sbom.get());
        final List<SbomComponent> shipped = findShipped(components);

        final ModuleCredits credits;
        try {
            credits = readOptional(CreditsFiles.CREDITS_FILE).map(CreditsFiles::readCredits)
                                                              .orElseGet(ModuleCredits::empty);
        } catch(final JacksonException e) {
            problems.add(CreditsFiles.CREDITS_FILE + " is not valid: " + e.getOriginalMessage());
            return;
        }

        checkEntries(credits, shipped);

        final List<BibTeXEntry> entries;
        try {
            entries = readOptional(CreditsFiles.CITATIONS_FILE).map(BibTeXParser::parse)
                                                                .orElseGet(List::of);
        } catch(final IllegalArgumentException e) {
            problems.add(CreditsFiles.CITATIONS_FILE + " is not valid: " + e.getMessage());
            return;
        }

        checkCitations(credits, entries);
    }

    /**
     * @return The jars in {@link #shippedFolder} except the module jar, sorted by name.
     */
    private List<Path> shippedJars() throws IOException {
        try(Stream<Path> files = Files.list(shippedFolder)) {
            return files.filter(file -> file.getFileName().toString().endsWith(".jar"))
                        .filter(file -> !file.getFileName().toString().equals(moduleJar))
                        .sorted()
                        .toList();
        }
    }
}

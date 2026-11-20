package de.evoal.core.main.credits;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Collects the credits of an installation from its jars: every jar with the files of
 *   {@link CreditsFiles} is an EvoAl module, and the other jars in its folder are the libraries
 *   it ships. A jar is matched with the SBOM of the module by its SHA-256 hash, as in the build
 *   check ({@link CreditsCheck}), so only the libraries that are really there are listed, in
 *   the version that is there.
 * <p>
 * A library that several modules ship appears once, with the purposes of all of them.
 */
public final class CreditsCollector {
    /**
     * The name of core.main's module in the credits.
     */
    public static final String CORE_MODULE = "core";

    private CreditsCollector() {
    }

    /**
     * @return The entries of the keys, in the order of the keys; unknown keys are skipped (the
     *   build check reports them).
     */
    private static List<BibTeXEntry> citationsOf(final List<String> keys, final List<BibTeXEntry> entries) {
        final Map<String, BibTeXEntry> entriesByKey = entries.stream()
                                                             .collect(Collectors.toMap(BibTeXEntry::key,
                                                                                       Function.identity()));

        return keys.stream()
                   .map(entriesByKey::get)
                   .filter(Objects::nonNull)
                   .toList();
    }

    /**
     * Collects the credits of the jars.
     *
     * @param jars The jars of the installation, e.g. the module path.
     * @param coreFolder The folder of core.main, whose module is named {@value #CORE_MODULE};
     *   the module of another folder is named after the folder.
     * @throws IOException if a jar cannot be read.
     * @throws tools.jackson.core.JacksonException if an SBOM or credits file is not valid.
     * @throws IllegalArgumentException if a BibTeX file is not valid.
     */
    public static InstalledCredits collect(final List<Path> jars, final Path coreFolder) throws IOException {
        final Map<Path, List<Path>> jarsByFolder = jars.stream()
                                                       .collect(Collectors.groupingBy(Path::getParent,
                                                                                      TreeMap::new,
                                                                                      Collectors.toList()));
        final List<InstalledModule> modules = new ArrayList<>();
        final List<SbomComponent> evoalComponents = new ArrayList<>();
        final Map<String, InstalledLibrary> librariesByCoordinates = new LinkedHashMap<>();

        for(final Map.Entry<Path, List<Path>> folder : jarsByFolder.entrySet()) {
            final boolean isCoreFolder = folder.getKey().equals(coreFolder);
            final String moduleName = isCoreFolder ? CORE_MODULE : folder.getKey().getFileName().toString();
            final Map<Path, ModuleFiles> moduleFiles = readModuleFiles(folder.getValue());
            final Map<String, Path> librariesByHash = hashLibraries(folder.getValue(), moduleFiles);

            for(final ModuleFiles files : moduleFiles.values()) {
                final List<BibTeXEntry> moduleCitations = citationsOf(files.credits().citations(), files.entries());
                modules.add(new InstalledModule(moduleName, files.module(), moduleCitations));

                for(final SbomComponent component : files.components()) {
                    final Path jar = librariesByHash.get(component.sha256());
                    if(jar == null) {
                        continue;
                    }

                    if(component.isEvoal()) {
                        evoalComponents.add(component);
                        continue;
                    }

                    final InstalledLibrary library = toLibrary(moduleName, component, jar, files);
                    librariesByCoordinates.merge(library.coordinates(), library, CreditsCollector::merge);
                }
            }
        }

        final List<InstalledModule> sortedModules = modules.stream()
                                                           .sorted(Comparator.comparing(CreditsCollector::moduleOrder))
                                                           .toList();
        final Comparator<InstalledLibrary> byName = Comparator.comparing(library -> library.component().name());
        final Comparator<InstalledLibrary> libraryOrder = byName.thenComparing(InstalledLibrary::coordinates);
        final List<InstalledLibrary> sortedLibraries = librariesByCoordinates.values()
                                                                             .stream()
                                                                             .sorted(libraryOrder)
                                                                             .toList();

        return new InstalledCredits(sortedModules, evoalComponents, sortedLibraries);
    }

    /**
     * @return The hashes of the jars of the folder that are no EvoAl module.
     */
    private static Map<String, Path> hashLibraries(final List<Path> jars,
                                                   final Map<Path, ModuleFiles> moduleFiles) throws IOException {
        final Map<String, Path> librariesByHash = new HashMap<>();
        for(final Path jar : jars) {
            if(moduleFiles.containsKey(jar)) {
                continue;
            }

            final String hash = CreditsFiles.hashOf(jar);
            librariesByHash.put(hash, jar);
        }

        return librariesByHash;
    }

    /**
     * Merges the entries of two modules that ship the same library.
     */
    private static InstalledLibrary merge(final InstalledLibrary first, final InstalledLibrary second) {
        final List<LibraryUse> uses = Stream.concat(first.uses().stream(), second.uses().stream())
                                            .toList();
        final List<BibTeXEntry> citations = Stream.concat(first.citations().stream(), second.citations().stream())
                                                  .collect(Collectors.toMap(BibTeXEntry::key,
                                                                            Function.identity(),
                                                                            (kept, duplicate) -> kept,
                                                                            LinkedHashMap::new))
                                                  .values()
                                                  .stream()
                                                  .toList();
        final List<BundledCredits> bundled = Stream.concat(first.bundled().stream(), second.bundled().stream())
                                                   .distinct()
                                                   .toList();

        return new InstalledLibrary(first.component(),
                                    first.jar(),
                                    first.licenses(),
                                    first.website(),
                                    uses,
                                    citations,
                                    bundled);
    }

    /**
     * @return The sort key of a module: core first, then the plugins by name.
     */
    private static String moduleOrder(final InstalledModule module) {
        if(module.name().equals(CORE_MODULE)) {
            return "";
        }

        return module.name();
    }

    /**
     * @return The text of the entry, empty if the jar has no such entry.
     */
    private static Optional<String> readEntry(final ZipFile zip, final String fileName) throws IOException {
        final ZipEntry entry = zip.getEntry(CreditsFiles.FOLDER + "/" + fileName);
        if(entry == null) {
            return Optional.empty();
        }

        try(InputStream stream = zip.getInputStream(entry)) {
            final byte[] content = stream.readAllBytes();

            return Optional.of(new String(content, StandardCharsets.UTF_8));
        }
    }

    /**
     * @return The files of the jars that are EvoAl modules (have an SBOM), by jar.
     */
    private static Map<Path, ModuleFiles> readModuleFiles(final List<Path> jars) throws IOException {
        final Map<Path, ModuleFiles> moduleFiles = new LinkedHashMap<>();
        for(final Path jar : jars) {
            final Optional<ModuleFiles> files = readModuleFiles(jar);
            files.ifPresent(found -> moduleFiles.put(jar, found));
        }

        return moduleFiles;
    }

    /**
     * @return The files of the jar, empty if the jar has no SBOM (no EvoAl module).
     */
    private static Optional<ModuleFiles> readModuleFiles(final Path jar) throws IOException {
        try(ZipFile zip = new ZipFile(jar.toFile())) {
            final Optional<String> sbom = readEntry(zip, CreditsFiles.SBOM_FILE);
            if(sbom.isEmpty()) {
                return Optional.empty();
            }

            final SbomComponent module = CreditsFiles.readSbomModule(sbom.get());
            final List<SbomComponent> components = CreditsFiles.readSbom(sbom.get());
            final ModuleCredits credits = readEntry(zip, CreditsFiles.CREDITS_FILE).map(CreditsFiles::readCredits)
                                                                                  .orElseGet(ModuleCredits::empty);
            final List<BibTeXEntry> entries = readEntry(zip, CreditsFiles.CITATIONS_FILE).map(BibTeXParser::parse)
                                                                                        .orElseGet(List::of);

            return Optional.of(new ModuleFiles(module, components, credits, entries));
        }
    }

    /**
     * @return All licences of the SBOM, the SPDX ids first.
     */
    private static List<String> sbomLicensesOf(final SbomComponent component) {
        return Stream.concat(component.licenseIds().stream(), component.licenseNames().stream())
                     .toList();
    }

    /**
     * Creates the library as one module ships it.
     */
    private static InstalledLibrary toLibrary(final String moduleName,
                                              final SbomComponent component,
                                              final Path jar,
                                              final ModuleFiles files) {
        final String coordinates = component.coordinates();
        final Optional<LibraryCredits> entry = files.credits()
                                                    .libraries()
                                                    .stream()
                                                    .filter(library -> library.library().equals(coordinates))
                                                    .findFirst();

        final List<String> licenses = entry.map(LibraryCredits::licenses)
                                           .filter(chosen -> !chosen.isEmpty())
                                           .orElseGet(() -> sbomLicensesOf(component));
        final String website = entry.map(LibraryCredits::url)
                                    .orElse(component.website());
        final String purpose = entry.map(LibraryCredits::purpose)
                                    .orElse("");
        final List<String> citationKeys = entry.map(LibraryCredits::citations)
                                               .orElseGet(List::of);
        final List<BibTeXEntry> citations = citationsOf(citationKeys, files.entries());
        final List<BundledCredits> bundled = entry.map(LibraryCredits::bundled)
                                                  .orElseGet(List::of);
        final List<LibraryUse> uses = List.of(new LibraryUse(moduleName, purpose));

        return new InstalledLibrary(component, jar, licenses, website, uses, citations, bundled);
    }

    /**
     * The files of {@link CreditsFiles} of one EvoAl module jar.
     *
     * @param module The module as its SBOM describes it.
     * @param components The libraries of its SBOM.
     * @param credits Its hand-written credits.
     * @param entries Its BibTeX entries.
     */
    private record ModuleFiles(SbomComponent module,
                               List<SbomComponent> components,
                               ModuleCredits credits,
                               List<BibTeXEntry> entries) {
    }
}

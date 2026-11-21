package de.evoal.core.api.literature;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.resource.Resource;

import de.evoal.core.main.credits.BibTeXEntry;
import de.evoal.core.main.credits.BibTeXParser;
import de.evoal.core.main.credits.CitationFormat;
import de.evoal.core.main.credits.CreditsFiles;
import de.evoal.core.main.credits.LibraryCredits;
import de.evoal.core.main.credits.ModuleCredits;
import de.evoal.languages.model.base.definitions.Definition;

/**
 * The literature of the EvoAl modules on the class or module path: the BibTeX entries of every
 *   module ({@code META-INF/evoal/credits.bib}) and the citations that its
 *   {@code credits.json} names for the module and its libraries. Every EvoAl module carries an
 *   SBOM ({@code META-INF/evoal/sbom.cdx.json}); its location (jar or folder) identifies the
 *   module, and a DL type belongs to the module whose location holds its DL file.
 */
@Slf4j
public final class LiteratureIndex {
    /**
     * The modules, in the order of the class loader.
     */
    private final List<ModuleLiterature> modules;

    /**
     * The module of core.main, whose citations every run names first.
     */
    private final ModuleLiterature core;

    /**
     * The class loader that resolves {@code classpath:} URIs of DL files.
     */
    private final ClassLoader classpath;

    /**
     * The keys that more than one module defines differently and that were already reported.
     */
    private final Set<String> reportedConflicts = new LinkedHashSet<>();

    private LiteratureIndex(final List<ModuleLiterature> modules, final ModuleLiterature core, final ClassLoader classpath) {
        this.modules = List.copyOf(modules);
        this.core = core;
        this.classpath = classpath;
    }

    /**
     * Reads the literature of the modules that the class loader sees.
     *
     * @param classpath The class loader, e.g. the one of EvoAl's modules.
     * @throws UncheckedIOException if a file cannot be read.
     * @throws IllegalArgumentException if a BibTeX or credits file is not valid.
     */
    public static LiteratureIndex load(final @NonNull ClassLoader classpath) {
        try {
            final List<ModuleLiterature> modules = new ArrayList<>();
            final Enumeration<URL> sboms = classpath.getResources(CreditsFiles.FOLDER + "/" + CreditsFiles.SBOM_FILE);
            while(sboms.hasMoreElements()) {
                final String sbom = sboms.nextElement().toString();
                final String root = sbom.substring(0, sbom.length() - (CreditsFiles.FOLDER + "/" + CreditsFiles.SBOM_FILE).length());
                modules.add(read(root));
            }

            final Optional<Path> coreLocation = locationOfClass(LiteratureIndex.class);
            final ModuleLiterature core = modules.stream()
                                                 .filter(module -> module.location().isPresent()
                                                                   && module.location().equals(coreLocation))
                                                 .findFirst()
                                                 .orElse(ModuleLiterature.EMPTY);

            return new LiteratureIndex(modules, core, classpath);
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot read the literature of the modules.", e);
        }
    }

    /**
     * @return The keys that core.main names for itself (the EvoAl paper).
     */
    public List<String> coreCitations() {
        return core.citations();
    }

    /**
     * @param definition A DL type or declaration.
     * @return The keys that the credits of the module declaring the definition name for the
     *   module and its libraries; none if the module is unknown.
     */
    public List<String> moduleCitationsOf(final @NonNull Definition definition) {
        return moduleOf(definition).map(ModuleLiterature::citations)
                                   .orElseGet(List::of);
    }

    /**
     * @param key A BibTeX key.
     * @param owner The DL definition that cites the key, or {@code null}; if several modules
     *   define the key differently, the entry of the owner's module wins.
     * @return The entry as BibTeX, empty if no module defines the key.
     */
    public Optional<String> bibtexOf(final @NonNull String key, final Definition owner) {
        final List<ModuleLiterature> defining = modules.stream()
                                                       .filter(module -> module.entries().containsKey(key))
                                                       .toList();
        if(defining.isEmpty()) {
            return Optional.empty();
        }

        final Optional<ModuleLiterature> ownerModule = owner == null ? Optional.empty() : moduleOf(owner);
        final ModuleLiterature chosen = ownerModule.filter(defining::contains)
                                                   .orElse(defining.getFirst());
        final String bibtex = CitationFormat.toBibTeX(chosen.entries().get(key));

        final boolean conflict = defining.stream()
                                         .map(module -> CitationFormat.toBibTeX(module.entries().get(key)))
                                         .anyMatch(other -> !other.equals(bibtex));
        if(conflict && reportedConflicts.add(key)) {
            log.warn("Several modules define the BibTeX entry '{}' differently; using the one of {}.", key, chosen.root());
        }

        return Optional.of(bibtex);
    }

    /**
     * @return The module whose location holds the DL file of the definition.
     */
    private Optional<ModuleLiterature> moduleOf(final Definition definition) {
        final Resource resource = definition.eResource();
        if(resource == null || resource.getURI() == null) {
            return Optional.empty();
        }

        final Optional<Path> file = locationOf(resolve(resource.getURI().toString()));
        if(file.isEmpty()) {
            return Optional.empty();
        }

        return modules.stream()
                      .filter(module -> module.location().isPresent())
                      .filter(module -> file.get().equals(module.location().get())
                                        || file.get().startsWith(module.location().get()))
                      .findFirst();
    }

    /**
     * @return The URL of a {@code classpath:} URI, other URIs unchanged.
     */
    private String resolve(final String uri) {
        final String prefix = "classpath:/";
        if(!uri.startsWith(prefix)) {
            return uri;
        }

        final URL url = classpath.getResource(uri.substring(prefix.length()));
        return url == null ? uri : url.toString();
    }

    /**
     * @return The jar file of a {@code jar:} URI, the file or folder of a {@code file:} URI.
     */
    static Optional<Path> locationOf(final String uri) {
        try {
            if(uri.startsWith("jar:")) {
                final int separator = uri.indexOf("!");
                final String archive = separator < 0 ? uri.substring(4) : uri.substring(4, separator);
                return Optional.of(Path.of(new java.net.URI(archive)).toAbsolutePath().normalize());
            }

            if(uri.startsWith("file:")) {
                return Optional.of(Path.of(new java.net.URI(uri)).toAbsolutePath().normalize());
            }
        } catch(final URISyntaxException | IllegalArgumentException e) {
            log.debug("Cannot locate '{}'.", uri, e);
        }

        return Optional.empty();
    }

    private static Optional<Path> locationOfClass(final Class<?> type) {
        final URL url = type.getResource(type.getSimpleName() + ".class");
        if(url == null) {
            return Optional.empty();
        }

        final String classFile = type.getName().replace('.', '/') + ".class";
        final String text = url.toString();
        if(text.startsWith("file:") && text.endsWith(classFile)) {
            return locationOf(text.substring(0, text.length() - classFile.length()));
        }

        return locationOf(text);
    }

    private static ModuleLiterature read(final String root) throws IOException {
        final Optional<String> credits = readOptional(root, CreditsFiles.CREDITS_FILE);
        final Optional<String> bibtex = readOptional(root, CreditsFiles.CITATIONS_FILE);

        final List<String> citations = new ArrayList<>();
        credits.map(CreditsFiles::readCredits)
               .ifPresent(moduleCredits -> addCitations(moduleCredits, citations));

        final Map<String, BibTeXEntry> entries = new LinkedHashMap<>();
        bibtex.map(BibTeXParser::parse)
              .ifPresent(parsed -> parsed.forEach(entry -> entries.put(entry.key(), entry)));

        return new ModuleLiterature(root, locationOf(root), citations, entries);
    }

    private static void addCitations(final ModuleCredits credits, final List<String> citations) {
        final Set<String> keys = new LinkedHashSet<>(credits.citations());
        for(final LibraryCredits library : credits.libraries()) {
            keys.addAll(library.citations());
        }

        citations.addAll(keys);
    }

    private static Optional<String> readOptional(final String root, final String fileName) throws IOException {
        final URL url = java.net.URI.create(root + CreditsFiles.FOLDER + "/" + fileName).toURL();
        try(InputStream stream = url.openStream()) {
            return Optional.of(new String(stream.readAllBytes(), StandardCharsets.UTF_8));
        } catch(final java.io.FileNotFoundException | java.nio.file.NoSuchFileException e) {
            return Optional.empty();
        }
    }

    /**
     * The literature of one module.
     *
     * @param root The URL of the module's root, e.g. {@code jar:file:/…/plugin.jar!/}.
     * @param location The jar or folder of the module.
     * @param citations The keys that its credits name for the module and its libraries.
     * @param entries Its BibTeX entries by key.
     */
    private record ModuleLiterature(String root,
                                    Optional<Path> location,
                                    List<String> citations,
                                    Map<String, BibTeXEntry> entries) {
        static final ModuleLiterature EMPTY = new ModuleLiterature("", Optional.empty(), List.of(), Map.of());

        ModuleLiterature {
            citations = List.copyOf(citations);
            entries = Collections.unmodifiableMap(new LinkedHashMap<>(entries));
        }
    }
}

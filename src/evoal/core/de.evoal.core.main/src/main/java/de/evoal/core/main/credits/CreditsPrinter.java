package de.evoal.core.main.credits;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Prints the credits of an installation for {@code --credits}: how EvoAl and its plugins are
 *   cited and the third-party code inside their jars, then every third-party library with version, licence, project link, the modules
 *   that use it and what for, its citation, the libraries inside its jar and bundled native
 *   code. {@code --credits bibtex} prints all citations as BibTeX instead.
 */
public final class CreditsPrinter {
    /**
     * The indentation of the details of a library.
     */
    private static final String INDENT = "      ";

    /**
     * The prefix of SPDX ids that are no SPDX licences but defined by EvoAl.
     */
    private static final String LICENSE_REFERENCE = "LicenseRef-";

    /**
     * The prefix of the URL of an SPDX licence page.
     */
    private static final String SPDX_LICENSES = "https://spdx.org/licenses/";

    private CreditsPrinter() {
    }

    /**
     * @return All citations of the installation without duplicates: the modules' first, then
     *   the libraries'.
     */
    private static List<BibTeXEntry> allCitations(final InstalledCredits credits) {
        final Stream<BibTeXEntry> moduleCitations = credits.modules()
                                                           .stream()
                                                           .flatMap(module -> module.citations().stream());
        final Stream<BibTeXEntry> libraryCitations = credits.libraries()
                                                            .stream()
                                                            .flatMap(library -> library.citations().stream());
        final Map<String, BibTeXEntry> citationsByKey = new LinkedHashMap<>();
        Stream.concat(moduleCitations, libraryCitations)
              .forEach(citation -> citationsByKey.putIfAbsent(citation.key(), citation));

        return List.copyOf(citationsByKey.values());
    }

    /**
     * @return The licence with the link to its text, e.g.
     *   {@code Apache-2.0 (https://spdx.org/licenses/Apache-2.0.html)}.
     */
    private static String describeLicense(final String licenseId) {
        if(licenseId.startsWith(LICENSE_REFERENCE)) {
            return licenseId + " (licenses/" + licenseId + ".txt in the release)";
        }

        return licenseId + " (" + SPDX_LICENSES + licenseId + ".html)";
    }

    /**
     * Prints all citations of the installation as BibTeX, EvoAl's first.
     */
    public static void printBibTeX(final PrintStream out, final InstalledCredits credits) {
        final List<BibTeXEntry> citations = allCitations(credits);
        for(final BibTeXEntry citation : citations) {
            final String bibtex = CitationFormat.toBibTeX(citation);
            out.println(bibtex);
        }
    }

    private static void printBundled(final PrintStream out, final InstalledLibrary library) {
        for(final BundledCredits bundled : library.bundled()) {
            out.println(INDENT + "Bundles:  " + describeBundled(bundled));
        }
    }

    /**
     * @return The bundled code with its licences and project link, e.g.
     *   {@code Snappy (BSD-3-Clause, https://github.com/google/snappy)}.
     */
    private static String describeBundled(final BundledCredits bundled) {
        final String licenses = String.join(", ", bundled.licenses());
        if(bundled.url() == null) {
            return bundled.name() + " (" + licenses + ")";
        }

        return bundled.name() + " (" + licenses + ", " + bundled.url() + ")";
    }

    /**
     * Prints the credits of the installation.
     */
    public static void printCredits(final PrintStream out, final InstalledCredits credits) {
        printModules(out, credits.modules());

        out.println();
        final int numberOfLibraries = credits.libraries().size();
        out.println("EvoAl uses the following " + numberOfLibraries + " libraries. Thank you to their authors!");
        for(final InstalledLibrary library : credits.libraries()) {
            out.println();
            printLibrary(out, library);
        }

        out.println();
        out.println("The licence texts are in the folder licenses/ of the release, the notices of the libraries");
        out.println("in NOTICE. 'evoal-credits.sh bibtex' prints the citations as BibTeX.");
    }

    private static void printLibrary(final PrintStream out, final InstalledLibrary library) {
        final SbomComponent component = library.component();
        out.println("  " + component.name() + " " + component.version() + " (" + library.coordinates() + ")");

        final List<String> licenses = library.licenses()
                                             .stream()
                                             .map(CreditsPrinter::describeLicense)
                                             .toList();
        out.println(INDENT + "Licence:  " + String.join(", ", licenses));

        if(library.website() != null) {
            out.println(INDENT + "Project:  " + library.website());
        }

        for(final LibraryUse use : library.uses()) {
            out.println(INDENT + "Used by:  " + use.module() + ": " + use.purpose());
        }

        for(final BibTeXEntry citation : library.citations()) {
            out.println(INDENT + "Cite:     " + CitationFormat.toText(citation));
        }

        for(final SbomComponent contained : library.contained()) {
            out.println(INDENT + "Contains: " + contained.name() + " " + contained.version() + " ("
                        + contained.coordinates() + ")");
        }

        printBundled(out, library);
    }

    /**
     * Prints the version of EvoAl, the citations of EvoAl and its plugins and the third-party
     *   code inside their jars.
     */
    private static void printModules(final PrintStream out, final List<InstalledModule> modules) {
        for(final InstalledModule module : modules) {
            final boolean isCore = module.name().equals(CreditsCollector.CORE_MODULE);
            if(isCore) {
                out.println("EvoAl " + module.component().version());
            }

            final String citer = isCore ? "EvoAl" : "the plugin " + module.name();
            if(!module.citations().isEmpty()) {
                out.println();
                out.println("If you use " + citer + ", please cite:");
                for(final BibTeXEntry citation : module.citations()) {
                    out.println("  " + CitationFormat.toText(citation));
                }
            }

            if(!module.bundled().isEmpty()) {
                final String owner = isCore ? "EvoAl" : "The plugin " + module.name();
                out.println();
                out.println(owner + " contains third-party code:");
                for(final BundledCredits bundled : module.bundled()) {
                    out.println("  " + describeBundled(bundled));
                }
            }
        }
    }
}

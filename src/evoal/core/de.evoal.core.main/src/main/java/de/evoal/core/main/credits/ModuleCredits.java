package de.evoal.core.main.credits;

import java.util.List;

/**
 * The content of {@value CreditsFiles#CREDITS_FILE}: the citations of the module itself and the
 *   credits of the third-party libraries that it ships.
 *
 * @param citations The keys of the entries in {@value CreditsFiles#CITATIONS_FILE} with which
 *   users cite the module itself, e.g. the EvoAl paper in core.main or the paper of an
 *   external plugin.
 * @param libraries One entry per shipped library.
 */
public record ModuleCredits(List<String> citations, List<LibraryCredits> libraries) {
    public ModuleCredits {
        citations = CreditsFiles.copyOrEmpty(citations);
        libraries = CreditsFiles.copyOrEmpty(libraries);
    }

    /**
     * @return The credits of a module without citations and third-party libraries.
     */
    public static ModuleCredits empty() {
        return new ModuleCredits(List.of(), List.of());
    }
}

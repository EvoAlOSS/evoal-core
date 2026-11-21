package de.evoal.core.main.credits;

import java.util.List;

/**
 * The content of {@value CreditsFiles#CREDITS_FILE}: the citations of the module itself, the
 *   third-party code inside its own jars and the credits of the third-party libraries that it
 *   ships.
 *
 * @param citations The keys of the entries in {@value CreditsFiles#CITATIONS_FILE} with which
 *   users cite the module itself, e.g. the EvoAl paper in core.main or the paper of an
 *   external plugin.
 * @param bundled Third-party code with a licence of its own inside the module's jar or inside
 *   EvoAl's own artifacts that the module ships, e.g. native code or code ported from another
 *   project.
 * @param libraries One entry per shipped library.
 */
public record ModuleCredits(List<String> citations, List<BundledCredits> bundled, List<LibraryCredits> libraries) {
    public ModuleCredits {
        citations = CreditsFiles.copyOrEmpty(citations);
        bundled = CreditsFiles.copyOrEmpty(bundled);
        libraries = CreditsFiles.copyOrEmpty(libraries);
    }

    /**
     * @return The credits of a module without citations and third-party code.
     */
    public static ModuleCredits empty() {
        return new ModuleCredits(List.of(), List.of(), List.of());
    }
}

package de.evoal.core.main.credits;

import java.nio.file.Path;
import java.util.List;

/**
 * A third-party library of the installation with its credits, merged from all EvoAl modules
 *   that ship it.
 *
 * @param component The library in the SBOM of the (first) module that ships it.
 * @param jar The jar of the library.
 * @param licenses The licences under which EvoAl uses the library: the choice of the credits
 *   file, else the licences of the SBOM.
 * @param website The project link: the one of the credits file, else the one of the SBOM;
 *   {@code null} if neither has one.
 * @param uses What the modules use the library for.
 * @param citations The entries that the authors of the library ask users to cite.
 * @param bundled Native code inside the jar with a licence of its own.
 */
public record InstalledLibrary(SbomComponent component,
                               Path jar,
                               List<String> licenses,
                               String website,
                               List<LibraryUse> uses,
                               List<BibTeXEntry> citations,
                               List<BundledCredits> bundled) {
    public InstalledLibrary {
        licenses = CreditsFiles.copyOrEmpty(licenses);
        uses = CreditsFiles.copyOrEmpty(uses);
        citations = CreditsFiles.copyOrEmpty(citations);
        bundled = CreditsFiles.copyOrEmpty(bundled);
    }

    /**
     * @return The coordinates without version, {@code groupId:artifactId}.
     */
    public String coordinates() {
        return component.coordinates();
    }
}

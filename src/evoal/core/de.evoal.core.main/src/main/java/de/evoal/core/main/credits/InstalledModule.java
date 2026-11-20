package de.evoal.core.main.credits;

import java.util.List;

/**
 * An EvoAl module of the installation: core.main or a plugin, i.e. a jar with the files of
 *   {@link CreditsFiles}.
 *
 * @param name {@code core} or the folder name of the plugin.
 * @param component The module as its SBOM describes it ({@code metadata.component}).
 * @param citations The entries with which users cite the module itself.
 */
public record InstalledModule(String name, SbomComponent component, List<BibTeXEntry> citations) {
    public InstalledModule {
        citations = CreditsFiles.copyOrEmpty(citations);
    }
}

package de.evoal.core.main.credits;

import java.util.List;

import tools.jackson.databind.JsonNode;

/**
 * A library of a module's CycloneDX SBOM ({@value CreditsFiles#SBOM_FILE}).
 *
 * @param group The Maven group id.
 * @param name The Maven artifact id.
 * @param version The version.
 * @param licenseIds The licences that the POM states with an SPDX id.
 * @param licenseNames The licences that the POM states only by name or as an expression.
 * @param sha256 The SHA-256 hash of the jar in lower-case hexadecimal, {@code null} if the
 *   SBOM has none.
 * @param website The project link, {@code null} if the SBOM has none.
 * @param source The component as it stands in the SBOM, for the merged SBOM of a release.
 */
public record SbomComponent(String group,
                            String name,
                            String version,
                            List<String> licenseIds,
                            List<String> licenseNames,
                            String sha256,
                            String website,
                            JsonNode source) {
    /**
     * The prefix of the group ids of EvoAl's own artifacts, which need no credits.
     */
    private static final String EVOAL_GROUP = "de.evoal";

    public SbomComponent {
        licenseIds = CreditsFiles.copyOrEmpty(licenseIds);
        licenseNames = CreditsFiles.copyOrEmpty(licenseNames);
    }

    /**
     * @return The coordinates without version, {@code groupId:artifactId}, as used in
     *   {@value CreditsFiles#CREDITS_FILE}.
     */
    public String coordinates() {
        return group + ":" + name;
    }

    /**
     * @return Whether this is one of EvoAl's own artifacts, e.g. a language module.
     */
    public boolean isEvoal() {
        final boolean isEvoalGroup = group.equals(EVOAL_GROUP);
        final boolean isEvoalSubgroup = group.startsWith(EVOAL_GROUP + ".");

        return isEvoalGroup || isEvoalSubgroup;
    }
}

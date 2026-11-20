package de.evoal.core.main.credits;

import java.util.List;

/**
 * The credits of one third-party library that a module ships, one entry of
 *   {@value CreditsFiles#CREDITS_FILE}.
 *
 * @param library The Maven coordinates without version, {@code groupId:artifactId}.
 * @param purpose What EvoAl uses the library for.
 * @param licenses The SPDX ids of the licences under which EvoAl uses the library. Empty if
 *   the SBOM states exactly one SPDX id; required if the POM states no licence, a licence
 *   without SPDX id, or several licences to choose from.
 * @param url The project link, if the SBOM has none or a wrong one; {@code null} otherwise.
 * @param citations The keys of the entries in {@value CreditsFiles#CITATIONS_FILE} that the
 *   authors of the library ask users to cite.
 * @param bundled Native code inside the jar that has its own licence.
 */
public record LibraryCredits(String library,
                             String purpose,
                             List<String> licenses,
                             String url,
                             List<String> citations,
                             List<BundledCredits> bundled) {
    public LibraryCredits {
        licenses = CreditsFiles.copyOrEmpty(licenses);
        citations = CreditsFiles.copyOrEmpty(citations);
        bundled = CreditsFiles.copyOrEmpty(bundled);
    }
}

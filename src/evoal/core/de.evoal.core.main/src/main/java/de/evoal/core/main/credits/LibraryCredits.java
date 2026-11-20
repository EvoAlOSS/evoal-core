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
 * @param contains The coordinates ({@code groupId:artifactId}) of libraries of the SBOM whose
 *   code is inside the jar of this library and that are not shipped as jars of their own, e.g.
 *   the util part of EvoAl's merged Xtext jar. They count as shipped, under the licence of their
 *   SBOM entry, and need no entry of their own.
 */
public record LibraryCredits(String library,
                             String purpose,
                             List<String> licenses,
                             String url,
                             List<String> citations,
                             List<BundledCredits> bundled,
                             List<String> contains) {
    public LibraryCredits {
        licenses = CreditsFiles.copyOrEmpty(licenses);
        citations = CreditsFiles.copyOrEmpty(citations);
        bundled = CreditsFiles.copyOrEmpty(bundled);
        contains = CreditsFiles.copyOrEmpty(contains);
    }
}

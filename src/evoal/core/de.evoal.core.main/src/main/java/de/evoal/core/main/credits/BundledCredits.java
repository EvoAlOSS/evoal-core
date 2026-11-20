package de.evoal.core.main.credits;

import java.util.List;

/**
 * Native code inside a library jar that has a licence of its own, e.g. the Snappy library in
 *   {@code snappy-java}.
 *
 * @param name The name of the bundled code.
 * @param licenses The SPDX ids of its licences.
 * @param url The project link.
 */
public record BundledCredits(String name, List<String> licenses, String url) {
    public BundledCredits {
        licenses = CreditsFiles.copyOrEmpty(licenses);
    }
}

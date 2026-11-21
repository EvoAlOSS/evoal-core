package de.evoal.core.main.credits;

import java.util.List;

/**
 * Third-party code with a licence of its own that is not shipped as a library jar: native code
 *   inside a library jar, e.g. the Snappy library in {@code snappy-java}, or code inside a
 *   module's own jars or the EvoAl artifacts it ships, e.g. code ported from another project.
 *
 * @param name The name of the bundled code.
 * @param licenses The SPDX ids of its licences.
 * @param url The project link; {@code null} if there is none.
 * @param copyright The copyright notice of the code, e.g. {@code Copyright 2013, Jane Doe},
 *   which the release's notice file reproduces; required for the code of a module, optional for
 *   the code inside a library jar, whose notice files the release takes from the jar.
 */
public record BundledCredits(String name, List<String> licenses, String url, String copyright) {
    public BundledCredits {
        licenses = CreditsFiles.copyOrEmpty(licenses);
    }
}

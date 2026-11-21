package de.evoal.core.main.credits;

import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditsFilesTest {
    /**
     * The LGPL 3.0 consists of additional permissions to the GPL 3.0, so its file in core.main
     *   has to contain both texts.
     */
    @Test
    public void lgpl3TextContainsTheGpl3() throws IOException {
        final Optional<String> text = CreditsFiles.readLicenseText("LGPL-3.0-or-later");

        Assertions.assertTrue(text.isPresent(), "core.main has no text for LGPL-3.0-or-later.");
        Assertions.assertTrue(text.get().startsWith("GNU LESSER GENERAL PUBLIC LICENSE\nVersion 3,"), text.get());
        Assertions.assertTrue(text.get().contains("\nGNU GENERAL PUBLIC LICENSE\nVersion 3,"), text.get());
    }
}

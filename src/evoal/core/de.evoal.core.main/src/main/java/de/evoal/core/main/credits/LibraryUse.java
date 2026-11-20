package de.evoal.core.main.credits;

/**
 * What an EvoAl module uses a third-party library for.
 *
 * @param module The name of the module: {@code core} or the folder name of the plugin.
 * @param purpose The purpose from the module's {@value CreditsFiles#CREDITS_FILE}.
 */
public record LibraryUse(String module, String purpose) {
}

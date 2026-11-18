package de.evoal.core.api.reproducibility;

/**
 * A part of a run whose results may not be reproducible on other platforms.
 *
 * @param component The name of the component, e.g. a fitness step.
 * @param reason Why the results of the component may differ between platforms.
 */
public record ReproducibilityNote(String component, String reason) {
}

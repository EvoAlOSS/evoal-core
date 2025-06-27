package de.evoal.core.api.validation.model;

import de.evoal.core.api.validation.context.DiagnosticsContext;
import lombok.NonNull;

/**
 * Evaluation diagnostics during EvoAl's runtime.
 */
public record Diagnostics (@NonNull Level level, @NonNull DiagnosticsContext context, @NonNull String message) {

    public static Diagnostics of(@NonNull Level level, @NonNull DiagnosticsContext context, @NonNull String message) {
        return new Diagnostics(level, context, message);
    }

    /**
     * Level of the diagnostics message
     */
    public enum Level {
        Error, Warning, Info;
    }
}

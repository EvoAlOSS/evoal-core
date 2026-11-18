package de.evoal.core.api.reproducibility;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import lombok.extern.slf4j.Slf4j;

/**
 * Collects the parts of the current process whose results may not be reproducible on other
 *   platforms, e.g. components that use native numeric libraries. Native libraries are much
 *   faster than pure Java code, but their results can differ slightly between platforms and
 *   library versions.
 * <p>
 * Every note is logged as a warning when it is reported for the first time. The
 *   optimisation applications write the notes into the description of a run (the
 *   {@code reproducibility} of {@code execution-information.json} in the memory model);
 *   components report while they are set up, i.e. before the run starts.
 */
@ApplicationScoped
@Slf4j
public class ReproducibilityProtocol {
    /**
     * The reason of components that use native numeric libraries.
     */
    public static final String NATIVE_LIBRARIES = "uses native numeric libraries (BLAS/LAPACK); results may differ slightly"
                                                  + " between platforms";

    /**
     * The reported notes, in the order of their first report.
     */
    private final List<ReproducibilityNote> notes = new ArrayList<>();

    /**
     * @return The reported notes, in the order of their first report.
     */
    public synchronized List<ReproducibilityNote> notes() {
        return List.copyOf(notes);
    }

    /**
     * Reports a part whose results may not be reproducible. Reporting the same note again
     *   has no effect.
     *
     * @param component The name of the component, e.g. a fitness step.
     * @param reason Why the results of the component may differ between platforms.
     */
    public synchronized void report(final String component, final String reason) {
        final ReproducibilityNote note = new ReproducibilityNote(component, reason);

        if(notes.contains(note)) {
            return;
        }

        notes.add(note);
        log.warn("'{}' {}.", component, reason);
    }

    /**
     * Reports a component that uses native numeric libraries.
     *
     * @param component The name of the component.
     */
    public void reportNativeLibraries(final String component) {
        report(component, NATIVE_LIBRARIES);
    }
}

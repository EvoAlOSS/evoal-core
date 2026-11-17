package de.evoal.optimisation.api.run;

/**
 * Starts and stops the {@link de.evoal.core.api.cdi.RunScoped} context of a run.
 */
public interface RunScope {
    /**
     * Starts the context of a run.
     */
    void start();

    /**
     * Stops the context of the run and destroys its beans.
     */
    void stop();
}

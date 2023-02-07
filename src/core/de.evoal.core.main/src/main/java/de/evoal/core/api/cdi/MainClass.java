package de.evoal.core.api.cdi;

/**
 * Base interface for all main classes. A main class must be annotated using the
 * {@link javax.inject.Named} annotation, which can be used on the command line
 * to select the main class to execute.
 *
 * Additionally, you should add a {@link Application} annotation to your main class
 * to allow EvoAl to print some documentation for the user.
 */
public interface MainClass {
    /**
     * Run the main.
     */
    public void run();
}

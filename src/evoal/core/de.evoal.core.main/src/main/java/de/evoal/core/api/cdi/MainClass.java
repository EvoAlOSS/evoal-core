package de.evoal.core.api.cdi;

/**
 * Base interface for all main classes. A main class is annotated with {@link Application}:
 *   its name selects the main class on the command line ({@code -Bcore:main=<name>}), and its
 *   documentation is printed by the help. The parameters that the application reads are
 *   documented with {@link Commandline} in a {@link de.evoal.core.api.board.BlackboardEntries}
 *   class.
 */
public interface MainClass {
    /**
     * Run the main.
     */
    void run();
}

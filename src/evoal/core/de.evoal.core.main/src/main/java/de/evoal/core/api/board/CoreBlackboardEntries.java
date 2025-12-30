package de.evoal.core.api.board;

import de.evoal.core.api.cdi.Commandline;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("core-entries")
public class CoreBlackboardEntries implements BlackboardEntries {
    /**
     * Parameter to specify for logging leven.
     */
    @Commandline(main = "",  name = "core:logging", doc = "Logging level to use (ERROR,WARN,INFO,DEBUG)")
    public static final String LOGGING_LEVEL = "core:logging";

    /**
     * Name of the main to run.
     */
    public static final String MAIN = "core:main";

    @Commandline(main="", name="core:search-path", doc="Additional search path entries for DSL lookup.")
    public static final String SEARCH_PATH = "core:search-path";
}

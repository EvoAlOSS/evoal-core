package de.evoal.core.api.board;

import de.evoal.core.api.cdi.Commandline;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("core-entries")
public class CoreBlackboardEntries implements BlackboardEntries {

    /**
     * The target properties to search for.
     */
    public static final String TARGET_PROPERTIES = "core:target-properties";

    /**
     * Folder containing the constraint files.
     */
    public static final String CONSTRAINT_FOLDER = "core:constraint-folder";

    /**
     * Number of evaluation runs.
     */
    @Commandline(main = "heuristic-search", name = "core:evaluation-iterations", doc = "Number of iterations to run the search.")
    public static final String EVALUATION_ITERATIONS = "core:evaluation-iterations";

    /**
     * The evaluation run number.
     */
    public static final String EVALUATION_RUN = "core:evaluation-run";

    /**
     * The actual output folder for the evaluation.
     */
    @Commandline(main = "heuristic-search", name = "core:evaluation-output-folder", doc = "Folder to write the results to.")
    public static final String EVALUATION_OUTPUT_FOLDER = "core:evaluation-output-folder";

    /**
     * The heuristic configuration.
     */
    public static final String OPTIMISATION_CONFIGURATION = "core:optimisation-configuration";

    /**
     * The file containing the ea configuration.
     */
    @Commandline(main = "heuristic-search", name = "core:optimisation-configuration", doc = "Optimisation configuration to use.")
    public static final String OPTIMISATION_CONFIGURATION_FILE = "core:optimisation-configuration-file";

    /**
     * Name of the main to run.
     */
    public static final String MAIN = "core:main";

    /**
     * File containing targets for evaluation.
     */
    @Commandline(main="heuristic-search-evaluation", name = "core:target-points-file", doc = "A file containing the targets to use for evaluation.")
    public static final String TARGET_POINTS_FILE = "core:target-points-file";
}

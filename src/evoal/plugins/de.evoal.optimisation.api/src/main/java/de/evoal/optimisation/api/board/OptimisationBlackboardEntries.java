package de.evoal.optimisation.api.board;

import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.cdi.Commandline;
import de.evoal.optimisation.main.search.HeuristicSearchEvaluation;
import de.evoal.optimisation.main.search.HeuristicSearchMain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("optimisation-entries")
public class OptimisationBlackboardEntries implements BlackboardEntries {

    /**
     * Number of evaluation runs.
     */
    @Commandline(main = HeuristicSearchEvaluation.NAME, name = "optimisation:evaluation-iterations",
                 doc = "Number of runs of the search (for every target point, if a target points file is given).")
    public static final String EVALUATION_ITERATIONS = "optimisation:evaluation-iterations";

    /**
     * The output folder given on the command line. The applications derive the output folders
     *   of their evaluations and runs from it; the components of a run read the folder of the
     *   run from {@link de.evoal.optimisation.api.run.CurrentRun}.
     */
    @Commandline(main = {HeuristicSearchMain.NAME, HeuristicSearchEvaluation.NAME}, name = "optimisation:evaluation-output-folder",
                 doc = "Folder for the output; the statistics of a run go to <folder>/<name of the OL file without extension>.")
    public static final String EVALUATION_OUTPUT_FOLDER = "optimisation:evaluation-output-folder";

    /**
     * The DDL modules that the OL module of the problem imports (a list of
     *   {@code DataDescriptionModule}, set when the configuration is loaded); their
     *   {@code constraints} sections belong to the problem.
     */
    public static final String IMPORTED_DATA_MODULES = "optimisation:imported-data-modules";

    /**
     * The heuristic configuration.
     */
    public static final String OPTIMISATION_CONFIGURATION = "optimisation:optimisation-configuration";

    /**
     * The OL file with the problem and the algorithm.
     */
    @Commandline(main = {HeuristicSearchMain.NAME, HeuristicSearchEvaluation.NAME}, name = "optimisation:optimisation-configuration-file",
                 doc = "The OL file with the problem and the algorithm, e.g., search.ol.")
    public static final String OPTIMISATION_CONFIGURATION_FILE = "optimisation:optimisation-configuration-file";

    /**
     * File containing targets for evaluation.
     */
    @Commandline(main = HeuristicSearchEvaluation.NAME, name = "optimisation:target-points-file",
                 doc = "Optional data file (e.g., json or csv) with one target per row: values of the search and optimisation features; the search is run for every target.")
    public static final String TARGET_POINTS_FILE = "optimisation:target-points-file";
}

package de.evoal.optimisation.api.board;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("optimisation-entries")
public class OptimisationBlackboardEntries {

    /**
     * Number of evaluation runs.
     */
    public static final String EVALUATION_ITERATIONS = "optimisation:evaluation-iterations";

    /**
     * The actual output folder for the evaluation.
     */
    public static final String EVALUATION_OUTPUT_FOLDER = "optimisation:evaluation-output-folder";

    /**
     * The evaluation run number.
     */
    public static final String EVALUATION_RUN = "optimisation:evaluation-run";

    /**
     * The heuristic configuration.
     */
    public static final String OPTIMISATION_CONFIGURATION = "optimisation:optimisation-configuration";

    /**
     * The file containing the pso configuration.
     */
    public static final String OPTIMISATION_CONFIGURATION_FILE = "optimisation:optimisation-configuration-file";

    /**
     * File containing targets for evaluation.
     */
    public static final String TARGET_POINTS_FILE = "optimisation:target-points-file";


    /**
     * The target properties to search for.
     */
    public static final String TARGET_PROPERTIES = "optimisation:target-properties";
}

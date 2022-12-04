package de.evoal.core.api.board;

public final class BlackboardEntry {

    /**
     * The target properties to search for.
     */
    public static final String TARGET_PROPERTIES = "TARGET_PROPERTIES";

    //    public static final String TARGET_PROPERTIES_SOURCE = "TARGET_PROPERTIES_SOURCE";

    /**
     * Folder containing the constraint validation models.
     */
//    public static final String CONSTRAINT_VALIDATION_FOLDER = "CONSTRAINT_VALIDATION_FOLDER";

    /**
     * Chooses the evaluation kind.
     */
//    public static final String EVALUATION = "EVALUATION";

    /**
     * Number of evaluation runs.
     */
//    public static final String EVALUATION_ITERATIONS = "EVALUATION_ITERATIONS";

    /**
     * The evaluation run number.
     */
    public static final String EVALUATION_RUN = "core:evaluation-run";

    /**
     * The actual output folder for the evaluation.
     */
    public static final String EVALUATION_OUTPUT_FOLDER = "core:evaluation-output-folder";

    /**
     * Configuration file containing the configuration fot the standard fitness function.
     */
//    public static final String FITNESS_STANDARD_FUNCTION_FILE = "FITNESS_STANDARD_FUNCTION_FILE";

    /**
     * The heuristic configuration.
     */
    public static final String EA_CONFIGURATION = "core:ea-configuration";

    /**
     * The file containing the ea configuration.
     */
    public static final String EA_CONFIGURATION_FILE = "core:ea-configuration-file";

    /**
     * File containing the machine learning file.
     */
//    public static final String MACHINE_LEARNING_FILE = "MACHINE_LEARNING_FILE";

    /**
     * Name of the main to run.
     */
    public static final String MAIN = "core:main";

    /**
     * The trained predictive function
     */
//    public static final String PREDICTIVE_FUNCTION = "PREDICTIVE_FUNCTION";

    /**
     * The predictive configuration to use
     */
//    public static final String PREDICTIVE_FUNCTION_CONFIGURATION = "PREDICTIVE_FUNCTION_CONFIGURATION";

    /**
     * File containing the predictive function file.
     */
//    public static final String PREDICTIVE_FUNCTION_FILE = "PREDICTIVE_FUNCTION_FILE";

    /**
     * Targets.
     */
//    public static final String TARGET_POINTS = "TARGET_POINTS";

    /**
     * File containing targets for evaluation.
     */
//    public static final String TARGETS_FILE = "TARGETS_FILE";

    /**
     * File containing the training points.
     */
//    public static final String TRAINING_POINT_FILE = "TRAINING_POINT_FILE";

    private final String label;

    private BlackboardEntry(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isSame(final String label) {
        return this.label.equals(label);
    }

    public static BlackboardEntry of(final String label) {
        return new BlackboardEntry(label);
    }
}

package de.evoal.core.api.board;

public final class BlackboardEntry {

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
    public static final String EVALUATION_ITERATIONS = "core:evaluation-iterations";

    /**
     * The evaluation run number.
     */
    public static final String EVALUATION_RUN = "core:evaluation-run";

    /**
     * The actual output folder for the evaluation.
     */
    public static final String EVALUATION_OUTPUT_FOLDER = "core:evaluation-output-folder";

    /**
     * The heuristic configuration.
     */
    public static final String OPTIMISATION_CONFIGURATION = "core:optimisation-configuration";

    /**
     * The file containing the ea configuration.
     */
    public static final String OPTIMISATION_CONFIGURATION_FILE = "core:optimisation-configuration-file";

    /**
     * Name of the main to run.
     */
    public static final String MAIN = "core:main";

    /**
     * File containing targets for evaluation.
     */
    public static final String TARGET_POINTS_FILE = "core:target-points-file";

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

package de.evoal.surrogate.api;

public final class SurrogateBlackboardEntry {
    /**
     * Loaded surrogate configuration.
     */
    public static final String SURROGATE_CONFIGURATION = "surrogate:configuration";

    /**
     * Configuration file for the data generator.
     */
    public static final String SURROGATE_CONFIGURATION_FILE = "surrogate:configuration-file";

    /**
     * File containing a pre-trained surrogate.
     */
    public static final String SURROGATE_PRETRAINED_FILE = "surrogate:pre-trained";

    /**
     * File containing the training data.
     */
    public static final String SURROGATE_TRAINING_DATA_FILE = "surrogate:training-data";

    private SurrogateBlackboardEntry() {}
}

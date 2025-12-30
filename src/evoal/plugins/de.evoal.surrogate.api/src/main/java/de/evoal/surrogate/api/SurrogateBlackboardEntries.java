package de.evoal.surrogate.api;

import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.cdi.Commandline;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("surrogate-entries")
public class SurrogateBlackboardEntries implements BlackboardEntries {
    /**
     * Loaded surrogate configuration.
     */
//    public static final String SURROGATE_CONFIGURATION = "surrogate:configuration";

    /**
     * Configuration file for the data generator.
     */
    @Commandline(main = "", name = "surrogate:configuration-file", doc = "Configuration file for surrogate training, e.g., surrogate.mll.")
    public static final String SURROGATE_CONFIGURATION_FILE = "surrogate:configuration-file";

    /**
     * File containing a pre-trained surrogate.
     */
    @Commandline(main = "", name = "surrogate:pre-trained", doc = "File containing a pre-trained surrogate function written by \"surrogate-training\".")
    public static final String SURROGATE_PRETRAINED_FILE = "surrogate:pre-trained";

    /**
     * File containing the training data.
     */
    @Commandline(main = "", name = "surrogate:training-data", doc = "File containing data for the surrogate training.")
    public static final String SURROGATE_TRAINING_DATA_FILE = "surrogate:training-data";

    private SurrogateBlackboardEntries() {}
}

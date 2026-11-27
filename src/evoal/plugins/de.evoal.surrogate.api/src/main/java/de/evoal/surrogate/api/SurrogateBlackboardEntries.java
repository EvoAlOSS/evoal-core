package de.evoal.surrogate.api;

import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.cdi.Commandline;
import de.evoal.optimisation.main.search.HeuristicSearchEvaluation;
import de.evoal.optimisation.main.search.HeuristicSearchMain;
import de.evoal.surrogate.main.SurrogateMain;

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
     * The MLL file of the surrogate to train.
     */
    @Commandline(main = SurrogateMain.NAME, name = "surrogate:configuration-file", doc = "The MLL file of the surrogate to train, e.g., surrogate.mll.")
    public static final String SURROGATE_CONFIGURATION_FILE = "surrogate:configuration-file";

    /**
     * File containing a pre-trained surrogate.
     */
    @Commandline(main = {HeuristicSearchMain.NAME, HeuristicSearchEvaluation.NAME}, name = "surrogate:pre-trained",
                 doc = "File containing a pre-trained surrogate function written by \"surrogate-training\".")
    public static final String SURROGATE_PRETRAINED_FILE = "surrogate:pre-trained";

    /**
     * File containing the training data; read into {@link #SURROGATE_TRAINING_DATA} when a
     *   'training-population' without 'training-file' needs it.
     */
    @Commandline(main = {HeuristicSearchMain.NAME, HeuristicSearchEvaluation.NAME}, name = "surrogate:training-data-file",
                 doc = "File containing the training data, used by a 'training-population' without 'training-file'.")
    public static final String SURROGATE_TRAINING_DATA_FILE = "surrogate:training-data-file";

    /**
     * The training data read from {@link #SURROGATE_TRAINING_DATA_FILE}
     *   ({@link TrainingData}); read once per run.
     */
    public static final String SURROGATE_TRAINING_DATA = "surrogate:training-data";

    private SurrogateBlackboardEntries() {}
}

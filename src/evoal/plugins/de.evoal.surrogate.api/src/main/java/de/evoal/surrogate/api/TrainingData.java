package de.evoal.surrogate.api;

import java.util.List;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * The training data of a run, read from the file of the command-line entry
 *   {@link SurrogateBlackboardEntries#SURROGATE_TRAINING_DATA_FILE} and kept on the blackboard
 *   as {@link SurrogateBlackboardEntries#SURROGATE_TRAINING_DATA}.
 *
 * @param file The file the data was read from.
 * @param candidates The data points.
 */
public record TrainingData(String file, List<TypedEObject> candidates) {
    public TrainingData {
        candidates = List.copyOf(candidates);
    }

    /**
     * Summarises the data, since the blackboard logs bound values.
     */
    @Override
    public String toString() {
        return candidates.size() + " data points of " + file;
    }
}

package de.evoal.core.api.statistics;

import de.evoal.core.api.ea.fitness.type.FitnessType;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.engine.EvolutionResult;

/**
 * Evaluation-specific data writer for evaluation results. The information
 * may be individual-, generation-, or run-specific and may be specific to
 * a certain technique under investigation. What all writer have in common
 * is the table-like structure of data (think of a CSV file).
 *
 * The framework will call {@link #init(Instance)} once before the evolutionary
 * algorithm starts. While the EA runs, it will call {@link #add(EvolutionResult)}
 * for each generation of individuals. When the EA terminated, the framework calls
 * {@link #write()} once to force a serialization of the data.
 */
public interface StatisticsWriter {
    /**
     * Adds a evaluation result to the statistics.
     */
    public void add(final EvolutionResult<?, FitnessType> result);

    /**
     * Passes the writer configuration.
     */
    public StatisticsWriter init(final Instance configuration);

    /**
     * Write the statistics since the run is completed.
     */
    public void write();
}

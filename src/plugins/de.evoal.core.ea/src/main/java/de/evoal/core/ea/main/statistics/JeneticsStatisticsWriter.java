package de.evoal.core.ea.main.statistics;

import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.statistics.writer.StatisticsWriter;
import io.jenetics.engine.EvolutionResult;

/**
 * Adapter for converting Jenetis statistics information into EvoAl
 *   statistics information.
 */
public class JeneticsStatisticsWriter {
    private final StatisticsWriter writer;

    public JeneticsStatisticsWriter(final StatisticsWriter writer) {
        this.writer = writer;
    }

    public void add(final EvolutionResult<?, OptimisationValue> result) {
        writer.add(new IterationResultAdapter(result));
    }
}

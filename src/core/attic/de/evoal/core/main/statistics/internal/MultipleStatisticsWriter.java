package de.evoal.core.main.statistics.internal;

import de.evoal.languages.model.instance.Instance;
import de.evoal.core.api.statistics.StatisticsWriter;
import de.evoal.core.api.ea.fitness.type.FitnessType;
import io.jenetics.engine.EvolutionResult;

import java.util.Arrays;

public class MultipleStatisticsWriter implements StatisticsWriter {
    private final StatisticsWriter[] writers;

    public MultipleStatisticsWriter(final StatisticsWriter ... writers) {
        this.writers = writers;
    }

    @Override
    public void add(final EvolutionResult<?, FitnessType> evolutionResult) {
        Arrays.stream(writers).forEach(w -> w.add(evolutionResult));
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    @Override
    public void write() {
        Arrays.stream(writers).forEach(StatisticsWriter::write);
    }
}

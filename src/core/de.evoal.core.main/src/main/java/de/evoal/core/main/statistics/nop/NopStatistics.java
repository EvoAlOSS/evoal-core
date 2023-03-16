package de.evoal.core.main.statistics.nop;

import de.evoal.core.api.statistics.IterationResult;
import de.evoal.languages.model.instance.Instance;
import de.evoal.core.api.statistics.writer.StatisticsWriter;

import javax.enterprise.context.Dependent;

import javax.inject.Named;

@Named("none")
@Dependent
public class NopStatistics implements StatisticsWriter {
    @Override
    public void add(final IterationResult evolutionResult) {
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    @Override
    public void write() {
    }
}

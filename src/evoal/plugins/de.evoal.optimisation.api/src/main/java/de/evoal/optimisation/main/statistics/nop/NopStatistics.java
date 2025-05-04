package de.evoal.optimisation.main.statistics.nop;

import de.evoal.optimisation.api.model.Iteration;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

import javax.enterprise.context.Dependent;

import javax.inject.Named;

@Named("de.evoal.optimisation.core.none")
@Dependent
public class NopStatistics implements StatisticsWriter {
    @Override
    public void add(final Iteration evolutionResult) {
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    @Override
    public void write() {
    }
}

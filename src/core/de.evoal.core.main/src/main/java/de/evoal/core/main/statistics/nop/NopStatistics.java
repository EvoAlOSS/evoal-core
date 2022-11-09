package de.evoal.core.main.statistics.nop;

import de.evoal.languages.model.instance.Instance;
import de.evoal.core.api.statistics.StatisticsWriter;
import de.evoal.core.api.ea.fitness.type.FitnessType;
import io.jenetics.engine.EvolutionResult;
import javax.enterprise.context.Dependent;

import javax.inject.Named;

@Named("none")
@Dependent
public class NopStatistics implements StatisticsWriter {
    @Override
    public void add(final EvolutionResult<?, FitnessType> evolutionResult) {
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    @Override
    public void write() {
    }
}

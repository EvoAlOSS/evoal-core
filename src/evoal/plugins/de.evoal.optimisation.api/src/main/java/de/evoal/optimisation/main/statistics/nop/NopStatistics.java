package de.evoal.optimisation.main.statistics.nop;

import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

import jakarta.enterprise.context.Dependent;

import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

@Named("de.evoal.optimisation.core.none")
@Dependent
public class NopStatistics implements StatisticsWriter {
    @Override
    public void add(final Iteration evolutionResult) {
    }

    @Override
    public StatisticsWriter init(final EObject configuration) {
        return this;
    }

    @Override
    public void write() {
    }
}

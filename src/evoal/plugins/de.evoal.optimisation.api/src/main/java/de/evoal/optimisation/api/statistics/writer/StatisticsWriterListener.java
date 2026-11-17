package de.evoal.optimisation.api.statistics.writer;

import de.evoal.optimisation.api.events.IndividualEvaluated;
import de.evoal.optimisation.api.events.IterationFinished;
import de.evoal.optimisation.api.events.IterationStarted;
import de.evoal.optimisation.api.events.RunEvent;
import de.evoal.optimisation.api.events.RunFinished;
import de.evoal.optimisation.api.events.RunListener;
import de.evoal.optimisation.api.events.RunStarted;
import de.evoal.optimisation.api.events.StepExecuted;

/**
 * Connects a statistics writer to the events of a run: {@link StatisticsWriter#start()} on
 *   {@link RunStarted}, {@link StatisticsWriter#add} on {@link IterationFinished} and
 *   {@link StatisticsWriter#write()} on {@link RunFinished}.
 *
 * @param writer The connected writer.
 */
public record StatisticsWriterListener(StatisticsWriter writer) implements RunListener {
    @Override
    public void on(final RunEvent event) {
        switch(event) {
            case RunStarted started -> writer.start();
            case IterationFinished(var iteration) -> writer.add(iteration);
            case RunFinished finished -> writer.write();
            case IterationStarted started -> { }
            case StepExecuted executed -> { }
            case IndividualEvaluated evaluated -> { }
        }
    }
}

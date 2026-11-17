package de.evoal.optimisation.api.statistics.writer;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.events.IndividualEvaluated;
import de.evoal.optimisation.api.events.IterationFinished;
import de.evoal.optimisation.api.events.IterationStarted;
import de.evoal.optimisation.api.events.RunFinished;
import de.evoal.optimisation.api.events.RunStarted;
import de.evoal.optimisation.api.events.StepExecuted;

public class StatisticsWriterListenerTest {
    private final StatisticsWriter writer = Mockito.mock(StatisticsWriter.class);

    private final StatisticsWriterListener listener = new StatisticsWriterListener(writer);

    @Test
    public void aStartedRunStartsTheWriter() {
        // when
        listener.on(new RunStarted(null));

        // then
        Mockito.verify(writer).start();
        Mockito.verifyNoMoreInteractions(writer);
    }

    @Test
    public void aFinishedIterationIsAdded() {
        // given
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();

        // when
        listener.on(new IterationFinished(iteration));

        // then
        Mockito.verify(writer).add(iteration);
        Mockito.verifyNoMoreInteractions(writer);
    }

    @Test
    public void aFinishedRunWritesTheStatistics() {
        // when
        listener.on(new RunFinished(null));

        // then
        Mockito.verify(writer).write();
        Mockito.verifyNoMoreInteractions(writer);
    }

    @Test
    public void otherEventsAreIgnored() {
        // given
        final TypedEObject candidate = Mockito.mock(TypedEObject.class);

        // when
        listener.on(new IterationStarted(0));
        listener.on(new StepExecuted(0, MemoryFactory.eINSTANCE.createUnorderedIterationStep()));
        listener.on(new IndividualEvaluated(candidate, candidate, EvaluationSource.REAL));

        // then
        Mockito.verifyNoInteractions(writer);
    }
}

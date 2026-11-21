package de.evoal.optimisation.api.run;

import jakarta.inject.Provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.optimisation.api.execution.EvaluationPosition;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.model.IndividualIDGenerator;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.main.search.OptimisationConfigurationSetup;

@ExtendWith(MockitoExtension.class)
public class SearchRunnerTest {
    @Mock
    private OptimisationConfigurationSetup configurationSetup;

    @Mock
    private RandomService randomService;

    @Mock
    private IndividualIDGenerator idGenerator;

    @Mock
    private ExecutionRecorder executionRecorder;

    @Mock
    private Provider<FitnessPipeline> fitnessPipelines;

    @InjectMocks
    private SearchRunner runner;

    @Test
    public void setUpDelegatesToTheConfigurationSetup() {
        final OptimisationModule configuration = Mockito.mock(OptimisationModule.class);
        Mockito.when(configurationSetup.setUp("search.ol")).thenReturn(configuration);

        Assertions.assertSame(configuration, runner.setUp("search.ol"));
    }

    @Test
    public void runStartsTheRunWithItsNumberAndPositionAndRunsTheAlgorithm() {
        final OptimisationModule configuration = Mockito.mock(OptimisationModule.class);
        final Configuration algorithmConfiguration = Mockito.mock(Configuration.class);
        Mockito.when(configuration.getAlgorithm()).thenReturn(algorithmConfiguration);

        final FitnessPipeline pipeline = Mockito.mock(FitnessPipeline.class);
        final FitnessLayout layout = Mockito.mock(FitnessLayout.class);
        Mockito.when(fitnessPipelines.get()).thenReturn(pipeline);
        Mockito.when(pipeline.layout()).thenReturn(layout);

        final OptimisationAlgorithm algorithm = Mockito.mock(OptimisationAlgorithm.class);
        final EvaluationPosition position = EvaluationPosition.withoutTarget(3, 5);

        try (MockedStatic<BeanFactory> factory = Mockito.mockStatic(BeanFactory.class)) {
            factory.when(() -> BeanFactory.createComponent(OptimisationAlgorithm.class, algorithmConfiguration)).thenReturn(algorithm);

            runner.run(configuration, 7, position);
        }

        final InOrder order = Mockito.inOrder(randomService, idGenerator, executionRecorder, algorithm);
        order.verify(randomService).startRun(7);
        order.verify(idGenerator).startRun();
        order.verify(executionRecorder).startRun(position);
        order.verify(executionRecorder).defineFitness(layout);
        order.verify(executionRecorder).beginExecution();
        order.verify(algorithm).run();
        order.verify(executionRecorder).finishRun();
        order.verifyNoMoreInteractions();
    }
}

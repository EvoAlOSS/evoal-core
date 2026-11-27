package de.evoal.optimisation.api.run;

import java.io.File;

import jakarta.inject.Provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ScopeControl;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.optimisation.api.execution.EvaluationPosition;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.main.search.OptimisationConfigurationSetup;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class SearchRunnerTest {
    @Mock
    private OptimisationConfigurationSetup configurationSetup;

    @Mock
    private ScopeControl scopes;

    @Spy
    private CurrentEvaluation currentEvaluation = new CurrentEvaluation();

    @Spy
    private CurrentRun currentRun = new CurrentRun();

    @Mock
    private RandomService randomService;

    @Mock
    private ExecutionRecorder executionRecorder;

    @Mock
    private Provider<FitnessPipeline> fitnessPipelines;

    @Mock
    private RunLiterature literature;

    @InjectMocks
    private SearchRunner runner;

    /**
     * The scopes run their bodies.
     */
    @BeforeEach
    public void runTheBodiesOfTheScopes() throws Throwable {
        Mockito.doAnswer(invocation -> {
            invocation.<ScopeControl.Body<?>>getArgument(0).run();
            return null;
        }).when(scopes).inEvaluation(ArgumentMatchers.any());

        Mockito.doAnswer(invocation -> {
            invocation.<ScopeControl.Body<?>>getArgument(1).run();
            return null;
        }).when(scopes).inRun(ArgumentMatchers.anyLong(), ArgumentMatchers.any());
    }

    @Test
    public void setUpDelegatesToTheConfigurationSetup() {
        final OptimisationModule configuration = Mockito.mock(OptimisationModule.class);
        Mockito.when(configurationSetup.setUp("search.ol")).thenReturn(configuration);

        Assertions.assertSame(configuration, runner.setUp("search.ol"));
    }

    @Test
    public void evaluateOpensAnEvaluationWithItsOutputFolder() throws Throwable {
        // given
        final File outputFolder = new File("output/search");
        final boolean[] ran = { false };

        // when
        runner.evaluate(outputFolder, () -> ran[0] = true);

        // then
        Mockito.verify(scopes).inEvaluation(ArgumentMatchers.any());
        Assertions.assertTrue(ran[0]);
        Assertions.assertSame(outputFolder, currentEvaluation.outputFolder());
    }

    @Test
    public void runOpensARunWithItsParametersAndRunsTheAlgorithm() throws Throwable {
        // given
        final OptimisationModule configuration = Mockito.mock(OptimisationModule.class);
        final Configuration algorithmConfiguration = Mockito.mock(Configuration.class);
        Mockito.when(configuration.getAlgorithm()).thenReturn(algorithmConfiguration);

        final FitnessPipeline pipeline = Mockito.mock(FitnessPipeline.class);
        final FitnessLayout layout = Mockito.mock(FitnessLayout.class);
        Mockito.when(fitnessPipelines.get()).thenReturn(pipeline);
        Mockito.when(pipeline.layout()).thenReturn(layout);

        final OptimisationAlgorithm algorithm = Mockito.mock(OptimisationAlgorithm.class);
        final File outputFolder = new File("output/search");
        final RunParameters parameters = new RunParameters(7, outputFolder, EvaluationPosition.withoutTarget(3, 5), null);

        // when
        try (MockedStatic<BeanFactory> factory = Mockito.mockStatic(BeanFactory.class)) {
            factory.when(() -> BeanFactory.createComponent(OptimisationAlgorithm.class, algorithmConfiguration)).thenReturn(algorithm);

            runner.run(configuration, parameters);
        }

        // then
        Assertions.assertSame(parameters, currentRun.getParameters());

        final InOrder order = Mockito.inOrder(scopes, literature, executionRecorder, algorithm);
        order.verify(scopes).inRun(ArgumentMatchers.eq(7L), ArgumentMatchers.any());
        order.verify(literature).start(configuration, outputFolder);
        order.verify(executionRecorder).defineFitness(layout);
        order.verify(executionRecorder).beginExecution();
        order.verify(algorithm).run();
        order.verify(executionRecorder).finishRun();
    }
}

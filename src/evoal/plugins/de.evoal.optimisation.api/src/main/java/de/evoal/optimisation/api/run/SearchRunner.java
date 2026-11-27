package de.evoal.optimisation.api.run;

import java.io.File;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Provider;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.EvaluationScoped;
import de.evoal.core.api.cdi.RunScoped;
import de.evoal.core.api.cdi.ScopeControl;
import de.evoal.core.api.provenance.RunRecord;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.FitnessComponentRequirements;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.main.search.OptimisationConfigurationSetup;

/**
 * Sets up an algorithm configuration of an OL file and executes runs of it, for the applications
 *   that search, e.g. {@code heuristic-search} (an evaluation with one run),
 *   {@code heuristic-search-evaluation} (repetitions and target points) or the COCO experiment
 *   of the benchmark suites (one run per problem). A configuration is set up once and can be
 *   run several times.
 * <p>
 * The runs of an application belong to an evaluation ({@link #evaluate}); every run opens its
 *   own {@link RunScoped} scope ({@link #run}), so the state of a run (e.g., the evaluation
 *   counters, the individual ids and the random streams) starts anew in every run. The
 *   {@link EvaluationScoped} state, e.g., the statistics files, is shared by the runs of the
 *   evaluation and ends with it. The application states what differs between the runs
 *   ({@link RunParameters}) and the columns of the statistics writers.
 */
@ApplicationScoped
@Slf4j
public class SearchRunner {
    @Inject
    private OptimisationConfigurationSetup configurationSetup;

    @Inject
    private ScopeControl scopes;

    @Inject
    private CurrentEvaluation currentEvaluation;

    @Inject
    private CurrentRun currentRun;

    @Inject
    private RandomService randomService;

    @Inject
    private ExecutionRecorder executionRecorder;

    /**
     * Creates the fitness pipeline of a run, whose components are recorded.
     */
    @Inject
    private Provider<FitnessPipeline> fitnessPipelines;

    /**
     * Writes the literature of the configuration ({@value RunLiterature#FILE_NAME}).
     */
    @Inject
    private RunLiterature literature;

    /**
     * Loads the configuration, sets up the search and optimisation space of its problem and binds
     *   the runtime model to the blackboard ({@code optimisation:optimisation-configuration}).
     *
     * @param configurationFile The OL file.
     * @return The runtime model of the configuration.
     */
    public OptimisationModule setUp(final String configurationFile) {
        return configurationSetup.setUp(configurationFile);
    }

    /**
     * Runs the body as an evaluation: the runs it executes ({@link #run}) share the
     *   evaluation-scoped state, which is destroyed when the body ends.
     *
     * @param outputFolder The output folder of the evaluation, e.g., for the statistics files.
     * @param body The runs of the evaluation.
     * @throws X the exception of the body.
     */
    public <X extends Throwable> void evaluate(final @NonNull File outputFolder, final ScopeControl.Body<X> body) throws X {
        scopes.inEvaluation(() -> {
            currentEvaluation.setOutputFolder(outputFolder);
            body.run();
        });
    }

    /**
     * Executes a run of the algorithm of the configuration in a new run scope: writes the
     *   literature of the configuration into the output folder of the run
     *   ({@value RunLiterature#FILE_NAME}, once for all runs of a configuration and folder),
     *   creates the algorithm and runs it.
     *
     * @param configuration The runtime model of {@link #setUp}.
     * @param parameters The parameters of the run.
     * @throws IllegalStateException if no evaluation is open ({@link #evaluate}).
     */
    public void run(final OptimisationModule configuration, final @NonNull RunParameters parameters) {
        scopes.inRun(parameters.number(), () -> {
            currentRun.setParameters(parameters);
            log.info("Starting run {} (seed {}).", parameters.number(), randomService.getSeed());

            execute(configuration, parameters.outputFolder());
        });
    }

    private void execute(final OptimisationModule configuration, final File outputFolder) {
        literature.start(configuration, outputFolder);
        RunRecord.current().setFolder(outputFolder.toPath().resolve(RunRecord.FOLDER));

        final FitnessLayout layout = fitnessPipelines.get().layout();
        try {
            FitnessComponentRequirements.check(literature.definitionsOf(configuration.getAlgorithm()), layout);
        } catch(final InitializationException e) {
            log.error("The configuration does not fit the fitness of the problem: {}", e.getMessage());
            throw new RuntimeException("The configuration does not fit the fitness of the problem.", e);
        }

        final OptimisationAlgorithm algorithm =
                BeanFactory.createComponent(OptimisationAlgorithm.class, configuration.getAlgorithm());

        executionRecorder.defineFitness(layout);
        executionRecorder.beginExecution();
        algorithm.run();
        executionRecorder.finishRun();
    }
}

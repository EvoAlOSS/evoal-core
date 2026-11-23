package de.evoal.optimisation.api.run;

import java.nio.file.Path;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Provider;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.provenance.RunRecord;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.execution.EvaluationPosition;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.model.IndividualIDGenerator;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.main.search.OptimisationConfigurationSetup;

/**
 * Sets up an algorithm configuration of an OL file and executes runs of it, for the applications
 *   that search, e.g. {@code heuristic-search} (one run), {@code heuristic-search-evaluation}
 *   (repetitions and target points) or the COCO experiment of the benchmark suites (one run per
 *   problem). A configuration is set up once and can be run several times; every run gets the
 *   random numbers of its run number ({@link RandomService#startRun(long)}), so runs with
 *   different numbers are independent and runs with the same number repeat each other.
 * <p>
 * The application keeps what differs between them: the output folder and the run of the
 *   blackboard ({@code optimisation:evaluation-output-folder}, {@code optimisation:evaluation-run})
 *   and the columns of the statistics writers.
 */
@ApplicationScoped
public class SearchRunner {
    @Inject
    private OptimisationConfigurationSetup configurationSetup;

    @Inject
    private RandomService randomService;

    @Inject
    private IndividualIDGenerator idGenerator;

    @Inject
    private ExecutionRecorder executionRecorder;

    /**
     * Creates the fitness pipeline of a run, whose components are recorded.
     */
    @Inject
    private Provider<FitnessPipeline> fitnessPipelines;

    @Inject
    private Blackboard board;

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
     * Executes a run of the algorithm of the configuration: writes the literature of the
     *   configuration into the output folder ({@value RunLiterature#FILE_NAME}, once for all runs
     *   of a configuration and folder), starts the random numbers of the run, the individual ids
     *   and the execution of the memory model, creates the algorithm and runs it.
     *
     * @param configuration The runtime model of {@link #setUp}.
     * @param run The number of the run; it determines the random numbers of the run.
     * @param position The position of the run in an evaluation setup (repetition, target point),
     *   {@code null} for a single run.
     */
    public void run(final OptimisationModule configuration, final long run, final EvaluationPosition position) {
        final Object outputFolder = board.getOrNull(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER);
        literature.start(configuration, outputFolder);
        if(outputFolder != null) {
            RunRecord.current().setFolder(Path.of(outputFolder.toString()).resolve(RunRecord.FOLDER));
        }
        randomService.startRun(run);
        idGenerator.startRun();
        executionRecorder.startRun(position);

        final OptimisationAlgorithm algorithm =
                BeanFactory.createComponent(OptimisationAlgorithm.class, configuration.getAlgorithm());

        executionRecorder.defineFitness(fitnessPipelines.get().layout());
        executionRecorder.beginExecution();
        algorithm.run();
        executionRecorder.finishRun();
    }
}

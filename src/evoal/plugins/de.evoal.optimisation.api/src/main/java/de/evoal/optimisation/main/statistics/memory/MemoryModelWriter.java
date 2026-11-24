package de.evoal.optimisation.main.statistics.memory;

import java.io.File;
import java.lang.module.ModuleDescriptor;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import tools.jackson.databind.node.ObjectNode;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.execution.EvaluationPosition;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.Goals;
import de.evoal.optimisation.api.run.RunLiterature;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

/**
 * Writes the memory model of a run as JSON files (DL type {@code memory-model}) into the
 *   folder {@value #FOLDER_NAME} of the output folder, or into its subfolder of the run in
 *   the evaluation setup ({@link EvaluationPosition#relativeFolder()}).
 * <p>
 * The EvoAl version is the version of this module; all EvoAl modules share one version.
 * <p>
 * By default, the final version of the memory model is written: an iteration holds its
 *   ranked members. With {@code 'steps' := true}, the steps version is written: every executed
 *   step additionally holds its outputs, and every individual is related to its direct
 *   predecessor. Both versions have the same individual ids.
 * <p>
 * The writer is created while the metrics are still being defined. Therefore, it prepares
 *   the folder and writes {@code execution-information.json} when the run starts
 *   ({@link #start()}), when the definitions are complete. It writes
 *   {@code execution-finished.json} when the run finishes ({@link #write()}); the
 *   execution metrics have to be final at that point.
 */
@Dependent
@Named("de.evoal.optimisation.core.memory-model")
@Slf4j
public class MemoryModelWriter implements StatisticsWriter {
    /**
     * The name of the folder in the output folder.
     */
    public static final String FOLDER_NAME = "memory-model";

    /**
     * The version that is written if the module has no version, e.g. in unit tests.
     */
    public static final String UNKNOWN_VERSION = "unknown";

    /**
     * The configuration of the algorithm.
     */
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm")
    private EObject algorithm;

    /**
     * The statistics writers of the algorithm block ({@code document := [...]}), {@code null} if
     *   there are none.
     */
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "documentation")
    private List<EObject> algorithmWriters;

    /**
     * Finds the data descriptions of the features.
     */
    @Inject
    private EAnnotationHelper annotationHelper;

    /**
     * Reads the configuration of the writer and of the fitness steps.
     */
    @Inject
    private AttributeHelper attributes;

    /**
     * Reads the attribute values of the configurations, with their defaults.
     */
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The ids of the best individuals (rank 0) of the last written iteration.
     */
    private List<Integer> best = List.of();

    /**
     * Whether writing failed. Then no further files are written, so the memory model has
     *   no {@code execution-finished.json}.
     */
    private boolean failed;

    /**
     * The folder of the run, created when the run starts. {@code null} before.
     */
    private MemoryModelFolder folder;

    /**
     * The goals of the problem, with the targets of the run resolved.
     */
    @Inject
    private Goals goals;

    /**
     * The literature of the configuration ({@code citations.bib}), whose keys the execution
     *   information lists.
     */
    @Inject
    private RunLiterature literature;

    /**
     * Converts the memory model to JSON, created when the run starts.
     */
    private MemoryModelJson json;

    /**
     * The number of written iteration files.
     */
    private int numberOfIterations;

    /**
     * The output folder of the application.
     */
    @Inject
    @BlackboardValue(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER)
    private File outputFolder;

    /**
     * The optimisation problem.
     */
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem")
    private EObject problem;

    /**
     * The statistics writers of the problem, {@code null} if there are none.
     */
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.documentation")
    private List<EObject> problemWriters;

    /**
     * Provides the seed of the execution.
     */
    @Inject
    private RandomService randomService;

    /**
     * Provides the execution and the position of the run.
     */
    @Inject
    private ExecutionRecorder recorder;

    /**
     * Whether the steps version is written instead of the final version.
     */
    private boolean steps;

    /**
     * Writes the iteration file.
     *
     * A failure to write is logged and stops the writer; the run continues.
     *
     * @throws IllegalStateException if the run is not started ({@link #start()}) or the
     *   iterations are not numbered 0, 1, 2, ...
     */
    @Override
    public void add(final Iteration iteration) {
        if(failed) {
            return;
        }

        if(folder == null) {
            throw new IllegalStateException("The memory model writer got iteration " + iteration.getNumber()
                                            + " before the run started.");
        }

        try {
            requireNextNumber(iteration);

            final ObjectNode document = json.toIteration(iteration, steps);
            folder.write("iteration-" + iteration.getNumber() + ".json", document);

            numberOfIterations += 1;
            best = bestOf(iteration);
        } catch(final EvoalIOException e) {
            stopWriting(e);
        }
    }

    /**
     * @return The ids of the members of rank 0.
     */
    private static List<Integer> bestOf(final Iteration iteration) {
        return iteration.getRanks()
                        .stream()
                        .filter(rank -> rank.getNumber() == 0)
                        .map(Rank::getMembers)
                        .flatMap(List::stream)
                        .map(Individual::getId)
                        .toList();
    }

    /**
     * Reads whether the executed steps are written ({@code 'steps'}).
     */
    @Override
    public StatisticsWriter init(final EObject configuration) {
        final Boolean writeSteps = attributes.lookup(configuration, "steps");
        steps = Boolean.TRUE.equals(writeSteps);

        return this;
    }

    /**
     * @return Whether the steps version is written ({@code 'steps'}).
     */
    @Override
    public boolean readsSteps() {
        return steps;
    }

    /**
     * @throws IllegalStateException if the iteration does not have the next number.
     */
    private void requireNextNumber(final Iteration iteration) {
        if(iteration.getNumber() == numberOfIterations) {
            return;
        }

        throw new IllegalStateException("The memory model expects iteration " + numberOfIterations
                                        + ", but got iteration " + iteration.getNumber() + ".");
    }

    /**
     * @return The folder of the current run.
     */
    private Path runFolder() {
        final Path baseFolder = outputFolder.toPath()
                                            .resolve(FOLDER_NAME);
        final Optional<EvaluationPosition> position = recorder.getEvaluationPosition();

        return position.map(EvaluationPosition::relativeFolder)
                       .map(baseFolder::resolve)
                       .orElse(baseFolder);
    }

    /**
     * Prepares the folder of the run and writes the execution information.
     *
     * A failure to write is logged and stops the writer; the run continues.
     *
     * @throws IllegalStateException if the problem is not an optimisation problem.
     */
    @Override
    public void start() {
        try {
            prepareRun();
        } catch(final EvoalIOException e) {
            stopWriting(e);
        }
    }

    /**
     * Prepares the folder of the run and writes the execution information.
     *
     * @throws IllegalStateException if the problem is not an optimisation problem.
     * @throws EvoalIOException if the folder cannot be prepared or the file cannot be written.
     */
    private void prepareRun() throws EvoalIOException {
        if(!(problem instanceof Problem optimisationProblem)) {
            throw new IllegalStateException("The memory model writer needs the optimisation problem, but got "
                                            + problem + ".");
        }

        json = new MemoryModelJson(annotationHelper, ConfigurationJson.of(evaluator));
        folder = new MemoryModelFolder(runFolder());
        folder.prepare();

        final List<EObject> documentation = writersInUse();
        final List<Configuration> fitnessSteps = attributes.lookup(algorithm, "fitness-pipeline");
        final Execution execution = recorder.getExecution();
        final RunSetup setup = toSetup();

        final ObjectNode document = json.toExecutionInformation(optimisationProblem,
                                                                goals,
                                                                algorithm,
                                                                documentation,
                                                                fitnessSteps,
                                                                execution,
                                                                setup,
                                                                literature.keys());
        folder.write("execution-information.json", document);

        log.info("Writing the memory model to '{}'.", folder.getFolder());
    }

    /**
     * @return The statistics writers in the order they are used: those of the problem, then
     *   those of the algorithm block (see {@code StatisticsFactory}).
     */
    private List<EObject> writersInUse() {
        final List<EObject> writers = new ArrayList<>();
        if(problemWriters != null) {
            writers.addAll(problemWriters);
        }
        if(algorithmWriters != null) {
            writers.addAll(algorithmWriters);
        }

        return writers;
    }

    /**
     * Logs the failure and stops writing.
     */
    private void stopWriting(final EvoalIOException failure) {
        failed = true;

        log.error("Failed to write the memory model, no further files are written.", failure);
    }

    /**
     * @return The setup of the current run.
     */
    private RunSetup toSetup() {
        final String version = versionOfModule();
        final long seed = randomService.getSeed();
        final long run = randomService.getRun();
        final EvaluationPosition position = recorder.getEvaluationPosition()
                                                    .orElse(null);

        return new RunSetup(version, seed, run, position);
    }

    /**
     * @return The version of this module, {@value #UNKNOWN_VERSION} if it has none (e.g. an
     *   unnamed module in unit tests).
     */
    private static String versionOfModule() {
        final ModuleDescriptor descriptor = MemoryModelWriter.class.getModule()
                                                                   .getDescriptor();
        if(descriptor == null) {
            return UNKNOWN_VERSION;
        }

        return descriptor.rawVersion()
                         .orElse(UNKNOWN_VERSION);
    }

    /**
     * Writes {@code execution-finished.json} and removes the folder for incomplete files.
     *   Does nothing if the run was not started or writing failed.
     */
    @Override
    public void write() {
        final boolean nothingToFinish = folder == null || failed;
        if(nothingToFinish) {
            return;
        }

        final Execution execution = recorder.getExecution();
        final ObjectNode document = json.toExecutionFinished(numberOfIterations, best, execution);

        try {
            folder.write("execution-finished.json", document);
            folder.complete();
        } catch(final EvoalIOException e) {
            stopWriting(e);
        }
    }
}

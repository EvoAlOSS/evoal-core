package de.evoal.optimisation.main.search;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.*;
import de.evoal.optimisation.api.cdi.TargetPointLoader;
import de.evoal.optimisation.api.execution.EvaluationPosition;
import de.evoal.optimisation.api.run.RunParameters;
import de.evoal.optimisation.api.run.SearchRunner;

import jakarta.enterprise.context.ApplicationScoped;

import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import jakarta.inject.Provider;
import lombok.extern.slf4j.Slf4j;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

@Slf4j
@Application(
        name = HeuristicSearchEvaluation.NAME,
        documentation = """
Prepares evaluation of a heuristic search by running it multiple times.
Furthermore, it is possible to use a target file to run it for multiple
times for different targets.

Each target is searched for 'optimisation:evaluation-iterations' times to allow a
proper empirical evaluation.
"""
)
@ApplicationScoped
public class HeuristicSearchEvaluation implements MainClass {
    /**
     * The name of the application, the value of {@code -Bcore:main}.
     */
    public static final String NAME = "heuristic-search-evaluation";

    @Inject
    private Blackboard board;

    @Inject
    private SearchRunner runner;

    /**
     * Counts the runs over all targets, each run gets its own random numbers.
     */
    private long runCounter = 0;

    @Inject
    private WriterContext context;

    @Inject
    @BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE)
    private String olFile;

    @Inject
    @BlackboardValue(OptimisationBlackboardEntries.EVALUATION_ITERATIONS)
    private int iterations;

    /**
     * The folder the statistics are written to: {@code <output-folder>/<name of the OL file>}.
     */
    private File outputBaseDir;

    private List<EObjectPair> targets;

    private Column targetColumn;
    private Column repetitionColumn;

    @Inject @Named("search-space")
    private Provider<Space> searchSpaceProvider;

    @Inject @Named("optimisation-space")
    private Provider<Space> optimisationSpaceProvider;

    private OptimisationModule algorithmConfiguration;

    @Override
    public void run() {
        final String targetFile = board.getOrNull(OptimisationBlackboardEntries.TARGET_POINTS_FILE);

        log.info("Running heuristic search evaluation with the following configuration:");
        log.info("  target points loaded from ({})", targetFile == null ? "no target points given" : targetFile);
        log.info("  heuristic configuration loaded from ({})", olFile);
        log.info("  running {} iterations.", iterations);

        final String outputFolder = board.get(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER);
        outputBaseDir = HeuristicSearchUtils.calculateOutputBaseDir(new File(outputFolder), new File(olFile));

        algorithmConfiguration = runner.setUp(olFile);

        if(targetFile != null) {
            final TargetPointLoader loader = BeanFactory.create(TargetPointLoader.class);
            targets = loader.getTargetObjectStream(searchSpaceProvider.get(), optimisationSpaceProvider.get()).get().toList();
            log.info("Processing {} targets during evaluation.", targets.size());
        }

        final long startTime = System.currentTimeMillis();
        runner.evaluate(outputBaseDir, this::process);
        final long endTime = System.currentTimeMillis();

        System.err.println("Calculation of heuristic search took in average " + (endTime - startTime)/iterations + " ms.");
    }

    private void process() {
        repetitionColumn = HeuristicSearchUtils.addColumn(context, "repetition", ColumnType.Integer, 0);

        if(targets != null) {
            targetColumn = HeuristicSearchUtils.addColumn(context, "target", ColumnType.Integer, 0);

            targets.forEach(this::processTarget);
        } else {
            processOptimisation(null);
        }
    }

    private int targetIndex = 0;

    /**
     * The index of the target point that is currently evaluated.
     */
    private int currentTarget;

    private void processTarget(final EObjectPair target) {
        final int targetIndex = this.targetIndex++;
        currentTarget = targetIndex;

        context.bindColumn(targetColumn, targetIndex);

        log.info("Evaluating with target {} -> {}.", targetIndex, target);

        processOptimisation(target.getSecond());
    }

    /**
     * Runs the repetitions of the search.
     *
     * @param targetProperties The values of the target point, {@code null} without a target
     *   file.
     */
    private void processOptimisation(final EObject targetProperties) {
        for (int i = 0; i < iterations; ++i) {
            log.info("Running {}/{}", i, iterations);
            context.bindColumn(repetitionColumn, i);

            final RunParameters parameters = new RunParameters(runCounter++, outputBaseDir, toEvaluationPosition(i), targetProperties);
            runner.run(algorithmConfiguration, parameters);
        }
    }

    /**
     * @return The position of the run: the repetition and, if a target file is used, the
     *   current target point.
     */
    private EvaluationPosition toEvaluationPosition(final int repetition) {
        if(targets == null) {
            return EvaluationPosition.withoutTarget(repetition, iterations);
        }

        return EvaluationPosition.withTarget(repetition, iterations, currentTarget, targets.size());
    }
}


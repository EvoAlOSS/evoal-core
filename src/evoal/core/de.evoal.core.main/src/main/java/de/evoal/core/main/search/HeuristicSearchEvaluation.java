package de.evoal.core.main.search;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.*;
import de.evoal.core.api.optimisation.OptimisationAlgorithm;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesPair;
import de.evoal.core.api.board.Blackboard;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.statistics.writer.WriterContext;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Pair;

import javax.inject.Inject;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Application(
        name = "heuristic-search-evaluation",
documentation = """
Prepares evaluation of a heuristic search by running it multiple times.
Furthermore, it is possible to use a target file to run it for multiple
times for different targets.

Each target is searched for 'core:evaluation-iterations' times to allow a
proper empirical evaluation.
"""
)
@ApplicationScoped
public class HeuristicSearchEvaluation implements MainClass {
    @Inject
    private Blackboard board;

    @Inject
    private WriterContext context;

    @Inject
    @BlackboardValue(CoreBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE)
    private String olFile;

    @Inject
    @BlackboardValue(CoreBlackboardEntries.EVALUATION_ITERATIONS)
    private int iterations;

    @Inject
    @BlackboardValue(CoreBlackboardEntries.EVALUATION_OUTPUT_FOLDER)
    private File outputBaseDir;

    private List<Pair<Properties, Properties>> targets;

    private Column targetColumn;
    private Column runColumn;


    @Inject
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm")
    private Instance algorithmConfiguration;

    @Override
    public void run() {
        final String targetFile = board.getOrNull(CoreBlackboardEntries.TARGET_POINTS_FILE);

        log.info("Running heuristic search evaluation with the following configuration:");
        log.info("  target points loaded from ({})", targetFile == null ? "no target points given" : targetFile);
        log.info("  heuristic configuration loaded from ({})", olFile);
        log.info("  running {} iterations.", iterations);

        if(targetFile != null) {
            Stream<PropertiesPair> targetStream = BeanFactory.create("target-stream", Stream.class);
            targets = targetStream.collect(Collectors.toList());
        }

        log.info("Processing {} targets during evaluation.", targets.size());

        final long startTime = System.currentTimeMillis();
        process();
        final long endTime = System.currentTimeMillis();

        System.err.println("Calculation of heuristic search took in average " + (endTime - startTime)/iterations + " ms.");
    }

    private void process() {
        runColumn = HeuristicSearchUtils.addColumn(context,"run", ColumnType.Integer, 0);

        board.bind(CoreBlackboardEntries.EVALUATION_OUTPUT_FOLDER, outputBaseDir);

        if(targets != null) {
            targetColumn = HeuristicSearchUtils.addColumn(context, "target", ColumnType.Integer, 0);

            targets.forEach(this::processTarget);
        } else {
            processOptimisation();
        }
    }

    private int targetIndex = 0;
    private void processTarget(final Pair<Properties, Properties> target) {
        final int targetIndex = this.targetIndex++;

        context.bindColumn(targetColumn, targetIndex);

        board.bind(CoreBlackboardEntries.TARGET_PROPERTIES, target.getSecond());

        log.info("Evaluating with target {} -> {}.", targetIndex, target);

        processOptimisation();
    }

    private void processOptimisation() {
        final int runLength = calculateFigures(iterations);

        board.bind(CoreBlackboardEntries.EVALUATION_OUTPUT_FOLDER, outputBaseDir);

        for (int i = 0; i < iterations; ++i) {
            log.info("Running {}/{}", i, iterations);
            final String run = convertToString(i, runLength);
            board.bind(CoreBlackboardEntries.EVALUATION_RUN, run);
            context.bindColumn(runColumn, i);

            BeanFactory.createComponent(OptimisationAlgorithm.class, algorithmConfiguration)
                       .run();
        }
    }

    private String convertToString(final int targetIndex, final int length) {
        return String.format("%0" + Math.max(length, 1) + "d", targetIndex);
    }

    private int calculateFigures(final int number) {
        return (int)(Math.log10(number));
    }
}


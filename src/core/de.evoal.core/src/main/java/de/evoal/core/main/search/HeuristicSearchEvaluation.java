package de.evoal.core.main.search;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesPair;
import de.evoal.core.api.board.Blackboard;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.core.api.statistics.Column;
import de.evoal.core.api.statistics.ColumnType;
import de.evoal.core.api.statistics.WriterContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Pair;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Named("evaluation")
@ApplicationScoped
public class HeuristicSearchEvaluation implements MainClass {
    @Inject
    private Blackboard board;

    @Inject
    private WriterContext context;

    @Inject
    @BlackboardValue(BlackboardEntry.EA_CONFIGURATION_FILE)
    private String heuristicFile;

    @Inject
    @BlackboardValue(BlackboardEntry.EVALUATION_ITERATIONS)
    private int iterations;

    private File outputBaseDir;

    private List<Pair<Properties, Properties>> targets;

    @Inject
    @BlackboardValue(BlackboardEntry.TARGET_POINTS_FILE)
    private String targetFile;

    @Inject
    @Named("target-stream")
    private Stream<PropertiesPair> targetStream;

    private Column targetColumn;
    private Column runColumn;

    @Override
    public void run() {
        log.info("Running heuristic search evaluation with the following configuration:");
        log.info("  target points loaded from ({})", targetFile);
        log.info("  heuristic configuration loaded from ({})", heuristicFile);
        log.info("  running {} iterations.", iterations);

        /* prepare output directory */
        this.outputBaseDir = new File(board.<String>get(BlackboardEntry.EVALUATION_OUTPUT_FOLDER));

        targets = targetStream.collect(Collectors.toList());

        log.info("Processing {} targets during evaluation.", targets.size());

        final long startTime = System.currentTimeMillis();
        process();
        final long endTime = System.currentTimeMillis();

        System.err.println("Calculation of heuristic search took in average " + (endTime - startTime)/iterations + " ms.");
    }

    private void process() {
        targetColumn = HeuristicSearchUtils.addColumn(context,"target", ColumnType.Integer, 0);
        runColumn = HeuristicSearchUtils.addColumn(context,"run", ColumnType.Integer, 0);

        targets.forEach(this::processTarget);
    }

    private int targetIndex = 0;
    private void processTarget(final Pair<Properties, Properties> target) {
        final int targetIndex = this.targetIndex++;
        final int targetLength = calculateFigures(targets.size());
        final int runLength = calculateFigures(iterations);

        context.bindColumn(targetColumn, targetIndex);

//        board.bind(BlackboardEntry.TARGET_PROPERTIES_SOURCE, target.getFirst());
        board.bind(BlackboardEntry.TARGET_PROPERTIES, target.getSecond());
        board.bind(BlackboardEntry.EVALUATION_OUTPUT_FOLDER, outputBaseDir);

        log.info("Evaluating with target {} -> {}.", targetIndex, target);

        for (int i = 0; i < iterations; ++i) {
            log.info("Running {}/{}", i, iterations);
            final String run = convertToString(i, runLength);
            board.bind(BlackboardEntry.EVALUATION_RUN, run);
            context.bindColumn(runColumn, i);

            BeanFactory.create(HeuristicSearch.class)
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


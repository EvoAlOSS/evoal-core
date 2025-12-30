package de.evoal.optimisation.main.search;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.*;
import de.evoal.optimisation.api.cdi.TargetPointLoader;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.core.api.properties.PropertiesPair;

import jakarta.enterprise.context.ApplicationScoped;

import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import de.evoal.optimisation.main.producer.OptimisationModuleLoader;
import jakarta.inject.Provider;
import lombok.extern.slf4j.Slf4j;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.File;
import java.util.List;

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
    private OptimisationModuleLoader loader;

    @Inject
    @BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE)
    private String olFile;

    @Inject
    @BlackboardValue(OptimisationBlackboardEntries.EVALUATION_ITERATIONS)
    private int iterations;

    @Inject
    @BlackboardValue(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER)
    private File outputBaseDir;

    private List<PropertiesPair> targets;

    private Column targetColumn;
    private Column runColumn;

    @Inject @Named("search-space-specification")
    private Provider<PropertiesSpecification> inputSpaceProvider;

    @Inject @Named("optimisation-space-specification")
    private Provider<PropertiesSpecification> outputSpaceProvider;

    private OptimisationModule algorithmConfiguration;

    @Override
    public void run() {
        final String targetFile = board.getOrNull(OptimisationBlackboardEntries.TARGET_POINTS_FILE);

        log.info("Running heuristic search evaluation with the following configuration:");
        log.info("  target points loaded from ({})", targetFile == null ? "no target points given" : targetFile);
        log.info("  heuristic configuration loaded from ({})", olFile);
        log.info("  running {} iterations.", iterations);

        algorithmConfiguration = loader.load(olFile);
        board.bind(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, algorithmConfiguration);

        if(targetFile != null) {
            final TargetPointLoader loader = BeanFactory.create(TargetPointLoader.class);
            targets = loader.getTargetPropertiesStream(inputSpaceProvider.get(), outputSpaceProvider.get()).get().toList();
            log.info("Processing {} targets during evaluation.", targets.size());
        }

        final long startTime = System.currentTimeMillis();
        process();
        final long endTime = System.currentTimeMillis();

        System.err.println("Calculation of heuristic search took in average " + (endTime - startTime)/iterations + " ms.");
    }

    private void process() {
        runColumn = HeuristicSearchUtils.addColumn(context,"run", ColumnType.Integer, 0);

        board.bind(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER, outputBaseDir);

        if(targets != null) {
            targetColumn = HeuristicSearchUtils.addColumn(context, "target", ColumnType.Integer, 0);

            targets.forEach(this::processTarget);
        } else {
            processOptimisation();
        }
    }

    private int targetIndex = 0;
    private void processTarget(final PropertiesPair target) {
        final int targetIndex = this.targetIndex++;

        context.bindColumn(targetColumn, targetIndex);

        board.bind(OptimisationBlackboardEntries.TARGET_PROPERTIES, target.getSecond());

        log.info("Evaluating with target {} -> {}.", targetIndex, target);

        processOptimisation();
    }

    private void processOptimisation() {
        final int runLength = calculateFigures(iterations);

        board.bind(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER, outputBaseDir);

        for (int i = 0; i < iterations; ++i) {
            log.info("Running {}/{}", i, iterations);
            final String run = convertToString(i, runLength);
            board.bind(OptimisationBlackboardEntries.EVALUATION_RUN, run);
            context.bindColumn(runColumn, i);

            BeanFactory.createComponent(OptimisationAlgorithm.class, algorithmConfiguration.getAlgorithm())
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


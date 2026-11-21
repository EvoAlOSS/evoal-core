package de.evoal.optimisation.main.search;

import java.io.File;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.run.SearchRunner;

/**
 * Runs a single heuristic search for the problem and algorithm of an OL file.
 *   Unlike {@link HeuristicSearchEvaluation}, there is only one run, so the
 *   statistics contain no {@code run} or {@code target} columns.
 */
@Application(
        name = "heuristic-search",
        documentation = """
This application starts a heuristic search for an optimal solution based on a
problem specification.
""")
@ApplicationScoped
@Slf4j
public class HeuristicSearchMain implements MainClass {
    @Inject
    private Blackboard board;

    @Inject
    private SearchRunner runner;

    @Override
    public void run() {
        log.info("Searching for an optimal problem solution.");
        final String outputFolder = board.get(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER);
        final String heuristicFileName = board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE);

        final File outputRoot = new File(outputFolder);
        final File configurationFile = new File(heuristicFileName);
        final File outputBaseDir = HeuristicSearchUtils.calculateOutputBaseDir(outputRoot, configurationFile);

        board.bind(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER, outputBaseDir);
        board.bind(OptimisationBlackboardEntries.EVALUATION_RUN, "0");

        final OptimisationModule configuration = runner.setUp(heuristicFileName);
        runner.run(configuration, 0, null);
    }
}

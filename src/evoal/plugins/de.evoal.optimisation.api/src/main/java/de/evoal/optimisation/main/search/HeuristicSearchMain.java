package de.evoal.optimisation.main.search;

import java.io.File;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EClass;

import org.apache.commons.math3.util.Pair;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.random.RandomService;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.models.core.ecore.Space;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.producer.SpaceProducer;
import de.evoal.optimisation.main.producer.OptimisationModuleLoader;

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
    private EClassProvider eClassProvider;

    @Inject
    private OptimisationModuleLoader loader;

    @Inject
    private RandomService randomService;

    @Inject
    private SpaceProducer spaceProducer;

    @Inject
    private OptimisationModelTransformer transformer;

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

        final OptimisationModule configurationModel = loader.load(heuristicFileName);
        setupSpaces(configurationModel);

        final Space searchSpace = spaceProducer.searchSpace();
        final Space merged = spaceProducer.optimisationSpace()
                                          .merge(searchSpace);

        final de.evoal.models.v202704.optimisation.model.OptimisationModule eConfigurationModel =
                transformer.transform(configurationModel, merged);

        board.bind(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, eConfigurationModel);

        randomService.startRun(0);

        BeanFactory.createComponent(OptimisationAlgorithm.class, eConfigurationModel.getAlgorithm())
                   .run();
    }

    private void setupSpaces(final OptimisationModule module) {
        log.info("Setting up search and optimisation space for local search.");

        final Pair<EClass, EClass> spaceClasses = eClassProvider.eClassFor(module.getProblem());
        final Space searchSpace = new Space(spaceClasses.getFirst());
        final Space optimisationSpace = new Space(spaceClasses.getSecond());

        spaceProducer.setSearchSpace(searchSpace);
        spaceProducer.setOptimisationSpace(optimisationSpace);
    }
}

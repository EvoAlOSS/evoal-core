package de.evoal.optimisation.main.search;

import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.optimisation.api.producer.SpaceProducer;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.cdi.*;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import de.evoal.optimisation.main.producer.OptimisationModuleLoader;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EClass;

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
	private RandomService randomService;

	@Inject
	private WriterContext context;

	@Inject
	private EClassProvider eClassProvider;

	@Inject
	private OptimisationModuleLoader loader;

	@Inject
	private OptimisationModelTransformer transformer;

	@Inject
	private SpaceProducer spaceProducer;

	@Override
	public void run() {
		log.info("Searching for an optimal problem solution.");
		final String outputFolder = board.get(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER);
		final String heuristicFileName = board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE);

		final File outputBaseDir = HeuristicSearchUtils.calculateOutputBaseDir(new File(outputFolder), new File(heuristicFileName));

		HeuristicSearchUtils.addColumn(context,"target", ColumnType.Integer, 0);
		HeuristicSearchUtils.addColumn(context,"run", ColumnType.Integer, 0);

		board.bind(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER, outputBaseDir);
		board.bind(OptimisationBlackboardEntries.EVALUATION_RUN, "0");

		final OptimisationModule configurationModel = loader.load(heuristicFileName);
		setupSpaces(configurationModel);
		final Space merged = spaceProducer.optimisationSpace().merge(spaceProducer.searchSpace());

		final de.evoal.models.v202704.optimisation.model.OptimisationModule eConfigurationModel = transformer.transform(configurationModel, merged);

		board.bind(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, eConfigurationModel);

		randomService.startRun(0);

		BeanFactory
				.createComponent(OptimisationAlgorithm.class, eConfigurationModel.getAlgorithm())
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

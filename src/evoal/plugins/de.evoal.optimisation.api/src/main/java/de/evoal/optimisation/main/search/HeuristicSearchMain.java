package de.evoal.optimisation.main.search;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.cdi.*;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import jakarta.enterprise.context.ApplicationScoped;

import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import lombok.extern.slf4j.Slf4j;
import de.evoal.optimisation.main.producer.OptimisationModuleLoader;

import jakarta.inject.Inject;
import java.io.File;

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
	@BlackboardValue(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE)
	private String algorithmConfigurationFile;

	@Inject
	private Blackboard board;

	@Inject
	private WriterContext context;

	@Inject
	private OptimisationModuleLoader loader;

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
		board.bind(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, configurationModel);

		BeanFactory.createComponent(OptimisationAlgorithm.class, configurationModel.getAlgorithm())
				.run();
	}
}

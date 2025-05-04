package de.evoal.optimisation.main.search;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import javax.enterprise.context.ApplicationScoped;

import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import de.evoal.languages.model.base.expressions.Instance;

import javax.inject.Inject;
import java.io.File;

@Application(
		name = "heuristic-search",
		documentation = """
This application starts a heuristic search for an optimal solution based on a
problem specification.
""")
@ApplicationScoped
public class HeuristicSearchMain implements MainClass {
	@Inject
	private Blackboard board;

	@Inject
	private WriterContext context;

	@Inject
	@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm")
	private Instance algorithmConfiguration;

	@Override
	public void run() {
		final String outputFolder = board.get(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER);
		final String heuristicFileName = board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE);

		final File outputBaseDir = HeuristicSearchUtils.calculateOutputBaseDir(new File(outputFolder), new File(heuristicFileName));

		HeuristicSearchUtils.addColumn(context,"target", ColumnType.Integer, 0);
		HeuristicSearchUtils.addColumn(context,"run", ColumnType.Integer, 0);

		board.bind(OptimisationBlackboardEntries.EVALUATION_OUTPUT_FOLDER, outputBaseDir);
		board.bind(OptimisationBlackboardEntries.EVALUATION_RUN, "0");

		BeanFactory.createComponent(OptimisationAlgorithm.class, algorithmConfiguration)
				.run();
	}
}

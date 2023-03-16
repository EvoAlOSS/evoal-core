package de.evoal.core.main.search;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.properties.Properties;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.core.api.optimisation.OptimisationAlgorithm;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.statistics.writer.WriterContext;
import de.evoal.languages.model.instance.Instance;
import org.apache.commons.math3.util.Pair;

import javax.inject.Inject;
import java.io.File;
import java.util.stream.Stream;

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
	@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm")
	private Instance algorithmConfiguration;

	@Override
	public void run() {
		final String outputFolder = board.get(CoreBlackboardEntries.EVALUATION_OUTPUT_FOLDER);
		final String heuristicFileName = board.get(CoreBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE);

		final File outputBaseDir = HeuristicSearchUtils.calculateOutputBaseDir(new File(outputFolder), new File(heuristicFileName));

		HeuristicSearchUtils.addColumn(context,"target", ColumnType.Integer, 0);
		HeuristicSearchUtils.addColumn(context,"run", ColumnType.Integer, 0);

		board.bind(CoreBlackboardEntries.EVALUATION_OUTPUT_FOLDER, outputBaseDir);
		board.bind(CoreBlackboardEntries.EVALUATION_RUN, "0");

		BeanFactory.create(OptimisationAlgorithm.class)
				   .init(algorithmConfiguration)
				   .run();
	}

	private static void setTarget(final Stream<Pair<Properties, Properties>> targets, final Blackboard board) {
		final Pair<Properties, Properties> targetProperties =
					targets.findFirst()
						   .orElseThrow(() -> {throw new IllegalStateException("No target point found");});

		board.bind(CoreBlackboardEntries.TARGET_PROPERTIES, targetProperties.getSecond());
	}
}

package de.evoal.core.main.search;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.properties.Properties;
import javax.enterprise.context.ApplicationScoped;

import de.evoal.core.api.statistics.ColumnType;
import de.evoal.core.api.statistics.WriterContext;
import org.apache.commons.math3.util.Pair;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.stream.Stream;

@Named("heuristic-search")
@ApplicationScoped
public class HeuristicSearchMain implements MainClass {
	@Inject
	private Blackboard board;

	@Inject
	private WriterContext context;

	@Override
	public void run() {
		final String outputFolder = board.get(BlackboardEntry.EVALUATION_OUTPUT_FOLDER);
		final String heuristicFileName = board.get(BlackboardEntry.EA_CONFIGURATION_FILE);

		final File outputBaseDir = HeuristicSearchUtils.calculateOutputBaseDir(new File(outputFolder), new File(heuristicFileName));

		HeuristicSearchUtils.addColumn(context,"target", ColumnType.Integer, 0);
		HeuristicSearchUtils.addColumn(context,"run", ColumnType.Integer, 0);

		board.bind(BlackboardEntry.EVALUATION_OUTPUT_FOLDER, outputBaseDir);
		board.bind(BlackboardEntry.EVALUATION_RUN, "0");

		BeanFactory.create(HeuristicSearch.class)
				   .run();
	}

	private static void setTarget(final Stream<Pair<Properties, Properties>> targets, final Blackboard board) {
		final Pair<Properties, Properties> targetProperties =
					targets.findFirst()
						   .orElseThrow(() -> {throw new IllegalStateException("No target point found");});

		board.bind(BlackboardEntry.TARGET_PROPERTIES, targetProperties.getSecond());
	}
}

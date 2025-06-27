package de.evoal.optimisation.main.search;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.utils.EvoAlShutDownException;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.cdi.*;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import javax.enterprise.context.ApplicationScoped;

import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;
import de.evoal.optimisation.main.producer.OptimisationModuleLoader;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;
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

	public void receive(@Observes(notifyObserver = Reception.IF_EXISTS) final Diagnostics diag) {
		AnsiConsole.err()
				   .print(Ansi.ansi().fg(Ansi.Color.WHITE).a("["));

		switch(diag.level()) {
			case Error:
				AnsiConsole.err()
						.print(Ansi.ansi().fgRed().a(" ERROR "));
				break;
			case Warning:
				AnsiConsole.err()
						   .print(Ansi.ansi().fgYellow().a("WARNING"));
				break;
			case Info:
				AnsiConsole.err()
						   .print(Ansi.ansi().fgYellow().a(" INFO  "));
				break;
		}
		AnsiConsole.err()
 				   .print(Ansi.ansi().fg(Ansi.Color.WHITE).a("] "));
		AnsiConsole.err()
				   .print(Ansi.ansi().fg(Ansi.Color.YELLOW).a(diag.context()));
		AnsiConsole.err()
				   .print(Ansi.ansi().reset());
		System.err.println(": " +  diag.message());
	}
}

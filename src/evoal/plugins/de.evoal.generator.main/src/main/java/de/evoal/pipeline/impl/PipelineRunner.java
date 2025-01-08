package de.evoal.pipeline.impl;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.languages.model.pipeline.PipelineModule;
import de.evoal.pipeline.api.board.PipelineBlackboardEntries;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.pipeline.api.cdi.GeneratorModuleLoader;
import de.evoal.pipeline.api.cdi.PipelineCollector;
import de.evoal.pipeline.impl.internal.DSLConverter;
import de.evoal.pipeline.impl.internal.DynamicEClassProvider;
import de.evoal.pipeline.impl.internal.StatementExecutor;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Main class for EvoAl's data generator.
 */
@ApplicationScoped
@Application(
		name = "de.evoal.pipeline.pipeline-runner",
		documentation = """
Application for running a data pipeline. Pipelines can be used to generate
training data, pre-process real-world training data, or to predict data using
a learned model.
"""
)
@Named("de.evoal.pipeline.pipeline-runner")
public class PipelineRunner implements MainClass {

	/**
	 * Logger instance
	 */
	private final static Logger log = LoggerFactory.getLogger(PipelineRunner.class);

	@Inject
	@BlackboardValue(PipelineBlackboardEntries.PIPELINE_CONFIGURATION_FILE)
	private String configurationFilename;

	@Inject
	private GeneratorModuleLoader loader;

	@Inject
	private DefinitionModuleLoader definitionLoader;


	@Inject
	private PipelineCollector converter;

	private static final Collector<PipelineDefinition, ?, Map<String, PipelineDefinition>> toMap =
			Collectors.toUnmodifiableMap(PipelineDefinition::getName,
					Function.identity());


	@Override
	public void run() {
		final GeneratorModule module = loader.load(configurationFilename);

		log.info("Executing model-to-model transformation on DSLs");
		final DynamicEClassProvider provider = new DynamicEClassProvider();
		final EClass space = provider.eClassFor(module);
		final DSLConverter converter = new DSLConverter(space);
		final PipelineModule pModule = converter.convert(module);

		log.info("Starting pipeline.");

		final Map<String, PipelineDefinition> pipelineTable = pModule
				.getPipelines()
				.stream()
				.collect(toMap);

		new StatementExecutor(definitionLoader, pipelineTable, space)
				.execute(pModule.getStatements());

		log.info("Finished pipeline.");
	}
}

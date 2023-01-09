package de.evoal.generator.main;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.*;
import de.evoal.generator.main.generators.GeneratorFactory;
import de.evoal.generator.main.internal.Pipeline;
import de.evoal.generator.main.internal.StatementExecutor;
import de.evoal.languages.model.generator.Configuration;
import de.evoal.languages.model.generator.PipelineDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for EvoAl's data generator.
 */
@ApplicationScoped
@Named("data-generator")
public class DataGenerator implements MainClass {

	/**
	 * Logger instance
	 */
	private final static Logger log = LoggerFactory.getLogger(DataGenerator.class);

	@Inject
	@BlackboardValue(GeneratorBlackboardEntry.GENERATOR_CONFIGURATION)
	private Configuration configuration;

	@Inject
	private GeneratorFactory factory;

	@Override
	public void run() {
		log.info("Starting data generation.");

		final Map<String, Pipeline> pipelineTable = createPipelines();

		new StatementExecutor(pipelineTable)
				.execute(configuration.getStatements());

		log.info("Finished data generation.");
	}

	private Map<String, Pipeline> createPipelines() {
		final Map<String, Pipeline> result = new HashMap<>();

		for(final PipelineDefinition definition : configuration.getPipelines()) {
			final String pipelineName = definition.getName();

			log.info("Creating pipeline '{}'.", pipelineName);

			final Pipeline pipeline = new Pipeline(pipelineName,
												   definition.getSteps()
															 .stream()
															 .map(f -> {
																 try {
																	 return factory.create(f);
																 } catch(final InitializationException e) {
																	 log.error("Failed to initialize generator function:", e);
																	 throw new RuntimeException("Failed to initialize generator function.", e);
																 }
															 })
															 .collect(Collectors.toList()));

			result.put(pipelineName, pipeline);
		}

		return result;
	}
}

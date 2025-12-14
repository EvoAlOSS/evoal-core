package de.evoal.pipeline.impl;

import de.evoal.core.api.ecore.Space;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;

import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.pipeline.PipelineModule;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.interpreter.ProgramInterpreter;
import de.evoal.pipeline.api.board.PipelineBlackboardEntries;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.pipeline.api.cdi.GeneratorModuleLoader;
import de.evoal.pipeline.api.cdi.PipelineCollector;
import de.evoal.pipeline.impl.internal.GeneratorDSLConverter;

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
@Slf4j
public class PipelineRunner implements MainClass {

	/**
	 * Name of the pipeline configuration.
	 */
	@Inject
	@BlackboardValue(PipelineBlackboardEntries.PIPELINE_CONFIGURATION_FILE)
	private String configurationFilename;

	/**
	 * For collecting and converting  the pipelines.
	 */
	@Inject
	private PipelineCollector converter;

	/**
	 * For loading definition files.
	 */
	@Inject
	private DefinitionModuleLoader definitionLoader;

	/**
	 * For loading generator modules.
	 */
	@Inject
	private GeneratorModuleLoader loader;

	@Override
	public void run() {
		log.info("Loading generator module from '{}'.", configurationFilename);
		final GeneratorModule module = loader.load(configurationFilename);

		log.info("Generating dynamic EClass for model.");
		final EClassProvider provider = new EClassProvider();
		final EClass dynamicEClass = provider.eClassFor(module);
		final Space space = new Space(dynamicEClass);

		log.info("Executing model-to-model on generator model.");
		final GeneratorDSLConverter converter = new GeneratorDSLConverter(definitionLoader, space);
		final PipelineModule pModule = converter.convert(module);

		log.info("Running pipeline.");
		new ProgramInterpreter()
				.execute(pModule.getProgram(), space);
        log.info("Finished pipeline.");
	}
}

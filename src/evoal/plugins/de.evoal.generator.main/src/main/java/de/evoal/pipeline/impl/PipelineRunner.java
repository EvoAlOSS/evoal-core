package de.evoal.pipeline.impl;

import de.evoal.models.core.ecore.Space;
import de.evoal.pipeline.impl.internal.GeneratorModelTransformer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClass;

import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.models.v202704.pipeline.PipelineModule;
import de.evoal.models.v202704.pipeline.PipelinePackage;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.execution.ExecutionPackage;
import org.eclipse.emf.ecore.EPackage;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.interpreter.ProgramInterpreter;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.literature.ConfigurationLiterature;
import de.evoal.core.api.provenance.RunRecord;
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
		name = PipelineRunner.NAME,
		documentation = """
Application for running a data pipeline. Pipelines can be used to generate
training data, pre-process real-world training data, or to predict data using
a learned model.
"""
)
@Named(PipelineRunner.NAME)
@Slf4j
public class PipelineRunner implements MainClass {
	/**
	 * The name of the application, the value of {@code -Bcore:main}.
	 */
	public static final String NAME = "de.evoal.pipeline.pipeline-runner";

	/**
	 * The packages of the pipeline runtime model that the literature walker enters: the
	 *   pipelines are variables of the program, and calls refer to them in expressions.
	 */
	private static final Set<EPackage> PIPELINE_MODEL = Set.of(PipelinePackage.eINSTANCE, ExecutionPackage.eINSTANCE,
	                                                              ExpressionsPackage.eINSTANCE);


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

	@Inject
	private GeneratorModelTransformer transformer;

	/**
	 * Reads the attributes of the configurations for their literature.
	 */
	@Inject
	private AttributeEvaluator evaluator;

	@Override
	public void run() {
		log.info("Loading generator module from '{}'.", configurationFilename);
		final GeneratorModule module = loader.load(configurationFilename);

		log.info("Generating dynamic EClass for model.");
		final EClassProvider provider = new EClassProvider();
		final EClass dynamicEClass = provider.eClassFor(module);
		final Space space = new Space(dynamicEClass);

		log.info("Executing model-to-model on generator model.");
		final PipelineModule pModule = transformer.transform(module, space);

		writeLiterature(pModule);

		log.info("Running pipeline.");
		new ProgramInterpreter()
				.execute(pModule.getProgram(), space);
        log.info("Finished pipeline.");
	}

	/**
	 * Names the folder of the run's provenance ({@code provenance/<configuration file>} in the
	 *   execution folder) and writes the literature of the pipelines into it.
	 */
	private void writeLiterature(final PipelineModule pModule) {
		final Path folder = Path.of(RunRecord.FOLDER, Path.of(configurationFilename).getFileName().toString());
		RunRecord.current().setFolder(folder);

		try {
			final ConfigurationLiterature literature = ConfigurationLiterature.of(evaluator, PIPELINE_MODEL);
			ConfigurationLiterature.citationsOf(literature.definitions(pModule))
								   .write(folder);
		} catch(final IOException e) {
			log.error("Failed to write the literature of the pipelines to '{}'.", folder, e);
		}
	}
}

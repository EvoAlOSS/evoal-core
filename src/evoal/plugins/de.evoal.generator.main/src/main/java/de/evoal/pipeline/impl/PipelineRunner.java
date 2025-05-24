package de.evoal.pipeline.impl;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.interpreter.api.ProgramInterpreter;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.languages.model.execution.Variable;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.pipeline.PipelineModule;
import de.evoal.pipeline.api.board.PipelineBlackboardEntries;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.pipeline.api.cdi.GeneratorModuleLoader;
import de.evoal.pipeline.api.cdi.PipelineCollector;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.pipeline.impl.internal.GeneratorDSLConverter;
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

	private static final Collector<NamedVariable, ?, Map<Variable, Object>> toMap =
			Collectors.toUnmodifiableMap(Function.identity(),
					Function.identity());


	@Override
	public void run() {
		final GeneratorModule module = loader.load(configurationFilename);

		log.info("Executing model-to-model transformation on DSLs");
		final EClassProvider provider = new EClassProvider();
		final EClass space = provider.eClassFor(module);
		final GeneratorDSLConverter converter = new GeneratorDSLConverter(definitionLoader, space);
		final PipelineModule pModule = converter.convert(module);


		log.info("Starting pipeline.");
		new ProgramInterpreter()
				.execute(pModule.getProgram(), space);
        log.info("Finished pipeline.");
	}
}

package de.evoal.surrogate.main.pipeline;

import jakarta.inject.Inject;

import de.evoal.surrogate.main.literature.SurrogateLiterature;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.cdi.EvoalBuiltinFunction;
import de.evoal.languages.model.mll.TaskDescription;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.io.ModelWriter;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Stores the trained model with its prediction pipeline and its goodness-of-fit values
 *   (one parameter per measure, with the value of each data set), and writes the
 *   goodness-of-fit file if the learning task names one
 *   ({@code serialise to "model.pson" and "gof.json"}). Storing again, e.g. after testing,
 *   writes the files again with all values recorded so far.
 */
@Dependent
@Named("de.evoal.surrogate.pipeline.store-model")
@Slf4j
public class StoreModelFunction implements EvoalBuiltinFunction {
	/**
	 * The DL types of the training, which the model file records.
	 */
	@Inject
	private SurrogateLiterature literature;

	/**
	 * Creates the function; the literature is injected.
	 */
	public StoreModelFunction() {
	}

	/**
	 * Creates the function with the given literature, e.g., for tests.
	 */
	StoreModelFunction(final SurrogateLiterature literature) {
		this.literature = literature;
	}

	@Override
	public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
		final ModelFunctionData memento = (ModelFunctionData) context.getByName("model-function");
		final TaskDescription task = (TaskDescription) context.getByName("learning-task");
		final PipelineDefinition def = (PipelineDefinition) context.getByName("predicting");
		final GoodnessOfFit goodnessOfFit = GoodnessOfFit.of(context);

		final ModelWriter writer = memento.writer().get();
		addGoodnessOfFit(writer, goodnessOfFit);

		writer.addTrainingDefinitions(literature.trainingDefinitions())
			  .addPredictionPipeline(def)
			  .store(memento.function());

		if(task.getGofFile() != null) {
			writeGoodnessOfFitFile(new File(task.getGofFile()), goodnessOfFit);
		}

		return Optional.empty();
	}

	private static void addGoodnessOfFit(final ModelWriter writer, final GoodnessOfFit goodnessOfFit) {
		for(final Map.Entry<EStructuralFeature, Map<String, Map<String, Double>>> feature : goodnessOfFit.values().entrySet()) {
			for(final Map.Entry<String, Map<String, Double>> measure : feature.getValue().entrySet()) {
				final Parameter parameter = Parameter.builder()
						.name(measure.getKey())
						.value(new LinkedHashMap<>(measure.getValue()))
						.build();

				writer.addOutputFeatureInformation(feature.getKey(), parameter);
			}
		}
	}

	/**
	 * Writes the goodness-of-fit values as JSON: output feature → measure → data set → value.
	 *
	 * @param file The file to write.
	 * @param goodnessOfFit The values to write.
	 */
	static void writeGoodnessOfFitFile(final File file, final GoodnessOfFit goodnessOfFit) {
		log.info("Writing goodness-of-fit values to '{}'.", file);

		final Map<String, Map<String, Map<String, Double>>> content = new LinkedHashMap<>();
		goodnessOfFit.values()
					 .forEach((feature, measures) -> content.put(feature.getName(), measures));

		final File parent = file.getAbsoluteFile().getParentFile();
		if(parent != null) {
			parent.mkdirs();
		}

		final ObjectMapper mapper = JsonMapper.builder()
											  .enable(SerializationFeature.INDENT_OUTPUT)
											  .build();
		mapper.writeValue(file, content);
	}
}

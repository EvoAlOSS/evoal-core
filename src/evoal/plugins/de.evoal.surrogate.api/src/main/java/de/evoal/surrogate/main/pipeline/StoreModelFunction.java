package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.cdi.EvoalBuiltinFunction;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.surrogate.api.function.ModelFunctionData;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.Optional;

/**
 * Calculates cross validation values.
 */
@Dependent
@Named("de.evoal.surrogate.pipeline.store-model")
@Slf4j
public class StoreModelFunction implements EvoalBuiltinFunction {
	@Override
	public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
		final ModelFunctionData memento = (ModelFunctionData) context.getByName("model-function");

		final PipelineDefinition def = (PipelineDefinition) context.getByName("predicting");

		memento.writer()
			   .get()
			   .addPredictionPipeline(def)
			   .store(memento.function());

		return Optional.empty();
	}
}

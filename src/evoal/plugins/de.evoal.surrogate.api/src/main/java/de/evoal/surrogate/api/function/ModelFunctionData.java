package de.evoal.surrogate.api.function;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.ModelWriter;
import lombok.NonNull;

import java.util.Optional;

/**
 * A model function with its reader, its writer and its executable prediction pipeline.
 *
 * @param function The model function.
 * @param reader Reads the information stored with the model.
 * @param writer Writes the model and its information.
 * @param pipeline The prediction pipeline that every prediction runs.
 */
public record ModelFunctionData(ModelFunction function, Optional<ModelReader> reader, Optional<ModelWriter> writer, PredictionPipeline pipeline) {
    /**
     * Creates the data of a model without stored prediction pipeline: it predicts with the
     *   model function only.
     */
    public ModelFunctionData(final ModelFunction function, final Optional<ModelReader> reader, final Optional<ModelWriter> writer) {
        this(function, reader, writer, PredictionPipeline.implicit(function));
    }

    /**
     * @param pipeline The executable prediction pipeline.
     * @return The same model with the given pipeline.
     */
    public ModelFunctionData withPipeline(final @NonNull PredictionPipeline pipeline) {
        return new ModelFunctionData(function, reader, writer, pipeline);
    }

    /**
     * Predicts through the prediction pipeline, see {@link PredictionPipeline#predict}.
     *
     * @param input An object with the input features of the model.
     * @param output The object that receives the output features of the model.
     */
    public void predict(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
        pipeline.predict(input, output);
    }
}

package de.evoal.surrogate.api.function;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.models.core.ecore.Space;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.ModelStorageFactory;
import de.evoal.surrogate.api.io.ModelWriter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Factory for creating for model readers, and writers. The reader and writer of a model type
 *   for a format are the beans {@code <model>-reader-<extension>} and
 *   {@code <model>-writer-<extension>}.
 */
@ApplicationScoped
@Slf4j
public class ModelFunctionFactory {
    private static final String READER = "-reader-";

    private static final String WRITER = "-writer-";

    @Inject
    private ModelStorageFactory factory;

    private Optional<ModelReader> reader(final ModelStorage storage, final String modelName) {
        final String name = modelName + READER + storage.getStorageExtension();

        log.info("Looking up model function reader '{}'.", name);
        final ModelReader reader = BeanFactory.create(name, ModelReader.class);
        reader.setStorage(storage);
        reader.setSpace(storage.getInputSpace(), storage.getOutputSpace());

        return Optional.of(reader);
    }

    private ModelWriter writer(final ModelStorage storage, final String modelName) {
        final String name = modelName + WRITER + storage.getStorageExtension();

        log.info("Looking up model function writer '{}'.", name);
        final ModelWriter writer = BeanFactory.create(name, ModelWriter.class);
        writer.setStorage(storage);

        return writer;
    }

    /**
     * @return The formats (file extensions) in which the model type can be stored, sorted.
     */
    public List<String> writableFormats(final @NonNull String modelName) {
        final String prefix = modelName + WRITER;

        return CDI.current()
                  .getBeanManager()
                  .getBeans(ModelWriter.class, Any.Literal.INSTANCE)
                  .stream()
                  .map(Bean::getName)
                  .filter(Objects::nonNull)
                  .filter(name -> name.startsWith(prefix))
                  .map(name -> name.substring(prefix.length()))
                  .distinct()
                  .sorted()
                  .toList();
    }

    /**
     * Checks that the model type can be stored in the format.
     *
     * @param modelName The model type, i.e. its DL type.
     * @param extension The file extension of the format.
     * @throws IllegalStateException with the formats of the model type if it has no writer for
     *   the format.
     */
    public void requireWriter(final @NonNull String modelName, final @NonNull String extension) {
        requireFormat(modelName, extension, writableFormats(modelName));
    }

    /**
     * @throws IllegalStateException with the formats of the model type if the format is not one
     *   of them.
     */
    static void requireFormat(final String modelName, final String extension, final List<String> formats) {
        if(!formats.contains(extension)) {
            throw new IllegalStateException("The model type '" + modelName + "' cannot be stored as '." + extension + "'; it supports: "
                    + (formats.isEmpty() ? "no format" : String.join(", ", formats)) + ".");
        }
    }

    private ModelFunctionData create(final ModelStorage storage, final ModelFunction function) {
        final String modelName = function.getModelName();
        requireWriter(modelName, storage.getStorageExtension());

        final Optional<ModelReader> reader = reader(storage, modelName);
        final Optional<ModelWriter> writer = Optional.of(writer(storage, modelName));

        return new ModelFunctionData(function, reader, writer);
    }

    public ModelFunctionData create(final URI location, final ModelFunction function) {
        final ModelStorage storage = factory.create(location, function.input, function.output);

        return create(storage, function);
    }

    /**
     * Loads the model of a storage. The writer is only looked up if the model type has one for
     *   the format; a loaded model is not stored again, and a foreign ONNX model has none.
     */
    private ModelFunctionData load(final ModelStorage storage) {
        final String modelName = storage.getModelName();
        final Optional<ModelReader> reader = reader(storage, modelName);
        final Optional<ModelWriter> writer = writableFormats(modelName).contains(storage.getStorageExtension())
                                             ? Optional.of(writer(storage, modelName))
                                             : Optional.empty();

        final ModelFunction function = reader.get().load();
        final ModelFunctionData data = new ModelFunctionData(function, reader, writer);

        return storage.getPredictionPipeline()
                      .map(pipeline -> data.withPipeline(PredictionPipeline.of(pipeline, storage.getPipelineSpace(), function)))
                      .orElse(data);
    }

    public ModelFunctionData load(final URI location, final Space inputSpace, final Space outputSpace) {
        final ModelStorage storage = factory.create(location, inputSpace, outputSpace);

        return load(storage);
    }
}

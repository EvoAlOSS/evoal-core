package de.evoal.surrogate.api.function;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.ModelStorageFactory;
import de.evoal.surrogate.api.io.ModelWriter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URI;
import java.util.Optional;

/**
 * Factory for creating for model readers, and writers.
 */
@ApplicationScoped
@Slf4j
public class ModelFunctionFactory {
    @Inject
    private ModelStorageFactory factory;

    private Optional<ModelReader> reader(final ModelStorage storage, final String modelName) {
        final String name = modelName + "-reader-" + storage.getStorageExtension();

        log.info("Looking up model function reader '{}'.", name);
        final ModelReader reader = BeanFactory.create(name, ModelReader.class);
        reader.setStorage(storage);
        reader.setSpace(storage.getInputSpace(), storage.getOutputSpace());

        return Optional.of(reader);
    }

    private Optional<ModelWriter> writer(final ModelStorage storage, final String modelName) {
        final String name = modelName + "-writer-" + storage.getStorageExtension();

        log.info("Looking up model function writer '{}'.", name);
        final ModelWriter writer = BeanFactory.create(name, ModelWriter.class);
        writer.setStorage(storage);

        return Optional.of(writer);
    }

    private ModelFunctionData create(final ModelStorage storage, final ModelFunction function) {
        final String modelName = function.getModelName();

        final Optional<ModelReader> reader = reader(storage, modelName);
        final Optional<ModelWriter> writer = writer(storage, modelName);

        return new ModelFunctionData(function, reader, writer);
    }

    public ModelFunctionData create(final URI location, final ModelFunction function) {
        final ModelStorage storage = factory.create(location, function.input, function.output);

        return create(storage, function);
    }

    private ModelFunctionData load(final ModelStorage storage) {
        final Optional<ModelReader> reader = reader(storage, storage.getModelName());
        final Optional<ModelWriter> writer = writer(storage, storage.getModelName());

        return new ModelFunctionData(reader.get().load(), reader, writer);
    }

    public ModelFunctionData load(final URI location, final Space inputSpace, final Space outputSpace) {
        final ModelStorage storage = factory.create(location, inputSpace, outputSpace);

        return load(storage);
    }
}

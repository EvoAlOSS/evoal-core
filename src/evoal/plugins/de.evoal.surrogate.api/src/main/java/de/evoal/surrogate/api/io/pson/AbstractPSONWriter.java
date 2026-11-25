package de.evoal.surrogate.api.io.pson;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.AbstractModelWriter;
import de.evoal.surrogate.api.io.ModelStorage;
import lombok.NonNull;

/**
 * Base of the writers of PSON model files: the file is the configuration of the model with its
 *   state, which the subclass adds.
 */
public abstract class AbstractPSONWriter extends AbstractModelWriter {
    private PSONModelStorage storage;

    @Override
    public void store(final ModelFunction function) {
        final SurrogateConfiguration configuration = configurationOf(function);

        toConfiguration(function, configuration);

        storage.store(configuration);
    }

    protected abstract void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration);

    @Override
    public void setStorage(final @NonNull ModelStorage storage) {
        this.storage = (PSONModelStorage) storage;
    }
}

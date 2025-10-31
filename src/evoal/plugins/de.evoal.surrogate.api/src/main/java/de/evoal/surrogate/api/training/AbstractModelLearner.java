package de.evoal.surrogate.api.training;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.ModelStorageFactory;
import de.evoal.surrogate.api.io.ModelWriter;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.net.URI;
import java.util.Map;

/**
 * Abstract base implementation of model learners.
 */
@Slf4j
public abstract class AbstractModelLearner implements ModelLearner {
    /**
     * The input features of the model.
     */
    @Getter
    protected Space inputFeatures;

    @Inject
    private ModelStorageFactory factory;

    /**
     * The output features of the model.
     */
    @Getter
    protected Space outputFeatures;

    @Getter
    private ModelWriter writer;

    @Override
    public void setFeatureSpaces(final Space inputFeatures, final Space outputFeatures) {
        this.inputFeatures = inputFeatures;
        this.outputFeatures = outputFeatures;
    }
}

package de.evoal.surrogate.api.io.onnx;

import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.Space;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.pson.Parameter;

/**
 * Base of the readers of ONNX model files. The model runs in ONNX Runtime; the feature
 *   information comes from the model information of the file. The reader of a model type
 *   (named {@code <model>-reader-onnx}) usually needs no code of its own.
 * <p>
 * The reader implements the raw {@link ModelReader}: the readers are looked up by name as raw
 *   {@code ModelReader}, and CDI does not find a bean whose type has concrete type arguments.
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractONNXReader implements ModelReader {
    /**
     * The input space.
     */
    @Getter
    private Space input;

    /**
     * The output space.
     */
    @Getter
    private Space output;

    /**
     * The storage to load data from.
     */
    protected ONNXModelStorage storage;

    @Override
    public void setSpace(final @NonNull Space input, final @NonNull Space output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void setStorage(final @NonNull ModelStorage storage) {
        this.storage = (ONNXModelStorage) storage;
    }

    @Override
    public Collection<Parameter> getOutputFeatureInformation(final EStructuralFeature feature) {
        return storage.getOutputParameters().getOrDefault(feature.getName(), List.of());
    }

    @Override
    public Collection<Parameter> getInputFeatureInformation(final EStructuralFeature feature) {
        return storage.getInputParameters().getOrDefault(feature.getName(), List.of());
    }

    @Override
    public @NonNull ONNXFunction load() {
        storage.load();

        return createFunction(storage);
    }

    /**
     * @return The function of the loaded model, with the name of the model information.
     */
    protected ONNXFunction createFunction(final ONNXModelStorage storage) {
        return new ONNXFunction(storage.getModelName(), getInput(), getOutput(), storage.getSession().orElseThrow());
    }
}

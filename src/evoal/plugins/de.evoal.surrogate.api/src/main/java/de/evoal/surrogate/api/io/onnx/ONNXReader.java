package de.evoal.surrogate.api.io.onnx;

import ai.onnxruntime.OrtSession;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.pson.Parameter;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.function.ModelFunction;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.List;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Named("de.evoal.surrogate.api.ml.general-onnx-reader-onnx")
@Dependent
@Slf4j
public class ONNXReader implements ModelReader {

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
    @Setter
    protected ONNXModelStorage storage;

    @Override
    public void setSpace(final @NonNull Space input, final @NonNull Space output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void setStorage(@NonNull ModelStorage storage) {this.storage = (ONNXModelStorage) storage;}

    @Override
    public Space getInput() {
        return input;
    }

    @Override
    public Space getOutput() {
        return output;
    }

    @Override
    public Collection<Parameter> getOutputFeatureInformation(EStructuralFeature feature) {
        return List.of();
    }

    @SneakyThrows
    @Override
    public @NonNull ModelFunction load() {
        storage.load();
        ONNXModelStorage onnxStore=(ONNXModelStorage) storage;
        OrtSession session = onnxStore.getSession().get();
        log.info("Load - Input:{}, Output:{}",getInput().getEClass().getName(),getOutput().getEClass().getName());
        log.info("Load - Input:{}, Output:{}",getInput(),getOutput());
        return new ONNXFunction(getInput(), getOutput(),session);

    }
}

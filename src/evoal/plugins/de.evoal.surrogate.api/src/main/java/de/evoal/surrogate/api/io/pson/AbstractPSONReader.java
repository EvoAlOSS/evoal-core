package de.evoal.surrogate.api.io.pson;

import de.evoal.models.core.ecore.Space;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.ModelReader;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.List;

public abstract class AbstractPSONReader<F extends ModelFunction, T extends PSONModelStorage> implements ModelReader<F, T> {
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
    protected T storage;

    @Override
    public void setSpace(final @NonNull Space input, final @NonNull Space output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public Collection<Parameter> getOutputFeatureInformation(final EStructuralFeature feature) {
        return storage.getConfiguration()
                .get()
                .getOutputParameters()
                .get(feature.getName());
    }

    @Override
    public Collection<Parameter> getInputFeatureInformation(final EStructuralFeature feature) {
        return storage.getConfiguration()
                .get()
                .getInputParameters()
                .getOrDefault(feature.getName(), List.of());
    }
}

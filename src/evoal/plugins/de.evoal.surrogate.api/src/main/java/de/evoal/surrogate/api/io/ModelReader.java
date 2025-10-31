package de.evoal.surrogate.api.io;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.ModelLearner;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *     A model reader is an adapter that loads a serialised trained model from  a storage
 *     location. Since the storage locations use different strategies each model has to
 *     provide a custom erader for each supported {@link ModelStorage}.
 *  </p>
 *
 * @param <F> The concrete model function.
 * @param <T> The concrete storage type supported.
 */
public interface ModelReader<F extends ModelFunction, T extends ModelStorage> {
    /**
     * @return The configured input space.
     */
    Space getInput();

    /**
     * @return The configured output space.
     */
    Space getOutput();

    /**
     * Loads and returns the output feature information for a given feature.
     * @param feature The feature for which the output information are requested
     * @return Output feature information for the given feature.
     */
    Collection<Parameter> getOutputFeatureInformation(final EStructuralFeature feature);

    /**
     * Sets the input and output space of the function to read.
     */
    void setSpace(final @NonNull Space input, final @NonNull Space output);

    /**
     * Sets the actual storage to use.
     *
     * @param storage The storage to be used.
     */
    void setStorage(final @NonNull T storage);

    /**
     * Loads the model and returns the model function..
     */
    @NonNull F load();
}

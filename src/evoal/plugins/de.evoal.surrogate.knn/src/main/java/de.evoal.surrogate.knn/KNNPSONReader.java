package de.evoal.surrogate.knn;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.AbstractPSONReader;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Named("de.evoal.surrogate.knn.ml.knn-reader-pson")
@Dependent
@Slf4j
public class KNNPSONReader extends AbstractPSONReader {
    public static final String PARAMETER_TRAINING = "training";

    @Override
    public @NonNull ModelFunction load() {
        final SurrogateConfiguration configuration = storage
                .getConfiguration()
                .get();

        final int k = (int)configuration.getState()
                        .stream()
                        .filter(p -> KNNLerner.PARAMETER_K.equals(p.getName()))
                        .map(Parameter::getValue)
                        .findFirst()
                        .get();

        // TODO Perhaps, we should store the training data along-side the model.
        //  Currently, we are it storing multiple times.
        final List<EObjectPair> training = (List<EObjectPair>) configuration.getState()
                        .stream()
                        .filter(p -> KNNPSONReader.PARAMETER_TRAINING.equals(p.getName()))
                        .map(Parameter::getValue)
                        .findFirst()
                        .get();


        final EObjectPairStreamSupplier pairSupplier = EObjectPairStreamFactory.createFromList(getInput(), getOutput(), training);

        return new KNNFunction(getInput(), getOutput(), pairSupplier, k);
    }
}

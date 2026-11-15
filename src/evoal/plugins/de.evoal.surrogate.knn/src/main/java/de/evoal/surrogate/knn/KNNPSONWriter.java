package de.evoal.surrogate.knn;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Dependent
@Named("de.evoal.surrogate.knn.ml.knn-writer-pson")
@Slf4j
public class KNNPSONWriter extends AbstractPSONWriter {
    @Override
    protected void toConfiguration(@NonNull ModelFunction function, @NonNull SurrogateConfiguration configuration) {
        final KNNFunction knnFunction = (KNNFunction) function;

        final List<Parameter> parameters = new ArrayList<>();

        parameters.add(new Parameter(KNNLerner.PARAMETER_K, knnFunction.getK()));
        parameters.add(new Parameter(KNNPSONReader.PARAMETER_TRAINING, knnFunction.getTrainingDataSupplier().get().toList()));

        configuration.getState()
                .addAll(parameters);
    }
}

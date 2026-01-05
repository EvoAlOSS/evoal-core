package de.evoal.surrogate.smile.gaussian;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.smile.KernelFactory;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Writer for the gaussian process surrogate model.
 */
@Named("de.evoal.surrogate.smile.ml.gaussian-process-writer-pson")
@Dependent
@Slf4j
public class GaussianProcessPSONWriter extends AbstractPSONWriter {

    @Override
    protected void toConfiguration(@NonNull ModelFunction function, @NonNull SurrogateConfiguration configuration) {
        final GaussianProcessFunction process = (GaussianProcessFunction) function;

        final Map<String, Object> modelConfiguration = new HashMap<>();
        modelConfiguration.put("parameters", process.getParameters());
        modelConfiguration.put("regression", KernelFactory.toConfiguration(process.getRegression()));

        configuration.getState()
                .add(Parameter.builder().name("model").value(modelConfiguration).build());
    }
}

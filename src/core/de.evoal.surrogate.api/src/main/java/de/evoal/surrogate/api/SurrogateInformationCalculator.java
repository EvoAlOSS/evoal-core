package de.evoal.surrogate.api;

import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;

import java.util.List;

/**
 * Calculates information on the calculated surrogate, such as cross validation
 *   values, goodness of fit, and so on.
 */
public interface SurrogateInformationCalculator {
    /**
     * Configures the calculator with the given parameters.
     *
     * @param function
     * @param config
     * @param parameters
     */
    void configure(final SurrogateFunction function, final SurrogateConfiguration config, final List<Object> parameters, final PropertiesStreamSupplier trainingData);

    /**
     * Executes the calculation.
     */
    void execute();
}

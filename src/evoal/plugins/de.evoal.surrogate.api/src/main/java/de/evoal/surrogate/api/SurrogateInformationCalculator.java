package de.evoal.surrogate.api;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.interpreter.api.cdi.EvoalBuiltinFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;

import java.util.List;

/**
 * Calculates information on the calculated surrogate, such as cross validation
 *   values, goodness of fit, and so on.
 */
public interface SurrogateInformationCalculator extends EvoalBuiltinFunction<SurrogateInformationCalculator> {
    /**
     * Configures the calculator with the given parameters.
     *
     * @param function The trained surrogate function.
     * @param config The configuration of the surrogate function.
     * @param trainingData The data used to train the surrogate function
     */
    void configure(final SurrogateFunction function, final SurrogateConfiguration config, final EObjectPairStreamSupplier trainingData);
}

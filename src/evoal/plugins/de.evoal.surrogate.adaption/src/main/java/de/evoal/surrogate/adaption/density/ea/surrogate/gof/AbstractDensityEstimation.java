package de.evoal.surrogate.adaption.density.ea.surrogate.gof;

import java.util.Optional;
import java.util.function.Function;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.surrogate.adaption.density.model.DensityData;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.SurrogateFunction;

public abstract class AbstractDensityEstimation implements SurrogateInformationCalculator {
    /**
     * The used smoothing value -> configuration value.
     */
    protected double bandwidth = 1.0;

    protected SurrogateConfiguration configuration;

    /**
     * Used during calculation for storing the properties specification of the handled function.
     */
    protected Space sourcePropertiesSpec = null;

    /**
     * Used during calculation for storing the properties specification of the handled function.
     */
    protected Space targetPropertiesSpec = null;

    protected EObjectPairStreamSupplier trainingData;

    protected abstract DensityData calculateDensityData(final Function<EObjectPair, Double> mapper);

    @Override
    public void configure(final SurrogateFunction function, final SurrogateConfiguration config, final EObjectPairStreamSupplier trainingData) {
        this.trainingData = trainingData;
        this.configuration = config;
    }

    @Override
    public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
        Requirements.requireSize(arguments, 1);

        bandwidth = (Double)arguments[0];

        for(final PartialFunctionConfiguration fc : configuration.getFunctions()) {
            // create properties specification for the configuration
            sourcePropertiesSpec = fc.getInputData();
            targetPropertiesSpec = fc.getOutputData();

            for(final EStructuralFeature feature : sourcePropertiesSpec) {
                final Function<EObjectPair, Double> mapper = pair -> pair.getFirst().eGetAsDouble(feature);

                calculateDensityData(mapper).attachTo(fc, feature.getName());
            }

            for(final EStructuralFeature feature : targetPropertiesSpec) {
                final Function<EObjectPair, Double> mapper = pair -> pair.getSecond().eGetAsDouble(feature);

                calculateDensityData(mapper).attachTo(fc, feature.getName());
            }
        }

        sourcePropertiesSpec = null;
        targetPropertiesSpec = null;

        return Optional.empty();
    }
}

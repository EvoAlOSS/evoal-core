package de.evoal.surrogate.adaption.density.ea.surrogate.gof;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.surrogate.adaption.density.model.DensityData;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class AbstractDensityEstimation extends SurrogateInformationCalculator {
    /**
     * The used smoothing value -> configuration value.
     */
    protected double bandwidth = 1.0;

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
    public Optional<Object> calculate(final InterpreterState context, final Object[] arguments) {
        Requirements.requireSize(arguments, 1);

        trainingData = helper.loadTrainingDataPaired(context);

        bandwidth = (Double)arguments[0];

        final ModelFunction function = functionData.function();

        sourcePropertiesSpec = function.getInput();
        targetPropertiesSpec = function.getOutput();

        for(final EStructuralFeature feature : sourcePropertiesSpec) {
            final Function<EObjectPair, Double> mapper = pair -> pair.getFirst().eGetAsDouble(feature);
            final Consumer<Parameter> parameterAppender =
                    p -> functionData.writer()
                             .get()
                             .addInputFeatureInformation(feature, p);

            calculateDensityData(mapper)
                    .attachTo(parameterAppender);
        }

        for(final EStructuralFeature feature : targetPropertiesSpec) {
            final Function<EObjectPair, Double> mapper = pair -> pair.getSecond().eGetAsDouble(feature);
            final Consumer<Parameter> parameterAppender =
                    p -> functionData.writer()
                            .get()
                            .addOutputFeatureInformation(feature, p);

            calculateDensityData(mapper)
                    .attachTo(parameterAppender);
        }

        sourcePropertiesSpec = null;
        targetPropertiesSpec = null;

        return Optional.empty();
    }
}

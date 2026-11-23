package de.evoal.surrogate.main.pipeline;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Arrays;
import java.util.List;

/**
 * Min-max normalisation (Han, Kamber and Pei 2012): maps each feature linearly from
 *   [minimum, maximum] to ['new-minimum', 'new-maximum']. A feature with minimum = maximum is
 *   only shifted (its range counts as 1).
 */
@Dependent
@Slf4j
@Named("de.evoal.surrogate.pipeline.min-max-normalisation")
public class MinMaxNormalisationComponent extends FittedPreparationComponent {
    private double newMinimum;

    private double newMaximum;

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        newMinimum = evaluator.attributeToDouble(configuration, "new-minimum");
        newMaximum = evaluator.attributeToDouble(configuration, "new-maximum");
        if(!(newMinimum < newMaximum)) {
            throw new InitializationException("'min-max-normalisation' needs 'new-minimum' < 'new-maximum', but has " + newMinimum + " and " + newMaximum + ".");
        }

        return this;
    }

    @Override
    protected List<String> parameterNames() {
        return List.of("minimum", "maximum");
    }

    @Override
    protected double[] fit(final @NonNull EStructuralFeature feature, final double @NonNull [] values) {
        final double minimum = Arrays.stream(values).min().orElse(0.0);
        final double maximum = Arrays.stream(values).max().orElse(0.0);
        if(minimum == maximum) {
            log.warn("'min-max-normalisation': '{}' is constant ({}) in the training data; it is only shifted.", feature.getName(), minimum);
        }

        return new double[] {minimum, maximum};
    }

    private static double range(final double @NonNull [] parameters) {
        final double range = parameters[1] - parameters[0];
        return range == 0.0 ? 1.0 : range;
    }

    @Override
    protected double transform(final double value, final double @NonNull [] parameters) {
        return (value - parameters[0]) / range(parameters) * (newMaximum - newMinimum) + newMinimum;
    }

    @Override
    protected double invert(final double value, final double @NonNull [] parameters) {
        return (value - newMinimum) / (newMaximum - newMinimum) * range(parameters) + parameters[0];
    }
}

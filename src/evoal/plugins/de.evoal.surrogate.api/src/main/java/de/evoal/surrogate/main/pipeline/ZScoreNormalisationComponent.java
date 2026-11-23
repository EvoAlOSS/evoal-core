package de.evoal.surrogate.main.pipeline;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Arrays;
import java.util.List;

/**
 * Z-score normalisation (Han, Kamber and Pei 2012): v' = (v - μ) / σ with the mean μ and the
 *   standard deviation σ (divided by n) of each feature. A feature with σ = 0 is only shifted
 *   (σ counts as 1).
 */
@Dependent
@Slf4j
@Named("de.evoal.surrogate.pipeline.z-score-normalisation")
public class ZScoreNormalisationComponent extends FittedPreparationComponent {
    @Override
    protected List<String> parameterNames() {
        return List.of("μ", "σ");
    }

    @Override
    protected double[] fit(final @NonNull EStructuralFeature feature, final double @NonNull [] values) {
        final double mean = Arrays.stream(values).average().orElse(0.0);
        final double variance = Arrays.stream(values)
                                      .map(v -> (v - mean) * (v - mean))
                                      .average()
                                      .orElse(0.0);
        final double deviation = Math.sqrt(variance);
        if(deviation == 0.0) {
            log.warn("'z-score-normalisation': '{}' is constant ({}) in the training data; it is only shifted.", feature.getName(), mean);
        }

        return new double[] {mean, deviation};
    }

    private static double deviation(final double @NonNull [] parameters) {
        return parameters[1] == 0.0 ? 1.0 : parameters[1];
    }

    @Override
    protected double transform(final double value, final double @NonNull [] parameters) {
        return (value - parameters[0]) / deviation(parameters);
    }

    @Override
    protected double invert(final double value, final double @NonNull [] parameters) {
        return value * deviation(parameters) + parameters[0];
    }
}

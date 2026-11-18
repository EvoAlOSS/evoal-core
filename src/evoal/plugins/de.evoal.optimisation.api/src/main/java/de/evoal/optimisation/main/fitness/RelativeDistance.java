package de.evoal.optimisation.main.fitness;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.fitness.TargetDistance;

/**
 * The relative distance {@code abs(v - t) / max(abs(t), scale)}. Below {@code abs(t) = scale},
 *   including a target of 0, the distance is measured absolutely in units of {@code scale}.
 */
@Dependent
@Named("de.evoal.optimisation.core.relative-distance")
public class RelativeDistance implements TargetDistance {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The smallest denominator, greater than 0.
     */
    private double scale;

    /**
     * Creates the distance without configuration. CDI uses it before {@link #init(EObject)}.
     */
    public RelativeDistance() {
    }

    /**
     * Creates the distance with the given scale.
     *
     * @param scale The smallest denominator.
     * @throws IllegalArgumentException if the scale is not greater than 0.
     */
    public RelativeDistance(final double scale) {
        this.scale = requirePositive(scale);
    }

    @Override
    public double distance(final double value, final double target) {
        final double deviation = Math.abs(value - target);
        final double denominator = Math.max(Math.abs(target), scale);

        return deviation / denominator;
    }

    @Override
    public RelativeDistance init(final EObject configuration) {
        final double configuredScale = evaluator.attributeToDouble(configuration, "scale");
        this.scale = requirePositive(configuredScale);

        return this;
    }

    private static double requirePositive(final double scale) {
        // also rejects NaN
        if(!(scale > 0.0)) {
            throw new IllegalArgumentException("The 'scale' of 'relative-distance' must be greater than 0, but is "
                                               + scale + ".");
        }

        return scale;
    }
}

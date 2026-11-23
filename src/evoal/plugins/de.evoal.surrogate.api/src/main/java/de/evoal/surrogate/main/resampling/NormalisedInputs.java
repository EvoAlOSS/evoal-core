package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.List;

/**
 * The input features of the rows, min-max normalised to [0, 1] on the rows, for dividing the
 *   input space into blocks independently of the units of the inputs. A feature whose values
 *   are all equal is 0 in every row.
 */
final class NormalisedInputs {
    private NormalisedInputs() {
    }

    /**
     * @param rows The rows.
     * @param features The input features, at least one.
     * @return One array per row with one value per feature, in the order of the features.
     */
    static double[][] of(final List<TypedEObject> rows, final List<EStructuralFeature> features) {
        if(features.isEmpty()) {
            throw new IllegalArgumentException("Dividing the input space into blocks needs at least one input feature.");
        }

        final int d = features.size();
        final double[][] points = new double[rows.size()][d];
        for(int f = 0; f < d; ++f) {
            final EStructuralFeature feature = features.get(f);

            double minimum = Double.POSITIVE_INFINITY;
            double maximum = Double.NEGATIVE_INFINITY;
            for(int i = 0; i < rows.size(); ++i) {
                final double value = rows.get(i).eGetAsDouble(feature);
                points[i][f] = value;
                minimum = Math.min(minimum, value);
                maximum = Math.max(maximum, value);
            }

            final double range = maximum - minimum;
            for(final double[] point : points) {
                point[f] = range > 0 ? (point[f] - minimum) / range : 0.0;
            }
        }

        return points;
    }
}

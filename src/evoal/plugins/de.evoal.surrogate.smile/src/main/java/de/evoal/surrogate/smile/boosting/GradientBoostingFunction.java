package de.evoal.surrogate.smile.boosting;

import lombok.Getter;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.data.Tuple;
import smile.data.type.DataTypes;
import smile.data.type.StructField;
import smile.data.type.StructType;
import smile.regression.GradientTreeBoost;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.PredictionInterval;
import de.evoal.surrogate.api.function.Rearrangement;
import de.evoal.surrogate.api.function.Rearrangement.Rearranged;
import de.evoal.surrogate.api.io.onnx.IntervalONNXFunction;

/**
 * A trained 'gradient-boosting' model: three Smile models that predict the output, its lower
 *   and its upper quantile. The three values are {@linkplain Rearrangement rearranged} at every
 *   point. The function has a single output; the model file is an ONNX file, whose reader gives
 *   an {@link IntervalONNXFunction} with the same predictions.
 */
public class GradientBoostingFunction extends ModelFunction implements PredictionInterval {
    /**
     * The name of the model, its DL type.
     */
    public static final String MODEL_NAME = "de.evoal.surrogate.smile.ml.gradient-boosting";

    /**
     * The model of the prediction, of the lower bound and of the upper bound.
     */
    @Getter
    private final GradientTreeBoost prediction;

    @Getter
    private final GradientTreeBoost lower;

    @Getter
    private final GradientTreeBoost upper;

    /**
     * The weight of each tree.
     */
    @Getter
    private final double shrinkage;

    /**
     * The coverage of the interval.
     */
    private final double coverage;

    /**
     * {@value IntervalONNXFunction#MEDIAN} or {@value IntervalONNXFunction#MEAN}.
     */
    @Getter
    private final String pointPrediction;

    /**
     * The schema of a point: the inputs named {@code x0}, ..., in the order of the input space.
     */
    private final StructType schema;

    /**
     * @param input The input features.
     * @param output The single output feature.
     * @param prediction The model of the prediction.
     * @param lower The model of the lower bound.
     * @param upper The model of the upper bound.
     * @param shrinkage The weight of each tree of the three models.
     * @param coverage The coverage of the interval.
     * @param pointPrediction {@value IntervalONNXFunction#MEDIAN} or
     *   {@value IntervalONNXFunction#MEAN}.
     */
    public GradientBoostingFunction(final Space input, final Space output,
                                    final GradientTreeBoost prediction, final GradientTreeBoost lower, final GradientTreeBoost upper,
                                    final double shrinkage, final double coverage, final String pointPrediction) {
        super(MODEL_NAME, input, output);

        if(output.size() != 1) {
            throw new IllegalArgumentException("A gradient boosting model has a single output, not " + output + ".");
        }

        this.prediction = prediction;
        this.lower = lower;
        this.upper = upper;
        this.shrinkage = shrinkage;
        this.coverage = coverage;
        this.pointPrediction = pointPrediction;
        this.schema = schemaOf(input.size());
    }

    /**
     * @return The schema of the inputs: {@code x0}, ..., {@code x(n-1)}, all double. Feature names
     *   like {@code x:0} do not parse in a Smile formula.
     */
    static StructType schemaOf(final int inputs) {
        final StructField[] fields = new StructField[inputs];
        for(int i = 0; i < inputs; ++i) {
            fields[i] = new StructField(columnName(i), DataTypes.DoubleType);
        }

        return new StructType(fields);
    }

    /**
     * @return The name of the column of the i-th input.
     */
    static String columnName(final int i) {
        return "x" + i;
    }

    @Override
    public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
        output.eSet(this.output.iterator().next(), predict(input).prediction());
    }

    @Override
    public Interval interval(final @NonNull TypedEObject input, final @NonNull EStructuralFeature output) {
        if(!this.output.contains(output)) {
            throw new IllegalArgumentException("'" + output.getName() + "' is not the output of the gradient boosting model.");
        }

        return predict(input).interval();
    }

    @Override
    public double coverage(final @NonNull EStructuralFeature output) {
        return coverage;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The fitted trees do not change, and Smile binds the formula of a model per thread.
     */
    @Override
    public boolean isThreadSafe() {
        return true;
    }

    private Rearranged predict(final TypedEObject input) {
        final double[] values = predictUnarranged(toArray(input));

        return IntervalONNXFunction.MEDIAN.equals(pointPrediction)
               ? Rearrangement.ofQuantile(values[0], values[1], values[2])
               : Rearrangement.ofMean(values[0], values[1], values[2]);
    }

    /**
     * @param point The inputs in the order of the input space.
     * @return The prediction, the lower and the upper bound as the three models predict them,
     *   before the rearrangement.
     */
    double[] predictUnarranged(final double[] point) {
        final Tuple tuple = Tuple.of(schema, point);

        return new double[] {prediction.predict(tuple), lower.predict(tuple), upper.predict(tuple)};
    }

    private double[] toArray(final TypedEObject input) {
        final double[] point = new double[this.input.size()];

        int index = 0;
        for(final EStructuralFeature feature : this.input) {
            point[index] = input.eGetAsDouble(feature);
            index += 1;
        }

        return point;
    }
}

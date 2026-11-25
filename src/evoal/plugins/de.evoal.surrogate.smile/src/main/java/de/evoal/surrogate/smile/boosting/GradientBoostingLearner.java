package de.evoal.surrogate.smile.boosting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToLongFunction;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import smile.base.cart.Loss;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.math.MathEx;
import smile.regression.GradientTreeBoost;

import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.onnx.IntervalONNXFunction;
import de.evoal.surrogate.api.training.AbstractModelLearner;
import de.evoal.surrogate.api.training.ModelLearner;
import de.evoal.surrogate.smile.utils.Converter;

/**
 * Learns a 'gradient-boosting' model: three Smile gradient boosting models with the same
 *   attributes, for the prediction (least squares for the mean, the 0.5 quantile for the
 *   median), the lower bound (quantile (1 − coverage) / 2) and the upper bound (quantile
 *   (1 + coverage) / 2).
 * <p>
 * Smile draws the rows of each tree from the random generator of the training thread, which
 *   the learner seeds before each fit with a seed of the {@link RandomService}: with
 *   {@code shared} rows all three fits use the same seed, so tree t of each model is fitted on
 *   the same rows; with {@code independent} rows each fit has its own seed.
 */
@Dependent
@Named("de.evoal.surrogate.smile.ml.gradient-boosting-learner")
@Slf4j
public class GradientBoostingLearner extends AbstractModelLearner {
    /**
     * The name of the random stream of the fits, the DL type.
     */
    static final String STREAM = GradientBoostingFunction.MODEL_NAME;

    /**
     * The response column of the training data.
     */
    private static final String RESPONSE = "y";

    /**
     * The attributes of the model.
     *
     * @param median Whether the prediction is the median (otherwise the mean).
     * @param trees The number of trees of each model.
     * @param shrinkage The weight of each tree.
     * @param maxDepth The maximum depth of a tree.
     * @param maxNodes The maximum number of leaves of a tree.
     * @param nodeSize The minimum number of rows in a leaf.
     * @param samplingFraction The share of the rows each tree is fitted on.
     * @param sharedRows Whether tree t of each model is fitted on the same rows.
     * @param coverage The coverage of the prediction interval.
     */
    record Settings(boolean median, int trees, double shrinkage, int maxDepth, int maxNodes, int nodeSize,
                    double samplingFraction, boolean sharedRows, double coverage) {
    }

    @Inject
    private AttributeHelper helper;

    @Inject
    private RandomService random;

    private Settings settings;

    /**
     * The training data to use.
     */
    private final List<TypedEObject> trainingData = new ArrayList<>();

    /**
     * The trained model.
     */
    private GradientBoostingFunction function;

    @Override
    public void add(final TypedEObject features) {
        trainingData.add(features.copy());
    }

    @Override
    public ModelLearner init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        settings = new Settings(
                IntervalONNXFunction.MEDIAN.equals(helper.<EEnumLiteral>lookup(configuration, "point-prediction").getName()),
                helper.lookup(configuration, "number-trees"),
                helper.lookup(configuration, "shrinkage"),
                helper.lookup(configuration, "max-depth"),
                helper.lookup(configuration, "max-nodes"),
                helper.lookup(configuration, "node-size"),
                helper.lookup(configuration, "sampling-fraction"),
                "shared".equals(helper.<EEnumLiteral>lookup(configuration, "row-sampling").getName()),
                helper.lookup(configuration, "coverage"));

        return this;
    }

    @Override
    public void learn() {
        log.info("Fitting gradient boosting with a prediction interval from {} to {}.", inputFeatures, outputFeatures);

        Requirements.requireSizeGreaterThan(inputFeatures, 0);
        Requirements.requireSize(outputFeatures, 1);

        final Function<TypedEObject, double[]> sourceConverter = Converter.create(inputFeatures);
        final Function<TypedEObject, double[]> targetConverter = Converter.create(outputFeatures);

        final double[][] sources = new double[trainingData.size()][];
        final double[] targets = new double[trainingData.size()];
        for(int i = 0; i < trainingData.size(); ++i) {
            sources[i] = sourceConverter.apply(trainingData.get(i));
            targets[i] = targetConverter.apply(trainingData.get(i))[0];
        }

        log.info("Using {} points for regression.", sources.length);
        function = fit(inputFeatures, outputFeatures, sources, targets, settings, random::seedFor);
    }

    /**
     * Fits the three models.
     *
     * @param input The input features.
     * @param output The single output feature.
     * @param sources The inputs of the training rows, in the order of the input space.
     * @param targets The output of the training rows.
     * @param settings The attributes of the model.
     * @param seeds The seed of a named random stream.
     * @return The trained model.
     */
    static GradientBoostingFunction fit(final Space input, final Space output, final double[][] sources, final double[] targets,
                                        final Settings settings, final ToLongFunction<String> seeds) {
        final DataFrame data = dataFrame(input.size(), sources, targets);
        final Formula formula = Formula.lhs(RESPONSE);
        final double alpha = (1.0 - settings.coverage()) / 2.0;

        final GradientTreeBoost prediction = fit(formula, data, settings.median() ? Loss.quantile(0.5) : Loss.ls(), settings,
                                                 seeds.applyAsLong(streamOf(settings, "prediction")));
        final GradientTreeBoost lower = fit(formula, data, Loss.quantile(alpha), settings,
                                            seeds.applyAsLong(streamOf(settings, "lower")));
        final GradientTreeBoost upper = fit(formula, data, Loss.quantile(1.0 - alpha), settings,
                                            seeds.applyAsLong(streamOf(settings, "upper")));

        log.info("Fitted {} trees per model: prediction ({}), lower bound (quantile {}) and upper bound (quantile {}).",
                 settings.trees(), settings.median() ? IntervalONNXFunction.MEDIAN : IntervalONNXFunction.MEAN, alpha, 1.0 - alpha);

        return new GradientBoostingFunction(input, output, prediction, lower, upper, settings.shrinkage(), settings.coverage(),
                                            settings.median() ? IntervalONNXFunction.MEDIAN : IntervalONNXFunction.MEAN);
    }

    /**
     * @return The name of the random stream of a model: the same for all three models with
     *   shared rows, one per model otherwise.
     */
    static String streamOf(final Settings settings, final String model) {
        return settings.sharedRows() ? STREAM : STREAM + "/" + model;
    }

    private static GradientTreeBoost fit(final Formula formula, final DataFrame data, final Loss loss, final Settings settings, final long seed) {
        final GradientTreeBoost.Options options = new GradientTreeBoost.Options(loss, settings.trees(), settings.maxDepth(), settings.maxNodes(),
                                                                                settings.nodeSize(), settings.shrinkage(),
                                                                                settings.samplingFraction(), null, null);

        // Smile draws the rows of each tree from the generator of this thread
        MathEx.setSeed(seed);

        return GradientTreeBoost.fit(formula, data, options);
    }

    /**
     * @return The training data with the columns {@code x0}, ..., {@code x(n-1)} and the response.
     */
    private static DataFrame dataFrame(final int inputs, final double[][] sources, final double[] targets) {
        final double[][] rows = new double[sources.length][];
        for(int i = 0; i < sources.length; ++i) {
            rows[i] = new double[inputs + 1];
            System.arraycopy(sources[i], 0, rows[i], 0, inputs);
            rows[i][inputs] = targets[i];
        }

        final String[] names = new String[inputs + 1];
        for(int i = 0; i < inputs; ++i) {
            names[i] = GradientBoostingFunction.columnName(i);
        }
        names[inputs] = RESPONSE;

        return DataFrame.of(rows, names);
    }

    @Override
    public @NonNull ModelFunction toFunction() {
        return function;
    }
}

package de.evoal.surrogate.smile.boosting;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.ToLongFunction;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import smile.base.cart.InternalNode;
import smile.base.cart.Loss;
import smile.base.cart.Node;
import smile.base.cart.OrdinalNode;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.math.MathEx;
import smile.regression.GradientTreeBoost;
import smile.regression.RegressionTree;

import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.api.function.PredictionInterval.Interval;
import de.evoal.surrogate.api.io.onnx.AbstractONNXReader;
import de.evoal.surrogate.api.io.onnx.IntervalONNXFunction;
import de.evoal.surrogate.api.io.onnx.ONNXFunction;
import de.evoal.surrogate.api.io.onnx.ONNXModelStorage;
import de.evoal.surrogate.main.internal.SurrogateModelTransformer;
import de.evoal.surrogate.smile.boosting.GradientBoostingLearner.Settings;

/**
 * The 'gradient-boosting' surrogate (#349): fitting, the prediction interval and the ONNX file.
 */
public class GradientBoostingTest {
    private static final EPackage PACKAGE = EcoreFactory.eINSTANCE.createEPackage();
    static {
        PACKAGE.setName("test");
        PACKAGE.setNsURI("http://www.evoal.de/test/gradient-boosting");
    }

    /**
     * The relative tolerance of the stored model: ONNX Runtime sums the leaf weights in another
     *   order than Smile.
     */
    private static final double TOLERANCE = 1e-12;

    private static final ToLongFunction<String> SEEDS = RandomService.withSeed(42)::seedFor;

    @TempDir
    Path folder;

    private EAttribute x0;
    private EAttribute x1;
    private EAttribute y;
    private EAttribute lower;
    private EAttribute upper;
    private Space input;
    private Space output;

    @BeforeEach
    void setUp() {
        final EClass data = EcoreFactory.eINSTANCE.createEClass();
        data.setName("data" + PACKAGE.getEClassifiers().size());
        PACKAGE.getEClassifiers().add(data);
        x0 = attribute(data, "x:0");
        x1 = attribute(data, "x:1");
        y = attribute(data, "y:0");
        lower = attribute(data, "y:0" + IntervalONNXFunction.LOWER);
        upper = attribute(data, "y:0" + IntervalONNXFunction.UPPER);

        final Space space = new Space(data);
        input = space.subSpace(List.of(x0, x1));
        output = space.subSpace(List.of(y));
    }

    private static EAttribute attribute(final EClass type, final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        type.getEStructuralFeatures().add(attribute);

        return attribute;
    }

    /**
     * Training data: x uniform in [0, 1]², y = sin(2π·x0) + x1 with normal noise whose standard
     *   deviation 0.05 + 0.5·x0 grows with x0.
     */
    private record Data(double[][] sources, double[] targets) {
        static Data of(final int rows, final long seed) {
            final SplittableRandom random = new SplittableRandom(seed);
            final double[][] sources = new double[rows][];
            final double[] targets = new double[rows];
            for(int i = 0; i < rows; ++i) {
                sources[i] = new double[] {random.nextDouble(), random.nextDouble()};
                targets[i] = mean(sources[i]) + noise(random) * (0.05 + 0.5 * sources[i][0]);
            }

            return new Data(sources, targets);
        }

        static double mean(final double[] point) {
            return Math.sin(2 * Math.PI * point[0]) + point[1];
        }

        /**
         * @return A standard normal number (Box–Muller).
         */
        private static double noise(final SplittableRandom random) {
            return Math.sqrt(-2 * Math.log(1 - random.nextDouble())) * Math.cos(2 * Math.PI * random.nextDouble());
        }
    }

    private static Settings settings(final boolean median, final double samplingFraction, final boolean sharedRows) {
        return new Settings(median, 50, 0.1, 6, 16, 5, samplingFraction, sharedRows, 0.8);
    }

    private GradientBoostingFunction fit(final Data data, final Settings settings, final ToLongFunction<String> seeds) {
        return GradientBoostingLearner.fit(input, output, data.sources(), data.targets(), settings, seeds);
    }

    private TypedEObject at(final double[] point) {
        final TypedEObject in = input.newEObject();
        in.eSet(x0, point[0]);
        in.eSet(x1, point[1]);

        return in;
    }

    /**
     * Stores the model as ONNX file and loads the file with the given output features.
     */
    private ONNXModelStorage storeAndLoad(final GradientBoostingFunction function, final Space outputs) {
        final DefinitionModuleLoader loader = Mockito.mock(DefinitionModuleLoader.class);
        final SurrogateModelTransformer transformer = Mockito.mock(SurrogateModelTransformer.class);
        Mockito.when(transformer.setSpace(Mockito.any())).thenReturn(transformer);

        final File file = folder.resolve("model.onnx").toFile();
        final ONNXModelStorage storage = new ONNXModelStorage(loader, transformer);
        storage.setLocation(file.toURI()).setSpaces(input, output);
        final GradientBoostingONNXWriter writer = new GradientBoostingONNXWriter();
        writer.setStorage(storage);
        writer.store(function);

        final ONNXModelStorage loaded = new ONNXModelStorage(loader, transformer);
        loaded.setLocation(file.toURI()).setSpaces(input, outputs);

        return loaded;
    }

    /**
     * @return The function of the stored model whose outputs are the three outputs of the
     *   graph, before the rearrangement.
     */
    private ONNXFunction unarranged(final GradientBoostingFunction function) {
        final Space outputs = input.merge(output).subSpace(List.of(y, lower, upper));
        final AbstractONNXReader reader = new AbstractONNXReader() {
        };
        reader.setStorage(storeAndLoad(function, outputs));
        reader.setSpace(input, outputs);

        return reader.load();
    }

    /**
     * @return Random points in [-0.5, 1.5]² (also outside the training data) and, for every split
     *   of the three models, a point exactly on its split value.
     */
    private static List<double[]> testPoints(final GradientBoostingFunction function, final int random) {
        final SplittableRandom generator = new SplittableRandom(7);
        final List<double[]> points = new ArrayList<>();
        for(int i = 0; i < random; ++i) {
            points.add(new double[] {generator.nextDouble(-0.5, 1.5), generator.nextDouble(-0.5, 1.5)});
        }

        for(final GradientTreeBoost model : List.of(function.getPrediction(), function.getLower(), function.getUpper())) {
            for(final RegressionTree tree : model.trees()) {
                addSplitPoints(tree.root(), generator, points);
            }
        }

        return points;
    }

    private static void addSplitPoints(final Node node, final SplittableRandom generator, final List<double[]> points) {
        if(node instanceof OrdinalNode ordinal) {
            final double[] point = {generator.nextDouble(), generator.nextDouble()};
            point[ordinal.feature()] = SmileInternals.splitValue(ordinal);
            points.add(point);
        }

        if(node instanceof InternalNode internal) {
            addSplitPoints(internal.trueChild(), generator, points);
            addSplitPoints(internal.falseChild(), generator, points);
        }
    }

    private static void assertClose(final double expected, final double actual, final String what) {
        Assertions.assertTrue(Math.abs(expected - actual) <= TOLERANCE * Math.max(1.0, Math.max(Math.abs(expected), Math.abs(actual))),
                              what + ": expected " + expected + ", got " + actual);
    }

    @Test
    public void theStoredModelComputesTheThreeModels() {
        // given
        final GradientBoostingFunction function = fit(Data.of(300, 1), settings(false, 0.7, true), SEEDS);

        // when
        final ONNXFunction stored = unarranged(function);

        // then
        final List<double[]> points = testPoints(function, 500);
        Assertions.assertTrue(points.size() > 1000, "points on split values: " + points.size());
        for(final double[] point : points) {
            final double[] expected = function.predictUnarranged(point);
            final TypedEObject out = stored.getOutput().newEObject();
            stored.apply(at(point), out);

            assertClose(expected[0], out.eGetAsDouble(y), "prediction at " + point[0] + ", " + point[1]);
            assertClose(expected[1], out.eGetAsDouble(lower), "lower bound at " + point[0] + ", " + point[1]);
            assertClose(expected[2], out.eGetAsDouble(upper), "upper bound at " + point[0] + ", " + point[1]);
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    public void theReaderGivesTheModelWithItsInterval(final boolean median) {
        // given
        final GradientBoostingFunction function = fit(Data.of(300, 2), settings(median, 0.7, true), SEEDS);
        final GradientBoostingONNXReader reader = new GradientBoostingONNXReader();
        reader.setStorage(storeAndLoad(function, output));
        reader.setSpace(input, output);

        // when
        final ONNXFunction loaded = reader.load();

        // then
        final IntervalONNXFunction interval = Assertions.assertInstanceOf(IntervalONNXFunction.class, loaded);
        Assertions.assertEquals(GradientBoostingFunction.MODEL_NAME, loaded.getModelName());
        Assertions.assertEquals(0.8, interval.coverage(y));
        for(final double[] point : testPoints(function, 200)) {
            final TypedEObject expected = output.newEObject();
            function.apply(at(point), expected);
            final TypedEObject actual = output.newEObject();
            loaded.apply(at(point), actual);
            final Interval expectedInterval = function.interval(at(point), y);
            final Interval actualInterval = interval.interval(at(point), y);

            assertClose(expected.eGetAsDouble(y), actual.eGetAsDouble(y), "prediction");
            assertClose(expectedInterval.lower(), actualInterval.lower(), "lower bound");
            assertClose(expectedInterval.upper(), actualInterval.upper(), "upper bound");
        }
    }

    @Test
    public void treesThatAreASingleLeafAreStored() {
        // given: constant data, so no split improves a tree
        final double[][] sources = new double[50][];
        final double[] targets = new double[50];
        for(int i = 0; i < sources.length; ++i) {
            sources[i] = new double[] {i / 50.0, (i % 7) / 7.0};
            targets[i] = 3.0;
        }
        final GradientBoostingFunction function = GradientBoostingLearner.fit(input, output, sources, targets,
                                                                              new Settings(true, 5, 0.1, 2, 2, 1, 1.0, true, 0.8), SEEDS);
        Assertions.assertInstanceOf(smile.base.cart.LeafNode.class, function.getPrediction().trees()[0].root());

        // when
        final ONNXFunction stored = unarranged(function);

        // then
        for(final double[] point : List.of(new double[] {0.0, 0.0}, new double[] {-1.0, 2.0}, new double[] {0.5, 0.5})) {
            final TypedEObject out = stored.getOutput().newEObject();
            stored.apply(at(point), out);

            Assertions.assertEquals(3.0, out.eGetAsDouble(y), 1e-12);
            Assertions.assertEquals(3.0, out.eGetAsDouble(lower), 1e-12);
            Assertions.assertEquals(3.0, out.eGetAsDouble(upper), 1e-12);
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void theIntervalHoldsTheCoverageAndFollowsTheNoise(final boolean sharedRows) {
        // given
        final Settings settings = new Settings(true, 200, 0.05, 4, 8, 20, 0.7, sharedRows, 0.8);
        final GradientBoostingFunction function = fit(Data.of(2000, 3), settings, SEEDS);
        final Data test = Data.of(2000, 4);

        // when
        int inside = 0;
        double narrow = 0.0;
        int narrowCount = 0;
        double wide = 0.0;
        int wideCount = 0;
        for(int i = 0; i < test.targets().length; ++i) {
            final double[] point = test.sources()[i];
            final Interval interval = function.interval(at(point), y);
            if(interval.lower() <= test.targets()[i] && test.targets()[i] <= interval.upper()) {
                inside += 1;
            }
            if(point[0] < 0.2) {
                narrow += interval.width();
                narrowCount += 1;
            } else if(point[0] > 0.8) {
                wide += interval.width();
                wideCount += 1;
            }
        }

        // then: the noise at x0 > 0.8 is more than 4 times the noise at x0 < 0.2
        final double share = inside / (double) test.targets().length;
        Assertions.assertEquals(0.8, share, 0.05, "share of the test rows in the interval");
        Assertions.assertTrue(wide / wideCount > 2 * narrow / narrowCount,
                              "mean width " + narrow / narrowCount + " at x0 < 0.2, " + wide / wideCount + " at x0 > 0.8");
    }

    @Test
    public void theMedianLiesInTheInterval() {
        // given
        final GradientBoostingFunction function = fit(Data.of(300, 5), settings(true, 0.7, true), SEEDS);

        // then
        for(final double[] point : testPoints(function, 500)) {
            final TypedEObject out = output.newEObject();
            function.apply(at(point), out);
            final Interval interval = function.interval(at(point), y);

            Assertions.assertTrue(interval.lower() <= out.eGetAsDouble(y) && out.eGetAsDouble(y) <= interval.upper());
        }
    }

    @Test
    public void theMeanIsALeastSquaresModelWithTheSameAttributesAndSeed() {
        // given
        final Data data = Data.of(300, 6);
        final GradientBoostingFunction function = fit(data, settings(false, 0.7, true), SEEDS);

        // when: Smile's least-squares model, fitted directly
        final double[][] rows = new double[data.targets().length][];
        for(int i = 0; i < rows.length; ++i) {
            rows[i] = new double[] {data.sources()[i][0], data.sources()[i][1], data.targets()[i]};
        }
        MathEx.setSeed(SEEDS.applyAsLong(GradientBoostingLearner.STREAM));
        final GradientTreeBoost leastSquares = GradientTreeBoost.fit(Formula.lhs("y"), DataFrame.of(rows, "x0", "x1", "y"),
                                                                     new GradientTreeBoost.Options(Loss.ls(), 50, 6, 16, 5, 0.1, 0.7, null, null));

        // then
        for(final double[] point : testPoints(function, 200)) {
            final TypedEObject out = output.newEObject();
            function.apply(at(point), out);

            Assertions.assertEquals(leastSquares.predict(smile.data.Tuple.of(GradientBoostingFunction.schemaOf(2), point)), out.eGetAsDouble(y));
        }
    }

    @Test
    public void theSameSeedGivesTheSameModelAndAnotherSeedAnotherOne() {
        // given
        final Data data = Data.of(300, 8);
        final Settings settings = settings(true, 0.7, true);

        // when
        final GradientBoostingFunction first = fit(data, settings, SEEDS);
        final GradientBoostingFunction second = fit(data, settings, SEEDS);
        final GradientBoostingFunction other = fit(data, settings, RandomService.withSeed(43)::seedFor);

        // then
        final List<double[]> points = testPoints(first, 200);
        Assertions.assertTrue(points.stream().allMatch(p -> java.util.Arrays.equals(first.predictUnarranged(p), second.predictUnarranged(p))));
        Assertions.assertFalse(points.stream().allMatch(p -> java.util.Arrays.equals(first.predictUnarranged(p), other.predictUnarranged(p))));
    }

    @Test
    public void sharedRowsUseOneStreamForTheThreeModelsAndIndependentRowsOneEach() {
        final Settings shared = settings(true, 0.7, true);
        final Settings independent = settings(true, 0.7, false);

        Assertions.assertEquals(List.of(GradientBoostingLearner.STREAM, GradientBoostingLearner.STREAM, GradientBoostingLearner.STREAM),
                                List.of(GradientBoostingLearner.streamOf(shared, "prediction"), GradientBoostingLearner.streamOf(shared, "lower"),
                                        GradientBoostingLearner.streamOf(shared, "upper")));
        Assertions.assertEquals(List.of(GradientBoostingLearner.STREAM + "/prediction", GradientBoostingLearner.STREAM + "/lower",
                                        GradientBoostingLearner.STREAM + "/upper"),
                                List.of(GradientBoostingLearner.streamOf(independent, "prediction"), GradientBoostingLearner.streamOf(independent, "lower"),
                                        GradientBoostingLearner.streamOf(independent, "upper")));
    }

    @Test
    public void sharedAndIndependentRowsDifferOnlyWithASamplingFractionBelowOne() {
        // given
        final Data data = Data.of(300, 9);

        // when
        final GradientBoostingFunction sharedSample = fit(data, settings(true, 0.7, true), SEEDS);
        final GradientBoostingFunction independentSample = fit(data, settings(true, 0.7, false), SEEDS);
        final GradientBoostingFunction sharedAll = fit(data, settings(true, 1.0, true), SEEDS);
        final GradientBoostingFunction independentAll = fit(data, settings(true, 1.0, false), SEEDS);

        // then
        final List<double[]> points = testPoints(sharedSample, 200);
        Assertions.assertFalse(points.stream().allMatch(p -> java.util.Arrays.equals(sharedSample.predictUnarranged(p), independentSample.predictUnarranged(p))));
        Assertions.assertTrue(points.stream().allMatch(p -> java.util.Arrays.equals(sharedAll.predictUnarranged(p), independentAll.predictUnarranged(p))));
    }

    @Test
    public void theOutputMustBeASingleFeature() {
        final Space outputs = input.merge(output).subSpace(List.<EStructuralFeature>of(y, lower));

        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new GradientBoostingFunction(input, outputs, null, null, null, 0.1, 0.8, IntervalONNXFunction.MEAN));
    }
}

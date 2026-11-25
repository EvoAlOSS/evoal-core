package de.evoal.surrogate.main.resampling;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import de.evoal.surrogate.api.training.PredictedValues;
import de.evoal.surrogate.api.training.ResampledValues;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import de.evoal.surrogate.main.gof.interval.MPIWCalculator;
import de.evoal.surrogate.main.gof.interval.PICPCalculator;
import de.evoal.surrogate.main.gof.rmse.RMSECalculator;
import de.evoal.surrogate.main.gof.rmse.RRSECalculator;
import de.evoal.surrogate.main.gof.rsquare.RSquareCalculator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * The pooled goodness of fit of a resampling scheme: the measures on the held-out rows of all
 *   parts, each with the prediction of its part's model (#351).
 */
public class PooledGoodnessOfFitTest {
    private static final String SCHEME = "leave-one-out-cross-validation";
    private static final String RMSE = "de.evoal.surrogate.ml.rmse";
    private static final String RRSE = "de.evoal.surrogate.ml.rrse";
    private static final String R_SQUARE = "de.evoal.surrogate.ml.R²";
    private static final String PICP = "de.evoal.surrogate.ml.picp";
    private static final String MPIW = "de.evoal.surrogate.ml.mpiw";

    /**
     * The actual values of the rows.
     */
    private static final double[] ACTUAL = {1.0, 2.0, 4.0, 7.0, 11.0};

    private static final EPackage PACKAGE = EcoreFactory.eINSTANCE.createEPackage();
    private static final EClass DATA = EcoreFactory.eINSTANCE.createEClass();
    private static final EAttribute Y = attribute("y:0");
    private static final Space SPACE;

    static {
        PACKAGE.setName("test");
        PACKAGE.setNsURI("http://www.evoal.de/test/pooled-goodness-of-fit");
        DATA.setName("data");
        DATA.getEStructuralFeatures().add(Y);
        PACKAGE.getEClassifiers().add(DATA);
        SPACE = new Space(DATA);
    }

    private static EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);

        return attribute;
    }

    private static List<TypedEObject> rows() {
        return Arrays.stream(ACTUAL)
                     .mapToObj(value -> {
                         final TypedEObject row = SPACE.newEObject();
                         row.eSet(Y, value);
                         return row;
                     })
                     .toList();
    }

    /**
     * The model of a part predicts the mean of its training rows for every held-out row.
     */
    private static Map<EStructuralFeature, PredictedValues> meanModel(final Part part) {
        final double mean = Arrays.stream(part.training()).mapToDouble(i -> ACTUAL[i]).average().orElseThrow();
        final double[] actual = Arrays.stream(part.heldOut()).mapToDouble(i -> ACTUAL[i]).toArray();
        final double[] predicted = new double[actual.length];
        Arrays.fill(predicted, mean);

        return Map.of(Y, new PredictedValues(actual, predicted));
    }

    /**
     * Runs the measures on precomputed predictions in a state without a surrogate.
     *
     * @return Measure → value.
     */
    private static Map<String, Object> assess(final Map<EStructuralFeature, PredictedValues> predictions, final SurrogateInformationCalculator... measures) {
        final InterpreterState state = new InterpreterState();
        GoodnessOfFit.of(state).assess(SCHEME, Stream::empty, predictions);

        for(final SurrogateInformationCalculator measure : measures) {
            measure.call(state, new Object[0]);
        }

        final Map<String, Object> result = new LinkedHashMap<>();
        GoodnessOfFit.of(state)
                     .values()
                     .getOrDefault(Y, Map.of())
                     .forEach((measure, dataSets) -> result.put(measure, dataSets.get(SCHEME)));

        return result;
    }

    private static Map<EStructuralFeature, PredictedValues> pooledMeanModel(final List<Part> parts) {
        return PredictedValues.pool(parts.stream().map(PooledGoodnessOfFitTest::meanModel).toList());
    }

    @Test
    public void thePoolConcatenatesPartsOfDifferentSizesInTheirOrder() {
        // given
        final Map<EStructuralFeature, PredictedValues> first = Map.of(Y, new PredictedValues(new double[]{1.0, 2.0}, new double[]{1.5, 2.5}));
        final Map<EStructuralFeature, PredictedValues> second = Map.of(Y, new PredictedValues(new double[]{3.0}, new double[]{3.5}));

        // when
        final PredictedValues pooled = PredictedValues.pool(List.of(first, second)).get(Y);

        // then
        Assertions.assertArrayEquals(new double[]{1.0, 2.0, 3.0}, pooled.actual());
        Assertions.assertArrayEquals(new double[]{1.5, 2.5, 3.5}, pooled.predicted());
        Assertions.assertTrue(pooled.bounds().isEmpty());
    }

    @Test
    public void theBoundsArePooledAndAssessed() {
        // given: covered are 1.0 and 3.0, not 2.0; widths 2, 1 and 3
        final Map<EStructuralFeature, PredictedValues> first = Map.of(Y, new PredictedValues(new double[]{1.0, 2.0}, new double[]{1.0, 2.5},
                Optional.of(new PredictedValues.Bounds(new double[]{0.0, 2.2}, new double[]{2.0, 3.2}))));
        final Map<EStructuralFeature, PredictedValues> second = Map.of(Y, new PredictedValues(new double[]{3.0}, new double[]{3.0},
                Optional.of(new PredictedValues.Bounds(new double[]{1.5}, new double[]{4.5}))));

        // when
        final Map<EStructuralFeature, PredictedValues> pooled = PredictedValues.pool(List.of(first, second));
        final Map<String, Object> values = assess(pooled, new PICPCalculator(), new MPIWCalculator());

        // then
        Assertions.assertArrayEquals(new double[]{0.0, 2.2, 1.5}, pooled.get(Y).bounds().orElseThrow().lower());
        Assertions.assertArrayEquals(new double[]{2.0, 3.2, 4.5}, pooled.get(Y).bounds().orElseThrow().upper());
        Assertions.assertEquals(2.0 / 3.0, (Double) values.get(PICP), 1e-12);
        Assertions.assertEquals(2.0, (Double) values.get(MPIW), 1e-12);
    }

    @Test
    public void aPartWithoutBoundsPoolsNoBounds() {
        // given
        final Map<EStructuralFeature, PredictedValues> first = Map.of(Y, new PredictedValues(new double[]{1.0}, new double[]{1.0},
                Optional.of(new PredictedValues.Bounds(new double[]{0.0}, new double[]{2.0}))));
        final Map<EStructuralFeature, PredictedValues> second = Map.of(Y, new PredictedValues(new double[]{3.0}, new double[]{3.0}));

        // when
        final PredictedValues pooled = PredictedValues.pool(List.of(first, second)).get(Y);

        // then
        Assertions.assertTrue(pooled.bounds().isEmpty());
    }

    @Test
    public void leaveOneOutOfTheMeanModelHasNoValuePerPartButAPooledValue() {
        // given: the residual of row i is (a_i - mean(a)) n / (n - 1)
        final List<Part> parts = new LeaveOneOutCrossValidation().parts(rows());
        final double n = ACTUAL.length;

        // when
        final Map<String, Object> single = assess(meanModel(parts.get(0)), new RRSECalculator(), new RSquareCalculator());
        final Map<String, Object> pooled = assess(pooledMeanModel(parts), new RRSECalculator(), new RSquareCalculator());

        // then
        Assertions.assertEquals(Map.of(), single);
        Assertions.assertEquals(n / (n - 1), (Double) pooled.get(RRSE), 1e-12);
        Assertions.assertEquals(1.0 - (n / (n - 1)) * (n / (n - 1)), (Double) pooled.get(R_SQUARE), 1e-12);
    }

    @Test
    public void kFoldWithOneFoldPerRowPoolsAsLeaveOneOut() {
        // given
        final List<Part> leaveOneOut = new LeaveOneOutCrossValidation().parts(rows());
        final List<Part> kFold = new KFoldCrossValidation(ACTUAL.length, RandomService.withSeed(42).random("k-fold")).parts(rows());

        // when
        final Map<String, Object> first = assess(pooledMeanModel(leaveOneOut), new RMSECalculator(), new RRSECalculator(), new RSquareCalculator());
        final Map<String, Object> second = assess(pooledMeanModel(kFold), new RMSECalculator(), new RRSECalculator(), new RSquareCalculator());

        // then
        Assertions.assertEquals(first.keySet(), second.keySet());
        for(final String measure : List.of(RMSE, RRSE, R_SQUARE)) {
            Assertions.assertEquals((Double) first.get(measure), (Double) second.get(measure), 1e-12, measure);
        }
    }

    @Test
    public void aMeasureIsRecordedWithItsPartsAndItsPooledValue() {
        // given
        final GoodnessOfFit goodnessOfFit = new GoodnessOfFit();
        final Map<EStructuralFeature, Map<String, List<Double>>> values = Map.of(Y, Map.of(RMSE, List.of(1.0, 3.0)));
        final Map<EStructuralFeature, Map<String, Double>> pooled = Map.of(Y, Map.of(RMSE, 2.5, R_SQUARE, 0.9));

        // when
        ResampleFunction.record(goodnessOfFit, SCHEME, 2, values, pooled);

        // then
        final Map<String, Map<String, Object>> recorded = goodnessOfFit.values().get(Y);
        Assertions.assertEquals(ResampledValues.of(List.of(1.0, 3.0), OptionalDouble.of(2.5)), recorded.get(RMSE).get(SCHEME));
        Assertions.assertEquals(ResampledValues.of(List.of(), OptionalDouble.of(0.9)), recorded.get(R_SQUARE).get(SCHEME));
    }

    @Test
    public void aMeasureWithoutPooledValueIsRecordedWithItsParts() {
        // given
        final GoodnessOfFit goodnessOfFit = new GoodnessOfFit();

        // when
        ResampleFunction.record(goodnessOfFit, SCHEME, 3, Map.of(Y, Map.of(RMSE, List.of(1.0))), Map.of());

        // then
        Assertions.assertEquals(ResampledValues.of(List.of(1.0), OptionalDouble.empty()), goodnessOfFit.values().get(Y).get(RMSE).get(SCHEME));
    }

    @Test
    public void theHeldOutRowsOfAllPartsArePooledInTheOrderOfTheParts() {
        // given
        final List<TypedEObject> rows = rows();
        final ResampleFunction.Assessed first = new ResampleFunction.Assessed(rows.subList(0, 2), meanModel(new Part(new int[]{2, 3, 4}, new int[]{0, 1})));
        final ResampleFunction.Assessed second = new ResampleFunction.Assessed(rows.subList(2, 5), meanModel(new Part(new int[]{0, 1}, new int[]{2, 3, 4})));

        // when
        final ResampleFunction.Assessed pooled = ResampleFunction.Assessed.pool(List.of(first, second));

        // then
        Assertions.assertEquals(rows, pooled.rows());
        Assertions.assertArrayEquals(ACTUAL, pooled.predictions().get(Y).actual());
    }
}

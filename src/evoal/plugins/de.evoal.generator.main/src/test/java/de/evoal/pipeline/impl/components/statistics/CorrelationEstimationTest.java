package de.evoal.pipeline.impl.components.statistics;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.api.correlations.CorrelationRange;
import de.evoal.optimisation.api.correlations.RankStandardError;
import de.evoal.pipeline.api.values.PipelineValues;

/**
 * The estimates of {@link CorrelationEstimation} on rows of the real features {@code x},
 *   {@code y}, {@code z}, the integer feature {@code o} and the string feature {@code n}.
 */
public class CorrelationEstimationTest {
    private static final double[] X = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final double[] Y = {2.1, 3.9, 6.2, 7.8, 9.9, 12.5, 13.1, 16.4, 17.2, 21.0};

    private final Space space = space();

    private final InterpreterState context = new InterpreterState();

    private static Space space() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("row");

        add(eClass, "x", EcorePackage.Literals.EDOUBLE);
        add(eClass, "y", EcorePackage.Literals.EDOUBLE);
        add(eClass, "z", EcorePackage.Literals.EDOUBLE);
        add(eClass, "o", EcorePackage.Literals.EINT);
        add(eClass, "n", EcorePackage.Literals.ESTRING);

        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    /**
     * Adds an attribute as {@code EClassProvider} creates it for a data description.
     */
    private static void add(final EClass eClass, final String name, final EClassifier type) {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName(name);
        feature.setEType(type);
        feature.setUnsettable(true);
        eClass.getEStructuralFeatures().add(feature);
    }

    private EStructuralFeature feature(final String name) {
        return space.getEClass().getEStructuralFeature(name);
    }

    private CorrelationEstimation estimation(final List<String> names, final List<ScaleType> scales, final double minimum,
                                             final Map<EStructuralFeature, List<CorrelationRange>> ranges)
            throws InitializationException {
        final CorrelationEstimation estimation = new CorrelationEstimation();
        estimation.setContext(context);
        PipelineValues.of(context).beginExecution();

        return estimation.configure(names.stream().map(this::feature).toList(), scales, "correlations", minimum, 0.95,
                                    RankStandardError.BONETT_WRIGHT, ranges);
    }

    private void feed(final CorrelationEstimation estimation, final double[] x, final double[] y, final double[] z) {
        for(int i = 0; i < x.length; ++i) {
            final TypedEObject row = space.newEObject();
            row.eSet(feature("x"), x[i]);
            row.eSet(feature("y"), y[i]);
            row.eSet(feature("z"), z == null ? 0.0 : z[i]);
            row.eSet(feature("o"), i % 3);
            row.eSet(feature("n"), "v" + i);
            estimation.apply(row);
        }
        estimation.streamEnded();
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> estimates() {
        return (List<Map<String, Object>>) PipelineValues.of(context).get("correlations");
    }

    @Test
    public void thePearsonEstimateHasItsIntervalAndKeys() throws InitializationException {
        final CorrelationEstimation estimation = estimation(List.of("x", "y"), List.of(ScaleType.QUOTIENT, ScaleType.QUOTIENT),
                                                            0.0, Map.of());

        feed(estimation, X, Y, null);

        final Map<String, Object> estimate = estimates().getFirst();
        Assertions.assertEquals(List.of("first", "second", "firstLower", "firstUpper", "secondLower", "secondUpper", "ranged",
                                        "kind", "n", "coefficient", "absoluteCoefficient", "confidenceLower",
                                        "confidenceUpper", "confidenceLevel", "intervalMethod"),
                                List.copyOf(estimate.keySet()));
        Assertions.assertEquals("x", estimate.get("first"));
        Assertions.assertEquals("y", estimate.get("second"));
        Assertions.assertEquals(false, estimate.get("ranged"));
        Assertions.assertNull(estimate.get("firstLower"));
        Assertions.assertEquals("pearson", estimate.get("kind"));
        Assertions.assertEquals(10, estimate.get("n"));
        Assertions.assertEquals(0.9956358982969217, (Double) estimate.get("coefficient"), 1e-12);
        Assertions.assertEquals(0.9809395711258976, (Double) estimate.get("confidenceLower"), 1e-9);
        Assertions.assertEquals(0.9990064725507297, (Double) estimate.get("confidenceUpper"), 1e-9);
        Assertions.assertEquals("fisher", estimate.get("intervalMethod"));
    }

    @Test
    public void anOrdinalFeatureGivesASpearmanEstimate() throws InitializationException {
        final CorrelationEstimation estimation = estimation(List.of("x", "o"), List.of(ScaleType.QUOTIENT, ScaleType.ORDINAL),
                                                            0.0, Map.of());

        feed(estimation, X, Y, null);

        Assertions.assertEquals("spearman", estimates().getFirst().get("kind"));
        Assertions.assertEquals("bonett-wright", estimates().getFirst().get("intervalMethod"));
    }

    @Test
    public void pairsWithANominalFeatureAreSkipped() throws InitializationException {
        final CorrelationEstimation estimation = estimation(List.of("x", "y", "n"),
                                                            List.of(ScaleType.QUOTIENT, ScaleType.QUOTIENT, ScaleType.NOMINAL),
                                                            0.0, Map.of());

        feed(estimation, X, Y, null);

        Assertions.assertEquals(1, estimates().size());
    }

    @Test
    public void nonNumericFeaturesThatAreNotNominalAreRejected() {
        Assertions.assertThrows(InitializationException.class,
                                () -> CorrelationEstimation.checkFeatures(List.of(feature("x"), feature("n")),
                                                                          List.of(ScaleType.QUOTIENT, ScaleType.ORDINAL)));
        Assertions.assertThrows(InitializationException.class,
                                () -> CorrelationEstimation.checkFeatures(List.of(feature("x")), List.of(ScaleType.QUOTIENT)));
    }

    @Test
    public void everyCombinationOfRangesGetsAnEstimateBesidesTheOneOnAllRows() throws InitializationException {
        final Map<EStructuralFeature, List<CorrelationRange>> ranges =
                Map.of(feature("x"), List.of(new CorrelationRange(1, 5), new CorrelationRange(6, 10)),
                       feature("y"), List.of(new CorrelationRange(0, 100)));
        final CorrelationEstimation estimation = estimation(List.of("x", "y"), List.of(ScaleType.QUOTIENT, ScaleType.QUOTIENT),
                                                            0.0, ranges);

        feed(estimation, X, Y, null);

        final List<Map<String, Object>> estimates = estimates();
        Assertions.assertEquals(List.of(false, true, true), estimates.stream().map(e -> e.get("ranged")).toList());
        Assertions.assertEquals(List.of(10, 5, 5), estimates.stream().map(e -> e.get("n")).toList());
        Assertions.assertEquals(6.0, estimates.get(2).get("firstLower"));
        Assertions.assertEquals(100.0, estimates.get(2).get("secondUpper"));
    }

    @Test
    public void weakAndConstantEstimatesAreLeftOut() throws InitializationException {
        // z is constant (no coefficient), the pairs with it are left out; x and y stay
        final CorrelationEstimation estimation = estimation(List.of("x", "y", "z"),
                                                            List.of(ScaleType.QUOTIENT, ScaleType.QUOTIENT, ScaleType.QUOTIENT),
                                                            0.99, Map.of());

        feed(estimation, X, Y, null);

        Assertions.assertEquals(1, estimates().size());
        Assertions.assertEquals("y", estimates().getFirst().get("second"));
    }

    @Test
    public void aMissingValueLeavesOutTheRowOnlyForItsPairs() throws InitializationException {
        final double[] z = {1, 3, 2, 5, 4, 7, 6, 9, 8, Double.NaN};
        final CorrelationEstimation estimation = estimation(List.of("x", "y", "z"),
                                                            List.of(ScaleType.QUOTIENT, ScaleType.QUOTIENT, ScaleType.QUOTIENT),
                                                            0.0, Map.of());

        feed(estimation, X, Y, z);

        Assertions.assertEquals(List.of(10, 9, 9), estimates().stream().map(e -> e.get("n")).toList());
    }

    @Test
    public void aRowWithoutAValueIsLeftOutOnlyForItsPairs() throws InitializationException {
        // given: the last row has no value for z, e.g. a missing value of an ARFF file (#355)
        final CorrelationEstimation estimation = estimation(List.of("x", "y", "z"),
                                                            List.of(ScaleType.QUOTIENT, ScaleType.QUOTIENT, ScaleType.QUOTIENT),
                                                            0.0, Map.of());
        final double[] z = {1, 3, 2, 5, 4, 7, 6, 9, 8};

        // when
        for(int i = 0; i < X.length; ++i) {
            final TypedEObject row = space.newEObject();
            row.eSet(feature("x"), X[i]);
            row.eSet(feature("y"), Y[i]);
            if(i < z.length) {
                row.eSet(feature("z"), z[i]);
            }
            estimation.apply(row);
        }
        estimation.streamEnded();

        // then
        Assertions.assertEquals(List.of(10, 9, 9), estimates().stream().map(e -> e.get("n")).toList());
    }

    @Test
    public void aValueOfZeroIsAValue() throws InitializationException {
        // given (#355)
        final double[] z = {0, 3, 2, 5, 4, 7, 6, 9, 8, 0};
        final CorrelationEstimation estimation = estimation(List.of("x", "y", "z"),
                                                            List.of(ScaleType.QUOTIENT, ScaleType.QUOTIENT, ScaleType.QUOTIENT),
                                                            0.0, Map.of());

        // when
        feed(estimation, X, Y, z);

        // then
        Assertions.assertEquals(List.of(10, 10, 10), estimates().stream().map(e -> e.get("n")).toList());
    }
}

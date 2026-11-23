package de.evoal.surrogate.smile.gaussian;

import de.evoal.core.api.ecore.misc.ConcurrentEClassAccess;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * The predictive standard deviation of a Gaussian process surrogate and its use by several
 *   threads (#293).
 */
public class GaussianProcessFunctionTest {
    private final EAttribute x = attribute("x:0");

    private final EAttribute y = attribute("y:0");

    private final Space data = space(x, y);

    @Nested
    @DisplayName("given the Gaussian process of the Forrester function with a gap in (0.6, 0.9)")
    class Forrester {
        private final GaussianProcessFunction function = new GaussianProcessFunction(data.subSpace(List.of(x)),
                                                                                      data.subSpace(List.of(y)),
                                                                                      ForresterGaussianProcess.fit(100),
                                                                                      Map.of());

        @Test
        public void theDeviationAtTheTrainingPointsIsSmallerThanInTheGap() {
            // given
            final double inTheGap = function.standardDeviation(at(0.75), y);

            // then
            for(final double training : ForresterGaussianProcess.TRAINING) {
                final double deviation = function.standardDeviation(at(training), y);

                Assertions.assertTrue(deviation >= 0.0, "deviation at " + training);
                Assertions.assertTrue(deviation < inTheGap / 10, "deviation " + deviation + " at " + training + ", " + inTheGap + " in the gap");
            }
        }

        @Test
        public void theDeviationGrowsTowardsTheMiddleOfTheGap() {
            Assertions.assertTrue(function.standardDeviation(at(0.65), y) < function.standardDeviation(at(0.75), y));
        }

        @Test
        public void anotherFeatureIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> function.standardDeviation(at(0.5), x));
        }

        @Test
        public void itIsThreadSafe() {
            Assertions.assertTrue(function.isThreadSafe());
        }

        @Test
        public void predictionsInParallelEqualTheSequentialOnes() throws Exception {
            // given
            final List<TypedEObject> inputs = inputs();
            final List<Double> sequential = inputs.stream().map(this::predict).toList();

            // when
            final List<Double> parallel = inParallel(inputs, this::predict);

            // then
            Assertions.assertEquals(sequential, parallel);
        }

        /**
         * The standard deviation uses the native BLAS and LAPACK (dot product, Cholesky
         *   solve). They are not bitwise reproducible: on macOS (Accelerate) even two
         *   sequential runs differ in the last digits (up to 3e-11 for the Forrester process),
         *   so the values are compared with a tolerance. Without the lock in
         *   {@code standardDeviation}, the OpenBLAS of the CI gave wrong values here (0.034
         *   instead of 0.0086).
         */
        @Test
        public void standardDeviationsInParallelEqualTheSequentialOnes() throws Exception {
            // given
            final List<TypedEObject> inputs = inputs();
            final List<Double> sequential = inputs.stream().map(input -> function.standardDeviation(input, y)).toList();

            // when
            final List<Double> parallel = inParallel(inputs, input -> function.standardDeviation(input, y));

            // then
            for(int i = 0; i < inputs.size(); ++i) {
                Assertions.assertEquals(sequential.get(i), parallel.get(i), 1e-9, "at " + inputs.get(i).eGetAsDouble(x));
            }
        }

        private double predict(final TypedEObject input) {
            final TypedEObject output = data.newEObject();
            function.apply(input, output);

            return output.eGetAsDouble(y);
        }
    }

    /**
     * @return 1000 points in [0, 1].
     */
    private List<TypedEObject> inputs() {
        return IntStream.range(0, 1000)
                        .mapToObj(i -> at(i / 999.0))
                        .toList();
    }

    /**
     * Computes the values on 8 threads at once.
     *
     * @return The values in the order of the inputs.
     */
    private List<Double> inParallel(final List<TypedEObject> inputs, final Function<TypedEObject, Double> value) throws Exception {
        ConcurrentEClassAccess.prepare(data.getEClass());

        final List<Callable<Double>> tasks = inputs.stream()
                                                   .<Callable<Double>>map(input -> () -> value.apply(input))
                                                   .toList();
        try(final ExecutorService threads = Executors.newFixedThreadPool(8)) {
            final List<Double> result = new ArrayList<>();
            for(final Future<Double> future : threads.invokeAll(tasks)) {
                result.add(future.get());
            }

            return result;
        }
    }

    private TypedEObject at(final double value) {
        final TypedEObject input = data.newEObject();
        input.eSet(x, value);

        return input;
    }

    private static EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);

        return attribute;
    }

    private static Space space(final EAttribute... attributes) {
        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("data");
        type.getEStructuralFeatures().addAll(List.of(attributes));

        final EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("test");
        pkg.setNsURI("http://www.evoal.de/test/gaussian-process");
        pkg.getEClassifiers().add(type);

        return new Space(type);
    }
}

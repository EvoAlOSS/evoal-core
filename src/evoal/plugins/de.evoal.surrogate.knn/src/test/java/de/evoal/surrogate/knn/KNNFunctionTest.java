package de.evoal.surrogate.knn;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.misc.ConcurrentEClassAccess;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KNNFunctionTest {
    private final EAttribute x = realAttribute("x");
    private final EAttribute y = realAttribute("y");
    private final Space space = space(x, y);

    private TypedEObject point(final double xValue, final double yValue) {
        final TypedEObject point = space.newEObject();
        point.eSet(x, xValue);
        point.eSet(y, yValue);

        return point;
    }

    private static EAttribute realAttribute(final String name) {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName(name);
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        return feature;
    }

    private static Space space(final EAttribute... features) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().addAll(List.of(features));
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    @Nested
    @DisplayName("given a 2-nearest-neighbour function on three training points")
    class TwoNearestNeighbours {
        private final List<TypedEObject> training = List.of(point(0.0, 10.0), point(1.0, 20.0), point(5.0, 90.0));

        private final KNNFunction function = new KNNFunction(
                space.subSpace(Stream.of(x)),
                space.subSpace(Stream.of(y)),
                () -> training.stream().map(p -> new EObjectPair(p, p)),
                2);

        @Test
        public void predictionIsWrittenIntoTheOutput() {
            // given
            final TypedEObject input = point(0.2, 99.0);
            final TypedEObject output = space.newEObject();

            // when
            function.apply(input, output);

            // then: the mean of the two nearest points (10 and 20)
            Assertions.assertEquals(15.0, output.eGetAsDouble(y));
        }

        @Test
        public void inputIsNotChanged() {
            // given
            final TypedEObject input = point(0.2, 99.0);

            // when
            function.apply(input, space.newEObject());

            // then
            Assertions.assertEquals(99.0, input.eGetAsDouble(y));
        }

        @Test
        public void itIsThreadSafe() {
            Assertions.assertTrue(function.isThreadSafe());
        }

        @Test
        public void predictionsInParallelEqualTheSequentialOnes() throws Exception {
            // given
            final List<TypedEObject> inputs = IntStream.range(0, 1000)
                                                       .mapToObj(i -> point(i / 200.0, 0.0))
                                                       .toList();
            final List<Double> sequential = inputs.stream().map(this::predict).toList();

            // when
            ConcurrentEClassAccess.prepare(space.getEClass());
            final List<Callable<Double>> tasks = inputs.stream()
                                                       .<Callable<Double>>map(input -> () -> predict(input))
                                                       .toList();
            final List<Double> parallel = new ArrayList<>();
            try(final ExecutorService threads = Executors.newFixedThreadPool(8)) {
                for(final Future<Double> future : threads.invokeAll(tasks)) {
                    parallel.add(future.get());
                }
            }

            // then
            Assertions.assertEquals(sequential, parallel);
        }

        private double predict(final TypedEObject input) {
            final TypedEObject output = space.newEObject();
            function.apply(input, output);

            return output.eGetAsDouble(y);
        }
    }
}

package de.evoal.surrogate.smile.api;

import de.evoal.core.api.ecore.misc.ConcurrentEClassAccess;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import smile.math.kernel.GaussianKernel;
import smile.regression.KernelMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * The use of an ε-SVR surrogate by several threads (#293).
 */
public class KernelBasedSVRFunctionTest {
    private final EAttribute x = attribute("x:0");

    private final EAttribute y = attribute("y:0");

    private final Space data = space(x, y);

    /**
     * A kernel machine with three support vectors and normalised inputs and outputs.
     */
    private final KernelBasedSVRFunction function = new KernelBasedSVRFunction(
            data.subSpace(List.of(x)),
            data.subSpace(List.of(y)),
            Map.of(),
            new KernelMachine<>(new GaussianKernel(0.5), new double[][] {{-1.0}, {0.0}, {1.0}}, new double[] {0.5, -1.0, 2.0}, 0.25),
            2.0,
            new double[] {5.0}, new double[] {2.0},
            new double[] {100.0}, new double[] {10.0});

    @Test
    public void itIsThreadSafe() {
        Assertions.assertTrue(function.isThreadSafe());
    }

    @Test
    public void predictionsInParallelEqualTheSequentialOnes() throws Exception {
        // given
        final List<TypedEObject> inputs = IntStream.range(0, 1000)
                                                   .mapToObj(i -> at(i / 100.0))
                                                   .toList();
        final List<Double> sequential = inputs.stream().map(this::predict).toList();

        // when
        ConcurrentEClassAccess.prepare(data.getEClass());
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
        final TypedEObject output = data.newEObject();
        function.apply(input, output);

        return output.eGetAsDouble(y);
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
        pkg.setNsURI("http://www.evoal.de/test/svr");
        pkg.getEClassifiers().add(type);

        return new Space(type);
    }
}

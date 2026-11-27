package de.evoal.optimisation.main.fitness;

import java.lang.reflect.Field;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.core.api.random.EvaluationTask;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.EvaluationSourceProvider;

/**
 * The noisy function around a function that returns the objective {@code y = 10}.
 */
public class NoisyFunctionTest {
    private Space space;

    private EAttribute y;

    private final OptimisationFunction delegate = Mockito.mock(OptimisationFunction.class,
            Mockito.withSettings().extraInterfaces(EvaluationSourceProvider.class));

    private final NoisyFunction function = new NoisyFunction();

    private TypedEObject output;

    @BeforeEach
    public void wrapTheFunction() throws Exception {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Objectives");
        y = EcoreFactory.eINSTANCE.createEAttribute();
        y.setName("y");
        y.setEType(EcorePackage.Literals.EDOUBLE);
        eClass.getEStructuralFeatures().add(y);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);
        space = new Space(eClass);

        output = space.newEObject();
        output.eSet(y, 10.0);
        Mockito.when(delegate.evaluate(Mockito.any())).thenReturn(output);

        inject("delegate", delegate);
        inject("randomService", RandomService.withSeed(42));
        inject("standardDeviation", 0.5);
    }

    private void inject(final String name, final Object value) throws ReflectiveOperationException {
        final Field field = NoisyFunction.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(function, value);
    }

    /**
     * @return The objective of the evaluation with the index.
     */
    private double evaluateAs(final long index) {
        return new EvaluationTask(0, index).call(() -> (Double) function.evaluate(Mockito.mock(TypedEObject.class)).eGet(y));
    }

    @Test
    public void theNoiseDependsOnlyOnTheEvaluation() {
        // when
        final double first = evaluateAs(3);
        final double again = evaluateAs(3);
        final double other = evaluateAs(4);

        // then
        Assertions.assertEquals(first, again);
        Assertions.assertNotEquals(first, other);
        Assertions.assertNotEquals(10.0, first);
        Assertions.assertEquals(10.0, output.eGet(y), "the result of the wrapped function stays unchanged");
    }

    @Test
    public void multiplicativeNoiseScalesTheObjective() throws Exception {
        // given
        final double additive = evaluateAs(3) - 10.0;
        inject("multiplicative", true);

        // when
        final double multiplicative = evaluateAs(3);

        // then: the same normal sample e gives 10 + e and 10 * (1 + e)
        Assertions.assertEquals(10.0 * (1.0 + additive), multiplicative, 1e-12);
    }

    @Test
    public void theFunctionForwardsTheSourceAndTheThreadSafety() {
        // given
        Mockito.when(((EvaluationSourceProvider) delegate).getEvaluationSource()).thenReturn(EvaluationSource.SURROGATE);
        Mockito.when(delegate.isThreadSafe()).thenReturn(true);

        // then
        Assertions.assertEquals(EvaluationSource.SURROGATE, function.getEvaluationSource());
        Assertions.assertTrue(function.isThreadSafe());
    }

    @Test
    public void theNoiseNeedsAnEvaluation() {
        Assertions.assertThrows(IllegalStateException.class, () -> function.evaluate(Mockito.mock(TypedEObject.class)));
    }
}

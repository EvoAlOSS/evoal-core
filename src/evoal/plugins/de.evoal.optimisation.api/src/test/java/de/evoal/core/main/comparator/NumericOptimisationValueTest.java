package de.evoal.core.main.comparator;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.main.comparator.NumericOptimisationValue;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.main.comparator.FitnessValue;
import org.eclipse.emf.ecore.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class NumericOptimisationValueTest {
    private final static EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
    private final static EClass eClass = EcoreFactory.eINSTANCE.createEClass();
    private final static EAttribute eFeature = EcoreFactory.eINSTANCE.createEAttribute();
    private static Space space;

    @BeforeAll
    public static void setup() {
        ePackage.setName("Dynamic");
        ePackage.setNsPrefix("dyn");
        ePackage.setNsURI("http://dyn/1.0");
        ePackage.getEClassifiers().clear();
        ePackage.getEClassifiers().add(eClass);

        eFeature.setName("dimension-1");
        eFeature.setEType(EcorePackage.eINSTANCE.getEDouble());
        eClass.getEStructuralFeatures().clear();
        eClass.getEStructuralFeatures().add(eFeature);

        space = new Space(eClass);
    }


    @Test
    public void testOf() {
        final TypedEObject object = space.newEObject();
        object.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(Collections.singletonMap(eFeature, v -> 2 * v.doubleValue()), object);

        Assertions.assertNotNull(optValue);
        Assertions.assertEquals(42.0, optValue.doubleValue());
    }

    @Test
    public void testCompareToSelf() {
        final TypedEObject object = space.newEObject();
        object.eSet(eFeature, 42.0);

        final NumericOptimisationValue testee = NumericOptimisationValue.of(Collections.singletonMap(eFeature, v -> 2 * v.doubleValue()), object);

        int result = testee.compareTo(testee);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCompareToOptimisationValueSameContent() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final TypedEObject object2 = space.newEObject();
        object2.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue1 = NumericOptimisationValue.of(Collections.singletonMap(eFeature, v -> 2 * v.doubleValue()), object1);
        final NumericOptimisationValue optValue2 = NumericOptimisationValue.of(Collections.singletonMap(eFeature, v -> 2 * v.doubleValue()), object2);

        Assertions.assertNotNull(optValue1);
        Assertions.assertNotNull(optValue2);
        Assertions.assertEquals(0, optValue1.compareTo(optValue2));
        Assertions.assertEquals(0, optValue2.compareTo(optValue1));
    }

    @Test
    public void testCompareToOptimisationValueDifferentContent() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final TypedEObject object2 = space.newEObject();
        object2.eSet(eFeature, 83.0);

        final NumericOptimisationValue optValue1 = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);
        final NumericOptimisationValue optValue2 = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object2);

        Assertions.assertNotNull(optValue1);
        Assertions.assertNotNull(optValue2);
        Assertions.assertEquals(-1, optValue1.compareTo(optValue2));
        Assertions.assertEquals(1, optValue2.compareTo(optValue1));
    }

    @Test
    public void testCompareToDifferentInstance() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue1 = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);
        final FitnessLayout layout = new FitnessLayout(List.of(FitnessComponent.named("dimension-1")));
        final Fitness fitness = new Fitness(layout, new double[] {42.0});
        final FitnessValue optValue2 = FitnessValue.of(object1, fitness, new int[] {0}, List.of(eFeature));

        Assertions.assertThrows(IllegalArgumentException.class, () -> optValue1.compareTo(optValue2));
    }

    @Test
    public void testToString() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);

        Assertions.assertNotNull(optValue);
        Assertions.assertEquals("NumericOptimisationValue [42.0]", optValue.toString());
    }

    @Test
    public void testToStatistics() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);

        Assertions.assertNotNull(optValue);
        Object [] statistics = optValue.toStatistics().toArray();

        Assertions.assertNotNull(statistics);
        Assertions.assertEquals(1, statistics.length);
        Assertions.assertEquals(42.0,statistics[0]);
    }

    @Test
    public void testIntValue() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);

        Assertions.assertNotNull(optValue);
        int value = optValue.intValue();

        Assertions.assertEquals(42, value);
    }


    @Test
    public void testLongValue() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);

        Assertions.assertNotNull(optValue);
        long value = optValue.longValue();

        Assertions.assertEquals(42L, value);
    }

    @Test
    public void testFloatValue() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);

        Assertions.assertNotNull(optValue);
        float value = optValue.floatValue();

        Assertions.assertEquals(42.0f, value);
    }

    @Test
    public void testDoubleValue() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);

        Assertions.assertNotNull(optValue);
        double value = optValue.doubleValue();

        Assertions.assertEquals(42.0, value);
    }

    @Test
    public void testGetFitnessValue() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature, 42.0);

        final NumericOptimisationValue optValue = NumericOptimisationValue.of(Collections.singletonMap(eFeature, Function.identity()), object1);

        Assertions.assertNotNull(optValue);
        Number value = optValue.getFitnessValue();

        Assertions.assertEquals(42.0, value);
    }
}

package de.evoal.core.main.comparator;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.main.comparator.NumericOptimisationValue;
import de.evoal.optimisation.main.comparator.WeightedSumOptimisationValue;
import org.eclipse.emf.ecore.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class WeightedSumOptimisationValueTest  {
    private final static EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
    private final static EClass eClass = EcoreFactory.eINSTANCE.createEClass();
    private final static EAttribute eFeature1 = EcoreFactory.eINSTANCE.createEAttribute();
    private final static EAttribute eFeature2 = EcoreFactory.eINSTANCE.createEAttribute();
    private static Space space;
    private static Map<EStructuralFeature, Double> weights;

    @BeforeAll
    public static void setup() {
        ePackage.setName("Dynamic");
        ePackage.setNsPrefix("dyn");
        ePackage.setNsURI("http://dyn/1.0");
        ePackage.getEClassifiers().add(eClass);

        eFeature1.setName("dimension-1");
        eFeature1.setEType(EcorePackage.eINSTANCE.getEDouble());

        eFeature2.setName("dimension-2");
        eFeature2.setEType(EcorePackage.eINSTANCE.getEDouble());

        eClass.getEStructuralFeatures().add(eFeature1);
        eClass.getEStructuralFeatures().add(eFeature2);

        space = new Space(eClass);

        weights = new HashMap<>();
        weights.put(eFeature1, 2.0);
        weights.put(eFeature2, 3.0);

    }

    @Test
    public void testGetFitnessValues() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 21.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);

        Assertions.assertNotNull(testee);
        TypedEObject values = testee.getFitnessValues();

        Assertions.assertNotNull(values);
        Assertions.assertEquals(space, values.eSpace());
        Assertions.assertEquals(42.0, values.eGet(eFeature1));
        Assertions.assertEquals(21.0, values.eGet(eFeature2));
    }

    @Test
    public void testCompareToNull() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 21.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);

        Assertions.assertThrows(NullPointerException.class, () -> testee.compareTo(null));
    }

    @Test
    public void testCompareToSelf() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 21.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);

        int result = testee.compareTo(testee);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCompareToIdentical() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 21.0);

        final TypedEObject object2 = space.newEObject();
        object2.eSet(eFeature1, 42.0);
        object2.eSet(eFeature2, 21.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);
        WeightedSumOptimisationValue other = WeightedSumOptimisationValue.of(weights, object2);

        int result = testee.compareTo(other);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCompareToLarger() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 12.0);

        final TypedEObject object2 = space.newEObject();
        object2.eSet(eFeature1, 42.0);
        object2.eSet(eFeature2, 14.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);
        WeightedSumOptimisationValue other = WeightedSumOptimisationValue.of(weights, object2);

        int result = testee.compareTo(other);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testCompareToSmaller() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 12.0);

        final TypedEObject object2 = space.newEObject();
        object2.eSet(eFeature1, 9.0);
        object2.eSet(eFeature2, 12.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);
        WeightedSumOptimisationValue other = WeightedSumOptimisationValue.of(weights, object2);

        int result = testee.compareTo(other);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testCompareToOtherInstance() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 12.0);

        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
        EAttribute eFeature1 = EcoreFactory.eINSTANCE.createEAttribute();

        ePackage.getEClassifiers().add(eClass2);

        eFeature1.setName("dimension-1");
        eFeature1.setEType(EcorePackage.eINSTANCE.getEDouble());

        eClass2.getEStructuralFeatures().add(eFeature1);

        Space space2 = new Space(eClass2);

        final TypedEObject object2 = space2.newEObject();
        object2.eSet(eFeature1, 9.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);
        NumericOptimisationValue other = NumericOptimisationValue.of(Collections.singletonMap(eFeature1, v -> 1.0), object2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> testee.compareTo(other));
    }

    @Test
    public void testToStringWithOneDimension() {
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
        EAttribute eFeature1 = EcoreFactory.eINSTANCE.createEAttribute();

        ePackage.getEClassifiers().add(eClass2);

        eFeature1.setName("dimension-1");
        eFeature1.setEType(EcorePackage.eINSTANCE.getEDouble());

        eClass2.getEStructuralFeatures()
               .add(eFeature1);

        Space space2 = new Space(eClass2);

        final TypedEObject object = space2.newEObject();
        object.eSet(eFeature1, 9.0);

        final Map<EStructuralFeature, Double> weights = Collections.singletonMap(eFeature1, 1.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object);

        Assertions.assertNotNull(testee);
        Assertions.assertEquals("WeightedSum [fit=[9.0], w=[1.0]]", testee.toString());
    }

    @Test
    public void testToStringWithTwoDimensions() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 12.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);

        Assertions.assertNotNull(testee);

        Assertions.assertEquals("WeightedSum [fit=[42.0, 12.0], w=[2.0, 3.0]]", testee.toString());
    }

    @Test
    public void testToStatistics() {
        final TypedEObject object1 = space.newEObject();
        object1.eSet(eFeature1, 42.0);
        object1.eSet(eFeature2, 12.0);

        WeightedSumOptimisationValue testee = WeightedSumOptimisationValue.of(weights, object1);

        Assertions.assertNotNull(testee);
        Object [] result = testee.toStatistics().toArray();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(42.0, result[0]);
        Assertions.assertEquals(12.0, result[1]);
    }
}

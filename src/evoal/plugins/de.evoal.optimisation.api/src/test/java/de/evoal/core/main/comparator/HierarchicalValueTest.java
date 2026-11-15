package de.evoal.core.main.comparator;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.main.comparator.HierarchicalValue;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class HierarchicalValueTest {
    private Map<EStructuralFeature, Function<Number, Number>> weights1;
    private Map<EStructuralFeature, Function<Number, Number>> weights2;
    private List<EStructuralFeature> normalOrder;
    private List<EStructuralFeature> inverseOrder;

    private EAttribute eAttribute1;
    private EAttribute eAttribute2;
    private EAttribute eAttribute3;


    private Space space;

    @BeforeEach
    void setUp() {
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        EClass eClass = EcoreFactory.eINSTANCE.createEClass();

        eAttribute1 = EcoreFactory.eINSTANCE.createEAttribute();
        eAttribute2 = EcoreFactory.eINSTANCE.createEAttribute();
        eAttribute3 = EcoreFactory.eINSTANCE.createEAttribute();

        eAttribute1.setName("feature1");
        eAttribute2.setName("feature2");
        eAttribute3.setName("feature3");
        eAttribute1.setEType(EcorePackage.eINSTANCE.getEDouble());
        eAttribute2.setEType(EcorePackage.eINSTANCE.getEDouble());
        eAttribute3.setEType(EcorePackage.eINSTANCE.getEDouble());

        eClass.getEStructuralFeatures().add(eAttribute1);
        eClass.getEStructuralFeatures().add(eAttribute2);
        eClass.getEStructuralFeatures().add(eAttribute3);

        ePackage.getEClassifiers().add(eClass);

        space = new Space(eClass);

        normalOrder = Arrays.asList(eAttribute1, eAttribute2, eAttribute3);
        inverseOrder = Arrays.asList(eAttribute3, eAttribute2, eAttribute1);

        weights1 = new HashMap<>();
        weights1.put(eAttribute1, (Function<Number, Number>) number -> 1 * number.doubleValue());
        weights1.put(eAttribute2, (Function<Number, Number>) number -> 1 * number.doubleValue());
        weights1.put(eAttribute3, (Function<Number, Number>) number -> 1 * number.doubleValue());

        weights2 = new HashMap<>();
        weights2.put(eAttribute1, (Function<Number, Number>) number -> 1 * number.doubleValue());
        weights2.put(eAttribute2, (Function<Number, Number>) number -> -1 * number.doubleValue());
        weights2.put(eAttribute3, (Function<Number, Number>) number -> 1 * number.doubleValue());
    }

    @Test
    void testOf() {
        TypedEObject object = space.newEObject();
        object.eSet(eAttribute1, 0.5);
        object.eSet(eAttribute2, 0.7);
        object.eSet(eAttribute3, 0.9);

        HierarchicalValue value = HierarchicalValue.of(weights1, object, normalOrder);

        assertEquals(object.eGet(eAttribute1), value.getFitnessValues().eGet(eAttribute1));
        assertEquals(object.eGet(eAttribute2), value.getFitnessValues().eGet(eAttribute2));
        assertEquals(object.eGet(eAttribute3), value.getFitnessValues().eGet(eAttribute3));
    }

    @Test
    void testCompareTo() {
        TypedEObject object1 = space.newEObject();
        object1.eSet(eAttribute1, 0.5);
        object1.eSet(eAttribute2, 0.7);
        object1.eSet(eAttribute3, 0.9);

        TypedEObject object2 = space.newEObject();
        object2.eSet(eAttribute1, 0.5);
        object2.eSet(eAttribute2, 0.7);
        object2.eSet(eAttribute3, 1.0);

        HierarchicalValue value1 = HierarchicalValue.of(weights1, object1, normalOrder);
        HierarchicalValue value2 = HierarchicalValue.of(weights1, object2, normalOrder);

        assertTrue(value1.compareTo(value2) < 0);
        assertTrue(value2.compareTo(value1) > 0);
    }

    @Test
    void testCompareToEqual() {
        TypedEObject object = space.newEObject();
        object.eSet(eAttribute1, 0.5);
        object.eSet(eAttribute2, 0.7);
        object.eSet(eAttribute3, 0.9);

        HierarchicalValue value1 = HierarchicalValue.of(weights1, object, normalOrder);
        HierarchicalValue value2 = HierarchicalValue.of(weights1, object, normalOrder);

        assertEquals(0, value1.compareTo(value2));
    }

    @Test
    void testCompareToDifferentOrder() {
        TypedEObject object = space.newEObject();
        object.eSet(eAttribute1, 0.5);
        object.eSet(eAttribute2, 0.7);
        object.eSet(eAttribute3, 0.9);
        
        HierarchicalValue value1 = HierarchicalValue.of(weights1, object, normalOrder);
        HierarchicalValue value2 = HierarchicalValue.of(weights2, object, inverseOrder);

        assertTrue(value1.compareTo(value2) < 0);
        assertTrue(value2.compareTo(value1) > 0);
    }

    @Test
    void testToStatistics() {
        TypedEObject object = space.newEObject();
        object.eSet(eAttribute1, 0.5);
        object.eSet(eAttribute2, 0.7);
        object.eSet(eAttribute3, 0.9);


        HierarchicalValue value = HierarchicalValue.of(weights1, object, normalOrder);

        List<Object> statistics = value.toStatistics();
        assertEquals(0.5, object.eGet(eAttribute1));
        assertEquals(0.7, object.eGet(eAttribute2));
        assertEquals(0.9, object.eGet(eAttribute3));
    }

    @Test
    void testToString() {
        TypedEObject object = space.newEObject();
        object.eSet(eAttribute1, 0.5);
        object.eSet(eAttribute2, 0.7);
        object.eSet(eAttribute3, 0.9);

        HierarchicalValue value = HierarchicalValue.of(weights1, object, normalOrder);

        String expected = "HierarchicalValue [fit=[feature1=0.5, feature2=0.7, feature3=0.9], order=feature1, feature2, feature3]";
        assertEquals(expected, value.toString());
    }

    @Test
    void testCompareToInvalidType() {
        TypedEObject object = space.newEObject();
        object.eSet(eAttribute1, 0.5);
        object.eSet(eAttribute2, 0.7);
        object.eSet(eAttribute3, 0.9);

        HierarchicalValue value = HierarchicalValue.of(weights1, object, normalOrder);

        OptimisationValue other = Mockito.mock(OptimisationValue.class);

        assertThrows(IllegalArgumentException.class, () -> value.compareTo(other));
    }
}
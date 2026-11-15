package de.evoal.core.api.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

public class TypedEObjectsTest {
    private final Space space = space();

    private TypedEObject position(final double x, final double y) {
        final TypedEObject position = space.newEObject();
        final EAttribute xFeature = (EAttribute) space.getEClass().getEStructuralFeature("x");
        final EAttribute yFeature = (EAttribute) space.getEClass().getEStructuralFeature("y");

        position.eSet(xFeature, x);
        position.eSet(yFeature, y);

        return position;
    }

    private static EAttribute realAttribute(final String name) {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName(name);
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        return feature;
    }

    private static Space space() {
        final EAttribute x = realAttribute("x");
        final EAttribute y = realAttribute("y");

        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().add(x);
        eClass.getEStructuralFeatures().add(y);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    @Nested
    @DisplayName("given two objects with the same values")
    class SameValues {
        private final TypedEObject first = position(1.0, 2.0);

        private final TypedEObject second = position(1.0, 2.0);

        @Test
        public void theObjectsHaveTheSameValues() {
            // when
            final boolean same = TypedEObjects.haveSameValues(first, second);

            // then
            Assertions.assertTrue(same);
        }

        @Test
        public void aCopyHasTheSameValues() {
            // given
            final TypedEObject copy = new TypedEObject(first);

            // when
            final boolean same = TypedEObjects.haveSameValues(first, copy);

            // then
            Assertions.assertTrue(same);
        }
    }

    @Nested
    @DisplayName("given two objects that differ in one value")
    class DifferentValue {
        private final TypedEObject first = position(1.0, 2.0);

        private final TypedEObject second = position(1.0, 2.0000000001);

        @Test
        public void theObjectsDoNotHaveTheSameValues() {
            // when
            final boolean same = TypedEObjects.haveSameValues(first, second);

            // then
            Assertions.assertFalse(same);
        }
    }
}

package de.evoal.pipeline.impl.components.benchmarks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

/**
 * The Forrester function at points with known values.
 */
class ForresterTest {
    private final List<EStructuralFeature> xs = new ArrayList<>();

    private final List<EStructuralFeature> ys = new ArrayList<>();

    private Space space(final int variables, final int values) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Space");
        xs.clear();
        ys.clear();
        for(int i = 0; i < variables; ++i) {
            final EAttribute x = attribute("x:" + i);
            xs.add(x);
            eClass.getEStructuralFeatures().add(x);
        }
        for(int i = 0; i < values; ++i) {
            final EAttribute y = attribute("y:" + i);
            ys.add(y);
            eClass.getEStructuralFeatures().add(y);
        }
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private static EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        return attribute;
    }

    private TypedEObject evaluate(final int values, final double... variables) {
        final Space space = space(variables.length, values);
        final TypedEObject point = new TypedEObject(space);
        for(int i = 0; i < variables.length; ++i) {
            point.eSet(xs.get(i), variables[i]);
        }

        final Forrester forrester = new Forrester();
        forrester.setFeatures(space, space.subSpace(xs), space.subSpace(ys));
        return forrester.apply(point);
    }

    private double evaluate(final double x) {
        return evaluate(1, x).eGetAsDouble(ys.getFirst());
    }

    @Test
    @DisplayName("at the borders: f(0) = 4 sin(-4), f(1) = 16 sin(8)")
    void borders() {
        Assertions.assertEquals(4.0 * Math.sin(-4.0), evaluate(0.0), 1e-12);
        Assertions.assertEquals(16.0 * Math.sin(8.0), evaluate(1.0), 1e-12);
        Assertions.assertEquals(3.02720998, evaluate(0.0), 1e-8);
        Assertions.assertEquals(15.82973195, evaluate(1.0), 1e-8);
    }

    @Test
    @DisplayName("the squared factor vanishes at x = 1/3")
    void root() {
        Assertions.assertEquals(0.0, evaluate(1.0 / 3.0), 1e-15);
    }

    @Test
    @DisplayName("the global minimum f(0.757249) = -6.02074")
    void globalMinimum() {
        final double minimum = evaluate(0.757249);
        Assertions.assertEquals(-6.02074, minimum, 1e-5);
        Assertions.assertTrue(evaluate(0.757249 - 1e-3) > minimum);
        Assertions.assertTrue(evaluate(0.757249 + 1e-3) > minimum);
    }

    @Test
    @DisplayName("more than one variable or value is rejected")
    void wrongNumberOfFeatures() {
        Assertions.assertThrows(IllegalStateException.class, () -> evaluate(1, 0.5, 0.5));
        Assertions.assertThrows(IllegalStateException.class, () -> evaluate(2, 0.5));
    }
}

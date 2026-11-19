package de.evoal.pipeline.impl.components.benchmarks;

import java.util.ArrayList;
import java.util.Arrays;
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
 * ZDT1 at points with known values.
 */
class Zdt1Test {
    private static final int VARIABLES = 30;

    private final List<EStructuralFeature> xs = new ArrayList<>();

    private EStructuralFeature f1;

    private EStructuralFeature f2;

    private Zdt1 createBenchmark(final Space space) {
        final Zdt1 zdt1 = new Zdt1();
        zdt1.setFeatures(space, space.subSpace(xs), space.subSpace(List.of(f1, f2)));
        return zdt1;
    }

    private Space space(final int variables) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Space");
        xs.clear();
        for(int i = 0; i < variables; ++i) {
            final EAttribute x = attribute("x:" + i);
            xs.add(x);
            eClass.getEStructuralFeatures().add(x);
        }
        f1 = attribute("f:1");
        f2 = attribute("f:2");
        eClass.getEStructuralFeatures().add(f1);
        eClass.getEStructuralFeatures().add(f2);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private static EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        return attribute;
    }

    private TypedEObject evaluate(final double... values) {
        final Space space = space(values.length);
        final TypedEObject point = new TypedEObject(space);
        for(int i = 0; i < values.length; ++i) {
            point.eSet(xs.get(i), values[i]);
        }
        return createBenchmark(space).apply(point);
    }

    @Test
    @DisplayName("on the Pareto-optimal front (x_2 = ... = x_n = 0): f2 = 1 - sqrt(f1)")
    void front() {
        for(final double x1 : new double[] {0.0, 0.25, 0.5, 1.0}) {
            final double[] values = new double[VARIABLES];
            values[0] = x1;

            final TypedEObject result = evaluate(values);
            Assertions.assertEquals(x1, result.eGetAsDouble(f1), 0.0);
            Assertions.assertEquals(1.0 - Math.sqrt(x1), result.eGetAsDouble(f2), 1e-15);
        }
    }

    @Test
    @DisplayName("all variables 1: g = 10, f2 = 10 * (1 - sqrt(1 / 10))")
    void ones() {
        final double[] values = new double[VARIABLES];
        Arrays.fill(values, 1.0);

        final TypedEObject result = evaluate(values);
        Assertions.assertEquals(1.0, result.eGetAsDouble(f1), 0.0);
        Assertions.assertEquals(10.0 * (1.0 - Math.sqrt(0.1)), result.eGetAsDouble(f2), 1e-12);
    }

    @Test
    @DisplayName("two variables: g = 1 + 9 * x_2")
    void twoVariables() {
        final TypedEObject result = evaluate(0.36, 0.5);
        final double g = 1.0 + 9.0 * 0.5;
        Assertions.assertEquals(g * (1.0 - Math.sqrt(0.36 / g)), result.eGetAsDouble(f2), 1e-12);
    }

    @Test
    @DisplayName("fewer than two variables are rejected")
    void oneVariable() {
        Assertions.assertThrows(IllegalStateException.class, () -> evaluate(0.5));
    }
}

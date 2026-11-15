package de.evoal.optimisation.local_search.main.neighbour;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.ecore.info.BoundaryExtractor.Bound;
import de.evoal.core.api.ecore.info.BoundaryExtractor.Extracted;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

public class ManualNeighbourChoosingStrategyTest {
    private final EClass eClass = EcoreFactory.eINSTANCE.createEClass();

    public ManualNeighbourChoosingStrategyTest() {
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);
    }

    private EAttribute feature(final String name, final EClassifier type) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(type);
        eClass.getEStructuralFeatures().add(attribute);
        return attribute;
    }

    private static void inject(final Object target, final String name, final Object value) throws Exception {
        final Field field = ManualNeighbourChoosingStrategy.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * Creates the strategy. The values are pairs of feature and step size.
     */
    private ManualNeighbourChoosingStrategy strategy(final Space space, final Object... steps) throws Exception {
        final TypedEObject stepValues = space.newEObject();
        for(int i = 0; i < steps.length; i += 2) {
            stepValues.eSet((EAttribute) steps[i], steps[i + 1]);
        }

        final ManualNeighbourChoosingStrategy strategy = new ManualNeighbourChoosingStrategy();
        inject(strategy, "space", space);
        inject(strategy, "stepValues", stepValues);
        inject(strategy, "boundaries", new FeatureBoundaries());
        return strategy;
    }

    @Test
    public void allCombinationsAreGenerated() throws Exception {
        final EAttribute x = feature("x", EcorePackage.Literals.EDOUBLE);
        final EAttribute y = feature("y", EcorePackage.Literals.EDOUBLE);
        final Space space = new Space(eClass);

        final TypedEObject base = space.newEObject();
        base.eSet(x, 0.0);
        base.eSet(y, 0.0);

        final List<TypedEObject> neighbours = strategy(space, x, 0.5, y, 1.0).neighbours(base).toList();

        // 3^2 combinations without the unchanged candidate
        Assertions.assertEquals(8, neighbours.size());
        Assertions.assertTrue(neighbours.stream().noneMatch(n -> n.eGet(x).equals(0.0) && n.eGet(y).equals(0.0)));
        Assertions.assertEquals(-0.5, neighbours.getLast().eGet(x));
        Assertions.assertEquals(-1.0, neighbours.getLast().eGet(y));
    }

    @Test
    public void valuesHaveTheTypeOfTheirFeature() throws Exception {
        final EAttribute real = feature("real", EcorePackage.Literals.EDOUBLE);
        final EAttribute single = feature("single", EcorePackage.Literals.EFLOAT);
        final EAttribute integer = feature("integer", EcorePackage.Literals.EINT);
        final EAttribute flag = feature("flag", EcorePackage.Literals.EBOOLEAN);
        final Space space = new Space(eClass);

        final TypedEObject base = space.newEObject();
        base.eSet(real, 1.0);
        base.eSet(single, 1.0f);
        base.eSet(integer, 1);
        base.eSet(flag, true);

        strategy(space, real, 0.1, single, 0.1f, integer, 2).neighbours(base).forEach(n -> {
            Assertions.assertInstanceOf(Double.class, n.eGet(real));
            Assertions.assertInstanceOf(Float.class, n.eGet(single));
            Assertions.assertInstanceOf(Integer.class, n.eGet(integer));
            Assertions.assertEquals(true, n.eGet(flag));
        });
    }

    @Test
    public void neighboursOutsideOfTheBoundariesAreSkipped() throws Exception {
        final EAttribute x = feature("x", EcorePackage.Literals.EDOUBLE);
        FeatureBoundaries.annotate(x, new Extracted(Optional.of(new Bound(-1.0, true)), Optional.of(new Bound(1.0, false))));
        final Space space = new Space(eClass);

        final TypedEObject base = space.newEObject();
        base.eSet(x, 0.5);

        final List<Object> values = strategy(space, x, 0.5).neighbours(base).map(n -> n.eGet(x)).toList();

        // 1.0 is excluded by the upper boundary, 0.5 is the unchanged candidate
        Assertions.assertEquals(List.of(0.0), values);
    }

    @Test
    public void integerOverflowIsSkipped() throws Exception {
        final EAttribute n = feature("n", EcorePackage.Literals.EINT);
        final Space space = new Space(eClass);

        final TypedEObject base = space.newEObject();
        base.eSet(n, Integer.MAX_VALUE);

        final List<Object> values = strategy(space, n, 1).neighbours(base).map(o -> o.eGet(n)).toList();

        Assertions.assertEquals(List.of(Integer.MAX_VALUE - 1), values);
    }
}

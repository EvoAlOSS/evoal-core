package de.evoal.optimisation.local_search.main.neighbour;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.ecore.info.BoundaryExtractor.Bound;
import de.evoal.core.api.ecore.info.BoundaryExtractor.Extracted;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
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
     * Creates the strategy with the fixed neighbour order. The values are pairs of
     *   feature and step size.
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

    /**
     * Creates the strategy with the random neighbour order of the given seed.
     */
    private ManualNeighbourChoosingStrategy randomStrategy(final long seed, final Space space, final Object... steps) throws Exception {
        final ManualNeighbourChoosingStrategy strategy = strategy(space, steps);
        inject(strategy, "random", RandomService.withSeed(seed).random(ManualNeighbourChoosingStrategy.NAME));
        return strategy;
    }

    private static List<List<Object>> valuesOf(final List<TypedEObject> neighbours, final EAttribute... features) {
        return neighbours.stream()
                         .map(neighbour -> Arrays.stream(features).map(neighbour::eGet).toList())
                         .toList();
    }

    @Nested
    @DisplayName("given two real features at the origin")
    class TwoRealFeatures {
        private EAttribute x;
        private EAttribute y;
        private Space space;
        private TypedEObject base;

        @BeforeEach
        public void setUp() {
            x = feature("x", EcorePackage.Literals.EDOUBLE);
            y = feature("y", EcorePackage.Literals.EDOUBLE);
            space = new Space(eClass);

            base = space.newEObject();
            base.eSet(x, 0.0);
            base.eSet(y, 0.0);
        }

        @Test
        public void allCombinationsExceptTheCandidateAreGenerated() throws Exception {
            // when
            final List<TypedEObject> neighbours = strategy(space, x, 0.5, y, 1.0).neighbours(base).toList();

            // then: 3^2 combinations without the unchanged candidate
            Assertions.assertEquals(8, neighbours.size());
            Assertions.assertTrue(neighbours.stream().noneMatch(n -> n.eGet(x).equals(0.0) && n.eGet(y).equals(0.0)));
        }

        @Test
        public void theFixedOrderEndsWithDecreasingAllFeatures() throws Exception {
            // when
            final List<TypedEObject> neighbours = strategy(space, x, 0.5, y, 1.0).neighbours(base).toList();

            // then
            Assertions.assertEquals(-0.5, neighbours.getLast().eGet(x));
            Assertions.assertEquals(-1.0, neighbours.getLast().eGet(y));
        }

        @Test
        public void theRandomOrderGeneratesTheSameNeighbours() throws Exception {
            // when
            final List<TypedEObject> fixed = strategy(space, x, 0.5, y, 1.0).neighbours(base).toList();
            final List<TypedEObject> random = randomStrategy(42, space, x, 0.5, y, 1.0).neighbours(base).toList();

            // then
            final Set<List<Object>> fixedValues = valuesOf(fixed, x, y).stream().collect(Collectors.toSet());
            final Set<List<Object>> randomValues = valuesOf(random, x, y).stream().collect(Collectors.toSet());
            Assertions.assertEquals(8, random.size());
            Assertions.assertEquals(fixedValues, randomValues);
        }

        @Test
        public void theRandomOrderChangesBetweenCalls() throws Exception {
            // given
            final ManualNeighbourChoosingStrategy strategy = randomStrategy(42, space, x, 0.5, y, 1.0);

            // when
            final List<List<Object>> first = valuesOf(strategy.neighbours(base).toList(), x, y);
            final List<List<Object>> second = valuesOf(strategy.neighbours(base).toList(), x, y);

            // then
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void theRandomOrderIsReproducibleWithTheSameSeed() throws Exception {
            // when
            final List<List<Object>> first = valuesOf(randomStrategy(42, space, x, 0.5, y, 1.0).neighbours(base).toList(), x, y);
            final List<List<Object>> second = valuesOf(randomStrategy(42, space, x, 0.5, y, 1.0).neighbours(base).toList(), x, y);

            // then
            Assertions.assertEquals(first, second);
        }
    }

    @Nested
    @DisplayName("given features of different types")
    class DifferentTypes {
        @Test
        public void valuesHaveTheTypeOfTheirFeature() throws Exception {
            // given
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

            // when
            final List<TypedEObject> neighbours = strategy(space, real, 0.1, single, 0.1f, integer, 2).neighbours(base).toList();

            // then
            neighbours.forEach(n -> {
                Assertions.assertInstanceOf(Double.class, n.eGet(real));
                Assertions.assertInstanceOf(Float.class, n.eGet(single));
                Assertions.assertInstanceOf(Integer.class, n.eGet(integer));
                Assertions.assertEquals(true, n.eGet(flag));
            });
        }
    }

    @Nested
    @DisplayName("given a candidate near its boundaries")
    class NearBoundaries {
        @Test
        public void neighboursOutsideOfTheBoundariesAreSkipped() throws Exception {
            // given
            final EAttribute x = feature("x", EcorePackage.Literals.EDOUBLE);
            FeatureBoundaries.annotate(x, new Extracted(Optional.of(new Bound(-1.0, true)), Optional.of(new Bound(1.0, false))));
            final Space space = new Space(eClass);

            final TypedEObject base = space.newEObject();
            base.eSet(x, 0.5);

            // when
            final List<Object> values = strategy(space, x, 0.5).neighbours(base).map(n -> n.eGet(x)).toList();

            // then: 1.0 is excluded by the upper boundary, 0.5 is the unchanged candidate
            Assertions.assertEquals(List.of(0.0), values);
        }

        @Test
        public void integerOverflowIsSkipped() throws Exception {
            // given
            final EAttribute n = feature("n", EcorePackage.Literals.EINT);
            final Space space = new Space(eClass);

            final TypedEObject base = space.newEObject();
            base.eSet(n, Integer.MAX_VALUE);

            // when
            final List<Object> values = strategy(space, n, 1).neighbours(base).map(o -> o.eGet(n)).toList();

            // then
            Assertions.assertEquals(List.of(Integer.MAX_VALUE - 1), values);
        }
    }
}

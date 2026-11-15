package de.evoal.core.main.fitness;

import de.evoal.core.api.ecore.info.BoundaryExtractor.Bound;
import de.evoal.core.api.ecore.info.BoundaryExtractor.Extracted;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.main.fitness.RandomFitness;
import org.eclipse.emf.ecore.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RandomFitnessTest {

    private Space space;
    private EAttribute feature1;
    private EAttribute feature2;
    private RandomFitness testee;

    @BeforeEach
    void setUp() throws Exception {
        final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("test");
        ePackage.setNsPrefix("tst");
        ePackage.setNsURI("urn:test");

        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        ePackage.getEClassifiers().add(eClass);

        feature1 = EcoreFactory.eINSTANCE.createEAttribute();
        feature1.setName("feature1");
        feature1.setEType(EcorePackage.eINSTANCE.getEInt());

        feature2 = EcoreFactory.eINSTANCE.createEAttribute();
        feature2.setName("feature2");
        feature2.setEType(EcorePackage.eINSTANCE.getEDouble());

        eClass.getEStructuralFeatures().add(feature1);
        eClass.getEStructuralFeatures().add(feature2);

        FeatureBoundaries.annotate(feature1, new Extracted(Optional.of(new Bound(-10, true)), Optional.of(new Bound(10, false))));
        FeatureBoundaries.annotate(feature2, new Extracted(Optional.of(new Bound(0.0, true)), Optional.of(new Bound(1.0, false))));

        space = new Space(eClass);

        testee = new RandomFitness();

        final Field specificationField = RandomFitness.class.getDeclaredField("optimisationSpace");
        specificationField.setAccessible(true);
        specificationField.set(testee, space);

        final Field boundariesField = RandomFitness.class.getDeclaredField("boundaries");
        boundariesField.setAccessible(true);
        boundariesField.set(testee, new FeatureBoundaries());
        final Field randomFieldtestee = RandomFitness.class.getDeclaredField("randomService");
        randomFieldtestee.setAccessible(true);
        randomFieldtestee.set(testee, RandomService.withSeed(42));

        testee.init(null);
    }

    @Test
    void testEvaluate_setsPlausibleValuesForAllFeatures() {
        final TypedEObject result = testee.evaluate(null);

        assertNotNull(result);

        final Object value1 = result.eGet(feature1);
        final Object value2 = result.eGet(feature2);

        assertInstanceOf(Integer.class, value1);
        final int intValue = (int) value1;
        assertTrue(intValue >= -10 && intValue < 10);

        assertInstanceOf(Double.class, value2);
        final double doubleValue = (double) value2;
        assertTrue(doubleValue >= 0.0 && doubleValue < 1.0);
    }

    @Test
    void testEvaluate_producesDifferentValuesBetweenCalls() {
        final TypedEObject result1 = testee.evaluate(null);
        final TypedEObject result2 = testee.evaluate(null);

        boolean areDifferent = false;
        for (final org.eclipse.emf.ecore.EStructuralFeature feature : space) {
            if (!result1.eGet(feature).equals(result2.eGet(feature))) {
                areDifferent = true;
                break;
            }
        }

        assertTrue(areDifferent, "Random values should differ between evaluations.");
    }

    @Test
    void testEvaluate_unboundedFeaturesUseTheRangeOfTheirType() throws Exception {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        final EAttribute real = EcoreFactory.eINSTANCE.createEAttribute();
        real.setName("real");
        real.setEType(EcorePackage.eINSTANCE.getEDouble());
        final EAttribute integer = EcoreFactory.eINSTANCE.createEAttribute();
        integer.setName("integer");
        integer.setEType(EcorePackage.eINSTANCE.getELong());
        final EAttribute flag = EcoreFactory.eINSTANCE.createEAttribute();
        flag.setName("flag");
        flag.setEType(EcorePackage.eINSTANCE.getEBoolean());
        eClass.getEStructuralFeatures().add(real);
        eClass.getEStructuralFeatures().add(integer);
        eClass.getEStructuralFeatures().add(flag);

        final RandomFitness fitness = new RandomFitness();
        final Field spaceField = RandomFitness.class.getDeclaredField("optimisationSpace");
        spaceField.setAccessible(true);
        spaceField.set(fitness, new Space(eClass));
        final Field boundariesField = RandomFitness.class.getDeclaredField("boundaries");
        boundariesField.setAccessible(true);
        boundariesField.set(fitness, new FeatureBoundaries());
        final Field randomFieldfitness = RandomFitness.class.getDeclaredField("randomService");
        randomFieldfitness.setAccessible(true);
        randomFieldfitness.set(fitness, RandomService.withSeed(42));
        fitness.init(null);

        final TypedEObject result = fitness.evaluate(null);
        assertTrue(Double.isFinite((double) result.eGet(real)));
        assertInstanceOf(Long.class, result.eGet(integer));
        assertInstanceOf(Boolean.class, result.eGet(flag));
    }
}

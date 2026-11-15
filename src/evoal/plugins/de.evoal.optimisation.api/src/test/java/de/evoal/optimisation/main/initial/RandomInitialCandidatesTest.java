package de.evoal.optimisation.main.initial;

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
import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

public class RandomInitialCandidatesTest {
    private final EClass eClass = EcoreFactory.eINSTANCE.createEClass();

    public RandomInitialCandidatesTest() {
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
        final Field field = RandomInitialCandidates.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    private List<TypedEObject> candidates(final long seed, final int count) throws Exception {
        final RandomInitialCandidates provider = new RandomInitialCandidates();
        inject(provider, "searchSpace", new Space(eClass));
        inject(provider, "boundaries", new FeatureBoundaries());
        inject(provider, "randomService", RandomService.withSeed(seed));
        return provider.create().limit(count).toList();
    }

    @Test
    public void allFeaturesGetValuesWithinTheirBoundaries() throws Exception {
        final EAttribute real = feature("real", EcorePackage.Literals.EDOUBLE);
        final EAttribute integer = feature("integer", EcorePackage.Literals.EINT);
        final EAttribute flag = feature("flag", EcorePackage.Literals.EBOOLEAN);
        FeatureBoundaries.annotate(real, new Extracted(Optional.of(new Bound(-5.12, true)), Optional.of(new Bound(5.12, true))));
        FeatureBoundaries.annotate(integer, new Extracted(Optional.of(new Bound(1, false)), Optional.of(new Bound(4, true))));

        for(final TypedEObject candidate : candidates(42, 100)) {
            final double r = (double) candidate.eGet(real);
            final int i = (int) candidate.eGet(integer);

            Assertions.assertTrue(-5.12 <= r && r <= 5.12, "real " + r);
            Assertions.assertTrue(2 <= i && i <= 4, "integer " + i);
            Assertions.assertInstanceOf(Boolean.class, candidate.eGet(flag));
        }
    }

    @Test
    public void unboundedFeaturesUseTheRangeOfTheirType() throws Exception {
        final EAttribute real = feature("real", EcorePackage.Literals.EDOUBLE);
        final EAttribute integer = feature("integer", EcorePackage.Literals.EINT);

        final TypedEObject candidate = candidates(42, 1).getFirst();

        Assertions.assertTrue(Double.isFinite((double) candidate.eGet(real)));
        Assertions.assertInstanceOf(Integer.class, candidate.eGet(integer));
    }

    @Test
    public void sameSeedSameCandidates() throws Exception {
        final EAttribute real = feature("real", EcorePackage.Literals.EDOUBLE);

        Assertions.assertEquals(candidates(7, 5).stream().map(c -> c.eGet(real)).toList(),
                                candidates(7, 5).stream().map(c -> c.eGet(real)).toList());
    }

    @Test
    public void longFeaturesAreRejected() {
        feature("big", EcorePackage.Literals.ELONG);

        Assertions.assertThrows(IllegalArgumentException.class, () -> candidates(42, 1));
    }
}

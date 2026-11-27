package de.evoal.optimisation.main.initial;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.BoundaryExtractor.Bound;
import de.evoal.core.api.ecore.info.BoundaryExtractor.Extracted;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.models.ModelCandidates;

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

    private RandomInitialCandidates provider(final long seed) throws Exception {
        return provider(seed, new DynamicEClassProvider());
    }

    private RandomInitialCandidates provider(final long seed, final DynamicEClassProvider dynamicClasses) throws Exception {
        final RandomInitialCandidates provider = new RandomInitialCandidates();
        final Space space = new Space(eClass);
        inject(provider, "searchSpace", space);
        inject(provider, "models", new ModelCandidates(space, new FeatureBoundaries(), dynamicClasses));
        inject(provider, "randomService", RandomService.withSeed(seed));
        return provider;
    }

    private List<TypedEObject> candidates(final long seed, final int count) throws Exception {
        return provider(seed).create().limit(count).toList();
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
    public void tabularValuesAreTheDrawsOfThePopulationStream() throws Exception {
        // given
        final EAttribute real = feature("real", EcorePackage.Literals.EDOUBLE);
        final EAttribute integer = feature("integer", EcorePackage.Literals.EINT);
        final EAttribute flag = feature("flag", EcorePackage.Literals.EBOOLEAN);
        FeatureBoundaries.annotate(real, new Extracted(Optional.of(new Bound(-5.12, true)), Optional.of(new Bound(5.12, true))));
        FeatureBoundaries.annotate(integer, new Extracted(Optional.of(new Bound(1, false)), Optional.of(new Bound(4, true))));

        // when
        final List<TypedEObject> candidates = candidates(42, 20);

        // then: the draws of the implementation before models were supported
        final RandomGenerator stream = RandomService.withSeed(42).random("de.evoal.optimisation.core.random-population");
        for(final TypedEObject candidate : candidates) {
            final double ratio = stream.nextDouble();
            Assertions.assertEquals(ratio * 5.12 + (1.0 - ratio) * -5.12, candidate.eGet(real));
            Assertions.assertEquals((int) stream.nextLong(2, 5), candidate.eGet(integer));
            Assertions.assertEquals(stream.nextBoolean(), candidate.eGet(flag));
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

    @Nested
    @DisplayName("given a search space with structured data of the policy types")
    class ModelSearchSpace {
        private final DynamicEClassProvider dynamicClasses = new DynamicEClassProvider();

        private EReference policy;

        private EClass grow;

        private EClass randomPopulation;

        @BeforeEach
        public void createSearchSpace() {
            final DefinitionModule types = LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/models/policy.dl");
            final ClassDefinition policyType = typeOf(types, "policy");

            policy = EcoreFactory.eINSTANCE.createEReference();
            policy.setName("policy");
            policy.setContainment(true);
            policy.setEType(dynamicClasses.toEClass(policyType));
            eClass.getEStructuralFeatures().add(policy);

            final DefinitionModule core = LanguageHelper.loadFromClasspath("de/evoal/optimisation/core.dl");
            grow = dynamicClasses.toEClass(typeOf(core, "grow"));
            randomPopulation = dynamicClasses.toEClass(typeOf(core, "random-population"));
        }

        private static ClassDefinition typeOf(final DefinitionModule module, final String name) {
            return module.getTypes()
                         .stream()
                         .filter(type -> name.equals(type.getName()))
                         .findFirst()
                         .orElseThrow();
        }

        /**
         * @return The population configured with grow and the depth limit, or without method.
         */
        private RandomInitialCandidates population(final Integer maximumDepth) throws Exception {
            final RandomInitialCandidates provider = provider(42, dynamicClasses);

            final EObject configuration = EcoreUtil.create(randomPopulation);
            if(maximumDepth != null) {
                final EObject method = EcoreUtil.create(grow);
                method.eSet(grow.getEStructuralFeature("maximum-depth"), maximumDepth);
                configuration.eSet(randomPopulation.getEStructuralFeature("method"), method);
            }
            provider.init(configuration);

            return provider;
        }

        @Test
        public void everyCandidateGetsAModel() throws Exception {
            // when
            final List<TypedEObject> candidates = population(5).create().limit(10).toList();

            // then
            for(final TypedEObject candidate : candidates) {
                final EObject model = Assertions.assertInstanceOf(EObject.class, candidate.eGet(policy));
                Assertions.assertEquals("policy", model.eClass().getName());
                // the candidate wraps the object of the search space class, which contains the model
                Assertions.assertSame(eClass, model.eContainer().eClass());
            }
        }

        @Test
        public void aMissingMethodIsRejected() throws Exception {
            // given
            final RandomInitialCandidates provider = population(null);

            // when
            final IllegalArgumentException error = Assertions.assertThrows(IllegalArgumentException.class, provider::create);

            // then
            Assertions.assertTrue(error.getMessage().contains("needs a 'method'"), error.getMessage());
        }

        @Test
        public void aDepthLimitBelowTheMinimalDepthIsRejected() throws Exception {
            // given
            final RandomInitialCandidates provider = population(4);

            // when
            final IllegalArgumentException error = Assertions.assertThrows(IllegalArgumentException.class, provider::create);

            // then
            Assertions.assertTrue(error.getMessage().contains("needs a depth of at least 5, but the 'method' allows 4"),
                                  error.getMessage());
        }
    }
}

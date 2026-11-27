package de.evoal.optimisation.api.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;

/**
 * The tree measures ({@link ModelTrees}), the attribute slots ({@link AttributeSlots}), the
 *   minimal trees ({@link ModelBuilder#buildMinimal}) and the minimal-subtree repair
 *   ({@link LimitRepairs}) on the policy types of the 2048 example and on recursive expressions.
 */
public class LimitRepairsTest {
    private static final int MODELS = 200;

    private final DynamicEClassProvider provider = new DynamicEClassProvider();

    private final ValueDrawer values = new ValueDrawer(new FeatureBoundaries());

    private final ModelTypeSource source = new ModelTypeSource() {
        @Override
        public List<EClass> concreteSubtypesOf(final EClass type) {
            return provider.concreteSubclassesOf(type);
        }

        @Override
        public boolean isOptional(final EStructuralFeature feature) {
            return DynamicEClassProvider.isOptional(feature);
        }
    };

    private static RandomGenerator randomness(final long seed) {
        return RandomService.withSeed(seed).random("de.evoal.optimisation.test.repairs");
    }

    private static ClassDefinition typeOf(final DefinitionModule module, final String name) {
        return module.getTypes()
                     .stream()
                     .filter(type -> name.equals(type.getName()))
                     .findFirst()
                     .orElseThrow(() -> new AssertionError("The module has no type '" + name + "'."));
    }

    private List<EObject> models(final ModelTypes types, final EClass root, final TreeMethod method, final Double optionalProbability,
                                 final long seed) {
        final BuildSettings settings = new BuildSettings(method, BuildSettings.NO_SIZE_LIMIT, optionalProbability);
        final ModelBuilder builder = new ModelBuilder(types, values, settings, randomness(seed));
        final List<EObject> models = new ArrayList<>();
        for(int i = 0; i < MODELS; i++) {
            models.add(builder.build(root, i));
        }

        return models;
    }

    @Nested
    @DisplayName("given the policy types of the 2048 example")
    class PolicyTypes {
        private EClass policy;

        private ModelTypes types;

        @BeforeEach
        public void loadTypes() {
            final DefinitionModule module = LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/models/policy.dl");
            policy = provider.toEClass(typeOf(module, "policy"));
            types = new ModelTypes(source, values, List.of(policy));
        }

        @Test
        public void sizeAndHeightCountTheObjectsAndTheDeepestOne() {
            // given
            final EObject model = models(types, policy, new TreeMethod.Grow(5), null, 1).getFirst();

            // then
            final List<EObject> objects = ModelTrees.objects(model);
            Assertions.assertSame(model, objects.getFirst());
            Assertions.assertEquals(objects.size(), ModelTrees.size(model));
            Assertions.assertEquals(5, ModelTrees.height(model));
            Assertions.assertEquals(objects.stream().mapToInt(object -> ModelTrees.depthOf(object, model)).max().orElseThrow(),
                                    ModelTrees.height(model));
            Assertions.assertEquals(policy.getEStructuralFeature("entries").getEType(), ModelTrees.typeOfPlace(objects.get(1)));
        }

        @Test
        public void theSlotsFollowThePreOrderAndTheAttributes() {
            // given
            final EObject model = models(types, policy, new TreeMethod.Grow(5), null, 2).getFirst();

            // when
            final List<AttributeSlots.Slot> slots = AttributeSlots.of(model, types::isOptional);

            // then: every attribute of the policy types is single-valued and required
            final int attributes = ModelTrees.objects(model)
                                             .stream()
                                             .mapToInt(object -> object.eClass().getEAllAttributes().size())
                                             .sum();
            Assertions.assertEquals(attributes, slots.size());
            Assertions.assertSame(model, slots.getFirst().object());
            Assertions.assertEquals("action", slots.getFirst().attribute().getName());

            final List<EObject> order = ModelTrees.objects(model);
            for(int i = 1; i < slots.size(); ++i) {
                Assertions.assertTrue(order.indexOf(slots.get(i - 1).object()) <= order.indexOf(slots.get(i).object()));
            }

            slots.getFirst().set(3);
            Assertions.assertEquals(3, model.eGet(policy.getEStructuralFeature("action")));
        }

        @Test
        public void aMinimalTreeHasTheMinimalSize() {
            // given
            final ModelBuilder minimal = ModelBuilder.minimal(types, values, randomness(3));

            // then
            for(int i = 0; i < 20; ++i) {
                Assertions.assertEquals(7, ModelTrees.size(minimal.buildMinimal(policy, 0, 5)));
            }
        }

        @Test
        public void theSizeRepairKeepsTheLimitAndTheMultiplicities() {
            // given
            final List<EObject> models = models(types, policy, new TreeMethod.Full(5), null, 4);
            final ModelBuilder minimal = ModelBuilder.minimal(types, values, randomness(5));
            final EStructuralFeature entries = policy.getEStructuralFeature("entries");

            // when / then
            boolean repairedOne = false;
            for(final EObject model : models) {
                final boolean wasTooLarge = ModelTrees.size(model) > 12;
                final EObject before = EcoreUtil.copy(model);

                Assertions.assertTrue(LimitRepairs.repairSize(model, 12, types, minimal));
                Assertions.assertTrue(ModelTrees.size(model) <= 12, "size " + ModelTrees.size(model));
                Assertions.assertFalse((((List<?>) model.eGet(entries)).isEmpty()));
                if(!wasTooLarge) {
                    Assertions.assertTrue(EcoreUtil.equals(before, model), "a model within the limit stays unchanged");
                }
                repairedOne |= wasTooLarge;
            }
            Assertions.assertTrue(repairedOne);
        }

        @Test
        public void theSizeRepairSavesNoMoreThanNeededIfOneChangeSuffices() {
            // given: a model one object above the limit
            final EObject model = models(types, policy, new TreeMethod.Grow(5), null, 6).stream()
                                                                                       .filter(candidate -> ModelTrees.size(candidate) > 14)
                                                                                       .findFirst()
                                                                                       .orElseThrow();
            final int limit = ModelTrees.size(model) - 1;

            // when
            Assertions.assertTrue(LimitRepairs.repairSize(model, limit, types, ModelBuilder.minimal(types, values, randomness(7))));

            // then: one change suffices, and the smallest one is applied; a model of more than 14
            // objects has a second entry (6 objects or more), so at most 6 objects are removed
            Assertions.assertTrue(ModelTrees.size(model) >= limit - 5, "size " + ModelTrees.size(model));
        }

        @Test
        public void theSizeRepairFailsBelowTheMinimalSize() {
            // given
            final EObject model = models(types, policy, new TreeMethod.Grow(5), null, 8).getFirst();

            // then
            Assertions.assertFalse(LimitRepairs.repairSize(model, 6, types, ModelBuilder.minimal(types, values, randomness(9))));
        }

        @Test
        public void theDepthRepairFailsIfTheRootCannotFit() {
            // given
            final EObject model = models(types, policy, new TreeMethod.Grow(5), null, 10).getFirst();

            // then
            Assertions.assertFalse(LimitRepairs.repairDepth(model, 4, types, ModelBuilder.minimal(types, values, randomness(11))));
        }
    }

    @Nested
    @DisplayName("given recursive expressions")
    class Expressions {
        private EClass expression;

        private ModelTypes types;

        @BeforeEach
        public void loadTypes() {
            final DefinitionModule negation = LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/models/negation.dl");
            expression = provider.toEClass(typeOf(negation, "negation").getSuperType());
            types = new ModelTypes(source, values, List.of(expression));
        }

        @Test
        public void theDepthRepairKeepsTheLimitAndTheObjectsAboveIt() {
            // given
            final List<EObject> models = models(types, expression, new TreeMethod.Full(7), 0.5, 12);

            // when / then
            for(final EObject model : models) {
                final ModelBuilder minimal = ModelBuilder.minimal(types, values, randomness(13));
                final EObject before = EcoreUtil.copy(model);

                Assertions.assertTrue(LimitRepairs.repairDepth(model, 3, types, minimal));
                Assertions.assertTrue(ModelTrees.height(model) <= 3, "height " + ModelTrees.height(model));

                // the root and the objects down to depth 2 keep their classes
                final List<String> kept = ModelTrees.objects(before)
                                                    .stream()
                                                    .filter(object -> ModelTrees.depthOf(object, before) <= 1)
                                                    .map(object -> object.eClass().getName())
                                                    .toList();
                final List<String> after = ModelTrees.objects(model)
                                                     .stream()
                                                     .filter(object -> ModelTrees.depthOf(object, model) <= 1)
                                                     .map(object -> object.eClass().getName())
                                                     .toList();
                Assertions.assertEquals(kept, after);
            }
        }

        @Test
        public void theRepairsAreDeterministicForASeed() {
            // given
            final List<EObject> first = models(types, expression, new TreeMethod.Full(6), 0.5, 14);
            final List<EObject> second = models(types, expression, new TreeMethod.Full(6), 0.5, 14);
            final ModelBuilder firstMinimal = ModelBuilder.minimal(types, values, randomness(15));
            final ModelBuilder secondMinimal = ModelBuilder.minimal(types, values, randomness(15));

            // when / then
            for(int i = 0; i < MODELS; ++i) {
                LimitRepairs.repairDepth(first.get(i), 2, types, firstMinimal);
                LimitRepairs.repairDepth(second.get(i), 2, types, secondMinimal);
                LimitRepairs.repairSize(first.get(i), 4, types, firstMinimal);
                LimitRepairs.repairSize(second.get(i), 4, types, secondMinimal);
                Assertions.assertTrue(EcoreUtil.equals(first.get(i), second.get(i)), "model " + i);
                Assertions.assertTrue(ModelTrees.size(first.get(i)) <= 4);
            }
        }

        @Test
        public void unsetOptionalAttributesAreNoSlots() {
            // given
            final List<EObject> models = models(types, expression, new TreeMethod.Grow(4), 0.5, 16);

            // then
            for(final EObject model : models) {
                for(final AttributeSlots.Slot slot : AttributeSlots.of(model, types::isOptional)) {
                    final EAttribute attribute = slot.attribute();
                    Assertions.assertTrue(!types.isOptional(attribute) || slot.object().eIsSet(attribute));
                    Assertions.assertNotNull(slot.get());
                }
            }
        }
    }
}

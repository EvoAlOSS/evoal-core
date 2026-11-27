package de.evoal.optimisation.api.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

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
import de.evoal.core.api.ecore.info.FeatureScales;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.dl.DefinitionModule;

public class ModelBuilderTest {
    /**
     * The number of models of the statistical tests.
     */
    private static final int MODELS = 400;

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

    /**
     * Within +-4 standard deviations of the binomial expectation, as the statistical tests of the
     *   operators (#302).
     */
    private static void assertBinomial(final long observed, final long trials, final double p, final String what) {
        final double expected = trials * p;
        final double sigma = Math.sqrt(trials * p * (1.0 - p));

        Assertions.assertTrue(Math.abs(observed - expected) <= 4.0 * sigma,
                              what + ": observed " + observed + " of " + trials + ", expected " + expected + " +- " + 4.0 * sigma);
    }

    /**
     * @return The objects of the model, the root first.
     */
    private static List<EObject> objectsOf(final EObject root) {
        final List<EObject> objects = new ArrayList<>();
        objects.add(root);
        root.eAllContents().forEachRemaining(objects::add);

        return objects;
    }

    /**
     * @return The depth of the object in its model; the root has depth 0.
     */
    private static int depthOf(final EObject object) {
        int depth = 0;
        for(EObject container = object.eContainer(); container != null; container = container.eContainer()) {
            depth++;
        }

        return depth;
    }

    private static int depthOfModel(final EObject root) {
        return objectsOf(root).stream()
                              .mapToInt(ModelBuilderTest::depthOf)
                              .max()
                              .orElse(0);
    }

    private static List<EObject> leavesOf(final EObject root) {
        return objectsOf(root).stream()
                              .filter(object -> object.eContents().isEmpty())
                              .toList();
    }

    private static RandomGenerator randomness(final long seed) {
        return RandomService.withSeed(seed).random("de.evoal.optimisation.test.builder");
    }

    private static ClassDefinition typeOf(final DefinitionModule module, final String name) {
        return module.getTypes()
                     .stream()
                     .filter(type -> name.equals(type.getName()))
                     .findFirst()
                     .orElseThrow(() -> new AssertionError("The module has no type '" + name + "'."));
    }

    private ModelBuilder builder(final ModelTypes types, final TreeMethod method, final long maximumSize,
                                 final Double optionalProbability, final long seed) {
        final BuildSettings settings = new BuildSettings(method, maximumSize, optionalProbability);

        return new ModelBuilder(types, values, settings, randomness(seed));
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

        private List<EObject> models(final TreeMethod method, final long maximumSize, final long seed) {
            final ModelBuilder builder = builder(types, method, maximumSize, null, seed);
            final List<EObject> models = new ArrayList<>();
            for(int i = 0; i < MODELS; i++) {
                models.add(builder.build(policy, i));
            }

            return models;
        }

        private List<EObject> objectsOfType(final List<EObject> models, final String name) {
            return models.stream()
                         .flatMap(model -> objectsOf(model).stream())
                         .filter(object -> name.equals(object.eClass().getName()))
                         .toList();
        }

        @Test
        public void theTypesCanBeBuilt() {
            // then
            Assertions.assertEquals(List.of(), types.problems());
            Assertions.assertFalse(types.hasOptionalFeatures());
        }

        @Test
        public void theMinimalDepthAndSizeFollowFromTheRequiredAttributes() {
            // then: policy > Entry > OrExpression > AndExpression > Comparison > operand
            Assertions.assertEquals(5, types.minimumDepth(policy));
            Assertions.assertEquals(7, types.minimumSize(policy));
            Assertions.assertEquals(5, types.maximumDepth(policy));
        }

        @Test
        public void modelsKeepTheMultiplicitiesAndTheBoundaries() {
            // when
            final List<EObject> models = models(new TreeMethod.Grow(5), BuildSettings.NO_SIZE_LIMIT, 42);

            // then
            for(final EObject model : models) {
                final List<?> entries = (List<?>) model.eGet(policy.getEStructuralFeature("entries"));
                Assertions.assertTrue(1 <= entries.size() && entries.size() <= 4, "entries " + entries.size());

                final int action = (int) model.eGet(policy.getEStructuralFeature("action"));
                Assertions.assertTrue(0 <= action && action <= 3, "action " + action);
            }

            for(final EObject and : objectsOfType(models, "AndExpression")) {
                final List<?> comparisons = (List<?>) and.eGet(and.eClass().getEStructuralFeature("comparisons"));
                Assertions.assertTrue(1 <= comparisons.size() && comparisons.size() <= 2, "comparisons " + comparisons.size());
            }

            for(final EObject call : objectsOfType(models, "scoreGain")) {
                final int direction = (int) call.eGet(call.eClass().getEStructuralFeature("direction"));
                Assertions.assertTrue(0 <= direction && direction <= 3, "direction " + direction);
            }
        }

        @Test
        public void theObjectsAreContainedInTheirModel() {
            // when
            final EObject model = models(new TreeMethod.Grow(5), BuildSettings.NO_SIZE_LIMIT, 7).getFirst();

            // then
            final List<?> entries = (List<?>) model.eGet(policy.getEStructuralFeature("entries"));
            final EObject entry = (EObject) entries.getFirst();
            Assertions.assertSame(model, entry.eContainer());

            final EObject copy = EcoreUtil.copy(model);
            Assertions.assertTrue(EcoreUtil.equals(model, copy));
            Assertions.assertEquals(objectsOf(model).size(), objectsOf(copy).size());
        }

        @Test
        public void theSameSeedGivesTheSameModels() {
            // when
            final List<EObject> first = models(new TreeMethod.RampedHalfAndHalf(5, 7), BuildSettings.NO_SIZE_LIMIT, 3);
            final List<EObject> second = models(new TreeMethod.RampedHalfAndHalf(5, 7), BuildSettings.NO_SIZE_LIMIT, 3);

            // then
            for(int i = 0; i < MODELS; i++) {
                Assertions.assertTrue(EcoreUtil.equals(first.get(i), second.get(i)), "model " + i);
            }
        }

        @Test
        public void concreteSubtypesAreChosenUniformly() {
            // when
            final List<EObject> models = models(new TreeMethod.Grow(5), BuildSettings.NO_SIZE_LIMIT, 11);

            // then
            final long integerComparisons = objectsOfType(models, "IntegerComparison").size();
            final long booleanComparisons = objectsOfType(models, "BooleanComparison").size();
            assertBinomial(integerComparisons, integerComparisons + booleanComparisons, 0.5, "integer comparisons");
        }

        @Test
        public void enumLiteralsAreChosenUniformly() {
            // when
            final List<EObject> comparisons = objectsOfType(models(new TreeMethod.Grow(5), BuildSettings.NO_SIZE_LIMIT, 13),
                                                            "IntegerComparison");

            // then
            final long less = comparisons.stream()
                                         .map(comparison -> comparison.eGet(comparison.eClass().getEStructuralFeature("operator")))
                                         .filter(literal -> "less".equals(literal.toString()))
                                         .count();
            assertBinomial(less, comparisons.size(), 0.5, "operator less");
        }

        @Test
        public void theSizeLimitIsKept() {
            // when
            final List<EObject> models = models(new TreeMethod.Grow(5), 12, 17);

            // then
            for(final EObject model : models) {
                final int size = objectsOf(model).size();
                Assertions.assertTrue(7 <= size && size <= 12, "size " + size);
            }

            final boolean hasLargerModels = models.stream().anyMatch(model -> objectsOf(model).size() > 7);
            Assertions.assertTrue(hasLargerModels);
        }
    }

    @Nested
    @DisplayName("given recursive expressions in two modules")
    class Expressions {
        private EClass expression;

        private ModelTypes types;

        @BeforeEach
        public void loadTypes() {
            final DefinitionModule negation = LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/models/negation.dl");
            final ClassDefinition negationType = typeOf(negation, "negation");
            expression = provider.toEClass(negationType.getSuperType());
            types = new ModelTypes(source, values, List.of(expression));
        }

        private List<EObject> models(final TreeMethod method, final double optionalProbability, final long seed) {
            final ModelBuilder builder = builder(types, method, BuildSettings.NO_SIZE_LIMIT, optionalProbability, seed);
            final List<EObject> models = new ArrayList<>();
            for(int i = 0; i < MODELS; i++) {
                models.add(builder.build(expression, i));
            }

            return models;
        }

        @Test
        public void theSubtypesComeFromAllLoadedModulesOrderedByQualifiedName() {
            // when
            final List<String> subtypes = types.concreteSubtypesOf(expression)
                                               .stream()
                                               .map(EClass::getName)
                                               .toList();

            // then
            Assertions.assertEquals(List.of("constant", "labelled", "plus", "variable", "negation"), subtypes);
            Assertions.assertTrue(types.hasOptionalFeatures());
            Assertions.assertEquals(ModelTypes.UNBOUNDED, types.maximumDepth(types.concreteSubtypesOf(expression).get(2)));
        }

        @Test
        public void growKeepsTheDepthLimit() {
            // when
            final List<EObject> models = models(new TreeMethod.Grow(4), 0.5, 19);

            // then
            for(final EObject model : models) {
                Assertions.assertTrue(depthOfModel(model) <= 4, "depth " + depthOfModel(model));
            }

            final boolean hasShallowModels = models.stream().anyMatch(model -> depthOfModel(model) < 4);
            Assertions.assertTrue(hasShallowModels);
        }

        @Test
        public void fullPutsEveryLeafAtTheDepthLimit() {
            // when
            final List<EObject> models = models(new TreeMethod.Full(3), 0.5, 23);

            // then
            for(final EObject model : models) {
                for(final EObject leaf : leavesOf(model)) {
                    Assertions.assertEquals(3, depthOf(leaf), "leaf " + leaf.eClass().getName());
                }
            }
        }

        @Test
        public void rampedHalfAndHalfAlternatesFullAndGrowOverTheDepths() {
            // given
            final TreeMethod method = new TreeMethod.RampedHalfAndHalf(1, 3);

            // when
            final List<EObject> models = models(method, 0.5, 29);

            // then
            for(int i = 0; i < MODELS; i++) {
                final TreeMethod.Plan plan = method.planFor(i);
                Assertions.assertEquals(1 + (i / 2) % 3, plan.depthLimit());

                final EObject model = models.get(i);
                if(plan.shape() == TreeMethod.Shape.FULL) {
                    Assertions.assertEquals(plan.depthLimit(), depthOfModel(model), "full model " + i);
                } else {
                    Assertions.assertTrue(depthOfModel(model) <= plan.depthLimit(), "grow model " + i);
                }
            }
        }

        @Test
        public void optionalAttributesAreSetWithTheirProbability() {
            // when
            final List<EObject> never = models(new TreeMethod.Grow(4), 0.0, 31);
            final List<EObject> sometimes = models(new TreeMethod.Grow(4), 0.3, 31);

            // then
            final List<EObject> neverLabelled = labelled(never);
            Assertions.assertTrue(neverLabelled.stream().noneMatch(object -> object.eIsSet(weightOf(object))));

            final List<EObject> sometimesLabelled = labelled(sometimes);
            final long weighted = sometimesLabelled.stream()
                                                   .filter(object -> object.eIsSet(weightOf(object)))
                                                   .count();
            assertBinomial(weighted, sometimesLabelled.size(), 0.3, "weights");
        }

        private List<EObject> labelled(final List<EObject> models) {
            return models.stream()
                         .flatMap(model -> objectsOf(model).stream())
                         .filter(object -> "labelled".equals(object.eClass().getName()))
                         .toList();
        }

        private EStructuralFeature weightOf(final EObject labelled) {
            return labelled.eClass().getEStructuralFeature("weight");
        }

        @Test
        public void numbersStayWithinTheirBoundariesAndHaveTheirScale() {
            // when
            final List<EObject> models = models(new TreeMethod.Grow(4), 0.5, 37);

            // then
            for(final EObject object : models.stream().flatMap(model -> objectsOf(model).stream()).toList()) {
                if("constant".equals(object.eClass().getName())) {
                    final double value = (double) object.eGet(object.eClass().getEStructuralFeature("value"));
                    Assertions.assertTrue(-1.0 <= value && value <= 1.0, "value " + value);
                }
            }

            final EClass constant = types.concreteSubtypesOf(expression).getFirst();
            final EClass variable = types.concreteSubtypesOf(expression).get(3);
            Assertions.assertEquals(ScaleType.CARDINAL, FeatureScales.scaleOf(constant.getEStructuralFeature("value")));
            Assertions.assertEquals(ScaleType.NOMINAL, FeatureScales.scaleOf(variable.getEStructuralFeature("index")));
        }
    }

    @Nested
    @DisplayName("given models that cannot be built")
    class BrokenModels {
        private DefinitionModule module;

        @BeforeEach
        public void loadTypes() {
            module = LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/models/broken.dl");
        }

        private String problemsOf(final String name) {
            final EClass root = provider.toEClass(typeOf(module, name));
            final ModelTypes types = new ModelTypes(source, values, List.of(root));

            return String.join("; ", types.problems());
        }

        @Test
        public void attributesWithoutRandomValuesAreReported() {
            Assertions.assertTrue(problemsOf("named").contains("'named.name' has the type EString"), problemsOf("named"));
        }

        @Test
        public void arraysWithoutMaximumAreReported() {
            Assertions.assertTrue(problemsOf("unbounded").contains("'unbounded.values' is an array without @MaximumNumberOfElements"),
                                  problemsOf("unbounded"));
        }

        @Test
        public void typesThatCannotEndAreReported() {
            Assertions.assertTrue(problemsOf("endless").contains("an object of endless cannot end"), problemsOf("endless"));
        }

        @Test
        public void abstractTypesWithoutConcreteSubtypeAreReported() {
            Assertions.assertTrue(problemsOf("holder").contains("the type nothing has no concrete subtype"), problemsOf("holder"));
        }

        @Test
        public void multiDimensionalArraysAreReported() {
            Assertions.assertTrue(problemsOf("matrix").contains("'matrix.rows' is a multi-dimensional array"), problemsOf("matrix"));
        }
    }
}

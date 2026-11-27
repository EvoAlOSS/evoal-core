package de.evoal.optimisation.ea.main.operators.model;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.AttributeSlots;
import de.evoal.optimisation.api.builder.AttributeSlots.Slot;
import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelTrees;
import de.evoal.optimisation.api.builder.TreeMethod;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.ModelSpace;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.DoubleChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.NodeSelection;
import de.evoal.optimisation.ea.main.operators.BitFlipMutation;
import de.evoal.optimisation.ea.main.operators.CreepMutation;
import de.evoal.optimisation.ea.main.operators.GaussianMutation;
import de.evoal.optimisation.ea.main.operators.PolynomialMutation;
import de.evoal.optimisation.ea.main.operators.RandomResetMutation;
import de.evoal.optimisation.ea.test.PolicyRotation;

/**
 * The value mutations on models and the structural operators of a model chromosome, on the
 *   policy types of the 2048 example and on recursive terms.
 */
public class ModelOperatorsTest {
    private static final int MODELS = 300;

    private static final String POLICY = "de/evoal/optimisation/ea/test/models/policy.dl";

    private static final String TERMS = "de/evoal/optimisation/ea/test/models/terms.dl";

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
     * @return The genes of the models, one model per genes.
     */
    private static List<ModelGenes> genes(final ModelChromosome chromosome, final List<EObject> models) {
        return models.stream()
                     .map(model -> new ModelGenes(new EObject[] {EcoreUtil.copy(model)}, chromosome.context()))
                     .toList();
    }

    /**
     * @return The values of the model in slot order.
     */
    private static List<Object> values(final EObject root, final ModelChromosome chromosome) {
        return AttributeSlots.of(root, chromosome.context().types()::isOptional)
                             .stream()
                             .map(Slot::get)
                             .toList();
    }

    /**
     * @return Whether every object of the model fits the type of its place.
     */
    private static boolean fitsItsPlaces(final EObject root) {
        return ModelTrees.objects(root)
                         .stream()
                         .skip(1)
                         .allMatch(object -> ModelTrees.typeOfPlace(object).isSuperTypeOf(object.eClass()));
    }

    /**
     * @return The number of elements of all arrays of the model.
     */
    private static int arrayElements(final EObject root) {
        return ModelArray.of(root).stream().mapToInt(array -> array.elements().size()).sum();
    }

    @Nested
    @DisplayName("given the policy types of the 2048 example")
    class PolicyTypes {
        private final ModelSpace space = new ModelSpace(POLICY, "policy", false);

        private final ModelChromosome chromosome = space.chromosome(BoundaryHandling.STICK);

        private final List<EObject> models = space.models(new TreeMethod.RampedHalfAndHalf(5, 5), null, MODELS, 1);

        @Test
        public void aValueMutationNeedsAnAttributeOfItsKind() {
            // then: the policy types have no real attribute, but booleans, ints and an ordinal enum
            Assertions.assertThrows(InitializationException.class, () -> new GaussianMutation(1.0, Double.NaN, 0.1).check(chromosome));
            Assertions.assertThrows(InitializationException.class, () -> new PolynomialMutation(1.0, Double.NaN, 20.0).check(chromosome));
            Assertions.assertDoesNotThrow(() -> new CreepMutation(1.0, Double.NaN, 1).check(chromosome));
            Assertions.assertDoesNotThrow(() -> new BitFlipMutation(1.0, Double.NaN).check(chromosome));
            Assertions.assertDoesNotThrow(() -> new RandomResetMutation(1.0, Double.NaN).check(chromosome));
        }

        @Test
        public void bitFlipInvertsOnlyBooleansWithTheGeneProbability() {
            // given
            final BitFlipMutation mutation = new BitFlipMutation(1.0, 0.3);
            final RandomGenerator random = ModelSpace.random(2);

            // when / then
            long booleans = 0;
            long flipped = 0;
            for(final ModelGenes genes : genes(chromosome, models)) {
                final EObject before = EcoreUtil.copy(genes.root(0));
                final List<Slot> slotsBefore = AttributeSlots.of(before, chromosome.context().types()::isOptional);
                mutation.mutate(genes, 0.3, random);
                final List<Slot> slotsAfter = AttributeSlots.of(genes.root(0), chromosome.context().types()::isOptional);

                Assertions.assertEquals(slotsBefore.size(), slotsAfter.size());
                for(int i = 0; i < slotsBefore.size(); ++i) {
                    final boolean isBoolean = slotsBefore.get(i).get() instanceof Boolean;
                    final boolean changed = !slotsBefore.get(i).get().equals(slotsAfter.get(i).get());
                    Assertions.assertTrue(isBoolean || !changed, "only booleans change");
                    booleans += isBoolean ? 1 : 0;
                    flipped += changed ? 1 : 0;
                }
                Assertions.assertEquals(genes.slots(slot -> slot.get() instanceof Boolean).size(), mutation.geneCount(genes));
            }
            assertBinomial(flipped, booleans, 0.3, "flipped booleans");
        }

        @Test
        public void creepMovesTheOrdinalEnumAlongItsLiterals() {
            // given: the integers are nominal, the operator of a comparison is ordinal (less, greater)
            final CreepMutation mutation = new CreepMutation(1.0, 1.0, 1);
            final RandomGenerator random = ModelSpace.random(3);

            // when / then
            for(final ModelGenes genes : genes(chromosome, models)) {
                final EObject before = EcoreUtil.copy(genes.root(0));
                mutation.mutate(genes, 1.0, random);
                chromosome.handleBoundaries(genes, BoundaryHandling.STICK);

                final List<Slot> slotsBefore = AttributeSlots.of(before, chromosome.context().types()::isOptional);
                final List<Slot> slotsAfter = AttributeSlots.of(genes.root(0), chromosome.context().types()::isOptional);
                for(int i = 0; i < slotsBefore.size(); ++i) {
                    final boolean isOperator = "operator".equals(slotsBefore.get(i).attribute().getName());
                    if(!isOperator) {
                        Assertions.assertEquals(slotsBefore.get(i).get(), slotsAfter.get(i).get());
                    } else {
                        // one step from less is greater, from greater the boundary handling sticks or steps back
                        final String after = slotsAfter.get(i).get().toString();
                        Assertions.assertTrue(Set.of("less", "greater").contains(after), after);
                    }
                }
            }
        }

        @Test
        public void randomResetKeepsTheBoundaries() {
            // given
            final RandomResetMutation mutation = new RandomResetMutation(1.0, 1.0);
            final RandomGenerator random = ModelSpace.random(4);

            // when / then
            for(final ModelGenes genes : genes(chromosome, models)) {
                mutation.mutate(genes, 1.0, random);
                for(final Slot slot : genes.slots(slot -> slot.get() instanceof Integer)) {
                    final int value = (Integer) slot.get();
                    Assertions.assertTrue(0 <= value && value <= 3, slot.attribute().getName() + " " + value);
                }
            }
        }

        @Test
        public void subtreeCrossoverExchangesFittingSubtreesAndKeepsTheCounts() {
            // given
            final SubtreeCrossover crossover = new SubtreeCrossover(1.0, NodeSelection.UNIFORM);
            final RandomGenerator random = ModelSpace.random(5);
            final List<ModelGenes> genes = genes(chromosome, models);

            // when / then
            int changed = 0;
            for(int i = 0; i + 1 < genes.size(); i += 2) {
                final ModelGenes a = genes.get(i);
                final ModelGenes b = genes.get(i + 1);
                final int objects = ModelTrees.size(a.root(0)) + ModelTrees.size(b.root(0));
                final EObject beforeA = EcoreUtil.copy(a.root(0));

                crossover.recombine(a, b, random);

                Assertions.assertTrue(fitsItsPlaces(a.root(0)) && fitsItsPlaces(b.root(0)));
                Assertions.assertEquals(objects, ModelTrees.size(a.root(0)) + ModelTrees.size(b.root(0)), "no object is lost");
                Assertions.assertEquals(((List<?>) beforeA.eGet(beforeA.eClass().getEStructuralFeature("entries"))).size(),
                                        ((List<?>) a.root(0).eGet(a.root(0).eClass().getEStructuralFeature("entries"))).size());
                changed += EcoreUtil.equals(beforeA, a.root(0)) ? 0 : 1;
            }
            Assertions.assertTrue(changed > 0);
            Assertions.assertDoesNotThrow(() -> crossover.check(chromosome));
            Assertions.assertThrows(InitializationException.class,
                                    () -> crossover.check(new DoubleChromosome(List.of(Candidates.real("x")), new double[] {0.0},
                                                                               new double[] {1.0})));
        }

        @Test
        public void arraySizeMutationChangesOneArrayByOneWithinItsMultiplicity() {
            // given
            final BuildSettings settings = new BuildSettings(new TreeMethod.Grow(5), BuildSettings.NO_SIZE_LIMIT, null);
            final ArraySizeMutation mutation = new ArraySizeMutation(1.0, settings);
            final RandomGenerator random = ModelSpace.random(6);

            // when / then
            for(final ModelGenes genes : genes(chromosome, models)) {
                final EObject before = EcoreUtil.copy(genes.root(0));
                mutation.mutate(genes, 1.0, random);

                // every policy has the resizable array of its entries, so every model changes
                Assertions.assertFalse(EcoreUtil.equals(before, genes.root(0)));
                Assertions.assertTrue(fitsItsPlaces(genes.root(0)));

                for(final ModelArray array : ModelArray.of(genes.root(0))) {
                    final EStructuralFeature feature = array.feature();
                    final int count = array.elements().size();
                    Assertions.assertTrue(feature.getLowerBound() <= count && count <= feature.getUpperBound(), feature.getName() + " " + count);
                }
            }
            Assertions.assertThrows(InitializationException.class, () -> new ArraySizeMutation(1.0, null).check(chromosome));
        }

        @Test
        public void arrayReorderSwapsTwoElements() {
            // given
            final ArrayReorderMutation mutation = new ArrayReorderMutation(1.0);
            final RandomGenerator random = ModelSpace.random(7);

            // when / then
            int changed = 0;
            for(final ModelGenes genes : genes(chromosome, models)) {
                final EObject before = EcoreUtil.copy(genes.root(0));
                mutation.mutate(genes, 1.0, random);

                Assertions.assertEquals(ModelTrees.size(before), ModelTrees.size(genes.root(0)));
                Assertions.assertEquals(arrayElements(before), arrayElements(genes.root(0)));
                final boolean hasLongArray = ModelArray.of(before).stream().anyMatch(array -> array.elements().size() >= 2);
                final boolean isChanged = !EcoreUtil.equals(before, genes.root(0));
                Assertions.assertTrue(isChanged || !hasLongArray || hasEqualElements(before));
                changed += isChanged ? 1 : 0;
            }
            Assertions.assertTrue(changed > 0);
        }

        /**
         * @return Whether an array of the model has two equal elements, so a swap may not change it.
         */
        private boolean hasEqualElements(final EObject root) {
            for(final ModelArray array : ModelArray.of(root)) {
                final List<Object> elements = array.elements();
                for(int i = 0; i < elements.size(); ++i) {
                    for(int j = i + 1; j < elements.size(); ++j) {
                        final Object first = elements.get(i);
                        final Object second = elements.get(j);
                        final boolean equal = first instanceof EObject a && second instanceof EObject b ? EcoreUtil.equals(a, b) : first.equals(second);
                        if(equal) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        @Test
        public void aPluginOperatorRotatesAllDirectionsTogether() {
            // given: the DL type of the plugin operator
            final DefinitionModule rotation = LanguageHelper.loadFromClasspath("de/evoal/optimisation/ea/test/rotation/rotation.dl");
            Assertions.assertEquals("policy-rotation", rotation.getTypes().getFirst().getName());

            final MutationOperator mutation = new PolicyRotation(1.0, Set.of("direction", "action"));
            final RandomGenerator random = ModelSpace.random(8);

            // when / then
            for(final ModelGenes genes : genes(chromosome, models)) {
                final List<Slot> before = genes.slots(slot -> Set.of("direction", "action").contains(slot.attribute().getName()));
                final List<Integer> old = before.stream().map(slot -> (Integer) slot.get()).toList();
                mutation.mutate(genes, 1.0, random);
                final List<Integer> rotated = genes.slots(slot -> Set.of("direction", "action").contains(slot.attribute().getName()))
                                                   .stream()
                                                   .map(slot -> (Integer) slot.get())
                                                   .toList();

                final int r = Math.floorMod(rotated.getFirst() - old.getFirst(), 4);
                Assertions.assertTrue(1 <= r && r <= 3);
                for(int i = 0; i < old.size(); ++i) {
                    Assertions.assertEquals((old.get(i) + r) % 4, rotated.get(i));
                }
            }
            Assertions.assertDoesNotThrow(() -> mutation.check(chromosome));
        }
    }

    @Nested
    @DisplayName("given recursive terms")
    class Terms {
        private final ModelSpace space = new ModelSpace(TERMS, "plus", true);

        private final ModelChromosome chromosome = space.chromosome(BoundaryHandling.BOUNCE);

        private final List<EObject> models = space.models(new TreeMethod.RampedHalfAndHalf(2, 6), null, MODELS, 11);

        @Test
        public void gaussianMutationChangesOnlyTheCardinalRealsWithOneOverN() {
            // given
            final GaussianMutation mutation = new GaussianMutation(1.0, Double.NaN, 0.2);
            final RandomGenerator random = ModelSpace.random(12);

            // when / then
            long changed = 0;
            long trials = 0;
            double expected = 0.0;
            for(final ModelGenes genes : genes(chromosome, models)) {
                final List<Object> before = values(genes.root(0), chromosome);
                final int n = mutation.geneCount(genes);
                Assertions.assertEquals(genes.slots(slot -> "value".equals(slot.attribute().getName())).size(), n);
                if(n == 0) {
                    continue;
                }

                mutation.mutate(genes, 1.0 / n, random);
                chromosome.handleBoundaries(genes, BoundaryHandling.BOUNCE);
                final List<Object> after = values(genes.root(0), chromosome);
                for(int i = 0; i < before.size(); ++i) {
                    final boolean isChanged = !before.get(i).equals(after.get(i));
                    Assertions.assertTrue(!isChanged || before.get(i) instanceof Double, "only reals change");
                    if(after.get(i) instanceof Double value) {
                        Assertions.assertTrue(-1.0 <= value && value <= 1.0, "value " + value);
                    }
                    changed += isChanged ? 1 : 0;
                }
                trials += n;
                expected += 1.0;
            }
            // one changed value per model on average
            assertBinomial(changed, trials, expected / trials, "changed reals");
        }

        @Test
        public void creepChangesTheOrdinalIntegersWithinTheirBoundaries() {
            // given
            final CreepMutation mutation = new CreepMutation(1.0, 1.0, 2);
            final RandomGenerator random = ModelSpace.random(13);

            // when / then
            for(final ModelGenes genes : genes(chromosome, models)) {
                mutation.mutate(genes, 1.0, random);
                chromosome.handleBoundaries(genes, BoundaryHandling.BOUNCE);
                for(final Slot slot : genes.slots(slot -> "index".equals(slot.attribute().getName()))) {
                    final int index = (Integer) slot.get();
                    Assertions.assertTrue(0 <= index && index <= 2, "index " + index);
                }
                for(final Slot slot : genes.slots(slot -> "weights".equals(slot.attribute().getName()))) {
                    // weights are nominal: creep leaves them alone, but they stay within their boundaries
                    final int weight = (Integer) slot.get();
                    Assertions.assertTrue(0 <= weight && weight <= 5, "weight " + weight);
                }
            }
        }

        @Test
        public void subtreeMutationReplacesANodeWithinTheLimitsOfItsMethod() {
            // given
            final BuildSettings settings = new BuildSettings(new TreeMethod.Grow(6), 40, null);
            final SubtreeMutation mutation = new SubtreeMutation(1.0, NodeSelection.UNIFORM, settings);
            final RandomGenerator random = ModelSpace.random(14);

            // when / then
            int rootReplaced = 0;
            for(final ModelGenes genes : genes(chromosome, models)) {
                final EObject root = genes.root(0);
                mutation.mutate(genes, 1.0, random);

                Assertions.assertTrue(fitsItsPlaces(genes.root(0)));
                Assertions.assertTrue(ModelTrees.height(genes.root(0)) <= 6, "height " + ModelTrees.height(genes.root(0)));
                Assertions.assertTrue(chromosome.context().rootTypes().getFirst().isSuperTypeOf(genes.root(0).eClass()));
                rootReplaced += genes.root(0) == root ? 0 : 1;
            }
            Assertions.assertTrue(rootReplaced > 0, "the root is a node, too");
            Assertions.assertDoesNotThrow(() -> mutation.check(chromosome));
        }

        @Test
        public void theInternalNodeProbabilityPrefersInnerNodes() {
            // given
            final NodeSelection selection = new NodeSelection(OptionalDouble.of(0.9));
            final RandomGenerator random = ModelSpace.random(15);

            // when
            long inner = 0;
            long trials = 0;
            for(final EObject model : models) {
                final List<EObject> nodes = ModelTrees.objects(model);
                final boolean hasBoth = nodes.stream().anyMatch(ModelTrees::isInner) && nodes.stream().anyMatch(node -> !ModelTrees.isInner(node));
                if(!hasBoth) {
                    continue;
                }
                inner += ModelTrees.isInner(selection.choose(nodes, random)) ? 1 : 0;
                ++trials;
            }

            // then
            assertBinomial(inner, trials, 0.9, "inner nodes");
        }

        @Test
        public void theGenesAndTheCandidatesShareNoObjects() {
            // given
            final EObject model = models.getFirst();
            final ModelGenes genes = chromosome.encode(space.input(EcoreUtil.copy(model)));

            // when
            new SubtreeMutation(1.0, NodeSelection.UNIFORM, new BuildSettings(new TreeMethod.Full(3), 20, null))
                    .mutate(genes, 1.0, ModelSpace.random(16));
            final List<EObject> decoded = new ArrayList<>();
            final var target = space.space().newEObject();
            chromosome.decode(genes, target);
            decoded.add((EObject) target.eGet(space.model()));

            // then
            Assertions.assertNotSame(genes.root(0), decoded.getFirst());
            Assertions.assertTrue(EcoreUtil.equals(genes.root(0), decoded.getFirst()));
        }
    }
}

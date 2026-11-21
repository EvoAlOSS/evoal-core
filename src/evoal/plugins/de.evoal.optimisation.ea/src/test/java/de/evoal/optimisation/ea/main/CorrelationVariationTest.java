package de.evoal.optimisation.ea.main;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.ecore.info.BoundaryExtractor;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.correlations.BuildingBlock;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.api.genotype.BinaryChromosome;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.DoubleChromosome;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.correlation.CorrelationTransfer;
import de.evoal.optimisation.ea.main.correlation.Linkage;
import de.evoal.optimisation.ea.main.operators.CorrelationAwareMutation;
import de.evoal.optimisation.ea.main.operators.GaussianMutation;
import de.evoal.optimisation.ea.main.operators.LinkageCrossover;
import de.evoal.optimisation.ea.main.operators.SbxCrossover;
import de.evoal.optimisation.ea.main.operators.SinglePointCrossover;
import de.evoal.optimisation.ea.main.operators.UniformCrossover;
import de.evoal.optimisation.ea.main.statistics.LinkageStatistics;

/**
 * The correlation-aware operators in the {@link Variation}: x lives in a double chromosome,
 *   y in a Gray chromosome; x and y are correlated with rho = 1 or form a building block.
 */
public class CorrelationVariationTest {
    private final EAttribute x = bounded(Candidates.real("x"), -1.0, 1.0);
    private final EAttribute y = bounded(Candidates.real("y"), -1.0, 1.0);
    private final Space space = Candidates.space(x, y);
    private final Genotype genotype = new Genotype(List.of(new DoubleChromosome(List.of(x), new double[] {-1.0}, new double[] {1.0}),
                                                           new BinaryChromosome(List.of(y), new BinaryChromosome.Kind[] {BinaryChromosome.Kind.REAL},
                                                                                new double[] {-1.0}, new double[] {1.0}, 16, true)),
                                                   space);
    private final CorrelationTransfer transfer = new CorrelationTransfer(
            List.of(new Correlation(1, x, y, 1.0, null, null, CorrelationKind.LINEAR)), 0.0, new FeatureBoundaries(), "test");
    private final Linkage linkage = new Linkage(transfer.correlations());

    private static EAttribute bounded(final EAttribute feature, final double lower, final double upper) {
        FeatureBoundaries.annotate(feature, new BoundaryExtractor.Extracted(Optional.of(new BoundaryExtractor.Bound(lower, true)),
                                                                            Optional.of(new BoundaryExtractor.Bound(upper, true))));
        return feature;
    }

    private Candidate parent(final double xValue, final double yValue) {
        final TypedEObject input = space.newEObject();
        input.eSet(x, xValue);
        input.eSet(y, yValue);

        return Candidate.evaluated(input, Candidates.withFitness(0.0).evaluation(), Lineage.NONE);
    }

    @Test
    public void aMutationOfXIsPropagatedToYInTheOtherChromosome() {
        // given: the gaussian mutation only changes the chromosome of x
        final MutationOperator mutation = new CorrelationAwareMutation(new GaussianMutation(1.0, 1.0, 0.2), transfer, 1);
        final OperatorPlan plan = new OperatorPlan(List.of(),
                                                   List.of(new OperatorUse<>(mutation, List.of(0), "test/mutation")));
        final Variation variation = new Variation(genotype, plan, BoundaryHandling.STICK, RandomService.withSeed(5));
        final Candidate parent = parent(0.0, 0.0);
        final Offspring child = new Offspring(genotype.encode(parent.input()), List.of(parent), null);

        // when
        variation.mutate(child);
        final Candidate candidate = variation.toCandidate(child);

        // then: y follows x (up to the precision of the Gray code)
        final double xValue = (Double) candidate.input().eGet(x);
        final double yValue = (Double) candidate.input().eGet(y);
        Assertions.assertNotEquals(0.0, xValue);
        Assertions.assertEquals(xValue, yValue, 2.0 / 65535);
        Assertions.assertEquals(List.of("x"), candidate.lineage().properties().get(Variation.PRIMARY_FEATURES));
        Assertions.assertEquals(List.of("y from x (1.0)"), candidate.lineage().properties().get(Variation.PROPAGATED_FEATURES));
        Assertions.assertEquals(List.of("correlation-aware-mutation(gaussian-mutation)"),
                                candidate.lineage().properties().get(Variation.OPERATORS));
    }

    @Test
    public void aLinkageCrossoverKeepsXAndYFromTheSameParent() {
        // given: the uniform crossover only exchanges the chromosome of x
        final RecombinationOperator crossover = new LinkageCrossover(new UniformCrossover(1.0, 1.0), linkage);
        final OperatorPlan plan = new OperatorPlan(List.of(new OperatorUse<>(crossover, List.of(0), "test/recombination")),
                                                   List.of());
        final Variation variation = new Variation(genotype, plan, BoundaryHandling.STICK, RandomService.withSeed(5));

        // when
        final List<Offspring> children = variation.recombine(parent(0.5, 0.5), parent(-0.5, -0.5));
        final Candidate a = variation.toCandidate(children.get(0));
        final Candidate b = variation.toCandidate(children.get(1));

        // then: x was exchanged, so y follows
        Assertions.assertEquals(-0.5, (Double) a.input().eGet(x));
        Assertions.assertEquals(-0.5, (Double) a.input().eGet(y), 2.0 / 65535);
        Assertions.assertEquals(0.5, (Double) b.input().eGet(y), 2.0 / 65535);
        Assertions.assertEquals(List.of("y with x"), a.lineage().properties().get(Variation.LINKED_FEATURES));
    }

    @Test
    public void aLinkageCrossoverKeepsABuildingBlockFromTheSameParent() {
        // given: x and y form a building block, and the uniform crossover only exchanges the chromosome of x
        final Linkage block = new Linkage(List.of(new BuildingBlock(1, List.of(x, y))));
        final RecombinationOperator crossover = new LinkageCrossover(new UniformCrossover(1.0, 1.0), block);
        final OperatorPlan plan = new OperatorPlan(List.of(new OperatorUse<>(crossover, List.of(0), "test/recombination")),
                                                   List.of());
        final Variation variation = new Variation(genotype, plan, BoundaryHandling.STICK, RandomService.withSeed(5));

        // when
        final List<Offspring> children = variation.recombine(parent(0.5, 0.5), parent(-0.5, -0.5));
        final Candidate a = variation.toCandidate(children.get(0));
        final Candidate b = variation.toCandidate(children.get(1));

        // then: x was exchanged, so y follows
        Assertions.assertEquals(-0.5, (Double) a.input().eGet(y), 2.0 / 65535);
        Assertions.assertEquals(0.5, (Double) b.input().eGet(y), 2.0 / 65535);
        Assertions.assertEquals(List.of("y with x"), a.lineage().properties().get(Variation.LINKED_FEATURES));
    }

    @Test
    public void onlyCrossoversThatExchangeGenesCanBeLinked() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LinkageCrossover(new SbxCrossover(1.0, 15.0), linkage));
        Assertions.assertDoesNotThrow(() -> new LinkageCrossover(new SinglePointCrossover(1.0), linkage));
    }

    @Test
    public void theLinkageStatisticsCountTheBuildingBlockBeforeAndAfterTheLinkageStep() {
        // given: x and y form a building block; the uniform crossover exchanges x, the linkage step brings y along
        final BuildingBlock block = new BuildingBlock(1, List.of(x, y));
        final LinkageStatistics statistics = new LinkageStatistics();
        statistics.setUp(List.of(block));
        final RecombinationOperator crossover = new LinkageCrossover(new UniformCrossover(1.0, 1.0), new Linkage(List.of(block)));
        final OperatorPlan plan = new OperatorPlan(List.of(new OperatorUse<>(crossover, List.of(0), "test/recombination")),
                                                   List.of());
        final Variation variation = new Variation(genotype, plan, BoundaryHandling.STICK, RandomService.withSeed(5), statistics);

        // when
        variation.recombine(parent(0.5, 0.5), parent(-0.5, -0.5));
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        statistics.contributeTo(iteration);

        // then: both children are counted, preserved after the linkage step, not before it
        Assertions.assertEquals(2L, iteration.getMetrics().get(LinkageStatistics.CHILDREN + "building-block-1"));
        Assertions.assertEquals(2L, iteration.getMetrics().get(LinkageStatistics.PRESERVED + "building-block-1"));
        Assertions.assertEquals(0L, iteration.getMetrics().get(LinkageStatistics.PRESERVED_BEFORE + "building-block-1"));
    }

    @Test
    public void aRecombinationThatDoesNotFireIsNotCounted() {
        final BuildingBlock block = new BuildingBlock(1, List.of(x, y));
        final LinkageStatistics statistics = new LinkageStatistics();
        statistics.setUp(List.of(block));
        final RecombinationOperator crossover = new UniformCrossover(0.0, 1.0);
        final OperatorPlan plan = new OperatorPlan(List.of(new OperatorUse<>(crossover, List.of(0), "test/recombination")),
                                                   List.of());
        final Variation variation = new Variation(genotype, plan, BoundaryHandling.STICK, RandomService.withSeed(5), statistics);

        variation.recombine(parent(0.5, 0.5), parent(-0.5, -0.5));
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        statistics.contributeTo(iteration);

        Assertions.assertEquals(0L, iteration.getMetrics().get(LinkageStatistics.CHILDREN + "building-block-1"));
    }

    @Test
    public void aFeatureOfAGrayChromosomeIsAnAnchorAlthoughTheParentLiesOffItsGrid() {
        // given: y (Gray, 16 bits) comes first in the building block; 0.5 is not on the grid of y.
        // The uniform crossover only exchanges the chromosome of x, so y of the first child comes from the first parent.
        final Linkage block = new Linkage(List.of(new BuildingBlock(1, List.of(y, x))));
        final RecombinationOperator crossover = new LinkageCrossover(new UniformCrossover(1.0, 1.0), block);
        final OperatorPlan plan = new OperatorPlan(List.of(new OperatorUse<>(crossover, List.of(0), "test/recombination")),
                                                   List.of());
        final Variation variation = new Variation(genotype, plan, BoundaryHandling.STICK, RandomService.withSeed(5));

        // when
        final List<Offspring> children = variation.recombine(parent(0.5, 0.5), parent(-0.5, -0.5));
        final Candidate a = variation.toCandidate(children.get(0));

        // then: y anchors the building block, so x returns to the value of the first parent and the child keeps its
        // genome (without the anchor, x would anchor and y would come from the second parent)
        Assertions.assertEquals(0.5, (Double) a.input().eGet(x));
        Assertions.assertEquals(0.5, (Double) a.input().eGet(y), 2.0 / 65535);
        Assertions.assertNull(a.lineage().properties().get(Variation.OPERATORS));
    }
}

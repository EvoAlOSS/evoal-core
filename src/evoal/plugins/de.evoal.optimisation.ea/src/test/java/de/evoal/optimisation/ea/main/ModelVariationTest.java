package de.evoal.optimisation.ea.main;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.builder.TreeMethod;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.ModelSpace;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.DoubleChromosome;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.NodeSelection;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.operators.GaussianMutation;
import de.evoal.optimisation.ea.main.operators.RandomResetMutation;
import de.evoal.optimisation.ea.main.operators.model.SubtreeCrossover;

/**
 * The variation of a genotype that combines a model chromosome (a 2048 policy) with a double
 *   chromosome.
 */
public class ModelVariationTest {
    private final EAttribute x = Candidates.real("x");

    private final ModelSpace space = new ModelSpace("de/evoal/optimisation/ea/test/models/policy.dl", "policy", false, x);

    private final ModelChromosome models = space.chromosome(BoundaryHandling.STICK);

    private final Genotype genotype = new Genotype(List.of(models, new DoubleChromosome(List.of(x), new double[] {-1.0}, new double[] {1.0})),
                                                   space.space());

    private final List<EObject> policies = space.models(new TreeMethod.Grow(5), null, 20, 1);

    private Candidate parent(final int index, final double value) {
        final TypedEObject input = space.input(EcoreUtil.copy(policies.get(index)));
        input.eSet(x, value);

        return Candidate.evaluated(input, Candidates.withFitness(0.0).evaluation(), Lineage.NONE);
    }

    private Variation variation(final double crossover, final double modelMutation, final double realMutation) {
        final OperatorPlan plan = new OperatorPlan(
                List.<OperatorUse<RecombinationOperator>>of(new OperatorUse<>(new SubtreeCrossover(crossover, NodeSelection.UNIFORM), 0, "test/r")),
                List.<OperatorUse<MutationOperator>>of(new OperatorUse<>(new RandomResetMutation(modelMutation, Double.NaN), 0, "test/m0"),
                                                       new OperatorUse<>(new GaussianMutation(realMutation, 1.0, 0.1), 1, "test/m1")));

        return new Variation(genotype, plan, BoundaryHandling.STICK, RandomService.withSeed(5));
    }

    @Test
    public void aModelChildNamesTheModelAsChangedFeatureAndLeavesItsParentsAlone() {
        // given
        final Variation variation = variation(1.0, 0.0, 0.0);
        final Candidate first = parent(0, 0.1);
        final Candidate second = parent(1, 0.2);
        final EObject firstPolicy = EcoreUtil.copy((EObject) first.input().eGet(space.model()));

        // when
        final Candidate child = variation.toCandidate(variation.recombine(first, second).getFirst());

        // then
        Assertions.assertEquals(Lineage.Kind.RECOMBINATION, child.lineage().kind());
        Assertions.assertEquals(List.of("model"), child.lineage().properties().get(Variation.CHANGED_FEATURES));
        Assertions.assertEquals(0.1, child.input().eGet(x));
        Assertions.assertTrue(EcoreUtil.equals(firstPolicy, (EObject) first.input().eGet(space.model())), "the parent is unchanged");
        Assertions.assertNotSame(first.input().eGet(space.model()), child.input().eGet(space.model()));
    }

    @Test
    public void bothChromosomesAreMutated() {
        // given
        final Variation variation = variation(0.0, 1.0, 1.0);
        final Candidate first = parent(2, 0.1);

        // when
        final Offspring child = variation.recombine(first, parent(3, 0.2)).getFirst();
        variation.mutate(child);
        final Candidate candidate = variation.toCandidate(child);

        // then: the real gene changes for sure, the model with one reset value on average
        Assertions.assertEquals(Lineage.Kind.MUTATION, candidate.lineage().kind());
        Assertions.assertTrue(((List<?>) candidate.lineage().properties().get(Variation.CHANGED_FEATURES)).contains("x"));
        Assertions.assertEquals(0.1, first.input().eGet(x));
    }

    @Test
    public void anUnchangedModelChildIsACopy() {
        // given
        final Variation variation = variation(0.0, 0.0, 0.0);
        final Candidate first = parent(4, 0.1);

        // when
        final Offspring child = variation.recombine(first, parent(5, 0.2)).getFirst();
        variation.mutate(child);

        // then
        Assertions.assertEquals(Lineage.identity(first), variation.toCandidate(child).lineage());
    }
}

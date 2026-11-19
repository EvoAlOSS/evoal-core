package de.evoal.optimisation.ea.main;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.DoubleChromosome;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.operators.GaussianMutation;
import de.evoal.optimisation.ea.main.operators.SinglePointCrossover;

public class VariationTest {
    private final EAttribute x = Candidates.real("x");
    private final EAttribute y = Candidates.real("y");
    private final Space space = Candidates.space(x, y);
    private final Genotype genotype = new Genotype(List.of(new DoubleChromosome(List.of(x, y), new double[] {-1.0, -1.0},
                                                                                new double[] {1.0, 1.0})),
                                                   space);

    private Candidate parent(final double xValue, final double yValue) {
        final TypedEObject input = space.newEObject();
        input.eSet(x, xValue);
        input.eSet(y, yValue);
        final Evaluation evaluation = Candidates.withFitness(0.0).evaluation();

        return Candidate.evaluated(input, evaluation, Lineage.NONE);
    }

    private Variation variation(final double crossoverProbability, final double mutationProbability) {
        final OperatorPlan plan = new OperatorPlan(
                List.<OperatorUse<RecombinationOperator>>of(new OperatorUse<>(new SinglePointCrossover(crossoverProbability), List.of(0), "test/recombination")),
                List.<OperatorUse<MutationOperator>>of(new OperatorUse<>(new GaussianMutation(mutationProbability, 1.0, 0.1), List.of(0), "test/mutation")));

        return new Variation(genotype, plan, BoundaryHandling.STICK, RandomService.withSeed(3));
    }

    @Test
    public void anUnchangedChildIsACopyOfItsParent() {
        // given
        final Variation variation = variation(0.0, 0.0);
        final Candidate first = parent(0.1, 0.2);

        // when
        final Offspring child = variation.recombine(first, parent(0.3, 0.4)).getFirst();
        variation.mutate(child);
        final Candidate candidate = variation.toCandidate(child);

        // then
        Assertions.assertEquals(Lineage.identity(first), candidate.lineage());
        Assertions.assertTrue(candidate.isEvaluated());
    }

    @Test
    public void aRecombinedChildRefersToBothParentsAndShareItsPairWithTheSibling() {
        // given
        final Variation variation = variation(1.0, 0.0);
        final Candidate first = parent(0.1, 0.2);
        final Candidate second = parent(0.3, 0.4);

        // when
        final List<Offspring> children = variation.recombine(first, second);
        final Candidate a = variation.toCandidate(children.get(0));
        final Candidate b = variation.toCandidate(children.get(1));

        // then: two genes, so the cut lies between x and y
        Assertions.assertEquals(Lineage.Kind.RECOMBINATION, a.lineage().kind());
        Assertions.assertEquals(List.of(first, second), a.lineage().predecessors());
        Assertions.assertEquals(List.of(second, first), b.lineage().predecessors());
        Assertions.assertSame(a.lineage().pair(), b.lineage().pair());
        Assertions.assertEquals(List.of("single-point-crossover"), a.lineage().properties().get(Variation.OPERATORS));
        Assertions.assertEquals(List.of("y"), a.lineage().properties().get(Variation.CHANGED_FEATURES));
        Assertions.assertEquals(0.1, a.input().eGet(x));
        Assertions.assertEquals(0.4, a.input().eGet(y));
        Assertions.assertFalse(a.isEvaluated());
    }

    @Test
    public void aMutatedChildRefersToItsParent() {
        // given
        final Variation variation = variation(0.0, 1.0);
        final Candidate first = parent(0.1, 0.2);

        // when
        final Offspring child = variation.recombine(first, parent(0.3, 0.4)).getFirst();
        variation.mutate(child);
        final Candidate candidate = variation.toCandidate(child);

        // then
        Assertions.assertEquals(Lineage.Kind.MUTATION, candidate.lineage().kind());
        Assertions.assertEquals(List.of(first), candidate.lineage().predecessors());
        Assertions.assertEquals(List.of("gaussian-mutation"), candidate.lineage().properties().get(Variation.OPERATORS));
        Assertions.assertEquals(List.of("x", "y"), candidate.lineage().properties().get(Variation.CHANGED_FEATURES));
    }

    @Test
    public void theVariationIsReproducible() {
        final Candidate first = parent(0.1, 0.2);
        final Candidate second = parent(0.3, 0.4);

        final Variation one = variation(0.5, 0.5);
        final Variation two = variation(0.5, 0.5);
        for(int i = 0; i < 20; ++i) {
            final Offspring a = one.recombine(first, second).getFirst();
            final Offspring b = two.recombine(first, second).getFirst();
            one.mutate(a);
            two.mutate(b);

            Assertions.assertEquals(a.genome().toString(), b.genome().toString());
        }
    }
}

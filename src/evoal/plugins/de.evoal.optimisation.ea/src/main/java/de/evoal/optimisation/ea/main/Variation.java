package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import de.evoal.core.api.random.RandomService;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.Genome;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.operators.CorrelationAwareMutation;
import de.evoal.optimisation.ea.main.operators.LinkageCrossover;

/**
 * Recombines and mutates the genomes of one run, following the probability rules of the
 *   EA:
 * <ul>
 *   <li>a recombination is applied to a pair with its probability, one draw per pair and
 *     use, and then changes every chromosome of the use;</li>
 *   <li>a mutation is applied to a child with its probability, one draw per child and use,
 *     and then changes every gene of the chromosomes of the use with the gene probability
 *     (default 1 / n, n the number of these genes);</li>
 *   <li>the uses are applied in the order of the {@link OperatorPlan}; after every use, the
 *     boundary handling brings the genes back into their boundaries.</li>
 * </ul>
 * Every use draws from its own named stream of the {@link RandomService}, so the variation
 *   does not depend on the number of threads.
 * <p>
 * A child becomes a candidate with the properties {@code operators} (the operators that
 *   changed its genome) and {@code changed-features} (the features whose genes differ from
 *   the parent whose place it takes). A child that was recombined refers to both parents and
 *   its sibling, a child that was only mutated to its parent, and a child without changes is
 *   a copy of its parent and keeps the evaluation.
 * <p>
 * A mutation that fires first chooses the mutation to apply
 *   ({@link MutationOperator#choose}); the property {@code operators} names the chosen one.
 * <p>
 * A {@link CorrelationAwareMutation} propagates its change to correlated features after the
 *   use (properties {@code primary-features} and {@code propagated-features}); a
 *   {@link LinkageCrossover} keeps the features of building blocks and correlated pairs of both
 *   children together after the use (property {@code linked-features}).
 */
final class Variation {
    /**
     * The name of the property with the operators.
     */
    static final String OPERATORS = "operators";

    /**
     * The name of the property with the changed features.
     */
    static final String CHANGED_FEATURES = "changed-features";

    /**
     * The name of the property with the features that a correlation-aware mutation changed
     *   itself.
     */
    static final String PRIMARY_FEATURES = "primary-features";

    /**
     * The name of the property with the changes that a correlation-aware mutation propagated.
     */
    static final String PROPAGATED_FEATURES = "propagated-features";

    /**
     * The name of the property with the features that a linkage crossover set.
     */
    static final String LINKED_FEATURES = "linked-features";

    private final BoundaryHandling boundaryHandling;

    private final Genotype genotype;

    private final List<OperatorUse<MutationOperator>> mutations;
    private final List<RandomGenerator> mutationRandom = new ArrayList<>();

    private final List<OperatorUse<RecombinationOperator>> recombinations;
    private final List<RandomGenerator> recombinationRandom = new ArrayList<>();

    /**
     * @param genotype The genotype.
     * @param plan The operators.
     * @param boundaryHandling Brings the genes back into their boundaries.
     * @param random Gives the random streams of the current run.
     */
    Variation(final Genotype genotype, final OperatorPlan plan, final BoundaryHandling boundaryHandling,
              final RandomService random) {
        this.genotype = genotype;
        this.boundaryHandling = boundaryHandling;
        this.recombinations = plan.recombinations();
        this.mutations = plan.mutations();

        recombinations.forEach(use -> recombinationRandom.add(random.random(use.stream())));
        mutations.forEach(use -> mutationRandom.add(random.random(use.stream())));
    }

    /**
     * Recombines a pair of parents into two children.
     */
    List<Offspring> recombine(final Candidate first, final Candidate second) {
        final Object pair = new Object();
        final Offspring a = new Offspring(genotype.encode(first.input()), List.of(first, second), pair);
        final Offspring b = new Offspring(genotype.encode(second.input()), List.of(second, first), pair);

        for(int u = 0; u < recombinations.size(); ++u) {
            final OperatorUse<RecombinationOperator> use = recombinations.get(u);
            final RandomGenerator random = recombinationRandom.get(u);

            if(random.nextDouble() >= use.operator().probability()) {
                continue;
            }

            final Genome beforeA = a.genome.copy();
            final Genome beforeB = b.genome.copy();
            for(final int c : use.chromosomes()) {
                final Genes genesA = a.genome.chromosomes().get(c);
                final Genes genesB = b.genome.chromosomes().get(c);
                use.operator().recombine(genesA, genesB, random);
                genotype.chromosomes().get(c).handleBoundaries(genesA, boundaryHandling);
                genotype.chromosomes().get(c).handleBoundaries(genesB, boundaryHandling);
            }

            if(use.operator() instanceof LinkageCrossover crossover) {
                link(crossover, a, b, first, second);
            }

            noteChange(a, beforeA, use.operator().name(), true);
            noteChange(b, beforeB, use.operator().name(), true);
        }

        return List.of(a, b);
    }

    /**
     * Redoes the variation of a child: recombines its parents again and keeps the child in
     *   the place of the same parent, then mutates it. The draws continue the streams.
     *
     * @return The new child; its sibling is not recreated.
     */
    Offspring revary(final Offspring child) {
        final Offspring again = recombine(child.parents.get(0), child.parents.get(1)).getFirst();
        mutate(again);

        return again;
    }

    /**
     * Mutates a child.
     */
    void mutate(final Offspring child) {
        for(int u = 0; u < mutations.size(); ++u) {
            final OperatorUse<MutationOperator> use = mutations.get(u);
            final RandomGenerator random = mutationRandom.get(u);

            if(random.nextDouble() >= use.operator().probability()) {
                continue;
            }

            final MutationOperator mutation = use.operator().choose(random);

            int genes = 0;
            for(final int c : use.chromosomes()) {
                genes += child.genome.chromosomes().get(c).size();
            }
            final double geneProbability = mutation.geneProbability().orElse(1.0 / genes);

            final Genome before = child.genome.copy();
            for(final int c : use.chromosomes()) {
                final Genes chromosomeGenes = child.genome.chromosomes().get(c);
                mutation.mutate(chromosomeGenes, geneProbability, random);
                genotype.chromosomes().get(c).handleBoundaries(chromosomeGenes, boundaryHandling);
            }

            if(mutation instanceof CorrelationAwareMutation correlationAware) {
                propagate(correlationAware, child, before);
            }

            noteChange(child, before, mutation.name(), false);
        }
    }

    /**
     * Keeps the features of building blocks and correlated pairs of the children together and
     *   notes the set features.
     */
    private void link(final LinkageCrossover crossover, final Offspring a, final Offspring b, final Candidate first,
                      final Candidate second) {
        final TypedEObject childA = genotype.decode(a.genome);
        final TypedEObject childB = genotype.decode(b.genome);
        final List<String> linked = crossover.link(first.input(), second.input(), childA, childB);
        if(linked.isEmpty()) {
            return;
        }

        genotype.write(a.genome, childA, crossover.linkage().features());
        genotype.write(b.genome, childB, crossover.linkage().features());
        a.linkedFeatures.addAll(linked);
        b.linkedFeatures.addAll(linked);
    }

    /**
     * Propagates the changes of a correlation-aware mutation and notes the primary and the
     *   propagated changes.
     */
    private void propagate(final CorrelationAwareMutation mutation, final Offspring child, final Genome before) {
        final List<String> primary = genotype.changedFeatures(before, child.genome);
        if(primary.isEmpty()) {
            return;
        }

        final TypedEObject after = genotype.decode(child.genome);
        final List<String> propagated = mutation.propagate(genotype.decode(before), after);
        child.primaryFeatures.addAll(primary);
        if(propagated.isEmpty()) {
            return;
        }

        genotype.write(child.genome, after, mutation.transfer().features());
        child.propagatedFeatures.addAll(propagated);
    }

    private void noteChange(final Offspring child, final Genome before, final String operator, final boolean recombination) {
        if(!genotype.isUnchanged(before, child.genome)) {
            child.operators.add(operator);
            child.recombined |= recombination;
        }
    }

    /**
     * @return The candidate of the child.
     */
    Candidate toCandidate(final Offspring child) {
        final Candidate parent = child.parents.getFirst();
        if(genotype.isUnchanged(child.parentGenome, child.genome)) {
            return parent.copy();
        }

        final Lineage origin = child.recombined
                ? Lineage.recombination(child.parents, child.pair)
                : Lineage.mutation(parent);
        Lineage lineage = origin.withProperty(OPERATORS, List.copyOf(child.operators))
                                .withProperty(CHANGED_FEATURES, genotype.changedFeatures(child.parentGenome, child.genome));
        if(!child.primaryFeatures.isEmpty()) {
            lineage = lineage.withProperty(PRIMARY_FEATURES, List.copyOf(child.primaryFeatures));
        }
        if(!child.propagatedFeatures.isEmpty()) {
            lineage = lineage.withProperty(PROPAGATED_FEATURES, List.copyOf(child.propagatedFeatures));
        }
        if(!child.linkedFeatures.isEmpty()) {
            lineage = lineage.withProperty(LINKED_FEATURES, List.copyOf(child.linkedFeatures));
        }

        return new Candidate(genotype.decode(child.genome), lineage);
    }
}

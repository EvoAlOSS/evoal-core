package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import de.evoal.core.api.random.RandomService;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.Genome;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;

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

            noteChange(a, beforeA, use.operator().name(), true);
            noteChange(b, beforeB, use.operator().name(), true);
        }

        return List.of(a, b);
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

            int genes = 0;
            for(final int c : use.chromosomes()) {
                genes += child.genome.chromosomes().get(c).size();
            }
            final double geneProbability = use.operator().geneProbability().orElse(1.0 / genes);

            final Genome before = child.genome.copy();
            for(final int c : use.chromosomes()) {
                final Genes chromosomeGenes = child.genome.chromosomes().get(c);
                use.operator().mutate(chromosomeGenes, geneProbability, random);
                genotype.chromosomes().get(c).handleBoundaries(chromosomeGenes, boundaryHandling);
            }

            noteChange(child, before, use.operator().name(), false);
        }
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
        final Lineage lineage = origin.withProperty(OPERATORS, List.copyOf(child.operators))
                                      .withProperty(CHANGED_FEATURES, genotype.changedFeatures(child.parentGenome, child.genome));

        return new Candidate(genotype.decode(child.genome), lineage);
    }
}

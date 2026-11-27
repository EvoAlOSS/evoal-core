package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import de.evoal.optimisation.ea.main.statistics.LinkageStatistics;

/**
 * Recombines and mutates the genomes of one run, following the probability rules of the
 *   EA:
 * <ul>
 *   <li>a recombination is applied to a pair with its probability, one draw per pair and
 *     use, and then changes the chromosome of the use;</li>
 *   <li>a mutation is applied to a child with its probability, one draw per child and use,
 *     and then changes every gene of the chromosome of the use with the gene probability
 *     (default 1 / n, n the number of genes of the chromosome, for a model the number of
 *     attribute values the mutation applies to, see {@link MutationOperator#geneCount});</li>
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
 * <p>
 * The linkage step and the statistics compare the children with the parents as the genotype
 *   represents them (encoded and decoded again), since a real feature of a bit or Gray
 *   chromosome is rounded to its grid and the initial population is not created by the
 *   genotype.
 * <p>
 * If the run records {@link LinkageStatistics}, every child of a recombination that fired is
 *   counted with its state before the first linkage step of the pair and after the
 *   recombinations (decoded only then); the statistics draw no random numbers.
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
     * Counts how often the recombinations preserve building blocks and correlated pairs;
     *   {@code null} if nothing is counted.
     */
    private final LinkageStatistics statistics;

    /**
     * Creates a variation without linkage statistics, e.g., for tests.
     *
     * @param genotype The genotype.
     * @param plan The operators.
     * @param boundaryHandling Brings the genes back into their boundaries.
     * @param random Gives the random streams of the current run.
     */
    Variation(final Genotype genotype, final OperatorPlan plan, final BoundaryHandling boundaryHandling,
              final RandomService random) {
        this(genotype, plan, boundaryHandling, random, null);
    }

    /**
     * @param genotype The genotype.
     * @param plan The operators.
     * @param boundaryHandling Brings the genes back into their boundaries.
     * @param random Gives the random streams of the current run.
     * @param statistics Counts how often the recombinations preserve building blocks and
     *   correlated pairs; {@code null} or not recording if nothing is counted.
     */
    Variation(final Genotype genotype, final OperatorPlan plan, final BoundaryHandling boundaryHandling,
              final RandomService random, final LinkageStatistics statistics) {
        this.statistics = statistics != null && statistics.isRecording() ? statistics : null;
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
        return recombine(first, second, true);
    }

    /**
     * Recombines a pair of parents into two children.
     *
     * @param countSibling Whether the linkage statistics count the second child, which is not
     *   used when a child is varied again.
     */
    private List<Offspring> recombine(final Candidate first, final Candidate second, final boolean countSibling) {
        final Object pair = new Object();
        final Offspring a = new Offspring(genotype.encode(first.input()), List.of(first, second), pair);
        final Offspring b = new Offspring(genotype.encode(second.input()), List.of(second, first), pair);

        boolean fired = false;
        TypedEObject unlinkedA = null;
        TypedEObject unlinkedB = null;

        // the parents as the genotype represents them, e.g. rounded to the precision of a bit chromosome;
        // created when needed
        TypedEObject parentA = null;
        TypedEObject parentB = null;

        for(int u = 0; u < recombinations.size(); ++u) {
            final OperatorUse<RecombinationOperator> use = recombinations.get(u);
            final RandomGenerator random = recombinationRandom.get(u);

            if(random.nextDouble() >= use.operator().probability()) {
                continue;
            }
            fired = true;

            final Genome beforeA = a.genome.copy();
            final Genome beforeB = b.genome.copy();
            final int c = use.chromosome();
            final Genes genesA = a.genome.chromosomes().get(c);
            final Genes genesB = b.genome.chromosomes().get(c);
            use.operator().recombine(genesA, genesB, random);
            genotype.chromosomes().get(c).handleBoundaries(genesA, boundaryHandling);
            genotype.chromosomes().get(c).handleBoundaries(genesB, boundaryHandling);

            if(use.operator() instanceof LinkageCrossover crossover) {
                if(parentA == null) {
                    parentA = represented(first);
                    parentB = represented(second);
                }
                if(statistics != null && unlinkedA == null) {
                    unlinkedA = genotype.decode(a.genome);
                    unlinkedB = genotype.decode(b.genome);
                }
                link(crossover, a, b, parentA, parentB);
            }

            noteChange(a, beforeA, use.operator().name(), true);
            noteChange(b, beforeB, use.operator().name(), true);
        }

        if(statistics != null && fired) {
            if(parentA == null) {
                parentA = represented(first);
                parentB = represented(second);
            }

            final TypedEObject childA = genotype.decode(a.genome);
            statistics.count(parentA, parentB, unlinkedA == null ? childA : unlinkedA, childA);

            if(countSibling) {
                final TypedEObject childB = genotype.decode(b.genome);
                statistics.count(parentA, parentB, unlinkedB == null ? childB : unlinkedB, childB);
            }
        }

        return List.of(a, b);
    }

    /**
     * @return The input of the candidate as the genotype represents it: encoded and decoded
     *   again, so a real feature of a bit or Gray chromosome lies on its grid, like the
     *   decoded children. The initial population is not created by the genotype.
     */
    private TypedEObject represented(final Candidate candidate) {
        return genotype.decode(genotype.encode(candidate.input()));
    }

    /**
     * Redoes the variation of a child: recombines its parents again and keeps the child in
     *   the place of the same parent, then mutates it. The draws continue the streams.
     *
     * @return The new child; its sibling is not recreated.
     */
    Offspring revary(final Offspring child) {
        final Offspring again = recombine(child.parents.get(0), child.parents.get(1), false).getFirst();
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

            final int c = use.chromosome();
            final Genes chromosomeGenes = child.genome.chromosomes().get(c);
            final double geneProbability = mutation.geneProbability().orElse(1.0 / Math.max(1, mutation.geneCount(chromosomeGenes)));

            final Genome before = child.genome.copy();
            mutation.mutate(chromosomeGenes, geneProbability, random);
            genotype.chromosomes().get(c).handleBoundaries(chromosomeGenes, boundaryHandling);

            if(mutation instanceof CorrelationAwareMutation correlationAware) {
                propagate(correlationAware, child, before);
            }

            noteChange(child, before, mutation.name(), false);
        }
    }

    /**
     * Keeps the features of building blocks and correlated pairs of the children together and
     *   notes the set features.
     *
     * @param parentA The first parent as the genotype represents it.
     * @param parentB The second parent as the genotype represents it.
     */
    private void link(final LinkageCrossover crossover, final Offspring a, final Offspring b, final TypedEObject parentA,
                      final TypedEObject parentB) {
        final TypedEObject childA = genotype.decode(a.genome);
        final TypedEObject childB = genotype.decode(b.genome);
        final List<String> linked = crossover.link(parentA, parentB, childA, childB);
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
     * @return The candidate of the child, related to its parents: an unchanged copy of the first
     *   parent, a recombination of the parents or a mutation of the first parent, with the
     *   operators that changed the child and the changed features.
     */
    Candidate toCandidate(final Offspring child) {
        final Candidate parent = child.parents.getFirst();
        if(genotype.isUnchanged(child.parentGenome, child.genome)) {
            return parent.copy();
        }

        final Lineage origin = child.recombined
                ? Lineage.recombination(child.parents, child.pair)
                : Lineage.mutation(parent);
        final Map<String, Object> properties = new LinkedHashMap<>();
        properties.put(OPERATORS, List.copyOf(child.operators));
        properties.put(CHANGED_FEATURES, genotype.changedFeatures(child.parentGenome, child.genome));
        if(!child.primaryFeatures.isEmpty()) {
            properties.put(PRIMARY_FEATURES, List.copyOf(child.primaryFeatures));
        }
        if(!child.propagatedFeatures.isEmpty()) {
            properties.put(PROPAGATED_FEATURES, List.copyOf(child.propagatedFeatures));
        }
        if(!child.linkedFeatures.isEmpty()) {
            properties.put(LINKED_FEATURES, List.copyOf(child.linkedFeatures));
        }

        return new Candidate(genotype.decode(child.genome), origin.withProperties(properties));
    }

    /**
     * The candidate of a child after its mutation ({@link #mutate}). Its lineage relates it to
     *   the parents as {@link #toCandidate}; if the mutation changed it, its step lineage is the
     *   mutation of the recombined child, with the operators and changed features of the
     *   mutation. A child that the mutation left unchanged is the recombined child itself, and a
     *   child equal to its first parent is an unchanged copy of it, as in {@link #toCandidate}.
     *
     * @param child The mutated child.
     * @param recombined The candidate of the child after the recombination ({@link #toCandidate}).
     * @param beforeMutation The genome of the child before the mutation.
     * @param operatorsBefore The number of operators that changed the child before the mutation.
     * @return The candidate of the child.
     */
    Candidate toMutatedCandidate(final Offspring child, final Candidate recombined, final Genome beforeMutation,
                                 final int operatorsBefore) {
        if(genotype.isUnchanged(beforeMutation, child.genome)) {
            return recombined;
        }

        final Candidate candidate = toCandidate(child);
        if(candidate.lineage().kind() == Lineage.Kind.IDENTITY) {
            // equal to the first parent: the copy keeps its evaluation
            return candidate;
        }

        final List<String> mutationOperators = child.operators.subList(operatorsBefore, child.operators.size());
        final Map<String, Object> properties = new LinkedHashMap<>();
        properties.put(OPERATORS, List.copyOf(mutationOperators));
        properties.put(CHANGED_FEATURES, genotype.changedFeatures(beforeMutation, child.genome));
        if(!child.primaryFeatures.isEmpty()) {
            properties.put(PRIMARY_FEATURES, List.copyOf(child.primaryFeatures));
        }
        if(!child.propagatedFeatures.isEmpty()) {
            properties.put(PROPAGATED_FEATURES, List.copyOf(child.propagatedFeatures));
        }

        return new Candidate(candidate.input(), candidate.lineage(), Lineage.mutation(recombined).withProperties(properties));
    }
}

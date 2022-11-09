package de.evoal.core.main.ea.alterer.mutator;

import de.evoal.core.main.ea.alterer.internal.AbstractCorrelationAlterer;
import de.evoal.core.main.ea.functions.correlation.model.Correlation;
import de.evoal.core.main.ea.functions.correlation.model.Correlations;
import io.jenetics.*;
import io.jenetics.internal.math.Probabilities;
import io.jenetics.util.ISeq;
import io.jenetics.util.RandomRegistry;
import io.jenetics.util.Seq;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import static java.lang.Math.pow;
import static java.lang.String.format;

public abstract class CorrelationMutator<
        G extends Gene<?, G>,
        C extends Comparable<? super C>,
        CC extends CorrelationMutatorMemento
>
        extends AbstractCorrelationAlterer<G, C> {

    protected final double threshold;
    private final Correlations<G> correlations;

    /**
     * Construct a Mutation object which a given mutation probability.
     *
     * @param probability Mutation probability. The given probability is
     *         divided by the number of chromosomes of the genotype to form
     *         the concrete mutation probability.
     * @param threshold Threshold value for strong and weak relations.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *          valid range of {@code [0, 1]}.
     */
    protected CorrelationMutator(final double probability, final double threshold, final Correlations correlations) {
        super(probability);
        
        this.correlations = correlations;
        this.threshold = threshold;
    }

    /**
     * Concrete implementation of the alter method. It uses the following
     * mutation methods: {@link #mutate(Phenotype, long, double, RandomGenerator)},
     * {@link #mutate(Genotype, double, RandomGenerator)},
     * {@link #mutate(Chromosome, double, CC, RandomGenerator)}, {@link #mutate(Gene, CC, RandomGenerator)},
     * in this specific order.
     *
     * @see #mutate(Phenotype, long, double, RandomGenerator)
     * @see #mutate(Genotype, double, RandomGenerator)
     * @see #mutate(Chromosome, double, CC, RandomGenerator)
     * @see #mutate(Gene, CC, RandomGenerator)
     */
    @Override
    public AltererResult<G, C> alter(
            final Seq<Phenotype<G, C>> population,
            final long generation
    ) {
        assert population != null : "Not null is guaranteed from base class.";

        final RandomGenerator random = RandomRegistry.random();
        final double p = pow(_probability, 1.0/3.0);
        final int P = Probabilities.toInt(p);

        final Seq<MutatorResult<Phenotype<G, C>>> result = population
                .map(pt -> random.nextInt() < P
                        ? mutate(pt, generation, p, random)
                        : new MutatorResult(pt, 0));

        return new AltererResult(
                result.map(MutatorResult::result).asISeq(),
                result.stream().mapToInt(MutatorResult::mutations).sum()
        );
    }

    /**
     * Mutates the given phenotype.
     *
     * @see #mutate(Genotype, double, RandomGenerator)
     * @see #mutate(Chromosome, double, CC, RandomGenerator)
     * @see #mutate(Gene, CC, RandomGenerator)
     *
     * @param phenotype the phenotype to mutate
     * @param generation the actual generation
     * @param p the mutation probability for the underlying genetic objects
     * @param random the random engine used for the phenotype mutation
     * @return the mutation result
     */
    protected MutatorResult<Phenotype<G, C>> mutate(
            final Phenotype<G, C> phenotype,
            final long generation,
            final double p,
            final RandomGenerator random
    ) {
        final MutatorResult<Genotype<G>> result = mutate(phenotype.genotype(), p, random);

        return new MutatorResult(Phenotype.of(result.result(), generation), result.mutations());
    }

    /**
     * Mutates the given genotype.
     *
     * @see #mutate(Chromosome, double, CC, RandomGenerator)
     * @see #mutate(Gene, CC, RandomGenerator)
     *
     * @param genotype the genotype to mutate
     * @param p the mutation probability for the underlying genetic objects
     * @param random the random engine used for the genotype mutation
     * @return the mutation result
     */
    protected MutatorResult<Genotype<G>> mutate(
            final Genotype<G> genotype,
            final double p,
            final RandomGenerator random
    ) {
        final int P = Probabilities.toInt(p);
        final long count = genotype.stream().count();
        final CC [] contexts = createContextArray((int)count);
        final List<MutatorResult<Chromosome<G>>> results = new ArrayList<>((int)count);

        for(int i = 0; i < count; ++i) {
            final Chromosome<G> chromosome = genotype.get(i);
            final boolean shouldMutate = random.nextInt() < P;

            if(!shouldMutate) {
                results.add(new MutatorResult(chromosome, 0));
            } else {
                final CC context = contexts[i];
                final MutatorResult<Chromosome<G>> mutatorResult = mutate(chromosome, p, context, random);
                propagateCorrelationInfo(contexts, genotype, i);

                results.add(mutatorResult);
            }
        }

        final ISeq<MutatorResult<Chromosome<G>>> result = results.stream().collect(ISeq.toISeq());

        return new MutatorResult(
                Genotype.of(result.map(MutatorResult::result)),
                result.stream().mapToInt(MutatorResult::mutations).sum()
        );
    }

    protected void propagateCorrelationInfo(final CC [] contexts, final Genotype<G> genotype, final int i) {
        final CC context = contexts[i];

        for(final Correlation correlation : this.correlations.find(genotype, i)) {
            final int targetIndex = Math.max(correlation.getChromosomeOne(), correlation.getChromosomeTwo());

            contexts[targetIndex].apply(context, correlation);
            propagateCorrelationInfo(contexts, genotype, targetIndex);
        }
    }

    /**
     * Creates an array of uninitialized contexts.
     * @param count Size of array.
     * @return A newly created array.
     */
    protected abstract CC[] createContextArray(final int count);

    /**
     * Mutates the given chromosome.
     *
     * @see #mutate(Gene, CC, RandomGenerator)
     *
     * @param chromosome the chromosome to mutate
     * @param p the mutation probability for the underlying genetic objects
     * @param context the context of the mutation. Should be modified.
     * @param random the random engine used for the genotype mutation
     * @return the mutation result
     */
    protected MutatorResult<Chromosome<G>> mutate(
            final Chromosome<G> chromosome,
            final double p,
            final CC context,
            final RandomGenerator random
    ) {
        final int P = Probabilities.toInt(p);

        final ISeq<MutatorResult<G>> result = chromosome.stream()
                .map(gene -> random.nextInt() < P
                        ? new MutatorResult<G>(mutate(gene, context, random), 1)
                        : new MutatorResult<G>(gene, 0))
                .collect(ISeq.toISeq());

        return new MutatorResult(
                chromosome.newInstance(result.map(MutatorResult::result)),
                result.stream().mapToInt(MutatorResult::mutations).sum()
        );
    }

    /**
     * Mutates the given gene.
     *
     * @param gene the gene to mutate
     * @param context the context for mutation. The parameter should be modified
     * @param random the random engine used for the genotype mutation‚
     * @return the mutation result
     */
    protected G mutate(final G gene, final CC context, final RandomGenerator random) {
        return gene.newInstance();
    }

    /**
     * Creates an uninitialized context.
     *
     * @return an uninitialized context
     */
    protected abstract CC uninitializedContext();

    @Override
    public String toString() {
        return format("%s[p=%f]", getClass().getSimpleName(), _probability);
    }
}

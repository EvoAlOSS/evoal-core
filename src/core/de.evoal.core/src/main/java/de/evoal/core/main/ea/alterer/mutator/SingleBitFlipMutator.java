package de.evoal.core.main.ea.alterer.mutator;

import io.jenetics.*;
import io.jenetics.util.MSeq;

import java.util.random.RandomGenerator;

public class SingleBitFlipMutator<
        C extends Comparable<? super C>
        >
        extends Mutator<BitGene, C>
{

    /**
     * Constructs an alterer with a given filip probability.
     *
     * @param probability the flip probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *          valid range of {@code [0, 1]}.
     */
    public SingleBitFlipMutator(final double probability) {
        super(probability);
    }

    /**
     * Default constructor, with default mutation probability
     * ({@link AbstractAlterer#DEFAULT_ALTER_PROBABILITY}).
     */
    public SingleBitFlipMutator() {
        this(DEFAULT_ALTER_PROBABILITY);
    }

    /**
     * Flips a random gene in the .
     */
    @Override
    protected MutatorResult<Chromosome<BitGene>> mutate(
            final Chromosome<BitGene> chromosome,
            final double p,
            final RandomGenerator random
    ) {
        final MSeq<BitGene> genes = MSeq.of(chromosome);

        final int index = random.nextInt();

        final BitGene gene = genes.get(index);
        genes.set(index, BitGene.of(!gene.bit()));

        return new MutatorResult(
                chromosome.newInstance(genes.toISeq()),
                1
        );
    }

}

package de.evoal.core.ea.api.alterer;

import io.jenetics.*;
import io.jenetics.util.RandomRegistry;
import io.jenetics.util.Seq;

public abstract class EvoAlMutator<
        G extends Gene<?, G>,
        C extends Comparable<? super C>
        >
        extends Mutator<G, C>
{
    public EvoAlMutator(final double probability) {
        super(probability);
    }

    @Override
    public AltererResult<G, C> alter(
            final Seq<Phenotype<G, C>> population,
            final long generation
    ) {
        assert population != null : "Not null is guaranteed from base class.";

        final var random = RandomRegistry.random();
        final double p = StrictMath.pow(_probability, 1.0/3.0);
        final int P = EvoAlMutator.toInt(p);

        final Seq<MutatorResult<Phenotype<G, C>>> result = population
                .map(pt -> mutate(pt, generation, p, random));

        return new AltererResult<>(
                result.map(MutatorResult::result).asISeq(),
                result.stream().mapToInt(MutatorResult::mutations).sum()
        );
    }

    private static final long INT_RANGE = pow(2, 32) - 1;

    protected static int toInt(final double probability) {
        return (int)(Math.round(INT_RANGE*probability) + Integer.MIN_VALUE);
    }

    protected static long pow(final long b, final long e) {
        long base = b;
        long exp = e;
        long result = 1;

        while (exp != 0) {
            if ((exp & 1) != 0) {
                result *= base;
            }
            exp >>>= 1;
            base *= base;
        }

        return result;
    }
}

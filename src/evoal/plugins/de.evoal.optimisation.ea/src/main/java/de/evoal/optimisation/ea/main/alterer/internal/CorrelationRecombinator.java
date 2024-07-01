package de.evoal.optimisation.ea.main.alterer.internal;

import io.jenetics.AltererResult;
import io.jenetics.Gene;
import io.jenetics.Phenotype;
import io.jenetics.internal.math.Subset;
import io.jenetics.util.MSeq;
import io.jenetics.util.RandomRegistry;
import io.jenetics.util.Seq;

import java.util.random.RandomGenerator;

import static io.jenetics.internal.math.Randoms.indexes;
import static java.lang.String.format;

public abstract class CorrelationRecombinator<
        G extends Gene<?, G>,
        C extends Comparable<? super C>
        >
        extends AbstractCorrelationAlterer<G, C> {
    private final int _order;

    /**
     * Constructs an alterer with a given recombination probability.
     *
     * @param probability The recombination probability.
     * @param order the number of individuals involved in the
     *        {@link #recombine(MSeq, int[], long)} step
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *         valid range of {@code [0, 1]} or the given {@code order} is
     *         smaller than two.
     */
    protected CorrelationRecombinator(final double probability, final int order) {
        super(probability);
        if (order < 2) {
            throw new IllegalArgumentException(format(
                    "Order must be greater than one, but was %d.", order
            ));
        }
        _order = order;
    }

    /**
     * Return the number of individuals involved in the
     * {@link #recombine(MSeq, int[], long)} step.
     *
     * @return the number of individuals involved in the recombination step.
     */
    public int order() {
        return _order;
    }

    @Override
    public AltererResult<G, C> alter(
            final Seq<Phenotype<G, C>> population,
            final long generation
    ) {
        final AltererResult<G, C> result;
        if (population.size() >= 2) {
            final RandomGenerator random = RandomRegistry.random();
            final int order = Math.min(_order, population.size());

            final MSeq<Phenotype<G, C>> pop = MSeq.of(population);
            final int count = indexes(random, population.size(), _probability)
                    .mapToObj(i -> individuals(i, population.size(), order, random))
                    .mapToInt(ind -> recombine(pop, ind, generation))
                    .sum();

            result = new AltererResult(pop.toISeq(), count);
        } else {
            result = new AltererResult(population.asISeq());
        }

        return result;
    }

    static int[] individuals(
            final int index,
            final int size,
            final int order,
            final RandomGenerator random
    ) {
        final int[] ind = Subset.next(size, order, random);

        // Find the correct slot for the "master" individual.
        // This prevents duplicate index entries.
        int i = 0;
        while (ind[i] < index && i < ind.length - 1) {
            ++i;
        }
        ind[i] = index;

        return ind;
    }

    /**
     * Recombination template method. This method is called 0 to n times. It is
     * guaranteed that this method is only called by one thread.
     *
     * @param population the population to recombine
     * @param individuals the array with the indexes of the individuals which
     *        are involved in the <i>recombination</i> step. The length of the
     *        array is {@link #order()}. The first individual is the
     *        <i>primary</i> individual.
     * @param generation the current generation.
     * @return the number of genes that has been altered.
     */
    protected abstract int recombine(
            final MSeq<Phenotype<G, C>> population,
            final int[] individuals,
            final long generation
    );
}

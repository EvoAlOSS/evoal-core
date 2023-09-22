package de.evoal.core.ea.main.alterer.crossover;

import de.evoal.core.api.correlations.Correlation;
import de.evoal.core.api.correlations.Correlations;
import de.evoal.core.ea.api.codec.CustomCodec;
import io.jenetics.*;
import io.jenetics.util.MSeq;
import io.jenetics.util.RandomRegistry;

import java.util.random.RandomGenerator;

import static java.lang.Math.min;

public abstract class CorrelationCrossover<
        G extends Gene<?, G>,
        C extends Comparable<? super C>,
        M extends CorrelationCrossoverMemento<M>
        >
        extends Recombinator<G, C> {

    private final Correlations correlations;

    private final CustomCodec<G> codec;

    /**
     * Constructs an alterer with a given recombination probability.
     *
     * @param probability the recombination probability
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *          valid range of {@code [0, 1]}
     */
    protected CorrelationCrossover(final double probability, final Correlations correlations, final CustomCodec<G> codec) {
        super(probability, 2);
        
        this.correlations = correlations;
        this.codec = codec;
    }

    @Override
    protected final int recombine(
            final MSeq<Phenotype<G, C>> population,
            final int[] individuals,
            final long generation
    ) {
        assert individuals.length == 2 : "Required order of 2";
        final RandomGenerator random = RandomRegistry.random();

        final var pt1 = population.get(individuals[0]);
        final var pt2 = population.get(individuals[1]);
        final var gt1 = pt1.genotype();
        final var gt2 = pt2.genotype();

        //Choosing the Chromosome index for crossover.
        final int chIndex = random.nextInt(min(gt1.length(), gt2.length()));
        final int rootIndex = correlations.findCorrelationRoot(codec.decode(gt1), chIndex);

        final var c1 = MSeq.of(gt1);
        final var c2 = MSeq.of(gt2);

        final var memento = newCrossoverMemento();

        final var correlationOrder = crossover(gt1, gt2, c1, c2, rootIndex, memento);

        //Creating two new Phenotypes and exchanging it with the old.
        population.set(
                individuals[0],
                Phenotype.of(Genotype.of(c1), generation)
        );
        population.set(
                individuals[1],
                Phenotype.of(Genotype.of(c2), generation)
        );

        return correlationOrder;
    }

    private int crossover(final Genotype<G> gt1, final Genotype<G> gt2, final MSeq<Chromosome<G>> c1, final MSeq<Chromosome<G>> c2, final int chIndex, final M memento) {
        final var genes1 = MSeq.of(c1.get(chIndex));
        final var genes2 = MSeq.of(c2.get(chIndex));

        int correlationOrder = crossover(memento, genes1, genes2);

        c1.set(chIndex, c1.get(chIndex).newInstance(genes1.toISeq()));
        c2.set(chIndex, c2.get(chIndex).newInstance(genes2.toISeq()));

        for(final Correlation correlation : correlations.find(codec.decode(gt1), chIndex)) {
            final int targetIndex = correlation.getChromosomeTwo();

            correlationOrder += crossover(gt1, gt2, c1, c2, targetIndex, newCrossoverMemento().apply(memento, correlation)); // sum up correlations
        }

        return correlationOrder;
    }

    /**
     * @return A valid and initialized crossover memento.
     */
    protected abstract M newCrossoverMemento();

    /**
     * Template method which performs the crossover. The arguments given are
     * mutable non null arrays of the same length.
     *
     * @oaram memento the crossover memento to be applied
     * @param that the genes of the first chromosome
     * @param other the genes of the other chromosome
     * @return the number of altered genes
     */
    protected abstract int crossover(final M memento, final MSeq<G> that, final MSeq<G> other);
}

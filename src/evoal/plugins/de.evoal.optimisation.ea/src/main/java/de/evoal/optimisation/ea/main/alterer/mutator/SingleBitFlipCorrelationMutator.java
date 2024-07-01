package de.evoal.optimisation.ea.main.alterer.mutator;

import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import io.jenetics.*;
import io.jenetics.util.MSeq;

import java.util.random.RandomGenerator;

public class SingleBitFlipCorrelationMutator<
        C extends Comparable<? super C>
        >
        extends CorrelationMutator<BitGene, C, SingleBitFlipCorrelationMutatorMemento>
{

    /**
     * Constructs an alterer with a given filip probability.
     *
     * @param probability the flip probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *          valid range of {@code [0, 1]}.
     */
    public SingleBitFlipCorrelationMutator(final double probability, final double threshold, final Correlations correlations, final CustomCodec<BitGene> codec) {
        super(probability, threshold, correlations, codec);
    }

    @Override
    protected SingleBitFlipCorrelationMutatorMemento[] createContextArray(final int count) {
        final SingleBitFlipCorrelationMutatorMemento[] result = new SingleBitFlipCorrelationMutatorMemento[count];

        for(int i = 0; i < count; ++i) {
            result[i] = uninitializedContext();
        }

        return result;
    }

    /**
     * Flips a random gene in the .
     */
    @Override
    protected MutatorResult<Chromosome<BitGene>> mutate(final Chromosome<BitGene> chromosome,
                                                        final double p,
                                                        final SingleBitFlipCorrelationMutatorMemento memento,
                                                        final RandomGenerator random) {
        final MSeq<BitGene> genes = MSeq.of(chromosome);

        int index = memento.getIndex(random, genes.length(), p);
        SingleBitFlipCorrelationMutatorMemento.FlipDirection direction = SingleBitFlipCorrelationMutatorMemento.FlipDirection.UNSET;
        boolean newBit = false;

        switch(memento.getDirection()) {
            case UNSET: {
                newBit = !genes.get(index).bit();
                direction = SingleBitFlipCorrelationMutatorMemento.FlipDirection.from(newBit);
                break;
            }

            case SINGLE_FLIP_UP: {
                newBit = true;
                direction = SingleBitFlipCorrelationMutatorMemento.FlipDirection.UP;
                break;
            }

            case SINGLE_FLIP_DOWN: {
                newBit = false;
                direction = SingleBitFlipCorrelationMutatorMemento.FlipDirection.DOWN;
                break;
            }

            case TRANSITIVE_UP: {
                index = findNearestIndex(genes, index, false);
                newBit = true;
                direction = SingleBitFlipCorrelationMutatorMemento.FlipDirection.UP;
            }

            case TRANSITIVE_DOWN: {
                index = findNearestIndex(genes, index, true);
                newBit = false;
                direction = SingleBitFlipCorrelationMutatorMemento.FlipDirection.DOWN;
            }
        }

        genes.set(index, BitGene.of(newBit));
        memento.setDirection(direction);

        return new MutatorResult(
                chromosome.newInstance(genes.toISeq()),
                1
        );
    }

    private int findNearestIndex(final MSeq<BitGene> genes, final int starting, final boolean value) {
        if(genes.get(starting).bit() == value) {
            return starting;
        }

        for(int i = 1; i < genes.length(); ++i) {
            final int upperIndex = Math.min(starting + i, genes.length() - 1);
            if(genes.get(upperIndex).bit() == value) {
                return upperIndex;
            }

            final int lowerIndex = Math.max(starting - i, 0);
            if(genes.get(lowerIndex).bit() == value) {
                return lowerIndex;
            }
        }

        return starting;
    }

    @Override
    protected SingleBitFlipCorrelationMutatorMemento uninitializedContext() {
        return new SingleBitFlipCorrelationMutatorMemento(threshold);
    }
}

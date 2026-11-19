package de.evoal.optimisation.ea.main;

import java.util.List;

/**
 * An operator and the chromosomes it is applied to. A recombination or mutation of the
 *   algorithm is one use for all chromosomes without own operators that it applies to; an
 *   operator of a chromosome is one use for this chromosome.
 *
 * @param operator The operator.
 * @param chromosomes The indices of the chromosomes, not empty.
 * @param stream The name of the random stream of the use.
 * @param <T> The type of the operator.
 */
public record OperatorUse<T>(T operator, List<Integer> chromosomes, String stream) {
    public OperatorUse {
        chromosomes = List.copyOf(chromosomes);
        if(chromosomes.isEmpty()) {
            throw new IllegalArgumentException("An operator use needs at least one chromosome.");
        }
    }
}

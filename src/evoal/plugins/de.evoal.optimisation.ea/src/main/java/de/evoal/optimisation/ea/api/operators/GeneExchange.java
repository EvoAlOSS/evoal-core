package de.evoal.optimisation.ea.api.operators;

/**
 * Marks a recombination that only exchanges genes between the two children, so every gene of
 *   a child comes from one of the parents (e.g., single-point, multi-point and uniform
 *   crossover). Only such recombinations can be wrapped by {@code 'linkage-crossover'};
 *   blending recombinations create new values. The DL type {@code 'gene-exchange'} is the
 *   counterpart of this interface: the DL types of the implementations extend it.
 */
public interface GeneExchange {
}

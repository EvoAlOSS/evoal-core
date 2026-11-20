package de.evoal.optimisation.ea.main.operators;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.operators.AbstractRecombination;
import de.evoal.optimisation.ea.api.operators.GeneExchange;

/**
 * One-point crossover (DL type {@code 'single-point-crossover'}): a cut point is chosen
 *   uniformly between two genes, and the children exchange the genes after it. A chromosome
 *   with one gene is not changed.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.single-point-crossover")
public class SinglePointCrossover extends AbstractRecombination implements GeneExchange {
    public SinglePointCrossover() {
    }

    /**
     * @param probability The probability that the recombination is applied to a pair.
     */
    public SinglePointCrossover(final double probability) {
        super(probability);
    }

    @Override
    public String name() {
        return "single-point-crossover";
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        final int size = first.size();
        if(size < 2) {
            return;
        }

        final int cut = random.nextInt(1, size);
        for(int gene = cut; gene < size; ++gene) {
            first.exchange(second, gene);
        }
    }
}

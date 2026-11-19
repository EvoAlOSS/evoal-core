package de.evoal.optimisation.ea.main.operators;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.IntegerGenes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;

/**
 * Random reset mutation (DL type {@code 'random-reset-mutation'}): a mutated gene gets a
 *   value drawn uniformly from the boundaries of its feature.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.random-reset-mutation")
public class RandomResetMutation extends AbstractMutation {
    public RandomResetMutation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     * @param geneProbability The probability that a gene is changed, {@code NaN} for 1 / n.
     */
    public RandomResetMutation(final double probability, final double geneProbability) {
        super(probability, geneProbability);
    }

    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        for(int gene = 0; gene < genes.size(); ++gene) {
            if(random.nextDouble() >= geneProbability) {
                continue;
            }

            switch(genes) {
                case RealGenes real -> {
                    final double ratio = random.nextDouble();
                    real.set(gene, ratio * real.upper(gene) + (1.0 - ratio) * real.lower(gene));
                }
                case IntegerGenes integer -> integer.set(gene, random.nextLong(integer.lower(gene), integer.upper(gene) + 1));
                default -> throw new IllegalArgumentException("Random reset mutation does not apply to " + genes.getClass().getSimpleName() + ".");
            }
        }
    }

    @Override
    public String name() {
        return "random-reset-mutation";
    }
}

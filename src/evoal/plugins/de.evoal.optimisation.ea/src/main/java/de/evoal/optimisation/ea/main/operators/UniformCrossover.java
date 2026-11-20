package de.evoal.optimisation.ea.main.operators;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.operators.AbstractRecombination;
import de.evoal.optimisation.ea.api.operators.GeneExchange;

/**
 * Uniform crossover (DL type {@code 'uniform-crossover'}): the children exchange every gene
 *   with {@code 'swap-probability'}, one draw per gene.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.uniform-crossover")
public class UniformCrossover extends AbstractRecombination implements GeneExchange {
    /**
     * The probability that a gene is exchanged.
     */
    private double swapProbability = 0.5;

    public UniformCrossover() {
    }

    /**
     * @param probability The probability that the recombination is applied to a pair.
     * @param swapProbability The probability that a gene is exchanged.
     */
    public UniformCrossover(final double probability, final double swapProbability) {
        super(probability);
        this.swapProbability = swapProbability;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        swapProbability = attributes.attributeToDouble(configuration, "swap-probability");
    }

    @Override
    public String name() {
        return "uniform-crossover";
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        for(int gene = 0; gene < first.size(); ++gene) {
            if(random.nextDouble() < swapProbability) {
                first.exchange(second, gene);
            }
        }
    }
}

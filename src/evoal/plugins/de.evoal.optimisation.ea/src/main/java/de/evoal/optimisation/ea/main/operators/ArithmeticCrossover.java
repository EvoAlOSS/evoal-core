package de.evoal.optimisation.ea.main.operators;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;

import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.AbstractRecombination;

/**
 * Arithmetic crossover (DL type {@code 'arithmetic-crossover'}): the children are the weighted
 *   means alpha x + (1 - alpha) y and (1 - alpha) x + alpha y of the parents x and y, gene by
 *   gene. With alpha = 0.5 both children are the mean of the parents.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.arithmetic-crossover")
public class ArithmeticCrossover extends AbstractRecombination {
    /**
     * The weight of the parent whose place a child takes.
     */
    private double alpha = 0.5;

    public ArithmeticCrossover() {
    }

    /**
     * @param probability The probability that the recombination is applied to a pair.
     * @param alpha The weight of the parent whose place a child takes.
     */
    public ArithmeticCrossover(final double probability, final double alpha) {
        super(probability);
        this.alpha = alpha;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        alpha = attributes.attributeToDouble(configuration, "alpha");
    }

    @Override
    public String name() {
        return "arithmetic-crossover";
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        final RealGenes x = (RealGenes) first;
        final RealGenes y = (RealGenes) second;

        for(int gene = 0; gene < x.size(); ++gene) {
            final double xi = x.get(gene);
            final double yi = y.get(gene);
            x.set(gene, alpha * xi + (1.0 - alpha) * yi);
            y.set(gene, (1.0 - alpha) * xi + alpha * yi);
        }
    }
}

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
 * Blend crossover BLX-alpha (DL type {@code 'blx-alpha-crossover'}; Eshelman and Schaffer
 *   1993): every gene of every child is drawn uniformly from [min - alpha I, max + alpha I],
 *   where min and max are the parent values and I = max - min. The algorithm brings values
 *   outside the boundaries back with its boundary handling.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.blx-alpha-crossover")
public class BlxAlphaCrossover extends AbstractRecombination {
    /**
     * How far the interval reaches beyond the parents, relative to their distance.
     */
    private double alpha = 0.5;

    public BlxAlphaCrossover() {
    }

    /**
     * @param probability The probability that the recombination is applied to a pair.
     * @param alpha How far the interval reaches beyond the parents.
     */
    public BlxAlphaCrossover(final double probability, final double alpha) {
        super(probability);
        this.alpha = alpha;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        alpha = attributes.attributeToDouble(configuration, "alpha");
    }

    @Override
    public String name() {
        return "blx-alpha-crossover";
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        final RealGenes x = (RealGenes) first;
        final RealGenes y = (RealGenes) second;

        for(int gene = 0; gene < x.size(); ++gene) {
            final double minimum = Math.min(x.get(gene), y.get(gene));
            final double maximum = Math.max(x.get(gene), y.get(gene));
            final double lower = minimum - alpha * (maximum - minimum);
            final double width = (maximum - minimum) * (1.0 + 2.0 * alpha);

            x.set(gene, lower + random.nextDouble() * width);
            y.set(gene, lower + random.nextDouble() * width);
        }
    }
}

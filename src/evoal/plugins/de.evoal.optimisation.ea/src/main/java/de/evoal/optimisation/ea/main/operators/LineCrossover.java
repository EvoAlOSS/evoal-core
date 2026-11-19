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
 * Line recombination (DL type {@code 'line-crossover'}; the extended line recombination of the
 *   breeder genetic algorithm, Muehlenbein and Schlierkamp-Voosen 1993): every child lies on
 *   the line through its parents, z = x + a (y - x) with x the parent whose place it takes,
 *   y the other parent, and one factor a per child and chromosome drawn uniformly from
 *   [-d, 1 + d] (d = {@code extension}). The algorithm brings values outside the boundaries
 *   back with its boundary handling.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.line-crossover")
public class LineCrossover extends AbstractRecombination {
    /**
     * How far a child may lie beyond its parents, relative to their distance (d).
     */
    private double extension = 0.25;

    public LineCrossover() {
    }

    /**
     * @param probability The probability that the recombination is applied to a pair.
     * @param extension How far a child may lie beyond its parents (d).
     */
    public LineCrossover(final double probability, final double extension) {
        super(probability);
        this.extension = extension;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        extension = attributes.attributeToDouble(configuration, "extension");
    }

    @Override
    public String name() {
        return "line-crossover";
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        final RealGenes x = (RealGenes) first;
        final RealGenes y = (RealGenes) second;
        final double a = -extension + random.nextDouble() * (1.0 + 2.0 * extension);
        final double b = -extension + random.nextDouble() * (1.0 + 2.0 * extension);

        for(int gene = 0; gene < x.size(); ++gene) {
            final double xi = x.get(gene);
            final double yi = y.get(gene);
            x.set(gene, xi + a * (yi - xi));
            y.set(gene, yi + b * (xi - yi));
        }
    }
}

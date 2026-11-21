package de.evoal.optimisation.ea.main.operators;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.random.Gaussian;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;

/**
 * Gaussian mutation (DL type {@code 'gaussian-mutation'}): a normally distributed value with
 *   mean 0 and the standard deviation {@code sigma} times the range of the feature is added
 *   to a mutated gene. The algorithm brings values outside the boundaries back with its
 *   boundary handling.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.gaussian-mutation")
public class GaussianMutation extends AbstractMutation {
    /**
     * The standard deviation relative to the range of the feature.
     */
    private double sigma = 0.1;

    public GaussianMutation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     * @param geneProbability The probability that a gene is changed, {@code NaN} for 1 / n.
     * @param sigma The standard deviation relative to the range of the feature.
     */
    public GaussianMutation(final double probability, final double geneProbability, final double sigma) {
        super(probability, geneProbability);
        this.sigma = sigma;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        sigma = attributes.attributeToDouble(configuration, "sigma");
    }

    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        final RealGenes real = (RealGenes) genes;

        for(int gene = 0; gene < real.size(); ++gene) {
            if(random.nextDouble() < geneProbability) {
                final double range = real.upper(gene) - real.lower(gene);
                real.set(gene, real.get(gene) + Gaussian.next(random) * sigma * range);
            }
        }
    }

    @Override
    public String name() {
        return "gaussian-mutation";
    }
}

package de.evoal.optimisation.ea.main.operators;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.math.EvoalMath;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;

/**
 * Polynomial mutation with boundaries (DL type {@code 'polynomial-mutation'}), in the bounded
 *   form of the NSGA-II reference implementation, revision 1.1.6 (Deb, Pratap, Agarwal and
 *   Meyarivan 2002, IEEE Transactions on Evolutionary Computation 6(2)): a mutated gene y with
 *   the boundaries l and u is moved by delta_q (u - l), where delta_q is drawn from the
 *   polynomial distribution with the distribution index eta_m so that the result stays within
 *   the boundaries.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.polynomial-mutation")
public class PolynomialMutation extends AbstractMutation {
    /**
     * The distribution index (eta_m).
     */
    private double distributionIndex = 20.0;

    public PolynomialMutation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     * @param geneProbability The probability that a gene is changed, {@code NaN} for 1 / n.
     * @param distributionIndex The distribution index (eta_m).
     */
    public PolynomialMutation(final double probability, final double geneProbability, final double distributionIndex) {
        super(probability, geneProbability);
        this.distributionIndex = distributionIndex;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        distributionIndex = attributes.attributeToDouble(configuration, "distribution-index");
    }

    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        final RealGenes real = (RealGenes) genes;
        final double exponent = 1.0 / (distributionIndex + 1.0);

        for(int gene = 0; gene < real.size(); ++gene) {
            if(random.nextDouble() >= geneProbability) {
                continue;
            }

            final double lower = real.lower(gene);
            final double upper = real.upper(gene);
            final double range = upper - lower;
            if(range <= 0.0) {
                continue;
            }

            final double y = real.get(gene);
            final double u = random.nextDouble();

            final double deltaQ;
            if(u < 0.5) {
                final double xy = 1.0 - (y - lower) / range;
                final double value = 2.0 * u + (1.0 - 2.0 * u) * EvoalMath.pow(xy, distributionIndex + 1.0);
                deltaQ = EvoalMath.pow(value, exponent) - 1.0;
            } else {
                final double xy = 1.0 - (upper - y) / range;
                final double value = 2.0 * (1.0 - u) + 2.0 * (u - 0.5) * EvoalMath.pow(xy, distributionIndex + 1.0);
                deltaQ = 1.0 - EvoalMath.pow(value, exponent);
            }

            real.set(gene, Math.min(upper, Math.max(lower, y + deltaQ * range)));
        }
    }

    @Override
    public String name() {
        return "polynomial-mutation";
    }
}

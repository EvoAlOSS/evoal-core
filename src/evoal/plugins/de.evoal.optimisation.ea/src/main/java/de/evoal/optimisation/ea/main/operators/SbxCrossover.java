package de.evoal.optimisation.ea.main.operators;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.math.EvoalMath;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.AbstractRecombination;

/**
 * Simulated binary crossover with boundaries (DL type {@code 'sbx-crossover'}; Deb and
 *   Agrawal 1995, Complex Systems 9), in the bounded form of the NSGA-II reference
 *   implementation, revision 1.1.6 (Deb, Pratap, Agarwal and Meyarivan 2002). Every gene is
 *   recombined with probability 0.5 if the parent values differ: the spread factor beta_q of
 *   the polynomial distribution with the distribution index eta_c is drawn so that both
 *   children stay within the boundaries, and the children are
 *   0.5 ((y1 + y2) -/+ beta_q (y2 - y1)). With probability 0.5 the children exchange the
 *   values.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.sbx-crossover")
public class SbxCrossover extends AbstractRecombination {
    /**
     * Parent values closer than this are not recombined.
     */
    private static final double EPSILON = 1.0e-14;

    /**
     * The distribution index (eta_c).
     */
    private double distributionIndex = 15.0;

    public SbxCrossover() {
    }

    /**
     * @param probability The probability that the recombination is applied to a pair.
     * @param distributionIndex The distribution index (eta_c).
     */
    public SbxCrossover(final double probability, final double distributionIndex) {
        super(probability);
        this.distributionIndex = distributionIndex;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        distributionIndex = attributes.attributeToDouble(configuration, "distribution-index");
    }

    @Override
    public String name() {
        return "sbx-crossover";
    }

    /**
     * @return The spread factor beta_q for the boundary factor beta.
     */
    private double spread(final double beta, final double u) {
        final double exponent = 1.0 / (distributionIndex + 1.0);
        final double alpha = 2.0 - EvoalMath.pow(beta, -(distributionIndex + 1.0));

        return u <= 1.0 / alpha
                ? EvoalMath.pow(u * alpha, exponent)
                : EvoalMath.pow(1.0 / (2.0 - u * alpha), exponent);
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        final RealGenes a = (RealGenes) first;
        final RealGenes b = (RealGenes) second;

        for(int gene = 0; gene < a.size(); ++gene) {
            if(random.nextDouble() >= 0.5) {
                continue;
            }

            final double y1 = Math.min(a.get(gene), b.get(gene));
            final double y2 = Math.max(a.get(gene), b.get(gene));
            if(y2 - y1 <= EPSILON) {
                continue;
            }

            final double lower = a.lower(gene);
            final double upper = a.upper(gene);
            final double u = random.nextDouble();

            final double betaLower = 1.0 + 2.0 * (y1 - lower) / (y2 - y1);
            final double c1 = 0.5 * ((y1 + y2) - spread(betaLower, u) * (y2 - y1));

            final double betaUpper = 1.0 + 2.0 * (upper - y2) / (y2 - y1);
            final double c2 = 0.5 * ((y1 + y2) + spread(betaUpper, u) * (y2 - y1));

            final double child1 = Math.min(upper, Math.max(lower, c1));
            final double child2 = Math.min(upper, Math.max(lower, c2));

            if(random.nextDouble() < 0.5) {
                a.set(gene, child2);
                b.set(gene, child1);
            } else {
                a.set(gene, child1);
                b.set(gene, child2);
            }
        }
    }
}

package de.evoal.optimisation.ea.main.operators;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.math.EvoalMath;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;

/**
 * Polynomial mutation with boundaries (DL type {@code 'polynomial-mutation'}), in the bounded
 *   form of the NSGA-II reference implementation, revision 1.1.6 (Deb, Pratap, Agarwal and
 *   Meyarivan 2002, IEEE Transactions on Evolutionary Computation 6(2)): a mutated gene y with
 *   the boundaries l and u is moved by delta_q (u - l), where delta_q is drawn from the
 *   polynomial distribution with the distribution index eta_m so that the result stays within
 *   the boundaries. On a model it changes the real attributes of at least cardinal scale.
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
    protected Optional<Predicate<EAttribute>> modelAttributes(final ModelGenes.Context context) {
        return Optional.of(GaussianMutation.cardinalReals());
    }

    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        if(genes instanceof ModelGenes models) {
            mutateModel(models, geneProbability, random, (slot, context, randomness) -> {
                final double[] bounds = context.realBounds(slot.attribute());
                final double value = ((Number) slot.get()).doubleValue();
                if(bounds[1] - bounds[0] > 0.0) {
                    slot.set(mutated(value, bounds[0], bounds[1], randomness.nextDouble()));
                }
            });
            return;
        }

        final RealGenes real = (RealGenes) genes;

        for(int gene = 0; gene < real.size(); ++gene) {
            if(random.nextDouble() >= geneProbability) {
                continue;
            }

            final double lower = real.lower(gene);
            final double upper = real.upper(gene);
            if(upper - lower <= 0.0) {
                continue;
            }

            real.set(gene, mutated(real.get(gene), lower, upper, random.nextDouble()));
        }
    }

    /**
     * @return The mutated value of y with the boundaries and the uniform draw u.
     */
    private double mutated(final double y, final double lower, final double upper, final double u) {
        final double range = upper - lower;
        final double exponent = 1.0 / (distributionIndex + 1.0);

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

        return Math.min(upper, Math.max(lower, y + deltaQ * range));
    }

    @Override
    public String name() {
        return "polynomial-mutation";
    }
}

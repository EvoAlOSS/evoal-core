package de.evoal.optimisation.ea.main.operators;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.ecore.info.FeatureScales;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.random.Gaussian;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;

/**
 * Gaussian mutation (DL type {@code 'gaussian-mutation'}): a normally distributed value with
 *   mean 0 and the standard deviation {@code sigma} times the range of the feature is added
 *   to a mutated gene. The algorithm brings values outside the boundaries back with its
 *   boundary handling. On a model it changes the real attributes of at least cardinal scale.
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

    /**
     * @return The real attributes of at least cardinal scale, for which a distance is defined.
     */
    static Predicate<EAttribute> cardinalReals() {
        return attribute -> EClassifierHelper.isDouble(attribute.getEType())
                            && FeatureScales.scaleOf(attribute).getValue() >= ScaleType.CARDINAL.getValue();
    }

    @Override
    protected Optional<Predicate<EAttribute>> modelAttributes(final ModelGenes.Context context) {
        return Optional.of(cardinalReals());
    }

    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        if(genes instanceof ModelGenes models) {
            mutateModel(models, geneProbability, random, (slot, context, randomness) -> {
                final double[] bounds = context.realBounds(slot.attribute());
                final double value = ((Number) slot.get()).doubleValue();
                slot.set(value + Gaussian.next(randomness) * sigma * (bounds[1] - bounds[0]));
            });
            return;
        }

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

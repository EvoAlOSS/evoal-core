package de.evoal.optimisation.ea.main.operators;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EAttribute;

import de.evoal.core.api.ecore.misc.EClassifierHelper;

import de.evoal.optimisation.ea.api.genotype.BitGenes;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;

/**
 * Bit-flip mutation (DL type {@code 'bit-flip-mutation'}): a mutated bit is inverted. On a
 *   model it inverts the boolean attributes.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.bit-flip-mutation")
public class BitFlipMutation extends AbstractMutation {
    public BitFlipMutation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     * @param geneProbability The probability that a bit is inverted, {@code NaN} for 1 / n.
     */
    public BitFlipMutation(final double probability, final double geneProbability) {
        super(probability, geneProbability);
    }

    @Override
    protected Optional<Predicate<EAttribute>> modelAttributes(final ModelGenes.Context context) {
        return Optional.of(attribute -> EClassifierHelper.isBoolean(attribute.getEType()));
    }

    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        if(genes instanceof ModelGenes models) {
            mutateModel(models, geneProbability, random, (slot, context, randomness) -> slot.set(!((Boolean) slot.get())));
            return;
        }

        final BitGenes bits = (BitGenes) genes;

        for(int bit = 0; bit < bits.size(); ++bit) {
            if(random.nextDouble() < geneProbability) {
                bits.flip(bit);
            }
        }
    }

    @Override
    public String name() {
        return "bit-flip-mutation";
    }
}

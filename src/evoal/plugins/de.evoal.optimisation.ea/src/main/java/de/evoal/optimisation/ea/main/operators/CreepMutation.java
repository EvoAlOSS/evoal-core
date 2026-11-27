package de.evoal.optimisation.ea.main.operators;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.ecore.info.FeatureScales;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;

import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.IntegerGenes;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;

/**
 * Creep mutation (DL type {@code 'creep-mutation'}): a mutated gene changes by a value drawn
 *   uniformly from -step, ..., -1, 1, ..., step. The algorithm brings values outside the
 *   boundaries back with its boundary handling. On a model it changes the integer and the enum
 *   attributes of at least ordinal scale; an enum value moves by the change in the order of
 *   the literals, and the boundary handling keeps it among the literals.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.creep-mutation")
public class CreepMutation extends AbstractMutation {
    /**
     * The largest change of a gene.
     */
    private int step = 1;

    public CreepMutation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     * @param geneProbability The probability that a gene is changed, {@code NaN} for 1 / n.
     * @param step The largest change of a gene.
     */
    public CreepMutation(final double probability, final double geneProbability, final int step) {
        super(probability, geneProbability);
        this.step = step;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        step = attributes.attributeToInteger(configuration, "step");
    }

    @Override
    protected Optional<Predicate<EAttribute>> modelAttributes(final ModelGenes.Context context) {
        return Optional.of(attribute -> {
            final boolean isOrdered = EClassifierHelper.isInteger(attribute.getEType()) || attribute.getEType() instanceof EEnum;

            return isOrdered && FeatureScales.scaleOf(attribute).getValue() >= ScaleType.ORDINAL.getValue();
        });
    }

    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        if(genes instanceof ModelGenes models) {
            mutateModel(models, geneProbability, random, (slot, context, randomness) -> {
                final int change = drawChange(randomness);
                if(slot.attribute().getEType() instanceof EEnum eEnum) {
                    final List<EEnumLiteral> literals = eEnum.getELiterals();
                    final int index = literals.indexOf(eEnum.getEEnumLiteral(((Enumerator) slot.get()).getName()));
                    final long moved = context.handling().apply((long) index + change, 0L, literals.size() - 1L);
                    slot.set(literals.get((int) moved).getInstance());
                } else {
                    final long value = ((Number) slot.get()).longValue();
                    slot.set(NumericConversions.toType(value + change, slot.attribute().getEType()));
                }
            });
            return;
        }

        final IntegerGenes integers = (IntegerGenes) genes;

        for(int gene = 0; gene < integers.size(); ++gene) {
            if(random.nextDouble() < geneProbability) {
                integers.set(gene, integers.get(gene) + drawChange(random));
            }
        }
    }

    /**
     * @return A change drawn uniformly from the 2 * step values -step, ..., -1, 1, ..., step.
     */
    private int drawChange(final RandomGenerator random) {
        final int draw = random.nextInt(2 * step);

        return draw < step ? draw - step : draw - step + 1;
    }

    @Override
    public String name() {
        return "creep-mutation";
    }
}

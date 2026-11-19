package de.evoal.optimisation.ea.main.operators;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;

import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.IntegerGenes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;

/**
 * Creep mutation (DL type {@code 'creep-mutation'}): a mutated gene changes by a value drawn
 *   uniformly from -step, ..., -1, 1, ..., step. The algorithm brings values outside the
 *   boundaries back with its boundary handling.
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
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        final IntegerGenes integers = (IntegerGenes) genes;

        for(int gene = 0; gene < integers.size(); ++gene) {
            if(random.nextDouble() < geneProbability) {
                // 2 * step values without 0
                final int draw = random.nextInt(2 * step);
                final int change = draw < step ? draw - step : draw - step + 1;
                integers.set(gene, integers.get(gene) + change);
            }
        }
    }

    @Override
    public String name() {
        return "creep-mutation";
    }
}

package de.evoal.optimisation.ea.main.operators;

import java.util.Arrays;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.operators.AbstractRecombination;

/**
 * Multi-point crossover (DL type {@code 'multi-point-crossover'}): {@code points} different
 *   cut points are chosen uniformly between two genes, and the children exchange every second
 *   segment, starting with the segment after the first cut. A chromosome with fewer genes
 *   than {@code points + 1} gets one cut between every two genes.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.multi-point-crossover")
public class MultiPointCrossover extends AbstractRecombination {
    /**
     * The number of cut points.
     */
    private int points = 2;

    public MultiPointCrossover() {
    }

    /**
     * @param probability The probability that the recombination is applied to a pair.
     * @param points The number of cut points.
     */
    public MultiPointCrossover(final double probability, final int points) {
        super(probability);
        this.points = points;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        points = attributes.attributeToInteger(configuration, "points");
    }

    @Override
    public String name() {
        return "multi-point-crossover";
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        final int size = first.size();
        if(size < 2) {
            return;
        }

        final int[] cuts = cutPoints(size, Math.min(points, size - 1), random);

        boolean exchanged = false;
        int next = 0;
        for(int gene = 0; gene < size; ++gene) {
            if(next < cuts.length && gene == cuts[next]) {
                exchanged = !exchanged;
                next += 1;
            }
            if(exchanged) {
                first.exchange(second, gene);
            }
        }
    }

    /**
     * @return {@code count} different cut points between 1 and {@code size - 1}, sorted; a
     *   partial Fisher-Yates shuffle draws them uniformly.
     */
    private static int[] cutPoints(final int size, final int count, final RandomGenerator random) {
        final int[] candidates = new int[size - 1];
        for(int i = 0; i < candidates.length; ++i) {
            candidates[i] = i + 1;
        }

        for(int i = 0; i < count; ++i) {
            final int j = random.nextInt(i, candidates.length);
            final int swap = candidates[i];
            candidates[i] = candidates[j];
            candidates[j] = swap;
        }

        final int[] cuts = Arrays.copyOf(candidates, count);
        Arrays.sort(cuts);

        return cuts;
    }
}

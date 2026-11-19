package de.evoal.optimisation.ea.main.alterer.model.crossover;

import de.evoal.core.api.utils.Requirements;
import de.evoal.optimisation.ea.api.codec.model.ModelChromosome;
import de.evoal.optimisation.ea.api.codec.model.ModelGene;
import de.evoal.languages.model.base.expressions.Instance;
import io.jenetics.Genotype;
import io.jenetics.Phenotype;
import io.jenetics.Recombinator;
import io.jenetics.util.MSeq;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.util.EcoreUtil;

@Slf4j
public abstract class TreeCrossover<A extends Comparable<? super A>> extends Recombinator<ModelGene, A> {

    /**
     * Constructs an alterer with a given recombination probability.
     *
     * @param probability The recombination probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *                                  valid range of {@code [0, 1]} or the given {@code order} is
     *                                  smaller than two.
     */
    protected TreeCrossover(double probability) {
        super(probability, 2);
    }

    protected abstract void crossover(final Instance tree1, final Instance tree2);

    @Override
    protected int recombine(final MSeq<Phenotype<ModelGene, A>> population, int[] individuals, long generation) {
        Requirements.requireEqual(2, individuals.length);
        log.info("Recombining {} and {}.", individuals[0], individuals[1]);

        final Phenotype<ModelGene, A> phenotype1 = population.get(individuals[0]);
        final Phenotype<ModelGene, A> phenotype2 = population.get(individuals[1]);

        final Genotype<ModelGene> genotype1 = phenotype1.genotype();
        final Genotype<ModelGene> genotype2 = phenotype2.genotype();

        final Instance tree1 = EcoreUtil.copy(genotype1.gene().allele());
        final Instance tree2 = EcoreUtil.copy(genotype2.gene().allele());

        crossover(tree1, tree2);

        final ModelChromosome chromosome1 = ModelChromosome.of(((ModelChromosome)genotype1.chromosome()).builder(), tree1);
        final ModelChromosome chromosome2 = ModelChromosome.of(((ModelChromosome)genotype2.chromosome()).builder(), tree2);

        //Creating two new Phenotypes and exchanging it with the old.
        population.set(
                individuals[0],
                Phenotype.of(Genotype.of(chromosome1), generation)
        );
        population.set(
                individuals[1],
                Phenotype.of(Genotype.of(chromosome2), generation)
        );

        return order();
    }
}

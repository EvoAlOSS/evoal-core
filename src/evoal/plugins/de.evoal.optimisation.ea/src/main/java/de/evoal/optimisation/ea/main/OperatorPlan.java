package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory.ConfiguredChromosome;

/**
 * Decides which recombinations and mutations change which chromosomes: every chromosome uses
 *   the recombinations and mutations it lists, in their order. That they apply to it is
 *   checked when the configuration is loaded (the requirements of their DL types, e.g.
 *   {@code @Requires} and {@code @RequiresScale}) and by the operators themselves
 *   ({@link MutationOperator#check}, {@link RecombinationOperator#check}). The uses follow the order of the
 *   chromosomes. A chromosome without recombinations and mutations never
 *   changes, which is logged as a warning.
 *
 * @param recombinations The recombination uses, in the order they are applied.
 * @param mutations The mutation uses, in the order they are applied.
 */
@Slf4j
public record OperatorPlan(List<OperatorUse<RecombinationOperator>> recombinations,
                           List<OperatorUse<MutationOperator>> mutations) {
    /**
     * The prefix of the names of the random streams.
     */
    static final String STREAM = "de.evoal.optimisation.ea";

    public OperatorPlan {
        recombinations = List.copyOf(recombinations);
        mutations = List.copyOf(mutations);
    }

    /**
     * Creates the plan of the configured chromosomes.
     *
     * @param chromosomes The chromosomes with their configurations.
     * @param helper Reads the configurations.
     * @return The plan.
     * @throws InitializationException if an operator cannot be created.
     */
    public static OperatorPlan create(final List<ConfiguredChromosome> chromosomes, final AttributeHelper helper)
            throws InitializationException {
        final List<OperatorUse<RecombinationOperator>> recombinations = plan(chromosomes, helper, "recombination",
                                                                             RecombinationOperator.class);
        final List<OperatorUse<MutationOperator>> mutations = plan(chromosomes, helper, "mutation", MutationOperator.class);
        for(final OperatorUse<RecombinationOperator> use : recombinations) {
            use.operator().check(chromosomes.get(use.chromosome()).chromosome());
        }
        for(final OperatorUse<MutationOperator> use : mutations) {
            use.operator().check(chromosomes.get(use.chromosome()).chromosome());
        }

        final OperatorPlan plan = new OperatorPlan(recombinations, mutations);

        for(final int c : plan.unchangedChromosomes(chromosomes.size())) {
            log.warn("The chromosome {} has neither recombinations nor mutations and never changes.",
                     chromosomes.get(c).chromosome());
        }

        return plan;
    }

    /**
     * @param count The number of chromosomes.
     * @return The indices of the chromosomes that no recombination and no mutation changes,
     *   in ascending order.
     */
    List<Integer> unchangedChromosomes(final int count) {
        return IntStream.range(0, count)
                        .filter(c -> recombinations.stream().noneMatch(use -> use.chromosome() == c))
                        .filter(c -> mutations.stream().noneMatch(use -> use.chromosome() == c))
                        .boxed()
                        .toList();
    }

    private static <T extends EvoalComponent<T>> List<OperatorUse<T>> plan(
            final List<ConfiguredChromosome> chromosomes, final AttributeHelper helper, final String slot, final Class<T> type)
            throws InitializationException {
        final List<OperatorUse<T>> uses = new ArrayList<>();

        for(int c = 0; c < chromosomes.size(); ++c) {
            final ConfiguredChromosome configured = chromosomes.get(c);
            final String prefix = "genotype.chromosomes[" + c + "]." + slot;

            final List<EObject> configurations = helper.lookup(configured.configuration(), slot);
            for(int i = 0; i < configurations.size(); ++i) {
                final EObject configuration = configurations.get(i);
                final T operator = BeanFactory.createComponent(type, configuration);
                uses.add(new OperatorUse<>(operator, c, STREAM + "/" + prefix + "[" + i + "]"));
            }
        }

        return uses;
    }
}

package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.MeasurementScale;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory.ConfiguredChromosome;
import de.evoal.optimisation.ea.main.operators.ApplicabilityReader;

/**
 * Decides which recombinations and mutations change which chromosomes: every chromosome uses
 *   the recombinations and mutations it lists, in their order, and every one of them must
 *   apply to it. The applicability of an operator is read from its DL type. The uses follow
 *   the order of the chromosomes. A chromosome without recombinations and mutations never
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
     * @param factory Gives the scales of the features.
     * @param helper Reads the configurations.
     * @param reader Reads the applicability of the operator types.
     * @return The plan.
     * @throws InitializationException if an operator of a chromosome does not apply to it.
     */
    public static OperatorPlan create(final List<ConfiguredChromosome> chromosomes, final GenotypeFactory factory,
                                      final AttributeHelper helper, final ApplicabilityReader reader)
            throws InitializationException {
        final OperatorPlan plan = new OperatorPlan(
                plan(chromosomes, factory, helper, reader, "recombination", RecombinationOperator.class, RecombinationOperator::name),
                plan(chromosomes, factory, helper, reader, "mutation", MutationOperator.class, MutationOperator::name));

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
            final List<ConfiguredChromosome> chromosomes, final GenotypeFactory factory, final AttributeHelper helper,
            final ApplicabilityReader reader, final String slot, final Class<T> type, final Function<T, String> names)
            throws InitializationException {
        final List<OperatorUse<T>> uses = new ArrayList<>();

        for(int c = 0; c < chromosomes.size(); ++c) {
            final ConfiguredChromosome configured = chromosomes.get(c);
            final Chromosome chromosome = configured.chromosome();
            final List<MeasurementScale> scales = scales(chromosome, factory);
            final String prefix = "genotype.chromosomes[" + c + "]." + slot;

            final List<EObject> configurations = helper.lookup(configured.configuration(), slot);
            for(int i = 0; i < configurations.size(); ++i) {
                final EObject configuration = configurations.get(i);
                final T operator = BeanFactory.createComponent(type, configuration);
                final String reason = reader.of(configuration).reasonAgainst(chromosome, scales);
                if(reason != null) {
                    throw new InitializationException("The " + slot + " '" + names.apply(operator) + "' of the chromosome " + chromosome
                                                      + " does not apply to it: " + reason + ".");
                }
                uses.add(new OperatorUse<>(operator, c, STREAM + "/" + prefix + "[" + i + "]"));
            }
        }

        return uses;
    }

    private static List<MeasurementScale> scales(final Chromosome chromosome, final GenotypeFactory factory) {
        final List<MeasurementScale> scales = new ArrayList<>();
        for(final EStructuralFeature feature : chromosome.features()) {
            scales.add(factory.scaleOf(feature).orElse(null));
        }

        return scales;
    }
}

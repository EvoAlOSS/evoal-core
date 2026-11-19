package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.MeasurementScale;
import de.evoal.optimisation.ea.api.operators.Applicability;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory.ConfiguredChromosome;
import de.evoal.optimisation.ea.main.operators.ApplicabilityReader;
import de.evoal.optimisation.ea.main.operators.BitFlipMutation;
import de.evoal.optimisation.ea.main.operators.PolynomialMutation;
import de.evoal.optimisation.ea.main.operators.RandomResetMutation;
import de.evoal.optimisation.ea.main.operators.SbxCrossover;
import de.evoal.optimisation.ea.main.operators.SinglePointCrossover;
import de.evoal.optimisation.ea.main.operators.UniformCrossover;

/**
 * Decides which recombinations and mutations change which chromosomes:
 * <ul>
 *   <li>a chromosome with operators of its own uses them; each of them must apply to it;</li>
 *   <li>otherwise, it uses the operators of the algorithm that apply to it; the skipped
 *     ones are logged;</li>
 *   <li>if none applies, it uses the first default operator of its representation that
 *     applies (double: {@code 'sbx-crossover'} with probability 0.9, else
 *     {@code 'uniform-crossover'}; {@code 'polynomial-mutation'}, else
 *     {@code 'random-reset-mutation'}; integer: {@code 'uniform-crossover'},
 *     {@code 'random-reset-mutation'}; bit and gray: {@code 'single-point-crossover'},
 *     {@code 'bit-flip-mutation'}).</li>
 * </ul>
 * The applicability of every operator, also of the defaults, is read from its DL type.
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
     * A configured or default operator with its applicability.
     */
    private record Candidate<T>(T operator, String name, Applicability applicability, String stream) {
    }

    /**
     * Creates the plan of an algorithm configuration.
     *
     * @param algorithm The configuration of the algorithm.
     * @param chromosomes The chromosomes with their configurations.
     * @param factory Gives the scales of the features.
     * @param helper Reads the configurations.
     * @param reader Reads the applicability of the operator types.
     * @return The plan.
     * @throws InitializationException if an operator of a chromosome does not apply to it.
     */
    public static OperatorPlan create(final EObject algorithm, final List<ConfiguredChromosome> chromosomes,
                                      final GenotypeFactory factory, final AttributeHelper helper,
                                      final ApplicabilityReader reader) throws InitializationException {
        final ClassDefinition module = ApplicabilityReader.definitionOf(algorithm.eClass());

        final List<OperatorUse<RecombinationOperator>> recombinations =
                plan(algorithm, chromosomes, factory, helper, reader, "recombination", RecombinationOperator.class,
                     RecombinationOperator::name, chromosome -> defaultRecombinations(chromosome, module, reader));
        final List<OperatorUse<MutationOperator>> mutations =
                plan(algorithm, chromosomes, factory, helper, reader, "mutation", MutationOperator.class,
                     MutationOperator::name, chromosome -> defaultMutations(chromosome, module, reader));

        return new OperatorPlan(recombinations, mutations);
    }

    private static <T extends de.evoal.models.core.cdi.EvoalComponent<T>> List<OperatorUse<T>> plan(
            final EObject algorithm, final List<ConfiguredChromosome> chromosomes, final GenotypeFactory factory,
            final AttributeHelper helper, final ApplicabilityReader reader, final String slot, final Class<T> type,
            final Function<T, String> names, final Function<Chromosome, List<Candidate<T>>> defaults)
            throws InitializationException {
        final List<Candidate<T>> global = create(helper.lookup(algorithm, slot), slot, type, names, reader);
        final List<List<Integer>> globalChromosomes = new ArrayList<>();
        global.forEach(operator -> globalChromosomes.add(new ArrayList<>()));

        final List<OperatorUse<T>> own = new ArrayList<>();
        for(int c = 0; c < chromosomes.size(); ++c) {
            final ConfiguredChromosome configured = chromosomes.get(c);
            final Chromosome chromosome = configured.chromosome();
            final List<MeasurementScale> scales = scales(chromosome, factory);
            final String prefix = "genotype.chromosomes[" + c + "]." + slot;

            final List<Candidate<T>> ownOperators = configured.configuration() == null
                    ? List.of()
                    : create(helper.lookup(configured.configuration(), slot), prefix, type, names, reader);

            if(!ownOperators.isEmpty()) {
                for(final Candidate<T> operator : ownOperators) {
                    final String reason = operator.applicability().reasonAgainst(chromosome, scales);
                    if(reason != null) {
                        throw new InitializationException("The " + slot + " '" + operator.name() + "' of the chromosome " + chromosome
                                                          + " does not apply to it: " + reason + ".");
                    }
                    own.add(new OperatorUse<>(operator.operator(), List.of(c), operator.stream()));
                }
                continue;
            }

            boolean used = false;
            for(int g = 0; g < global.size(); ++g) {
                final Candidate<T> operator = global.get(g);
                final String reason = operator.applicability().reasonAgainst(chromosome, scales);
                if(reason == null) {
                    globalChromosomes.get(g).add(c);
                    used = true;
                } else {
                    log.warn("The {} '{}' skips the chromosome {}: {}.", slot, operator.name(), chromosome, reason);
                }
            }

            if(!used) {
                final Candidate<T> fallback = defaults.apply(chromosome)
                                                      .stream()
                                                      .filter(operator -> operator.applicability().reasonAgainst(chromosome, scales) == null)
                                                      .findFirst()
                                                      .orElseThrow(() -> new InitializationException("No " + slot + " applies to the chromosome "
                                                                                                     + chromosome + "."));
                log.info("The chromosome {} uses the default {} '{}'.", chromosome, slot, fallback.name());
                own.add(new OperatorUse<>(fallback.operator(), List.of(c), STREAM + "/default.chromosomes[" + c + "]." + slot));
            }
        }

        final List<OperatorUse<T>> uses = new ArrayList<>();
        for(int g = 0; g < global.size(); ++g) {
            if(globalChromosomes.get(g).isEmpty()) {
                log.warn("The {} '{}' applies to no chromosome.", slot, global.get(g).name());
                continue;
            }
            uses.add(new OperatorUse<>(global.get(g).operator(), globalChromosomes.get(g), global.get(g).stream()));
        }
        uses.addAll(own);

        return uses;
    }

    private static <T extends de.evoal.models.core.cdi.EvoalComponent<T>> List<Candidate<T>> create(
            final List<EObject> configurations, final String slot, final Class<T> type, final Function<T, String> names,
            final ApplicabilityReader reader) {
        final List<Candidate<T>> operators = new ArrayList<>();

        for(int i = 0; i < configurations.size(); ++i) {
            final EObject configuration = configurations.get(i);
            final T operator = BeanFactory.createComponent(type, configuration);
            operators.add(new Candidate<>(operator, names.apply(operator), reader.of(configuration),
                                          STREAM + "/" + slot + "[" + i + "]"));
        }

        return operators;
    }

    private static List<Candidate<RecombinationOperator>> defaultRecombinations(final Chromosome chromosome,
                                                                                final ClassDefinition module,
                                                                                final ApplicabilityReader reader) {
        final List<RecombinationOperator> operators = switch(chromosome.representation()) {
            case DOUBLE -> List.of(new SbxCrossover(0.9, 15.0), new UniformCrossover(1.0, 0.5));
            case INTEGER -> List.of(new UniformCrossover(1.0, 0.5));
            case BIT, GRAY -> List.of(new SinglePointCrossover(1.0));
        };

        return defaults(operators, RecombinationOperator::name, module, reader);
    }

    private static List<Candidate<MutationOperator>> defaultMutations(final Chromosome chromosome,
                                                                      final ClassDefinition module,
                                                                      final ApplicabilityReader reader) {
        final List<MutationOperator> operators = switch(chromosome.representation()) {
            case DOUBLE -> List.of(new PolynomialMutation(1.0, Double.NaN, 20.0), new RandomResetMutation(1.0, Double.NaN));
            case INTEGER -> List.of(new RandomResetMutation(1.0, Double.NaN));
            case BIT, GRAY -> List.of(new BitFlipMutation(1.0, Double.NaN));
        };

        return defaults(operators, MutationOperator::name, module, reader);
    }

    private static <T> List<Candidate<T>> defaults(final List<T> operators, final Function<T, String> names,
                                                   final ClassDefinition module, final ApplicabilityReader reader) {
        return operators.stream()
                        .map(operator -> new Candidate<>(operator, names.apply(operator), reader.of(module, names.apply(operator)), null))
                        .toList();
    }

    private static List<MeasurementScale> scales(final Chromosome chromosome, final GenotypeFactory factory) {
        final List<MeasurementScale> scales = new ArrayList<>();
        for(final EStructuralFeature feature : chromosome.features()) {
            scales.add(factory.scaleOf(feature).orElse(null));
        }

        return scales;
    }
}

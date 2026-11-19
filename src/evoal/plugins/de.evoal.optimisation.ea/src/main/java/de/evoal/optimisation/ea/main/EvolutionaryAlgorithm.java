package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.PropertyValueType;

import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.steps.EvaluateCandidates;
import de.evoal.optimisation.api.steps.ReplacePopulation;
import de.evoal.optimisation.api.steps.SampleCandidates;
import de.evoal.optimisation.api.steps.Step;
import de.evoal.optimisation.api.steps.Template;
import de.evoal.optimisation.api.steps.TemplateAlgorithm;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.replacement.ReplacementStrategy;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.CrowdedOrder;
import de.evoal.optimisation.ea.api.selection.ParetoFronts;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;
import de.evoal.optimisation.ea.main.comparator.CrowdedComparator;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory.ConfiguredChromosome;
import de.evoal.optimisation.ea.main.operators.ApplicabilityReader;
import de.evoal.optimisation.ea.main.selection.Nsga2Selection;

/**
 * An evolutionary algorithm (DL type {@code 'evolutionary-algorithm'}) as a template of
 *   steps. It holds a population of N candidates ({@code 'size-of-population'}).
 * <p>
 * Initialisation:
 * <ol>
 *   <li>Initialization: take N candidates of the {@code 'initialisation'},</li>
 *   <li>FitnessCalculation: evaluate them,</li>
 *   <li>Acceptance: they become the population.</li>
 * </ol>
 * Every generation (lambda = {@code 'number-of-offspring'}):
 * <ol>
 *   <li>Selection: the {@code 'parent-selection'} selects 2 * ceil(lambda / 2) parents,</li>
 *   <li>Adaption: the recombinations recombine every pair into two children,</li>
 *   <li>Adaption: the mutations mutate the first lambda children (see {@link Variation}),</li>
 *   <li>Check: the checks of new candidates, if any are configured; {@code resample} varies
 *     a failed child again,</li>
 *   <li>FitnessCalculation: evaluate the children; unchanged copies keep their evaluation,</li>
 *   <li>Acceptance: the {@code replacement} forms the next population,</li>
 *   <li>Check: the population checks, if any are configured.</li>
 * </ol>
 * With {@code 'crowded-comparator'} and {@code 'nsga2-selection'} (NSGA-II), the
 *   selections compare by front and crowding distance ({@link CrowdedOrder}), the ranks of
 *   the population are its non-dominated fronts, and an Acceptance step sorts the population
 *   into fronts after the initialisation and after a population check.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.evolutionary-algorithm")
@Slf4j
public class EvolutionaryAlgorithm extends TemplateAlgorithm {
    @Inject
    private AttributeEvaluator attributes;

    private BoundaryHandling boundaryHandling;

    /**
     * Evaluates the candidates.
     */
    @Inject
    private Evaluator evaluator;

    @Inject
    private GenotypeFactory genotypes;

    @Inject
    private AttributeHelper helper;

    @Inject @Named("initial")
    private InitialCandidatesProvider initialisation;

    /**
     * The number of children per generation (lambda).
     */
    private int offspring;

    private SelectionMethod parentSelection;

    @Inject
    private Provider<FitnessPipeline> pipelines;

    private OperatorPlan plan;

    @Inject
    private RandomService randomService;

    @Inject
    private ApplicabilityReader reader;

    @Inject
    private ExecutionRecorder recorder;

    private ReplacementStrategy replacement;

    /**
     * The number of candidates in the population (N).
     */
    private int size;

    private Genotype genotype;

    /**
     * Whether the comparator is {@code 'crowded-comparator'} (NSGA-II).
     */
    private boolean crowded;

    /**
     * The order in which the selections compare candidates.
     */
    private CandidateOrder order;

    private static final String PLUS = "plus-replacement";

    private static final String COMMA = "comma-replacement";

    @Override
    protected Set<CheckPoint> checkPoints() {
        return Set.of(CheckPoint.NEW_CANDIDATES, CheckPoint.POPULATION);
    }

    /**
     * @return {@code true}: a child can be varied again for the check reaction
     *   {@code resample}.
     */
    @Override
    protected boolean resamples() {
        return true;
    }

    @Override
    protected void configure(final EObject configuration) throws InitializationException {
        size = attributes.attributeToInteger(configuration, "size-of-population");
        offspring = attributes.attributeToInteger(configuration, "number-of-offspring");

        final EEnumLiteral handling = helper.lookup(configuration, "boundary-handling");
        boundaryHandling = BoundaryHandling.of(handling.getName());

        final EStructuralFeature genotypeFeature = configuration.eClass().getEStructuralFeature("genotype");
        final EObject genotypeConfiguration = configuration.eIsSet(genotypeFeature) ? (EObject) configuration.eGet(genotypeFeature) : null;
        final List<ConfiguredChromosome> chromosomes = genotypes.create(genotypeConfiguration);
        genotype = new Genotype(chromosomes.stream().map(ConfiguredChromosome::chromosome).toList(), genotypes.searchSpace());
        log.info("Genotype: {}.", genotype);

        plan = OperatorPlan.create(configuration, chromosomes, genotypes, helper, reader);

        parentSelection = BeanFactory.createComponent(SelectionMethod.class, helper.<EObject>lookup(configuration, "parent-selection"));
        replacement = BeanFactory.createComponent(ReplacementStrategy.class, helper.<EObject>lookup(configuration, "replacement"));
        replacement.check(size, offspring);

        requireSingleFitness("parent-selection", parentSelection);
        requireSingleFitness("replacement", replacement.selection());

        final EObject comparator = helper.lookup(configuration, "comparator");
        crowded = CrowdedComparator.TYPE.equals(DynamicEClassProvider.dlTypeOf(comparator));
        checkNsga2(parentSelection, replacement, crowded, pipelines.get().layout().components().size());
        order = crowded ? new CrowdedOrder() : CandidateOrder.BY_VALUE;

        recorder.defineProperty(Variation.OPERATORS, PropertyScope.RELATIONSHIP, PropertyValueType.TEXT, true,
                                "The recombinations and mutations that changed the child, in their order.");
        recorder.defineProperty(Variation.CHANGED_FEATURES, PropertyScope.RELATIONSHIP, PropertyValueType.TEXT, true,
                                "The features whose genes differ from the parent whose place the child takes.");

        if(crowded) {
            recorder.defineProperty(CrowdedOrder.FRONT, PropertyScope.INDIVIDUAL, PropertyValueType.INTEGER, false,
                                    "The non-dominated front of the candidate, 0 for the first front.");
            recorder.defineProperty(CrowdedOrder.CROWDING_DISTANCE, PropertyScope.INDIVIDUAL, PropertyValueType.REAL, false,
                                    "The crowding distance of the candidate within its front; Infinity at the boundary of the front.");
        }
    }

    /**
     * Checks the parts of NSGA-II: {@code 'crowded-comparator'} and {@code 'nsga2-selection'}
     *   only together, the selection only directly in {@code 'plus-replacement'} or
     *   {@code 'comma-replacement'} (so that every member of the next population has a front),
     *   and a fitness with at least two components.
     *
     * @param parentSelection The parent selection.
     * @param replacement The replacement.
     * @param crowded Whether the comparator is {@code 'crowded-comparator'}.
     * @param components The number of fitness components.
     * @throws InitializationException if a check fails.
     */
    static void checkNsga2(final SelectionMethod parentSelection, final ReplacementStrategy replacement,
                           final boolean crowded, final int components) throws InitializationException {
        if(parentSelection.sortsIntoFronts()) {
            throw new InitializationException("'nsga2-selection' is a survivor selection; use it as the selection of the "
                                              + "replacement, not as 'parent-selection'.");
        }

        final SelectionMethod survivors = replacement.selection();
        if(!survivors.sortsIntoFronts()) {
            if(crowded) {
                throw new InitializationException("'crowded-comparator' needs 'nsga2-selection' as the selection of the "
                                                  + "replacement, which computes the fronts and crowding distances.");
            }
            return;
        }

        if(!(survivors instanceof Nsga2Selection)) {
            throw new InitializationException("'nsga2-selection' cannot be nested in '" + survivors.name()
                                              + "'; use it directly as the selection of the replacement.");
        }
        if(!PLUS.equals(replacement.name()) && !COMMA.equals(replacement.name())) {
            throw new InitializationException("'nsga2-selection' needs '" + PLUS + "' or '" + COMMA + "', not '"
                                              + replacement.name() + "': every member of the next population needs a front.");
        }
        if(!crowded) {
            throw new InitializationException("'nsga2-selection' needs 'crowded-comparator' as 'comparator'.");
        }

        if(components < 2) {
            throw new InitializationException("NSGA-II needs a fitness with at least two components, but the fitness has "
                                              + components + "; remove the scalarisation step from 'fitness-pipeline'.");
        }
    }

    /**
     * @throws InitializationException if the selection uses the fitness itself, but the
     *   fitness has not exactly one component.
     */
    private void requireSingleFitness(final String slot, final SelectionMethod selection) throws InitializationException {
        final int components = pipelines.get().layout().components().size();

        if(selection.needsSingleFitness() && components != 1) {
            throw new InitializationException("The " + slot + " '" + selection.name() + "' needs a fitness with one component, "
                                              + "but the fitness has " + components + "; add a scalarisation step such as "
                                              + "'weighted-sum' to 'fitness-pipeline'.");
        }
    }

    /**
     * @return The constraint group of the constrained domination of {@code 'nsga2-selection'};
     *   {@code null} without NSGA-II or without a group.
     */
    private String constraintGroup() {
        if(replacement.selection() instanceof Nsga2Selection nsga2) {
            return nsga2.group().orElse(null);
        }

        return null;
    }

    @Override
    protected Template template() {
        final Variation variation = new Variation(genotype, plan, boundaryHandling, randomService);

        final List<Step> initialisationSteps = new ArrayList<>(List.of(new SampleCandidates(initialisation, size),
                                                                       new EvaluateCandidates(evaluator),
                                                                       new ReplacePopulation()));
        final String constraintGroup = constraintGroup();
        if(crowded) {
            initialisationSteps.add(GenerationSteps.sortIntoFronts(constraintGroup));
        }

        final List<Step> generation = new ArrayList<>();
        generation.add(GenerationSteps.selectParents(parentSelection, offspring, order,
                                                     randomService.random(OperatorPlan.STREAM + "/parent-selection")));
        generation.add(GenerationSteps.recombine(variation, offspring));
        generation.add(GenerationSteps.mutate(variation, offspring));
        generation.addAll(newCandidateChecks(GenerationSteps.resampler(variation)));
        generation.add(new EvaluateCandidates(evaluator));
        generation.add(GenerationSteps.replace(replacement, size, order,
                                               randomService.random(OperatorPlan.STREAM + "/replacement")));

        final List<Step> checks = populationChecks(evaluator);
        generation.addAll(checks);
        if(crowded && !checks.isEmpty()) {
            generation.add(GenerationSteps.sortIntoFronts(constraintGroup));
        }

        if(!crowded) {
            return new Template(initialisationSteps, generation);
        }

        // NSGA-II: the values are only partially ordered, the ranks are the fronts
        return new Template(initialisationSteps, generation) {
            @Override
            protected List<List<Integer>> ranks(final List<Candidate> members) {
                final List<double[]> fitness = members.stream()
                                                      .map(member -> member.fitness().values())
                                                      .toList();
                final double[] violations = CrowdedOrder.violationsOf(members, constraintGroup);

                return ParetoFronts.fronts(fitness, violations);
            }
        };
    }
}

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
import de.evoal.optimisation.api.steps.EvaluateCandidates;
import de.evoal.optimisation.api.steps.ReplacePopulation;
import de.evoal.optimisation.api.steps.SampleCandidates;
import de.evoal.optimisation.api.steps.Step;
import de.evoal.optimisation.api.steps.Template;
import de.evoal.optimisation.api.steps.TemplateAlgorithm;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.replacement.ReplacementStrategy;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory;
import de.evoal.optimisation.ea.main.genotype.GenotypeFactory.ConfiguredChromosome;
import de.evoal.optimisation.ea.main.operators.ApplicabilityReader;

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
 *   <li>Check: the checks of new candidates, if any are configured,</li>
 *   <li>FitnessCalculation: evaluate the children; unchanged copies keep their evaluation,</li>
 *   <li>Acceptance: the {@code replacement} forms the next population,</li>
 *   <li>Check: the population checks, if any are configured.</li>
 * </ol>
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

    @Override
    protected Set<CheckPoint> checkPoints() {
        return Set.of(CheckPoint.NEW_CANDIDATES, CheckPoint.POPULATION);
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

        recorder.defineProperty(Variation.OPERATORS, PropertyScope.RELATIONSHIP, PropertyValueType.TEXT, true,
                                "The recombinations and mutations that changed the child, in their order.");
        recorder.defineProperty(Variation.CHANGED_FEATURES, PropertyScope.RELATIONSHIP, PropertyValueType.TEXT, true,
                                "The features whose genes differ from the parent whose place the child takes.");
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

    @Override
    protected Template template() {
        final Variation variation = new Variation(genotype, plan, boundaryHandling, randomService);

        final List<Step> initialisationSteps = List.of(new SampleCandidates(initialisation, size),
                                                       new EvaluateCandidates(evaluator),
                                                       new ReplacePopulation());

        final List<Step> generation = new ArrayList<>();
        generation.add(GenerationSteps.selectParents(parentSelection, offspring,
                                                     randomService.random(OperatorPlan.STREAM + "/parent-selection")));
        generation.add(GenerationSteps.recombine(variation, offspring));
        generation.add(GenerationSteps.mutate(variation, offspring));
        generation.addAll(newCandidateChecks());
        generation.add(new EvaluateCandidates(evaluator));
        generation.add(GenerationSteps.replace(replacement, size, randomService.random(OperatorPlan.STREAM + "/replacement")));
        generation.addAll(populationChecks(evaluator));

        return new Template(initialisationSteps, generation);
    }
}

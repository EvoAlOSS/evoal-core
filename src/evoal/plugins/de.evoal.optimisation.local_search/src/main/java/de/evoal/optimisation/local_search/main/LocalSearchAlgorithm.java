package de.evoal.optimisation.local_search.main;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.run.OptimisationRun;
import de.evoal.optimisation.api.steps.FitnessCalculation;
import de.evoal.optimisation.api.steps.ReplacePopulation;
import de.evoal.optimisation.api.steps.SampleCandidates;
import de.evoal.optimisation.api.steps.Step;
import de.evoal.optimisation.api.steps.Template;

import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;

/**
 * A local search (DL type {@code 'local-search'}) as a template of steps. It holds a single
 *   candidate.
 * <p>
 * Initialisation:
 * <ol>
 *   <li>Initialization: take the first candidate of the {@code 'initialisation'},</li>
 *   <li>FitnessCalculation: evaluate it,</li>
 *   <li>Acceptance: it becomes the current candidate.</li>
 * </ol>
 * Every iteration:
 * <ol>
 *   <li>Adaption: offer the neighbours of the current candidate ({@link OfferNeighbours}),</li>
 *   <li>FitnessCalculation: evaluate them one after the other until the accepting strategy
 *     accepts one,</li>
 *   <li>Acceptance: move to the accepted neighbour, or end the search
 *     ({@link AcceptNeighbour}),</li>
 *   <li>ParameterAdjustment: pass the iteration to the accepting strategy
 *     ({@link AdjustAcceptingStrategy}).</li>
 * </ol>
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.local-search")
public class LocalSearchAlgorithm implements OptimisationAlgorithm {
    private AcceptingStrategy acceptingStrategy;

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    /**
     * The stopping criterion to use.
     */
    private TerminationCriterion criterion;

    /**
     * Evaluates and counts the candidates.
     */
    @Inject
    private EvaluationService evaluationService;

    @Inject
    private AttributeHelper helper;

    @Inject
    private TerminationCriterionProducer producer;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    @Inject @Named("neighbour-strategy")
    private NeighbourChoosingStrategy strategy;

    /**
     * Executes the run.
     */
    @Inject
    private OptimisationRun kernel;

    /**
     * Publishes the executed steps.
     */
    @Inject
    private RunEventDispatcher events;

    @Override
    public OptimisationAlgorithm init(final EObject instance) {
        criterion = producer.create(instance);
        final EObject acceptingConfiguration = helper.lookup(instance, "accepting-strategy");
        acceptingStrategy = BeanFactory.createComponent(AcceptingStrategy.class, acceptingConfiguration);

        return this;
    }

    @Override
    public void run() {
        log.info("Setting up local search algorithm.");

        kernel.execute(criterion, template());
    }

    /**
     * @return The template of the local search.
     */
    private Template template() {
        final List<Step> initialisation = List.of(new SampleCandidates(provider, 1),
                                                  new FitnessCalculation(evaluationService, comparator),
                                                  new ReplacePopulation());

        final AcceptNeighbour acceptance = new AcceptNeighbour(acceptingStrategy);
        final List<Step> iteration = List.of(new OfferNeighbours(strategy, acceptingStrategy),
                                             FitnessCalculation.untilAccepted(evaluationService, comparator,
                                                                              acceptance::isAcceptable),
                                             acceptance,
                                             new AdjustAcceptingStrategy(acceptingStrategy));

        return new Template(events, initialisation, iteration);
    }
}

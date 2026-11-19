package de.evoal.optimisation.local_search.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;

import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.steps.EvaluateCandidates;
import de.evoal.optimisation.api.steps.ReplacePopulation;
import de.evoal.optimisation.api.steps.SampleCandidates;
import de.evoal.optimisation.api.steps.Step;
import de.evoal.optimisation.api.steps.Template;
import de.evoal.optimisation.api.steps.TemplateAlgorithm;

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
 *     ({@link AdjustAcceptingStrategy}),</li>
 *   <li>Check: apply the population checks of {@code 'candidate-checks'} to the current
 *     candidate, if any are configured, e.g., a random restart by {@code 'maximum-age'}.</li>
 * </ol>
 */
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.local-search")
public class LocalSearchAlgorithm extends TemplateAlgorithm {
    private AcceptingStrategy acceptingStrategy;

    /**
     * Evaluates the candidates.
     */
    @Inject
    private Evaluator evaluator;

    @Inject
    private AttributeHelper helper;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    @Inject @Named("neighbour-strategy")
    private NeighbourChoosingStrategy strategy;

    @Override
    protected void configure(final EObject configuration) {
        final EObject acceptingConfiguration = helper.lookup(configuration, "accepting-strategy");
        acceptingStrategy = BeanFactory.createComponent(AcceptingStrategy.class, acceptingConfiguration);
    }

    /**
     * @return The population: the current candidate is checked at the end of every
     *   iteration.
     */
    @Override
    protected Set<CheckPoint> checkPoints() {
        return Set.of(CheckPoint.POPULATION);
    }

    @Override
    protected Template template() {
        final List<Step> initialisation = List.of(new SampleCandidates(provider, 1),
                                                  new EvaluateCandidates(evaluator),
                                                  new ReplacePopulation());

        final AcceptNeighbour acceptance = new AcceptNeighbour(acceptingStrategy);
        final List<Step> iteration = new ArrayList<>(List.of(new OfferNeighbours(strategy, acceptingStrategy),
                                                              EvaluateCandidates.untilAccepted(evaluator, acceptance::isAcceptable),
                                                              acceptance,
                                                              new AdjustAcceptingStrategy(acceptingStrategy)));
        iteration.addAll(populationChecks(evaluator));

        return new Template(initialisation, iteration);
    }
}

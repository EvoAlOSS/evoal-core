package de.evoal.optimisation.random_search.main;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

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

/**
 * Random search (DL type {@code 'random-search'}) as a template of steps. The
 *   initialisation and every iteration consist of the same steps:
 * <ol>
 *   <li>Initialization: sample the next candidates from the {@code 'initialisation'},</li>
 *   <li>FitnessCalculation: evaluate them,</li>
 *   <li>Acceptance: they replace the population.</li>
 * </ol>
 * The run kernel keeps the best candidate found so far.
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.random_search.optimisation.random-search")
public class RandomSearchAlgorithm implements OptimisationAlgorithm {
    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    /**
     * The stopping criterion.
     */
    private TerminationCriterion criterion;

    /**
     * Evaluates and counts the candidates.
     */
    @Inject
    private EvaluationService evaluationService;

    /**
     * Publishes the executed steps.
     */
    @Inject
    private RunEventDispatcher events;

    @Inject
    private AttributeHelper helper;

    @Inject
    private TerminationCriterionProducer producer;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    /**
     * Executes the run.
     */
    @Inject
    private OptimisationRun kernel;

    /**
     * The number of candidates per iteration.
     */
    private int samplesPerIteration;

    @Override
    public OptimisationAlgorithm init(final EObject configuration) {
        criterion = producer.create(configuration);
        samplesPerIteration = helper.<Integer>lookup(configuration, "samples-per-iteration");

        return this;
    }

    @Override
    public void run() {
        log.info("Running random search with {} samples per iteration.", samplesPerIteration);

        final List<Step> steps = List.of(new SampleCandidates(provider, samplesPerIteration),
                                         new FitnessCalculation(evaluationService, comparator),
                                         new ReplacePopulation());
        final Template template = new Template(events, steps, steps);

        kernel.execute(criterion, template);
    }
}

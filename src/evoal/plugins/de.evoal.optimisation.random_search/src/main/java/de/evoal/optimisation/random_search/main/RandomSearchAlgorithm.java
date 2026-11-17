package de.evoal.optimisation.random_search.main;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.AttributeHelper;

import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.steps.EvaluateCandidates;
import de.evoal.optimisation.api.steps.ReplacePopulation;
import de.evoal.optimisation.api.steps.SampleCandidates;
import de.evoal.optimisation.api.steps.Step;
import de.evoal.optimisation.api.steps.Template;
import de.evoal.optimisation.api.steps.TemplateAlgorithm;

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
@Dependent
@Named("de.evoal.optimisation.random_search.optimisation.random-search")
public class RandomSearchAlgorithm extends TemplateAlgorithm {
    /**
     * Evaluates the candidates.
     */
    @Inject
    private Evaluator evaluator;

    @Inject
    private AttributeHelper helper;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    /**
     * The number of candidates per iteration.
     */
    private int samplesPerIteration;

    @Override
    protected void configure(final EObject configuration) {
        samplesPerIteration = helper.<Integer>lookup(configuration, "samples-per-iteration");
    }

    @Override
    protected Template template() {
        final List<Step> steps = List.of(new SampleCandidates(provider, samplesPerIteration),
                                         new EvaluateCandidates(evaluator),
                                         new ReplacePopulation());

        return new Template(steps, steps);
    }
}

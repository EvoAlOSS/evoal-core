package de.evoal.optimisation.main.stopping;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.model.StagnationMeasure;

/**
 * Stops when a measure of the recorded fitness (e.g. the best or the mean fitness of an
 *   iteration) has not improved for a number of iterations, an improvement-based criterion
 *   like ImpBest and ImpAv in K. Zielinski, P. Weitkemper, R. Laur, K.-D. Kammeyer:
 *   Examination of Stopping Criteria for Differential Evolution based on a Power Allocation
 *   Problem. 10th International Conference on Optimization of Electrical and Electronic
 *   Equipment (OPTIM), 2006. The tolerance rule is described in {@link Stagnation}.
 * <p>
 * The measures need a fitness with one component. The state starts anew in iteration 0, so
 *   every run starts fresh.
 */
@Dependent
@Named("de.evoal.optimisation.core.stagnation")
@Slf4j
public class StagnationCriterion extends TerminationCriterionImpl {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The number of iterations without improvement after which the run stops.
     */
    private int iterations;

    /**
     * The measure of an iteration.
     */
    private StagnationMeasure measure;

    /**
     * Provides the fitness components of the configuration.
     */
    @Inject
    private FitnessPipeline pipeline;

    /**
     * The improvements and iterations without improvement of the current run.
     */
    private Stagnation stagnation;

    /**
     * @throws InitializationException if the fitness has more than one component or a
     *   tolerance is negative.
     */
    @Override
    public TerminationCriterion init(final EObject configuration) throws InitializationException {
        requireOneComponent(pipeline.layout());

        iterations = evaluator.attributeToInteger(configuration, "iterations");
        final double absoluteTolerance = evaluator.attributeToDouble(configuration, "absolute-tolerance");
        final double relativeTolerance = evaluator.attributeToDouble(configuration, "relative-tolerance");
        try {
            stagnation = new Stagnation(absoluteTolerance, relativeTolerance);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException("The stopping criterion 'stagnation': " + e.getMessage());
        }

        final EObject measureConfiguration = evaluator.attributeToEObject(configuration, "measure");
        measure = BeanFactory.createComponent(StagnationMeasure.class, measureConfiguration);

        return this;
    }

    /**
     * @throws InitializationException if the layout has more than one component.
     */
    private static void requireOneComponent(final FitnessLayout layout) throws InitializationException {
        if(layout.size() != 1) {
            throw new InitializationException("The stopping criterion 'stagnation' needs a fitness with one component, "
                                              + "but the fitness has the components " + layout
                                              + ". Add a scalarisation, e.g. 'weighted-sum', to the 'fitness-pipeline'.");
        }
    }

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        if(iteration.getNumber() == 0) {
            stagnation.reset();
        }

        final double value = measure.measure(iteration);
        final boolean improvement = stagnation.update(value);
        log.info("Check termination: measure {} in iteration {} ({}), reference {}, {} of {} iterations without improvement.",
                 value, iteration.getNumber(), improvement ? "improvement" : "no improvement", stagnation.reference(),
                 stagnation.iterationsWithoutImprovement(), iterations);

        return stagnation.iterationsWithoutImprovement() >= iterations;
    }
}

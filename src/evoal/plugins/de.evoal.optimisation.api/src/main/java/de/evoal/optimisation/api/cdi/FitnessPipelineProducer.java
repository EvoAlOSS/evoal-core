package de.evoal.optimisation.api.cdi;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.fitness.FitnessStep;
import de.evoal.optimisation.api.fitness.Goals;

/**
 * Creates the {@link FitnessPipeline} of the current optimisation configuration: the goals
 *   of the problem and the steps of the algorithm's {@code 'fitness-pipeline'}.
 */
@ApplicationScoped
public class FitnessPipelineProducer {
    @Inject
    private Blackboard board;

    @Inject
    private AttributeHelper helper;

    /**
     * @return The fitness pipeline of the current optimisation configuration.
     */
    @Produces
    @Dependent
    public FitnessPipeline create() {
        final EObject configuration = board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
        final Problem problem = helper.lookup(configuration, "problem");
        final EObject algorithm = helper.lookup(configuration, "algorithm");
        final Goals goals = Goals.of(problem);
        final List<FitnessStep> steps = createSteps(algorithm);

        return new FitnessPipeline(goals, steps);
    }

    private List<FitnessStep> createSteps(final EObject algorithm) {
        final List<Configuration> configurations = helper.lookup(algorithm, "fitness-pipeline");

        return configurations.stream()
                             .map(configuration -> BeanFactory.createComponent(FitnessStep.class, configuration))
                             .toList();
    }
}

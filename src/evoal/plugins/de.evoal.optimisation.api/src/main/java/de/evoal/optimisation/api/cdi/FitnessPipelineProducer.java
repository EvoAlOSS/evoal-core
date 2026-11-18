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
import de.evoal.optimisation.api.fitness.TargetDistance;

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
     * Creates the goals of the current problem. The target of a goal {@code towards target}
     *   is the current target point of the evaluation. The goals are created for every
     *   injection, i.e. for every run, so they follow the evaluation's target points.
     *
     * @return The goals of the current problem.
     */
    @Produces
    @Dependent
    public Goals createGoals() {
        final EObject configuration = board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
        final Problem problem = helper.lookup(configuration, "problem");
        final EObject targetPoint = board.getOrNull(OptimisationBlackboardEntries.TARGET_PROPERTIES);

        return Goals.of(problem, targetPoint, FitnessPipelineProducer::createDistance);
    }

    /**
     * @param goals The goals of the current problem.
     * @return The fitness pipeline of the current optimisation configuration.
     */
    @Produces
    @Dependent
    public FitnessPipeline createPipeline(final Goals goals) {
        final EObject configuration = board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
        final EObject algorithm = helper.lookup(configuration, "algorithm");
        final List<FitnessStep> steps = createSteps(algorithm);

        return new FitnessPipeline(goals, steps);
    }

    private static TargetDistance createDistance(final Configuration configuration) {
        return BeanFactory.createComponent(TargetDistance.class, configuration);
    }

    private List<FitnessStep> createSteps(final EObject algorithm) {
        final List<Configuration> configurations = helper.lookup(algorithm, "fitness-pipeline");

        return configurations.stream()
                             .map(configuration -> BeanFactory.createComponent(FitnessStep.class, configuration))
                             .toList();
    }
}

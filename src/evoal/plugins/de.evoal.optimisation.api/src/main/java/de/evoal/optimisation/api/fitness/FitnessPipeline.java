package de.evoal.optimisation.api.fitness;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * Computes the fitness of a candidate from its objectives.
 * <p>
 * The pipeline starts with the objectives as {@code double}s, one component per goal
 *   (integers up to 2^53 are exact). Then the steps run in order: first the
 *   {@link DirectionStep}, which converts the objectives into the canonical direction
 *   (minimisation), then the steps configured in {@code 'fitness-pipeline'}, in their
 *   order. The layouts of the steps are folded when the pipeline is built, so the
 *   components of the final fitness are known before the first evaluation.
 */
public final class FitnessPipeline {
    /**
     * The goals of the problem.
     */
    private final Goals goals;

    /**
     * The components of the fitness before the first step: one per goal.
     */
    private final FitnessLayout initialLayout;

    /**
     * The components of the fitness the pipeline returns.
     */
    private final FitnessLayout layout;

    /**
     * The steps, in the order in which they run.
     */
    private final List<FitnessStep> steps;

    /**
     * @param goals The goals of the problem.
     * @param configuredSteps The steps configured in {@code 'fitness-pipeline'}, in their
     *   order; they run after the direction step.
     * @throws IllegalArgumentException if a {@link Scalarisation} is not the last step.
     */
    public FitnessPipeline(final Goals goals, final List<FitnessStep> configuredSteps) {
        requireScalarisationIsLast(configuredSteps);

        this.goals = goals;
        this.initialLayout = FitnessLayout.of(goals);
        this.steps = Stream.concat(Stream.of(new DirectionStep()), configuredSteps.stream())
                           .toList();
        this.layout = foldLayouts();
    }

    /**
     * Computes the fitness of a candidate.
     *
     * @param input The candidate (a point of the search space).
     * @param objectives The result of the optimisation function for the candidate.
     * @return The fitness.
     * @throws IllegalStateException if a step returns a fitness with other components than
     *   it declared.
     */
    public Fitness apply(final TypedEObject input, final TypedEObject objectives) {
        final FitnessContext context = new FitnessContext(input, objectives, goals);
        Fitness fitness = toInitialFitness(objectives);

        for(final FitnessStep step : steps) {
            fitness = step.apply(context, fitness);
        }

        if(!layout.equals(fitness.layout())) {
            throw new IllegalStateException("The fitness pipeline returned the components " + fitness.layout()
                                            + " instead of " + layout + ".");
        }

        return fitness;
    }

    private FitnessLayout foldLayouts() {
        FitnessLayout result = initialLayout;

        for(final FitnessStep step : steps) {
            result = step.layout(result);
        }

        return result;
    }

    /**
     * @return The goals of the problem.
     */
    public Goals goals() {
        return goals;
    }

    /**
     * @return The components of the fitness the pipeline returns.
     */
    public FitnessLayout layout() {
        return layout;
    }

    /**
     * @return The steps, in the order in which they run.
     */
    public List<FitnessStep> steps() {
        return steps;
    }

    /**
     * Checks that only the last step is a {@link Scalarisation}, so a pipeline has at most
     *   one. There is no check in the language yet.
     */
    private static void requireScalarisationIsLast(final List<FitnessStep> configuredSteps) {
        final int lastIndex = configuredSteps.size() - 1;
        final boolean scalarisationBeforeLast = IntStream.range(0, lastIndex)
                                                         .mapToObj(configuredSteps::get)
                                                         .anyMatch(Scalarisation.class::isInstance);

        if(scalarisationBeforeLast) {
            throw new IllegalArgumentException("A scalarisation must be the last step of 'fitness-pipeline', and a"
                                               + " pipeline has at most one: " + configuredSteps + ".");
        }
    }

    private Fitness toInitialFitness(final TypedEObject objectives) {
        final double[] values = new double[goals.size()];

        for(int index = 0; index < values.length; ++index) {
            final Goal goal = goals.get(index);

            values[index] = objectives.eGetAsDouble(goal.objective());
        }

        return new Fitness(initialLayout, values);
    }
}

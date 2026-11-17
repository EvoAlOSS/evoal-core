package de.evoal.optimisation.api.fitness;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * A step of the {@link FitnessPipeline}: computes a new fitness from the fitness of the
 *   previous step. Steps configured in OL are instances of the DL type
 *   {@code 'fitness-step'}.
 * <p>
 * A step that changes the components (e.g. adds or removes one) declares this in
 *   {@link #layout(FitnessLayout)}, and the fitness it returns has exactly that layout.
 */
public interface FitnessStep extends EvoalComponent<FitnessStep> {
    /**
     * Computes the new fitness of a candidate.
     *
     * @param context The candidate, its objectives and the goals.
     * @param current The fitness computed by the previous steps.
     * @return The new fitness.
     */
    Fitness apply(FitnessContext context, Fitness current);

    /**
     * Declares the components of the fitness this step returns. It is called once, when the
     *   pipeline is built. The default keeps the components.
     *
     * @param input The components of the fitness the step gets.
     * @return The components of the fitness the step returns.
     */
    default FitnessLayout layout(final FitnessLayout input) {
        return input;
    }
}

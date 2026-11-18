package de.evoal.optimisation.api.fitness;

/**
 * A {@link FitnessStep} that reduces the fitness to one component, e.g. a weighted sum.
 *   Scalarisations are instances of the DL type {@code 'scalarisation'}.
 * <p>
 * A scalarisation must be the last step of a {@link FitnessPipeline}, and a pipeline has at
 *   most one.
 */
public interface Scalarisation extends ChangesUnits {
}

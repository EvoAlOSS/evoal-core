/**
 * The fitness pipeline: how the objectives of a candidate become its fitness.
 * <p>
 * The optimisation function computes the objectives of a candidate. The
 *   {@link de.evoal.optimisation.api.fitness.FitnessPipeline} turns them into the
 *   {@link de.evoal.optimisation.api.fitness.Fitness}: a vector of {@code double}s in the
 *   canonical direction (smaller is better), described by a
 *   {@link de.evoal.optimisation.api.fitness.FitnessLayout}. The first step converts each
 *   objective according to its {@link de.evoal.optimisation.api.fitness.Goal}
 *   ({@link de.evoal.optimisation.api.fitness.DirectionStep}); further
 *   {@link de.evoal.optimisation.api.fitness.FitnessStep}s are configured in
 *   {@code 'fitness-pipeline'} of the algorithm.
 * <p>
 * An {@link de.evoal.optimisation.api.fitness.Evaluator} evaluates a candidate and returns
 *   an {@link de.evoal.optimisation.api.fitness.Evaluation}: the objectives, the fitness and
 *   the optimisation value of the comparator
 *   ({@link de.evoal.optimisation.api.model.OptimisationValueComparator#toValue(de.evoal.models.core.ecore.TypedEObject, Fitness)}).
 *   The numeric and the hierarchical comparator compare the fitness; the weighted-sum and
 *   the epsilon comparator still compare the objectives.
 */
package de.evoal.optimisation.api.fitness;

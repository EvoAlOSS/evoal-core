/**
 * The run kernel shared by the optimisation algorithms.
 * <p>
 * An algorithm describes only its search ({@link de.evoal.optimisation.api.run.SearchProcedure}):
 *   how it creates the initial candidates, what one iteration does, and which candidates it
 *   currently holds ({@link de.evoal.optimisation.api.run.Population}). The kernel
 *   ({@link de.evoal.optimisation.api.run.OptimisationRun}) does the rest of the run: the
 *   {@link de.evoal.core.api.cdi.RunScoped} context, the run events, the iteration numbers,
 *   the termination check, the handling of an exhausted evaluation budget, and the memory
 *   model of every iteration (individual ids, lineage, ranks and the best individual so far).
 */
package de.evoal.optimisation.api.run;

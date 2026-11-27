/**
 * The run kernel shared by the optimisation algorithms.
 * <p>
 * An algorithm describes only its search ({@link de.evoal.optimisation.api.run.SearchProcedure}):
 *   how it creates the initial candidates, what one iteration does, and which candidates it
 *   currently holds ({@link de.evoal.optimisation.api.run.Population} of
 *   {@link de.evoal.optimisation.api.run.Candidate}s). The kernel
 *   ({@link de.evoal.optimisation.api.run.OptimisationRun}) does the rest of the run: the
 *   run events, the iteration numbers, the termination check, the handling of an exhausted
 *   evaluation budget, and the memory model of every iteration (individual ids, lineage,
 *   ranks and the best individual so far).
 * <p>
 * The {@link de.evoal.optimisation.api.run.SearchRunner} drives the runs of an application:
 *   it opens the {@link de.evoal.core.api.cdi.EvaluationScoped} scope of the evaluation and the
 *   {@link de.evoal.core.api.cdi.RunScoped} scope of every run, whose parameters
 *   ({@link de.evoal.optimisation.api.run.RunParameters}) the components of the run read from
 *   {@link de.evoal.optimisation.api.run.CurrentRun}.
 */
package de.evoal.optimisation.api.run;

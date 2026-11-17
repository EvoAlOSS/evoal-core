/**
 * The step model of the optimisation algorithms, after the unified meta-algorithm model
 *   (Berger, Plump, Drechsler: <em>Understandability and (self-)explainability in
 *   Optimisation Algorithms</em>, section 3.4, Fig. 3).
 * <p>
 * An algorithm is a {@link de.evoal.optimisation.api.steps.Template}: the steps of the
 *   initialisation and the steps of one iteration. The steps work on a
 *   {@link de.evoal.optimisation.api.steps.SearchState}. The kinds of steps are
 *   {@link de.evoal.optimisation.api.steps.Initialization},
 *   {@link de.evoal.optimisation.api.steps.Selection},
 *   {@link de.evoal.optimisation.api.steps.Adaption},
 *   {@link de.evoal.optimisation.api.steps.FitnessCalculation},
 *   {@link de.evoal.optimisation.api.steps.Acceptance} and
 *   {@link de.evoal.optimisation.api.steps.ParameterAdjustment}. The {@code Loop} with its
 *   termination criterion and the {@code Generation Increment} of the meta-model are
 *   executed by the run kernel ({@link de.evoal.optimisation.api.run.OptimisationRun}).
 * <p>
 * The templates are written in Java for now. They are designed to map one-to-one to DL
 *   types later, when the step structure becomes configurable in OL.
 */
package de.evoal.optimisation.api.steps;

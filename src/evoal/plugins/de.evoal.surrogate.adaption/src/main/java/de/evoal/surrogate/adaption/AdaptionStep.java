package de.evoal.surrogate.adaption;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.inject.Inject;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.fitness.DirectionStep;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessContext;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.fitness.RequiresObjectiveUnits;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.SurrogateModelProvider;

/**
 * Base class of the surrogate adaptions: fitness steps that adapt the components of the
 *   objectives predicted by the surrogate model, depending on how reliable the prediction
 *   is. Other components stay unchanged.
 * <p>
 * The adaption formulas work on objective values (see #288 for their redefinition on the
 *   canonical fitness). So a step converts the canonical value of a component back into the
 *   value of its objective, adapts it and converts the result back. This is only possible
 *   for {@code minimise} and {@code maximise} goals; components of target goals are
 *   rejected. Chained adaptions see the result of the previous one.
 * <p>
 * The surrogate is the optimisation function of the current run. It is looked up, and the
 *   information stored with it is read, when the pipeline is built, so a model without the
 *   required information fails at the start of the run.
 */
public abstract class AdaptionStep implements RequiresObjectiveUnits {
    @Inject
    private EvaluationService evaluations;

    /**
     * The positions of the adapted components in {@link #resolvedLayout}.
     */
    private int[] adaptedIndices;

    /**
     * The objectives this step adapts, by name; {@code null} until the step is prepared.
     */
    private Set<String> adaptedObjectives;

    /**
     * The layout {@link #adaptedIndices} was resolved for; all candidates of a run share it.
     */
    private FitnessLayout resolvedLayout;

    @Override
    public Fitness apply(final FitnessContext context, final Fitness current) {
        final FitnessLayout layout = current.layout();
        final int[] indices = adaptedIndicesOf(layout);
        final double[] values = current.values();

        for(final int index : indices) {
            final FitnessComponent component = layout.component(index);
            final Goal goal = component.goal().orElseThrow();
            final double objectiveValue = DirectionStep.toObjective(goal, values[index]);
            final double adaptedValue = adapt(context.input(), goal.name(), objectiveValue);

            values[index] = DirectionStep.toCanonical(goal, adaptedValue);
        }

        return new Fitness(layout, values);
    }

    /**
     * @throws IllegalArgumentException if a predicted objective has a target goal.
     * @throws IllegalStateException if the surrogate model lacks the information the step
     *   needs.
     */
    @Override
    public FitnessLayout layout(final FitnessLayout input) {
        adaptedIndicesOf(input);

        return input;
    }

    /**
     * Adapts the value of an objective.
     *
     * @param candidate The candidate (a point of the search space).
     * @param objective The name of the adapted objective.
     * @param value The value of the objective, possibly adapted by previous steps.
     * @return The adapted value of the objective.
     */
    protected abstract double adapt(TypedEObject candidate, String objective, double value);

    /**
     * Reads the information the step needs from the surrogate model. It is called once,
     *   when the pipeline is built.
     *
     * @return The names of the objectives the step adapts.
     * @throws IllegalStateException if the surrogate model lacks the information.
     */
    protected abstract Set<String> prepare();

    /**
     * @return The surrogate model of the current run.
     * @throws IllegalStateException if the optimisation function is not backed by a
     *   surrogate model.
     */
    protected ModelFunctionData surrogate() {
        final OptimisationFunction function = evaluations.optimisationFunction();

        if(!(function instanceof SurrogateModelProvider provider)) {
            throw new IllegalStateException("The surrogate adaption needs a surrogate as optimisation function, but the function is '"
                                            + function + "'.");
        }

        return provider.getModelFunctionData();
    }

    private int[] adaptedIndicesOf(final FitnessLayout layout) {
        if(layout == resolvedLayout) {
            return adaptedIndices;
        }

        if(adaptedObjectives == null) {
            adaptedObjectives = Set.copyOf(prepare());
        }

        final List<Integer> indices = new ArrayList<>();
        for(int index = 0; index < layout.size(); ++index) {
            final FitnessComponent component = layout.component(index);
            final boolean isAdapted = component.goal()
                                               .map(Goal::name)
                                               .filter(adaptedObjectives::contains)
                                               .isPresent();

            if(isAdapted) {
                requireNoTarget(component);
                indices.add(index);
            }
        }

        adaptedIndices = indices.stream()
                                .mapToInt(Integer::intValue)
                                .toArray();
        resolvedLayout = layout;

        return adaptedIndices;
    }

    private void requireNoTarget(final FitnessComponent component) {
        final Goal goal = component.goal().orElseThrow();

        if(goal instanceof Goal.Target) {
            throw new IllegalArgumentException("'" + this + "' cannot adapt '" + component.name() + "', which has a"
                                               + " target goal. The adaption formulas are only defined for minimise"
                                               + " and maximise goals (see #288).");
        }
    }
}

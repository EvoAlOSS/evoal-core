package de.evoal.optimisation.main.comparator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;

import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.fitness.Goals;

/**
 * Creates the value conversions for the evolutionary algorithm, which still compares the
 *   objectives instead of the fitness: every objective is converted so that a larger value
 *   is better.
 */
@ApplicationScoped
public class ComparatorFactory {
    /**
     * @param goals The goals of the current problem, with the targets resolved.
     * @return The conversion of every objective, so that a larger value is better.
     */
    @Produces @Dependent @Named("optimisation-value-conversions")
    public Map<EStructuralFeature, Function<Number, Number>> createValueConversions(final Goals goals) {
        final Map<EStructuralFeature, Function<Number, Number>> valueConversions = new HashMap<>();

        for(final Goal goal : goals.goals()) {
            final Function<Number, Number> conversion = toFunction(goal);
            valueConversions.put(goal.objective(), conversion);
        }

        return valueConversions;
    }

    private static Function<Number, Number> toFunction(final Goal goal) {
        return switch(goal) {
            case Goal.Maximise maximise -> Function.identity();
            case Goal.Minimise minimise -> value -> ArithmeticNumberOperations.multiply(value, -1);
            case Goal.Target target -> value -> toNegativeDistance(target, value);
        };
    }

    private static Number toNegativeDistance(final Goal.Target target, final Number value) {
        final double objectiveValue = NumericConversions.toDouble(value);
        final double distance = target.distanceOf(objectiveValue);

        return 0.0 - distance;
    }
}

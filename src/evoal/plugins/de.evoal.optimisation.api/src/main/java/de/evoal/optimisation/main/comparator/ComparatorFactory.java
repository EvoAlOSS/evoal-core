package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.ol.*;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class ComparatorFactory {
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem")
    private Instance problem;

    @Produces @Dependent @Named("optimisation-value-conversions")
    public List<Function<Double, Double>> createValueConversions() {
        return ((ProblemInstance)problem).getOptimisationSpace()
                    .stream()
                    .map(this::toFunction)
                    .collect(Collectors.toUnmodifiableList());
    }

    private Function<Double, Double> toFunction(final OptimisationGoal goal) {
        if(goal instanceof MaximiseGoal max) {
            return Function.identity();
        } else if(goal instanceof MinimiseGoal min) {
            return value -> value * -1.0;
        } else if(goal instanceof TargetGoal target) {
            return value -> Math.abs(value - ((Number)target.getValue().getValue()).doubleValue()) * -1.0;
        } else {
            throw new IllegalArgumentException("Unsupported goal type: " + goal.getClass().getName());
        }
    }
}
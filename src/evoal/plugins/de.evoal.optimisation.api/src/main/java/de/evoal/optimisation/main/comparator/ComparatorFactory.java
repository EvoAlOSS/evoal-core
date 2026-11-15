package de.evoal.optimisation.main.comparator;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.optimisation.model.*;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@ApplicationScoped
@Slf4j
public class ComparatorFactory {
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem")
    private EObject problem;

    @Produces @Dependent @Named("optimisation-value-conversions")
    public Map<EStructuralFeature, Function<Number, Number>> createValueConversions(final @Named("optimisation-space") Space optimisationSpace, final EAnnotationHelper helper) {
        final Map<EStructuralFeature, Function<Number, Number>> valueConversions = new HashMap<>();
        final Map<DataDescription, EStructuralFeature> features = helper.featuresOf(optimisationSpace);

        ((Problem)problem).getGoals()
                    .forEach(goal -> {
                        final EStructuralFeature feature = goal.getData();
                        final EClassifier definition = feature.getEType();
                        final Function<Number, Number> mapping = toFunction(goal);

                        valueConversions.put(feature, mapping);
                    });

        return valueConversions;
    }

    private Function<Number, Number> toFunction(final OptimisationGoal goal) {
        return switch (goal) {
            case MaximiseGoal max -> Function.identity();
            case MinimiseGoal min -> value -> ArithmeticNumberOperations.multiply(value, -1);
            case TargetGoal target ->
                value -> ArithmeticNumberOperations.multiply(ArithmeticNumberOperations.abs(ArithmeticNumberOperations.minus(value, target.getValue())), -1);
            default -> throw new IllegalArgumentException("Unsupported goal type: " + goal.getClass().getName());
        };
    }
}
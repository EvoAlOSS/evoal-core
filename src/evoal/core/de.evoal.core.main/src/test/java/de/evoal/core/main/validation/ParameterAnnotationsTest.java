package de.evoal.core.main.validation;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.core.main.validation.constraints.TestCheckers;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.definitions.Parameter;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.interpreter.ConstantEvaluator;

/**
 * Annotations on the parameters of a {@code def}, on {@code functions.dl} and {@code calls.ddl} in
 *   {@code de/evoal/core/test/parameters}: {@code weigh} needs an ordinal feature and a weight
 *   in [0, 1], {@code group} at least two features. The first two calls are valid, the other
 *   three break one rule each.
 */
public class ParameterAnnotationsTest {
    private final EObject calls = LanguageHelper.loadFromClasspath("de/evoal/core/test/parameters/calls.ddl");

    /**
     * An argument the validator passed on: the function, the parameter and the computed value.
     */
    private record Argument(String function, Parameter parameter, Object value) {
    }

    /**
     * @return The arguments of every call, in the order of the calls.
     */
    private List<Argument> arguments() {
        final List<Argument> arguments = new ArrayList<>();
        final ConstraintValidator recording = new ConstraintValidator() {
            @Override
            public void checkArgument(final @NonNull DiagnosticsContext context,
                                      final @NonNull FunctionDefinition function,
                                      final @NonNull Parameter parameter,
                                      final @NonNull Expression argument) {
                arguments.add(new Argument(function.getName(), parameter, new ConstantEvaluator().doSwitch(argument)));
            }
        };

        new CallConstraintValidator(recording).validate(calls.eResource());

        return arguments;
    }

    @Test
    public void theParametersCarryTheirAnnotations() {
        final List<Argument> arguments = arguments();

        Assertions.assertEquals(List.of("weigh", "weigh", "group", "weigh", "weigh", "weigh", "weigh", "group"),
                                arguments.stream().map(Argument::function).toList());
        Assertions.assertEquals(1, arguments.get(0).parameter().getConstraints().size());
        Assertions.assertEquals(2, arguments.get(1).parameter().getConstraints().size());
        Assertions.assertEquals(1, arguments.get(2).parameter().getConstraints().size());
    }

    @Test
    public void everyArgumentIsCheckedAgainstTheAnnotationsOfItsParameter() {
        final List<ConstraintCheck> checks = arguments().stream()
                                                        .map(argument -> TestCheckers.check(argument.parameter(), argument.value()))
                                                        .toList();

        // weigh(level, 0.5) and group([level, colour]) are valid
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, checks.get(0));
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, checks.get(1));
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, checks.get(2));

        // weigh(colour, 0.5): colour is nominal
        final ConstraintCheck.Violated nominal = Assertions.assertInstanceOf(ConstraintCheck.Violated.class, checks.get(3));
        Assertions.assertEquals("needs data of at least ordinal scale, but 'colour' is nominal", nominal.message());
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, checks.get(4));

        // weigh(level, 1.5): the weight is above 1
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, checks.get(5));
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, checks.get(6));

        // group([level]): one feature
        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, checks.get(7));
    }
}

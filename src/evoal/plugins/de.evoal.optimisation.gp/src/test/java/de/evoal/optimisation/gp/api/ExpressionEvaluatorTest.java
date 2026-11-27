package de.evoal.optimisation.gp.api;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.gp.Expressions;

/**
 * The evaluation of expressions built from the library and the terminals x0, x1 and c.
 */
public class ExpressionEvaluatorTest {
    private final Expressions expressions = new Expressions("de/evoal/optimisation/gp/test/terms.dl");

    private final ExpressionEvaluator evaluator = new ExpressionEvaluator(ExpressionFunctions.standard(),
                                                                          Map.of(expressions.test("x0"), 0,
                                                                                 expressions.test("x1"), 1));

    private double evaluate(final EObject root, final double x0, final double x1) {
        return evaluator.evaluate(root, new double[] {x0, x1});
    }

    @Test
    public void everyFunctionIsEvaluated() {
        // given
        final EObject x0 = expressions.variable("x0");
        final EObject x1 = expressions.variable("x1");

        // then
        Assertions.assertEquals(5.0, evaluate(expressions.function("plus", expressions.variable("x0"), expressions.variable("x1")), 2, 3));
        Assertions.assertEquals(-1.0, evaluate(expressions.function("minus", expressions.variable("x0"), expressions.variable("x1")), 2, 3));
        Assertions.assertEquals(6.0, evaluate(expressions.function("multiply", expressions.variable("x0"), expressions.variable("x1")), 2, 3));
        Assertions.assertEquals(0.5, evaluate(expressions.function("protected-division", x0, x1), 1, 2));
        Assertions.assertEquals(3.0, evaluate(expressions.function("protected-square-root", expressions.constant("c", 9.0)), 0, 0));
        Assertions.assertEquals(8.0, evaluate(expressions.function("protected-power", expressions.variable("x0"),
                                                                   expressions.variable("x1")), 2, 3));
    }

    @Test
    public void aTreeCombinesItsSubtrees() {
        // given: 5 * x0 * x0 * x0 + 42
        final EObject cube = expressions.function("multiply", expressions.variable("x0"),
                                                  expressions.function("multiply", expressions.variable("x0"),
                                                                       expressions.variable("x0")));
        final EObject root = expressions.function("plus",
                                                  expressions.function("multiply", expressions.constant("c", 5.0), cube),
                                                  expressions.constant("c", 42.0));

        // when
        final ExpressionEvaluator.CompiledExpression compiled = evaluator.compile(root);

        // then
        Assertions.assertEquals(42.0, compiled.evaluate(new double[] {0, 0}));
        Assertions.assertEquals(-4999999958.0, compiled.evaluate(new double[] {-1000, 0}));
        Assertions.assertEquals(82.0, compiled.evaluate(new double[] {2, 7}));
    }

    @Test
    public void theProtectedFunctionsAreDefinedEverywhere() {
        // then: protected division by 0
        final EObject division = expressions.function("protected-division", expressions.variable("x0"), expressions.variable("x1"));
        Assertions.assertEquals(1.0, evaluate(division, 7, 0));
        Assertions.assertEquals(1.0, evaluate(division, 0, 0));
        Assertions.assertEquals(1.0, evaluate(division, 7, -0.0));

        // then: the root of a negative number is the root of its absolute value
        final EObject root = expressions.function("protected-square-root", expressions.variable("x0"));
        Assertions.assertEquals(2.0, evaluate(root, -4, 0));

        // then: |base|^exponent, 1 if the power is not finite
        final EObject power = expressions.function("protected-power", expressions.variable("x0"), expressions.variable("x1"));
        Assertions.assertEquals(2.0, evaluate(power, -8, 1.0 / 3.0), 1e-12);
        Assertions.assertEquals(1.0, evaluate(power, 0, -1), "0^-1 is infinite");
        Assertions.assertEquals(1.0, evaluate(power, 10, 400), "10^400 overflows");
        Assertions.assertEquals(1.0, evaluate(power, 5, 0));
    }

    @Test
    public void anOverflowOfOtherFunctionsIsKept() {
        // given
        final EObject product = expressions.function("multiply", expressions.variable("x0"), expressions.variable("x1"));

        // then
        Assertions.assertEquals(Double.POSITIVE_INFINITY, evaluate(product, 1e200, 1e200));
    }

    @Test
    public void theLibraryAndTheTerminalsHaveNoProblems() {
        // given
        final EClass root = expressions.library("expression");
        final List<EClass> types = expressions.dynamicClasses().concreteSubclassesOf(root);

        // then
        Assertions.assertEquals(9, types.size(), "six functions, two variables and a constant");
        Assertions.assertEquals(List.of(), evaluator.problemsOf(types));
    }

    @Test
    public void anUnboundVariableIsAProblem() {
        // given
        final ExpressionEvaluator onlyX0 = new ExpressionEvaluator(ExpressionFunctions.standard(),
                                                                   Map.of(expressions.test("x0"), 0));
        final List<EClass> types = expressions.dynamicClasses().concreteSubclassesOf(expressions.library("expression"));

        // then
        Assertions.assertEquals(List.of("the variable type de.evoal.optimisation.gp.test.terms.x1 has no binding"),
                                onlyX0.problemsOf(types));
        final IllegalArgumentException failure = Assertions.assertThrows(IllegalArgumentException.class,
                                                                         () -> onlyX0.compile(expressions.variable("x1")));
        Assertions.assertTrue(failure.getMessage().contains("neither a bound variable"), failure.getMessage());
    }

    @Test
    public void unknownFunctionsAndConstantsWithoutRealValueAreProblems() {
        // given
        final Expressions broken = new Expressions("de/evoal/optimisation/gp/test/broken.dl");
        final ExpressionEvaluator brokenEvaluator = new ExpressionEvaluator(ExpressionFunctions.standard(),
                                                                            Map.of(broken.test("x0"), 0));
        final List<EClass> types = List.of(broken.test("x0"), broken.test("integer-constant"), broken.test("sine"));

        // then
        Assertions.assertEquals(List.of("the constant type de.evoal.optimisation.gp.test.broken.integer-constant needs exactly "
                                        + "one real attribute 'value'",
                                        "the type de.evoal.optimisation.gp.test.broken.sine is neither a variable, a constant "
                                        + "nor a function"),
                                brokenEvaluator.problemsOf(types));
    }
}

package de.evoal.optimisation.main.constraints;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.definitions.UntypedBaseDataDescription;
import de.evoal.languages.model.base.expressions.AddOrSubtractExpression;
import de.evoal.languages.model.base.expressions.AddOrSubtractOperator;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.ComparisonExpression;
import de.evoal.languages.model.base.expressions.ComparisonOperator;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator;
import de.evoal.languages.model.base.expressions.Parantheses;
import de.evoal.languages.model.base.expressions.PartialComparisonExpression;
import de.evoal.languages.model.base.expressions.PowerOfExpression;
import de.evoal.languages.model.base.expressions.ReadExpression;
import de.evoal.languages.model.base.expressions.RealLiteral;
import de.evoal.languages.model.base.expressions.StringLiteral;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.ddl.DdlFactory;
import de.evoal.languages.model.ol.MinimiseGoal;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintKind;
import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.LinearForm;

/**
 * The {@link ConstraintCompiler} on DDL constraints that are built as syntax trees: a problem
 *   searches for {@code x0} and {@code x1} and minimises {@code y}; {@code z} is declared, but
 *   not used by the problem.
 */
public class ConstraintCompilerTest {
    private static final ExpressionsFactory EXPRESSIONS = ExpressionsFactory.eINSTANCE;

    private final ConstraintCompiler compiler = new ConstraintCompiler(new EAnnotationHelper());

    private final DataDescriptionModule module = DdlFactory.eINSTANCE.createDataDescriptionModule();

    private final DataDescription x0 = description("x0");

    private final DataDescription x1 = description("x1");

    private final DataDescription y = description("y");

    private final DataDescription z = description("z");

    private EClass objectiveClass;

    private EClass searchClass;

    private static Call call(final String function, final Expression... parameters) {
        final FunctionDefinition definition = DefinitionsFactory.eINSTANCE.createFunctionDefinition();
        definition.setName(function);

        final Call call = EXPRESSIONS.createCall();
        call.setFunction(definition);
        call.getParameters().addAll(List.of(parameters));

        return call;
    }

    private static ComparisonExpression comparison(final AddOrSubtractExpression left,
                                                   final ComparisonOperator operator,
                                                   final AddOrSubtractExpression right) {
        final PartialComparisonExpression partial = EXPRESSIONS.createPartialComparisonExpression();
        partial.setOperator(operator);
        partial.setSubExpression(right);

        final ComparisonExpression comparison = EXPRESSIONS.createComparisonExpression();
        comparison.setLeftOperand(left);
        comparison.getComparison().add(partial);

        return comparison;
    }

    private Call constraint(final Expression comparison, final String group) {
        final StringLiteral groupLiteral = EXPRESSIONS.createStringLiteral();
        groupLiteral.setLiteral(group);

        final Call call = call("constraint", comparison, groupLiteral);
        module.getConstraints().add(call);

        return call;
    }

    private static TypeDefinitionReference data(final DataDescription description) {
        final TypeDefinitionReference reference = EXPRESSIONS.createTypeDefinitionReference();
        reference.setDefinition(description);

        return reference;
    }

    private DataDescription description(final String name) {
        final UntypedBaseDataDescription description = DefinitionsFactory.eINSTANCE.createUntypedBaseDataDescription();
        description.setName(name);
        description.setRepresentation(RepresentationType.REAL);
        module.getDescriptions().add(description);

        return description;
    }

    private static RealLiteral number(final double value) {
        final RealLiteral literal = EXPRESSIONS.createRealLiteral();
        literal.setLiteral(value);

        return literal;
    }

    /**
     * @return The sum {@code first op second}.
     */
    private static AddOrSubtractExpression sum(final ReadExpression first,
                                               final AddOrSubtractOperator operator,
                                               final ReadExpression second) {
        final AddOrSubtractExpression sum = term(first);
        sum.getOperators().add(operator);
        sum.getOperands().add(factor(second));

        return sum;
    }

    /**
     * @return The product {@code first op second}.
     */
    private static AddOrSubtractExpression product(final ReadExpression first,
                                                   final MultiplyDivideModuloOperator operator,
                                                   final ReadExpression second) {
        final MultiplyDivideModuloExpression product = factor(first);
        product.getOperators().add(operator);
        product.getOperands().add(power(second));

        final AddOrSubtractExpression sum = EXPRESSIONS.createAddOrSubtractExpression();
        sum.setLeftOperand(product);

        return sum;
    }

    /**
     * @return The expression in parentheses, usable as an operand.
     */
    private static Parantheses parentheses(final Expression expression) {
        final Parantheses parentheses = EXPRESSIONS.createParantheses();
        parentheses.setSubExpression(expression);

        return parentheses;
    }

    private static MultiplyDivideModuloExpression factor(final ReadExpression operand) {
        final MultiplyDivideModuloExpression factor = EXPRESSIONS.createMultiplyDivideModuloExpression();
        factor.setLeftOperand(power(operand));

        return factor;
    }

    private static PowerOfExpression power(final ReadExpression operand) {
        final UnaryAddOrSubtractExpression unary = EXPRESSIONS.createUnaryAddOrSubtractExpression();
        unary.setSubExpression(operand);

        final PowerOfExpression power = EXPRESSIONS.createPowerOfExpression();
        power.setLeftOperand(unary);

        return power;
    }

    /**
     * @return A single operand as the operand of a comparison.
     */
    private static AddOrSubtractExpression term(final ReadExpression operand) {
        final AddOrSubtractExpression sum = EXPRESSIONS.createAddOrSubtractExpression();
        sum.setLeftOperand(factor(operand));

        return sum;
    }

    private EStructuralFeature feature(final EClass eClass, final String name) {
        return eClass.getEStructuralFeature(name);
    }

    private TypedEObject searchPoint(final double valueOfX0, final double valueOfX1) {
        final TypedEObject point = new Space(searchClass).newEObject();
        point.eSet(feature(searchClass, "x0"), valueOfX0);
        point.eSet(feature(searchClass, "x1"), valueOfX1);

        return point;
    }

    private TypedEObject objectives(final double valueOfY) {
        final TypedEObject point = new Space(objectiveClass).newEObject();
        point.eSet(feature(objectiveClass, "y"), valueOfY);

        return point;
    }

    private Constraints compile() {
        return compiler.compile(searchClass.getEAllStructuralFeatures(), objectiveClass.getEAllStructuralFeatures());
    }

    @BeforeEach
    public void createProblem() {
        final ProblemInstance problem = OLFactory.eINSTANCE.createProblemInstance();
        problem.getSearchSpace().add(data(x0));
        problem.getSearchSpace().add(data(x1));

        final MinimiseGoal goal = OLFactory.eINSTANCE.createMinimiseGoal();
        goal.setData(data(y));
        problem.getOptimisationSpace().add(goal);

        final Pair<EClass, EClass> spaces = new EClassProvider().eClassFor(problem);
        searchClass = spaces.getFirst();
        objectiveClass = spaces.getSecond();
    }

    @Nested
    @DisplayName("given the constraint x0 < x1 in the group 'strict'")
    class LessThan {
        @BeforeEach
        public void declare() {
            constraint(comparison(term(data(x0)), ComparisonOperator.LESS_THAN, term(data(x1))), "strict");
        }

        @Test
        public void theNormalFormIsTheRightMinusTheLeftSide() {
            // when
            final Constraint constraint = compile().get(1);

            // then
            Assertions.assertEquals(ConstraintKind.INEQUALITY, constraint.kind());
            Assertions.assertEquals("strict", constraint.group());
            Assertions.assertEquals(1.5, constraint.valueOf(searchPoint(1.0, 2.5), null));
        }

        @Test
        public void theNormalFormIsLinear() {
            // when
            final Constraint constraint = compile().get(1);

            // then
            final LinearForm linear = constraint.linearForm().orElseThrow();
            Assertions.assertEquals(Map.of(feature(searchClass, "x0"), -1.0, feature(searchClass, "x1"), 1.0),
                                    linear.coefficients());
            Assertions.assertEquals(0.0, linear.constant());
        }

        @Test
        public void theConstraintReadsOnlySearchFeatures() {
            // when
            final Constraint constraint = compile().get(1);

            // then
            Assertions.assertFalse(constraint.usesObjectives());
            Assertions.assertEquals(List.of(feature(searchClass, "x0"), feature(searchClass, "x1")),
                                    constraint.searchFeatures());
        }
    }

    @Nested
    @DisplayName("given the constraint x0 + 2 * x1 >= 3")
    class WeightedSum {
        @BeforeEach
        public void declare() {
            final AddOrSubtractExpression twoTimesX1 = product(number(2.0),
                                                               MultiplyDivideModuloOperator.MULTIPLY,
                                                               data(x1));
            final AddOrSubtractExpression left = sum(data(x0), AddOrSubtractOperator.ADD, parentheses(twoTimesX1));
            constraint(comparison(left, ComparisonOperator.GREATER_EQUAL, term(number(3.0))), "linear");
        }

        @Test
        public void theLinearFormHasTheCoefficientsAndTheConstant() {
            // when
            final LinearForm linear = compile().get(1).linearForm().orElseThrow();

            // then
            Assertions.assertEquals(Map.of(feature(searchClass, "x0"), 1.0, feature(searchClass, "x1"), 2.0),
                                    linear.coefficients());
            Assertions.assertEquals(-3.0, linear.constant());
        }

        @Test
        public void theValueIsTheLeftMinusTheRightSide() {
            // when
            final double value = compile().get(1).valueOf(searchPoint(1.0, 0.5), null);

            // then
            Assertions.assertEquals(-1.0, value);
        }
    }

    @Nested
    @DisplayName("given the non-linear constraint x0 * x1 <= 1")
    class Product {
        @BeforeEach
        public void declare() {
            final AddOrSubtractExpression product = product(data(x0), MultiplyDivideModuloOperator.MULTIPLY, data(x1));
            constraint(comparison(product, ComparisonOperator.LESS_EQUAL, term(number(1.0))), "nonlinear");
        }

        @Test
        public void theConstraintHasNoLinearForm() {
            // when
            final Constraint constraint = compile().get(1);

            // then
            Assertions.assertTrue(constraint.linearForm().isEmpty());
            Assertions.assertEquals(-5.0, constraint.valueOf(searchPoint(2.0, 3.0), null));
        }
    }

    @Nested
    @DisplayName("given the equality x0 = 1 and the objective constraint y < 10")
    class EqualityAndObjective {
        @BeforeEach
        public void declare() {
            constraint(comparison(term(data(x0)), ComparisonOperator.EQUAL, term(number(1.0))), "first");
            constraint(comparison(term(data(y)), ComparisonOperator.LESS_THAN, term(number(10.0))), "second");
        }

        @Test
        public void theConstraintsAreNumberedInTheirOrder() {
            // when
            final Constraints constraints = compile();

            // then
            Assertions.assertEquals(2, constraints.size());
            Assertions.assertEquals(List.of("first", "second"), List.copyOf(constraints.groups()));
            Assertions.assertEquals(ConstraintKind.EQUALITY, constraints.get(1).kind());
        }

        @Test
        public void theObjectiveConstraintReadsTheObjectives() {
            // when
            final Constraint constraint = compile().get(2);

            // then
            Assertions.assertTrue(constraint.usesObjectives());
            Assertions.assertTrue(constraint.linearForm().isEmpty());
            Assertions.assertEquals(6.0, constraint.valueOf(searchPoint(0.0, 0.0), objectives(4.0)));
        }

        @Test
        public void theObjectiveConstraintCannotBeMeasuredWithoutObjectives() {
            // given
            final Constraint constraint = compile().get(2);

            // then
            final TypedEObject input = searchPoint(0.0, 0.0);
            Assertions.assertThrows(IllegalArgumentException.class, () -> constraint.valueOf(input, null));
        }
    }

    @Nested
    @DisplayName("given a standard deviation of x0")
    class StandardDeviation {
        @Test
        public void theConstraintsOfTheFeatureKnowTheDeviation() {
            // given
            module.getConstraints().add(call("standard-deviation", data(x0), number(0.25)));
            constraint(comparison(term(data(x0)), ComparisonOperator.LESS_THAN, term(data(x1))), "strict");

            // when
            final Constraint constraint = compile().get(1);

            // then
            Assertions.assertEquals(Map.of(feature(searchClass, "x0"), 0.25), constraint.deviations());
        }

        // a negative deviation is rejected when the DDL file is loaded, by the annotation of
        // the parameter 'deviation' (constraint.dl)
    }

    @Nested
    @DisplayName("given an unsupported constraint")
    class Unsupported {
        @Test
        public void anUnequalComparisonIsRejected() {
            // given
            constraint(comparison(term(data(x0)), ComparisonOperator.UNEQUAL, term(data(x1))), "strict");

            // then
            Assertions.assertThrows(IllegalArgumentException.class, ConstraintCompilerTest.this::compile);
        }

        @Test
        public void dataOutsideTheProblemIsRejected() {
            // given
            constraint(comparison(term(data(z)), ComparisonOperator.LESS_THAN, term(number(1.0))), "strict");

            // then
            Assertions.assertThrows(IllegalArgumentException.class, ConstraintCompilerTest.this::compile);
        }

        @Test
        public void aConstraintWithoutComparisonIsRejected() {
            // given
            constraint(term(data(x0)), "strict");

            // then
            Assertions.assertThrows(IllegalArgumentException.class, ConstraintCompilerTest.this::compile);
        }

        @Test
        public void aCallInAConstraintIsRejected() {
            // given
            final Call call = call("sin", data(x0));
            constraint(comparison(term(call), ComparisonOperator.LESS_THAN, term(number(1.0))), "strict");

            // then
            Assertions.assertThrows(IllegalArgumentException.class, ConstraintCompilerTest.this::compile);
        }
    }

    @Nested
    @DisplayName("given no constraints")
    class NoConstraints {
        @Test
        public void theProblemHasNoConstraints() {
            Assertions.assertTrue(compile().isEmpty());
        }
    }
}

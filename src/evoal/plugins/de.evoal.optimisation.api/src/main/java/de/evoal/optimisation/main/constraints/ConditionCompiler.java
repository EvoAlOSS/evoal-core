package de.evoal.optimisation.main.constraints;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleBinaryOperator;
import java.util.function.ToDoubleFunction;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.expressions.AddOrSubtractExpression;
import de.evoal.languages.model.base.expressions.AddOrSubtractOperator;
import de.evoal.languages.model.base.expressions.AndExpression;
import de.evoal.languages.model.base.expressions.ComparisonExpression;
import de.evoal.languages.model.base.expressions.ComparisonOperator;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator;
import de.evoal.languages.model.base.expressions.NotExpression;
import de.evoal.languages.model.base.expressions.NumberLiteral;
import de.evoal.languages.model.base.expressions.OrExpression;
import de.evoal.languages.model.base.expressions.Parantheses;
import de.evoal.languages.model.base.expressions.PartialComparisonExpression;
import de.evoal.languages.model.base.expressions.PowerOfExpression;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression;
import de.evoal.languages.model.base.expressions.XorExpression;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;

import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintKind;
import de.evoal.optimisation.api.constraints.FeatureValues;
import de.evoal.optimisation.api.constraints.LinearForm;

/**
 * Compiles the comparison of a DDL constraint into its normal form g:
 *   {@code a > b}, {@code a >= b} and {@code a = b} become {@code a - b},
 *   {@code a < b} and {@code a <= b} become {@code b - a}. The comparison is the only one of the
 *   constraint; the operands are arithmetic expressions ({@code + - * / %}, powers, unary
 *   signs, parentheses) over numbers, search features and objectives. Logical operators,
 *   {@code !=}, calls, strings, booleans and references to other data are rejected.
 * <p>
 * Alongside the function, the compiler tracks whether g is affine in the search features
 *   (sums of features multiplied by constants), which repairs need.
 */
final class ConditionCompiler extends ExpressionsSwitch<ConditionCompiler.Term> {
    /**
     * Whether the comparison is an equality or an inequality; {@code null} until it is found.
     */
    private ConstraintKind kind;

    /**
     * The objectives of the problem by their data description.
     */
    private final Map<DataDescription, EStructuralFeature> objectivesByData;

    /**
     * The objectives the constraint reads, in the order of their first use.
     */
    private final Set<EStructuralFeature> objectivesUsed = new LinkedHashSet<>();

    /**
     * The search features of the problem by their data description.
     */
    private final Map<DataDescription, EStructuralFeature> searchByData;

    /**
     * The search features the constraint reads, in the order of their first use.
     */
    private final Set<EStructuralFeature> searchFeaturesUsed = new LinkedHashSet<>();

    /**
     * @param searchByData The search features of the problem by their data description.
     * @param objectivesByData The objectives of the problem by their data description.
     */
    ConditionCompiler(final Map<DataDescription, EStructuralFeature> searchByData,
                      final Map<DataDescription, EStructuralFeature> objectivesByData) {
        this.searchByData = searchByData;
        this.objectivesByData = objectivesByData;
    }

    @Override
    public Term caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Term result = doSwitch(object.getLeftOperand());

        for(int index = 0; index < object.getOperators().size(); ++index) {
            final AddOrSubtractOperator operator = object.getOperators().get(index);
            final Term operand = doSwitch(object.getOperands().get(index));

            result = switch(operator) {
                case ADD -> result.plus(operand);
                case SUBTRACT -> result.minus(operand);
            };
        }

        return result;
    }

    @Override
    public Term caseAndExpression(final AndExpression object) {
        requireSingle(object.getSubExpressions(), "'and'");

        return doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Term caseComparisonExpression(final ComparisonExpression object) {
        final List<PartialComparisonExpression> comparisons = object.getComparison();

        if(comparisons.isEmpty()) {
            return doSwitch(object.getLeftOperand());
        }

        requireSingle(comparisons, "a chain of comparisons");
        if(kind != null) {
            throw new IllegalArgumentException("a constraint contains exactly one comparison.");
        }

        final PartialComparisonExpression comparison = comparisons.get(0);
        final ComparisonOperator operator = comparison.getOperator();
        final Term left = doSwitch(object.getLeftOperand());
        final Term right = doSwitch(comparison.getSubExpression());

        kind = operator == ComparisonOperator.EQUAL ? ConstraintKind.EQUALITY : ConstraintKind.INEQUALITY;

        return switch(operator) {
            case GREATER_THAN, GREATER_EQUAL, EQUAL -> left.minus(right);
            case LESS_THAN, LESS_EQUAL -> right.minus(left);
            case UNEQUAL -> throw new IllegalArgumentException("'!=' is not supported; use two constraints with '<' "
                                                               + "and '>'.");
        };
    }

    @Override
    public Term caseMultiplyDivideModuloExpression(final MultiplyDivideModuloExpression object) {
        Term result = doSwitch(object.getLeftOperand());

        for(int index = 0; index < object.getOperators().size(); ++index) {
            final MultiplyDivideModuloOperator operator = object.getOperators().get(index);
            final Term operand = doSwitch(object.getOperands().get(index));

            result = switch(operator) {
                case MULTIPLY -> result.times(operand);
                case DIVIDE -> result.dividedBy(operand);
                case MODULO -> result.modulo(operand);
            };
        }

        return result;
    }

    @Override
    public Term caseNotExpression(final NotExpression object) {
        if(object.isNegated()) {
            throw new IllegalArgumentException("'!' is not supported.");
        }

        return doSwitch(object.getOperand());
    }

    @Override
    public Term caseNumberLiteral(final NumberLiteral object) {
        final double value = object.getValue().doubleValue();

        return Term.constant(value);
    }

    @Override
    public Term caseOrExpression(final OrExpression object) {
        requireSingle(object.getSubExpressions(), "'or'");

        return doSwitch(object.getSubExpressions().get(0));
    }

    @Override
    public Term caseParantheses(final Parantheses object) {
        return doSwitch(object.getSubExpression());
    }

    @Override
    public Term casePowerOfExpression(final PowerOfExpression object) {
        final Term base = doSwitch(object.getLeftOperand());

        if(object.getRightOperand() == null) {
            return base;
        }

        final Term exponent = doSwitch(object.getRightOperand());

        return base.power(exponent);
    }

    @Override
    public Term caseTypeDefinitionReference(final TypeDefinitionReference object) {
        final TypeDefinition definition = object.getDefinition();

        if(!(definition instanceof DataDescription description)) {
            throw new IllegalArgumentException("'" + definition.getName() + "' is no data.");
        }

        final EStructuralFeature searchFeature = searchByData.get(description);
        if(searchFeature != null) {
            searchFeaturesUsed.add(searchFeature);

            return Term.searchFeature(searchFeature);
        }

        final EStructuralFeature objective = objectivesByData.get(description);
        if(objective != null) {
            objectivesUsed.add(objective);

            return Term.objective(objective);
        }

        throw new IllegalArgumentException("the data '" + description.getName() + "' is neither searched for nor an "
                                           + "objective of the problem.");
    }

    @Override
    public Term caseUnaryAddOrSubtractExpression(final UnaryAddOrSubtractExpression object) {
        final Term operand = doSwitch(object.getSubExpression());
        final long negations = object.getOperators()
                                     .stream()
                                     .filter(AddOrSubtractOperator.SUBTRACT::equals)
                                     .count();

        return negations % 2 == 0 ? operand : operand.negated();
    }

    @Override
    public Term caseXorExpression(final XorExpression object) {
        requireSingle(object.getSubExpressions(), "'xor'");

        return doSwitch(object.getSubExpressions().get(0));
    }

    /**
     * Compiles a constraint.
     *
     * @param number The position of the constraint in the DDL, from 1.
     * @param group The name of the group.
     * @param text The constraint as written in the DDL.
     * @param comparison The comparison of the constraint.
     * @param deviations The standard deviations of the features of the problem.
     * @return The constraint.
     * @throws IllegalArgumentException if the comparison cannot be compiled.
     */
    Constraint compile(final int number,
                       final String group,
                       final String text,
                       final Expression comparison,
                       final Map<EStructuralFeature, Double> deviations) {
        final Term normalForm = doSwitch(comparison);

        if(kind == null) {
            throw new IllegalArgumentException("a constraint needs a comparison ('<', '<=', '>', '>=' or '=').");
        }

        final Map<EStructuralFeature, Double> constraintDeviations = new LinkedHashMap<>();
        searchFeaturesUsed.stream()
                          .filter(deviations::containsKey)
                          .forEach(feature -> constraintDeviations.put(feature, deviations.get(feature)));
        objectivesUsed.stream()
                      .filter(deviations::containsKey)
                      .forEach(feature -> constraintDeviations.put(feature, deviations.get(feature)));

        final boolean isLinear = normalForm.affine() != null && objectivesUsed.isEmpty();
        final LinearForm linearForm = isLinear ? normalForm.affine().toLinearForm() : null;

        return new Constraint(number,
                              group,
                              text,
                              kind,
                              List.copyOf(searchFeaturesUsed),
                              List.copyOf(objectivesUsed),
                              constraintDeviations,
                              normalForm.function(),
                              linearForm);
    }

    @Override
    public Term defaultCase(final EObject object) {
        final String element = object.eClass().getName();

        final String text = ConstraintCompiler.textOf(object);

        throw new IllegalArgumentException("'" + text + "' (" + element + ") is not supported.");
    }

    private static void requireSingle(final List<?> elements, final String construct) {
        if(elements.size() != 1) {
            throw new IllegalArgumentException(construct + " is not supported.");
        }
    }

    /**
     * An affine function of search features: sum of coefficient(f) * x(f) + constant.
     *
     * @param coefficients The coefficients in the order of the first use of their features.
     * @param constant The constant term.
     */
    record Affine(Map<EStructuralFeature, Double> coefficients, double constant) {
        /**
         * @return Whether the function is a constant.
         */
        boolean isConstant() {
            return coefficients.isEmpty();
        }

        /**
         * @return The sum of both functions.
         */
        Affine plus(final Affine other) {
            final Map<EStructuralFeature, Double> sum = new LinkedHashMap<>(coefficients);
            other.coefficients.forEach((feature, coefficient) -> sum.merge(feature, coefficient, Double::sum));

            return new Affine(sum, constant + other.constant);
        }

        /**
         * @return The function multiplied by a factor.
         */
        Affine scaled(final double factor) {
            final Map<EStructuralFeature, Double> scaled = new LinkedHashMap<>();
            coefficients.forEach((feature, coefficient) -> scaled.put(feature, coefficient * factor));

            return new Affine(scaled, constant * factor);
        }

        /**
         * @return The linear form without coefficients that are 0.
         */
        LinearForm toLinearForm() {
            final Map<EStructuralFeature, Double> nonZero = new LinkedHashMap<>();
            coefficients.forEach((feature, coefficient) -> {
                if(coefficient != 0.0) {
                    nonZero.put(feature, coefficient);
                }
            });

            return new LinearForm(nonZero, constant);
        }
    }

    /**
     * A compiled arithmetic expression: its function and, if it is affine in the search
     *   features, its affine form.
     *
     * @param function Computes the value from the feature values.
     * @param affine The affine form, {@code null} if the expression is not affine.
     */
    record Term(ToDoubleFunction<FeatureValues> function, Affine affine) {
        /**
         * @return A constant.
         */
        static Term constant(final double value) {
            return new Term(values -> value, constantAffine(value));
        }

        /**
         * @return The affine form of a constant.
         */
        private static Affine constantAffine(final double value) {
            return new Affine(Map.of(), value);
        }

        /**
         * @return The quotient of both terms; affine if the divisor is a constant other than 0.
         */
        Term dividedBy(final Term divisor) {
            final boolean isAffine = affine != null && divisor.isConstant() && divisor.affine.constant != 0.0;
            final Affine quotient = isAffine ? affine.scaled(1.0 / divisor.affine.constant) : null;

            return combine(divisor, (a, b) -> a / b, quotient);
        }

        /**
         * @return Whether the term is a constant.
         */
        boolean isConstant() {
            return affine != null && affine.isConstant();
        }

        /**
         * @return The difference of both terms.
         */
        Term minus(final Term subtrahend) {
            return plus(subtrahend.negated());
        }

        /**
         * @return The remainder of both terms; affine only if both are constants.
         */
        Term modulo(final Term divisor) {
            final boolean bothConstant = isConstant() && divisor.isConstant();
            final Affine remainder = bothConstant ? constantAffine(affine.constant % divisor.affine.constant) : null;

            return combine(divisor, (a, b) -> a % b, remainder);
        }

        /**
         * @return The negated term.
         */
        Term negated() {
            final ToDoubleFunction<FeatureValues> inner = function;
            final Affine negatedAffine = affine == null ? null : affine.scaled(-1.0);

            return new Term(values -> -inner.applyAsDouble(values), negatedAffine);
        }

        /**
         * @return An objective; it is never part of an affine form.
         */
        static Term objective(final EStructuralFeature feature) {
            return new Term(values -> values.valueOf(feature), null);
        }

        /**
         * @return The sum of both terms.
         */
        Term plus(final Term summand) {
            final boolean bothAffine = affine != null && summand.affine != null;
            final Affine sum = bothAffine ? affine.plus(summand.affine) : null;

            return combine(summand, Double::sum, sum);
        }

        /**
         * @return This term to the power of the exponent; affine only if both are constants.
         */
        Term power(final Term exponent) {
            final boolean bothConstant = isConstant() && exponent.isConstant();
            final Affine result = bothConstant ? constantAffine(EvoalMath.pow(affine.constant, exponent.affine.constant))
                                               : null;

            return combine(exponent, EvoalMath::pow, result);
        }

        /**
         * @return A search feature with coefficient 1.
         */
        static Term searchFeature(final EStructuralFeature feature) {
            return new Term(values -> values.valueOf(feature), new Affine(Map.of(feature, 1.0), 0.0));
        }

        /**
         * @return The product of both terms; affine if one of them is a constant.
         */
        Term times(final Term factor) {
            Affine product = null;
            if(affine != null && factor.isConstant()) {
                product = affine.scaled(factor.affine.constant);
            } else if(isConstant() && factor.affine != null) {
                product = factor.affine.scaled(affine.constant);
            }

            return combine(factor, (a, b) -> a * b, product);
        }

        private Term combine(final Term other, final DoubleBinaryOperator operator, final Affine combinedAffine) {
            final ToDoubleFunction<FeatureValues> left = function;
            final ToDoubleFunction<FeatureValues> right = other.function;

            final ToDoubleFunction<FeatureValues> combined = values -> {
                final double leftValue = left.applyAsDouble(values);
                final double rightValue = right.applyAsDouble(values);

                return operator.applyAsDouble(leftValue, rightValue);
            };

            return new Term(combined, combinedAffine);
        }
    }
}

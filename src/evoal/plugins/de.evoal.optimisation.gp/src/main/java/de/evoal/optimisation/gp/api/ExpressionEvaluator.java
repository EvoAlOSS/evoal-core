package de.evoal.optimisation.gp.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;

/**
 * Evaluates expressions, trees of DL objects of the module {@value ExpressionTypes#MODULE}, with
 *   the reflective EMF API. A variable node takes the value of its variable, a constant node the
 *   value of its attribute {@code 'value'}, a function node applies the function of its DL type
 *   to the values of its containments. A tree is compiled once and then evaluated for many rows
 *   of variable values. The evaluator only reads the trees, so threads can share it.
 */
public final class ExpressionEvaluator {
    /**
     * The functions by the qualified names of their DL types.
     */
    private final Map<String, ExpressionFunction> functions;

    /**
     * The variable types with the positions of their values in a row.
     */
    private final Map<EClass, Integer> variables;

    /**
     * @param functions The functions by the qualified names of their DL types, e.g.
     *   {@link ExpressionFunctions#standard()}.
     * @param variables The variable types with the positions of their values in a row.
     */
    public ExpressionEvaluator(final Map<String, ExpressionFunction> functions, final Map<EClass, Integer> variables) {
        this.functions = Map.copyOf(functions);
        this.variables = Map.copyOf(variables);
    }

    private static double applyTo(final ExpressionFunction function, final CompiledExpression[] operands,
                                  final double[] row) {
        final double[] values = new double[operands.length];
        for(int i = 0; i < operands.length; ++i) {
            values[i] = operands[i].evaluate(row);
        }

        return function.apply(values);
    }

    /**
     * Compiles the tree.
     *
     * @param root The root of the tree.
     * @return The expression of the tree.
     * @throws IllegalArgumentException if a node is neither a bound variable, a constant nor a
     *   function with an operand per containment.
     */
    public CompiledExpression compile(final EObject root) {
        final EClass type = root.eClass();

        final Integer position = variables.get(type);
        if(position != null) {
            return row -> row[position];
        }

        if(ExpressionTypes.isConstant(type)) {
            return compileConstant(root);
        }

        return compileFunction(root);
    }

    private CompiledExpression compileConstant(final EObject constant) {
        final EClass type = constant.eClass();
        final EAttribute attribute = ExpressionTypes.valueAttributeOf(type)
                                                    .orElseThrow(() -> new IllegalArgumentException(
                                                            "The constant type " + nameOf(type)
                                                            + " needs exactly one real attribute 'value'."));
        final Object stored = constant.eGet(attribute);
        final double value = NumericConversions.toDouble(stored);

        return row -> value;
    }

    private CompiledExpression compileFunction(final EObject node) {
        final EClass type = node.eClass();
        final String dlType = DynamicEClassProvider.dlTypeOf(type);
        final ExpressionFunction function = functions.get(dlType);
        if(function == null) {
            throw new IllegalArgumentException("The type " + nameOf(type) + " of an expression is neither a bound "
                                               + "variable, a constant nor a function.");
        }

        final List<EReference> containments = type.getEAllContainments();
        if(containments.size() != function.arity()) {
            throw new IllegalArgumentException("The function " + nameOf(type) + " has " + function.arity()
                                               + " operands, but " + containments.size() + " containments.");
        }

        final CompiledExpression[] operands = new CompiledExpression[containments.size()];
        for(int i = 0; i < operands.length; ++i) {
            final EReference containment = containments.get(i);
            final EObject operand = (EObject) node.eGet(containment);
            if(operand == null) {
                throw new IllegalArgumentException("The operand '" + containment.getName() + "' of the function "
                                                   + nameOf(type) + " is missing.");
            }
            operands[i] = compile(operand);
        }

        return row -> applyTo(function, operands, row);
    }

    /**
     * Compiles and evaluates the tree for one row.
     *
     * @param root The root of the tree.
     * @param row The values of the variables.
     * @return The value of the tree.
     */
    public double evaluate(final EObject root, final double[] row) {
        final CompiledExpression expression = compile(root);

        return expression.evaluate(row);
    }

    private static String nameOf(final EClass type) {
        final String dlType = DynamicEClassProvider.dlTypeOf(type);

        return dlType == null ? type.getName() : dlType;
    }

    private Optional<String> problemOf(final EClass type) {
        if(ExpressionTypes.isVariable(type)) {
            return variables.containsKey(type)
                   ? Optional.empty()
                   : Optional.of("the variable type " + nameOf(type) + " has no binding");
        }

        if(ExpressionTypes.isConstant(type)) {
            return ExpressionTypes.valueAttributeOf(type).isPresent()
                   ? Optional.empty()
                   : Optional.of("the constant type " + nameOf(type) + " needs exactly one real attribute 'value'");
        }

        final String dlType = DynamicEClassProvider.dlTypeOf(type);
        final ExpressionFunction function = functions.get(dlType);
        if(function == null) {
            return Optional.of("the type " + nameOf(type) + " is neither a variable, a constant nor a function");
        }

        final List<EReference> containments = type.getEAllContainments();
        final boolean hasOperandPerContainment = containments.size() == function.arity()
                                                 && containments.stream().noneMatch(EReference::isMany);

        return hasOperandPerContainment
               ? Optional.empty()
               : Optional.of("the function " + nameOf(type) + " needs " + function.arity() + " single operands");
    }

    /**
     * Collects why trees of the types could not be evaluated: a variable type without a value,
     *   a constant type without exactly one real {@code 'value'}, a function type without a
     *   function or with another number of containments than operands.
     *
     * @param types The concrete types a tree can contain.
     * @return The problems, empty if every tree of the types can be evaluated.
     */
    public List<String> problemsOf(final Collection<EClass> types) {
        final List<String> problems = new ArrayList<>();
        for(final EClass type : types) {
            problemOf(type).ifPresent(problems::add);
        }

        return problems;
    }

    /**
     * A compiled expression.
     */
    @FunctionalInterface
    public interface CompiledExpression {
        /**
         * @param row The values of the variables, by the positions of the variable types.
         * @return The value of the expression.
         */
        double evaluate(double[] row);
    }
}

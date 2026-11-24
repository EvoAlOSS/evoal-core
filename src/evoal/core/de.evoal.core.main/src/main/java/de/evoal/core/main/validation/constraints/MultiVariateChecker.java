package de.evoal.core.main.validation.constraints;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.evoal.core.api.languages.paths.PathEvaluator;
import de.evoal.core.api.languages.paths.PathException;
import de.evoal.core.api.languages.paths.PathParser;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.AttributeReference;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.PathExpression;
import de.evoal.languages.model.base.expressions.SelfReference;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;
import de.evoal.languages.model.base.expressions.ValueReference;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.languages.model.interpreter.numeric.BooleanNumberOperations;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Checks {@code @MultiVariateConstraint} on a type: its {@code 'expression'} has to be true
 *   for every instance of the type, e.g. {@code self.'c1' + self.'c2' >= 4.0}. An attribute
 *   that the instance does not set has its DL default.
 */
@Dependent
@Named("de.evoal.core.constraints.MultiVariateConstraint")
public class MultiVariateChecker implements ConstraintCheckerComponent {
    /**
     * The condition of the constraint.
     */
    private Expression expression;

    public MultiVariateChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    public MultiVariateChecker(final Expression expression) {
        this.expression = expression;
    }

    @Override
    public ConstraintCheckerComponent init(final EObject config) throws InitializationException {
        final EStructuralFeature feature = config.eClass().getEStructuralFeature("expression");
        if(feature == null || !(config.eGet(feature) instanceof Expression condition)) {
            throw new InitializationException("A @MultiVariateConstraint needs an 'expression'.");
        }

        requireValidPaths(condition);
        expression = condition;
        return this;
    }

    @Override
    public ConstraintCheck check(final Object value) {
        if(!(value instanceof Instance instance)) {
            return ConstraintCheck.notCheckable("it is only known during the run");
        }

        final Object result;
        try {
            result = new InstanceEvaluator(instance).doSwitch(expression);
        } catch(final PathException e) {
            return ConstraintCheck.violated("has an invalid constraint '" + text(expression) + "': " + e.getMessage());
        } catch(final RuntimeException e) {
            return ConstraintCheck.notCheckable("'" + text(expression) + "' cannot be computed before the run (" + e.getMessage() + ")");
        }

        if(Boolean.TRUE.equals(result)) {
            return ConstraintCheck.satisfied();
        }

        return ConstraintCheck.violated("violates '" + text(expression) + "'");
    }

    /**
     * Parses every path expression of the condition, so a syntax error is reported once for the
     *   annotation, not for every instance.
     *
     * @throws InitializationException for the first invalid path.
     */
    private static void requireValidPaths(final Expression condition) throws InitializationException {
        final TreeIterator<EObject> contents = condition.eAllContents();
        while(contents.hasNext()) {
            if(!(contents.next() instanceof PathExpression path)) {
                continue;
            }

            try {
                PathParser.parse(path.getPath());
            } catch(final PathException e) {
                throw new InitializationException(e.getMessage(), e);
            }
        }
    }

    /**
     * @return The source text of the expression, or a placeholder if it was not parsed.
     */
    static String text(final EObject expression) {
        final INode node = NodeModelUtils.findActualNodeFor(expression);
        return node == null ? "<expression>" : NodeModelUtils.getTokenText(node);
    }

    /**
     * Evaluates the condition on the parsed instance: {@code self} is the instance, and an
     *   attribute reference yields the value of the attribute, or its DL default if the
     *   instance does not set it.
     */
    private static final class InstanceEvaluator extends ConstantEvaluator {
        /**
         * The functions on the selections of path expressions, declared in
         *   {@code de.evoal.core.constraints}.
         */
        private static final Set<String> SELECTION_FUNCTIONS = Set.of("count", "exists", "max", "min");

        /**
         * The module that declares the {@link #SELECTION_FUNCTIONS}.
         */
        private static final String SELECTION_FUNCTIONS_MODULE = "de.evoal.core.constraints";

        private final Instance self;

        private InstanceEvaluator(final Instance self) {
            this.self = self;
        }

        @Override
        public Object caseCall(final Call call) {
            final FunctionDefinition function = call.getFunction();
            if(!isSelectionFunction(function)) {
                return super.caseCall(call);
            }

            if(call.getParameters().size() != 1) {
                throw new IllegalStateException("'" + function.getName() + "' takes one path expression");
            }

            final Object argument = doSwitch(call.getParameters().getFirst());
            if(!(argument instanceof List<?> selection)) {
                throw new IllegalStateException("'" + function.getName() + "' takes a path expression, but got " + argument);
            }

            return switch(function.getName()) {
                case "count" -> selection.size();
                case "exists" -> !selection.isEmpty();
                case "max" -> extremeOf(function, selection, true);
                default -> extremeOf(function, selection, false);
            };
        }

        @Override
        public Object casePathExpression(final PathExpression path) {
            return PathEvaluator.evaluate(path.getPath(), self);
        }

        /**
         * @return The largest (or smallest) number of the selection.
         * @throws IllegalStateException if the selection is empty or contains something other than numbers.
         */
        private static Object extremeOf(final FunctionDefinition function, final List<?> selection, final boolean largest) {
            if(selection.isEmpty()) {
                throw new IllegalStateException("'" + function.getName() + "' of an empty selection");
            }

            Object extreme = null;
            for(final Object value : selection) {
                if(!(value instanceof Number)) {
                    throw new IllegalStateException("'" + function.getName() + "' of " + value + ", which is no number");
                }

                final boolean isMoreExtreme = extreme == null
                                              || (largest ? BooleanNumberOperations.isGreaterThan(value, extreme)
                                                          : BooleanNumberOperations.isLesserThan(value, extreme));
                if(isMoreExtreme) {
                    extreme = value;
                }
            }

            return extreme;
        }

        private static boolean isSelectionFunction(final FunctionDefinition function) {
            final boolean isDeclaredInConstraints = function != null
                                                    && function.eContainer() instanceof Module module
                                                    && SELECTION_FUNCTIONS_MODULE.equals(module.getName());

            return isDeclaredInConstraints && SELECTION_FUNCTIONS.contains(function.getName());
        }

        @Override
        public Object caseSelfReference(final SelfReference reference) {
            return self;
        }

        @Override
        public Object caseAttributeReference(final AttributeReference reference) {
            Object current = doSwitch(reference.getSelf());

            for(final ValueDefinitionReference child : reference.getChain()) {
                if(!(current instanceof Instance instance) || !(child.getDefinition() instanceof AttributeDefinition attribute)) {
                    throw new IllegalStateException("cannot follow '" + text(reference) + "'");
                }
                current = valueOf(instance, attribute);
            }

            return current;
        }

        @Override
        public Object caseValueReference(final ValueReference reference) {
            if(reference instanceof ValueDefinitionReference definition && definition.getDefinition() instanceof AttributeDefinition attribute) {
                return valueOf(self, attribute);
            }

            return super.caseValueReference(reference);
        }

        private Object valueOf(final Instance instance, final AttributeDefinition definition) {
            final Attribute attribute = instance.findAttribute(definition);
            final Expression value = attribute != null ? attribute.getValue() : definition.getInitialisation();
            if(value == null) {
                throw new IllegalStateException("'" + definition.getName() + "' is not set");
            }

            return doSwitch(value);
        }
    }
}

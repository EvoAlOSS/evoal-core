package de.evoal.core.main.validation.constraints;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.AttributeReference;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.SelfReference;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;
import de.evoal.languages.model.base.expressions.ValueReference;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
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
    MultiVariateChecker(final Expression expression) {
        this.expression = expression;
    }

    @Override
    public ConstraintCheckerComponent init(final EObject config) throws InitializationException {
        final EStructuralFeature feature = config.eClass().getEStructuralFeature("expression");
        if(feature == null || !(config.eGet(feature) instanceof Expression condition)) {
            throw new InitializationException("A @MultiVariateConstraint needs an 'expression'.");
        }

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
        } catch(final RuntimeException e) {
            return ConstraintCheck.notCheckable("'" + text(expression) + "' cannot be computed before the run (" + e.getMessage() + ")");
        }

        if(Boolean.TRUE.equals(result)) {
            return ConstraintCheck.satisfied();
        }

        return ConstraintCheck.violated("violates '" + text(expression) + "'");
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
        private final Instance self;

        private InstanceEvaluator(final Instance self) {
            this.self = self;
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

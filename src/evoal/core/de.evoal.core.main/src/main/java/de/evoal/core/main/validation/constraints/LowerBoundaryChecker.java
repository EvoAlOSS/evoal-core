package de.evoal.core.main.validation.constraints;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.interpreter.BooleanNumberOperations;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.function.BiFunction;

@Dependent @Named("de.evoal.core.constraints.LowerBoundary")
@Slf4j
public class LowerBoundaryChecker implements ConstraintCheckerComponent {
    private Number bound;

    @Inject
    private Event<Diagnostics> events;

    @Inject
    private AttributeHelper helper;

    private BiFunction<Object, Object, Boolean> comparator;

    @Override
    public ConstraintCheckerComponent init(final Instance config) throws InitializationException {
        this.bound = helper.lookup(config, "boundary");
        final boolean isBoundaryIncluded = helper.lookup(config, "inclusive");

        if (isBoundaryIncluded) {
            comparator = BooleanNumberOperations::isLesserThanOrEqualTo;
        } else {
            comparator = BooleanNumberOperations::isLesserThan;
        }

        return this;
    }

    @Override
    public void check(final DiagnosticsContext context, final EObject container) {
        if(!(container instanceof Attribute)) {
            events.fire(new Diagnostics(Diagnostics.Level.Warning, context, "LowerBoundaryChecker can only be used for attributes."));
            return;
        }

        final Attribute attribute = (Attribute) container;
        final ReadExpression expression = findArray(attribute.getValue());

        if(!(expression instanceof Literal)) {
            events.fire(new Diagnostics(Diagnostics.Level.Warning, context, "LowerBoundaryChecker can only be used for literal attributes."));
            return;
        }

        final Literal data = (Literal) expression;

        if(comparator.apply(data.getValue(), bound)) {
            events.fire(Diagnostics.of(Diagnostics.Level.Error, context, "Value is smaller than specified lower bound: " + bound));
        }
    }

    private ReadExpression findArray(final Expression value) {
        return  ((OrExpression)value)
                .getSubExpressions()
                .get(0)
                .getSubExpressions()
                .get(0)
                .getSubExpressions()
                .get(0)
                .getOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getSubExpression();
    }
}

package de.evoal.core.main.validation.constraints;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.languages.model.base.expressions.*;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Dependent @Named("de.evoal.core.constraints.MinimumNumberOfElements")
@Slf4j
public class MinimumNumberOfElementsChecker implements ConstraintCheckerComponent {
    private int bound;

    @Inject
    private Event<Diagnostics> events;

    @Inject
    private AttributeHelper helper;

    @Override
    public ConstraintCheckerComponent init(final Instance config) throws InitializationException {
        bound = helper.lookup(config, "bound");

        // TODO We should issue an error in case of a negative
        if(bound < 0) {
            bound = 0;
        }

        return this;
    }

    @Override
    public void checkOnInstance(final DiagnosticsContext context, final EObject container) {
        if(!(container instanceof Attribute)) {
            events.fire(new Diagnostics(Diagnostics.Level.Warning, context, "MinimumNumberOfElements can only be used for attributes."));
            return;
        }

        final Attribute attribute = (Attribute) container;
        final ReadExpression expression = findArray(attribute.getValue());

        if(!(expression instanceof Array)) {
            events.fire(new Diagnostics(Diagnostics.Level.Warning, context, "MinimumNumberOfElements can only be used for array attributes."));
            return;
        }

        final Array data = (Array) expression;

        if(data.getValues().size() < bound) {
            events.fire(Diagnostics.of(Diagnostics.Level.Error, context, "MinimumNumberOfElements must have at least " + bound + " elements."));
        }
    }


    @Override
    public void checkOnEcore(final DiagnosticsContext context, final Object object) {
        if(object instanceof EList<?> list) {
            if(list.size() < bound) {
                events.fire(Diagnostics.of(Diagnostics.Level.Error, context, "List size is smaller than specified lower bound: " + bound));
            }
        } else {
            throw new IllegalArgumentException("Cannot check " + object.getClass());
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

package de.evoal.core.main.validation.constraints;

import de.evoal.core.api.interpreter.ExpressionInterpreter;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.languages.model.base.expressions.*;

import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.ExecutionPackage;
import de.evoal.languages.model.execution.NamedVariable;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent @Named("de.evoal.core.constraints.MultiVariateConstraint")
@Slf4j
public class MultiVariateChecker implements ConstraintCheckerComponent {
    private Expression expression;

    @Inject
    private Event<Diagnostics> events;

    @Inject
    private AttributeHelper helper;

    @Override
    public MultiVariateChecker init(final Instance config) throws InitializationException {
        this.expression = config.findAttribute("expression").getValue();

        return this;
    }

    @Override
    public void check(final DiagnosticsContext context, final EObject container) {
        if(!(container instanceof Instance)) {
            events.fire(new Diagnostics(Diagnostics.Level.Warning, context, "MultiVariateConstraint can only be used for instances."));
            return;
        }

        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName("self");

        final InterpreterState state = new InterpreterState();
        state.put(variable, container);

        final ExpressionInterpreter interpreter = new ExpressionInterpreter(state);

        final Object result = interpreter.execute(expression);

        if(!(result instanceof Boolean) || !(Boolean) result) {
            final String constraint = serialize(expression);

            events.fire(Diagnostics.of(Diagnostics.Level.Error, context, "Constraint \"" + constraint + "\" is violated" ));
        }
    }

    private String serialize(final Expression expression) {
        final Resource resource = expression.eResource();

        if(!(resource instanceof XtextResource xtextResource) ) {
           return "<not serializable>";
        }

        return xtextResource.getSerializer()
                            .serialize(expression);
    }
}

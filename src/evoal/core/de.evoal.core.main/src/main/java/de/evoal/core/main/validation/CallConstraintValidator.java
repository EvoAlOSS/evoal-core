package de.evoal.core.main.validation;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.model.MetaValidator;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.definitions.Parameter;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.languages.model.base.expressions.Expression;

/**
 * Checks every call of a DL function ({@code def}) against the annotations of its parameters,
 *   e.g. {@code correlation(data 'x', data 'y', 1.5)} against the bounds of
 *   {@code coefficient}, when a file is loaded; see {@link ConstraintValidator#checkArgument}.
 */
@Slf4j
@ApplicationScoped
public class CallConstraintValidator implements MetaValidator {
    @Inject
    private ConstraintValidator constraints;

    public CallConstraintValidator() {
    }

    /**
     * Creates a validator with the given constraint checks, e.g., for tests.
     */
    CallConstraintValidator(final ConstraintValidator constraints) {
        this.constraints = constraints;
    }

    @Override
    public int priority() {
        return 320;
    }

    @Override
    public void validate(final @NonNull Resource resource) {
        final ResourceContext context = new ResourceContext(resource);
        final TreeIterator<EObject> contents = resource.getAllContents();

        while(contents.hasNext()) {
            if(contents.next() instanceof Call call && call.getFunction() != null) {
                checkCall(context, call);
            }
        }
    }

    private void checkCall(final ResourceContext context, final Call call) {
        final FunctionDefinition function = call.getFunction();
        final List<Parameter> parameters = function.getParameters();
        final List<Expression> arguments = call.getParameters();

        // a call with a wrong number of arguments is reported by the language validators
        final int checked = parameters.size() < arguments.size() ? parameters.size() : arguments.size();
        for(int i = 0; i < checked; ++i) {
            final Parameter parameter = parameters.get(i);
            constraints.checkArgument(new EObjectContext(context, function.getName() + "." + parameter.getName(), arguments.get(i)),
                                      function,
                                      parameter,
                                      arguments.get(i));
        }
    }
}

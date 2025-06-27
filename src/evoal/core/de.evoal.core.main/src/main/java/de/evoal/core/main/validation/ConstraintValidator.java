package de.evoal.core.main.validation;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.api.validation.context.EObjectContext;
import de.evoal.core.api.validation.model.InstanceValidator;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.EList;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@Slf4j
@ApplicationScoped
public class ConstraintValidator implements InstanceValidator {

    @Override
    public int priority() {
        return 300;
    }

    @Override
    public void validate(final @NonNull EObjectContext context, final @NonNull Instance instance) {
        final ClassDefinition definition = instance.getDefinition();
        final EList<AttributeDefinition> attributes = definition.getAllAttributes();

        for(final AttributeDefinition attribute : attributes) {
            final List<Expression> constraints = attribute.getConstraints();
            final Attribute attr = instance.findAttribute(attribute);

            constraints.stream()
                       .forEach(c-> check(new EObjectContext(context, attr.getDefinition().getName()), c, attr));
        }
    }

    private void check(final @NonNull DiagnosticsContext context, final @NonNull Expression constraint, final @NonNull Attribute attr) {
        if(!(constraint instanceof Instance)) {
            log.warn("Constraint validator does currently not support non-instance constraints: {}.", constraint);
            return;
        }

        final Instance instance = (Instance) constraint;
        final ConstraintCheckerComponent checker = BeanFactory.createComponent(ConstraintCheckerComponent.class, instance);

        checker.check(context, attr);
    }
}

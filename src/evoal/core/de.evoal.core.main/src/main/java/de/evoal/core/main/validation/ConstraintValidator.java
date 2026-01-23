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

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.emf.ecore.EObject;

import java.util.stream.Stream;

/**
 * Instance validator that checks user-defined constraints (using @-syntax in the .dl files).
 */
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

        log.info("Validating instance {}", definition.getName());
        collect(instance.getDefinition())
                .forEach(c -> checkOnInstance(context, c, instance));

        log.info("Validating attributes of {}", definition.getName());
        final EList<AttributeDefinition> attributes = definition.getAllAttributes();
        for(final AttributeDefinition attribute : attributes) {
            final Attribute attr = instance.findAttribute(attribute);

            if(attr == null) {
                continue;
            }

            attribute.getConstraints()
                     .forEach(c -> checkOnInstance(new EObjectContext(context, attr.getDefinition().getName()), c, attr));
        }
    }

    private Stream<Expression> collect(final ClassDefinition definition) {
        Stream<Expression> constraints = definition.getConstraints().stream();

        if(definition.getSuperType() != null) {
            final ClassDefinition superType = definition.getSuperType();
            constraints = Stream.concat(constraints, collect(superType));
        }

        return constraints;

    }

    public void checkOnInstance(final @NonNull DiagnosticsContext context, final @NonNull Expression constraint, final @NonNull EObject object) {
        if(constraint instanceof Instance configuration) {
            BeanFactory.createComponent(ConstraintCheckerComponent.class, configuration)
                       .checkOnInstance(context, object);
        } else {
            log.atWarn()
                .setMessage("Constraint validator does currently not support constraints of type: {}.")
                .addArgument(() -> constraint.eClass().getName())
                .log();
        }
    }


    public void checkOnEcore(final @NonNull DiagnosticsContext context, final @NonNull Expression constraint, final @NonNull Object object) {
        if(constraint instanceof Instance configuration) {
            BeanFactory.createComponent(ConstraintCheckerComponent.class, configuration)
                    .checkOnEcore(context, object);
        } else {
            log.atWarn()
                    .setMessage("Constraint validator does currently not support constraints of type: {}.")
                    .addArgument(() -> constraint.eClass().getName())
                    .log();
        }
    }
}

package de.evoal.core.api.validation.constraints;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.dynamic.ValueConverter;
import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Creates the configured {@link ConstraintCheckerComponent} of a constraint annotation, e.g.
 *   {@code @LowerBoundary { boundary := 0.0; }}. The checker is the component named by the
 *   fully-qualified name of the annotation's type; it is configured with the annotation,
 *   converted like any other DL instance. The configuration checks use it, and so does data
 *   generation, which checks the annotations of data descriptions on every row.
 */
@ApplicationScoped
@Slf4j
public class ConstraintCheckers {
    /**
     * Converts the annotations into the configurations of their checkers.
     */
    @Inject
    private Provider<ValueConverter> converters;

    /**
     * @param annotation The annotation, e.g. {@code @UpperBoundary { boundary := 1.0; }}.
     * @return The configured checker of the annotation, or empty if its type has none (e.g.
     *   {@code @Literature}).
     * @throws InitializationException if the annotation cannot configure its checker.
     */
    public Optional<ConstraintCheckerComponent> create(final @NonNull Instance annotation) throws InitializationException {
        final String name = nameOf(annotation.getDefinition());
        final ConstraintCheckerComponent checker = BeanProvider.getContextualReference(name, true, ConstraintCheckerComponent.class);
        if(checker == null) {
            log.debug("The annotation {} has no checker.", name);
            return Optional.empty();
        }

        final EObject configuration;
        try {
            configuration = (EObject) converters.get()
                                                .setTargetType(null)
                                                .convert(annotation);
        } catch(final RuntimeException e) {
            throw new InitializationException(e.getMessage(), e);
        }

        return Optional.of(checker.init(configuration));
    }

    /**
     * @param definition A DL type.
     * @return The fully-qualified name of the DL type, which names its checker.
     */
    public static String nameOf(final @NonNull ClassDefinition definition) {
        return definition.eContainer() instanceof Module module ? module.getName() + "." + definition.getName() : definition.getName();
    }
}

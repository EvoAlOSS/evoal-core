package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.mll.MachineLearningModule;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

import java.util.List;
import java.util.Optional;

/**
 * Checks {@code @InvertibleOnOutputs} (on {@code 'preparation-step'}): a preparation step that
 *   is not an {@code 'invertible-preparation-step'} must not name an output feature of the
 *   learning task of its MLL module, because its effect on the output cannot be undone after
 *   the prediction.
 */
@Dependent
@Named("de.evoal.surrogate.pipeline.InvertibleOnOutputs")
public class InvertibleOnOutputsChecker implements ConstraintCheckerComponent {
    private static final String MODULE = "de.evoal.surrogate.pipeline";
    private static final String INVERTIBLE = "invertible-preparation-step";

    @Override
    public ConstraintCheckerComponent init(final EObject configuration) {
        return this;
    }

    @Override
    public ConstraintCheck check(final Object value) {
        if(!(value instanceof Instance instance)) {
            return ConstraintCheck.notCheckable("it is not a parsed step");
        }

        final Optional<MachineLearningModule> module = moduleOf(instance);
        if(module.isEmpty()) {
            return ConstraintCheck.notCheckable("it is not part of an MLL module");
        }

        if(isInvertible(instance.getDefinition())) {
            return ConstraintCheck.satisfied();
        }

        final List<?> outputs = module.get().getTask().getOutputs();
        final Optional<String> output = featuresOf(instance).stream()
                                                            .map(TypeDefinitionReference::getDefinition)
                                                            .filter(outputs::contains)
                                                            .findFirst()
                                                            .map(f -> f.getName());
        return output.map(name -> ConstraintCheck.violated("transforms the output feature '" + name
                                                          + "' but cannot be undone after the prediction; use an invertible preparation step"))
                     .orElseGet(ConstraintCheck::satisfied);
    }

    private static Optional<MachineLearningModule> moduleOf(final EObject element) {
        for(EObject current = element; current != null; current = current.eContainer()) {
            if(current instanceof MachineLearningModule module) {
                return Optional.of(module);
            }
        }

        return Optional.empty();
    }

    private static boolean isInvertible(final ClassDefinition type) {
        for(ClassDefinition current = type; current != null; current = current.getSuperType()) {
            if(INVERTIBLE.equals(current.getName())
                    && current.eContainer() instanceof DefinitionModule module
                    && MODULE.equals(module.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return The data references of {@code features}.
     */
    private static List<TypeDefinitionReference> featuresOf(final Instance instance) {
        final Attribute attribute = instance.findAttribute("features");
        if(attribute == null
                || !(ElementSwitch.elementOf(attribute.getValue()).orElse(null) instanceof Array array)) {
            return List.of();
        }

        return array.getValues()
                    .stream()
                    .map(ElementSwitch::elementOf)
                    .flatMap(Optional::stream)
                    .filter(TypeDefinitionReference.class::isInstance)
                    .map(TypeDefinitionReference.class::cast)
                    .toList();
    }
}

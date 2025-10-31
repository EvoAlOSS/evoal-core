package de.evoal.optimisation.main.constraints.constraint.ast;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;
import de.evoal.languages.model.dl.DefinitionModule;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import java.util.Optional;

@Slf4j
public class AnnotationBoundaryIdentifier extends ExpressionsSwitch<Optional<Boundary>> {
    private final AttributeHelper helper;

    private final DataDescription context;

    public AnnotationBoundaryIdentifier(final AttributeHelper helper, final DataDescription context) {
        this.helper = helper;
        this.context = context;
    }

    @Override
    public Optional<Boundary> caseInstance(final Instance object) {
        final ClassDefinition definition = object.getDefinition();
        final DefinitionModule module = (DefinitionModule) definition.eContainer();

        if(!"de.evoal.core.constraints".equals(module.getName())) {
            return Optional.empty();
        }


        final boolean isInclusive = helper.lookup(object, "inclusive");
        final Number boundary = helper.lookup(object, "boundary");

        return switch (definition.getName()) {
            case "LowerBoundary" -> Optional.of(new Boundary(true, context, boundary, isInclusive));
            case "UpperBoundary" -> Optional.of(new Boundary(false, context, boundary, isInclusive));
            default -> super.caseInstance(object);
        };
    }

    @Override
    public Optional<Boundary> defaultCase(EObject object) {
        return Optional.empty();
    }
}

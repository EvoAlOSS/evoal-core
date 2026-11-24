package de.evoal.core.main.validation.constraints;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Checks {@code @RequiresRepresentation}: every selected data has one of the
 *   {@code representations} (real, integer, boolean or string data).
 */
@Dependent
@Named("de.evoal.core.constraints.RequiresRepresentation")
public class RequiresRepresentationChecker extends FeatureRequirementChecker {
    /**
     * The representations the data may have.
     */
    private List<RepresentationType> representations;

    public RequiresRepresentationChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    RequiresRepresentationChecker(final String features, final List<RepresentationType> representations) {
        super(features);
        this.representations = List.copyOf(representations);
    }

    @Override
    protected void configure(final EObject config) throws InitializationException {
        final EStructuralFeature feature = config.eClass().getEStructuralFeature("representations");
        final Object value = feature == null ? null : config.eGet(feature);
        if(!(value instanceof List<?> literals) || literals.isEmpty()) {
            throw new InitializationException("A @RequiresRepresentation needs 'representations'.");
        }

        representations = literals.stream()
                                  .map(literal -> RepresentationType.get(((Enumerator) literal).getName()))
                                  .toList();
    }

    @Override
    protected Optional<String> problemOf(final DataDescription data) {
        final RepresentationType representation = data instanceof BaseDataDescription base ? base.getRepresentation() : null;
        if(representations.contains(representation)) {
            return Optional.empty();
        }

        final String allowed = String.join(" or ", representations.stream()
                                                                  .map(RepresentationType::getLiteral)
                                                                  .toList());
        final String actual = representation == null ? "structured data" : representation.getLiteral() + " data";

        return Optional.of("needs " + allowed + " data, but '" + data.getName() + "' is " + actual);
    }
}

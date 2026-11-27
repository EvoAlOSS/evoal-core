package de.evoal.core.main.validation.constraints;

import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Checks {@code @RequiresScale}: every selected data has at least the {@code minimum} scale
 *   (nominal < ordinal < cardinal < quotient). Data without a scale is nominal, the default of
 *   the DDL; typed data has the scale of its type. Structured data (a model) meets every
 *   requirement: its attributes have their own scales, which the components that change them
 *   check.
 */
@Dependent
@Named("de.evoal.core.constraints.RequiresScale")
public class RequiresScaleChecker extends FeatureRequirementChecker {
    /**
     * The weakest scale the data may have.
     */
    private ScaleType minimum;

    public RequiresScaleChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    RequiresScaleChecker(final String features, final ScaleType minimum) {
        super(features);
        this.minimum = minimum;
    }

    @Override
    protected void configure(final EObject config) throws InitializationException {
        final EStructuralFeature feature = config.eClass().getEStructuralFeature("minimum");
        final Object value = feature == null ? null : config.eGet(feature);
        final ScaleType scale = value instanceof Enumerator literal ? ScaleType.get(literal.getName()) : null;
        if(scale == null || scale == ScaleType.UNKNOWN) {
            throw new InitializationException("A @RequiresScale needs a 'minimum' scale.");
        }

        minimum = scale;
    }

    @Override
    protected Optional<String> problemOf(final DataDescription data) {
        if(data instanceof StructuredDataDescription) {
            return Optional.empty();
        }

        final ScaleType scale = scaleOf(data);
        if(scale.getValue() >= minimum.getValue()) {
            return Optional.empty();
        }

        return Optional.of("needs data of at least " + minimum.getLiteral() + " scale, but '" + data.getName() + "' is "
                           + scale.getLiteral());
    }

    /**
     * @return The scale of the data; nominal for data without a scale.
     */
    private static ScaleType scaleOf(final DataDescription data) {
        final ScaleType scale = data instanceof BaseDataDescription base ? base.getScale() : null;
        final boolean hasNoScale = scale == null || scale == ScaleType.UNKNOWN;

        return hasNoScale ? ScaleType.NOMINAL : scale;
    }
}

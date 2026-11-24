package de.evoal.core.main.validation.constraints;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.paths.PathEvaluator;
import de.evoal.core.api.languages.paths.PathException;
import de.evoal.core.api.languages.paths.PathParser;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.PathExpression;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Base class of the checkers of the {@code FeatureRequirement}s ({@code @RequiresScale},
 *   {@code @RequiresRepresentation}, {@code @RequiresBoundaries}): the path of {@code features}
 *   is evaluated from the annotated instance, and every selected data is checked.
 */
abstract class FeatureRequirementChecker implements ConstraintCheckerComponent {
    /**
     * The attribute of the requirements that selects the data.
     */
    static final String FEATURES = "features";

    /**
     * The text of the path that selects the data.
     */
    private String features;

    FeatureRequirementChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    FeatureRequirementChecker(final String features) {
        this.features = features;
    }

    @Override
    public ConstraintCheck check(final Object value) {
        if(!(value instanceof Instance instance)) {
            return ConstraintCheck.notCheckable("it is only known during the run");
        }

        final List<Object> selection;
        try {
            selection = PathEvaluator.evaluate(features, instance);
        } catch(final PathException e) {
            return ConstraintCheck.violated("has an invalid 'features' path: " + e.getMessage());
        }

        for(final Object selected : selection) {
            if(!(selected instanceof DataDescription data)) {
                return ConstraintCheck.violated("selects " + selected + " with 'features' path \"" + features + "\", which is no data");
            }

            final Optional<String> problem = problemOf(data);
            if(problem.isPresent()) {
                return ConstraintCheck.violated(problem.get());
            }
        }

        return ConstraintCheck.satisfied();
    }

    /**
     * Reads the attributes of the concrete requirement.
     */
    protected abstract void configure(final EObject config) throws InitializationException;

    @Override
    public ConstraintCheckerComponent init(final EObject config) throws InitializationException {
        final EStructuralFeature feature = config.eClass().getEStructuralFeature(FEATURES);
        if(feature == null || !(config.eGet(feature) instanceof PathExpression path)) {
            throw new InitializationException("A feature requirement needs a 'features' path.");
        }

        try {
            PathParser.parse(path.getPath());
        } catch(final PathException e) {
            throw new InitializationException(e.getMessage(), e);
        }

        features = path.getPath();
        configure(config);

        return this;
    }

    /**
     * @param data A selected data description.
     * @return Why the data does not meet the requirement, e.g. "needs cardinal features, but
     *   'colour' is nominal"; empty if it meets it.
     */
    protected abstract Optional<String> problemOf(final DataDescription data);
}

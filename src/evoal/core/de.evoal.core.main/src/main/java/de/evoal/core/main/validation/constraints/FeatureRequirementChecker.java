package de.evoal.core.main.validation.constraints;

import java.util.ArrayList;
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
 *   is evaluated from the annotated instance, and every selected data is checked. On a
 *   parameter of a {@code def}, the path starts at the data of the argument, e.g.
 *   {@code features := path "."} for the data itself.
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
        final List<EObject> starts = startsOf(value);
        if(starts.isEmpty()) {
            return ConstraintCheck.notCheckable("it is only known during the run");
        }

        final List<Object> selection = new ArrayList<>();
        try {
            for(final EObject start : starts) {
                selection.addAll(PathEvaluator.evaluate(features, start));
            }
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
     * @return Where the path starts: the annotated instance, or for an annotation on a
     *   parameter of a {@code def} the data of the argument (each element for an array of data);
     *   empty if the value is only known during the run.
     */
    private static List<EObject> startsOf(final Object value) {
        return switch(value) {
            case Instance instance -> List.of(instance);
            case DataDescription data -> List.of(data);
            case List<?> elements when !elements.isEmpty() && elements.stream().allMatch(DataDescription.class::isInstance) ->
                    elements.stream().map(EObject.class::cast).toList();
            case null, default -> List.of();
        };
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

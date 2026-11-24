package de.evoal.core.main.validation.constraints;

import java.util.List;
import java.util.stream.Collectors;

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
 * Base class of the checkers of {@code @Requires} and {@code @Excludes}: the path of
 *   {@code selection} is evaluated from the annotated instance, and its selection is checked.
 */
abstract class SelectionChecker implements ConstraintCheckerComponent {
    /**
     * The text of the path.
     */
    private String selection;

    SelectionChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    SelectionChecker(final String selection) {
        this.selection = selection;
    }

    @Override
    public ConstraintCheck check(final Object value) {
        if(!(value instanceof Instance instance)) {
            return ConstraintCheck.notCheckable("it is only known during the run");
        }

        final List<Object> selected;
        try {
            selected = PathEvaluator.evaluate(selection, instance);
        } catch(final PathException e) {
            return ConstraintCheck.violated("has an invalid 'selection' path: " + e.getMessage());
        }

        return check(selection, selected);
    }

    /**
     * @param path The text of the path.
     * @param selected What the path selects.
     * @return The result of the check.
     */
    protected abstract ConstraintCheck check(final String path, final List<Object> selected);

    /**
     * @return The selected objects for a message, e.g. "'basic-mover'".
     */
    static String describe(final List<Object> selected) {
        return selected.stream()
                       .map(SelectionChecker::describe)
                       .collect(Collectors.joining(", "));
    }

    private static String describe(final Object selected) {
        return switch(selected) {
            case Instance instance -> "'" + instance.getDefinition().getName() + "'";
            case DataDescription data -> "data '" + data.getName() + "'";
            default -> String.valueOf(selected);
        };
    }

    @Override
    public ConstraintCheckerComponent init(final EObject config) throws InitializationException {
        final EStructuralFeature feature = config.eClass().getEStructuralFeature("selection");
        if(feature == null || !(config.eGet(feature) instanceof PathExpression path)) {
            throw new InitializationException("A @Requires or @Excludes needs a 'selection' path.");
        }

        try {
            PathParser.parse(path.getPath());
        } catch(final PathException e) {
            throw new InitializationException(e.getMessage(), e);
        }

        selection = path.getPath();

        return this;
    }
}

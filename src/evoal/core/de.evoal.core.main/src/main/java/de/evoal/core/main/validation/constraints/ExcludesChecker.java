package de.evoal.core.main.validation.constraints;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.core.api.validation.constraints.ConstraintCheck;

/**
 * Checks {@code @Excludes}: the path of {@code selection} selects nothing.
 */
@Dependent
@Named("de.evoal.core.constraints.Excludes")
public class ExcludesChecker extends SelectionChecker {
    public ExcludesChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    ExcludesChecker(final String selection) {
        super(selection);
    }

    @Override
    protected ConstraintCheck check(final String path, final List<Object> selected) {
        if(!selected.isEmpty()) {
            return ConstraintCheck.violated("excludes path \"" + path + "\", but it selects " + describe(selected));
        }

        return ConstraintCheck.satisfied();
    }
}

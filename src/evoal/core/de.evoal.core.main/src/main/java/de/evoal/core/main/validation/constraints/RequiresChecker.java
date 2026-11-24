package de.evoal.core.main.validation.constraints;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.core.api.validation.constraints.ConstraintCheck;

/**
 * Checks {@code @Requires}: the path of {@code selection} selects at least one object.
 */
@Dependent
@Named("de.evoal.core.constraints.Requires")
public class RequiresChecker extends SelectionChecker {
    public RequiresChecker() {
    }

    /**
     * Creates a configured checker, e.g., for tests.
     */
    RequiresChecker(final String selection) {
        super(selection);
    }

    @Override
    protected ConstraintCheck check(final String path, final List<Object> selected) {
        if(selected.isEmpty()) {
            return ConstraintCheck.violated("requires path \"" + path + "\" to select something, but it selects nothing");
        }

        return ConstraintCheck.satisfied();
    }
}

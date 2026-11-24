package de.evoal.core.main.validation.constraints;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.ol.OptimisationModule;

/**
 * The checkers of {@code @Requires} and {@code @Excludes} on the swarm of {@code configuration.ol}
 *   in {@code de/evoal/core/test/paths}, whose sibling 'mover' is a 'special-mover' (a
 *   'basic-mover').
 */
public class SelectionCheckersTest {
    private final OptimisationModule module = LanguageHelper.loadFromClasspath("de/evoal/core/test/paths/configuration.ol");

    private final Instance swarm = (Instance) ElementSwitch.elementOf(module.getAlgorithm().findAttribute("swarm").getValue())
                                                           .orElseThrow();

    private static void assertViolated(final ConstraintCheck check, final String message) {
        final ConstraintCheck.Violated violated = Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check);

        Assertions.assertEquals(message, violated.message());
    }

    @Test
    public void alternativesAreAUnion() {
        final RequiresChecker oneOf = new RequiresChecker("../mover[exactly basic-mover] | ../mover[exactly special-mover]");

        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, oneOf.check(swarm));
    }

    @Test
    public void excludesRejectsASelection() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, new ExcludesChecker("../mover[exactly basic-mover]").check(swarm));
        assertViolated(new ExcludesChecker("../mover[basic-mover]").check(swarm),
                       "excludes path \"../mover[basic-mover]\", but it selects 'special-mover'");
    }

    @Test
    public void requiresNeedsASelection() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, new RequiresChecker("../mover[basic-mover]").check(swarm));
        assertViolated(new RequiresChecker("../mover[exactly basic-mover]").check(swarm),
                       "requires path \"../mover[exactly basic-mover]\" to select something, but it selects nothing");
    }

    @Test
    public void anUnknownTypeIsAViolation() {
        final ConstraintCheck check = new RequiresChecker("../mover[unknown]").check(swarm);
        final ConstraintCheck.Violated violated = Assertions.assertInstanceOf(ConstraintCheck.Violated.class, check);

        Assertions.assertTrue(violated.message().contains("unknown type 'unknown'"), violated.message());
    }
}

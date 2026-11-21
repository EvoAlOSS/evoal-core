package de.evoal.optimisation.main.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.ProblemInstance;

/**
 * The problem of a run ({@link OptimisationConfigurationSetup#problemOf}) for OL modules from
 *   the classpath (as in a plugin jar), in {@code de/evoal/optimisation/test/imported}: the
 *   module {@code problem.ol} specifies the problem {@code 'sphere'}; the other modules import
 *   it or specify their own problem {@code 'local'}.
 */
public class ProblemOfTest {
    private static OptimisationModule load(final String file) {
        return LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/imported/" + file);
    }

    @Test
    public void theProblemOfTheAlgorithmMayComeFromAnImportedModule() {
        final OptimisationModule module = load("configuration.ol");

        final ProblemInstance problem = OptimisationConfigurationSetup.problemOf(module);

        Assertions.assertNull(module.getProblem());
        Assertions.assertEquals("sphere", problem.getName());
        Assertions.assertNotSame(module.eResource(), problem.eResource());
    }

    @Test
    public void theImportedProblemMayBeReferencedByItsQualifiedName() {
        final ProblemInstance problem = OptimisationConfigurationSetup.problemOf(load("qualified.ol"));

        Assertions.assertEquals("sphere", problem.getName());
    }

    @Test
    public void theProblemOfTheSameModuleIsUsedAsBefore() {
        final OptimisationModule module = load("same-module.ol");

        Assertions.assertSame(module.getProblem(), OptimisationConfigurationSetup.problemOf(module));
    }

    @Test
    public void aModuleWithoutAlgorithmIsRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> OptimisationConfigurationSetup.problemOf(load("problem.ol")));

        Assertions.assertTrue(e.getMessage().contains("'de.evoal.optimisation.test.imported.problem' configures no algorithm"),
                              e.getMessage());
    }

    @Test
    public void anUnresolvedProblemIsReportedWithItsNameAndTheModule() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> OptimisationConfigurationSetup.problemOf(load("unresolved.ol")));

        Assertions.assertTrue(e.getMessage().contains("'nonexistent'"), e.getMessage());
        Assertions.assertTrue(e.getMessage().contains("'de.evoal.optimisation.test.imported.unresolved'"), e.getMessage());
    }

    @Test
    public void aModuleWithAnotherProblemThanItsAlgorithmIsRejected() {
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> OptimisationConfigurationSetup.problemOf(load("two-problems.ol")));

        Assertions.assertTrue(e.getMessage().contains("specifies the problem 'local'"), e.getMessage());
        Assertions.assertTrue(e.getMessage().contains("for the problem 'sphere'"), e.getMessage());
    }
}

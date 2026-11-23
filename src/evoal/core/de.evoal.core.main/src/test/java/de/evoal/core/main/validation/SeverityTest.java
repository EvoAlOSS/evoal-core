package de.evoal.core.main.validation;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.validation.constraints.Severity;
import de.evoal.core.api.validation.model.Diagnostics;

/**
 * The severity of the constraint annotations: read from the DL literal, and reported by the
 *   {@link ConstraintValidator} at the matching level, so only an error stops the run.
 */
public class SeverityTest {
    @Test
    public void theLiteralsOfTheDlAreRead() {
        final EEnumLiteral warning = EcoreFactory.eINSTANCE.createEEnumLiteral();
        warning.setName("warning");

        Assertions.assertEquals(Severity.WARNING, Severity.of(warning));
        Assertions.assertEquals(Severity.ERROR, Severity.of("error"));
    }

    @Test
    public void anUnknownLiteralIsRejected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Severity.of("info"));
    }

    @Test
    public void aWarningIsReportedAsWarningAndAnErrorAsError() {
        Assertions.assertEquals(Diagnostics.Level.Warning, ConstraintValidator.levelOf(Severity.WARNING));
        Assertions.assertEquals(Diagnostics.Level.Error, ConstraintValidator.levelOf(Severity.ERROR));
    }
}

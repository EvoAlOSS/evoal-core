package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.mll.MachineLearningModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@code @InvertibleOnOutputs}: a preparation step that cannot be undone must not transform an
 *   output feature (#333).
 */
public class InvertibleOnOutputsCheckerTest {
    private static ConstraintCheck check(final String file, final int step) {
        final MachineLearningModule module = LanguageHelper.loadFromClasspath("de/evoal/surrogate/main/internal/" + file);
        final ConcreteStep concrete = (ConcreteStep) module.getPreparation().getSteps().get(step);

        return new InvertibleOnOutputsChecker().check(concrete.getInstance());
    }

    @Test
    public void aStepThatCannotBeUndoneMayTransformAnInput() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, check("not-invertible.mll", 0));
    }

    @Test
    public void aStepThatCannotBeUndoneMustNotTransformAnOutput() {
        final ConstraintCheck result = check("not-invertible.mll", 1);

        Assertions.assertInstanceOf(ConstraintCheck.Violated.class, result);
        Assertions.assertTrue(((ConstraintCheck.Violated) result).message().contains("'y:0'"), result.toString());
    }

    @Test
    public void anInvertibleStepMayTransformAnOutput() {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, check("preparation.mll", 1));
    }
}

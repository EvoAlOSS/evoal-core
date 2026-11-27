package de.evoal.optimisation.api.run;

import java.io.File;

import org.eclipse.emf.ecore.EObject;

import de.evoal.optimisation.api.execution.EvaluationPosition;
import lombok.NonNull;

/**
 * What an application states about a run ({@link SearchRunner#run}).
 *
 * @param number The number of the run; it determines the random numbers of the run, so runs
 *   with different numbers are independent and runs with the same number repeat each other.
 * @param outputFolder The folder for the results of the run, e.g., the memory model.
 * @param position The position of the run in an evaluation setup (repetition, target point),
 *   {@code null} for a run that is not part of one.
 * @param target The values of the target point the run searches for, {@code null} if the
 *   problem's goals have no target point.
 */
public record RunParameters(long number, @NonNull File outputFolder, EvaluationPosition position, EObject target) {
    /**
     * @return The parameters of a run that is not part of an evaluation setup and has no
     *   target point.
     */
    public static RunParameters single(final long number, final File outputFolder) {
        return new RunParameters(number, outputFolder, null, null);
    }
}

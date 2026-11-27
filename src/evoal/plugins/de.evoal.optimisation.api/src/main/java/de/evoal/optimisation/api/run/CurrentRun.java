package de.evoal.optimisation.api.run;

import java.io.File;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.RunScoped;
import de.evoal.optimisation.api.execution.EvaluationPosition;
import lombok.NonNull;

/**
 * The parameters of the current run ({@link RunParameters}). The {@link SearchRunner} states
 *   them when it opens the run; the components of the run read them here, e.g., the output
 *   folder of the memory model or the target point of the goals.
 */
@RunScoped
public class CurrentRun {
    /**
     * The parameters, {@code null} until the runner states them.
     */
    private RunParameters parameters;

    /**
     * @return The current run with the given parameters, e.g., for testing.
     */
    public static CurrentRun of(final RunParameters parameters) {
        final CurrentRun run = new CurrentRun();
        run.setParameters(parameters);

        return run;
    }

    /**
     * States the parameters of the run.
     *
     * @param parameters The parameters of the run.
     * @throws IllegalStateException if the parameters are already stated.
     */
    public void setParameters(final @NonNull RunParameters parameters) {
        if(this.parameters != null) {
            throw new IllegalStateException("The parameters of run " + this.parameters.number() + " are already stated.");
        }

        this.parameters = parameters;
    }

    /**
     * @return The parameters of the run.
     * @throws IllegalStateException if the runner has not stated them.
     */
    public RunParameters getParameters() {
        if(parameters == null) {
            throw new IllegalStateException("The parameters of the run are not stated.");
        }

        return parameters;
    }

    /**
     * @return The number of the run.
     */
    public long number() {
        return getParameters().number();
    }

    /**
     * @return The folder for the results of the run.
     */
    public File outputFolder() {
        return getParameters().outputFolder();
    }

    /**
     * @return The position of the run in the evaluation setup, empty for a run that is not part
     *   of one.
     */
    public Optional<EvaluationPosition> position() {
        return Optional.ofNullable(getParameters().position());
    }

    /**
     * @return The values of the target point the run searches for, empty without one.
     */
    public Optional<EObject> target() {
        return Optional.ofNullable(getParameters().target());
    }
}

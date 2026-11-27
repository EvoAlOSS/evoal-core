package de.evoal.optimisation.api.run;

import java.io.File;

import de.evoal.core.api.cdi.EvaluationScoped;
import lombok.NonNull;

/**
 * The output folder of the current evaluation ({@link SearchRunner#evaluate}): the statistics
 *   files that all runs of the evaluation append to are written there.
 */
@EvaluationScoped
public class CurrentEvaluation {
    /**
     * The output folder, {@code null} until the runner states it.
     */
    private File outputFolder;

    /**
     * @return The current evaluation with the given output folder, e.g., for testing.
     */
    public static CurrentEvaluation of(final File outputFolder) {
        final CurrentEvaluation evaluation = new CurrentEvaluation();
        evaluation.setOutputFolder(outputFolder);

        return evaluation;
    }

    /**
     * States the output folder of the evaluation.
     *
     * @param outputFolder The output folder.
     * @throws IllegalStateException if the output folder is already stated.
     */
    public void setOutputFolder(final @NonNull File outputFolder) {
        if(this.outputFolder != null) {
            throw new IllegalStateException("The output folder of the evaluation is already stated: " + this.outputFolder);
        }

        this.outputFolder = outputFolder;
    }

    /**
     * @return The output folder of the evaluation.
     * @throws IllegalStateException if the runner has not stated it.
     */
    public File outputFolder() {
        if(outputFolder == null) {
            throw new IllegalStateException("The output folder of the evaluation is not stated.");
        }

        return outputFolder;
    }
}

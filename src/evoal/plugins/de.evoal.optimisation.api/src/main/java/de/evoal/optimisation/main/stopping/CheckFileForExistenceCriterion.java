package de.evoal.optimisation.main.stopping;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.reproducibility.ReproducibilityProtocol;

import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.core.exceptions.InitializationException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

import java.io.File;

/**
 * Stops the run as soon as the file {@code 'file'} exists (DL type {@code 'file-check'}),
 *   e.g., to end a long search by hand. Since the result then depends on something outside
 *   the run, the criterion reports a note to the {@link ReproducibilityProtocol}.
 */
@Dependent
@Named("de.evoal.optimisation.core.file-check")
public class CheckFileForExistenceCriterion extends TerminationCriterionImpl {
    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private ReproducibilityProtocol reproducibility;

    private File file;

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        return file.exists();
    }

    @Override
    public TerminationCriterion init(final EObject configuration) throws InitializationException {
        String filename = evaluator.attributeToString(configuration, "file");
        file = new File(filename);

        reproducibility.report("file-check", "stops the run when the file '" + filename + "' exists, so the result depends on something outside the run");

        return this;
    }
}

package de.evoal.optimisation.main.stopping;

import de.evoal.core.api.languages.AttributeEvaluator;

import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.core.exceptions.InitializationException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

import java.io.File;

@Dependent
@Named("de.evoal.optimisation.core.file-check")
public class CheckFileForExistenceCriterion extends TerminationCriterionImpl {
    @Inject
    private AttributeEvaluator evaluator;

    private File file;

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        return file.exists();
    }

    @Override
    public TerminationCriterion init(final EObject configuration) throws InitializationException {
        String filename = evaluator.attributeToString(configuration, "file");
        file = new File(filename);

        return this;
    }
}

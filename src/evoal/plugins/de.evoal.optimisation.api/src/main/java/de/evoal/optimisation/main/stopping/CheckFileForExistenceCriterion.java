package de.evoal.optimisation.main.stopping;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.Iteration;
import de.evoal.optimisation.api.model.StoppingCriterion;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.File;

@Dependent
@Named("de.evoal.optimisation.core.file-check")
public class CheckFileForExistenceCriterion implements StoppingCriterion {
    @Inject
    private AttributeEvaluator evaluator;

    private File file;

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        return file.exists();
    }

    @Override
    public StoppingCriterion init(final Instance configuration) throws InitializationException {
        String filename = (String) evaluator.attributeToString(configuration, "file");
        file = new File(filename);

        return this;
    }
}

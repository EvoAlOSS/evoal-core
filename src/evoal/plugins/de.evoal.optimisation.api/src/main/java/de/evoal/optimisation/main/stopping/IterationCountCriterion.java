package de.evoal.optimisation.main.stopping;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.Iteration;
import de.evoal.optimisation.api.model.StoppingCriterion;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.core.iteration-count")
public class IterationCountCriterion implements StoppingCriterion {
    @Inject
    private AttributeEvaluator evaluator;

    private int maxIterations = 10;

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        log.info("Check termination {} > {}.", iteration.iteration(), maxIterations);

        return iteration.iteration() > maxIterations;
    }

    @Override
    public StoppingCriterion init(final Instance configuration) throws InitializationException {
        maxIterations = evaluator.attributeToInteger(configuration, "maximum-iterations");

        return this;
    }
}

package de.evoal.optimisation.main.stopping;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.core.exceptions.InitializationException;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.core.iteration-count")
public class IterationCountCriterion extends TerminationCriterionImpl {
    @Inject
    private AttributeEvaluator evaluator;

    private int maxIterations = 10;

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        log.info("Check termination {} > {}.", iteration.getNumber(), maxIterations);

        return iteration.getNumber() > maxIterations;
    }

    @Override
    public TerminationCriterion init(final EObject configuration) throws InitializationException {
        maxIterations = evaluator.attributeToInteger(configuration, "maximum-iterations");

        return this;
    }
}

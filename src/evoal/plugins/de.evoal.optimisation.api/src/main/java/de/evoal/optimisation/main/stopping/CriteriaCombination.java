package de.evoal.optimisation.main.stopping;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Iteration;

/**
 * A combination of stopping criteria ({@code 'all-of'}, {@code 'any-of'}). It checks every
 *   criterion in every iteration, also when the result is already decided, so criteria with
 *   a state (e.g. {@code 'stagnation'}) see every iteration.
 */
public abstract class CriteriaCombination extends TerminationCriterionImpl {
    /**
     * The combined criteria, in the order of the configuration.
     */
    private final List<TerminationCriterion> criteria = new ArrayList<>();

    @Inject
    private AttributeHelper helper;

    /**
     * Creates the combination without criteria. CDI uses it before {@link #init(EObject)}.
     */
    protected CriteriaCombination() {
    }

    /**
     * @param criteria The combined criteria.
     * @throws IllegalArgumentException if there is no criterion.
     */
    protected CriteriaCombination(final List<TerminationCriterion> criteria) {
        if(criteria.isEmpty()) {
            throw new IllegalArgumentException("A combination of stopping criteria needs at least one criterion.");
        }
        this.criteria.addAll(criteria);
    }

    /**
     * @param results Whether each criterion is satisfied, in the order of the criteria.
     * @return Whether the combination is satisfied.
     */
    protected abstract boolean combine(boolean[] results);

    /**
     * @throws InitializationException if {@code criteria} is empty.
     */
    @Override
    public TerminationCriterion init(final EObject configuration) throws InitializationException {
        final List<Configuration> configurations = helper.lookup(configuration, "criteria");
        if(configurations == null || configurations.isEmpty()) {
            throw new InitializationException("The stopping criterion '" + configuration.eClass().getName()
                                              + "' needs at least one criterion in 'criteria'.");
        }

        configurations.stream()
                      .map(criterion -> BeanFactory.createComponent(TerminationCriterion.class, criterion))
                      .forEach(criteria::add);

        return this;
    }

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        final boolean[] results = new boolean[criteria.size()];
        for(int index = 0; index < results.length; ++index) {
            results[index] = criteria.get(index).shouldTerminate(iteration);
        }

        return combine(results);
    }
}

package de.evoal.optimisation.api.cdi;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.optimisation.main.stopping.AnyOfCriterion;

/**
 * Creates the termination criterion of an algorithm: the criteria of its
 *   {@code 'stopping-criteria'}, of which at least one has to be satisfied.
 */
@ApplicationScoped
public class TerminationCriterionProducer {
    @Inject
    private AttributeHelper helper;

    /**
     * @param algorithm The configuration of the algorithm.
     * @return A criterion that is satisfied when at least one of the configured criteria is.
     * @throws IllegalArgumentException if the algorithm has no stopping criterion.
     */
    public TerminationCriterion create(final EObject algorithm) {
        final List<Configuration> configurations = helper.lookup(algorithm, "stopping-criteria");

        final List<TerminationCriterion> criteria = configurations.stream()
                                                                  .map(this::createCriterion)
                                                                  .toList();

        return new AnyOfCriterion(criteria);
    }

    private TerminationCriterion createCriterion(final Configuration configuration) {
        return BeanFactory.createComponent(TerminationCriterion.class, configuration);
    }
}

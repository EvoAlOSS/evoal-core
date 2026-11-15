package de.evoal.optimisation.api.cdi;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;

import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.optimisation.main.stopping.CriterionCombiner;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

@ApplicationScoped
public class TerminationCriterionProducer {
    @Inject
    private AttributeHelper helper;

    public TerminationCriterion create(final EObject algorithm) {
        final CriterionCombiner criterion = new CriterionCombiner();

        // create list of stopping criteria
        final List<Configuration> criteria = helper.lookup(algorithm, "stopping-criteria");

        // instantiate all criteria and add it to the criterion combiner
        criteria.stream()
                .map(config -> BeanFactory.createComponent(TerminationCriterion.class, config))
                .forEach(criterion::add);

        return criterion;
    }
}

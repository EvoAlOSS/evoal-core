package de.evoal.optimisation.api.cdi;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.StoppingCriterion;
import de.evoal.optimisation.main.stopping.CriterionCombiner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class StoppingCriterionProducer {
    @Inject
    private AttributeHelper helper;

    public StoppingCriterion create(final Instance algorithm) {
        final CriterionCombiner criterion = new CriterionCombiner();

        // create list of stopping criteria
        final List<Instance> criteria = helper.lookup(algorithm, "stopping-criteria");

        for(final de.evoal.languages.model.base.expressions.Instance delegateConfig : criteria) {
            final StoppingCriterion delegate = BeanFactory.createComponent(StoppingCriterion.class, delegateConfig);

            criterion.add(delegate);
        }

        return criterion;
    }
}

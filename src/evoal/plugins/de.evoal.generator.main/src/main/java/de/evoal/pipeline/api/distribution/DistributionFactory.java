package de.evoal.pipeline.api.distribution;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import java.util.List;

@ApplicationScoped
public class DistributionFactory {
    private DistributionFactory() {}

    public List<Distribution> readDistributions(final Instance instance, final String name) {
        final AttributeHelper helper = BeanFactory.create(AttributeHelper.class);

        final List<Instance> distributions = helper.lookup(instance, name);

        return distributions.stream()
                .map(i -> BeanFactory.createComponent(Distribution.class, i))
                .toList();
    }
}

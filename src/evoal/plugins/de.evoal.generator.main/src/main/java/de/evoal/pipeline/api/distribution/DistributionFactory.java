package de.evoal.pipeline.api.distribution;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

@ApplicationScoped
public class DistributionFactory {
    private DistributionFactory() {}

    public List<Distribution> readDistributions(final EObject instance, final String name) {
        final AttributeHelper helper = BeanFactory.create(AttributeHelper.class);

        final List<EObject> distributions = helper.lookup(instance, name);

        return distributions.stream()
                .map(i -> BeanFactory.createComponent(Distribution.class, i))
                .toList();
    }
}

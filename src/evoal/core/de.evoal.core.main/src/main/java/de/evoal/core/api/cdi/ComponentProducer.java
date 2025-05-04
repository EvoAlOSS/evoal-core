package de.evoal.core.api.cdi;

import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ComponentProducer {
    public <T extends EvoalComponent<T>> T create(final Class<T> clazz, final Instance configuration) {
        return BeanFactory.createComponent(clazz, configuration);
    }
}

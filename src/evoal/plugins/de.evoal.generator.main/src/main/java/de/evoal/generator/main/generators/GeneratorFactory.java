package de.evoal.generator.main.generators;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.dl.util.FQNProvider;
import de.evoal.languages.model.generator.Step;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GeneratorFactory {

    public GeneratorFunction create(final Step configuration) throws InitializationException {
        final String name = new FQNProvider().get(configuration.getInstance());

        return BeanFactory.create(name, GeneratorFunction.class)
                          .init(configuration);
    }
}

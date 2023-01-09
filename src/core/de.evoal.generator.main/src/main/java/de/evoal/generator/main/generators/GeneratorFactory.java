package de.evoal.generator.main.generators;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.generator.Step;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeneratorFactory {
    public GeneratorFunction create(final Step configuration) throws InitializationException {
        final String functionName = configuration.getInstance().getName().getName();

        return BeanFactory.create(functionName, GeneratorFunction.class)
                          .init(configuration);
    }
}

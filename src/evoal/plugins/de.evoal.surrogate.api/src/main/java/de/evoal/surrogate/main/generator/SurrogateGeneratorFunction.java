package de.evoal.surrogate.main.generator;

import de.evoal.core.api.properties.Properties;
import de.evoal.generator.api.AbstractGeneratorFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("de.evoal.surrogate.generator.surrogate")
public class SurrogateGeneratorFunction extends AbstractGeneratorFunction {

    @Inject
    private SurrogateFunction function;

    @Override
    public Properties apply(final Properties in) {
        final Properties out = mergeAndCopy(in);
        final Properties result = function.apply(in);

        out.putAll(result);

        return out;
    }

}

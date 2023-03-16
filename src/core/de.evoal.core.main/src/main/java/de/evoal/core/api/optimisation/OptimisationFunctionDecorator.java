package de.evoal.core.api.optimisation;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.languages.model.instance.Instance;

public abstract class OptimisationFunctionDecorator implements OptimisationFunction {
    protected OptimisationFunction decoratedFunction;

    @Override
    public OptimisationFunction init(final Instance config) {
        final Instance decoratedConfig = (Instance) config.findAttribute("function").getValue();

        decoratedFunction = BeanFactory.create(decoratedConfig.getDefinition().getName(), OptimisationFunction.class);
        decoratedFunction.init(decoratedConfig);

        return this;
    }
}

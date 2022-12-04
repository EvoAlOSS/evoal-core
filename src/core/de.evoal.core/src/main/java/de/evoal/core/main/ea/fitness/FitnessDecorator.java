package de.evoal.core.main.ea.fitness;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.languages.model.instance.Instance;

public abstract class FitnessDecorator implements FitnessFunction {
    protected FitnessFunction decoratedFunction;

    @Override
    public FitnessFunction init(final Instance config) {
        final Instance decoratedConfig = (Instance) config.findAttribute("function").getValue();

        decoratedFunction = BeanFactory.create(decoratedConfig.getName().getName(), FitnessFunction.class);

        return this;
    }
}

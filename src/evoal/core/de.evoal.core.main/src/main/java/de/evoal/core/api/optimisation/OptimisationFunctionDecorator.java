package de.evoal.core.api.optimisation;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Instance;

import javax.inject.Inject;

public abstract class OptimisationFunctionDecorator implements OptimisationFunction {
    protected OptimisationFunction decoratedFunction;

    @Inject
    protected LanguageHelper helper;

    @Override
    public OptimisationFunction init(final Instance config) {
        final Instance decoratedConfig = helper.lookup(config, "function");

        decoratedFunction = BeanFactory.createComponent(OptimisationFunction.class, decoratedConfig);

        return this;
    }
}

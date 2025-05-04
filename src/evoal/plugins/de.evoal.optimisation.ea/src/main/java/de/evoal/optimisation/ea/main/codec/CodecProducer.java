package de.evoal.optimisation.ea.main.codec;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class CodecProducer {
    @Produces @Named("codec")
    public CustomCodec create(final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.genotype") Instance configuration) {
        return BeanFactory.createComponent(CustomCodec.class, configuration);
    }

}

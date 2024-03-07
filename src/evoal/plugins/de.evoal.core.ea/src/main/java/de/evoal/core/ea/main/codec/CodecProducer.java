package de.evoal.core.ea.main.codec;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.ea.api.codec.CustomCodec;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class CodecProducer {
    @Produces @Named("codec")
    public CustomCodec create(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.genotype") Instance configuration) {
        return BeanFactory.createComponent(CustomCodec.class, configuration);
    }
}

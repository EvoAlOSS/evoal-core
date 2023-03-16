package de.evoal.core.ea.main.codec;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
@Slf4j
public class DynamicCodecProducer {
    @Produces @ApplicationScoped
    public DynamicCodec create(@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.genotype") Instance[] config, final @Named("genotype-specification") PropertiesSpecification specification) {
        log.info("Creating encoding for EA problem.");

        return DynamicCodec.from(config, specification);
    }
}

package de.evoal.core.main.ea.codec;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.instance.Array;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@ApplicationScoped
@Slf4j
public class DynamicCodecProducer {
    @Produces @Dependent
    public DynamicCodec create(@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.genotype") Array config) {
        log.info("Creating encoding for EA problem.");

        return DynamicCodec.from(config);
    }
}

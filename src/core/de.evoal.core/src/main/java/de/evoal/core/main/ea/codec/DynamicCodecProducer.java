package de.evoal.core.main.ea.codec;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.instance.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
@Slf4j
public class DynamicCodecProducer {
    @Produces @ApplicationScoped
    public DynamicCodec create(@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.genotype") Array config, final @Named("genotype-specification") PropertiesSpecification specification) {
        log.info("Creating encoding for EA problem.");

        return DynamicCodec.from(config, specification);
    }
}

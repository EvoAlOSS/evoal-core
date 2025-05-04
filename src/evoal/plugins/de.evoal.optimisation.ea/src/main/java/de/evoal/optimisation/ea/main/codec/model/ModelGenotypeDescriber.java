package de.evoal.optimisation.ea.main.codec.model;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.optimisation.ea.api.codec.CustomCodecDescriber;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Named(ModelGenotypeCodec.GENOTYPE_NAME + "-describer")
@Slf4j
public class ModelGenotypeDescriber implements CustomCodecDescriber {

    private Instance configuration;

    @Inject
    private AttributeHelper helper;

    @Override
    public CustomCodecDescriber init(final Instance configuration) throws InitializationException {
        log.info("Setting up describer");
        this.configuration = configuration;

        return CustomCodecDescriber.super.init(configuration);
    }

    @Override
    public List<Definition> describe() {
        log.info("Describing Genotype.");
        final List<Instance> genes = helper.lookup(configuration, "chromosomes");

        return genes
                .stream()
                .map(i -> helper.<StructuredDataDescription>lookup(i, "root"))
                .map(StructuredDataDescription::getType)
                .collect(Collectors.toList());
    }
}

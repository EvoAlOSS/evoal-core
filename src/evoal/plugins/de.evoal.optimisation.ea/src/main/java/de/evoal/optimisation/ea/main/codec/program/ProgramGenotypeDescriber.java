package de.evoal.optimisation.ea.main.codec.program;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.optimisation.ea.api.codec.CustomCodecDescriber;
import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Named("de.evoal.optimisation.ea.genetic-programming.program-genotype-describer")
@Slf4j
public class ProgramGenotypeDescriber implements CustomCodecDescriber {

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

        return genes.stream()
                .map(i -> helper.<Definition>lookup(i, "content"))
                .collect(Collectors.toList());
    }
}

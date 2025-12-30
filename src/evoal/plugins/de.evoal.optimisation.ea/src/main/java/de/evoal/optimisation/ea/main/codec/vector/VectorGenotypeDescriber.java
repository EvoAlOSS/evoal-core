package de.evoal.optimisation.ea.main.codec.vector;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.optimisation.ea.api.codec.CustomCodecDescriber;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.definitions.Definition;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Named("de.evoal.optimisation.ea.optimisation.vector-genotype-describer")
@Slf4j
public class VectorGenotypeDescriber implements CustomCodecDescriber {

    private Instance configuration;

    @Inject
    private AttributeHelper helper;

    @Inject
    private AttributeEvaluator evaluator;

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
                .flatMap(i -> helper.<List<Instance>>lookup(i, "genes").stream())
                .map(i -> helper.<Definition>lookup(i, "content"))
                .collect(Collectors.toList());
    }
}

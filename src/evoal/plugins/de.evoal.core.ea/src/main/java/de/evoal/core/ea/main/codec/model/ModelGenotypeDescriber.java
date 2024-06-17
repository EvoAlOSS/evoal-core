package de.evoal.core.ea.main.codec.model;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.ea.api.codec.CustomCodecDescriber;
import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Instance;
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
    private LanguageHelper helper;

    @Inject
    private ExpressionEvaluator evaluator;

    @Override
    public CustomCodecDescriber init(final Instance configuration) throws InitializationException {
        log.info("Setting up describer");
        this.configuration = configuration;

        return CustomCodecDescriber.super.init(configuration);
    }

    @Override
    public List<Definition> describe() {
        log.info("Describing Genotype.");
        final Object [] genes = helper.lookup(configuration, "chromosomes");

        return Arrays.stream(genes)
                .map(Instance.class::cast)
                .map(i -> evaluator.attributeToObject(i, "root"))
                .map(Definition.class::cast)
                .collect(Collectors.toList());
    }
}

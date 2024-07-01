package de.evoal.optimisation.ea.main.codec.vector;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.optimisation.ea.api.codec.CustomCodecDescriber;
import de.evoal.languages.model.base.Attribute;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.Definition;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Named("de.evoal.optimisation.ea.optimisation.vector-genotype-describer")
@Slf4j
public class VectorGenotypeDescriber implements CustomCodecDescriber {

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
                .map(i -> i.findAttribute("genes"))
                .map(Attribute::getValue)
                .map(evaluator::evaluate)
                .flatMap(l -> ((List<Instance>)(List)l).stream())
                .map(i -> evaluator.attributeToObject(i, "content"))
                .map(Definition.class::cast)
                .collect(Collectors.toList());
    }
}

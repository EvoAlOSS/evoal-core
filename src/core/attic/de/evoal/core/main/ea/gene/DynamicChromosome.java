package de.evoal.core.main.ea.gene;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import io.jenetics.AbstractChromosome;

import io.jenetics.util.ISeq;

public class DynamicChromosome<G extends DynamicGene<? extends Object>> extends AbstractChromosome<G> {

    protected DynamicChromosome(final ISeq<G> genes) {
        super(genes);
    }

    @Override
    public DynamicChromosome newInstance(final ISeq<G> iSeq) {
        return new DynamicChromosome(iSeq);
    }

    @Override
    public DynamicChromosome newInstance() {
        return new DynamicChromosome(random(_genes));
    }

    private static <G extends DynamicGene<? extends Object>>  ISeq<G> random(final ISeq<G> template) {
        return template.stream()
                .map(DynamicGene::newInstance)
                .collect(ISeq.toISeq());
    }

    public static DynamicChromosome from(final PropertiesSpecification specification) {
        return new DynamicChromosome(specification.getProperties()
                            .stream()
                .map(DynamicChromosome::toGene)
                .collect(ISeq.toISeq()));
    }

    private static DynamicGene<? extends Object> toGene(final PropertySpecification spec) {

    }
}

package de.evoal.core.ea.api.codec.model;

import de.evoal.core.ea.main.codec.model.ModelBuilder;
import de.evoal.languages.model.base.Instance;
import io.jenetics.AbstractChromosome;
import io.jenetics.Chromosome;
import io.jenetics.util.ISeq;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.util.EcoreUtil;

@Slf4j
public class ModelChromosome extends AbstractChromosome<ModelGene> {
    private final ModelBuilder builder;

    public ModelBuilder builder() {
        return builder;
    }

    /**
     * Create a new {@code AbstractChromosome} from the given {@code genes}
     * array.
     *
     * @param genes the genes that form the chromosome.
     * @throws NullPointerException     if the given gene array is {@code null}.
     * @throws IllegalArgumentException if the length of the gene sequence is
     *                                  empty.
     */
    protected ModelChromosome(ISeq<? extends ModelGene> genes, final ModelBuilder builder) {
        super(genes);
        this.builder = builder;
    }

    public static ModelChromosome of(final ModelBuilder memento) {
        return create(memento);
    }

    public static ModelChromosome of(final ModelBuilder memento, final Instance model) {
        return new ModelChromosome(ISeq.of(memento.toIterable(model)), memento);
    }

    private static ModelChromosome create(final ModelBuilder builder) {
        return ModelChromosome.of(builder, builder.random());
    }

    @Override
    public Chromosome<ModelGene> newInstance(final ISeq<ModelGene> genes) {
        return new ModelChromosome(genes, builder);
    }

    @Override
    public Chromosome<ModelGene> newInstance() {
        log.info("Creating new instance of model chromosome");
        return ModelChromosome.of(builder, builder.random());
    }

    public Instance getModel() {
        return ((ModelGene)gene()).allele();
    }

    public ModelChromosome copy() {
        return ModelChromosome.of(builder, EcoreUtil.copy(getModel()));
    }
}

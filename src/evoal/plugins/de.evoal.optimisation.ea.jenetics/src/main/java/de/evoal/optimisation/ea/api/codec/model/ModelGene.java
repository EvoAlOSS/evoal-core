package de.evoal.optimisation.ea.api.codec.model;

import de.evoal.languages.model.base.types.BooleanType;
import de.evoal.languages.model.base.types.IntType;
import de.evoal.languages.model.base.types.Type;
import de.evoal.optimisation.ea.main.codec.model.ModelBuilder;
import de.evoal.languages.model.base.expressions.*;
import io.jenetics.Gene;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A model gene represents an instance of the model space.
 */
public class ModelGene implements Gene<Instance, ModelGene> {
    /**
     * The model builder for generating new random instances.
     */
    private final ModelBuilder builder;

    /**
     * The instance the gene corresponds to
     */
    private final Instance allele;

    private ModelGene(final ModelBuilder builder, final Instance allele) {
        this.builder = builder;
        this.allele = allele;
    }

    @Override
    public Instance allele() {
        return allele;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public ModelGene newInstance() {
        final Instance copy = EcoreUtil.copy(allele);

        for(final Attribute attribute : copy.getAttributes()) {
            final Type attributeType = attribute.getDefinition().getType();
            if(attributeType instanceof IntType || attributeType instanceof BooleanType) {
                // regenerate attribute and set value to newly generated value
                final Attribute attr = builder.random(attribute.getDefinition());
                attribute.setValue(attr.getValue());
            }
        }

        return new ModelGene(builder, copy);
    }

    @Override
    public ModelGene newInstance(final Instance value) {
        return new ModelGene(builder, value);
    }

    public static ModelGene of(final ModelBuilder builder, final Instance allele) {
        return new ModelGene(builder, allele);
    }

    public int size() {
        return builder.size(allele);
    }
}

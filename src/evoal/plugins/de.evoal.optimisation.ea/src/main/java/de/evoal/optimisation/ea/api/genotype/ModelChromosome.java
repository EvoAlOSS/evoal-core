package de.evoal.optimisation.ea.api.genotype;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.builder.AttributeSlots.Slot;

/**
 * Structured features (models), one {@link ModelGenes model gene} each: the gene is a copy of the
 *   tree of the feature. Decoding and encoding copy the trees, so the genes and the candidates
 *   never share objects.
 */
public final class ModelChromosome extends Chromosome {
    /**
     * The shared context of the genes.
     */
    private final ModelGenes.Context context;

    /**
     * @param features The structured features.
     * @param context The tables, boundaries and boundary handling of the models.
     */
    public ModelChromosome(final List<EStructuralFeature> features, final ModelGenes.Context context) {
        super(features);
        this.context = context;
    }

    /**
     * @return The shared context of the genes.
     */
    public ModelGenes.Context context() {
        return context;
    }

    @Override
    public void decode(final Genes genes, final TypedEObject target) {
        final ModelGenes models = (ModelGenes) genes;

        for(int i = 0; i < models.size(); ++i) {
            target.eSet(features().get(i), EcoreUtil.copy(models.root(i)));
        }
    }

    @Override
    public ModelGenes encode(final TypedEObject candidate) {
        final EObject[] roots = new EObject[features().size()];

        for(int i = 0; i < roots.length; ++i) {
            roots[i] = EcoreUtil.copy((EObject) candidate.eGet(features().get(i)));
        }

        return new ModelGenes(roots, context);
    }

    @Override
    public int featureOfGene(final int gene) {
        return gene;
    }

    /**
     * Brings every integer and real attribute value of the models back into its boundaries.
     */
    @Override
    public void handleBoundaries(final Genes genes, final BoundaryHandling handling) {
        final ModelGenes models = (ModelGenes) genes;

        for(final Slot slot : models.slots(ModelChromosome::isNumeric)) {
            final EAttribute attribute = slot.attribute();
            final Number value = (Number) slot.get();

            if(EClassifierHelper.isInteger(attribute.getEType())) {
                final long[] bounds = context.integerBounds(attribute);
                final long handled = handling.apply(value.longValue(), bounds[0], bounds[1]);
                if(handled != value.longValue()) {
                    slot.set(NumericConversions.toType(handled, attribute.getEType()));
                }
            } else {
                final double[] bounds = context.realBounds(attribute);
                final double handled = handling.apply(value.doubleValue(), bounds[0], bounds[1]);
                if(Double.compare(handled, value.doubleValue()) != 0) {
                    slot.set(NumericConversions.toType(handled, attribute.getEType()));
                }
            }
        }
    }

    /**
     * @return Whether the slot holds an integer or a real value.
     */
    public static boolean isNumeric(final Slot slot) {
        final EClassifier type = slot.attribute().getEType();

        return EClassifierHelper.isInteger(type) || EClassifierHelper.isDouble(type);
    }

    @Override
    public Representation representation() {
        return Representation.MODEL;
    }
}

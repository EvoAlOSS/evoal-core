package de.evoal.optimisation.ea.api.genotype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lombok.NonNull;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.core.api.ecore.info.FeatureBoundaries;

import de.evoal.optimisation.api.builder.AttributeSlots;
import de.evoal.optimisation.api.builder.AttributeSlots.Slot;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.builder.ValueDrawer;

/**
 * The genes of a {@link ModelChromosome}: one model per feature, the root of its tree. The value
 *   mutations change the {@link AttributeSlots attribute slots} of the models, the structural
 *   operators their trees. All candidates of a chromosome share its {@link Context}.
 */
public final class ModelGenes implements Genes {
    /**
     * What the operators need to know about the models of a chromosome.
     *
     * @param types The tables of the classes of the models.
     * @param values Draws attribute values within their boundaries.
     * @param boundaries The boundaries of the numeric attributes; every numeric attribute of a
     *   model chromosome has both.
     * @param handling Brings a value outside its boundaries back, the {@code 'boundary-handling'}
     *   of the algorithm.
     * @param rootTypes The types of the features of the chromosome, i.e. of the roots of its
     *   models, in the order of the features.
     */
    public record Context(@NonNull ModelTypes types, @NonNull ValueDrawer values, @NonNull FeatureBoundaries boundaries,
                          @NonNull BoundaryHandling handling, @NonNull List<EClass> rootTypes) {
        public Context {
            rootTypes = List.copyOf(rootTypes);
        }

        /**
         * @return The inclusive boundaries of an integer attribute.
         */
        public long[] integerBounds(final EAttribute attribute) {
            final FeatureBoundaries.Boundaries bounds = boundaries.get(attribute);
            final long lower = bounds.lower().longValue() + (bounds.lowerIncluded() ? 0 : 1);
            final long upper = bounds.upper().longValue() - (bounds.UpperIncluded() ? 0 : 1);

            return new long[] {lower, upper};
        }

        /**
         * @return The inclusive boundaries of a real attribute; an exclusive boundary is replaced by
         *   the nearest value within.
         */
        public double[] realBounds(final EAttribute attribute) {
            final FeatureBoundaries.Boundaries bounds = boundaries.get(attribute);
            final double lower = bounds.lowerIncluded() ? bounds.lower().doubleValue() : Math.nextUp(bounds.lower().doubleValue());
            final double upper = bounds.UpperIncluded() ? bounds.upper().doubleValue() : Math.nextDown(bounds.upper().doubleValue());

            return new double[] {lower, upper};
        }
    }

    /**
     * The shared context.
     */
    private final Context context;

    /**
     * The roots of the models, one per feature.
     */
    private final EObject[] roots;

    /**
     * @param roots The roots of the models; the array is used, not copied, and the trees belong
     *   to the genes.
     * @param context The shared context of the chromosome.
     */
    public ModelGenes(final @NonNull EObject[] roots, final @NonNull Context context) {
        this.roots = roots;
        this.context = context;
    }

    /**
     * @return The shared context of the chromosome.
     */
    public Context context() {
        return context;
    }

    @Override
    public ModelGenes copy() {
        final EObject[] copies = new EObject[roots.length];
        for(int i = 0; i < roots.length; ++i) {
            copies[i] = EcoreUtil.copy(roots[i]);
        }

        return new ModelGenes(copies, context);
    }

    @Override
    public boolean equalAt(final Genes other, final int index) {
        requireCompatible(other);

        return EcoreUtil.equals(roots[index], ((ModelGenes) other).roots[index]);
    }

    @Override
    public void exchange(final Genes other, final int index) {
        requireCompatible(other);

        final ModelGenes genes = (ModelGenes) other;
        final EObject root = roots[index];
        roots[index] = genes.roots[index];
        genes.roots[index] = root;
    }

    /**
     * @return The root of the model of the feature at the index.
     */
    public EObject root(final int index) {
        return roots[index];
    }

    /**
     * Replaces the model of the feature at the index.
     */
    public void setRoot(final int index, final @NonNull EObject root) {
        roots[index] = root;
    }

    @Override
    public int size() {
        return roots.length;
    }

    /**
     * @param applies Whether a mutation changes the slot.
     * @return The slots of all models that the mutation changes, model after model, each in the
     *   order of {@link AttributeSlots}.
     */
    public List<Slot> slots(final @NonNull Predicate<Slot> applies) {
        final List<Slot> slots = new ArrayList<>();
        for(final EObject root : roots) {
            for(final Slot slot : AttributeSlots.of(root, context.types()::isOptional)) {
                if(applies.test(slot)) {
                    slots.add(slot);
                }
            }
        }

        return slots;
    }

    @Override
    public String toString() {
        return Arrays.toString(roots);
    }
}

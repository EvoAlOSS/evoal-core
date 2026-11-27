package de.evoal.optimisation.ea.main.operators.model;

import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.operators.AbstractModelMutation;

/**
 * Array reorder mutation (DL type {@code 'array-reorder-mutation'}): an array of every model
 *   with at least two elements is chosen uniformly, and two different positions, drawn
 *   uniformly, exchange their elements, as the swap mutation of permutations does. A model
 *   without such an array stays unchanged.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.array-reorder-mutation")
public class ArrayReorderMutation extends AbstractModelMutation {
    public ArrayReorderMutation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     */
    public ArrayReorderMutation(final double probability) {
        super(probability);
    }

    @Override
    protected void mutateModel(final ModelGenes models, final int model, final RandomGenerator random) {
        final EObject root = models.root(model);
        final List<ModelArray> arrays = ModelArray.of(root)
                                                  .stream()
                                                  .filter(array -> array.elements().size() >= 2)
                                                  .toList();
        if(arrays.isEmpty()) {
            return;
        }

        final ModelArray array = arrays.get(random.nextInt(arrays.size()));
        final EList<Object> elements = (EList<Object>) array.elements();
        final int count = elements.size();

        final int drawnFirst = random.nextInt(count);
        final int drawnSecond = random.nextInt(count - 1);
        final int other = drawnSecond >= drawnFirst ? drawnSecond + 1 : drawnSecond;
        final int lower = Math.min(drawnFirst, other);
        final int upper = Math.max(drawnFirst, other);

        // the element at upper moves to lower, the former element at lower is then at lower + 1
        elements.move(lower, upper);
        elements.move(upper, lower + 1);
    }

    @Override
    public String name() {
        return "array-reorder-mutation";
    }
}

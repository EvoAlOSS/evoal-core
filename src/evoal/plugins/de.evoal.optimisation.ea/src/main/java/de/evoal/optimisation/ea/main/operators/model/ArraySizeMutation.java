package de.evoal.optimisation.ea.main.operators.model;

import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelTrees;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.models.ModelCandidates;
import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.operators.AbstractModelMutation;

/**
 * Array size mutation (DL type {@code 'array-size-mutation'}): an array of every model whose
 *   number of elements can change (its @MinimumNumberOfElements is below its
 *   @MaximumNumberOfElements) is chosen uniformly and gets one element more or less: at the
 *   minimum one more, at the maximum one less, otherwise each with probability 1/2. A new
 *   element is inserted at a uniformly drawn position; it is a value drawn as by the random
 *   population, or a new tree built with the {@code method}. A uniformly drawn element is
 *   removed. A model without such an array stays unchanged.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.array-size-mutation")
public class ArraySizeMutation extends AbstractModelMutation {
    /**
     * Builds the new trees; {@code null} without {@code method}.
     */
    private SubtreeFactory subtrees;

    public ArraySizeMutation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     * @param settings The method of new trees, {@code null} if the models have no array of
     *   objects whose size can change.
     */
    public ArraySizeMutation(final double probability, final BuildSettings settings) {
        super(probability);
        this.subtrees = settings == null ? null : new SubtreeFactory(settings);
    }

    /**
     * @return Whether the number of elements of the feature can change.
     */
    private static boolean isResizable(final EStructuralFeature feature, final ModelTypes types) {
        return feature.isMany() && types.minimumCount(feature) < types.maximumCount(feature);
    }

    /**
     * Rejects a missing {@code method} if the models have arrays of objects whose size can change.
     */
    @Override
    public void check(final Chromosome chromosome) throws InitializationException {
        super.check(chromosome);
        final ModelGenes.Context context = ((ModelChromosome) chromosome).context();

        final boolean hasResizableContainment = context.types()
                                                       .classes()
                                                       .stream()
                                                       .flatMap(eClass -> eClass.getEAllContainments().stream())
                                                       .anyMatch(containment -> isResizable(containment, context.types()));
        if(hasResizableContainment && subtrees == null) {
            throw new InitializationException("The models have arrays of objects whose size can change, so the '" + name()
                                              + "' needs a 'method' for their new elements.");
        }
        if(subtrees != null) {
            subtrees.check(context, name());
        }
    }

    @Override
    protected void configureModel(final EObject configuration, final AttributeEvaluator attributes) {
        subtrees = ModelCandidates.optionalValue(configuration, "method")
                                  .map(EObject.class::cast)
                                  .map(SubtreeFactory::new)
                                  .orElse(null);
    }

    @Override
    protected void mutateModel(final ModelGenes models, final int model, final RandomGenerator random) {
        final ModelGenes.Context context = models.context();
        final EObject root = models.root(model);
        final List<ModelArray> arrays = ModelArray.of(root)
                                                  .stream()
                                                  .filter(array -> isResizable(array.feature(), context.types()))
                                                  .toList();
        if(arrays.isEmpty()) {
            return;
        }

        final ModelArray array = arrays.get(random.nextInt(arrays.size()));
        final List<Object> elements = array.elements();
        final int count = elements.size();
        final int minimum = context.types().minimumCount(array.feature());
        final int maximum = context.types().maximumCount(array.feature());

        final boolean adds;
        if(count <= minimum) {
            adds = true;
        } else if(count >= maximum) {
            adds = false;
        } else {
            adds = random.nextBoolean();
        }

        if(!adds) {
            elements.remove(random.nextInt(count));
            return;
        }

        final int position = random.nextInt(count + 1);
        if(array.feature() instanceof EAttribute attribute) {
            elements.add(position, context.values().draw(attribute, random));
        } else {
            final EClass type = ((EReference) array.feature()).getEReferenceType();
            final int depth = ModelTrees.depthOf(array.object(), root) + 1;
            final EObject element = subtrees.build(context, type, depth, ModelTrees.size(root), random);
            elements.add(position, element);
        }
    }

    @Override
    public String name() {
        return "array-size-mutation";
    }
}

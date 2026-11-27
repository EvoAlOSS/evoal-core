package de.evoal.optimisation.ea.main.operators.model;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelTrees;
import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.operators.AbstractModelMutation;
import de.evoal.optimisation.ea.api.operators.NodeSelection;

/**
 * Subtree mutation (DL type {@code 'subtree-mutation'}): a node of every model, the root
 *   included, is replaced by a new random tree of the type of its place, built with the
 *   {@code method} (Poli, Langdon and McPhee 2008, sec. 2.4; typed as in Montana 1995, sec. 2.1).
 *   The node is chosen by the {@link NodeSelection}.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.subtree-mutation")
public class SubtreeMutation extends AbstractModelMutation {
    @Inject
    private AttributeHelper helper;

    /**
     * Chooses the node.
     */
    private NodeSelection selection = NodeSelection.UNIFORM;

    /**
     * Builds the new subtrees.
     */
    private SubtreeFactory subtrees;

    public SubtreeMutation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     * @param selection Chooses the node.
     * @param settings The method of the new subtrees.
     */
    public SubtreeMutation(final double probability, final NodeSelection selection, final BuildSettings settings) {
        super(probability);
        this.selection = selection;
        this.subtrees = new SubtreeFactory(settings);
    }

    @Override
    public void check(final Chromosome chromosome) throws InitializationException {
        super.check(chromosome);
        subtrees.check(((ModelChromosome) chromosome).context(), name());
    }

    @Override
    protected void configureModel(final EObject configuration, final AttributeEvaluator attributes) {
        selection = new NodeSelection(optionalReal(configuration, "internal-node-probability", attributes));
        subtrees = new SubtreeFactory(helper.<EObject>lookup(configuration, "method"));
    }

    @Override
    protected void mutateModel(final ModelGenes models, final int model, final RandomGenerator random) {
        final EObject root = models.root(model);
        final EObject node = selection.choose(ModelTrees.objects(root), random);
        final boolean isRoot = node == root;

        final EClass place = isRoot ? models.context().rootTypes().get(model) : ModelTrees.typeOfPlace(node);
        final int depth = ModelTrees.depthOf(node, root);
        final long rest = ModelTrees.size(root) - ModelTrees.size(node);
        final EObject subtree = subtrees.build(models.context(), place, depth, rest, random);

        if(isRoot) {
            models.setRoot(model, subtree);
        } else {
            ModelTrees.replace(node, subtree);
        }
    }

    @Override
    public String name() {
        return "subtree-mutation";
    }

    @Override
    public String toString() {
        return name() + "(probability " + probability() + ", " + selection + ")";
    }
}

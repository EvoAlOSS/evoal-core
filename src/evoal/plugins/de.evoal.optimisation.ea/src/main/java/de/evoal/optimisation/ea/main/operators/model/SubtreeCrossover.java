package de.evoal.optimisation.ea.main.operators.model;

import java.util.List;
import java.util.OptionalDouble;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.ModelTrees;
import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.operators.AbstractRecombination;
import de.evoal.optimisation.ea.api.operators.NodeSelection;

/**
 * Subtree crossover (DL type {@code 'subtree-crossover'}): the two children exchange a subtree
 *   of every model (Poli, Langdon and McPhee 2008, sec. 2.4, in the variant with two offspring),
 *   restricted to fitting types as in strongly typed genetic programming (Montana 1995, sec.
 *   2.1, where the second subtree returns the same type as the first). Models have subtypes, so
 *   the rule here is symmetric: a node a of the first child is drawn among the nodes that have a
 *   partner in the second child (Montana draws it among all nodes and returns the parents
 *   without partner), then its partner b among those; b fits the place of a and a the place of
 *   b (the class is a subtype of the type of the containment). The roots
 *   are not exchanged, which would only swap the children. The subtrees take the positions of
 *   each other, so every element count stays. If no pair fits, the model stays unchanged. Both
 *   nodes are chosen by the {@link NodeSelection}.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.subtree-crossover")
public class SubtreeCrossover extends AbstractRecombination {
    /**
     * Chooses the nodes.
     */
    private NodeSelection selection = NodeSelection.UNIFORM;

    public SubtreeCrossover() {
    }

    /**
     * @param probability The probability that the recombination is applied to a pair.
     * @param selection Chooses the nodes.
     */
    public SubtreeCrossover(final double probability, final NodeSelection selection) {
        super(probability);
        this.selection = selection;
    }

    @Override
    public void check(final Chromosome chromosome) throws InitializationException {
        if(!(chromosome instanceof ModelChromosome)) {
            throw new InitializationException("The '" + name() + "' exchanges subtrees of models, but " + chromosome + " has none.");
        }
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature("internal-node-probability");
        if(feature != null && configuration.eIsSet(feature)) {
            selection = new NodeSelection(OptionalDouble.of(attributes.attributeToDouble(configuration, "internal-node-probability")));
        }
    }

    /**
     * @return Whether each node fits the place of the other.
     */
    private static boolean fit(final EObject a, final EObject b) {
        return ModelTrees.typeOfPlace(a).isSuperTypeOf(b.eClass()) && ModelTrees.typeOfPlace(b).isSuperTypeOf(a.eClass());
    }

    @Override
    public String name() {
        return "subtree-crossover";
    }

    /**
     * @return The nodes of the model without its root, in pre-order.
     */
    private static List<EObject> nodesBelowRoot(final EObject root) {
        final List<EObject> nodes = ModelTrees.objects(root);

        return nodes.subList(1, nodes.size());
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        final ModelGenes a = (ModelGenes) first;
        final ModelGenes b = (ModelGenes) second;
        first.requireCompatible(second);

        for(int model = 0; model < a.size(); ++model) {
            final List<EObject> nodesOfB = nodesBelowRoot(b.root(model));
            final List<EObject> candidates = nodesBelowRoot(a.root(model)).stream()
                                                                          .filter(node -> nodesOfB.stream().anyMatch(other -> fit(node, other)))
                                                                          .toList();
            if(candidates.isEmpty()) {
                continue;
            }

            final EObject nodeOfA = selection.choose(candidates, random);
            final List<EObject> partners = nodesOfB.stream()
                                                   .filter(other -> fit(nodeOfA, other))
                                                   .toList();
            final EObject nodeOfB = selection.choose(partners, random);

            final EObject copyOfA = EcoreUtil.copy(nodeOfA);
            final EObject copyOfB = EcoreUtil.copy(nodeOfB);
            ModelTrees.replace(nodeOfA, copyOfB);
            ModelTrees.replace(nodeOfB, copyOfA);
        }
    }

    @Override
    public String toString() {
        return name() + "(probability " + probability() + ", " + selection + ")";
    }
}

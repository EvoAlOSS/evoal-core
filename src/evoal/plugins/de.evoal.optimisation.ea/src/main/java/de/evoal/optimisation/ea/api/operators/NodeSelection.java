package de.evoal.optimisation.ea.api.operators;

import java.util.List;
import java.util.OptionalDouble;
import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EObject;

import de.evoal.optimisation.api.builder.ModelTrees;

/**
 * Chooses a node (an object) of a model for a structural operator: uniformly, or with the
 *   {@code 'internal-node-probability'} p an inner node (an object that contains objects) and
 *   with 1 - p a leaf, each uniformly. Koza (1992) chose inner nodes 90% of the time, since
 *   uniform choice mostly picks leaves (Poli, Langdon and McPhee 2008, sec. 2.4). If the
 *   candidates have no node of the drawn kind, a node of the other kind is chosen.
 *
 * @param internalNodeProbability The probability of an inner node; empty for uniform choice.
 */
public record NodeSelection(OptionalDouble internalNodeProbability) {
    /**
     * Uniform choice.
     */
    public static final NodeSelection UNIFORM = new NodeSelection(OptionalDouble.empty());

    /**
     * @param candidates The nodes to choose from, not empty.
     * @param random The random numbers of the operator.
     * @return The chosen node.
     */
    public EObject choose(final List<EObject> candidates, final RandomGenerator random) {
        if(internalNodeProbability.isEmpty()) {
            return candidates.get(random.nextInt(candidates.size()));
        }

        final boolean wantsInner = random.nextDouble() < internalNodeProbability.getAsDouble();
        final List<EObject> inner = candidates.stream().filter(ModelTrees::isInner).toList();
        final List<EObject> leaves = candidates.stream().filter(node -> !ModelTrees.isInner(node)).toList();

        final List<EObject> chosenKind;
        if(wantsInner) {
            chosenKind = inner.isEmpty() ? leaves : inner;
        } else {
            chosenKind = leaves.isEmpty() ? inner : leaves;
        }

        return chosenKind.get(random.nextInt(chosenKind.size()));
    }

    @Override
    public String toString() {
        return internalNodeProbability.isEmpty() ? "uniform" : "internal-node-probability " + internalNodeProbability.getAsDouble();
    }
}

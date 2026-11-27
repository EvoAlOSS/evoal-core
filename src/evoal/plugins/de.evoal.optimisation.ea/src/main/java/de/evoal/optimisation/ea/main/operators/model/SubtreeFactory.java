package de.evoal.optimisation.ea.main.operators.model;

import java.util.List;
import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.TreeMethod.Plan;
import de.evoal.optimisation.api.models.ModelCandidates;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;

/**
 * Builds the new subtrees of the structural mutations with the configured {@code method}: the
 *   depth limit of the method counts from the root of the model, as for the random population,
 *   and its {@code 'maximum-size'} limits the whole model, so a new subtree may use what the
 *   rest of the model leaves. The plans of the method are used in turn, one per subtree
 *   (ramped half-and-half alternates full and grow over its depth limits).
 */
final class SubtreeFactory {
    /**
     * The number of subtrees built so far; it selects the plan of the method.
     */
    private int built;

    /**
     * The method, the size limit and the optional probability.
     */
    private final BuildSettings settings;

    /**
     * @param method The configuration of the {@code 'tree-method'}.
     */
    SubtreeFactory(final EObject method) {
        this(ModelCandidates.settingsOf(method));
    }

    /**
     * @param settings The method, the size limit and the optional probability.
     */
    SubtreeFactory(final BuildSettings settings) {
        this.settings = settings;
    }

    /**
     * @param context The context of the models.
     * @param type The type of the place of the subtree.
     * @param depth The depth of the root of the subtree in its model.
     * @param restSize The number of objects of the model without the subtree.
     * @param random The random numbers of the mutation.
     * @return The new subtree.
     */
    EObject build(final ModelGenes.Context context, final EClass type, final int depth, final long restSize,
                  final RandomGenerator random) {
        final Plan plan = settings.method().planFor(built++);
        final long free = settings.maximumSize() - restSize;
        final long sizeLimit = Math.max(context.types().minimumSizeOfType(type), free);
        final ModelBuilder builder = new ModelBuilder(context.types(), context.values(), settings, random);

        return builder.build(type, depth, plan, sizeLimit);
    }

    /**
     * @throws InitializationException if the method cannot build the models of the context.
     */
    void check(final ModelGenes.Context context, final String owner) throws InitializationException {
        final List<String> problems = ModelCandidates.problemsOfSettings(settings, context.types(), context.rootTypes());
        if(!problems.isEmpty()) {
            throw new InitializationException("The 'method' of the '" + owner + "' cannot build the models: "
                                              + String.join("; ", problems) + ".");
        }
    }
}

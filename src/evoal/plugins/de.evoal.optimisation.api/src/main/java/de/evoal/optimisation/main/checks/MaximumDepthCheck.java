package de.evoal.optimisation.main.checks;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.LimitRepairs;
import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.ModelTrees;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.models.ModelCandidates;

/**
 * Fails a new candidate with a model whose depth exceeds the limit (DL type
 *   {@code 'maximum-depth'}); the depth of a model is the depth of its deepest object (the root has depth 0). The reaction {@code repair}
 *   uses {@link LimitRepairs#repairDepth}.
 */
@Dependent
@Named("de.evoal.optimisation.core.maximum-depth")
public class MaximumDepthCheck extends ModelLimitCheck {
    /**
     * Creates a check that is configured by {@link #init(EObject)}.
     */
    public MaximumDepthCheck() {
    }

    /**
     * Creates a configured check, e.g., for tests.
     *
     * @param reaction The reaction to a failed candidate.
     * @param maximumAttempts The maximum number of attempts of {@code resample} or {@code repair}.
     * @param limit The largest allowed depth.
     * @param fallback The reaction if the repair fails.
     * @param models The models of the search space.
     * @param randomService The source of the random numbers of the repair.
     * @throws InitializationException if the configuration cannot be used.
     */
    public MaximumDepthCheck(final CheckReaction reaction, final int maximumAttempts, final long limit, final CheckReaction fallback,
                             final ModelCandidates models, final RandomService randomService) throws InitializationException {
        super(reaction, maximumAttempts, limit, fallback, models, randomService);
    }

    @Override
    String describe(final long measure) {
        return "depth " + measure;
    }

    @Override
    String limitAttribute() {
        return "depth";
    }

    @Override
    long measure(final EObject root) {
        return ModelTrees.height(root);
    }

    @Override
    public String name() {
        return "maximum-depth";
    }

    @Override
    boolean repairModel(final EObject root, final long limit, final ModelTypes types, final ModelBuilder minimal) {
        return LimitRepairs.repairDepth(root, (int) limit, types, minimal);
    }
}

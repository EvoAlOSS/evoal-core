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
 * Fails a new candidate with a model whose size exceeds the limit (DL type
 *   {@code 'maximum-size'}); the size of a model is the number of its objects. The reaction {@code repair}
 *   uses {@link LimitRepairs#repairSize}.
 */
@Dependent
@Named("de.evoal.optimisation.core.maximum-size")
public class MaximumSizeCheck extends ModelLimitCheck {
    /**
     * Creates a check that is configured by {@link #init(EObject)}.
     */
    public MaximumSizeCheck() {
    }

    /**
     * Creates a configured check, e.g., for tests.
     *
     * @param reaction The reaction to a failed candidate.
     * @param maximumAttempts The maximum number of attempts of {@code resample} or {@code repair}.
     * @param limit The largest allowed size.
     * @param fallback The reaction if the repair fails.
     * @param models The models of the search space.
     * @param randomService The source of the random numbers of the repair.
     * @throws InitializationException if the configuration cannot be used.
     */
    public MaximumSizeCheck(final CheckReaction reaction, final int maximumAttempts, final long limit, final CheckReaction fallback,
                            final ModelCandidates models, final RandomService randomService) throws InitializationException {
        super(reaction, maximumAttempts, limit, fallback, models, randomService);
    }

    @Override
    String describe(final long measure) {
        return measure + " objects";
    }

    @Override
    String limitAttribute() {
        return "size";
    }

    @Override
    long measure(final EObject root) {
        return ModelTrees.size(root);
    }

    @Override
    public String name() {
        return "maximum-size";
    }

    @Override
    boolean repairModel(final EObject root, final long limit, final ModelTypes types, final ModelBuilder minimal) {
        return LimitRepairs.repairSize(root, limit, types, minimal);
    }
}

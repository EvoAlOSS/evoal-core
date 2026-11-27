package de.evoal.optimisation.main.checks;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.random.RandomGenerator;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.checks.AbstractCandidateCheck;
import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.checks.Repair;
import de.evoal.optimisation.api.models.ModelCandidates;
import de.evoal.optimisation.api.run.Candidate;

/**
 * Base class of the checks that limit the models of the candidates ({@code 'maximum-size'},
 *   {@code 'maximum-depth'}): every model of a new candidate is measured and compared with the
 *   limit. The reaction {@code repair} uses the minimal-subtree repair of
 *   {@link de.evoal.optimisation.api.builder.LimitRepairs}; the attribute values of the new
 *   objects are drawn from the named stream of the check.
 */
abstract class ModelLimitCheck extends AbstractCandidateCheck {
    /**
     * The name of the repair strategy, recorded in the memory model.
     */
    static final String REPAIR_NAME = "minimal-subtree-repair";

    @Inject
    private AttributeHelper helper;

    /**
     * The limit.
     */
    private long limit;

    /**
     * The models of the search space and their tables.
     */
    @Inject
    private ModelCandidates models;

    /**
     * The features that hold the models.
     */
    private List<EReference> modelFeatures;

    @Inject
    private RandomService randomService;

    /**
     * The repair with its fallback, {@code null} for the other reactions.
     */
    private Repair repair;

    /**
     * Creates a check that is configured by {@link #init(EObject)}.
     */
    ModelLimitCheck() {
    }

    /**
     * Creates a configured check, e.g., for tests.
     *
     * @param reaction The reaction to a failed candidate.
     * @param maximumAttempts The maximum number of attempts of {@code resample} or {@code repair}.
     * @param limit The limit.
     * @param fallback The reaction if the repair fails.
     * @param models The models of the search space.
     * @param randomService The source of the random numbers of the repair.
     * @throws InitializationException if the configuration cannot be used.
     */
    ModelLimitCheck(final CheckReaction reaction, final int maximumAttempts, final long limit, final CheckReaction fallback,
                    final ModelCandidates models, final RandomService randomService) throws InitializationException {
        super(reaction, maximumAttempts);
        this.models = models;
        this.randomService = randomService;
        setUp(limit, fallback);
    }

    @Override
    public final CheckPoint checkPoint() {
        return CheckPoint.NEW_CANDIDATES;
    }

    @Override
    protected final void configure(final EObject configuration) throws InitializationException {
        final Integer configured = helper.lookup(configuration, limitAttribute());
        final EEnumLiteral fallback = helper.lookup(configuration, "repair-fallback");

        setUp(configured, CheckReaction.of(fallback));
    }

    /**
     * @return The name of the attribute with the limit, e.g. {@code size}.
     */
    abstract String limitAttribute();

    /**
     * @return The measure of the model that is limited, e.g. its size.
     */
    abstract long measure(EObject root);

    /**
     * Repairs a model that exceeds the limit, in place.
     *
     * @return Whether the model fits the limit afterwards.
     */
    abstract boolean repairModel(EObject root, long limit, ModelTypes types, ModelBuilder minimal);

    /**
     * @return The description of a measure for reports, e.g. "25 objects".
     */
    abstract String describe(long measure);

    @Override
    public Optional<Repair> repair() {
        return Optional.ofNullable(repair);
    }

    private void setUp(final long configuredLimit, final CheckReaction fallback) throws InitializationException {
        modelFeatures = models.modelFeatures();
        if(modelFeatures.isEmpty()) {
            throw new InitializationException("The '" + name() + "' limits models, but the search space has no structured data.");
        }
        if(fallback == CheckReaction.REPAIR) {
            throw new InitializationException("The 'repair-fallback' of the '" + name() + "' cannot be 'repair'.");
        }

        limit = configuredLimit;
        if(reaction() == CheckReaction.REPAIR) {
            repair = new Repair(REPAIR_NAME, this::repairCandidate, fallback);
        }
    }

    /**
     * @return A copy of the candidate whose models are repaired as far as possible.
     */
    private TypedEObject repairCandidate(final TypedEObject input) {
        final TypedEObject copy = new TypedEObject(input);
        final ModelTypes types = models.types();
        final RandomGenerator randomness = randomService.random("de.evoal.optimisation.core." + name() + "/repair");
        final ModelBuilder minimal = ModelBuilder.minimal(types, models.values(), randomness);

        for(final EReference feature : modelFeatures) {
            final EObject root = (EObject) copy.eGet(feature);
            if(root != null && measure(root) > limit) {
                repairModel(root, limit, types, minimal);
            }
        }

        return copy;
    }

    @Override
    public final Set<CheckReaction> supportedReactions() {
        return EnumSet.allOf(CheckReaction.class);
    }

    @Override
    public final Optional<String> test(final Candidate candidate) {
        for(final EReference feature : modelFeatures) {
            final EObject root = (EObject) candidate.input().eGet(feature);
            if(root == null) {
                continue;
            }

            final long measure = measure(root);
            if(measure > limit) {
                return Optional.of("the model '" + feature.getName() + "' has " + describe(measure) + ", the limit is " + limit);
            }
        }

        return Optional.empty();
    }
}

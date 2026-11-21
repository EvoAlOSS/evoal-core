package de.evoal.optimisation.api.checks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.core.utils.FQNProvider;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.PropertyValueType;

import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;

/**
 * Creates the {@code 'candidate-checks'} of an algorithm configuration:
 * <ul>
 *   <li>rejects a check whose reaction the check type does not support, or whose check
 *     point the algorithm does not offer, {@code repair} without a repair strategy, and
 *     {@code resample} (also as the fallback of a repair) for population checks or
 *     algorithms that cannot redo their variation;</li>
 *   <li>creates the replacement source of every replacing check from its
 *     {@code 'replacement-source'}. A source of given candidates
 *     ({@code 'specify-candidates'}, {@code 'candidates-from-file'}) repeats its candidates,
 *     which is reported as a warning;</li>
 *   <li>defines the property {@link #REASON} of replacements in the
 *     {@link ExecutionRecorder}: on relationships for population checks, on individuals for
 *     checks of new candidates and for population checks (a replaced member that is new in
 *     the iteration is not recorded), the property {@link #ATTEMPTS} of resampled and
 *     repaired candidates and the property {@link #REPAIR} of repaired candidates, both in
 *     both scopes.</li>
 * </ul>
 */
@ApplicationScoped
@Slf4j
public class CandidateCheckProducer {
    /**
     * The name of the property that states why a candidate was replaced.
     */
    public static final String REASON = "reason";

    /**
     * The name of the property with the number of variations of a resampled candidate.
     */
    public static final String ATTEMPTS = "attempts";

    /**
     * The name of the property with the repair strategy of a repaired candidate.
     */
    public static final String REPAIR = "repair";

    /**
     * The DL types of the initial population sources that repeat their candidates.
     */
    private static final Set<String> GIVEN_CANDIDATES = Set.of("de.evoal.optimisation.core.specify-candidates",
                                                               "de.evoal.optimisation.core.candidates-from-file");

    private static final FQNProvider NAMES = new FQNProvider();

    @Inject
    private AttributeHelper helper;

    @Inject
    private ExecutionRecorder recorder;

    /**
     * @param algorithm The configuration of the algorithm.
     * @param offered The check points the algorithm offers.
     * @param resampling Whether the algorithm can redo the variation of a new candidate.
     * @return The configured checks, in the configured order.
     * @throws InitializationException if a check cannot be used with the algorithm.
     */
    public List<ConfiguredCheck> create(final EObject algorithm, final Set<CheckPoint> offered, final boolean resampling)
            throws InitializationException {
        final List<Configuration> configurations = helper.lookup(algorithm, "candidate-checks");
        if(configurations == null || configurations.isEmpty()) {
            return List.of();
        }

        final List<CandidateCheck> checks = configurations.stream()
                                                          .map(configuration -> BeanFactory.createComponent(CandidateCheck.class, configuration))
                                                          .toList();
        validate(checks, offered, resampling, NAMES.get(algorithm));
        defineProperties(checks);

        final List<ConfiguredCheck> configured = new ArrayList<>();
        for(final CandidateCheck check : checks) {
            if(!check.reactsWith(CheckReaction.REPLACE)) {
                configured.add(ConfiguredCheck.withoutSource(check));
                continue;
            }

            final EObject source = check.replacementSource();
            final String type = NAMES.get(source);
            if(GIVEN_CANDIDATES.contains(type)) {
                log.warn("The replacements of the check '{}' come from '{}' and repeat the given candidates.",
                         check.name(), type.substring(type.lastIndexOf('.') + 1));
            }

            final InitialCandidatesProvider provider = BeanFactory.createComponent(InitialCandidatesProvider.class, source);
            configured.add(new ConfiguredCheck(check, () -> new ReplacementSource(provider)));
        }

        return List.copyOf(configured);
    }

    /**
     * Defines the property {@link #REASON} for the check points of the replacing checks.
     */
    private void defineProperties(final List<CandidateCheck> checks) {
        final Set<CheckPoint> replacing = checks.stream()
                                                .filter(check -> check.reactsWith(CheckReaction.REPLACE))
                                                .map(CandidateCheck::checkPoint)
                                                .collect(Collectors.toSet());

        if(replacing.contains(CheckPoint.POPULATION)) {
            recorder.defineProperty(REASON, PropertyScope.RELATIONSHIP, PropertyValueType.TEXT, false,
                                    "Why the target of a replacement failed a candidate check.");
        }

        final boolean resampling = checks.stream().anyMatch(check -> check.reactsWith(CheckReaction.RESAMPLE));
        final boolean repairing = checks.stream().anyMatch(check -> check.reaction() == CheckReaction.REPAIR);
        if(resampling || repairing) {
            recorder.defineProperty(ATTEMPTS, PropertyScope.RELATIONSHIP, PropertyValueType.INTEGER, false,
                                    "The number of variations of a candidate that a candidate check resampled, or the "
                                    + "number of attempts of the repair of a repaired candidate.");
            recorder.defineProperty(ATTEMPTS, PropertyScope.INDIVIDUAL, PropertyValueType.INTEGER, false,
                                    "Like the property of the relationship, for a candidate without predecessor.");
        }

        if(repairing) {
            recorder.defineProperty(REPAIR, PropertyScope.RELATIONSHIP, PropertyValueType.TEXT, false,
                                    "The repair strategy that repaired the candidate after a failed candidate check.");
            recorder.defineProperty(REPAIR, PropertyScope.INDIVIDUAL, PropertyValueType.TEXT, false,
                                    "Like the property of the relationship, for a candidate without predecessor.");
        }

        if(!replacing.isEmpty()) {
            recorder.defineProperty(REASON, PropertyScope.INDIVIDUAL, PropertyValueType.TEXT, false,
                                    "Why the candidate this individual replaced failed a candidate check; set if the replaced candidate is not recorded.");
        }
    }

    /**
     * Checks that every check supports its reaction and that the algorithm offers its check
     *   point.
     *
     * @param checks The checks.
     * @param offered The check points the algorithm offers.
     * @param resampling Whether the algorithm can redo the variation of a new candidate.
     * @param algorithm The name of the algorithm, for the message.
     * @throws InitializationException if a check cannot be used with the algorithm.
     */
    public static void validate(final List<CandidateCheck> checks, final Set<CheckPoint> offered, final boolean resampling,
                                final String algorithm) throws InitializationException {
        for(final CandidateCheck check : checks) {
            if(!check.supportedReactions().contains(check.reaction())) {
                throw new InitializationException("The check '" + check.name() + "' does not support the reaction '"
                                                  + check.reaction() + "'; it supports " + check.supportedReactions() + ".");
            }

            if(check.reaction() == CheckReaction.REPAIR && check.repair().isEmpty()) {
                throw new InitializationException("The check '" + check.name() + "' has the reaction 'repair', but no "
                                                  + "repair strategy.");
            }

            final boolean resamples = check.reactsWith(CheckReaction.RESAMPLE);
            if(resamples && check.checkPoint() != CheckPoint.NEW_CANDIDATES) {
                throw new InitializationException("The check '" + check.name() + "' cannot resample: only checks of new "
                                                  + "candidates can redo their variation.");
            }
            if(resamples && !resampling) {
                throw new InitializationException("The algorithm '" + algorithm + "' cannot redo the variation of a candidate, "
                                                  + "so the check '" + check.name() + "' cannot resample.");
            }

            if(!offered.contains(check.checkPoint())) {
                throw new InitializationException("The algorithm '" + algorithm + "' does not offer the check point "
                                                  + check.checkPoint() + " of the check '" + check.name() + "'.");
            }
        }
    }
}

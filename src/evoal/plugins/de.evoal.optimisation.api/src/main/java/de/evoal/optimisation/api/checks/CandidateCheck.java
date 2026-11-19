package de.evoal.optimisation.api.checks;

import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.cdi.EvoalComponent;

import de.evoal.optimisation.api.run.Candidate;

/**
 * A test on candidates with a configured reaction to a failure (DL type
 *   {@code 'candidate-check'}). The check type defines where it tests the candidates
 *   ({@link #checkPoint()}) and which reactions it supports. The checks of an algorithm are
 *   created by the {@link CandidateCheckProducer}, which rejects unsupported reactions, check
 *   points the algorithm does not offer, and {@link CheckReaction#RESAMPLE} where the
 *   algorithm cannot redo the variation.
 */
public interface CandidateCheck extends EvoalComponent<CandidateCheck> {
    /**
     * @return Where the check tests the candidates.
     */
    CheckPoint checkPoint();

    /**
     * @return The maximum number of times the variation is redone for
     *   {@link CheckReaction#RESAMPLE}.
     */
    int maximumAttempts();

    /**
     * @return The name of the check for reports, e.g. {@code maximum-age}.
     */
    String name();

    /**
     * @return The configured reaction to a failed candidate.
     */
    CheckReaction reaction();

    /**
     * @return The configuration of the source of new candidates for {@link CheckReaction#REPLACE},
     *   empty if the {@code 'initialisation'} of the algorithm is used.
     */
    Optional<EObject> replacementSource();

    /**
     * @return The reactions the check supports.
     */
    Set<CheckReaction> supportedReactions();

    /**
     * Tests a candidate.
     *
     * @param candidate The candidate to test, evaluated or not.
     * @return Why the candidate failed, empty if it passed.
     */
    Optional<String> test(Candidate candidate);
}

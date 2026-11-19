package de.evoal.optimisation.main.checks;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;

import de.evoal.optimisation.api.checks.AbstractCandidateCheck;
import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.run.Candidate;

/**
 * Fails a member of the population that is older than the configured number of iterations
 *   (DL type {@code 'maximum-age'}). The age of a candidate is the number of iterations it
 *   was carried over into unchanged ({@link Candidate#age()}), so the maximum age itself is
 *   allowed.
 */
@Dependent
@Named("de.evoal.optimisation.core.maximum-age")
public class MaximumAgeCheck extends AbstractCandidateCheck {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The highest age a candidate may have.
     */
    private int iterations;

    /**
     * Creates a check that is configured by {@link #init(EObject)}.
     */
    public MaximumAgeCheck() {
    }

    /**
     * Creates a configured check, e.g., for tests.
     *
     * @param iterations The highest age a candidate may have.
     * @param reaction The reaction to a failed candidate.
     */
    public MaximumAgeCheck(final int iterations, final CheckReaction reaction) {
        super(reaction);
        this.iterations = iterations;
    }

    @Override
    public CheckPoint checkPoint() {
        return CheckPoint.POPULATION;
    }

    @Override
    protected void configure(final EObject configuration) {
        iterations = evaluator.attributeToInteger(configuration, "iterations");
    }

    @Override
    public String name() {
        return "maximum-age";
    }

    @Override
    public Set<CheckReaction> supportedReactions() {
        return EnumSet.of(CheckReaction.WARN, CheckReaction.REPLACE);
    }

    @Override
    public Optional<String> test(final Candidate candidate) {
        final int age = candidate.age();

        return age > iterations
                ? Optional.of("age " + age + " exceeds " + iterations + " iterations")
                : Optional.empty();
    }
}

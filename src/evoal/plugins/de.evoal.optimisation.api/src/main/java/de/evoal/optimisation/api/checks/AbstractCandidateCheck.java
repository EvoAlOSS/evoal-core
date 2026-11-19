package de.evoal.optimisation.api.checks;

import java.util.Optional;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Base class of the checks: reads the attributes of the base type {@code 'candidate-check'},
 *   the {@code reaction}, the optional {@code 'replacement-source'} and
 *   {@code 'maximum-attempts'}. Subclasses read
 *   their own attributes in {@link #configure(EObject)}.
 */
public abstract class AbstractCandidateCheck implements CandidateCheck {
    @Inject
    private AttributeHelper helper;

    /**
     * The maximum number of times the variation is redone for {@code resample}.
     */
    private int maximumAttempts = 10;

    /**
     * The configured reaction.
     */
    private CheckReaction reaction;

    /**
     * The configuration of the replacement source, {@code null} if not set.
     */
    private EObject replacementSource;

    /**
     * Creates a check that is configured by {@link #init(EObject)}.
     */
    protected AbstractCandidateCheck() {
    }

    /**
     * Creates a configured check, e.g., for tests.
     *
     * @param reaction The reaction to a failed candidate.
     */
    protected AbstractCandidateCheck(final CheckReaction reaction) {
        this.reaction = reaction;
    }

    /**
     * Creates a configured check, e.g., for tests.
     *
     * @param reaction The reaction to a failed candidate.
     * @param maximumAttempts The maximum number of times the variation is redone for
     *   {@code resample}.
     */
    protected AbstractCandidateCheck(final CheckReaction reaction, final int maximumAttempts) {
        this.reaction = reaction;
        this.maximumAttempts = maximumAttempts;
    }

    @Override
    public final CandidateCheck init(final EObject configuration) throws InitializationException {
        final EEnumLiteral literal = helper.lookup(configuration, "reaction");
        reaction = CheckReaction.of(literal);

        final EStructuralFeature source = configuration.eClass().getEStructuralFeature("replacement-source");
        if(source != null && configuration.eIsSet(source)) {
            replacementSource = (EObject) configuration.eGet(source);
        }

        maximumAttempts = helper.<Integer>lookup(configuration, "maximum-attempts");

        configure(configuration);

        return this;
    }

    /**
     * Reads the attributes of the check type.
     *
     * @param configuration The configuration of the check.
     * @throws InitializationException if the configuration cannot be used.
     */
    protected abstract void configure(EObject configuration) throws InitializationException;

    @Override
    public int maximumAttempts() {
        return maximumAttempts;
    }

    @Override
    public CheckReaction reaction() {
        return reaction;
    }

    @Override
    public Optional<EObject> replacementSource() {
        return Optional.ofNullable(replacementSource);
    }
}

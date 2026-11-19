package de.evoal.optimisation.api.checks;

import java.util.Iterator;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.model.InitialCandidatesProvider;

/**
 * The source of new candidates for the reaction {@link CheckReaction#REPLACE}. It takes the
 *   candidates one after the other from one stream of its provider, so replacements continue
 *   the stream and do not start it again.
 */
public final class ReplacementSource {
    /**
     * Provides the candidates.
     */
    private final InitialCandidatesProvider provider;

    /**
     * The candidates of the provider, created with the first replacement.
     */
    private Iterator<TypedEObject> candidates;

    /**
     * @param provider Provides the candidates.
     */
    public ReplacementSource(final InitialCandidatesProvider provider) {
        this.provider = provider;
    }

    /**
     * @return The next candidate of the provider.
     * @throws IllegalStateException if the provider has no further candidates.
     */
    public TypedEObject next() {
        if(candidates == null) {
            candidates = provider.create().iterator();
        }

        if(!candidates.hasNext()) {
            throw new IllegalStateException("The replacement source has no further candidates.");
        }

        return candidates.next();
    }
}

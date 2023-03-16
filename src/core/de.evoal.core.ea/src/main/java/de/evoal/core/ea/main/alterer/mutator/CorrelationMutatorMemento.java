package de.evoal.core.ea.main.alterer.mutator;


import de.evoal.core.ea.api.correlations.Correlation;

/**
 * Memento to preserve the state of correlation-aware mutator.
 * @param <CC>
 */
public interface CorrelationMutatorMemento<CC extends CorrelationMutatorMemento> {
    public void apply(final CC context, Correlation correlation);
}

package de.evoal.optimisation.ea.main.alterer.mutator;


import de.evoal.optimisation.api.correlations.Correlation;

/**
 * Memento to preserve the state of correlation-aware mutator.
 * @param <CC>
 */
public interface CorrelationMutatorMemento<CC extends CorrelationMutatorMemento> {
    void apply(final CC context, Correlation correlation);
}

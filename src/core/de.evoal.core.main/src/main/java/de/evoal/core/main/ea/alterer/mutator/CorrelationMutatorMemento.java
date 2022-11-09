package de.evoal.core.main.ea.alterer.mutator;


import de.evoal.core.main.ea.functions.correlation.model.Correlation;

/**
 * Memento to preserve the state of correlation-aware mutator.
 * @param <CC>
 */
public interface CorrelationMutatorMemento<CC extends CorrelationMutatorMemento> {
    public void apply(final CC context, Correlation correlation);
}

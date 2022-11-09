package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.main.ea.functions.correlation.model.Correlation;

public interface CorrelationCrossoverMemento<T extends CorrelationCrossoverMemento<T>> {

    /**
     * Applies the given memento with according to the correlation to this memento.
     */
    public T apply(final T memento, final Correlation correlation);
}

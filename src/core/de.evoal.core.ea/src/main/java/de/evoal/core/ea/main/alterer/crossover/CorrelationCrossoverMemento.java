package de.evoal.core.ea.main.alterer.crossover;

import de.evoal.core.api.correlations.Correlation;

public interface CorrelationCrossoverMemento<T extends CorrelationCrossoverMemento<T>> {

    /**
     * Applies the given memento with according to the correlation to this memento.
     */
    T apply(final T memento, final Correlation correlation);
}

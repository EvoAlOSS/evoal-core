package de.evoal.optimisation.ea.main.alterer.crossover;

import de.evoal.optimisation.api.correlations.Correlation;

public interface CorrelationCrossoverMemento<T extends CorrelationCrossoverMemento<T>> {

    /**
     * Applies the given memento with according to the correlation to this memento.
     */
    T apply(final T memento, final Correlation correlation);
}

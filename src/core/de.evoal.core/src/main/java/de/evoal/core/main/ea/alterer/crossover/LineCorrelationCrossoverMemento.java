package de.evoal.core.main.ea.alterer.crossover;

import de.evoal.core.main.ea.model.Correlation;
import io.jenetics.util.RandomRegistry;
import lombok.Data;

import java.util.random.RandomGenerator;

@Data
public class LineCorrelationCrossoverMemento implements CorrelationCrossoverMemento<LineCorrelationCrossoverMemento> {
    private double a;
    private double b;

    public LineCorrelationCrossoverMemento(final double probability) {
        final RandomGenerator random = RandomRegistry.random();
        random.nextDouble(-probability, 1 + probability);
        random.nextDouble(-probability, 1 + probability);
    }

    @Override
    public LineCorrelationCrossoverMemento apply(LineCorrelationCrossoverMemento memento, Correlation correlation) {
        return this;
    }
}
